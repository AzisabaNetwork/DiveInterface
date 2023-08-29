package com.flora30.divelib.util

import org.bukkit.Material
import org.bukkit.block.Block

object BlockUtil {

    //無条件に通れるブロック
    fun isIgnoreBlockType(block: Block): Boolean {
        return isIgnoreBlockType(block.type)
    }

    fun isIgnoreBlockType(material: Material): Boolean {
        val type = material.name
        return when {
            //サンゴ
            type.endsWith("CORAL") -> {
                true
            }
            //サンゴその２
            type.endsWith("FAN") -> {
                true
            }
            //看板
            type.endsWith("SIGN") -> {
                true
            }
            //旗
            type.endsWith("BANNER") -> {
                true
            }
            //感圧版
            type.endsWith("PLATE") -> {
                true
            }
            //ボタン
            type.endsWith("BUTTON") -> {
                true
            }
            //松明
            type.endsWith("TORCH") -> {
                true
            }
            //レール
            type.endsWith("RAIL") -> {
                true
            }
            else -> when (material) {
                // 空気系
                Material.AIR, Material.CAVE_AIR, Material.VOID_AIR,
                // 草系
                Material.GRASS, Material.FERN, Material.DEAD_BUSH, Material.TALL_GRASS, Material.LARGE_FERN, Material.VINE,
                // 作物系
                Material.WHEAT, Material.BEETROOTS, Material.CARROTS, Material.POTATOES, Material.SUGAR_CANE, Material.SWEET_BERRY_BUSH, Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.NETHER_WART,
                // 苗木系
                Material.SPRUCE_SAPLING, Material.ACACIA_SAPLING, Material.BAMBOO_SAPLING, Material.BIRCH_SAPLING, Material.DARK_OAK_SAPLING, Material.JUNGLE_SAPLING, Material.OAK_SAPLING,
                // 花系
                Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM, Material.AZURE_BLUET, Material.RED_TULIP, Material.ORANGE_TULIP, Material.WHITE_TULIP, Material.PINK_TULIP, Material.OXEYE_DAISY, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY, Material.WITHER_ROSE, Material.SUNFLOWER, Material.ROSE_BUSH, Material.LILAC, Material.PEONY,
                // 液体系
                Material.WATER, Material.LAVA,
                // 水草系
                Material.SEAGRASS, Material.TALL_SEAGRASS, Material.KELP_PLANT, Material.KELP,
                // その他
                Material.COBWEB, Material.SCAFFOLDING, Material.PAINTING, Material.ITEM_FRAME, Material.ARMOR_STAND, Material.REDSTONE, Material.REDSTONE_WIRE, Material.TRIPWIRE, Material.TRIPWIRE_HOOK, Material.STRING -> true

                else -> false
            }
        }
    }
}