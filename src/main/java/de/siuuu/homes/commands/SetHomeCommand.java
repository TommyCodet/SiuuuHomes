package de.siuuu.homes.commands;

import de.siuuu.homes.manager.HomeManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private final HomeManager manager;

    public SetHomeCommand(HomeManager manager) {
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

        if (args.length != 1) {
            player.sendMessage("§c/sethome <name>");
            return true;
        }

        manager.setHome(player, args[0]);

        player.sendMessage("§aHome erstellt.");
        return true;
    }
}
