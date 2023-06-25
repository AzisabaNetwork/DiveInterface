package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData
import com.flora30.divelib.util.BlockUtil

// rule true -> 通れるか？
// rule false -> 通れないか？
class GCMovable(
    val rule: Boolean
): GCondition {
    override fun check(data: GData): Boolean {
        if (rule && BlockUtil.isIgnoreBlockType(data.location.block)) return true
        if (!rule && !(BlockUtil.isIgnoreBlockType(data.location.block))) return true

        return false
    }
}