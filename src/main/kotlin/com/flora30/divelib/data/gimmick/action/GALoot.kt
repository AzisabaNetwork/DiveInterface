package com.flora30.divelib.data.gimmick.action

import com.flora30.divelib.data.GData

class GALoot(
    val lootType: String, // 種類
    val level: Int // 列数
): GAction {
    override fun execute(data: GData) {
        // data.player宛て
        // data.locationからlayerNameを取得
        TODO("ルートチェストに種類別データが必要")
    }
}