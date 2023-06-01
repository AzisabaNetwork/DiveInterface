package com.flora30.divelib.gui

import com.flora30.divelib.data.Whistle
import com.flora30.divelib.data.WhistleObject.whistleExpMap
import com.flora30.divelib.data.WhistleObject.whistleMap
import com.flora30.divelib.data.WhistleType
import com.flora30.divelib.data.player.PlayerDataObject.playerDataMap
import com.flora30.divelib.event.HelpEvent
import com.flora30.divelib.event.HelpType
import com.flora30.divelib.util.ComponentUtil
import com.flora30.divelib.util.GuiItem.getItem
import com.flora30.divelib.util.GuiItem.grayBack
import com.flora30.divelib.util.GuiItemType
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

object WhistleGUI {
    val sendRegion = listOf(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33)
    const val sendPoint = 34
    fun getGui(player: Player): Inventory {
        Bukkit.getPluginManager().callEvent(HelpEvent(player, HelpType.WhistleGUI))
        val inv = Bukkit.createInventory(null, 45, Component.text("笛ランク"))
        grayBack(inv)
        inv.setItem(4, getWhistleIcon(player))
        inv.setItem(sendPoint, sendIcon)
        for (slot in sendRegion) {
            inv.setItem(slot, null)
        }
        return inv
    }

    private val sendIcon: ItemStack
        get() {
            val item = ItemStack(Material.LIME_STAINED_GLASS_PANE)
            val meta = item.itemMeta!!
            val lore: MutableList<String> = ArrayList()

            // 名前
            meta.displayName(Component.text(ChatColor.GOLD.toString() + "<<" + ChatColor.WHITE + " クリックで遺物を納品する " + ChatColor.GOLD + ">>"))

            // 説明
            lore.add("")
            lore.add(ChatColor.WHITE.toString() + "空いた場所に遺物を置いてください")
            lore.add(ChatColor.YELLOW.toString() + "遺物価値" + ChatColor.WHITE + "によって、" + ChatColor.YELLOW + "貢献値" + ChatColor.WHITE + "が上昇します")
            meta.lore(ComponentUtil.convertComponentList(lore))
            item.itemMeta = meta
            return item
        }

    private fun getWhistleIcon(player: Player): ItemStack {
        val data = playerDataMap[player.uniqueId]
        val exp = data!!.levelData.whistleExp
        val nextExp = whistleExpMap[data.levelData.whistleRank + 1]!!
        val whistle = whistleMap[data.levelData.whistleRank]
        val item: ItemStack = when (whistle!!.type) {
            WhistleType.Red -> getItem(GuiItemType.WhistleRed)
            WhistleType.Blue -> getItem(GuiItemType.WhistleBlue)
            WhistleType.Moon -> getItem(GuiItemType.WhistleMoon)
            WhistleType.Black -> getItem(GuiItemType.WhistleBlack)
            WhistleType.White -> getItem(GuiItemType.WhistleWhite)
            else -> throw IllegalStateException("Unexpected value: " + whistle.type)
        }

        // 貢献値について
        val lore: MutableList<String> = ArrayList()
        lore.add("")
        val expText = ChatColor.GOLD.toString() + "現在の貢献値 ‣ " + ChatColor.WHITE + exp
        val nextExpText = ChatColor.GOLD.toString() + "（次まで ‣ " + ChatColor.WHITE + nextExp + ChatColor.GOLD + " ）"
        lore.add(expText + nextExpText)

        // 機能について
        lore.add("")
        lore.add(ChatColor.GOLD.toString() + "帰還可能な深度 ‣ " + ChatColor.WHITE + whistle.returnDepth)
        lore.add(ChatColor.GOLD.toString() + "エンダーチェストの容量 ‣ " + ChatColor.WHITE + whistle.enderCapacity)
        val meta = item.itemMeta!!
        meta.displayName(Component.text(getWhistleRankDisplay(whistle)))
        meta.lore(ComponentUtil.convertComponentList(lore))
        item.itemMeta = meta
        return item
    }

    private fun getWhistleRankDisplay(whistle: Whistle?): String {
        val type: String = when (whistle!!.type) {
            WhistleType.Red -> "赤笛"
            WhistleType.Blue -> "青笛"
            WhistleType.Moon -> "月笛"
            WhistleType.Black -> "黒笛"
            WhistleType.White -> "白笛"
        }
        return ChatColor.WHITE.toString() + type + " ランク" + whistle.rank
    }
}