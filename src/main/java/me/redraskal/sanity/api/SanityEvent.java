package me.redraskal.sanity.api;

import org.bukkit.entity.Player;

/**
 * Created by Redraskal_2 on 11/7/2016.
 */
public abstract class SanityEvent {

    public abstract int foodLevel();

    public abstract void execute(Player player);
}