package dev.bauhd.system.common.user;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

public final class UserManager {

  private final UserProvider provider;
  private final Map<Player, User> users;

  public UserManager(final UserProvider provider) {
    this.provider = provider;
    this.users = new HashMap<>();
  }

  public User user(final Player player) {
    return this.users.computeIfAbsent(player, this.provider::user);
  }
}
