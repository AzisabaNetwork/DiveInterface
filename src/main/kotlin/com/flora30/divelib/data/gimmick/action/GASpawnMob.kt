package com.flora30.divelib.data.gimmick.action

import com.flora30.divelib.data.GData
import io.lumine.xikage.mythicmobs.MythicMobs
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter

class GASpawnMob (
    val name: String
): GAction{
    override fun execute(data: GData) {
        MythicMobs.inst().apiHelper.getMythicMob(name).spawn(BukkitAdapter.adapt(data.location), 1.0)
    }
}