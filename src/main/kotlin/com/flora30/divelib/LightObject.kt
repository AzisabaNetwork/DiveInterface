package com.flora30.diveapin

import org.bukkit.entity.Player
import javax.xml.stream.Location

object LightObject {
    // 光の場所
    val lightLocations: Map<BlockLoc,Int> = HashMap()

    // 水中にする場所
    val waters: Set<BlockLoc> = HashSet()

}