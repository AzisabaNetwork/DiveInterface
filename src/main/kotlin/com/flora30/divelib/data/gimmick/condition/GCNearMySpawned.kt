package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData
import com.flora30.divelib.data.gimmick.GimmickObject
import com.flora30.divelib.data.player.PlayerDataObject

class GCNearMySpawned (
    val range: Int,
    val turn: Boolean // 判定があった時に何を返すか
): GCondition {
    override fun check(data: GData): Boolean {
        val layerData = PlayerDataObject.playerDataMap[data.player.uniqueId]?.layerData ?: return false

        for (log in layerData.gimmickLogs){
            if (log.location.distance(data.location) < range){
                if (GimmickObject.gimmickMap[log.gimmickID] == GimmickObject.gimmickMap[data.gimmickID]){
                    return getTurn(true)
                }
            }
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