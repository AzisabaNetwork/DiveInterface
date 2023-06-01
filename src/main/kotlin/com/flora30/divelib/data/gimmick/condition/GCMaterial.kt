package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData
import org.bukkit.Material

class GCMaterial(
    val material: Material
): GCondition {
    override fun check(data: GData): Boolean {
        return data.location.block.type == material;
    }
}