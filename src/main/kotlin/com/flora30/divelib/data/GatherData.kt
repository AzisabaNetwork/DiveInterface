package com.flora30.divelib.data

import com.flora30.divelib.data.item.ToolType
import java.util.*
import kotlin.collections.HashMap

class GatherData {
    // 採掘用のデータ
    // 採掘ツール | 通常ドロップのアイテムID
    val normalDropMap: Map<ToolType,Int> = EnumMap(ToolType::class.java)
    // 遺物のアイテムID | 確率
    val relicRateMap: Map<Int,Float> = HashMap()
    // 採掘中に出現する敵 | 確率
    val monsterMap: Map<String,Float> = HashMap()
    // 釣り中に出現する敵 | 確率
    val fishMonsterMap: Map<String,Float> = HashMap()

    // 採掘中に出現する敵を選択
    fun getRandomMob(): String?{
        var n = 0.0F
        for (mobId: String in monsterMap.keys){
            n += monsterMap[mobId] ?: continue
            if (Math.random() <= n) return mobId
        }
        return null
    }
    // 釣り中に出現する敵を選択
    fun getRandomFishMob(): String?{
        var n = 0.0F
        for (mobId: String in fishMonsterMap.keys){
            n += fishMonsterMap[mobId] ?: continue
            if (Math.random() <= n) return mobId
        }
        return null
    }
}