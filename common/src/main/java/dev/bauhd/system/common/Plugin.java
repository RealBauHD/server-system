package dev.bauhd.system.common;

import java.util.logging.Logger;
import org.bukkit.command.CommandMap;

public interface Plugin {

  CommandMap commandMap();

  Logger logger();
}
