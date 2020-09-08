package com.benmohammad.reelzapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.benmohammad.reelzapp.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity: AppCompatActivity() {

    var fadeIn: Animation? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        fadeIn = AnimationUtils.loadAnimation(this, R.anim.faded_start)
        logo.startAnimation(fadeIn)

        val timerThread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(1200)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                    overridePendingTransition(
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right
                    )
                }
            }
        }
        timerThread.start()
    }
}