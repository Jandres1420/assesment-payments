package com.pico.mvvm.credibanco.di

import android.app.Application
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.pico.mvvm.credibanco.core.Constants
import com.pico.mvvm.credibanco.data.repository.ApiRestRepositoryImpl
import com.pico.mvvm.credibanco.data.repository.MyDatabase
import com.pico.mvvm.credibanco.data.use_cases.CrediBancoUseCases
import com.pico.mvvm.credibanco.data.use_cases.GetAuthorization
import com.pico.mvvm.credibanco.data.use_cases.PostAnnulment
import com.pico.mvvm.credibanco.domain.repository.ApiRestRepository
import com.pico.mvvm.credibanco.domain.repository.ApiService
import com.pico.mvvm.credibanco.domain.repository.MyOpenHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.LOCAL_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCreateAppKey(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiRestRepository(apiService: ApiService): ApiRestRepository {
        return ApiRestRepositoryImpl(apiService)
    }

    @Provides
    fun provideCrediBancoUseCases(repository: ApiRestRepository) = CrediBancoUseCases(
        GetAuthorization(repository),
        PostAnnulment(repository)
    )

    @Provides
    @Singleton
    fun provideDatabaseHelper(@ApplicationContext context: Context): MyOpenHelper {
        return MyOpenHelper(context)
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideMyDatabase(dbHelper: MyOpenHelper): MyDatabase {
        return MyDatabase(dbHelper)
    }
}


