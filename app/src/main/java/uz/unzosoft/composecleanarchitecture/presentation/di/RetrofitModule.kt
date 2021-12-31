package uz.unzosoft.composecleanarchitecture.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.unzosoft.composecleanarchitecture.presentation.ui.common.constants.Constants.BASE_URL
import javax.inject.Singleton


/**
 * Created by Abdurashidov Shahzod on 31/12/21 20:33.
 * company QQBank
 * shahzod9933@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    @Singleton
    fun apiUrl(): String = BASE_URL

    @Provides
    @Singleton
    fun getRetrofit(
        api: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(api)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}