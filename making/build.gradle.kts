import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.geepawhill"
version = "1.0-SNAPSHOT"

plugins {
    application
    java
    kotlin("jvm")
    id("org.openjfx.javafxplugin") version "0.0.9"
}

repositories {
    maven {
        setUrl("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

application {
    mainClass.set("org.geepawhill.rw.making.MakerMainKt")
}

kotlin {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "14"
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

javafx {
    version = "15"
    modules = mutableListOf(
        "javafx.controls",
        "javafx.graphics",
        "javafx.fxml"
    )
}
dependencies {
    implementation("no.tornado:tornadofx:2.0.0-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.10")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("com.willowtreeapps.assertk:assertk:0.25")
}