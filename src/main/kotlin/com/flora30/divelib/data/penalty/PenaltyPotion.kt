package com.flora30.divelib.data.penalty

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class PenaltyPotion (
    val type: PotionEffectType,
    val time: Int,
    val level: Int
): Penalty{
    private final val effect: PotionEffect = PotionEffect(type,time,level,false,false,true)

    override fun execute(player: Player) {
        player.addPotionEffect(effect)
    }

}