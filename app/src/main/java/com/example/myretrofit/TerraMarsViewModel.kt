package com.example.myretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofit.model.MarsTerrain
import com.example.myretrofit.model.RetrofitRepository
import kotlinx.coroutines.launch


class TerraMarsViewModel: ViewModel() {
    private val repository: RetrofitRepository

    init {
        repository = RetrofitRepository()
        viewModelScope.launch {
            repository.getFetchTerraMarsCoroutines()
        }
    }

    fun getFetchTerraMars(): LiveData<List<MarsTerrain>>{
        return repository.getFetchTerraMarsEnqueue()
    }

    fun getFetchTerraMarsCoroutines(): LiveData<List<MarsTerrain>>{
        return repository.liveDataTerraMars
    }
}
