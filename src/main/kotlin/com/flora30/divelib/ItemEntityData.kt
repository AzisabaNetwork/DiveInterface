package com.flora30.diveapin

import java.util.UUID

class ItemEntityData (
    // データが保持される残り時間（tick）
    var remain: Int,
    // アイテムに紐づいたプレイヤーのUUID
    var id: UUID,
    // 名前表示用アーマースタンドのUUID
    var armorStandID: UUID
){
}