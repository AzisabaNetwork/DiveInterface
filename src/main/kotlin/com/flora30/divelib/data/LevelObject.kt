package com.flora30.divelib.data

object LevelObject {
    // レベル | 必要経験値
    val expMap: Map<Int,Int> = HashMap()

    // 次のレベルへの必要経験値
    fun getNextExp(level: Int): Int {
        return expMap.getOrDefault(level+1,999999)
    }

    // 最大レベル
    fun getMaxLevel(): Int{
        return expMap.keys.size - 1
    }
}