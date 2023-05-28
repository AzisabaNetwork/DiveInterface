package com.flora30.divelib.data

import com.flora30.divelib.BlockLoc
import com.flora30.divelib.DiveLib
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player

object RopeObject {
    val ropeSet = hashSetOf<Rope>()

    var showRange: Int = 20

    /**
     * ロープを表示する
     */
    fun display(rope: Rope, player: Player, isInstant: Boolean) {
        // 最後のブロック
        val lastMaterial = if (rope.isUpper) Material.SCAFFOLDING else Material.BARREL
        // 演出時間
        val effectTime = if (isInstant) 0 else 2

        // ロープの生成演出
        val size = rope.locations.size
        val alterSize = rope.alterLocations!!.size
        for (i in 0 until size - 1) {
            DiveLib.plugin.delayedTask(i * effectTime) {
                player.sendBlockChange(rope.locations[i].getLocation(), Material.SCAFFOLDING.createBlockData())
                if (!isInstant) {
                    player.playSound(rope.locations[i].getLocation(), Sound.BLOCK_LADDER_PLACE, 1f, 1f)
                }
            }
        }
        DiveLib.plugin.delayedTask(size * effectTime) {
            player.sendBlockChange(
                rope.locations[rope.locations.size - 1].getLocation(), lastMaterial.createBlockData()
            )
        }
        // ロープの生成演出
        for (i in 0 until alterSize - 1) {
            DiveLib.plugin.delayedTask(i * effectTime) {
                player.sendBlockChange(
                    rope.alterLocations[i].getLocation(),
                    Material.SCAFFOLDING.createBlockData()
                )
                if (!isInstant) {
                    player.playSound(
                        rope.alterLocations[i].getLocation(),
                        Sound.BLOCK_LADDER_PLACE,
                        1f,
                        1f
                    )
                }
            }
        }
        if (alterSize != 0) {
            DiveLib.plugin.delayedTask(alterSize * effectTime) {
                player.sendBlockChange(
                    rope.alterLocations[rope.alterLocations.size - 1].getLocation(), lastMaterial.createBlockData()
                )
            }
        }
    }

    fun isRopeLocation(player: Player, loc: Location): Boolean {
        val blockLoc = BlockLoc(loc)
        return isRopeLocation(player, blockLoc)
    }

    fun isRopeLocation(player: Player, blockLoc: BlockLoc): Boolean {
        // エラーでやり直し（setが変更された）
        while (true) {
            try {
                for (rope in ropeSet) {
                    if (!rope.lookingPlayers.contains(player)) {
                        continue
                    }

                    //ここが重い
                    if (isInRope(blockLoc, rope)) return true
                }
                return false
            } catch (ignored: ConcurrentModificationException) {
            }
        }
    }

    fun isInRope(loc: BlockLoc, rope: Rope): Boolean {
        return if (rope.locations.contains(loc)) true else rope.alterLocations?.contains(loc) ?: false
    }
}