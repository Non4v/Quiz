package com.example.midtermbtueasy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GetTextActivity : AppCompatActivity() {
    private lateinit var sentEmailTextView: TextView
    private lateinit var sentTextEditText: EditText
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_text)

        init()
        setGetedNumberAndMessage()
        setListeners()
    }

    private fun init(){
        sentEmailTextView = findViewById(R.id.sendedEmailTextView)
        sentTextEditText = findViewById(R.id.sendedTextEditText)
        clearButton = findViewById(R.id.clearButton)
    }

    private fun setGetedNumberAndMessage(){
        sentEmailTextView.text = intent.getStringExtra("Email")
        sentTextEditText.setText(intent.getStringExtra("Text"))
    }

    private fun setListeners(){
        clearButton.setOnClickListener {
            sentEmailTextView.text = null
            sentTextEditText.text = null
        }
    }
}