package com.flora30.divelib.data.loot

import org.bukkit.Material
import org.bukkit.Particle

class LootLevel (
    //yml
    val titlePlus: String = "Lv.1",
    val chestSlot: Int = 9,
    val percent: Double = 0.0,
    var particle: Particle = Particle.END_ROD,
    var material: Material = Material.CHEST
){
}