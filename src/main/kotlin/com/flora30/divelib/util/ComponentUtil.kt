package com.flora30.divelib.util

import net.kyori.adventure.text.Component

object ComponentUtil {
    fun convertComponentList(list: List<String>): List<Component>{
        val result = ArrayList<Component>()
        for (str: String in list){
            result.add(Component.text(str))
        }
        return result
    }
}