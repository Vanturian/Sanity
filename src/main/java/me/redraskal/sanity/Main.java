package me.redraskal.sanity;

import me.redraskal.sanity.listeners.FoodLevelChange;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new FoodLevelChange(), this);
    }

    @Override
    public void onDisable() {
        // TODO: Nothing here yet!
    }
}

