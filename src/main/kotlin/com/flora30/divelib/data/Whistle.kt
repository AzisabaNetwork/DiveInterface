package com.flora30.divelib.data

import com.flora30.divelib.data.WhistleType

class Whistle (
    val rank: Int, // タイプごとのランク（表示用）
    val type: WhistleType,
    val returnDepth: Int, // 帰還可能な深度
    val enderCapacity: Int // エンダーチェストの容量
){
}