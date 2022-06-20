package com.julianhv20.currencyconverter.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.julianhv20.currencyconverter.R
import com.julianhv20.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val currencies = resources.getStringArray(R.array.currency_list)
        val adapter = ArrayAdapter(this, R.layout.list_item, currencies)

        with(mainBinding.autoCompleteTextView) {
            setAdapter(adapter)
        }

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.currency.observe(this) { curr ->
            mainBinding.tvResult.text = curr

        }

        mainViewModel.fieldError.observe(this) { err ->
            val toast = Toast.makeText(this, err, Toast.LENGTH_SHORT)
            toast.show()
        }

        //Change the currency
        with(mainBinding){



            btnConvert.setOnClickListener {
                val to = autoCompleteTextView.text.toString()
                val amount = etNumber.text.toString()
                mainViewModel.convertCurrency(to, amount)
            }


        }



    }


}

