plugins {
    id("java")
}

dependencies {
    compileOnly(libs.spigot)
}

tasks.test {
    useJUnitPlatform()
}