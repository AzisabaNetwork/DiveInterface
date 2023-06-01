package com.flora30.divelib.data

import com.flora30.divelib.event.HelpType
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class Help (
    val trigger: HelpType,
    val material: Material,
    val title: String,
    val lore: List<String>
    ){

    fun getItem(): ItemStack {
        val item = ItemStack(material)
        if (item.itemMeta == null) return item
        val meta = item.itemMeta
        meta.displayName(Component.text(title))
        meta.lore(getLoreComponent(lore))
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
        item.itemMeta = meta
        return item
    }

    /**
     * List<String> -> List<Component>
     */
    private fun getLoreComponent(lore: List<String>): List<Component> {
        val component: MutableList<Component> = ArrayList()

        for (s: String in lore) {
            component.add(Component.text(s))
        }

        return component
    }
}