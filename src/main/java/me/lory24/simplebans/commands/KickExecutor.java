package me.lory24.simplebans.commands;

import me.lory24.simplebans.config.Values;
import me.lory24.simplebans.system.KickManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class KickExecutor implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final Values values = new Values();

        if (!sender.hasPermission("kick.execute")) {
            sender.sendMessage(values.getNoPermissionMessage(sender.getName(), "kick.execute"));
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(values.getSyntaxIncorrectMessage("/kick <player> [reason]"));
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            sender.sendMessage(values.getPlayerNotFoundMessage(args[0]));
            return true;
        }

        if (target.hasPermission("punishment.override")) {
            sender.sendMessage(values.getOverridePlayerMessage(values.getKickActionName(), args[0]));
            return true;
        }

        if (args.length == 1) {
            KickManager kickManager = new KickManager(target, sender, "NONE");
            kickManager.kick();
            return true;
        }

        KickManager kickManager = new KickManager(target, sender, generateReason(args));
        kickManager.kick();
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> arguments = new ArrayList<>();

        if (args.length == 1) {
            for (Player player : Bukkit.getOnlinePlayers()) arguments.add(player.getName());
        }

        return arguments;
    }

    private String generateReason(String[] args) {
        StringBuilder result = new StringBuilder();
        if (args.length == 2) {
            result.append(args[1]);
            return result.toString();
        }
        for(int n = 1; n <= (args.length - 1); n++) {
            if (n == args.length - 1) {
                result.append(args[n]);
                break;
            }
            result.append(args[n]).append(" ");
        }
        return result.toString();
    }
}
