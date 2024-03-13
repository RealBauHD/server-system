plugins {
    id("java")
    alias(libs.plugins.shadow)
}

dependencies {
    compileOnly(libs.spigot)

    implementation(project(":common"))
    implementation("net.kyori:adventure-platform-bukkit:4.3.2")
    implementation(libs.minimessage)
}

tasks.shadowJar {
    relocate("net.kyori", "dev.bauhd.relocation.kyori")
}

tasks.test {
    useJUnitPlatform()
}