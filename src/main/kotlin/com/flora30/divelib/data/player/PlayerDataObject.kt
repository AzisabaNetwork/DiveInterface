package com.flora30.diveapin.data.player

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

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