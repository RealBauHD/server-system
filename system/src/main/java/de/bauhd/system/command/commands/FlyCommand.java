package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class FlyCommand extends SystemCommand {

    public FlyCommand() {
        super("fly", "/fly <Player>");
    }

    @Override
    public boolean execute(CommandSender sender, String arg2, String[] args) {
        if (this.isPlayer(sender)) {
            final Player player = (Player) sender;

            if (this.testPermission(sender, "system.command.fly", "system.command.fly.*")) {
                if (args.length == 0) {
                    if (player.getAllowFlight()) {
                        player.sendMessage(this.prefix() + this.serverSystem().getConfig().getString("System.Fly.Deaktiviert").replaceAll("&", "§"));
                        player.setAllowFlight(false);
                    } else {
                        player.sendMessage(this.prefix() + this.serverSystem().getConfig().getString("System.Fly.Aktiviert").replaceAll("&", "§"));
                        player.setAllowFlight(true);
                    }
                } else if (args.length == 1) {
                    if (this.testPermission(sender,"system.command.fly.other", "system.command.fly.*")) {
                        final Player target = Bukkit.getPlayer(args[0]);

                        if (this.isOnline(sender, target)) {
                            if (target.getAllowFlight()) {
                                player.sendMessage(this.prefix() + "§cDer Spieler §e" + target.getName()
                                        + " §ckann jetzt nicht mehr Fliegen.");
                                target.sendMessage(this.prefix() + "§cDu kannst jetzt nicht mehr Fliegen.");
                                target.setAllowFlight(false);
                            } else {
                                player.sendMessage(this.prefix() + "§aDer Spieler §e" + target.getName()
                                        + " §akann jetzt Fliegen.");
                                target.sendMessage(this.prefix() + "§aDu kannst jetzt Fliegen.");
                                target.setAllowFlight(true);
                            }
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
