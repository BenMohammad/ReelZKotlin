package com.benmohammad.reelzapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.benmohammad.reelzapp.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_info.*


class InfoActivity: AppCompatActivity() {

    lateinit var adView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        supportActionBar!!.title = ""

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        textInfo.setText("<Coded, Hacked, Built {or} Developed in %500 LINES of code" +
                "of code??,...:: is where!££! Real the Godz of this @world live\n\n\n" +
                "Hack, Search%, Post and Share your \\\"mind\\\" in Java, " +
                "Create++ functions variables and crunch your ~Data~ built\n" +
                " to the constraints of this* Editor;\n" +
                "\n" +
                "\n Code is Life Data Crunching Hobo be ReelZ\n\n\n" +
                "On your commute, in the cafe, in bed Now you can code anywhere\n\n\n"+
                "</>Hack in the palm-of-your-hand. \n\n"+
                "ReelZ The Mobile Java Editor on Android/>")

        MobileAds.initialize(this) {}
        var mAdView = findViewById<AdView>(R.id.advertBanner)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(InfoActivity@this, SnippetsActivity::class.java))
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}