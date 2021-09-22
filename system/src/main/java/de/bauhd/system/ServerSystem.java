package de.bauhd.system;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ServerSystem extends JavaPlugin {

    @Override
    public void onEnable() {

        this.loadConfig();

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

    public void loadConfig() {
        if (!this.getDataFolder().exists()) this.getDataFolder().mkdir();

        final File file = new File(getDataFolder(), "config.yml");

        if (!file.exists()) {
            try (final InputStream inputStream = this.getResource("config.yml")) {
                Files.copy(inputStream, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
