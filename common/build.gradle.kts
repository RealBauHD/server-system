plugins {
    id("java")
}

dependencies {
    implementation(libs.spigot)
}

tasks.test {
    useJUnitPlatform()
}