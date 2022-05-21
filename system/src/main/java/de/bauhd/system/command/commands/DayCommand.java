package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class DayCommand extends SystemCommand {

	public DayCommand() {
		super("day", "/day <World>");
	}

	@Override
	public boolean execute(CommandSender commandSender, String label, String[] args) {
		if (this.testPermission(commandSender, "system.command.day")) {
			if (args.length == 0) {
				if (this.isPlayer(commandSender)) {
					final Player player = (Player) commandSender;

					player.getWorld().setTime(0L);
					player.sendMessage(this.prefix() + "§7Du hast die Zeit auf §eTag §7gestellt.");
				}
			} else if (args.length == 1) {
				Bukkit.getWorld(args[0]).setTime(0L);
				commandSender.sendMessage(this.prefix() + "§7Du hast die Zeit in §e" + args[0] + " §7auf §eTag §7gestellt.");
			} else {
				return false;
			}
		}
		return true;
	}
}
