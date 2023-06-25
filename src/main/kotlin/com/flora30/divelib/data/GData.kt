package com.flora30.divelib.data

import org.bukkit.Location
import org.bukkit.entity.Player

// ギミック用に取得するデータ
class GData(
    val player: Player,
    val location: Location,
    val gimmickID: String // 配置予定のギミック
) {
}