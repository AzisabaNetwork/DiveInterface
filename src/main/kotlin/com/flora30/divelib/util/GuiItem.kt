package com.flora30.divelib.util

import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

object GuiItem {
    /**
     * 名前のないアイテムを取得
     */
    fun getItem(material: Material): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta
        meta.displayName(Component.text("${ChatColor.RESET}"))
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta
        return item
    }

    /**
     * 名前のないアイテムを取得
     */
    fun getItem(type: GuiItemType): ItemStack {
        val item = ItemStack(Material.PAPER)
        val meta = item.itemMeta
        meta.displayName(Component.text("${ChatColor.RESET}"))
        meta.setCustomModelData(type.customModelData)
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta
        return item
    }

    /**
     * 戻るボタン
     */
    fun getReturn(): ItemStack {
        val item = ItemStack(Material.PAPER)
        val meta = item.itemMeta
        meta.displayName(Component.text("${ChatColor.WHITE}戻る"))
        meta.setCustomModelData(GuiItemType.Return.customModelData)
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta
        return item
    }

    /**
     * 背景を灰色ガラスにする
     */
    fun grayBack(inventory: Inventory): Inventory {
        for (i in 0 until inventory.size) {
            inventory.setItem(i, getItem(Material.GRAY_STAINED_GLASS_PANE))
        }
        return inventory
    }
}