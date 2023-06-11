package com.flora30.divelib.data.gimmick

object GimmickObject {
    // ギミックID | ギミック
    val gimmickMap = hashMapOf<String,Gimmick>()

    // layerID | ギミックログ
    val layerLogMap = hashMapOf<String,HashSet<GimmickLog>>()
}