package com.flora30.divelib.data.penalty

import org.bukkit.entity.Player

interface Penalty {
    fun execute(player: Player)
}