package com.augusto.bigball.di

import com.augusto.bigball.ui.features.auth.signin.SigninViewModel
import com.augusto.bigball.data.validator.EmailValidatorImpl
import com.augusto.bigball.ui.MainViewModel
import com.augusto.bigball.ui.features.auth.signup.SignupViewModel
import com.augusto.bigball.ui.features.home.bets.BetsViewModel
import com.augusto.bigball.ui.navigation.NavigationManager
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    single {
        NavigationManager()
    }

    viewModel {
        SignupViewModel(Dispatchers.IO, EmailValidatorImpl(), get(), get())
    }

    viewModel {
        SigninViewModel(Dispatchers.IO, EmailValidatorImpl(), get(), get())
    }

    viewModel {
        MainViewModel(get())
    }

    viewModel {
        BetsViewModel(Dispatchers.IO)
    }
}