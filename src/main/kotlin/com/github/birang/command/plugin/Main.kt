package com.github.birang.command.plugin

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class Main : JavaPlugin(), Listener {
    val consol = Bukkit.getConsoleSender()
    var count = 1

    override fun onEnable() {
        consol.sendMessage("${ChatColor.AQUA} [Pulgin Activity]")
        getServer().getPluginManager().registerEvents(this, this)

        saveConfig()
        var cfile = File(getDataFolder(), "config.yml")
        if (cfile.length().equals(0)) {
            getConfig().options().copyDefaults(true)
            saveConfig()
        }
    }

    override fun onDisable() {
        consol.sendMessage("${ChatColor.RED} [Plugin Disactivity]")
    }

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val msg = this.getConfig().getString("접속메시지")
        e.setJoinMessage("${ChatColor.GOLD} $msg")
    }

    @EventHandler
    fun breakBlock(e: BlockBreakEvent) {
        val msg1 = this.getConfig().getString("블록메시지.첫번째")
        val msg2 = this.getConfig().getString("블록메시지.세번째")
        e.getPlayer().sendMessage(msg1!!)
        e.getPlayer().sendMessage(msg2!!)
    }
}