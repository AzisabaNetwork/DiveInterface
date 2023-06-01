package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData

class GCDistance (
    val distance: Int,
    val checkType: Direction
): GCondition{
    override fun check(data: GData): Boolean {
        return when (checkType) {
            // 指定より距離が大きい？
            Direction.UP -> data.location.distance(data.player.location) >= distance
            // 指定より距離が小さい？
            Direction.DOWN -> data.location.distance(data.player.location) <= distance
        }
    }
}