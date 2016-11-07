package me.redraskal.sanity;

import me.redraskal.sanity.listeners.FoodLevelChange;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
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
        for(World world : Bukkit.getWorlds()) {
            for(Entity entity : world.getEntities()) {
                if(entity instanceof ArmorStand && entity.hasMetadata("sanity_mob")) {
                    entity.remove();
                }
            }
        }
    }
}