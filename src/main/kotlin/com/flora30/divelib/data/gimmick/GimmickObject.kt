package com.flora30.divelib.data.gimmick

object GimmickObject {
    // ギミックID | ギミック
    val gimmickMap = hashMapOf<String,Gimmick>()

    // layerID | ギミックログ
    val layerLogMap = hashMapOf<String,HashSet<GimmickLog>>()


    /**
     * データベース保存時の文字数省略用
     * データベース保存する予定のギミックだけ登録
     */
    fun getIntID(strID: String): Int{
        return when(strID){
            "Chest_Grass" -> 0
            "Chest_Ruin" -> 1
            "FallRock" -> 2
            else -> -1
        }
    }

    fun getStringID(intID: Int): String?{
        return when(intID){
            0 -> "Chest_Grass"
            1 -> "Chest_Ruin"
            2 -> "FallRock"
            else -> null
        }
    }
}