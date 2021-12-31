package uz.unzosoft.composecleanarchitecture.presentation.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.unzosoft.composecleanarchitecture.data.repository.ActiveRepositoryImpl
import uz.unzosoft.composecleanarchitecture.domain.repository.ActiveRepository


/**
 * Created by Abdurashidov Shahzod on 31/12/21 20:38.
 * company QQBank
 * shahzod9933@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindActiveRepository(activeRepositoryImpl: ActiveRepositoryImpl): ActiveRepository
}