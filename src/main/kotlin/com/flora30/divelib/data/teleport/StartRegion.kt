package com.flora30.divelib.data.teleport

import com.flora30.divelib.util.Mathing
import org.bukkit.Location
import org.bukkit.util.BoundingBox

class StartRegion (
    val loc1: Location,
    val loc2: Location
    ){
    val box: BoundingBox

    // 後から追加
    val locations = arrayListOf<Location>()

    init {
        val x1 = loc1.x
        val y1 = loc1.y
        val z1 = loc1.z

        val x2 = loc2.x
        val y2 = loc2.y
        val z2 = loc2.z

        box = BoundingBox(x1,y1,z1,x2,y2,z2)
    }

    fun getRandomLocation(): Location? {
        val random: Int = Mathing.getRandomInt(locations.size - 1)
        return try {
            locations[random]
        } catch (e: IndexOutOfBoundsException) {
            null
        }
    }

    fun isInArea(loc: Location): Boolean {
        val x = loc.x
        val y = loc.y
        val z = loc.z
        return box.contains(x, y, z)
    }
}