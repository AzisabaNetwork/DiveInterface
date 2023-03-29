package com.flora30.data.player

import com.comphenix.protocol.events.PacketContainer
import org.bukkit.Location

class PlayerData(
    val levelData: LevelData,
    val npcData: NpcData,
    val layerData: LayerData,
    val helpIdSet: HashSet<Int>,
    val foundRecipeSet: HashSet<Int>,
    val completedRecipeSet: HashSet<Int>,
    val isFirstJoin: Boolean,
    val money: Int,


) {
    // セーブしないもの
    val chatStackList: List<PacketContainer> = ArrayList()
    val afkLocation: Location? = null
    val afkTime = 0

    // sidebarIdから続き
}