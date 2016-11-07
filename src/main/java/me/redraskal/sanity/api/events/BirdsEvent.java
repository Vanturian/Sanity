package me.redraskal.sanity.api.events;

import me.redraskal.sanity.Main;
import me.redraskal.sanity.api.SanityEvent;
import me.redraskal.sanity.utils.CustomSkull;
import me.redraskal.sanity.utils.VectorUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
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
        for(int i=0; i<3; i++) {
            this.spawnBird(player);
        }
    }

    private void spawnBird(Player player) {
        ArmorStand armorStand = this.summon(player.getLocation());
        new BukkitRunnable() {
            float step = 0;
            public void run() {
                if(player.isDead() || !player.isOnline()) {
                    this.cancel();
                } else {
                    if(player.getFoodLevel() > foodLevel()) {
                        armorStand.remove();
                        this.cancel();
                    } else {
                        armorStand.teleport(VectorUtils.getLocationAroundCircle(player.getLocation().add(0, 1.2, 0), 2, (0.3f * step)));
                        step++;
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 0, 3L);
    }

    private ArmorStand summon(Location location) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setBasePlate(false);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.setHelmet(CustomSkull.constructBird());
        armorStand.setMetadata("sanity_mob", new FixedMetadataValue(Main.getInstance(), true));
        return armorStand;
    }
}