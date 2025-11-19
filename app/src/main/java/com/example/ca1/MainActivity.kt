package com.example.ca1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var bt :  Button
        lateinit var et1 : EditText
        lateinit var et2 : EditText
        lateinit var et3 : EditText


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bt = findViewById(R.id.BT1)
        et1 = findViewById(R.id.ET1)
        et2 = findViewById(R.id.ET2)
        et3 = findViewById(R.id.ET3)

        bt.setOnClickListener {
            val sub1 = et1.text.toString().toFloat()
            val sub2 = et2.text.toString().toFloat()
            val sub3 = et3.text.toString().toFloat()
            val cgpa = (sub1+sub2+sub3)/3
            Toast.makeText(this, "CGPA is $cgpa", Toast.LENGTH_LONG).show()
        }

    }
}