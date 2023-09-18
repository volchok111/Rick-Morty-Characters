package com.volchok.rickmorty.library.db.utils

//import android.content.Context
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import kotlin.reflect.KClass
//
//class RoomDatabaseFactory internal constructor(
//    private val applicationContext: Context
//) {
//
//    fun <T : RoomDatabase> create(databaseName: String, databaseClass: KClass<T>): T =
//        Room.databaseBuilder(
//            applicationContext,
//            databaseClass.java,
//            databaseName
//        ).build()
//}