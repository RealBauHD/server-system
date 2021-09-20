package de.bauhd.system;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerSystem extends JavaPlugin {

    @Override
    public void onEnable() {

        this.registerCommands();
        this.registerEvents();

    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {

    }

    private void registerEvents() {

    }

}
