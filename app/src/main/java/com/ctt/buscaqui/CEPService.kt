package com.ctt.buscaqui

import com.ctt.buscaqui.model.CEP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CEPService {
    @GET("{cepInserido}/json/")
    fun buscarCEP(
        @Path("cepInserido") cep: String
    ): Call<CEP>
}