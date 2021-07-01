package com.augusto.bigball.ui.features.home.bets

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.augusto.bigball.presentation.bases.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

class BetsViewModel(defaultDispatcher: CoroutineDispatcher) : BaseViewModel(defaultDispatcher) {

    private var _betsState by mutableStateOf(BetsState())
        private set

    val betsState = _betsState
}