package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData
import org.bukkit.Location
import org.bukkit.entity.Player

interface GCondition {
    fun check(data: GData): Boolean
}