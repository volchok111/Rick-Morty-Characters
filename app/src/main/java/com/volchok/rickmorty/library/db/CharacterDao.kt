package com.volchok.rickmorty.library.db

//import androidx.paging.PagingSource
//import androidx.room.Dao
//import androidx.room.Query
//import androidx.room.Upsert
//import com.volchok.rickmorty.library.db.model.CharacterEntity
//
//@Dao
//interface CharacterDao {
//
//    @Upsert
//    suspend fun upsertAll(characters: List<CharacterEntity>)
//
//    @Query("SELECT * FROM characterentity")
//    fun pagingSource(): PagingSource<Int, CharacterEntity>
//
//    @Query("DELETE FROM characterentity")
//    suspend fun clearAll()
//}