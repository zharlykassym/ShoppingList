package com.tamerlan.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tamerlan.shoppinglist.data.ShopListRepositoryImpl
import com.tamerlan.shoppinglist.domain.DeleteShopItemUseCase
import com.tamerlan.shoppinglist.domain.EditShopItemUseCase
import com.tamerlan.shoppinglist.domain.GetShopItemUseCase
import com.tamerlan.shoppinglist.domain.GetShopListUseCase
import com.tamerlan.shoppinglist.domain.ShopItem
import com.tamerlan.shoppinglist.domain.ShopListRepository


class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}
