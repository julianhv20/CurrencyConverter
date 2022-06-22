package com.julianhv20.currencyconverter.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {




    private val _currency : MutableLiveData<String> = MutableLiveData()
    val currency : LiveData<String> = _currency

    private val _fieldError : MutableLiveData<String> = MutableLiveData()
    val fieldError : LiveData<String> = _fieldError

    fun convertCurrency(to: String,inn: String, amount1: String) {
        if (to.isEmpty() || amount1.isEmpty() || inn.isEmpty()){
            _fieldError.value = "Please fill in all fields"
            return
        }


        val convertResult = currencyConverter(to,inn,amount1)
        _currency.value = convertResult.toString()

    }

    private fun currencyConverter(to: String,inn: String, amount1: String): Double {
        var result = 0.0
        if(inn=="USD"||to=="USD"){
            result=amount1.toDouble()*1
        }
        if(inn=="EUR"||to=="EUR"){
            result=amount1.toDouble()*1
        }
        if(inn=="GBP"||to=="GBP"){
            result=amount1.toDouble()*1
        }

        if(inn=="USD"||to=="EUR"){
            result=amount1.toDouble()*0.95
        }
        if(inn=="USD"||to=="GBP"){
            result=amount1.toDouble()*3983.00
        }

        if(inn=="EUR"||to=="USD"){
            result=amount1.toDouble()*1.05
        }
        if(inn=="EUR"||to=="USD"){
            result=amount1.toDouble()*4196.05
        }

        if(inn=="GBP"||to=="USD"){
            result=amount1.toDouble()*0.00026
        }
        if(inn=="GBP"||to=="EUR"){
            result=amount1.toDouble()*0.00024
        }

        return result
    }




}