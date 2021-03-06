package com.ctt.buscaqui

import com.google.gson.annotations.SerializedName

class CEP(
    @SerializedName("logradouro") val rua: String,
    @SerializedName("bairro") val bairro: String,
    @SerializedName("localidade") val cidade: String,
    @SerializedName("uf") val uf: String
) {
    override fun toString(): String{
        return "Rua: $rua\nBairro:$bairro\nE fica locado em: $cidade - $uf"
    }

}