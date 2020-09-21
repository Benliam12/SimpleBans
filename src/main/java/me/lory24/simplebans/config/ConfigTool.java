package me.lory24.simplebans.config;

import me.lory24.simplebans.SimpleBans;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public abstract class ConfigTool {
    private final FileConfiguration config = SimpleBans.instance.getConfig();

    public String getStringFromConfig(String path) {
        return this.getConfig().getString(path);
    }

    public boolean isBooleanGet(String path) {
        return Boolean.parseBoolean(getStringFromConfig(path));
    }

    public String printColors(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    private FileConfiguration getConfig() {
        return config;
    }
}
