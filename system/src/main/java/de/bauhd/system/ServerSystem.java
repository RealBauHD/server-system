package de.bauhd.system;

import de.bauhd.system.command.commands.*;
import de.bauhd.system.listener.PlayerJoinQuitListener;
import de.bauhd.system.updater.Updater;
import org.apache.commons.lang.LocaleUtils;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public final class ServerSystem extends JavaPlugin {

    private Updater updater;
    private ResourceBundle resourceBundle;

    @Override
    public void onEnable() {

        this.updater = new Updater(this);

        this.loadConfig();

        this.registerCommands();
        this.registerEvents();

        this.updater.checkUpdate();

    }

    @Override
    public void onDisable() {

    }

    public void loadConfig() {
        if (!this.getDataFolder().exists()) this.getDataFolder().mkdir();

        final File file = new File(this.getDataFolder(), "config.yml");

        if (!file.exists()) {
            try (final InputStream inputStream = this.getResource("config.yml")) {
                Files.copy(inputStream, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.resourceBundle = ResourceBundle.getBundle("messages", LocaleUtils.toLocale(this.getConfig().getString("Locale")));
    }

    private void registerCommands() {
        final Map<String, Class<? extends de.bauhd.system.command.SystemCommand>> systemCommands = new HashMap<>();

        systemCommands.put("clearchat", ClearChatCommand.class);
        systemCommands.put("day", DayCommand.class);
        systemCommands.put("enderchest", EnderChestCommand.class);
        systemCommands.put("feed", FeedCommand.class);
        systemCommands.put("fly", FlyCommand.class);
        systemCommands.put("gamemode", GameModeCommand.class);
        systemCommands.put("head", HeadCommand.class);
        systemCommands.put("heal", HealCommand.class);
        systemCommands.put("invsee", InvseeCommand.class);
        systemCommands.put("night", NightCommand.class);
        systemCommands.put("system", SystemCommand.class);
        systemCommands.put("tphere", TpHereCommand.class);
        systemCommands.put("tpto", TpToCommand.class);
        systemCommands.put("workbench", WorkbenchCommand.class);

        final File file = new File(this.getDataFolder(), "commands.yml");
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        try {
            final String commandPrefix = "server-system";
            // with Paper, it is way easier
            final CommandMap commandMap = (CommandMap)
                    this.getServer().getClass().getMethod("getCommandMap").invoke(this.getServer());

            for (final String commandName : systemCommands.keySet()) {
                configuration.set(commandName + ".Enabled", configuration.getBoolean(commandName + ".Enabled", true));
                if (configuration.getBoolean(commandName + ".Enabled")) {
                    final de.bauhd.system.command.SystemCommand command = systemCommands.get(commandName)
                            .getConstructor()
                            .newInstance();
                    final List<String> aliases = configuration.getList(commandName + ".Aliases", command.defaultAliases()).stream()
                            .map(Object::toString).collect(Collectors.toList());
                    configuration.set(commandName + ".Aliases", aliases);
                    command.setAliases(aliases);
                    commandMap.register(commandName, commandPrefix, command);
                }
            }
            configuration.save(file);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | IOException |
                 InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void registerEvents() {
        final PluginManager pluginManager = this.getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerJoinQuitListener(), this);
    }

    public Updater getUpdater() {
        return this.updater;
    }

    public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

}
