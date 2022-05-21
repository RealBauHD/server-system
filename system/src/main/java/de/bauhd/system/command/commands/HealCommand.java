package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class HealCommand extends SystemCommand {

    public HealCommand() {
        super("heal", "/heal <Player>");
    }

    @Override
    public boolean execute(CommandSender commandSender, String arg2, String[] args) {
        if (this.testPermission(commandSender, "system.command.heal", "system.command.heal.*")) {
            if (args.length == 0) {
                if (this.isPlayer(commandSender)) {
                    final Player player = (Player) commandSender;

                    player.sendMessage(this.prefix() + "§aDu wurdest geheilt.");
                    player.setHealth(20);
                    player.setFoodLevel(20);
                }
            } else if (args.length == 1) {
                if (this.testPermission(commandSender, "system.command.heal.other", "system.command.heal.*")) {
                    final Player target = Bukkit.getPlayer(args[0]);

                    if (this.isOnline(commandSender, target)) {
                        commandSender.sendMessage(this.prefix() + "§aDu hast " + target.getName() + " §ageheilt.");
                        target.sendMessage(
                                this.prefix() + "§aDu wurdest von " + commandSender.getName() + " §ageheilt.");
                        target.setHealth(20);
                        target.setFoodLevel(20);
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

}