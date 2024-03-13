plugins {
    id("java")
    alias(libs.plugins.shadow)
}

dependencies {
    compileOnly(libs.paper)
    compileOnly(libs.minimessage) // since 1.18 in paper

    implementation(project(":common"))
}

tasks.test {
    useJUnitPlatform()
}