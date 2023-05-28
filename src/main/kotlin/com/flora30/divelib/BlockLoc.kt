package com.flora30.divelib

import org.bukkit.Location
import org.bukkit.World
import org.bukkit.block.Block
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class BlockLoc (
    var world: World,
    var x: Int,
    var y: Int,
    var z: Int
){
    constructor(loc: Location) : this(
        loc.world,
        loc.blockX,
        loc.blockY,
        loc.blockZ
    )

    fun getBlock(): Block{
        return  world.getBlockAt(x,y,z)
    }

    fun getLocation(): Location{
        return getBlock().location
    }

    fun distance(otherLoc: BlockLoc): Double{
        return sqrt(
            (x - otherLoc.x+0.0).pow(2)
            + (y - otherLoc.y+0.0).pow(2)
            + (z - otherLoc.z+0.0).pow(2)
        )
    }

    fun add(x: Int, y: Int, z: Int){
        this.x += x
        this.y += y
        this.z += z
    }

    override fun equals(other: Any?): Boolean {
        if (other !is BlockLoc) return false

        // 比較する
        if (this.world != other.world) return false
        return this.x == other.x && this.y == other.y && this.z == other.z
    }

    override fun hashCode(): Int {
        var code: Int = world.name.hashCode()

        // xyz軸の座標, 正負
        code *= 31
        code += isPlus(x)
        code *= 31
        code += abs(x)

        code *= 31
        code += isPlus(y)
        code *= 31
        code += abs(y)

        code *= 31
        code += isPlus(z)
        code *= 31
        code += abs(z)

        return code
    }

    private fun isPlus(n: Int): Int{
        return if (n > 0){
            1
        } else{
            0
        }
    }
}