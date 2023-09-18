package com.volchok.rickmorty.library.db.data

//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.LoadType
//import androidx.paging.PagingState
//import androidx.paging.RemoteMediator
//import androidx.room.withTransaction
//import com.volchok.rickmorty.library.api.data.RickMortyApi
//import com.volchok.rickmorty.library.db.CharacterDatabase
//import com.volchok.rickmorty.library.db.model.CharacterEntity
//import com.volchok.rickmorty.library.db.utils.toCharacterEntity
//import java.io.IOException
//
//@OptIn(ExperimentalPagingApi::class)
//class CharacterRemoteMediator(
//    private val characterDb: CharacterDatabase,
//    private val rickMortyApi: RickMortyApi
//) : RemoteMediator<Int, CharacterEntity>() {
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, CharacterEntity>
//    ): MediatorResult {
//        return try {
//            val loadKey = when (loadType) {
//                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> return MediatorResult.Success(
//                    endOfPaginationReached = true
//                )
//
//                LoadType.APPEND -> {
//                    val lastItem = state.lastItemOrNull()
//                    if (lastItem == null) {
//                        1
//                    } else {
//                        (lastItem.id / state.config.pageSize) + 1
//                    }
//                }
//            }
//            val characters = rickMortyApi.getCharacters(
//                page = loadKey
//            )
//
//            characterDb.withTransaction {
//                if (loadType == LoadType.REFRESH) {
//                    characterDb.dao().clearAll()
//                }
//                val characterEntities = characters.results.map { it.toCharacterEntity() }
//                characterDb.dao().upsertAll(characterEntities)
//            }
//            MediatorResult.Success(
//                endOfPaginationReached = characters.results.isEmpty()
//            )
//        } catch (e: IOException) {
//            MediatorResult.Error(e)
//        }
//    }
//}