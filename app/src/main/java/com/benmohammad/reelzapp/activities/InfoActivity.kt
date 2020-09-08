package com.benmohammad.reelzapp.activities

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

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        adView = findViewById<View>(R.id.advertBanner) as AdView
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                finish()
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}