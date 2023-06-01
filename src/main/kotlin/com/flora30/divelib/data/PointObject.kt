package com.flora30.divelib.data

object PointObject {
    // ポイントを入れた時に追加
    val intMap: Map<Int, Point> = HashMap()
    val vitMap: Map<Int, Point> = HashMap()
    val atkMap: Map<Int, Point> = HashMap()
    val lucMap: Map<Int, Point> = HashMap()

    // 現在のポイントで適用
    val intApplyMap: Map<Int, Point> = HashMap()
    val vitApplyMap: Map<Int, Point> = HashMap()
    val atkApplyMap: Map<Int, Point> = HashMap()
    val lucApplyMap: Map<Int, Point> = HashMap()

    // 数値系
    fun getStamina(point: Int): Int{
        if (point > vitApplyMap.size || point == 0) return 0
        return vitApplyMap[point]?.stamina ?: 0
    }
    fun getHealth(point: Int): Int{
        if (point > vitApplyMap.size || point == 0) return 0
        return vitApplyMap[point]?.health ?: 0
    }

    // 倍率系
    fun getExpRate(point: Int): Double{
        if (point > intApplyMap.size || point == 0) return 1.0
        return (100.0 + intApplyMap[point]?.exp!!) / 100.0
    }
    fun getAttackRate(point: Int): Double{
        if (point > atkApplyMap.size || point == 0) return 1.0
        return (100.0 + atkApplyMap[point]?.weapon!!) / 100.0
    }
    fun getArtifactRate(point: Int): Double{
        if (point > atkApplyMap.size || point == 0) return 1.0
        return (100.0 + atkApplyMap[point]?.artifact!!) / 100.0
    }
    fun getLuckyRate(point: Int): Double{
        if (point > lucApplyMap.size || point == 0) return 1.0
        return (lucApplyMap[point]?.lucky!!) / 100.0
    }
    fun getGatherRelicRate(point: Int): Double{
        if (point > lucApplyMap.size || point == 0) return 1.0
        return (100.0 + lucApplyMap[point]?.gatherRelic!!) / 100.0
    }
    fun getGatherMonsterRate(point: Int): Double{
        if (point > intApplyMap.size || point == 0) return 1.0
        return (100.0 + intApplyMap[point]?.gatherMonster!!) / 100.0
    }

}