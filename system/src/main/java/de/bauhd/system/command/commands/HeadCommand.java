package de.bauhd.system.command.commands;

import de.bauhd.system.command.SystemCommand;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public final class HeadCommand extends SystemCommand {

    private Supplier<ItemStack> constructHeadStack;

    public HeadCommand() {
        super("head", "/head <Name>");

        try {
            this.constructHeadStack = () -> new ItemStack(Material.valueOf("PLAYER_HEAD"));
        } catch (IllegalArgumentException e) {
            this.constructHeadStack = () -> new ItemStack(Material.valueOf("SKULL_ITEM"), 1, (short) 3);
        }
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String label, String[] args) {
        if (this.isPlayer(sender)) {
            final Player player = (Player) sender;

            if (this.testPermission(sender, "system.command.head")) {
                if (args.length == 0) {
                    return false;
                } else if (args.length == 1) {
                    final String headName = args[0];

                    final ItemStack itemStack = this.constructHeadStack.get();
                    final SkullMeta itemMeta = (SkullMeta) itemStack.getItemMeta();
                    assert itemMeta != null;
                    itemMeta.setOwner(headName);
                    itemStack.setItemMeta(itemMeta);

                    player.getInventory().addItem(itemStack);
                    player.sendMessage(this.prefix() + "§aDu hast den Kopf von §e" + headName + " §aerhalten.");
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<String> defaultAliases() {
        return Collections.singletonList("skull");
    }

}
