package me.redraskal.sanity.api.events;

import me.redraskal.sanity.Main;
import me.redraskal.sanity.api.SanityEvent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Redraskal_2 on 11/7/2016.
 */
public class BirdsEvent extends SanityEvent {

    @Override
    public int foodLevel() {
        return 4;
    }

    @Override
    public void execute(Player player) {
        //TODO Add birds
        new BukkitRunnable() {
            public void run() {
                if(player.isDead() || player.isOnline()) {
                    this.cancel();
                } else {
                    if(player.getFoodLevel() > foodLevel()) {
                        //TODO Remove birds
                        this.cancel();
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 0, 20L);
    }
}