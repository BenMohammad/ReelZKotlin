package com.benmohammad.reelzapp.activities

import android.app.Activity
import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.benmohammad.reelzapp.R
import com.benmohammad.reelzapp.data.api.ApiHandler
import com.benmohammad.reelzapp.data.api.ApiService
import com.benmohammad.reelzapp.data.model.PostData
import com.benmohammad.reelzapp.util.CustomTextWatcher
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_output.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class MainActivity: AppCompatActivity() {

    private val REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = ""
        codebox.addTextChangedListener(CustomTextWatcher(codebox))

        clearOutputBtn.setOnClickListener { v ->
            clearOutput(v)
        }

        shareWhatsAppBtn.setOnClickListener { v ->
            shareOnWhatsApp(v)
        }

        searchOutputGoogleBtn.setOnClickListener { v ->
            searchOutputOnGoogle(v)
        }
    }


    private fun clearOutput(v: View) {
        if (outputTV.text.toString().isNotEmpty()) {
            outputTV.text = ""
            val snackBar = Snackbar.make(v, "Cleared...", Snackbar.LENGTH_SHORT)
            snackBar.show()
        } else {
            val snackBar = Snackbar.make(v, "Output empty...", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }

    }

    private fun shareOnWhatsApp(v: View) {
        if (codebox.text!!.isNotEmpty() && outputTV.text!!.isNotEmpty()) {
            val whatsAppIntent = Intent(Intent.ACTION_SEND)
            whatsAppIntent.type = "text/plain"
            whatsAppIntent.setPackage("com.whatsapp")
            val concatString =
                String.format("---INPUT---\n" + "codebox.text.toString()" + "\n\n ---Output---\n\n" + outputTV.text.toString())
            if (concatString.length > 65535) {
                Snackbar.make(
                    v,
                    "WhatsApp Messages can only be 65, 536 Characters long...",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            whatsAppIntent.putExtra(Intent.EXTRA_TEXT, concatString)
            try {
                v.context.startActivity(whatsAppIntent)
            } catch (e: ActivityNotFoundException) {
                val snackBar = Snackbar.make(v, "Error sending message...", Snackbar.LENGTH_SHORT)
                snackBar.show()
                return
            }
        } else {
            if(codebox.text.toString().isEmpty()) {
                val snackBar = Snackbar.make(v, "Editor is empty", Snackbar.LENGTH_SHORT)
                snackBar.show()
            } else {
                val snackBar =
                    Snackbar.make(v, "Run the code to get an output...", Snackbar.LENGTH_SHORT)
                snackBar.show()
                return
            }
        }
    }


    private fun searchOutputOnGoogle(v: View) {
        if(outputTV.text.toString().isNotEmpty()) {
            if(outputTV.text.toString().contains("error") || outputTV.text.toString().contains("java")) {
                val intent = Intent(Intent.ACTION_WEB_SEARCH)
                val searchQuery = outputTV.text.toString()
                intent.putExtra(SearchManager.QUERY, searchQuery)
                v.context.startActivity(intent)
            } else {
                Snackbar.make(v, "Unable to search these terms, try manually", Snackbar.LENGTH_SHORT).show()
            }
        } else {
            val snackBar = Snackbar.make(v, "No output to search...Run some code", Snackbar.LENGTH_SHORT)
            snackBar.show()
            return
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.editor_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.runcode -> {
                    if(codebox.text!!.isNotEmpty()) {
                        runCode()
                    } else {
                        val snackbar = Snackbar.make(
                            codebox,
                            "Editor is empty, nothing to run...",
                            Snackbar.LENGTH_SHORT
                        )
                        snackbar.show()
                    }
                return true
            }
            R.id.delete -> {
                if(codebox.text!!.isNotEmpty()) {
                    codebox.text?.clear()
                } else {
                    val snackbar = Snackbar.make(codebox, "Editor is empty...", Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                return true }
            R.id.snippets -> {
               openSnippets()
                return true
            }


        else -> return false
        }

    }

    private fun runCode() {
        val apiService: ApiService = ApiHandler.getService();
        val execute: Call<String> =
            apiService.execute(
                PostData(codebox.text.toString(),
            ))

        codebox.visibility = View.INVISIBLE
        progress.visibility = View.VISIBLE
        execute?.enqueue(object : Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(outputTV.context, "Failure on server", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                try {
                    if(response.isSuccessful) {
                        val responseJson = JSONObject(response.body().toString())
                        val output = responseJson.getString("output")
                        codebox.visibility = View.VISIBLE
                        progress.visibility = View.GONE
                        outputTV.text = output
                    } else {
                        progress.visibility = View.GONE
                        codebox.visibility = View.VISIBLE
                        Toast.makeText(codebox.context, "Error", Toast.LENGTH_SHORT).show()
                    }
                } catch (je: JSONException) {
                    progress.visibility = View.GONE
                    codebox.visibility = View.VISIBLE
                    je.printStackTrace()
                } catch (e: Exception) {
                    progress.visibility = View.GONE
                    codebox.visibility = View.VISIBLE
                    e.printStackTrace()
                }
            }
        })

    }


    private fun openSnippets() {
        val intent = Intent(MainActivity@this, SnippetsActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE)
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("data is null:" , data.toString())
        if(resultCode == Activity.RESULT_OK && data != null) {
            if(requestCode == 1) {
                val snippet = data.getStringExtra("snippet")


                codebox.addTextChangedListener(CustomTextWatcher(codebox))
                val editable: Editable? = codebox.text
                val start: Int = codebox!!.selectionStart
                editable?.insert(start, snippet)
                codebox.setSelection(start)
            }}
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

    }

}