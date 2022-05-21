package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class TpHereCommand extends SystemCommand {

    public TpHereCommand() {
        super("tphere", "/tphere <Player>");
    }

    @Override
    public boolean execute(CommandSender sender, String arg2, String[] args) {
        if (this.isPlayer(sender)) {
            final Player player = (Player) sender;

            if (this.testPermission(sender, "system.command.tphere")) {
                if (args.length == 1) {
                    final Player target = Bukkit.getPlayer(args[0]);
                    if (this.isOnline(sender, target)) {
                        player.sendMessage(
                                this.prefix() + "§aDer Spieler §e" + target.getName() + " §awird zu dir teleportiert.");
                        target.teleport(player.getLocation());
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
