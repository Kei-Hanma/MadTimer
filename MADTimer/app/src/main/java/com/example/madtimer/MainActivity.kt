package com.example.madtimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.madtimer.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import android.media.RingtoneManager
import android.media.Ringtone
import android.net.Uri


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var countDownTimer: CountDownTimer? = null
    private val isCounterRunning: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //start timer
        binding.soft.setOnClickListener{
            visibles1()
            Snackbar.make(
                findViewById(R.id.myCoordinatorLayout),
                "Egg boiling started!!",
                Snackbar.LENGTH_SHORT
            ).show()
            soft_timer()
        }
        binding.medium.setOnClickListener{
            visibles1()
            Snackbar.make(
                findViewById(R.id.myCoordinatorLayout),
                "Egg boiling started!!",
                Snackbar.LENGTH_SHORT
            ).show()
            medium_timer()
        }
        binding.hard.setOnClickListener{
            visibles1()
            Snackbar.make(
                findViewById(R.id.myCoordinatorLayout),
                "Egg boiling started!!",
                Snackbar.LENGTH_SHORT
            ).show()
            hard_timer()
        }
    }

    private fun visibles1(){
        binding.soft.visibility = View.INVISIBLE
        binding.medium.visibility = View.INVISIBLE
        binding.hard.visibility = View.INVISIBLE
        binding.stop.visibility = View.VISIBLE
        binding.start.visibility = View.VISIBLE
    }
    private fun visibles2(){
        binding.soft.visibility = View.VISIBLE
        binding.medium.visibility = View.VISIBLE
        binding.hard.visibility = View.VISIBLE
        binding.stop.visibility = View.INVISIBLE
        binding.start.visibility = View.INVISIBLE
    }

    private fun soft_timer() {
        countDownTimer = object : CountDownTimer(241000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val milliseconds: Long = millisUntilFinished
                val minutes = milliseconds / 1000 / 60
                val seconds = milliseconds / 1000 % 60
                binding.stop.setOnClickListener{countDownTimer?.cancel()}
                binding.start.setOnClickListener{countDownTimer?.start()}
                binding.time.setText("$minutes : $seconds")
            }

            override fun onFinish() {
                Snackbar.make(
                    findViewById(R.id.myCoordinatorLayout),
                    "Egg Soft Boiled!!",
                    Snackbar.LENGTH_SHORT
                ).show()
                visibles2()
                binding.timer.setImageResource(R.drawable.soft)
                val notification: Uri =
                    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val r = RingtoneManager.getRingtone(applicationContext, notification)
                r.play()
            }

        }
        countDownTimer?.start()
    }

    private fun medium_timer() {
        countDownTimer = object : CountDownTimer(361000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val milliseconds: Long = millisUntilFinished
                val minutes = milliseconds / 1000 / 60
                val seconds = milliseconds / 1000 % 60
                binding.stop.setOnClickListener{countDownTimer?.cancel()}
                binding.start.setOnClickListener{countDownTimer?.start()}
                binding.time.setText("$minutes : $seconds")
            }

            override fun onFinish() {
                Snackbar.make(
                    findViewById(R.id.myCoordinatorLayout),
                    "Egg Medium Boiled!!",
                    Snackbar.LENGTH_SHORT
                ).show()
                visibles2()
                binding.timer.setImageResource(R.drawable.medium)
                val notification: Uri =
                    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val r = RingtoneManager.getRingtone(applicationContext, notification)
                r.play()
            }

        }
        countDownTimer?.start()
    }

    private fun hard_timer() {
        countDownTimer = object : CountDownTimer(481000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val milliseconds: Long = millisUntilFinished
                val minutes = milliseconds / 1000 / 60
                val seconds = milliseconds / 1000 % 60
                binding.stop.setOnClickListener{countDownTimer?.cancel()}
                binding.start.setOnClickListener{countDownTimer?.start()}
                binding.time.setText("$minutes : $seconds")
            }

            override fun onFinish() {
                Snackbar.make(
                    findViewById(R.id.myCoordinatorLayout),
                    "Egg Hard Boiled!!",
                    Snackbar.LENGTH_SHORT
                ).show()
                visibles2()
                binding.timer.setImageResource(R.drawable.hard)
                val notification: Uri =
                    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val r = RingtoneManager.getRingtone(applicationContext, notification)
                r.play()
            }

        }
        countDownTimer?.start()
    }
}