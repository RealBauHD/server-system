package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public final class ClearChatCommand extends SystemCommand {

    public ClearChatCommand() {
        super("clearchat");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (this.testPermission(sender, "system.command.clearchat")) {
            for (final Player all : Bukkit.getOnlinePlayers()) {
                for (int i = 0; i < 100; i++) {
                    all.sendMessage("§a§b");
                }

                all.sendMessage(this.prefix() + "§7Der Chat wurde von §a" + sender.getName() + " §7geleert.");
            }
        }
        return true;
    }

    @Override
    public List<String> defaultAliases() {
        return Collections.singletonList("cc");
    }

}
