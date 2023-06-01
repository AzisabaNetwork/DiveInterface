package com.flora30.divelib.data

import com.flora30.divelib.DiveLib
import com.flora30.divelib.data.penalty.Penalty
import org.bukkit.Location
import java.io.File

object LayerObject {
    // 階層ID | 階層データ
    val layerMap = hashMapOf<String, Layer>()
    // 階層ID | 上昇負荷
    val penaltyMap = hashMapOf<String,List<Penalty>>()

    // 階層ID | 採掘データ
    val gatherMap = hashMapOf<String, GatherData>()

    // Layerの設定ファイルの場所
    val layerFile: Array<File> = File(DiveLib.plugin.dataFolder.absolutePath + "/area").listFiles()

    // 階層ID | Mobデータ
    val mobMap = hashMapOf<String,List<MobData>>()
    data class MobData(val mobName: String, val rate: Double)


    fun getLayerName(location: Location):String? {
        return layerMap.keys.firstOrNull { layerMap[it]!!.isInRange(location) }
    }

    fun getDepth(location: Location): Double{
        val layerName = getLayerName(location)
        if (layerName == null || layerName == "oldOrth") return 0.0
        val fallPlus = 200 - location.y
        val fallLayer = layerMap[layerName]!!.fall
        return fallPlus + fallLayer
    }
}