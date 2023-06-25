package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData
import com.flora30.divelib.util.EntityUtil
import io.lumine.xikage.mythicmobs.MythicMobs

class GCNearMob(
    val range: Int,
    val turn: Boolean // 判定があった時に何を返すか
): GCondition {
    override fun check(data: GData): Boolean {
        val entities = EntityUtil.getNearEntities(data.location,range)
        for (entity in entities){
            if (MythicMobs.inst().apiHelper.isMythicMob(entity)) return getTurn(true)
        }

        return getTurn(false)
    }

    private fun getTurn(isExist: Boolean): Boolean{
        return if (isExist){
            turn
        } else{
            !turn
        }
    }
}