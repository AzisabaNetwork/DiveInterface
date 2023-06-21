package com.flora30.divelib.data.gimmick.action

import com.flora30.divelib.data.GData
import com.flora30.divelib.data.Layer
import com.flora30.divelib.data.LayerObject
import com.flora30.divelib.util.Mathing.getRandomInt
import io.lumine.xikage.mythicmobs.MythicMobs
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter
import io.lumine.xikage.mythicmobs.mobs.MythicMob

class GASpawnLayerMob(
    val spawnType: SpawnType
): GAction {
    override fun execute(data: GData) {
        // Mobを取得
        val layerName = LayerObject.getLayerName(data.location) ?: return
        val mob = getRandomMob(layerName) ?: return

        // 召喚する
        mob.spawn(BukkitAdapter.adapt(data.location), 1.0)
    }

    private fun getRandomMob(layerName: String): MythicMob?{
        val mobDataList: List<Layer.MobData> = LayerObject.layerMap[layerName]?.mobMap?.get(spawnType) ?: return null

        var calcedRate = 0.0
        val randomized = getRandomInt(100)
        for (data in mobDataList) {
            val rate: Double = calcedRate + data.rate
            if (randomized <= rate) {
                return MythicMobs.inst().apiHelper.getMythicMob(data.mobName)
            }
            calcedRate = rate
        }

        return null
    }
}