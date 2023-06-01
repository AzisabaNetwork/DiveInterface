package com.flora30.divelib.data.talk

import com.flora30.divelib.data.talk.Talk

class NPC (
    val npcId: Int,
    val name: String,

    // 会話進捗 | 会話リスト
    val talks: List<List<Talk>>
){
}