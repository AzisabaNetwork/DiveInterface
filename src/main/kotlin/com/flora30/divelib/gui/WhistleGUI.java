package com.flora30.divelib.gui;

import com.flora30.divelib.data.player.PlayerData;
import com.flora30.divelib.data.player.PlayerDataObject;
import com.flora30.divelib.event.AddExpEvent;
import com.flora30.divelib.event.HelpEvent;
import com.flora30.divelib.event.HelpType;
import com.flora30.divelib.util.GuiItem;
import com.flora30.divelib.util.GuiItemType;
import com.flora30.divelib.util.PlayerItem;
import com.flora30.divelib.data.Whistle;
import com.flora30.divelib.data.WhistleObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WhistleGUI {
    public static final List<Integer> sendRegion = List.of(10,11,12,13,14,15,16, 19,20,21,22,23,24,25, 28,29,30,31,32,33);
    public static final int sendPoint = 34;

    public static Inventory getGui(Player player) {
        Bukkit.getPluginManager().callEvent(new HelpEvent(player, HelpType.WhistleGUI));

        Inventory inv = Bukkit.createInventory(null,45,"笛ランク");
        GuiItem.INSTANCE.grayBack(inv);

        inv.setItem(4, getWhistleIcon(player));
        inv.setItem(sendPoint, getSendIcon());
        for (int slot : sendRegion) {
            inv.setItem(slot, null);
        }

        return inv;
    }

    private static ItemStack getSendIcon() {
        ItemStack item = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        List<String> lore = new ArrayList<>();

        // 名前
        meta.setDisplayName(ChatColor.GOLD + "<<" + ChatColor.WHITE + " クリックで遺物を納品する " + ChatColor.GOLD +">>");

        // 説明
        lore.add("");
        lore.add(ChatColor.WHITE + "空いた場所に遺物を置いてください");
        lore.add(ChatColor.YELLOW + "遺物価値" + ChatColor.WHITE + "によって、" + ChatColor.YELLOW + "貢献値" + ChatColor.WHITE + "が上昇します");

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack getWhistleIcon(Player player) {
        PlayerData data = PlayerDataObject.INSTANCE.getPlayerDataMap().get(player.getUniqueId());
        int exp = data.getLevelData().getWhistleExp();
        int nextExp = WhistleObject.INSTANCE.getWhistleExpMap().get(data.getLevelData().getWhistleRank() + 1);
        Whistle whistle = WhistleObject.INSTANCE.getWhistleMap().get(data.getLevelData().getWhistleRank());

        ItemStack item;
        switch (whistle.getType()) {
            case Red -> item = GuiItem.INSTANCE.getItem(GuiItemType.WhistleRed);
            case Blue -> item = GuiItem.INSTANCE.getItem(GuiItemType.WhistleBlue);
            case Moon -> item = GuiItem.INSTANCE.getItem(GuiItemType.WhistleMoon);
            case Black -> item = GuiItem.INSTANCE.getItem(GuiItemType.WhistleBlack);
            case White -> item = GuiItem.INSTANCE.getItem(GuiItemType.WhistleWhite);
            default -> throw new IllegalStateException("Unexpected value: " + whistle.getType());
        }

        // 貢献値について
        List<String> lore = new ArrayList<>();
        lore.add("");
        String expText = ChatColor.GOLD + "現在の貢献値 ‣ " + ChatColor.WHITE + exp;
        String nextExpText = ChatColor.GOLD +"（次まで ‣ " + ChatColor.WHITE + nextExp + ChatColor.GOLD + " ）";
        lore.add(expText + nextExpText);

        // 機能について
        lore.add("");
        lore.add(ChatColor.GOLD + "帰還可能な深度 ‣ " + ChatColor.WHITE + whistle.getReturnDepth());
        lore.add(ChatColor.GOLD + "エンダーチェストの容量 ‣ " + ChatColor.WHITE + whistle.getEnderCapacity());

        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(getWhistleRankDisplay(whistle));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static String getWhistleRankDisplay(Whistle whistle) {
        String type;
        switch (whistle.getType()) {
            case Red -> type = "赤笛";
            case Blue -> type = "青笛";
            case Moon -> type = "月笛";
            case Black -> type = "黒笛";
            case White -> type = "白笛";
            default -> throw new IllegalStateException("Unexpected value: " + whistle.getType());
        }

        return ChatColor.WHITE + type + " ランク" + whistle.getRank();
    }

}