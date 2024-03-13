package dev.bauhd.system.common.user;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public final class UserManager implements Listener {

  private final UserProvider provider;
  private final Map<Player, User> users;

  public UserManager(final UserProvider provider) {
    this.provider = provider;
    this.users = new HashMap<>();
  }

  public User user(final Player player) {
    return this.users.computeIfAbsent(player, this.provider::user);
  }

  @EventHandler
  public void handle(final PlayerQuitEvent event) {
    this.users.remove(event.getPlayer());
  }
}
