package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public final class EnderChestCommand extends SystemCommand {

    public EnderChestCommand() {
        super("enderchest", "/enderchest <Player>");
    }

    @Override
    public boolean execute(CommandSender commandSender, String label, String[] args) {
        if (this.isPlayer(commandSender)) {
            final Player player = (Player) commandSender;

            if (args.length == 1) {
                final Player target = Bukkit.getPlayer(args[0]);

                if (this.testPermission(player, "system.command.enderchest.other")) {
                    if (target != null) {
                        player.openInventory(target.getEnderChest());
                    } else {
                        player.sendMessage(this.prefix() + this.serverSystem().getConfig().getString("Messages.Not-found"));
                    }
                }
            } else {
                if (this.testPermission(player, "system.command.enderchest")) {
                    player.openInventory(player.getEnderChest());
                }
            }
        }
        return true;
    }

    @Override
    public List<String> defaultAliases() {
        return Collections.singletonList("ec");
    }

}
