package uz.unzosoft.composecleanarchitecture.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.unzosoft.composecleanarchitecture.data.remote.ActiveApi
import javax.inject.Singleton


/**
 * Created by Abdurashidov Shahzod on 31/12/21 20:33.
 * company QQBank
 * shahzod9933@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ActiveApi = retrofit.create(ActiveApi::class.java)
}