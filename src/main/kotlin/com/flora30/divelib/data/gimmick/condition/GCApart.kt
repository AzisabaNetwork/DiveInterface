package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData

/**
 * 一定距離以上、自分から離れているか
 */
class GCApart (
    val amount: Int,
): GCondition{
    override fun check(data: GData): Boolean {
        return data.location.distance(data.player.location) >= amount
    }
}