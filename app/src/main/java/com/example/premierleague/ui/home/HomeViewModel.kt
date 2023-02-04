package com.example.premierleague.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DisplayedMatchModel
import com.example.domain.usecase.DeleteLocalDatabaseUseCase
import com.example.domain.usecase.FetchMatchesFromApiUseCase
import com.example.domain.usecase.GetMatchesFromLocalUseCase
import com.example.domain.usecase.SaveMatchToLocalUseCase
import com.example.premierleague.utils.network_validator.NetworkValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val TAG = "nageh"

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkValidator: NetworkValidator,
    private val fetchMatchesFromApiUseCase: FetchMatchesFromApiUseCase,
    private val saveMatchToLocalUseCase: SaveMatchToLocalUseCase,
    private val getMatchesFromLocalUseCase: GetMatchesFromLocalUseCase,
    private val deleteLocalDatabaseUseCase: DeleteLocalDatabaseUseCase,
) : ViewModel() {

    private val _matches: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Success(null))
    val matches: StateFlow<HomeState> = _matches

    init {
        fetchMatches()
    }

    private fun fetchMatches() = viewModelScope.launch() {
        _matches.value = HomeState.Loading(true)
        try {
            val list = withContext(Dispatchers.IO) {
                when (networkValidator.isConnected()) {
                    true -> {
                        deleteLocalDatabaseUseCase.invoke()
                        fetchMatchesFromApiUseCase.invoke()
                    }
                    false -> getMatchesFromLocalUseCase.invoke()
                }
            }
            withContext(Dispatchers.Main) { _matches.value = HomeState.Success(list) }
            saveMatchToLocal(list)
        } catch (e: Exception) {
            _matches.value = HomeState.Error(e)
            Log.e(TAG, "fetchMatches error:${e.message} ")
        } finally {
            _matches.value = HomeState.Loading(false)
        }
    }

    fun saveMatchToLocal(matches: List<DisplayedMatchModel>) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (networkValidator.isConnected()) matches.forEach { displayedMatch ->
                displayedMatch.matches?.forEach { matchModel ->
                    saveMatchToLocalUseCase(matchModel)
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "saveMatchToLocal error:${e.message} ")
        }
    }
}

sealed class HomeState {
    data class Success(val data: List<DisplayedMatchModel>?) : HomeState()
    data class Loading(val loading: Boolean) : HomeState()
    data class Error(val error: Throwable) : HomeState()
}