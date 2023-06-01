package com.flora30.divelib.data.teleport

import org.bukkit.Particle
import org.bukkit.entity.Player

class RelateParticle (
    val x: Double,
    val y: Double,
    val z: Double,
    val particle: Particle,
    val speed: Double
){
    fun spawnParticle(player: Player) {
        val loc = player.location.clone()
        loc.add(x,y,z)
        player.spawnParticle(particle,loc,1, 0.0, 0.0, 0.0,speed)
    }
}