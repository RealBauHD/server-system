plugins {
    id("java")
}

allprojects {
    group = "dev.bauhd"
    version = "3.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://hub.spigotmc.org/nexus/content/repositories/public/")
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
}

tasks.test {
    useJUnitPlatform()
}