package com.flora30.divelib.data.loot

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.block.BlockFace

class LootLocation (
    val world: String,
    val blockX: Int,
    val blockY: Int,
    val blockZ: Int,
    val face: BlockFace,
    var isPrepared: Boolean
){
    fun getLocation(): Location? {
        val world: World? = Bukkit.getWorld(this.world)
        if (world == null) {
            Bukkit.getLogger().info("[DiveCore-Loot]生成 - ワールドの取得に失敗しました")
            return null
        }
        return world.getBlockAt(blockX, blockY, blockZ).location
    }

    fun check(location: Location): Boolean {
        if (location.world == null || location.world.name != world) {
            return false
        }
        if (location.blockX != blockX) {
            return false
        }
        return if (location.blockY != blockY) {
            false
        } else location.blockZ == blockZ
    }
}