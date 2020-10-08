package me.lory24.simplebans.system;

import me.lory24.simplebans.config.Values;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickManager {
    private final Player player;
    private final CommandSender executor;
    private final String reason;

    public KickManager(Player player, CommandSender executor, String reason) {
        this.player = player;
        this.executor = executor;
        this.reason = reason;
    }

    /**
     * Kick player loaded in the KickManager local variables
     */
    public void kick() {
        Values values = new Values();
        player.kickPlayer(values.getKickPageMessage(reason, executor.getName(), player.getName()));
        executor.sendMessage(values.getKickMessage(reason, player.getName()));
        if (!values.isEnablePublicKickMessage()) return;
        Bukkit.broadcastMessage(values.getPublicKickMessage(reason, executor.getName(), player.getName()));
    }
}
