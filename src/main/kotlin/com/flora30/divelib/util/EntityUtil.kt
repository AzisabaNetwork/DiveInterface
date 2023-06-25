package com.flora30.divelib.util

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

        // 初期地点
        var x = location.blockX - range
        var z = location.blockZ - range
        val minZ = location.blockZ - range
        val maxX = location.blockX + range
        val maxZ = location.blockZ + range
        val world =location.world
        chunks.add(world.getChunkAt(x,z))

        // 16ずつ移動する
        while (x < maxX){
            while (z < maxZ){
                chunks.add(world.getChunkAt(x,z))
                z += 16
            }
            z = minZ
            x += 16
        }

        return chunks
    }
}