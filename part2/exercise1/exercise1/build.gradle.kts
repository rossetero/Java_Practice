plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.jar {
      manifest.attributes["Main-Class"] = "org.example.Main"
}

