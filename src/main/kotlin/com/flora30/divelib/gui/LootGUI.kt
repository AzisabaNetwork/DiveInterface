package com.flora30.divelib.gui

import com.flora30.divelib.ItemMain.getItem
import com.flora30.divelib.data.Layer
import com.flora30.divelib.data.PointObject.getLuckyRate
import com.flora30.divelib.data.gimmick.action.ChestType
import com.flora30.divelib.data.item.ItemDataObject.dropRateMap
import com.flora30.divelib.data.item.ItemDataObject.itemDataMap
import com.flora30.divelib.data.loot.LootObject
import com.flora30.divelib.data.loot.LootObject.failedLoot
import com.flora30.divelib.data.loot.LootObject.lootLevelList
import com.flora30.divelib.data.player.PlayerDataObject.playerDataMap
import com.flora30.divelib.event.HelpEvent
import com.flora30.divelib.event.HelpType
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

object LootGUI {
    fun open(player: Player, layer: Layer, type: ChestType, level: Int) {
        if (playerDataMap[player.uniqueId] == null) return
        Bukkit.getPluginManager().callEvent(HelpEvent(player, HelpType.LootChestGUI))
        val gui = create(player, layer, type, level)
        if (gui == null) {
            Bukkit.getLogger().info("type = "+type)
            Bukkit.getLogger().info("lootIDList = "+layer.lootIDList[type])
            Bukkit.getLogger().info("lootItemList = "+LootObject.lootItemMap[layer.lootIDList[type]])
            return
        }
        player.openInventory(gui)
    }


    private fun create(player: Player, layer: Layer, type: ChestType, level: Int): Inventory? {
        val data = playerDataMap[player.uniqueId]!!.levelData
        //プレイヤーデータの取得
        val luckyRate = getLuckyRate(data.pointLuc)
        //Bukkit.getLogger().info("[Loot]LuckyRate = "+luckyRate);

        //ラッキーチェスト判定
        val isLucky = Math.random() <= luckyRate
        //演出
        if (isLucky) {
            player.sendMessage("豪華なチェストを見つけた！")
            player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f)
            player.playSound(player.location, Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1f, 1f)
            player.spawnParticle(Particle.FLAME, player.location, 20, 0.1, 0.1, 0.1, 0.1)
        }

        //名前の＋を取り出してGUIを新規作成
        val maxSlot = lootLevelList[level].chestSlot
        val plus = lootLevelList[level].titlePlus
        val gui = Bukkit.createInventory(null, maxSlot, Component.text("宝箱 $plus"))
        var slotPlaced = 0

        //報酬の配置
        val itemList: ArrayList<LootObject.ItemAmount> = LootObject.lootItemMap[layer.lootIDList[type]] ?: return null
        val slotList = (0 until itemList.size).toMutableList()
        slotList.shuffle()
        //報酬リストを回す
        for (slot in slotList) {
            val ia = itemList[slot]
            val iData = itemDataMap[ia.itemId] ?: continue
            val rate = dropRateMap[iData.rarity]!!

            //入手するかの判定
            var item: ItemStack?
            if (Math.random() <= rate) {
                //アイテムの取得
                item = getItem(ia.itemId)
                item!!.amount = ia.amount
            } else {
                //レアドロップ失敗時：アイテムを失敗時のものに変更
                item = getItem(failedLoot!!.itemId)
                item!!.amount = failedLoot!!.amount
            }

            //gui上にランダム配置
            var guiSlot = (Math.random() * (gui.size - 1)).roundToInt()
            while (gui.getItem(guiSlot) != null) {
                guiSlot++
                if (guiSlot >= maxSlot) {
                    guiSlot = 0
                }
            }
            gui.setItem(guiSlot, item)
            slotPlaced++

            //インベントリが埋まったら抜ける
            if (isLucky) {
                if (slotPlaced >= gui.size) {
                    break
                }
            } else if (slotPlaced >= gui.size / 3) {
                break
            }
        }
        return gui
    }
}