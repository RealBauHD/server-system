package dev.bauhd.system.legacy.user;

import dev.bauhd.system.common.user.User;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public final class LegacyUser implements User {

  private final Player player;
  private final Audience audience;

  public LegacyUser(final Player player, final Audience audience) {
    this.player = player;
    this.audience = audience;
  }

  @Override
  public Player player() {
    return this.player;
  }

  @Override
  public void sendMessage(String message) {
    this.audience.sendMessage(MiniMessage.miniMessage().deserialize(message));
  }
}
