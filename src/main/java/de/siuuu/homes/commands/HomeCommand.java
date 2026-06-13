package de.siuuu.homes.commands;

import de.siuuu.homes.gui.HomeGUI;
import de.siuuu.homes.manager.HomeManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private final HomeManager manager;

    public HomeCommand(HomeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {

        if (!(sender instanceof Player player))
            return true;

        HomeGUI.open(player, manager);

        return true;
    }
}
