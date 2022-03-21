plugins {
    kotlin("jvm") version "1.5.10"
}

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}