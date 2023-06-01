package com.flora30.divelib.data.teleport

import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.inventory.ItemStack

class TravelData (
    val icon: ItemStack,
    val location: Location
){
    val name: Component? = icon.itemMeta.displayName()
}