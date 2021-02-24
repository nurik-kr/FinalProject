package kg.nurik.finalproject.data.repository

import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.model.allGames.BaseList
import retrofit2.Response

interface Repository {
    suspend fun loadData(): Response<BaseList>
}

class RepositoryImpl(private val network: Interactor) : Repository {
    override suspend fun loadData(): Response<BaseList> {
        return network.loadData()
    }
}