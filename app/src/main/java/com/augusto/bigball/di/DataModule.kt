package com.augusto.bigball.di

import com.augusto.bigball.core.data.dataSource.AuthDataSource
import com.augusto.bigball.core.data.dataSource.AuthLocalDataSource
import com.augusto.bigball.core.data.dataSource.ClassificationDataSource
import com.augusto.bigball.core.data.dataSource.MatchDataSource
import com.augusto.bigball.core.data.repository.AuthRepositoryImpl
import com.augusto.bigball.core.data.repository.ClassificationRepositoryImpl
import com.augusto.bigball.core.data.repository.MatchRepositoryImpl
import com.augusto.bigball.core.domain.repository.AuthRepository
import com.augusto.bigball.core.domain.repository.ClassificationRepository
import com.augusto.bigball.core.domain.repository.MatchRepository
import com.augusto.bigball.data.dataSource.AuthDataSourceImpl
import com.augusto.bigball.data.dataSource.ClassificationDataSourceImpl
import com.augusto.bigball.data.dataSource.MatchDataSourceImpl
import com.augusto.bigball.data.local.Preferences
import com.augusto.bigball.data.local.SharedDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

private val PREFERENCES = StringQualifier("preferences")

val dataModule = module {

    single<AuthDataSource> {
        AuthDataSourceImpl(get())
    }

    single<MatchDataSource> {
        MatchDataSourceImpl(get())
    }

    single<ClassificationDataSource> {
        ClassificationDataSourceImpl(get())
    }

    single(PREFERENCES) {
        Preferences(androidContext())
    }

    single<AuthLocalDataSource> {
        SharedDataSourceImpl(get(PREFERENCES))
    }

    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    single<MatchRepository> { MatchRepositoryImpl(get()) }
    single<ClassificationRepository> { ClassificationRepositoryImpl(get()) }
}