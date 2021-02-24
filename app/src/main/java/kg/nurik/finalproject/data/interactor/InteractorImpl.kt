package kg.nurik.finalproject.data.interactor

import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.remote.Service
import retrofit2.Response

interface Interactor {
    suspend fun loadData():Response<BaseList>
}

class InteractorImpl(private val service: Service) : Interactor {
    override suspend fun loadData(): Response<BaseList> {
        return service.loadCategories("91edefc0-74f2-11eb-b8af-b7d03964d7a1")
    }
}