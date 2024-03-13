plugins {
    id("java")
}

dependencies {
    compileOnly(libs.spigot)
    implementation(libs.configurate)
}

tasks.test {
    useJUnitPlatform()
}