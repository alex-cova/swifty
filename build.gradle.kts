import org.gradle.jvm.tasks.Jar

plugins {
    id("java-library")
    id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.antlr:antlr4:4.10.1")
    implementation("org.ow2.asm:asm-all:5.2")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("commons-io:commons-io:2.11.0")

    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.apache.commons:commons-lang3:3.12.0")

    compileOnly("org.jetbrains:annotations:23.0.0")
}


val fatJar = task("fatJar", type = Jar::class) {
    archiveBaseName.set("swifty")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = "com.swifty.Compiler"
    }
    from(configurations.runtimeClasspath.get()
        .map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

