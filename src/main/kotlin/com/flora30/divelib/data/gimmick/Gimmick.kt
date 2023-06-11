package com.flora30.divelib.data.gimmick

import com.flora30.divelib.data.gimmick.action.GAction
import com.flora30.divelib.data.gimmick.condition.GCondition

class Gimmick(
    val conditions: ArrayList<GCondition>,
    val actions: ArrayList<GAction>,
    val spawnRate: Int,
    val group: String,
    val random: Double, // 0 ~ 1
    val logTime: Int
) {
}