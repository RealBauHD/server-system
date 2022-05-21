package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public final class FeedCommand extends SystemCommand {

    public FeedCommand() {
        super("feed", "/feed <Player>");
    }

    @Override
    public boolean execute(CommandSender commandSender, String arg2, String[] args) {
        if (this.testPermission(commandSender, "system.command.feed", "system.command.feed.*")) {
            if (args.length == 0) {
                if (this.isPlayer(commandSender)) {
                    final Player player = (Player) commandSender;

                    player.sendMessage(this.prefix() + "§aDein Hunger wurde aufgeladen.");
                    player.setFoodLevel(20);
                }
            } else if (args.length == 1) {
                if (this.testPermission(commandSender, "system.command.feed.other", "system.command.feed.*")) {
                    final Player target = Bukkit.getPlayer(args[0]);

                    if (this.isOnline(commandSender, target)) {
                        commandSender.sendMessage(this.prefix() + "§aDu hast von §e" + target.getName() + " §aden Hunger aufgeladen.");
                        target.sendMessage(this.prefix() + "§aDein Hunger wurde von §e" + commandSender.getName() + " §aaufgeladen.");
                        target.setFoodLevel(20);
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<String> defaultAliases() {
        return Collections.singletonList("eat");
    }

}