package com.augusto.bigball.di

import com.augusto.bigball.NavigationManager
import com.augusto.bigball.SigninViewModel
import com.augusto.bigball.data.validator.EmailValidatorImpl
import com.augusto.bigball.presentation.login.viewmodel.LoginHomeViewModel
import com.augusto.bigball.SignupViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    single {
        NavigationManager()
    }

    viewModel {
        SignupViewModel(Dispatchers.IO, EmailValidatorImpl())
    }

    viewModel {
        LoginHomeViewModel(get())
    }

    viewModel {
        SigninViewModel(Dispatchers.IO, EmailValidatorImpl(), get())
    }
}