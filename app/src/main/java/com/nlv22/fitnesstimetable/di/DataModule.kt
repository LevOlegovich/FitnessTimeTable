package com.nlv22.fitnesstimetable.di

import com.nlv22.fitnesstimetable.data.repository.TrainingRepoImpl
import com.nlv22.fitnesstimetable.domain.repository.TrainingRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindTrainingRepo(impl: TrainingRepoImpl): TrainingRepo
}