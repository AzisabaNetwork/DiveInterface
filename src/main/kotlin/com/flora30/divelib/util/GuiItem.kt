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
        meta.displayName(Component.text("${ChatColor.WHITE}"))
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
        meta.displayName(Component.text("${ChatColor.WHITE}"))
        meta.setCustomModelData(getCustomModelData(type))
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta
        return item
    }

    private fun getCustomModelData(type: GuiItemType): Int {
        return when (type) {
            GuiItemType.QuestPrepared -> 1
            GuiItemType.QuestAccepted -> 2
            GuiItemType.QuestCompleted -> 3
            GuiItemType.PointLuc -> 4
            GuiItemType.PointInt -> 5
            GuiItemType.PointVit -> 6
            GuiItemType.PointAtk -> 7
            GuiItemType.Point -> 8
            GuiItemType.Return -> 9
            GuiItemType.Help -> 10
            GuiItemType.PointZero -> 11
            GuiItemType.Plus -> 12
            GuiItemType.WoolWhite -> 13
            GuiItemType.WoolGray -> 14
            GuiItemType.WoolBlack -> 15
            GuiItemType.WhistleRed -> 16
            GuiItemType.WhistleBlue -> 17
            GuiItemType.WhistleMoon -> 18
            GuiItemType.WhistleBlack -> 19
            GuiItemType.WhistleWhite -> 20
        }
    }

    /**
     * 戻るボタン
     */
    fun getReturn(): ItemStack {
        val item = ItemStack(Material.PAPER)
        val meta = item.itemMeta
        meta.displayName(Component.text("${ChatColor.WHITE}戻る"))
        meta.setCustomModelData(getCustomModelData(GuiItemType.Return))
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