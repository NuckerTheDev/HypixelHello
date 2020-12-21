package me.nucker.hypixelhello.commands;

import me.nucker.hypixelhello.HypixelHello;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class AboutCommand implements CommandExecutor {
    private Plugin pl = HypixelHello.getPlugin(HypixelHello.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("reload")|| args[0].equalsIgnoreCase("rl")) {
                    if(p.hasPermission("hypixelhello.reload")) {
                        pl.reloadConfig();
                        p.sendMessage(msg("&aPlugin reloaded"));
                    }else {
                        p.sendMessage(msg(pl.getConfig().getString("permission-message")));
                    }
                }else {
                    String[] messages = {msg("&a----------------------------------------"),
                            msg("&aHypixelHello &7- &9A recreation of the /hi command on hypixel"),
                            msg("&aDeveloped by &9Nucker"),
                            msg("&aGithub&7: &9https://github.com/nuckerr/hypixelhello"),
                            msg("&a----------------------------------------")
                    };
                    p.sendMessage(messages);
                }
            }else {
                String[] messages = {msg("&a----------------------------------------"),
                        msg("&aHypixelHello &7- &9A recreation of the /hi command on hypixel"),
                        msg("&aDeveloped by &9Nucker"),
                        msg("&aGithub&7: &9https://github.com/nuckerr/hypixelhello"),
                        msg("&a----------------------------------------")
                };
                p.sendMessage(messages);
            }
        }else {
            log("&aHypixel Hello developed by Nucker");
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
