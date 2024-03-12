plugins {
    id("java")
    alias(libs.plugins.shadow)
}

dependencies {
    compileOnly(libs.paper)
    compileOnly(libs.minimessage)

    implementation(project(":common"))
}

tasks.test {
    useJUnitPlatform()
}