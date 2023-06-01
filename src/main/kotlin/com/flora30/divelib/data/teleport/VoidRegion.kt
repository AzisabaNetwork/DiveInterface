package com.flora30.divelib.data.teleport

import org.bukkit.Location

class VoidRegion (
    val centerPoint: Location, // 中心
    val range: Int, // 範囲
    var next: String?, // 次層id
    var before: String? // 前層id
){
}