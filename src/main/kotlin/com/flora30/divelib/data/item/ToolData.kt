package com.flora30.divelib.data.item

import org.bukkit.Material

class ToolData (
    val toolType: ToolType = ToolType.None,
    val dropRate: Float = 1.0F,
    val maxDepth: Int = 100,
    val breakableMaterialSet: Set<Material> = HashSet()
){
}