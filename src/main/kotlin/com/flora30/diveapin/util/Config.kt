package com.flora30.diveapin.util

import org.bukkit.Bukkit
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.FileConfiguration
import java.io.File
import java.io.IOException

abstract class Config {
    abstract fun load()
    abstract fun save()

    open fun fileCheck(file: File) {
        try {
            if (file.createNewFile()) {
                Bukkit.getLogger().info(file.name + "を新規作成しました")
            } else {
                Bukkit.getLogger().info(file.name + "の存在を確認しました")
            }
        } catch (e: IOException) {
            Bukkit.getLogger().info(file.name + "の作成に失敗しました")
            e.printStackTrace()
        }
    }

    open fun folderCheck(path: String) {
        val f = File(path)
        try {
            if (f.mkdir()) {
                Bukkit.getLogger().info(f.name + "を新規作成しました")
            } else {
                Bukkit.getLogger().info(f.name + "の存在を確認しました")
            }
        } catch (e: SecurityException) {
            Bukkit.getLogger().info(f.name + "の作成に失敗しました")
            e.printStackTrace()
        }
    }

    open fun checkAndWrite(section: ConfigurationSection, path: String, item: Any?) {
        if (!section.contains(path)) {
            section.createSection(path)
        }
        section[path] = item
    }

    open fun loadOrDefault(pluginType: String, file: FileConfiguration, key: String, def: Int): Int {
        return if (file.isInt(key)) {
            file.getInt(key)
        } else {
            Bukkit.getLogger().info("[DiveCore-" + pluginType + "]" + key + "の読み込みに失敗したため、デフォルト値" + def + "を使います")
            def
        }
    }

    open fun loadOrDefault(pluginType: String, section: ConfigurationSection?, key: String, def: Int): Int {
        return if (section != null && section.isInt(key)) {
            section.getInt(key)
        } else {
            Bukkit.getLogger().info("[DiveCore-" + pluginType + "]" + key + "の読み込みに失敗したため、デフォルト値" + def + "を使います")
            def
        }
    }

    open fun loadOrDefault(pluginType: String, file: FileConfiguration?, key: String, def: Double): Double {
        return if (file != null && file.isDouble(key)) {
            file.getDouble(key)
        } else if (file != null && file.isInt(key)) {
            file.getInt(key).toDouble()
        } else {
            Bukkit.getLogger().info("[DiveCore-" + pluginType + "]" + key + "の読み込みに失敗したため、デフォルト値" + def + "を使います")
            def
        }
    }

    open fun loadOrDefault(pluginType: String, file: ConfigurationSection?, key: String, def: Double): Double {
        return if (file != null && file.isDouble(key)) {
            file.getDouble(key)
        } else if (file != null && file.isInt(key)) {
            file.getInt(key).toDouble()
        } else {
            Bukkit.getLogger().info("[DiveCore-" + pluginType + "]" + key + "の読み込みに失敗したため、デフォルト値" + def + "を使います")
            def
        }
    }

    open fun loadOrDefault(pluginType: String, file: FileConfiguration?, key: String, def: String): String? {
        return if (file != null && file.isString(key)) {
            file.getString(key)
        } else {
            Bukkit.getLogger().info("[DiveCore-" + pluginType + "]" + key + "の読み込みに失敗したため、デフォルト値" + def + "を使います")
            def
        }
    }

    open fun loadOrDefault(pluginType: String, file: FileConfiguration?, key: String, def: Boolean): Boolean {
        return if (file != null && file.isBoolean(key)) {
            file.getBoolean(key)
        } else {
            Bukkit.getLogger().info("[DiveCore-" + pluginType + "]" + key + "の読み込みに失敗したため、デフォルト値" + def + "を使います")
            def
        }
    }
}