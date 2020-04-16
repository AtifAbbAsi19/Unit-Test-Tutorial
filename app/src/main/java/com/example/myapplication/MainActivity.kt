package com.example.myapplication

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    lateinit var progressBar: ProgressBar
    lateinit var counterTimerLabel: AppCompatTextView

    val FOUR_SECONDS = 4000L

    var totalCount = 4

    var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressBar = findViewById(R.id.progressBar)

        counterTimerLabel = findViewById(R.id.counterTimerLabel)



        counterTimerLabel.text = String.format("%02d", 4)

        progressBar.progress = 100



         Handler().postDelayed({


             startProgressBar()


        },  1000)




        helloWorldBtn.setOnClickListener {
            navigateToNextActivity()
        }


    }

    private fun startProgressBar() {

        if (null != countDownTimer) {
            countDownTimer?.cancel()
        }


        ObjectAnimator.ofInt(progressBar, "progress", 100, 0).apply {
            duration = FOUR_SECONDS
            interpolator = DecelerateInterpolator()
        }.start()


        countDownTimer = object : CountDownTimer(FOUR_SECONDS, 1000) {

            override fun onTick(currentSeconds: Long) {

                val remaningTime = FOUR_SECONDS - currentSeconds

                totalCount -= 1

                counterTimerLabel.text = String.format("%02d", totalCount)

//                progressBar.progress = remaningTime.toInt() * 100 / (FOUR_SECONDS.toInt() / 1000)

            }

            override fun onFinish() {

                counterTimerLabel.text = String.format("%02d", 0)

                progressBar.progress = 0

            }
        }.start()



    }


    fun navigateToNextActivity() {
        startActivity(Intent(this, NextActivity::class.java))


    }
}
