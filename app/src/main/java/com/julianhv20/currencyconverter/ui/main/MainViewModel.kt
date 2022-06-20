package com.julianhv20.currencyconverter.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {




    private val _currency : MutableLiveData<String> = MutableLiveData()
    val currency : LiveData<String> = _currency

    private val _fieldError : MutableLiveData<String> = MutableLiveData()
    val fieldError : LiveData<String> = _fieldError

    fun convertCurrency(to: String, amount: String) {
        if (to.isEmpty() || amount.isEmpty()){
            _fieldError.value = "Please fill in all fields"
            return
        }


        val convertResult = currencyConverter(to,amount)
        _currency.value = convertResult.toString()

    }

    private fun currencyConverter(to: String, amount: String): Double {
        var result = 0.0
        when (to) {

            "USD" -> result = amount.toDouble() * 0.00026
            "EUR" -> result = amount.toDouble() * 0.00024
            "GBP" -> result = amount.toDouble() * 0.00021


        }

        return result
    }




}