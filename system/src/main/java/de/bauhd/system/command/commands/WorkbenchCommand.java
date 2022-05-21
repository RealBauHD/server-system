package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public final class WorkbenchCommand extends SystemCommand {

    public WorkbenchCommand() {
        super("workbench");
    }

    @Override
    public boolean execute(CommandSender commandSender, String label, String[] args) {
        if (this.isPlayer(commandSender)) {
            if (this.testPermission(commandSender, "system.command.workbench")) {
                ((Player) commandSender).openWorkbench(null, true);
            }
        }
        return true;
    }

    @Override
    public List<String> defaultAliases() {
        return Arrays.asList("wb", "craft");
    }

}