package com.flora30.divelib.data

import org.bukkit.ChatColor

object HelpObject {
    // ID | ヘルプ
    val helpMap: Map<Int,Help> = HashMap()

    fun getWhiteLore(lore: List<String>): List<String> {
        val newLore: MutableList<String> = ArrayList()

        newLore.add("")
        for (s: String in lore){
            newLore.add(""+ChatColor.WHITE+s)
        }
        return newLore
    }
}