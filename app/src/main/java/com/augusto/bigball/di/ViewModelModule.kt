package com.augusto.bigball.di

import com.augusto.bigball.AuthViewModel
import com.augusto.bigball.core.domain.useCase.Signup
import com.augusto.bigball.data.validator.EmailValidatorImpl
import com.augusto.bigball.presentation.login.viewmodel.LoginHomeViewModel
import com.augusto.bigball.presentation.login.viewmodel.SigninViewModel
import com.augusto.bigball.presentation.login.viewmodel.SignupViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        SigninViewModel(get(), get(), EmailValidatorImpl(), Dispatchers.IO)
    }

    viewModel {
        SignupViewModel(Signup(get()), EmailValidatorImpl(), Dispatchers.IO)
    }

    viewModel {
        LoginHomeViewModel(get())
    }

    viewModel {
        AuthViewModel(Dispatchers.IO, EmailValidatorImpl())
    }
}