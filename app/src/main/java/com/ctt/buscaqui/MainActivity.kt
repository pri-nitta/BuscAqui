package com.ctt.buscaqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var campoCEP: EditText
    private lateinit var botaoCEP: Button
    private lateinit var respostaCEP: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoCEP =findViewById(R.id.edtCEP)
        botaoCEP = findViewById(R.id.btnBuscarCep)
        respostaCEP = findViewById(R.id.txtCepResponse)

    }
}