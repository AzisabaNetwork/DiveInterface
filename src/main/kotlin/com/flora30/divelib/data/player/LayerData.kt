package com.flora30.divelib.data.player

import com.flora30.divelib.BlockLoc
import com.flora30.divelib.data.gimmick.GimmickLog
import org.bukkit.Location

class LayerData (
    var storySpeed: Int = 40,
    var curse: Double = 0.0,
    var lootLayer: String? = null,
    // 場所 | ルートチェストのデータ
    val lootMap: HashMap<Location,LootData>,
    // 行ったことのあるエリア
    val visitedLayers: HashSet<String>,
    // プレイヤー依存のギミックログ
    val gimmickLogs: HashSet<GimmickLog>,

    // セーブ無し
    var layer: String? = null,
    var openLootLocID: Int = 0
){
    fun isLootLocation(blockLoc: BlockLoc): Boolean{
        for (lootLoc in lootMap.keys){
            if (blockLoc.z == lootLoc.blockZ && blockLoc.y == lootLoc.blockY && blockLoc.x == lootLoc.blockZ) {
                return true
            }
        }
        return false
    }
}