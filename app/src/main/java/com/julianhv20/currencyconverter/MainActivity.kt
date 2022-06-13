package com.julianhv20.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.julianhv20.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currencies = resources.getStringArray(R.array.currency_list)
        val adapter = ArrayAdapter(this, R.layout.list_item, currencies)

        with(binding.autoCompleteTextView) {
            setAdapter(adapter)
        }

        //Change the currency

        binding.btnConvert.setOnClickListener {
            convertCurrency()
        }


    }

    private fun convertCurrency() {

        //Check for empty fields
        if (binding.autoCompleteTextView.text.isEmpty() || binding.etNumber.text.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            //clear textview
            binding.autoCompleteTextView.text.clear()
            binding.tvResult.text = ""
        } else {
            //Get the values from the fields
            val amount = binding.etNumber.text.toString()

            val to = binding.autoCompleteTextView.text.toString()
            val result = currencyConverter(to, amount)

            binding.tvResult.text = result.toString()
        }


    }

    private fun currencyConverter(to: String, amount: String): Any {


        var result: Double = 0.0
        when (to) {

            "USD" -> result = amount.toDouble() * 0.00026
            "EUR" -> result = amount.toDouble() * 0.00024
            "GBP" -> result = amount.toDouble() * 0.00021


        }

        return result



    }
}

