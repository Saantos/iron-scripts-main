plugins {
    kotlin("jvm") version "2.0.10"
}

repositories {
    mavenCentral()
    google()
    maven {
        url = uri("https://repo.powbot.org/releases")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.powbot:client-sdk:1.+")
    implementation("org.powbot:client-sdk-loader:1.+")
    implementation("com.google.guava:guava:32.0.0-android")
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.0")
}

tasks.test {
    useJUnitPlatform()
}
