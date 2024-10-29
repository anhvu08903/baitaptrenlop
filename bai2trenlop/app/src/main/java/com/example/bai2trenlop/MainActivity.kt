package com.example.bai2trenlop

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var editTextNumber: EditText
    private lateinit var radioEven: RadioButton
    private lateinit var radioOdd: RadioButton
    private lateinit var radioSquare: RadioButton
    private lateinit var buttonShow: Button
    private lateinit var listView: ListView
    private lateinit var textViewError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        radioEven = findViewById(R.id.radioEven)
        radioOdd = findViewById(R.id.radioOdd)
        radioSquare = findViewById(R.id.radioSquare)
        buttonShow = findViewById(R.id.buttonShow)
        listView = findViewById(R.id.listView)
        textViewError = findViewById(R.id.textViewError)

        buttonShow.setOnClickListener {
            showNumbers()
        }
    }

    private fun showNumbers() {
        val input = editTextNumber.text.toString()

        if (input.isEmpty()) {
            textViewError.text = "Vui lòng nhập một số nguyên dương."
            textViewError.visibility = View.VISIBLE
            return
        }

        val n = input.toIntOrNull()

        if (n == null || n <= 0) {
            textViewError.text = "Số nhập vào không hợp lệ. Vui lòng nhập một số nguyên dương."
            textViewError.visibility = View.VISIBLE
            return
        }

        textViewError.visibility = View.GONE

        val resultList = when {
            radioEven.isChecked -> generateEvenNumbers(n)
            radioOdd.isChecked -> generateOddNumbers(n)
            radioSquare.isChecked -> generateSquareNumbers(n)
            else -> emptyList()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList)
        listView.adapter = adapter
    }

    private fun generateEvenNumbers(n: Int): List<String> {
        return (0..n step 2).map { it.toString() }
    }

    private fun generateOddNumbers(n: Int): List<String> {
        return (1..n step 2).map { it.toString() }
    }

    private fun generateSquareNumbers(n: Int): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i * i <= n) {
            result.add((i * i).toString())
            i++
        }
        return result
    }
}
