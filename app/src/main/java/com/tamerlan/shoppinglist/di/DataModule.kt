package com.tamerlan.shoppinglist.di

import android.app.Application
import com.tamerlan.shoppinglist.data.AppDataBase
import com.tamerlan.shoppinglist.data.ShopListDao
import com.tamerlan.shoppinglist.data.ShopListRepositoryImpl
import com.tamerlan.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDataBase.getInstance(application).shopListDao()
        }

    }

}