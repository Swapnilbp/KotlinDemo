package com.bpointer.kotlindemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bpointer.kotlindemo.databinding.ActivityMain2Binding
import com.skydoves.powerspinner.IconSpinnerAdapter
import com.skydoves.powerspinner.IconSpinnerItem
import java.text.NumberFormat

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    var taxPercent = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }

        val adapter = IconSpinnerAdapter(binding.spinnerView)
        adapter.setItems(
            arrayListOf(
                IconSpinnerItem("20"),
                IconSpinnerItem("18"),
                IconSpinnerItem("15")
            )
        )
        binding.spinnerView.setSpinnerAdapter(adapter)
        binding.spinnerView.setOnSpinnerItemSelectedListener<IconSpinnerItem> { oldIndex, oldItem, newIndex, newItem ->
            taxPercent = "0." + newItem.text
            Toast.makeText(applicationContext, newItem.text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateTip() {
        val stringCost = binding.costEdit.text.toString()
        val cost = stringCost.toDoubleOrNull()
        if (cost == null) {
            displayTip(0.0, 0.0)
            return
        }
        val tipPercent = when (binding.percentGroup.checkedRadioButtonId) {
            R.id.amazingRadio -> 0.20
            R.id.goodRadio -> 0.18
            else -> 0.15
        }

        var tip = tipPercent * cost
        var tax = taxPercent.toDouble() * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
            tax = kotlin.math.ceil(tax)
        }
        displayTip(tip, tax)
    }

    @SuppressLint("SetTextI18n")
    private fun displayTip(tip: Double, tax: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        val formattedTax = NumberFormat.getCurrencyInstance().format(tax)
        binding.tipText.text = "Tip Amount :$formattedTip\tTax Amount :$formattedTax"
    }
}