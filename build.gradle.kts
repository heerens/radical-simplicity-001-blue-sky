plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    id("gg.jte.gradle") version "3.1.16"

    id("au.id.wale.tailwind") version "0.2.0"
}

group = "com.radicalsimplicity"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

tasks.named("compileKotlin") {
    dependsOn("tailwindCompile")
    dependsOn("generateJte")
}

tailwind {
    version = "3.4.17"
    configPath = "src/main/resources/tailwind"
    input = "src/main/resources/tailwind/style.css"
    output = "src/main/resources/static/style.css"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("gg.jte:jte-spring-boot-starter-3:3.1.16")
    implementation("gg.jte:jte-kotlin:3.1.16")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

jte {
    sourceDirectory.set(file("src/main/kotlin/com/radicalsimplicity/bluesky/adapter/web").toPath())
    generate()
}

tasks.withType<Test> {
    useJUnitPlatform()
}
