package com.flora30.divelib.data

import com.flora30.divelib.data.item.ToolType
import org.bukkit.Location
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Layer (
    val layerArea: LayerArea,
    val displayName: String,
    val groupName: String,
    val fall: Int,
    val isTown: Boolean,
    val exp: Int,
    val story: Story,
    val gimmickList: MutableList<String>
){

    fun isInRange(location: Location):Boolean {
        if (location.world == null || location.world.name != layerArea.world) return false
        if (location.blockX < layerArea.minX || layerArea.maxX < location.blockX) return false
        if (location.blockY < layerArea.minY || layerArea.maxY < location.blockY) return false
        if (location.blockZ < layerArea.minZ || layerArea.maxZ < location.blockZ) return false
        return true
    }

}