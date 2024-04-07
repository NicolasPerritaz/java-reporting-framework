plugins {
    `java-library`
    `jvm-test-suite`
}

group = "org.javareporting.framework"
version = "1.0-SNAPSHOT"

val openPdfVersion = "2.0.1"
val jUnitVersion = "5.9.1"
val jexlVersion = "3.3"
val mockitoVersion = "5.11.0"
val assertjVersion = "3.25.3"

repositories {
    mavenCentral()
}

dependencies {
    api("com.github.librepdf:openpdf:$openPdfVersion")
    api("org.apache.commons:commons-jexl3:$jexlVersion")
    testImplementation(platform("org.junit:junit-bom:$jUnitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
}

tasks.test {
    useJUnitPlatform()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }

        register<JvmTestSuite>("integrationTest") {
            dependencies {
                implementation(project())
            }

            sources {
                java {
                    setSrcDirs(listOf("src/it/java"))
                }
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}