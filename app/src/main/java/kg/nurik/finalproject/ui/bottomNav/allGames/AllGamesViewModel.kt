package kg.nurik.finalproject.ui.bottomNav.allGames

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.launch

class AllGamesViewModel(private val service: Repository): ViewModel() {

    val dataCategories = MutableLiveData<List<Data>>()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            val result = service.loadData()
            if (result.isSuccessful) dataCategories.postValue(result.body()?.data)
        }
    }

}