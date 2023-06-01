package com.flora30.divelib.data.teleport

import org.bukkit.Location
import org.bukkit.util.BoundingBox

class AreaRegion (
    val layerName: String,
    val loc1: Location,
    val loc2: Location
){
    val box: BoundingBox

    // 後から追加設定
    var to: Location? = null
    var error: Location? = null
    var npcCondition = intArrayOf(-1,-1)

    init {
        val x1: Double = loc1.x
        val y1: Double = loc1.y
        val z1: Double = loc1.z

        val x2: Double = loc2.x
        val y2: Double = loc2.y
        val z2: Double = loc2.z

        box = BoundingBox(x1, y1, z1, x2, y2, z2)
    }

    fun isInArea(loc: Location): Boolean {
        val x = loc.x
        val y = loc.y
        val z = loc.z
        return box.contains(x, y, z)
    }
}