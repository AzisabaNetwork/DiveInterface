package com.flora30.divelib.data.player

import com.comphenix.protocol.events.PacketContainer
import org.bukkit.Location
import org.bukkit.boss.BossBar

class PlayerData(
    val levelData: LevelData,
    val npcData: NpcData,
    val layerData: LayerData,
    val helpIdSet: HashSet<Int>,
    val foundRecipeSet: HashSet<Int>,
    val completedRecipeSet: HashSet<Int>,
    var isFirstJoin: Boolean,
    var money: Int,

    ) {
    // セーブしないもの
    val chatStackList: List<PacketContainer> = ArrayList()
    var afkLocation: Location? = null
    var afkTime = 0
    val sidebarId: Int = PlayerDataObject.getUniqueSideBarID()
    var maxST = 0
    var currentST = 0
    var food = 0
    var bossBar: BossBar? = null
    val coolDownMap: Map<String,Int> = HashMap()
    var displayCoolDownName: String ?= null
    val gatherBedrockMap: Map<Location,Int> = HashMap()

}