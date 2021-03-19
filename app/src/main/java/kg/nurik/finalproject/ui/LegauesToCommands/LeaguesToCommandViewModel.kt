package kg.nurik.finalproject.ui.LegauesToCommands

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.command.Commands
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LeaguesToCommandViewModel(private val service: Interactor) : ViewModel() {

    val dataCommands = MutableLiveData<BaseList<Commands>>()

    fun loadCommands(countryId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result =
                    service.loadCommands("91edefc0-74f2-11eb-b8af-b7d03964d7a1", countryId)
                dataCommands.postValue(result.body())
            }.onFailure {
                Log.d("ssasdas", it.localizedMessage)
            }
        }
    }

}