package com.ctt.buscaqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        botaoCEP.setOnClickListener{
            val cep = campoCEP.text.toString()
            if(cep.isNotEmpty()){
                buscarCEP(cep)
            } else{
                campoCEP.error = "Digite um CEP válido"
            }
        }
    }

    fun buscarCEP(cep: String){
        val retrofitClient = Network.RetrofitConfig("https://viacep.com.br/ws/")

        //juntar as pontas
        val servico = retrofitClient.create(CEPService::class.java)

        //url no navegador
        val chamada = servico.buscarCEP(cep)

        //realiza a chamada, faz o enter
        //.execute -> realiza a chamada de maneira sincrona (não depende da ordem de execução)
        //.enqueue -> chamada assincrona (chamada rápida)
        chamada.enqueue(
            object: Callback<CEP>{ //fluxo chamada/resposta
                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {
                    val endereco = response.body()?.toString()
                    endereco?.let{
                        if(it.isNotEmpty()){
                            respostaCEP.text = endereco
                        } else{
                            campoCEP.error = "Não há informações sobre ele! :("
                        }
                    }
                }

                override fun onFailure(call: Call<CEP>, t: Throwable) {
                    respostaCEP.text= "Tente novamente mais tarde."
                }

            }
        )
    }
}