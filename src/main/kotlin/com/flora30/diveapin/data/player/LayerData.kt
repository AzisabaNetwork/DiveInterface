package com.flora30.diveapin.data.player

class LayerData (
    var storySpeed: Int = 40,
    var curse: Double = 0.0,
    var lootLayer: String? = null,

    // セーブ無し
    var layer: String? = null,
    var openLootLocID: Int = 0
){
    // ID | ルートレベル
    val lootMap = hashMapOf<Int,Int>()

    // 行ったことのあるエリア
    val visitedLayers = hashSetOf<String>()

}