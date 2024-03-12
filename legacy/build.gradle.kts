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
    relocate("net.kyori.adventure", "dev.bauhd.relocation.adventure")
}

tasks.test {
    useJUnitPlatform()
}