package dev.bauhd.system.legacy.user;

import dev.bauhd.system.common.user.User;
import dev.bauhd.system.common.user.UserProvider;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.entity.Player;

public final class LegacyUserProvider implements UserProvider {

  private final BukkitAudiences audiences;

  public LegacyUserProvider(final BukkitAudiences audiences) {
    this.audiences = audiences;
  }

  @Override
  public User user(Player player) {
    return new LegacyUser(player, this.audiences.player(player));
  }
}
