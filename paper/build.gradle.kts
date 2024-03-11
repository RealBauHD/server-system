plugins {
    id("java")
}

dependencies {
    implementation(project(":common"))
    implementation(libs.paper)
}

tasks.test {
    useJUnitPlatform()
}