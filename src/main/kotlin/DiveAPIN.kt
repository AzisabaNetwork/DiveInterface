import org.bukkit.plugin.java.JavaPlugin

class DiveAPIN: JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }

    init {
        plugin = this
    }


    override fun onEnable() {
        super.onEnable()
        config.getString("")
        // config読込み処理
    }
}