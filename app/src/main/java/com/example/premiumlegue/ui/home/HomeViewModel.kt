package com.example.premiumlegue.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DisplayedMatchModel
import com.example.domain.usecase.FetchMatchesFromApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchMatchesFromApiUseCase: FetchMatchesFromApiUseCase,
) : ViewModel() {

    private val _matches: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Success(null))
    val matches: StateFlow<HomeState> = _matches

    init {
        fetchMatches()
    }

    private fun fetchMatches() = viewModelScope.launch {
        _matches.value = HomeState.Loading(true)
        try {
            _matches.value = HomeState.Success(fetchMatchesFromApiUseCase.invoke())
        } catch (e: Exception) {
            _matches.value = HomeState.Error(e)
            Log.e("nageh", "fetchMatches error:${e.message} ")
        } finally {
            _matches.value = HomeState.Loading(false)
        }
    }
}

sealed class HomeState {
    data class Success(val data: List<DisplayedMatchModel>?) : HomeState()
    data class Loading(val loading: Boolean) : HomeState()
    data class Error(val error: Throwable) : HomeState()
}