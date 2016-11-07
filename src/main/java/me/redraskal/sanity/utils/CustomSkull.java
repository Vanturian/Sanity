package me.redraskal.sanity.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * Created by Redraskal_2 on 11/7/2016.
 */
public class CustomSkull {

    private static String BIRD_TEXTURES =
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDlhNjZmM2QyNThkOTI3ZjdlNDgxODE0OGJhYzY3YjIzZTc5MjRhOTNiODlmM2M5NmI4NzU0YmZjYjQ4Zjc1In19fQ==";

    public static ItemStack constructBird() {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", BIRD_TEXTURES));

        try {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException|IllegalArgumentException|IllegalAccessException e1) {
            e1.printStackTrace();
        }

        head.setItemMeta(headMeta);
        return head;
    }
}