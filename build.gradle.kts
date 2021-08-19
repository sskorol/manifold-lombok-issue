plugins {
    java
    `java-library`
}

group = "io.github.sskorol"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val lombokVersion by extra("1.18.20")
val manifoldVersion by extra("2021.1.14")

repositories {
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
}

configurations {
    testImplementation {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("one.util:streamex:0.7.3")

    implementation("systems.manifold:manifold-ext-rt:${manifoldVersion}")
    implementation("systems.manifold:manifold-ext:${manifoldVersion}")

    annotationProcessor("systems.manifold:manifold-ext:${manifoldVersion}")
    testAnnotationProcessor("systems.manifold:manifold-ext:${manifoldVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    testImplementation("org.projectlombok:lombok:${lombokVersion}")
    testAnnotationProcessor("org.projectlombok:lombok:${lombokVersion}")
}

tasks.compileJava {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xplugin:Manifold")
}

tasks.withType(Wrapper::class) {
    gradleVersion = "7.1.1"
}
