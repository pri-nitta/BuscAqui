package com.ctt.buscaqui

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        fun RetrofitConfig(s: String): Retrofit{
            return Retrofit.Builder() //configura a retrofit
                    //url base da requisição da API
                .baseUrl("https://viacep.com.br/ws/")
                    //serialização, convertendo um dado em kotlin, responsável pelo Json
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}