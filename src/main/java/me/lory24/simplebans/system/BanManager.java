package me.lory24.simplebans.system;

import me.lory24.simplebans.config.Values;
import me.lory24.simplebans.system.data.DataManager;
import me.lory24.simplebans.system.data.PluginDatabase;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class BanManager
 * Handles ban events
 */
public class BanManager {
    private final String player;

    public BanManager(String player) {
        this.player = player;
    }

    public void ban(CommandSender executor, String banReason) {
        DataManager dataManager = new DataManager(PluginDatabase.getConnection());
        dataManager.insertPlayerToBansTable(player, executor, banReason);
        Player player = Bukkit.getPlayerExact(this.player);
        if (player == null) return;
        Values values = new Values();
        player.kickPlayer(values.getBanPageMessage(banReason, executor.getName(), this.player, "PERMANENT"));
    }

    public boolean isBanned() {
        return false; // EDIT HERE
    }
}
