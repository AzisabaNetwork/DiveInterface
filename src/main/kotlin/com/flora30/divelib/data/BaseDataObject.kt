package com.flora30.divelib.data

object BaseDataObject {
    // 拠点データ（レイヤーごとの設定）
    val baseLayerMap = hashMapOf<String, BaseLayer>()

    // 拠点データ（IDごとの設定）
    val baseLocationMap = hashMapOf<Int, BaseLocation>()

    // 焼けるものID | 焼いた後ID
    val cookMap = hashMapOf<Int, Int>()
}