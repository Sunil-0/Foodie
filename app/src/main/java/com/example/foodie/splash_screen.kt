package com.example.foodie

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import kotlinx.coroutines.delay

@Suppress("DEPRECATION")
class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var i = 0;
        var progressBarStatus = 0
        var proBar = findViewById<ProgressBar>(R.id.proBar)
        proBar.visibility = View.VISIBLE
        proBar.progress = i
        proBar.getProgressDrawable().setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN);

        Handler().postDelayed(Runnable {
            Thread(Runnable {
                while (proBar.progress < 100) {
                    i = i+10
                    proBar.progress = i
                    Thread.sleep(100)
                }
                Thread.sleep(500)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }).start()
        }, 3000)
    }
}