package com.flora30.divelib.data.player

import java.util.*

object PlayerDataObject {
    // UUID | プレイヤーデータ
    val playerDataMap: Map<UUID, PlayerData> = HashMap()

    // プレイヤー名 | UUID
    val playerIdMap: Map<String, UUID> = HashMap()

    // プレイヤーデータの読み込みが完了したプレイヤー
    val loadedPlayerSet: Set<UUID> = HashSet()

    // adminリスト
    // ゲームモード変更、Admin用セーブデータなど
    val adminSet: Set<UUID> = HashSet()

    private var uniqueId = 0
    fun getUniqueSideBarID(): Int{
        uniqueId++
        return uniqueId
    }
}