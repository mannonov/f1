import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
