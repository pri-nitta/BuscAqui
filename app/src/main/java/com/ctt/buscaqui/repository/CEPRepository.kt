package com.ctt.buscaqui.repository

import androidx.lifecycle.MutableLiveData
import com.ctt.buscaqui.model.CEP

class CEPRepository {
    fun buscarViaCEP(cepUsuario: String): MutableLiveData<CEP> {
        val cepLiveData = MutableLiveData<CEP>()
    }
}