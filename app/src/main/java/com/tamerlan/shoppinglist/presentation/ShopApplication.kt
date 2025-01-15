package com.tamerlan.shoppinglist.presentation

import android.app.Application
import com.tamerlan.shoppinglist.di.DaggerApplicationComponent

class ShopApplication : Application(){

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}