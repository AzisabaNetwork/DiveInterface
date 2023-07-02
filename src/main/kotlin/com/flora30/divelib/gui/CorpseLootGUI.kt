package com.flora30.divelib.gui

import com.flora30.divelib.ItemMain
import com.flora30.divelib.data.Layer
import com.flora30.divelib.data.PointObject
import com.flora30.divelib.data.gimmick.action.ChestType
import com.flora30.divelib.data.item.ItemDataObject
import com.flora30.divelib.data.loot.LootObject
import com.flora30.divelib.data.player.PlayerDataObject
import com.flora30.divelib.event.HelpEvent
import com.flora30.divelib.event.HelpType
import com.flora30.divelib.util.GuiItem
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import kotlin.math.roundToInt

object CorpseLootGUI {
    fun open(player: Player, layer: Layer, type: ChestType) {
        if (PlayerDataObject.playerDataMap[player.uniqueId] == null) return
        Bukkit.getPluginManager().callEvent(HelpEvent(player, HelpType.LootChestGUI))
        val gui = create(player, layer, type)
        if (gui == null) {
            Bukkit.getLogger().info("type = "+type)
            Bukkit.getLogger().info("lootIDList = "+layer.lootIDList[type])
            Bukkit.getLogger().info("lootItemList = "+ LootObject.lootItemMap[layer.lootIDList[type]])
            return
        }
        player.openInventory(gui)
    }


    private fun create(player: Player, layer: Layer, type: ChestType): Inventory? {
        val data = PlayerDataObject.playerDataMap[player.uniqueId]!!.levelData
        // ラッキーチェスト判定は行わない
        //名前の＋を取り出してGUIを新規作成
        val maxSlot = (2 + (Math.random() * 4)).toInt()
        val gui = Bukkit.createInventory(null, maxSlot, Component.text("探窟家の死体"))
        var slotPlaced = 0

        //報酬の配置
        val itemList: ArrayList<LootObject.ItemAmount> = LootObject.lootItemMap[layer.lootIDList[type]] ?: return null
        val slotList = arrayOf(3,4,5,
                                12,13,14,
                                21,22,23).toMutableList()
        slotList.shuffle()

        // 背景の調整
        GuiItem.grayBack(gui)
        for (slot in slotList){
            gui.setItem(slot,null)
        }


        //報酬リストを回す
        for (ia in itemList) {
            val iData = ItemDataObject.itemDataMap[ia.itemId] ?: continue
            val rate = ItemDataObject.dropRateMap[iData.rarity]!!

            //入手するかの判定
            var item: ItemStack?
            if (Math.random() <= rate) {
                //アイテムの取得
                item = ItemMain.getItem(ia.itemId)
                item!!.amount = ia.amount
            } else {
                //レアドロップ失敗時：アイテムを失敗時のものに変更
                item = ItemMain.getItem(LootObject.failedLoot!!.itemId)
                item!!.amount = LootObject.failedLoot!!.amount
            }

            //gui上にランダム配置
            var guiSlot = slotList[slotPlaced]
            while (gui.getItem(guiSlot) != null) {
                guiSlot++
                if (guiSlot >= maxSlot) {
                    guiSlot = 0
                }
            }
            gui.setItem(guiSlot, item)
            slotPlaced++

            //インベントリが埋まったら抜ける
            if (slotPlaced >= maxSlot) {
                break
            }
        }
        return gui
    }
}