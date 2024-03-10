plugins {
    id("java")
}

group = "org.javareporting.framework"
version = "1.0-SNAPSHOT"

val openPdfVersion = "2.0.1"
val jUnitVersion = "5.9.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.librepdf:openpdf:$openPdfVersion")
    testImplementation(platform("org.junit:junit-bom:$jUnitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}