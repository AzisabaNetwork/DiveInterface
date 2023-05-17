package com.flora30.diveapin.data.player

import java.util.*
import kotlin.collections.HashMap

object PlayerDataObject {
    val playerDataMap: Map<UUID, PlayerData> = HashMap()

    private var uniqueId = 0
    fun getUniqueSideBarID(): Int{
        uniqueId++
        return uniqueId
    }
}