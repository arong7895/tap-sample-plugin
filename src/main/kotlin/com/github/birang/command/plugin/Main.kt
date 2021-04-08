package com.github.birang.command.plugin

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(), Listener {
    val consol = Bukkit.getConsoleSender()

    override fun onEnable() {
        consol.sendMessage("[Pulgin Activity]")
        getServer().getPluginManager().registerEvents(this, this)
    }

    override fun onDisable() {
        consol.sendMessage("[Plugin Disactivity]")
    }

    @EventHandler
    fun join(e : PlayerJoinEvent) {
        e.setJoinMessage("Hello")
    }
}