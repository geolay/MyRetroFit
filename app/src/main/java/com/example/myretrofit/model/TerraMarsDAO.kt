package com.example.myretrofit.model


import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TerraMarsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerraMars(terraMars: MarsTerrain)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTerraMars(terraMars: List<MarsTerrain>)

    @Update
    suspend fun updateTerraMars(terraMars: MarsTerrain)

    @Delete
    suspend fun deleteTerraMars(terraMars: MarsTerrain)

   @Query("SELECT * FROM terramars_table")
   fun getAllTerraMars(): LiveData<List<MarsTerrain>>

    @Query("SELECT * FROM terramars_table WHERE id = :mId")
    fun getTerraMars(mId: String): LiveData<MarsTerrain>
}