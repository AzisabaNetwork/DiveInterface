package com.flora30.diveapin.util

import org.bukkit.Location
import org.bukkit.util.Vector
import java.util.*
import kotlin.math.cos
import kotlin.math.sin

object Mathing {

    private fun vectorFromLoc(a: Double, b: Double): Double {
        return Math.sqrt(a * a + b * b)
    }

    fun getSimpleXFromYaw(yaw: Double): Double {
        var yaw = yaw
        if (yaw < 0) {
            yaw += 360.0
        }
        return -sin(Math.toRadians(yaw))
    }

    fun getSimpleZFromYaw(yaw: Double): Double {
        var yaw = yaw
        if (yaw < 0) {
            yaw += 360.0
        }
        return cos(Math.toRadians(yaw))
    }

    fun getSimpleYFromPitch(pitch: Double): Double {
        var pitch = pitch
        if (pitch < 0) {
            pitch += 360.0
        }
        return sin(Math.toRadians(pitch))
    }

    fun getLocationsBetweenTwo(a: Location, b: Location, space: Double, maxLength: Double): List<Location> {
        val list: MutableList<Location> = ArrayList()
        //aとbの間のベクトル（b-a）
        val vector = Vector(b.x - a.x, b.y - a.y, b.z - a.y)
        vector.normalize()
        vector.multiply(space)
        //aがbを越えた判定・・・長さがmaxを越えた時|長さ＝current
        var currentRange = space
        a.add(vector)
        while (currentRange <= maxLength) {
            //範囲を登録
            list.add(a)
            //その後ベクトルを足す
            a.add(vector)
            currentRange += space
            //ここで次の判定
        }
        return list
    }

    fun getInt(str: String): Int {
        val i: Int = try {
            str.toInt()
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            -1
        }
        return i
    }

    fun getDouble(str: String): Double {
        val d: Double = try {
            str.toDouble()
        } catch (e: NullPointerException) {
            e.printStackTrace()
            -1.0
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            -1.0
        }
        return d
    }

    //0～maxのランダム
    fun getRandomInt(max: Int?): Int {
        val ran = Random()
        return ran.nextInt(max!!)
    }

}