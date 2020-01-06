package com.example.foregroundserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    val editText : EditText by lazy { findViewById<EditText>(R.id.editText1) }
    val start: Button by lazy { findViewById<Button>(R.id.btnStart) }
    val stop: Button by lazy { findViewById<Button>(R.id.btnStop) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start.setOnClickListener{
            startServiceFuntion()
        }
        stop.setOnClickListener{
            stopServiceFunction()
        }
    }

    private fun startServiceFuntion(){
        val dataToSend = editText.text.toString().trim()
        val serviceIntent = Intent(this, ExampleService::class.java)
        serviceIntent.putExtra("data", dataToSend)
        ContextCompat.startForegroundService(this, serviceIntent)
    }

    private fun stopServiceFunction() {
        val serviceIntent = Intent(this, ExampleService::class.java)
        stopService(serviceIntent)
    }
}
