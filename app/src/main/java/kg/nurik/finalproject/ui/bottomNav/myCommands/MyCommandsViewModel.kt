package kg.nurik.finalproject.ui.bottomNav.myCommands

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyCommandsViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    fun update(item: Commands) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                db.getPagingCasheDao().update(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage)
            }
        }
    }

//    fun loadCommands(countryId: Int) {
//        viewModelScope.launch(Dispatchers.IO) {
//            runCatching {
//                repository.loadCommands(
//                    "91edefc0-74f2-11eb-b8af-b7d03964d7a1",
//                    country_id = countryId
//                )
//            }.onFailure {
//                Log.d("commands", it.localizedMessage)
//            }
//        }
//    }

    fun getAllFavouriteCommands(): LiveData<List<Commands>> {
        return db.getPagingCasheDao().getFavorite()
    }
}