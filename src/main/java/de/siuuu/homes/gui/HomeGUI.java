package de.siuuu.homes.gui;

import de.siuuu.homes.manager.HomeManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class HomeGUI {

    public static void open(Player player, HomeManager manager) {

        Inventory inv =
                Bukkit.createInventory(null, 54, "Homes");

        int slot = 0;

        for (String home : manager.getHomes(player)) {

            ItemStack bed =
                    new ItemStack(Material.RED_BED);

            ItemMeta meta = bed.getItemMeta();

            meta.setDisplayName("§a" + home);

            bed.setItemMeta(meta);

            inv.setItem(slot++, bed);
        }

        player.openInventory(inv);
    }
}
