package kg.nurik.finalproject.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.local.CasheAppDatabase
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: Repository,
    private val db: CasheAppDatabase
) : ViewModel() {

    val search = MutableLiveData<Data>()

    fun startSearch(query: String) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {

                val favourite = db.getCasheDao().searchData(query)
                val data = db.getCasheDao().getAllGamesData()

                data.forEach {
                    if (data.find { it.name == query } != null)
                        search.postValue(it)
                    else{
                        Log.d("FavouriteCommands", "asdasdasd" ?: "no error message")
                    }
                }


//                query.forEach { _ ->
//
//                    if (favourite.find { it.name == query} != null)
////                        query.let { search.postValue() }
//                }
//                query?.let { search.postValue(listOf(it)) }
            }.onFailure {
                Log.d("FavouriteCommands", it.localizedMessage ?: "no error message")
            }
        }

    }

}