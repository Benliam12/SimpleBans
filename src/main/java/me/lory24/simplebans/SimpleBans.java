package me.lory24.simplebans;

import me.lory24.simplebans.commands.KickExecutor;
import me.lory24.simplebans.system.data.PluginDatabase;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.SQLException;

public final class SimpleBans extends JavaPlugin{
    public static SimpleBans instance;

    @Override
    public void onEnable() { // Plugin startup logic
        instance = this;
        this.saveDefaultConfig();
        instance.getCommand("kick").setExecutor(new KickExecutor());
        instance.getCommand("kick").setTabCompleter(new KickExecutor());

        PluginDatabase pluginDatabase = new PluginDatabase();
        pluginDatabase.initConnection();

        this.getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() { // Plugin shutdown logic
        try {
            PluginDatabase.connection.close();
        } catch (SQLException e) { e.printStackTrace(); }
        catch(NullPointerException e)
        {
            this.getLogger().info("No database connection found!");
        }
        this.getLogger().info("Plugin disabled!");
    }
}
