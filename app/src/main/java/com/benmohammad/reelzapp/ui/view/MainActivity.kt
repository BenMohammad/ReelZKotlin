package com.benmohammad.reelzapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.benmohammad.reelzapp.R
import com.benmohammad.reelzapp.data.api.ApiHelperImpl
import com.benmohammad.reelzapp.data.api.RetrofitBuilder
import com.benmohammad.reelzapp.ui.adapter.MainAdapter
import com.benmohammad.reelzapp.ui.viewmodel.MainViewModel
import com.benmohammad.reelzapp.util.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private var adapter = MainAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpClicks();
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.editor_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.delete -> {
                deleteInput()
                true
            }
            R.id.snippets -> {
                openSnippets()
                true
            }
            R.id.runcode -> {
                runCode();
                true
            }
            else -> false
        }
    }

    private fun deleteInput() {}

    private fun openSnippets() {
        val intent = Intent(this, SnippetsActivity::class.java)
        startActivity(intent)
    }

    private fun runCode() {}

    private fun setUpClicks(){}

    private fun setUpViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(
                    RetrofitBuilder.apiService
                )
            )
        ).get(MainViewModel::class.java )
    }
}