package com.benmohammad.reelzapp.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.benmohammad.reelzapp.R
import com.benmohammad.reelzapp.adapter.Comm
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class SnippetsActivity: AppCompatActivity(), Comm {

    lateinit var adView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snippets_lact)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        adView = findViewById<View>(R.id.advertBanner) as AdView
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.snippets_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.info -> {
                startActivity(Intent(SnippetsActivity@this, InfoActivity::class.java))
                finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> false
        }
    }

    override fun sendCodeToEditor(code: String) {
        val intent = Intent()
        intent.putExtra("snippet", code)
        setResult(Activity.RESULT_OK, intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(SnippetsActivity@this, MainActivity::class.java))
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}