package com.example.myretrofit.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitRepository() {
    private val service = RetrofitClient.getClientRetrofit()
    val liveDataTerraMars = MutableLiveData<List<MarsTerrain>>()

    fun getFetchTerraMarsEnqueue(): LiveData<List<MarsTerrain>> {
        service.fetchMarsTerrainEnqueue().enqueue(object : Callback<List<MarsTerrain>> {
            override fun onFailure(call: Call<List<MarsTerrain>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<MarsTerrain>>,
                response: Response<List<MarsTerrain>>
            ) {
                when (response.code()) {
                    in 200..299 -> liveDataTerraMars.value = response.body()
                    in 300..399 -> Log.d("ERROR", response.message().toString())
                    else -> Log.d("ERROR", "Error del servidor ${response.code()}")
                }
            }
        })

        return liveDataTerraMars
    }

    suspend fun getFetchTerraMarsCoroutines() {
        Log.d("Repository", "Utilizando Coroutines")
        try {
            val response = RetrofitClient.getClientRetrofit().fetchMarsterrainCoroutines()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    liveDataTerraMars.value = it
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()}")
            }
        }
        catch (t: Throwable) {
            Log.d("Error en Coroutine", t.message.toString())
        }
    }
}