package com.augusto.bigball.di

import com.augusto.bigball.core.domain.useCase.*
import org.koin.dsl.module

val useCaseModule = module {

    single {
        Signup(get())
    }

    single {
        Signin(get())
    }

    single {
        GetClassification(get())
    }

    single {
        ToBet(get())
    }

    single {
        IsLoggedIn(get())
    }
}