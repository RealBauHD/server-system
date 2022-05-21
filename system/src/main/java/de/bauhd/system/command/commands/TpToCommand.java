package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class TpToCommand extends SystemCommand {

    public TpToCommand() {
        super("tpto", "/tpto <Player>");
    }

    @Override
    public boolean execute(CommandSender sender, String arg2, String[] args) {
        if (this.isPlayer(sender)) {
            final Player player = (Player) sender;

            if (this.testPermission(sender, "system.command.tpto")) {
                if (args.length == 1) {
                    final Player target = Bukkit.getPlayer(args[0]);
                    if (this.isOnline(sender, target)) {
                        player.sendMessage(
                                this.prefix() + "§aDu wurdest zu §e" + target.getName() + " §ateleportiert.");
                        player.teleport(target.getLocation());
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
