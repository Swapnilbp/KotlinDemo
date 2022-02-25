package com.bpointer.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var count1Text: TextView
    private lateinit var dice1Image: ImageView
    private lateinit var rollButton: Button
    private lateinit var countUpButton: Button
    private lateinit var resetButton: Button
    private lateinit var count2Text: TextView
    private lateinit var dice2Image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollButton = findViewById(R.id.rollButton)
        countUpButton = findViewById(R.id.countUpButton)
        resetButton = findViewById(R.id.resetButton)
        count1Text = findViewById(R.id.count1Text)
        dice1Image = findViewById(R.id.dice1Image)
        count2Text = findViewById(R.id.count2Text)
        dice2Image = findViewById(R.id.dice2Image)

        rollButton.setOnClickListener { rollDice() }
        countUpButton.setOnClickListener { increaseCount() }
        resetButton.setOnClickListener { resetCount() }

        val tipButton:Button =findViewById(R.id.tipButton)
        tipButton.setOnClickListener { gotoNextPage() }
    }

    private fun gotoNextPage() {
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }

    private fun resetCount() {
        count1Text.text = "0"
        count2Text.text = "0"
        showImage()
    }

    private fun increaseCount() {
        if (count1Text.text == "Roll") {
            count1Text.text = "1"
        } else {
            var i = count1Text.text.toString().toInt()
            if (i < 6) {
                ++i
                count1Text.text = i.toString()
            }
        }
        if (count2Text.text == "Roll") {
            count2Text.text = "1"
        } else {
            var i = count2Text.text.toString().toInt()
            if (i < 6) {
                ++i
                count2Text.text = i.toString()
            }
        }
        showImage()
    }

    private fun rollDice() {
        val randomInt1 = (1..6).random()
        val randomInt2 = (1..6).random()
        count1Text.text = randomInt1.toString()
        count2Text.text = randomInt2.toString()
        showImage()
    }

    private fun showImage() {
        dice1Image.setImageResource(getImageDrawable(count1Text.text.toString().toInt()))
        dice2Image.setImageResource(getImageDrawable(count2Text.text.toString().toInt()))
    }

    private fun getImageDrawable(number: Int): Int {
        return when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }
}