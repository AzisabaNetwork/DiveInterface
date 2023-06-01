package com.flora30.divelib.data.teleport

import org.bukkit.Location
import org.bukkit.util.Vector

object TeleportObject {

    // ID | 範囲テレポート用の範囲
    val areaMap = hashMapOf<String, AreaRegion>()

    // LayerID | 奈落テレポート用の範囲
    val voidMap = hashMapOf<String, VoidRegion>()
    // 奈落テレポート用のパーティクル
    val voidParticles = hashSetOf<RelateParticle>()


    // layerID | 開始テレポート用の範囲
    val startMap = hashMapOf<String, StartRegion>()

    // 初期地点
    val returnPoint: Location? = null

    /**
     * 上下の階層へ行くためのVector
     * @param isUnder trueの場合は下の階層
     */
    fun getLayerVector(from: String?, isUnder: Boolean): Vector? {
        if (!voidMap.keys.contains(from)) return null
        val fromRegion: VoidRegion = voidMap[from] ?: return null
        val center: Location = fromRegion.centerPoint
        val otherCenter: Location

        // 他の階層を取得
        val vector = Vector()
        if (isUnder) {
            if (fromRegion.next == null) return null
            otherCenter = voidMap[fromRegion.next]?.centerPoint ?: return null
            vector.setY(150)
        } else {
            if (fromRegion.before == null) return null
            otherCenter = voidMap[fromRegion.before]?.centerPoint ?: return null
            vector.setY(-150)
        }

        // 他の階層へのVectorを計算
        vector.x = otherCenter.x - center.x
        vector.z = otherCenter.z - center.z
        return vector
    }
}