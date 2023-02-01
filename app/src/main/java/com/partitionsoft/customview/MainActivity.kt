package com.partitionsoft.customview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button_txt_changed)
        val textView: TextView = findViewById(R.id.text_custom_view)


        button.setOnClickListener {
            textView.text = "Text has been changed"
        }
    }
}