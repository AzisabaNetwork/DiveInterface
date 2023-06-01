package com.flora30.divelib.data.penalty

import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player

class PenaltyMaxHPDamage (
    val amount: Int // 最大HPを減少させる量
): Penalty{
    override fun execute(player: Player) {
        val maxHP = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)
        if (maxHP == null) {
            Bukkit.getLogger().info("[DiveCore-Penalty]maxHP=null | player : " + player.displayName())
            return
        }
        val current = maxHP.baseValue
        if(current - amount >= 0) {
            player.health = 0.0
        }else{
            maxHP.baseValue = current - amount
        }

    }
}