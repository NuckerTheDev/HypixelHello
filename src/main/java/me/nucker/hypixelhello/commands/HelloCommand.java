package me.nucker.hypixelhello.commands;

import me.nucker.hypixelhello.HypixelHello;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class HelloCommand implements CommandExecutor {
    private Plugin pl = HypixelHello.getPlugin(HypixelHello.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission(pl.getConfig().getString("permission"))) {
                p.sendMessage(msg(pl.getConfig().getString("message").replace("%player%", p.getDisplayName())));
            }else {
                p.sendMessage(msg(pl.getConfig().getString("permission-message").replace("%player%", p.getDisplayName())));
            }
        }else {
            log(pl.getConfig().getString("message").replace("%player%", "Console"));
        }
        return true;
    }
    // Util methods
    private String msg(String message) {
        return ChatColor.translateAlternateColorCodes('&',  message);
    }

    private void log(String message) {
        pl.getServer().getConsoleSender().sendMessage(msg(message));
    }
}
