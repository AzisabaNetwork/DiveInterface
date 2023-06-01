package com.flora30.divelib.data.penalty

import org.bukkit.entity.Player

class PenaltyDamage (
    val amount: Int
): Penalty{
    override fun execute(player: Player) {
        player.damage(amount.toDouble())
    }
}