package com.flora30.divelib.data

class Point (
    // そのまま適用
    val stamina: Int,
    val health: Int,

    // 割合で適用
    val exp: Int,
    val weapon: Int,
    val artifact: Int,
    val lucky: Int,
    val gatherMonster: Int,
    val gatherRelic: Int

): Cloneable{
    override fun clone(): Any {
        try{
            return super.clone()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
            throw AssertionError()
        }
    }
}