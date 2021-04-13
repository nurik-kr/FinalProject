package kg.nurik.finalproject.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.local.CasheAppDatabase
import kg.nurik.finalproject.data.model.allGames.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val db: CasheAppDatabase) : ViewModel() {

    val search = MutableLiveData<List<Data>>()
    private lateinit var data: List<Data>

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                data = db.getCasheDao().getAllGamesData()
            }
        }
    }

    fun startSearch(query: String) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                val result = data.filter { it.name?.contains(query) == true }
                search.postValue(result)
            }
        }
    }
}