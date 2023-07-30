package com.flora30.divelib.data.gimmick.condition

import com.flora30.divelib.data.GData
import com.flora30.divelib.data.LayerObject
import com.flora30.divelib.data.gimmick.GimmickObject

class GCSpecial : GCondition {
    override fun check(data: GData): Boolean {
        val layerName = LayerObject.getLayerName(data.location)

        for (region in GimmickObject.specialRegionMap[layerName] ?: return false) {
            if (region.isInArea(data.location)) return true
        }
        return false
    }
}