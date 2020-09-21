package me.lory24.simplebans;

import me.lory24.simplebans.commands.KickExecutor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleBans extends JavaPlugin {
    public static SimpleBans instance;

    @Override
    public void onEnable() { // Plugin startup logic
        instance = this;
        this.saveDefaultConfig();
        instance.getCommand("kick").setExecutor(new KickExecutor());
        instance.getCommand("kick").setTabCompleter(new KickExecutor());

        Bukkit.getLogger().info("[SmartBans] Plugin enabled!");
    }

    @Override
    public void onDisable() { // Plugin shutdown logic
        Bukkit.getLogger().info("[SmartBans] Plugin disabled!");
    }
}
