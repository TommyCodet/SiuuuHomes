package de.siuuu.homes.listeners;

import de.siuuu.homes.manager.HomeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.inventory.InventoryClickEvent;

public class HomeGUIListener implements Listener {

    private final HomeManager manager;

    public HomeGUIListener(HomeManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals("Homes"))
            return;

        event.setCancelled(true);

        if (event.getCurrentItem() == null)
            return;

        Player player = (Player) event.getWhoClicked();

        String home =
                event.getCurrentItem()
                        .getItemMeta()
                        .getDisplayName()
                        .replace("§a", "");

        if (event.isLeftClick()) {

            player.teleport(
                    manager.getHome(player, home)
            );

            player.closeInventory();
        }

        if (event.isRightClick()) {

            manager.deleteHome(player, home);

            player.closeInventory();

            player.sendMessage("§cHome gelöscht.");
        }
    }
}
