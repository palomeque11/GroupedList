package com.example.fetchsample.di;

import com.example.fetchsample.model.ItemRepositoryImpl
import com.example.fetchsample.rest.ItemClient;
import com.example.fetchsample.rest.ItemRepository

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import kotlinx.coroutines.CoroutineDispatcher;

@Module
@InstallIn(SingletonComponent::class)
public class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(service:ItemClient, dispatcher:CoroutineDispatcher): ItemRepository {
        return ItemRepositoryImpl(service,dispatcher)
    }
}
