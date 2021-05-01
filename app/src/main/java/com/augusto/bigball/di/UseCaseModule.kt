package com.augusto.bigball.di

import com.augusto.bigball.core.domain.useCase.GetClassification
import com.augusto.bigball.core.domain.useCase.Signin
import com.augusto.bigball.core.domain.useCase.Signup
import com.augusto.bigball.core.domain.useCase.ToBet
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
}