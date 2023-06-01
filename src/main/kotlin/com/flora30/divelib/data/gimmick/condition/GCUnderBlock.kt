package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData
import org.bukkit.Material

class GCUnderBlock(
    val type: Material
): GCondition {
    override fun check(data: GData): Boolean {
        return data.location.block.type == type
    }
}