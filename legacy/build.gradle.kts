plugins {
    id("java")
}

repositories {

}

dependencies {
    implementation(project(":common"))
    implementation(libs.spigot)
}

tasks.test {
    useJUnitPlatform()
}