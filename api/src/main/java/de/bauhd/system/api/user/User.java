package de.bauhd.system.api.user;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.UUID;

public interface User {

    /**
     * @return the unique id of the user
     */
    @NotNull UUID getUniqueId();

    /**
     * @return the name of the user
     */
    @NotNull String getName();

    /**
     * @return the money of the player
     */
    int getMoney();

    /**
     * @param money the money to set
     */
    void setMoney(final int money);

    /**
     * @param money the money to add
     */
    void addMoney(final int money);

    /**
     * @param money the money to remove
     */
    void removeMoney(final int money);

    /**
     * @return the player data file of the user
     */
    @NotNull File getFile();

}
