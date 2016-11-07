package me.redraskal.sanity.listener;

import me.redraskal.sanity.api.SanityAPI;
import me.redraskal.sanity.api.SanityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by Redraskal_2 on 11/7/2016.
 */
public class FoodLevel implements Listener {

    @EventHandler
    public void on(FoodLevelChangeEvent foodLevelChangeEvent) {
        for(SanityEvent sanityEvent : SanityAPI.getInstance().getEvents()) {
            if(foodLevelChangeEvent.getFoodLevel() == sanityEvent.foodLevel()) {
                sanityEvent.execute((org.bukkit.entity.Player) foodLevelChangeEvent.getEntity());
            }
        }
    }
}