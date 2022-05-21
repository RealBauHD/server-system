package de.bauhd.system.updater;

import de.bauhd.system.ServerSystem;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Updater {

    private final ServerSystem serverSystem;

    private boolean update = false;

    public Updater(final ServerSystem serverSystem) {
        this.serverSystem = serverSystem;
    }

    public void checkUpdate() {
        update = !this.getVersionFromURL().contains(this.serverSystem.getDescription().getVersion());
    }

    public boolean mustUpdate() {
        return update;
    }

    private @NotNull String getVersionFromURL() {
        final StringBuilder stringBuilder = new StringBuilder();

        try {
            final BufferedReader bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new URL("https://api.spigotmc.org/legacy/update.php?resource=62492")
                                            .openStream()));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(" ").append(s);
            }
            bufferedReader.close();
        } catch (Exception e) {
            this.update = false;
        }
        return stringBuilder.toString();
    }

}
