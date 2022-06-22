package com.julianhv20.currencyconverter.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class MainViewModel: ViewModel() {



    val dec= DecimalFormat("###,###,###,###,###,###,###.##")
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
        _currency.value = convertResult


    }

    private fun currencyConverter(
        to: String,
        inn: String,
        amount1: String
    ): String {
        var result = dec.format(0.00)
        var cash=""
        if(inn=="USD"&& to=="USD"){
            result=dec.format(amount1.toDouble()*1)
            cash="$"
        }
        if(inn=="EUR"&& to=="EUR"){
            result=dec.format(amount1.toDouble()*1)
            cash="€"
        }
        if(inn=="GBP"&&to=="GBP"){
            result=dec.format(amount1.toDouble()*1)
            cash="COP"
        }

        if(inn=="USD"&&to=="EUR"){
            result=dec.format(amount1.toDouble()*0.95)
            cash="€"
        }
        if(inn=="USD"&&to=="GBP"){
            result=dec.format(amount1.toDouble()*3983.00)
            cash="COP"
        }

        if(inn=="EUR"&&to=="USD"){
            result=dec.format(amount1.toDouble()*1.05)
            cash="$"
        }
        if(inn=="EUR"&&to=="GBP"){
            result=dec.format(amount1.toDouble()*4196.05)
            cash="COP"
        }

        if(inn=="GBP"&&to=="USD"){
            result=dec.format(amount1.toDouble()*0.00026)
            cash="$"
        }
        if(inn=="GBP"&&to=="EUR"){
            result=dec.format(amount1.toDouble()*0.00024)
            cash="€"
        }

        result=result.toString()+"  "+" "+cash
        return result
    }




}