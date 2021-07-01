package com.augusto.bigball.ui.features.home.bets

import com.augusto.bigball.ui.features.home.bets.component.Match

data class BetsState (
    val loading: Boolean = false,
    val matchesPerformed: Boolean = false,
    val matchs: List<Match> = listOf()
)