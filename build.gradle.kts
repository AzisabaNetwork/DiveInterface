plugins {
    kotlin("jvm") version "1.8.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    `maven-publish`
    java
}

group = "com.flora30"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://mvn.lumine.io/repository/maven-public/")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("io.lumine:Mythic-Dist:5.0.0-SNAPSHOT")
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    compileOnly("com.comphenix.protocol:ProtocolLib:4.7.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

nexusPublishing {
    this.repositories {
        create("repo") {
            username.set(project.properties["repoUsername"].toString())
            password.set(project.properties["repoPassword"].toString())
            nexusUrl.set(uri("https://repo.azisaba.net/repository/maven-releases/"))
            snapshotRepositoryUrl.set(uri("https://repo.azisaba.net/repository/maven-snapshots/"))
        }
    }
}