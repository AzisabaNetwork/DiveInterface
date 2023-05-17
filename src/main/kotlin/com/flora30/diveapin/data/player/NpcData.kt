package com.flora30.diveapin.data.player

class NpcData (
    var talkDelay: Int = 20,
    var storyMissionId: Int = -1,
    var mobMissionId: Int = -1,
    var itemMissionId: Int = -1,

    //セーブ無し
    var isTalking: Boolean = false,
    var setFirstTalk: Boolean = false
){
    // NPCID | 会話の進捗
    val talkProgressMap = hashMapOf<Int,Int>()

    fun setMissionId(type: String, id: Int){
        when(type){
            "Story" -> storyMissionId = id
            "Mob" -> mobMissionId = id
            "Item" -> itemMissionId = id
        }
    }

    fun getTalkProgress(id: Int): Int {
        return talkProgressMap[id] ?: 0
    }
}