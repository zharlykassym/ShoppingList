package com.tamerlan.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamerlan.shoppinglist.data.ShopListRepositoryImpl
import com.tamerlan.shoppinglist.domain.DeleteShopItemUseCase
import com.tamerlan.shoppinglist.domain.EditShopItemUseCase
import com.tamerlan.shoppinglist.domain.GetShopListUseCase
import com.tamerlan.shoppinglist.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val getShopListUseCase : GetShopListUseCase,
            private val deleteShopItemUseCase : DeleteShopItemUseCase,
            private val editShopItemUseCase : EditShopItemUseCase
) : ViewModel() {

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch { deleteShopItemUseCase.deleteShopItem(shopItem) }
    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
