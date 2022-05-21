package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class InvseeCommand extends SystemCommand {

	public InvseeCommand() {
		super("invsee", "/invsee <Player>");
	}

	@Override
	public boolean execute(CommandSender commandSender, String label, String[] args) {
		if (this.isPlayer(commandSender)) {
			final Player player = (Player) commandSender;
			
			if (this.testPermission(commandSender, "system.command.invsee")) {
				if (args.length == 1) {
					final Player target = Bukkit.getPlayer(args[0]);
					
					if (this.isOnline(commandSender, target)) {
						player.openInventory(target.getInventory());
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
