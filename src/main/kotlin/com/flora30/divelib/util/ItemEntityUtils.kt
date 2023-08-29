package com.flora30.divelib.util

import com.comphenix.protocol.events.PacketContainer
import com.flora30.divelib.DiveLib.Companion.protocolManager
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket
import net.minecraft.world.entity.item.ItemEntity
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object ItemEntityUtils {

    fun spawnPacketItem(player: Player, item: ItemStack, location: Location) {
        val entityItem = ItemEntity((player.world as CraftWorld).handle, location.x, location.y, location.z, CraftItemStack.asNMSCopy(item))
        entityItem.makeFakeItem() // makeFakeItem
        entityItem.setUnlimitedLifetime() // setUnlimitedLifetime
        entityItem.isNoGravity = true // setNoGravity
        entityItem.setGlowingTag(true)

        val addEntityPacket = ClientboundAddEntityPacket(
            entityItem
        )
        val dataEntityPacket = ClientboundSetEntityDataPacket(
            entityItem.id,
            entityItem.entityData,
            false
        )

        protocolManager.sendServerPacket(player, PacketContainer.fromPacket(addEntityPacket))
        protocolManager.sendServerPacket(player, PacketContainer.fromPacket(dataEntityPacket))

        player.playSound(location, Sound.ENTITY_ENDER_EYE_DEATH, 1f, 1f)
    }
}