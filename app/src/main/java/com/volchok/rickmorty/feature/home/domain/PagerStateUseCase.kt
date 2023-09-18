package com.volchok.rickmorty.feature.home.domain

//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.paging.PagingData
//import androidx.paging.map
//import com.volchok.rickmorty.feature.home.model.Character
//import com.volchok.rickmorty.library.api.data.RickMortyApi
//import com.volchok.rickmorty.library.db.CharacterDatabase
//import com.volchok.rickmorty.library.db.data.CharacterRemoteMediator
//import com.volchok.rickmorty.library.db.utils.toCharacter
//import com.volchok.rickmorty.library.use_case.domain.SynchronousUseCase
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//
//class PagerStateUseCase(
//    private val db: CharacterDatabase,
//    private val rickMortyApi: RickMortyApi
//) : SynchronousUseCase<Unit, Flow<PagingData<Character>>> {
//    @OptIn(ExperimentalPagingApi::class)
//    override fun invoke(input: Unit): Flow<PagingData<Character>> {
//        val pager = Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                initialLoadSize = 10,
//                enablePlaceholders = false,
//                prefetchDistance = 5
//            ),
//            remoteMediator = CharacterRemoteMediator(db, rickMortyApi)
//        ) {
//            db.dao().pagingSource()
//        }
//            .flow
//            .map { pagingData ->
//                pagingData.map { it.toCharacter() }
//            }
//        return pager
//    }
//}