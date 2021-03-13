package com.ctt.buscaqui.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.buscaqui.model.CEP
import com.ctt.buscaqui.repository.CEPRepository

class MainActivityViewModel(
    private val cepRepository: CEPRepository = CEPRepository()
) : ViewModel() {

    private lateinit var CEPLiveData: MutableLiveData<CEP>

    fun buscarCEP(cepInserido: String): MutableLiveData<CEP> {
        CEPLiveData = cepRepository.buscarViaCEP(cepUsuario = cepInserido)
        return CEPLiveData
    }
}