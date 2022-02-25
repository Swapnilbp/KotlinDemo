package com.bpointer.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bpointer.kotlindemo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener { openPage(1) }
        binding.button2.setOnClickListener { openPage(2) }
    }

    private fun openPage(i: Int) {
        when (i) {
            1 -> startActivity(Intent(this, MainActivity::class.java))
            2 -> startActivity(Intent(this, MainActivity2::class.java))
            else -> startActivity(Intent(this@HomeActivity, HomeActivity::class.java))
        }
    }
}