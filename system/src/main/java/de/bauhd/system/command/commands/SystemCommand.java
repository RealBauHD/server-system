package de.bauhd.system.command.commands;

import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public final class SystemCommand extends de.bauhd.system.command.SystemCommand {

    public SystemCommand() {
        super("system");
    }

    @Override
    public boolean execute(CommandSender sender, String arg2, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(this.prefix() + "§7Developer: §aBauHD");
            sender.sendMessage(this.prefix() + "§7System Version: §a"
                    + this.serverSystem().getDescription().getVersion());
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (this.testPermission(sender, "system.command.system.reload")) {
                    this.serverSystem().reloadConfig();
                    sender.sendMessage(this.prefix() + "§aDie Config wurde neu geladen.");
                }
            } else {
                sender.sendMessage(this.prefix() + "§7Developer: §aBauHD");
                sender.sendMessage(this.prefix() + "§7System Version: §a"
                        + this.serverSystem().getDescription().getVersion());
            }
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        if (sender.hasPermission("system.reload")) {
            return Collections.singletonList("reload");
        }
        return null;
    }

}
