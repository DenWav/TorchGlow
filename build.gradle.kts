/*
 * TorchGlow
 *
 * IntelliJ JVM Bytecode Psi Equivalency Framework
 *
 * Copyright (c) 2017 Kyle Wood
 *
 * MIT License
 *
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        maven {
            name = "intellij-plugin-service"
            setUrl("https://dl.bintray.com/jetbrains/intellij-plugin-service")
        }
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.1.3-2" // kept in sync with IntelliJ's bundled dep
    idea
    id("org.jetbrains.intellij") version "0.2.15"
    id("net.minecrell.licenser") version "0.3"
}

defaultTasks("build")

val CI = System.getenv("CI") != null

val ideaVersion: String by extra
val javaVersion: String by extra
val kotlinVersion: String by extra
val downloadIdeaSources: String by extra

val compileKotlin by tasks
val runIde: JavaExec by tasks

configurations {
    "kotlin"()
    "compileOnly" { extendsFrom("kotlin"()) }
    "testCompile" { extendsFrom("kotlin"()) }
}

repositories {
    mavenCentral()
}

java {
    setSourceCompatibility(javaVersion)
    setTargetCompatibility(javaVersion)
}

dependencies {
    "kotlin"(kotlinModule("stdlib")) { isTransitive = false }
    compile(kotlinModule("stdlib-jre7")) { isTransitive = false }
    compile(kotlinModule("stdlib-jre8")) { isTransitive = false }
}

intellij {
    // IntelliJ IDEA dependency
    version = ideaVersion

    // not really a plugin, but set this up so we can test
    pluginName = "TorchGlow"

    downloadSources = !CI && downloadIdeaSources.toBoolean()

    sandboxDirectory = project.rootDir.canonicalPath + "/.sandbox"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = javaVersion
}

idea {
    module {
        excludeDirs.add(file(intellij.sandboxDirectory))
    }
}

license {
    header = file("copyright.txt")
    include("**/*.kt", "**/*.gradle", "**/*.xml", "**/*.html")
}

// Workaround problems caused by separate output directories for classes in Gradle 4.0
// gradle-intellij-plugin needs to be updated to support them properly
java.sourceSets.all {
    output.classesDir = File(buildDir, "classes/$name")
}

runIde {
    maxHeapSize = "2G"

    (findProperty("intellijJre") as? String)?.let(this::setExecutable)

    System.getProperty("debug")?.let {
        systemProperty("idea.ProcessCanceledException", "disabled")
        systemProperty("idea.debug.mode", "true")
    }
}

inline operator fun <T : Task> T.invoke(a: T.() -> Unit): T = apply(a)
fun DependencyHandlerScope.kotlinModule(module: String) = kotlinModule(module, kotlinVersion) as String
