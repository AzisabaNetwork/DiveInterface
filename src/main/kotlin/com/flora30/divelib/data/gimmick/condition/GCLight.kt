package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData

class GCLight(
    val light: Int,
    val checkType: Direction,
): GCondition {
    override fun check(data: GData): Boolean {
        return when(checkType){
            Direction.UP ->  data.location.block.lightLevel >= light
            Direction.DOWN -> data.location.block.lightLevel <= light
        }
    }
}