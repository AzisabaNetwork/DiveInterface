package com.flora30.divelib.data.talk

import org.bukkit.entity.Player

abstract class Check (
    val failed: String
): Talk{
    private val failedText: TalkText = TalkText(failed)
    private var loop = TalkLoop(1)

    /**
     * 実装が必要
     */
    abstract fun check(player: Player, npc: NPC): Boolean

    override fun talk(player: Player, npc: NPC) {
        check(player,npc)
    }

    fun falsedText(player: Player, npc: NPC){
        failedText.talk(player, npc)
        loop.talk(player, npc)
    }
}