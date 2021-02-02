package com.example.myretrofit.model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
interface MarsAPI {

    // FORMA NUEVA
    @GET("realestate")
    suspend fun fetchMarsterrainCoroutines(): Response<List<MarsTerrain>>

    // VIEJA CONFIABLE
    @GET("realestate")
    fun fetchMarsTerrainEnqueue(): Call<List<MarsTerrain>>


}