package de.bauhd.system.command;

import de.bauhd.system.ServerSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public abstract class SystemCommand extends Command {

    private static final ServerSystem SERVER_SYSTEM = ServerSystem.getPlugin(ServerSystem.class);
    private static final String PREFIX = SERVER_SYSTEM.getConfig().getString("Prefix")
            .replace('&', '§');
    private static final ResourceBundle RESOURCE_BUNDLE = SERVER_SYSTEM.getResourceBundle();

    public SystemCommand(final @NotNull String name) {
        this(name, "/" + name);
    }

    public SystemCommand(final @NotNull String name,
                         final @NotNull String usage) {
        super(name, null, RESOURCE_BUNDLE.getString("command-usage").replace("%command%", usage), Collections.emptyList());
    }

    public List<String> defaultAliases() {
        return Collections.emptyList();
    }

    public boolean isPlayer(final @NotNull CommandSender commandSender) {
        if (commandSender instanceof Player) return true;
        commandSender.sendMessage(PREFIX + RESOURCE_BUNDLE.getString("no-player"));
        return false;
    }

    public boolean testPermission(final @NotNull CommandSender commandSender, final @NotNull String... strings) {
        for (final String s : strings) if (commandSender.hasPermission(s)) return true;
        if (commandSender.hasPermission("system.*")) return true;
        commandSender.sendMessage(PREFIX + RESOURCE_BUNDLE.getString("no-permission"));
        return false;
    }

    public boolean isOnline(final @NotNull CommandSender commandSender, final @Nullable Player player) {
        if (player != null) return true;
        commandSender.sendMessage(PREFIX + RESOURCE_BUNDLE.getString("player-not-found"));
        return false;
    }

    public ServerSystem serverSystem() {
        return SERVER_SYSTEM;
    }

    public String prefix() {
        return PREFIX;
    }

}
