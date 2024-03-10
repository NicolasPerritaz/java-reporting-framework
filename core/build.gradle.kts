plugins {
    java
    `jvm-test-suite`
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