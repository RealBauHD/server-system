package dev.bauhd.system.common.user;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface UserProvider {

  User user(Player player);
}
