package de.siuuu.homes.commands;

import de.siuuu.homes.manager.HomeManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class DelHomeCommand implements CommandExecutor {

    private final HomeManager manager;

    public DelHomeCommand(HomeManager manager) {
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

        if (args.length != 1)
            return true;

        manager.deleteHome(player, args[0]);

        player.sendMessage("§cHome gelöscht.");
        return true;
    }
}
