package com.flora30.divelib.util

import org.bukkit.Bukkit
import org.bukkit.Chunk
import org.bukkit.Location
import org.bukkit.entity.Entity

object EntityUtil {
    fun getNearEntities(location: Location, range: Int): HashSet<Entity>{
        val entities = hashSetOf<Entity>()

        // チャンク内のエンティティを取得することで効率化
        for (chunk in getNearChunks(location,range)){
            for (entity in chunk.entities){
                if (entity.location.distance(location) < range){
                    entities.add(entity)
                }
            }
        }

        return entities
    }

    private fun getNearChunks(location: Location, range: Int): HashSet<Chunk>{
        val chunks = hashSetOf<Chunk>()
        var moveLocation = location.clone()

        // 初期地点
        val minX = location.blockX - range
        val minZ = location.blockZ - range
        val maxX = location.blockX + range
        val maxZ = location.blockZ + range
        Bukkit.getLogger().info("chunk search -> "+((2*range)/16)*((2*range)/16)+" times")

        chunks.add(location.chunk)

        // 16ずつ移動する
        while (moveLocation.blockX < maxX){
            while (moveLocation.blockZ < maxZ){
                chunks.add(location.chunk)
                moveLocation = Location(moveLocation.world, moveLocation.x, moveLocation.y, moveLocation.z + 16)
            }
            moveLocation = Location(moveLocation.world, moveLocation.x + 16, moveLocation.y, minZ.toDouble())
        }

        return chunks
    }
}