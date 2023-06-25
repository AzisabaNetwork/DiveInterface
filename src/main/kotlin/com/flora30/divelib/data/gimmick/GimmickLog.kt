package com.flora30.divelib.data.gimmick

import org.bukkit.Location

data class GimmickLog(
    val location: Location,
    val gimmickID: String,
    val time: Long
) {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is GimmickLog) return false

        if (this.time != other.time) return false
        if (this.gimmickID != other.gimmickID) return false

        return this.location == other.location
    }

    override fun hashCode(): Int {
        var hash = 2;

        hash = 31 * hash + location.hashCode()
        hash = 31 * hash + gimmickID.hashCode()
        hash = 31 * hash + time.hashCode()

        return hash
    }
}