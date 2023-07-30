package com.flora30.divelib.util

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.flora30.divelib.DiveLib.Companion.protocolManager
import com.github.retrooper.packetevents.protocol.entity.data.EntityData
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes
import com.github.retrooper.packetevents.util.Vector3d
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity
import net.minecraft.world.entity.item.EntityItem
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.*

object ItemEntityUtils {

    fun spawnPacketItem(player: Player, item: ItemStack, location: Location) {
        val entityItem = EntityItem((player.world as CraftWorld).handle, location.x, location.y, location.z, CraftItemStack.asNMSCopy(item))
        entityItem.t() // makeFakeItem
        entityItem.r() // setUnlimitedLifetime
        entityItem.o(true) // setNoGravity
        entityItem.setGlowingTag(true)

        val addEntityPacket = WrapperPlayServerSpawnEntity(
            entityItem.id,
            Optional.of(entityItem.uniqueID),
            EntityTypes.ITEM,
            Vector3d(
                entityItem.locX(),
                entityItem.locY(),
                entityItem.locZ()
            ),
            entityItem.yRot,
            entityItem.xRot,
            0f,
            0,
            Optional.of(Vector3d.zero())
        )
        val dataEntityPacket = WrapperPlayServerEntityMetadata(
            entityItem.id,
            mutableListOf(
                EntityData(0, EntityDataTypes.NBT, entityItem.bukkitEntity.persistentDataContainer.toTagCompound())
            )
        )

        protocolManager.sendServerPacket(player, PacketContainer.deserializeFromBuffer(PacketType.Play.Server.SPAWN_ENTITY, addEntityPacket.buffer) as PacketContainer)
        protocolManager.sendServerPacket(player, PacketContainer.deserializeFromBuffer(PacketType.Play.Server.ENTITY_METADATA, dataEntityPacket.buffer) as PacketContainer)

        player.playSound(location, Sound.ENTITY_ENDER_EYE_DEATH, 1f, 1f)
    }
}