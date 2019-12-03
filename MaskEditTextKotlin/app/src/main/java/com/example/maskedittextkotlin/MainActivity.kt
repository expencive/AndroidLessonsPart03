package com.example.maskedittextkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.redmadrobot.inputmask.MaskedTextChangedListener
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

class MainActivity : AppCompatActivity() {

    internal lateinit var editText: EditText
    internal lateinit var textView: TextView
    internal lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            enablePhoneNumberMask(editText.text.toString())
        })

    }

    fun enablePhoneNumberMask(text: String){

        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)



    }



}
