package de.siuuu.homes;

import de.siuuu.homes.commands.*;
import de.siuuu.homes.listeners.HomeGUIListener;
import de.siuuu.homes.manager.HomeManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SiuuuHomes extends JavaPlugin {

    private static SiuuuHomes instance;
    private HomeManager homeManager;

    @Override
    public void onEnable() {

        instance = this;

        saveResource("homes.yml", false);

        homeManager = new HomeManager(this);

        getCommand("sethome").setExecutor(new SetHomeCommand(homeManager));
        getCommand("home").setExecutor(new HomeCommand(homeManager));
        getCommand("delhome").setExecutor(new DelHomeCommand(homeManager));

        getServer().getPluginManager().registerEvents(
                new HomeGUIListener(homeManager),
                this
        );
    }

    public static SiuuuHomes getInstance() {
        return instance;
    }

    public HomeManager getHomeManager() {
        return homeManager;
    }
}
