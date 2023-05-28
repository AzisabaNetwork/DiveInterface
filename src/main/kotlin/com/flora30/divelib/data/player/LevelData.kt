package com.flora30.divelib.data.player

class LevelData (
    var whistleExp: Int = 0,
    var whistleRank: Int = 1,
    var exp: Int = 0,
    var level: Int = 1,
    var rawPoint: Int = 0, // 振り分け前のポイント
    var pointLuc: Int = 0, // 幸運
    var pointInt: Int = 0, // 知識
    var pointVit: Int = 0, // 体力
    var pointAtk: Int = 0  // 武力
){
}