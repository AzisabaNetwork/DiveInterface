package com.flora30.divelib.data.player

class LayerData (
    var storySpeed: Int = 40,
    var curse: Double = 0.0,
    var lootLayer: String? = null,
    // ID | ルートレベル
    val lootMap: HashMap<Int,Int>,
    // 行ったことのあるエリア
    val visitedLayers: HashSet<String>,

    // セーブ無し
    var layer: String? = null,
    var openLootLocID: Int = 0
){

}