package me.redraskal.sanity.commands;

import me.redraskal.sanity.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 * Created by Redraskal_2 on 11/7/2016.
 */
public class SanityCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PluginDescriptionFile descriptionFile = Main.getInstance().getDescription();
        String authors = "";
        for(String author : descriptionFile.getAuthors()) {
            if(authors.isEmpty()) { authors = "&e" + author; } else { authors = authors + "&f, &e" + author; }
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l" + descriptionFile.getName()
                + " &7(&e" + descriptionFile.getVersion()
                + "&7)&f&l: &fDeveloped by " + authors));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7" + descriptionFile.getDescription()));
        return false;
    }
}