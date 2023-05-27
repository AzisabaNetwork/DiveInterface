package com.flora30.diveapin

import com.flora30.diveapin.data.Rarity
import com.flora30.diveapin.event.PutItemEntityEvent
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.*
import org.bukkit.inventory.ItemStack
import org.bukkit.scoreboard.Team
import java.util.*
import kotlin.collections.HashSet

object ItemEntityObject {
    // playerItemに必要なアイテムスポーン関連の機能のみ
    // 一時保存（アイテムエンティティ | プレイヤーUUID）
    val itemEntityMap = hashMapOf<Item, ItemEntityData>()
    // 一時保存（エンティティ | 攻撃したプレイヤーリスト）
    val mobMap = hashMapOf<UUID, MobEntityData>()

    // 色の演出用
    val freeItemSet = hashSetOf<Item>()
    // レア度 | 発光用Team
    val colorTeamMap = hashMapOf<Rarity,Team>()


    val releaseTick: Int = 200

    /** アイテムエンティティを召喚する
     * @return 召喚されたエンティティ
     */
    fun spawnItem(item: ItemStack, location: Location, player: Player): Entity? {
        if (location.world == null) return null
        val itemEntity = location.world.dropItem(location,item)

        // アイテムを登録する
        putItem(itemEntity,player)
        return itemEntity
    }

    /**
     * ワールドに召喚されたアイテムを登録する
     */
    fun putItem(item: Item, player: Player){
        // 発光色の追加にはItemDataが必要なのでEventで他に渡す
        val event = PutItemEntityEvent(item,player)
        Bukkit.getPluginManager().callEvent(event)
        if (event.isCancelled) return

        // アーマースタンドIDはItemEntityDataの生成時に強制で必要
        // 名前表示用のアーマースタンド
        val armorStand: ArmorStand =
            item.world.spawnEntity(item.location.add(0.0,-1.5,0.0), EntityType.ARMOR_STAND) as ArmorStand;
        armorStand.isInvisible = true
        armorStand.isCustomNameVisible = true
        armorStand.customName = player.displayName().toString()
        armorStand.setGravity(false)
        armorStand.isInvulnerable = true

        // アイテムエンティティを登録する
        val data = ItemEntityData(
            releaseTick,
            player.uniqueId,
            armorStand.uniqueId
        )
        itemEntityMap[item] = data
    }
}