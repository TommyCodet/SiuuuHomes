package de.siuuu.homes.manager;

import org.bukkit.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.Player;
import de.siuuu.homes.SiuuuHomes;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class HomeManager {

    private final File file;
    private final FileConfiguration config;

    public HomeManager(SiuuuHomes plugin) {

        file = new File(plugin.getDataFolder(), "homes.yml");
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void setHome(Player player, String name) {

        String path = "players." + player.getUniqueId() + ".homes." + name;

        config.set(path + ".world", player.getWorld().getName());
        config.set(path + ".x", player.getLocation().getX());
        config.set(path + ".y", player.getLocation().getY());
        config.set(path + ".z", player.getLocation().getZ());

        save();
    }

    public void deleteHome(Player player, String name) {

        config.set(
                "players." + player.getUniqueId() + ".homes." + name,
                null
        );

        save();
    }

    public Location getHome(Player player, String name) {

        String path = "players." + player.getUniqueId() + ".homes." + name;

        if (!config.contains(path))
            return null;

        World world =
                Bukkit.getWorld(config.getString(path + ".world"));

        return new Location(
                world,
                config.getDouble(path + ".x"),
                config.getDouble(path + ".y"),
                config.getDouble(path + ".z")
        );
    }

    public Set<String> getHomes(Player player) {

        String path = "players." + player.getUniqueId() + ".homes";

        if (!config.contains(path))
            return Set.of();

        return config.getConfigurationSection(path).getKeys(false);
    }

    private void save() {

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
