package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GameModeCommand extends SystemCommand {

    public GameModeCommand() {
        super("gamemode", "/gamemode 0 | 1 | 2 | 3 <Player>");
    }

    @Override
    public boolean execute(CommandSender commandSender, String label, String[] args) {
        if (this.isPlayer(commandSender)) {
            final Player player = (Player) commandSender;

            if (this.testPermission(commandSender, "system.command.gamemode")) {
                if (args.length == 0) {
                    return false;
                } else if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "0":
                        case "s":
                        case "survival":
                            player.sendMessage(this.prefix() + this.serverSystem().getConfig()
                                    .getString("System.Gamemode.Überleben").replaceAll("&", "§"));
                            player.setGameMode(GameMode.SURVIVAL);
                            break;
                        case "1":
                        case "c":
                        case "creative":
                            player.sendMessage(this.prefix() + this.serverSystem().getConfig()
                                    .getString("System.Gamemode.Creative").replaceAll("&", "§"));
                            player.setGameMode(GameMode.CREATIVE);
                            break;
                        case "2":
                        case "a":
                        case "adventure":
                            player.sendMessage(this.prefix() + this.serverSystem().getConfig()
                                    .getString("System.Gamemode.Abenteuer").replaceAll("&", "§"));
                            player.setGameMode(GameMode.ADVENTURE);
                            break;
                        case "3":
                        case "sp":
                        case "spectator":
                            player.sendMessage(this.prefix() + this.serverSystem().getConfig()
                                    .getString("System.Gamemode.Spectator").replaceAll("&", "§"));
                            player.setGameMode(GameMode.SPECTATOR);
                            break;
                        default:
                            return false;
                    }
                } else if (args.length == 2) {
                    final Player target = Bukkit.getPlayer(args[1]);

                    if (this.isOnline(commandSender, target)) {
                        switch (args[0].toLowerCase()) {
                            case "0":
                            case "s":
                            case "survival":
                                player.sendMessage(this.prefix() + "§6Du hast " + target.getName()
                                        + " §6in Gamemode Überleben gesetzt.");
                                target.sendMessage(this.prefix() + "§6Du wurdest von " + player.getName()
                                        + " §6in den Gamemode Überleben gesetzt.");
                                target.setGameMode(GameMode.SURVIVAL);
                                break;
                            case "1":
                            case "c":
                            case "creative":
                                player.sendMessage(this.prefix() + "§6Du hast " + target.getName()
                                        + " §6in Gamemode Creative gesetzt.");
                                target.sendMessage(this.prefix() + "§6Du wurdest von " + player.getName()
                                        + " §6in den Gamemode Creative gesetzt.");
                                target.setGameMode(GameMode.CREATIVE);
                                break;
                            case "2":
                            case "a":
                            case "adventure":
                                player.sendMessage(this.prefix() + "§6Du hast " + target.getName()
                                        + " §6in Gamemode Adventure gesetzt.");
                                target.sendMessage(this.prefix() + "§6Du wurdest von " + player.getName()
                                        + " §6in den Gamemode Adventure gesetzt.");
                                target.setGameMode(GameMode.ADVENTURE);
                                break;
                            case "3":
                            case "sp":
                            case "spectator":
                                player.sendMessage(this.prefix() + "§6Du hast " + target.getName()
                                        + " §6in Gamemode Spectator gesetzt.");
                                target.sendMessage(this.prefix() + "§6Du wurdest von " + player.getName()
                                        + " §6in den Gamemode Spectator gesetzt.");
                                target.setGameMode(GameMode.SPECTATOR);
                                break;
                            default:
                                return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return Arrays.asList("survival", "creative", "adventure", "spectator");
    }

    @Override
    public List<String> defaultAliases() {
        return Collections.singletonList("gm");
    }

}