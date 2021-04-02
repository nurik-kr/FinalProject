package kg.nurik.finalproject.ui.bottomNav.allGames

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllGamesViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    val data = MutableLiveData<List<Data>>()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.loadData()
            }.onFailure {
                Log.d("Error", it.localizedMessage?: "no error message")
            }
        }
    }

    fun getAllGames(): LiveData<List<Data>> {
        return db.getPagingCasheDao().getAllGames()
    }

    fun getFavouriteFiveContinent(data: List<Data>) {
        if(data.isNotEmpty()){
            val list = ArrayList<Data>()
            for (i in 0..4) {
                list.add(data.random())
            }
            this.data.postValue(list)
        }
    }

}