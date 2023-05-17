package com.flora30.diveapin.util

import io.lumine.xikage.mythicmobs.MythicMobs
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.entity.Entity

object DMythicUtil {
    fun spawnMob(mobName: String, location: Location): Entity? {
        return try {
            MythicMobs.inst().apiHelper.spawnMythicMob(mobName, location)
        } catch (e: InvalidMobTypeException){
            Bukkit.getLogger().info("" + ChatColor.YELLOW + "[DiveCore-Mythic] Mob名 " + mobName + " が見つかりません")
            null
        }
    }
}