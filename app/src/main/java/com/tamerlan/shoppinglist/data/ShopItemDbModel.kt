package com.tamerlan.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamerlan.shoppinglist.domain.ShopItem

@Entity(tableName = "shop_items")
data class ShopItemDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)
