package com.flora30.divelib.data

import org.bukkit.Location
import org.bukkit.block.BlockFace

class BaseLocation(
    val location: Location,
    val face: BlockFace,
    val isTown : Boolean
) {
}