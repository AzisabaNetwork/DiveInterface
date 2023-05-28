package com.flora30.diveapin.data

import com.flora30.diveapin.BlockLoc
import org.bukkit.entity.Player
import java.util.*

class Rope (
    // ロープのItemID
    val id: Int,

    // 置いたプレイヤー
    val owner: UUID,

    // ロープを構成する座標
    val locations: List<BlockLoc>,

    // ロープを構成する座標（上下の階層）
    val alterLocations: List<BlockLoc>?,

    // 上昇ロープ
    val isUpper: Boolean,

    // 見ているプレイヤー
    val lookingPlayers: Set<Player>
){
    // ロープの周囲に人がいない回数
    var failCount: Int = 0

    fun isNear(player: Player): Boolean{

        val playerLoc = BlockLoc(player.location)

        val first: BlockLoc = locations[0]
        val last: BlockLoc = locations[locations.size-1]
        val alterFirst: BlockLoc? = alterLocations?.get(0)
        val alterLast: BlockLoc? = alterLocations?.get(alterLocations.size-1)

        // locations の判定
        if (first.world === playerLoc.world) {
            if (first.distance(playerLoc) <= RopeObject.showRange) {
                return true
            }
            if (last.distance(playerLoc) <= RopeObject.showRange) {
                return true
            }
        }

        // alterLocations の判定
        if (alterFirst == null || alterLast == null) return false
        return if (alterFirst.world == playerLoc.world) {
            if (alterFirst.distance(playerLoc) <= RopeObject.showRange) {
                true
            } else alterLast.distance(playerLoc) <= RopeObject.showRange
        } else false
    }
}