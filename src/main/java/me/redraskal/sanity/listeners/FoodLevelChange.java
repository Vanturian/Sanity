package me.redraskal.sanity.listeners;

import me.redraskal.sanity.api.SanityAPI;
import me.redraskal.sanity.api.SanityEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {

    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
        for (SanityEvent e : SanityAPI.getInstance().getEvents()) {
            if(event.getFoodLevel() == e.foodLevel()) {
                e.execute((Player)event.getEntity());
            }
        }
    }
}
