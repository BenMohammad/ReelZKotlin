package com.benmohammad.reelzapp.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.benmohammad.reelzapp.R
import com.benmohammad.reelzapp.util.CustomTextWatcher
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    val REQUEST_CODE = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        codebox.addTextChangedListener(CustomTextWatcher(codebox))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.editor_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.runcode -> {

                return true
            }
            R.id.delete -> {


                return true
            }
            R.id.snippets -> {
                startActivity(Intent(MainActivity@this, SnippetsActivity::class.java))
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                return true
            }
            else -> return false

        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && data != null) {
            if(resultCode == Activity.RESULT_OK) {
                val snippet = data.getStringExtra("snippet")
                codebox.addTextChangedListener(CustomTextWatcher(codebox))
                val editable: Editable? = codebox.text
                val start: Int = codebox!!.selectionStart
                editable?.insert(start, snippet)
                codebox.setSelection(start)
            }}
    }

}