package com.flora30.divelib.data.item

import com.flora30.divelib.data.Rarity

class ItemData (
    val type: ItemType = ItemType.Other,
    val area: String,
    val text: List<String>,
    val rarity: Rarity = Rarity.Normal,
    val money: Double = 0.0,
    val level: Int = 1,
    val food: Int = 0,
    val damage: Int = 0,
    val exp: Int = 0
){
    // 初期状態がnullになっているもの
    // configの設定項目があることとリンク
    var toolData: ToolData? = null
    var ropeData: RopeData? = null
    var artifactData: ArtifactData? = null
    var cookData: CookData? = null
}