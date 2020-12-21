package me.nucker.hypixelhello;

import me.nucker.hypixelhello.commands.AboutCommand;
import me.nucker.hypixelhello.commands.HelloCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class HypixelHello extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        log("&aStarting HypixelHello..");
        saveDefaultConfig();
        getCommand("hi").setExecutor(new HelloCommand());
        getCommand("hypixelhello").setExecutor(new AboutCommand());
        log("&aSuccessfully started HypixelHello");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("&cHypixelHello is shutting down");
    }

    // Util methods
    private String msg(String message) {
        return ChatColor.translateAlternateColorCodes('&',  message);
    }

    private void log(String message) {
        getServer().getConsoleSender().sendMessage(msg(message));
    }
}
