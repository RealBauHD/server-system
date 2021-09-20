package de.bauhd.system.api.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public interface UserHandler {

    /**
     * @return the users
     */
    @NotNull Collection<User> getUsers();

    /**
     * @param uuid the uuid to get the user
     * @return the user
     */
    @Nullable User getUser(final @NotNull UUID uuid);

    /**
     * @param name the name to get the user
     * @return the user
     */
    @Nullable User getUser(final @NotNull String name);

    /**
     * @return the user count
     */
    int getUserCount();

}
