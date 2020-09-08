package com.benmohammad.reelzapp.ui.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.benmohammad.reelzapp.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class InfoActivity: AppCompatActivity() {

    lateinit var adView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        adView = findViewById<View>(R.id.advertBanner) as AdView
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                finish()
                true
            }
            else -> false
        }
    }
}