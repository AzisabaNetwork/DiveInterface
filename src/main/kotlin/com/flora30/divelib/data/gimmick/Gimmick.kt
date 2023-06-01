package com.flora30.divelib.data.gimmick

import com.flora30.divelib.data.gimmick.action.GAction
import com.flora30.divelib.data.gimmick.condition.GCondition

class Gimmick(
    val conditions: ArrayList<GCondition>,
    val actions: ArrayList<GAction>
) {
}