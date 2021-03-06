package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import java.util.*
import java.util.concurrent.TimeUnit

class SixtySeconds : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixty_seconds)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val goToMain = Intent(this,MainActivity::class.java)
        var textView = findViewById<TextView>(R.id.text_view)
        val duration = TimeUnit.MINUTES.toMillis(1)
        var uno = object : CountDownTimer(duration, 1000) {
            override fun onTick(timeLeft: Long) {
                var sDuration = String.format(
                    Locale.ENGLISH, "%02d : %02d",
                    TimeUnit.MILLISECONDS.toMinutes(timeLeft),
                    TimeUnit.MILLISECONDS.toSeconds(timeLeft) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeLeft)))
                textView.text = sDuration
            }

            override fun onFinish() {
                startActivity(goToMain)
                finish()
            }
        }

        val startTimerButton = findViewById<Button>(R.id.startTimerButton)
        startTimerButton.isVisible = true
        startTimerButton.setOnClickListener {
            uno.start()
            startTimerButton.isVisible = false
        }
    }

    override fun onBackPressed() {
        val goBackPlease = Intent(this,FinishedQuestion::class.java)
        startActivity(goBackPlease)
        finish()
    }
}