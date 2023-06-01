package com.flora30.divelib.data.recipe

import com.flora30.divelib.ItemMain
import com.flora30.divelib.util.GuiItem
import com.flora30.divelib.util.GuiItemType
import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.inventory.ItemStack
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.random.Random

class Recipe (
    // 素材アイテム（位置、itemId）
    val materials: IntArray,
    // ぼやけた地点（位置、隠すブロック3種類）
    val hides: Array<HideType?>,
    // 完成品の数
    val amount: Int,

){
    // 隠すアイテムのItemStack（先に作成しておく）
    val hideItemMap: MutableMap<HideType,ItemStack> = EnumMap(HideType::class.java)
    // ぼやけた地点が無い場合true
    var isAutoComplete: Boolean = true
    // 必要な素材数まとめ
    val itemAmounts: MutableList<ItemAmount> = ArrayList()
    data class ItemAmount(val itemId: Int, val amount: Int)

    // ぼやけた地点で素材の前につく言葉
    val prefixes: Array<String> = arrayOf("たぶん","きっと","おそらく","もしかして")

    /**
     * Materialに応じたItemStackを作成するので、ItemStackMainが動くことが必須
     */
    init {
        // hideに応じたItemStackを作成
        for (hide: HideType in HideType.values()){
            // 現在のhideTypeで隠される素材一覧を取得
            val hiddenList = arrayListOf<Int>()
            for (i:Int in 0..11){
                if (hides[i] == hide && materials[i] != 0){
                    hiddenList.add(materials[i])
                }
            }

            // ItemStackを作成
            val item = when(hide){
                HideType.White -> GuiItem.getItem(GuiItemType.WoolWhite)
                HideType.Gray -> GuiItem.getItem(GuiItemType.WoolGray)
                HideType.Black -> GuiItem.getItem(GuiItemType.WoolBlack)
            }
            val meta = item.itemMeta
            meta.displayName(Component.text(""+ChatColor.GOLD+"ぼやけた地点"))
            val lore = arrayListOf<Component>()
            for (hiddenId: Int in hiddenList) {
                val hiddenItem = ItemMain.getItem(hiddenId)
                if (hiddenItem == null || hiddenItem.itemMeta == null) continue
                lore.add(Component.text(""))
                lore.add(Component.text(""+ChatColor.WHITE+prefixes[Random.nextInt(prefixes.size)]+" ‣ "+hiddenItem.itemMeta.displayName()))
            }
            meta.lore(lore)
            item.itemMeta = meta
            hideItemMap[hide] = item
        }

        // 必要な素材数まとめ
        // カウント済みのアイテムIDを入れる場所
        val counted = arrayListOf<Int>()
        for (id: Int in materials) {
            // 素材が無い場所 || カウント済み
            if (id == 0 || counted.contains(id)) continue

            // 素材数をカウントする
            val count = materials.filter{ i:Int -> i == id}.count()
            itemAmounts.add(ItemAmount(id,count))
            counted.add(id)
        }

        // isAutoCompleteを設定
        for (h: HideType? in hides){
            if (h != null) {
                isAutoComplete = false
            }
        }
    }

    /**
     * Completed段階の素材表示リスト
     */
    fun getCompletedMaterials(): Array<ItemStack?>{
        val items: Array<ItemStack?> = arrayOfNulls(12)

        for (i: Int in 0..11){
            // アイテムIDを取得
            val id: Int = materials[i]
            if (id == 0) continue

            // アイテムを取得
            val item = ItemMain.getItem(id) ?: continue
            item.amount = 1
            items[i] = item
        }

        return items
    }

    /**
     * Found段階の素材表示リスト
     */
    fun getFoundMaterials(): Array<ItemStack?>{
        val items: Array<ItemStack?> = arrayOfNulls(12)

        for (i:Int in 0..11){
            // 隠されていた場合:隠すアイテムを取得
            if (hides[i] != null){
                items[i] = hideItemMap.get(hides[i])?.clone()
                continue
            }

            // アイテムIDを取得
            val id: Int = materials[i]
            if (id == 0) continue

            // アイテムを取得
            val item = ItemMain.getItem(id) ?: continue
            item.amount = 1
            items[i] = item
        }
        return items
    }

}