package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData
import org.bukkit.Material

class GCNearBlock(
    val direction: Direction, // 検知する方向
    val length: Int, // 距離
    val type: Material // その場所のブロックの種類
): GCondition {
    override fun check(data: GData): Boolean {
        val location = data.location.clone();

        return when(direction){
            Direction.UP -> {
                location.add(0.0, length.toDouble(),0.0)
                location.block.type == type
            }

            Direction.DOWN -> {
                location.add(0.0,-length.toDouble(),0.0)
                location.block.type == type
            }
        }
    }
}