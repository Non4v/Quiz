package com.example.midtermbtueasy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var senderEmailEditText: EditText
    private lateinit var sendTextEditText: EditText
    private lateinit var sendTextButton: Button
    private var senderEmail: String? = null
    private var senderText: String? = null
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setListeners()
    }

    private fun init(){
        senderEmailEditText = findViewById(R.id.sendEmailEditText)
        sendTextEditText = findViewById(R.id.sendTextEditText)
        sendTextButton = findViewById(R.id.sendTextButton)
    }

    private fun setListeners(){
        sendTextButton.setOnClickListener {
            checkIfFieldsAreEmpty()
            if(senderEmail != null && senderText != null){
                startActivity(Intent(this, GetTextActivity::class.java).apply {
                    putExtra("Email", senderEmail)
                    putExtra("Text", senderText)
                })
            }else{
                Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkIfFieldsAreEmpty(){
        if(senderEmailEditText.text.isNullOrEmpty()){
            senderEmail = null
            senderEmailEditText.error = "You forget to input Your Email"
        }else if(!senderEmailEditText.text.matches(emailPattern.toRegex())){
            senderEmail=null
            senderEmailEditText.error="Invalid Email Address"
        }else{
            senderEmail = senderEmailEditText.text.toString()
        }
        if(sendTextEditText.text.isNullOrEmpty()){
            senderText = null
            sendTextEditText.error = "You forget to input Your Text"
        }else{
            senderText = sendTextEditText.text.toString()
        }
    }
}