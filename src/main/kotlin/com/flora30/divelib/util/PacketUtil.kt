package com.flora30.diveapin.util

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.wrappers.BlockPosition
import com.comphenix.protocol.wrappers.WrappedBlockData
import com.flora30.diveapin.DiveLib
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import java.lang.reflect.InvocationTargetException

object PacketUtil {

    /**
     * ブロックを1個変更する
     */
    fun sendBlockChangePacket(player: Player?, material: Material?, location: Location) {
        sendBlockChangePacket(player, material, location.blockX, location.blockY, location.blockZ)
    }

    fun sendBlockChangePacket(player: Player?, material: Material?, x: Int, y: Int, z: Int) {
        // パケットコンテナを作成
        val protocolManager = ProtocolLibrary.getProtocolManager()
        val packetContainer = protocolManager.createPacket(PacketType.Play.Server.BLOCK_CHANGE)
        // フィールドへ書き込み
        packetContainer.blockPositionModifier.write(0, BlockPosition(x, y, z))
        packetContainer.blockData.write(0, WrappedBlockData.createData(material))
        // 送信
        try {
            protocolManager.sendServerPacket(player, packetContainer)
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }

    fun fadeOutBorderPacket(player: Player, time: Int) {
        sendBorderPacket(player, 200000, 1f, 0f, time.toLong())
        DiveLib.plugin.delayedTask(20) { sendBorderPacket(player, 0, 0f, 0f, 0) }
    }

    fun setBorderPacket(player: Player) {
        sendBorderPacket(player, 200000, 1f, 1f, 0)
    }

    /**
     * @param first,last 赤の彩度（0 ~ 1）
     * @param time 変化する時間
     */
    private fun sendBorderPacket(player: Player, warningBlock: Int, first: Float, last: Float, time: Long) {
        // 彩度を WorldBorder の大きさに変換
        var time = time
        val firstDiameter = (first * -300000f + 400000).toDouble()
        val lastDiameter = (last * -300000f + 400000).toDouble()
        time *= 1000


        // パケット作成
        val protocolManager = ProtocolLibrary.getProtocolManager()
        val packet = protocolManager.createPacket(PacketType.Play.Server.INITIALIZE_BORDER)
        packet.doubles.write(0,player.location.x) // x
        packet.doubles.write(1,player.location.z) // z
        packet.doubles.write(2,firstDiameter) // oldDiameter
        packet.doubles.write(3,lastDiameter) // newDiameter
        packet.longs.write(0,time) // speed
        packet.integers.write(0,warningBlock) // warningBlocks
        packet.integers.write(1,15) // warningTime

        // 送信
        try {
            protocolManager.sendServerPacket(player, packet)
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }
}