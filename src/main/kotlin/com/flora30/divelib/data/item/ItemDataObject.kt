package com.flora30.divelib.data.item

import com.flora30.divelib.data.Rarity
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.scoreboard.Team
import java.lang.IllegalArgumentException
import java.util.*

object ItemDataObject {

    // 固定のアイテムデータ ItemIdごと
    val itemDataMap = hashMapOf<Int, ItemData>()

    // レア度 | 発光用のTeam
    val colorTeamMap: Map<Rarity, Team> = createColorTeamMap()

    // レア度 | ドロップ率
    val dropRateMap: Map<Rarity,Double> = EnumMap(Rarity::class.java)

    private fun createColorTeamMap(): Map<Rarity,Team> {
        val map = EnumMap<Rarity, Team>(Rarity::class.java)
        val board = Bukkit.getScoreboardManager().mainScoreboard

        // レアリティに応じた色のTeamを作成する
        for (rarity in Rarity.values()) {
            var team: Team
            val color: NamedTextColor = getNamedTextColor(rarity)
            team = try{
                board.registerNewTeam("c_$color")
            } catch (e: IllegalArgumentException) {
                board.getTeam("c_$color")!!
            }
            team.color(color)
            map.put(rarity,team)
        }

        // 完成後
        Bukkit.getLogger().info("[DiveItem-ItemEntity]color loaded "+map.keys.size)
        return map
    }

    fun getNamedTextColor(rarity: Rarity): NamedTextColor {
        return when (rarity) {
            Rarity.Unusual -> NamedTextColor.DARK_GREEN
            Rarity.Rare -> NamedTextColor.DARK_BLUE
            Rarity.Epic -> NamedTextColor.DARK_PURPLE
            Rarity.Legendary -> NamedTextColor.GOLD
            Rarity.Blessed -> NamedTextColor.DARK_RED
            else -> NamedTextColor.WHITE
        }
    }
}