plugins {
    java
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.diffplug.spotless") version "6.25.0"
    // https://gradle-pitest-plugin.solidsoft.info/
    id("info.solidsoft.pitest") version "1.19.0-rc.1"
    id("jacoco")
}

group = "com.koreaap"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    dependsOn(tasks.spotlessCheck)
    finalizedBy(tasks.jacocoTestReport)
    finalizedBy(tasks.jacocoTestCoverageVerification)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    doLast {
        val reportPath = "${layout.buildDirectory.get().asFile.absolutePath.replace("\\", "/")}/reports/jacoco/test/html/index.html"
        println("테스트 커버리지 리포트: file:///$reportPath")
    }
}

tasks.pitest {
    doLast {
        val reportPath = "${layout.buildDirectory.get().asFile.absolutePath.replace("\\", "/")}/reports/pitest/index.html"
        println("결함 삽입 테스트 리포트: file:///$reportPath")
    }
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.test, tasks.jacocoTestReport)
    violationRules {
        rule {

            limit {
                minimum = 0.80.toBigDecimal() // 80% 이상이어야 통과
            }
        }
    }
    classDirectories.setFrom(
        files(
            classDirectories.files.map {
                fileTree(it) {
                    exclude(
                        "com/koreaap/itdev2/TddStudyApplication.class",
                    )
                }
            },
        ),
    )
}

tasks.register("testAndBuild") {
    dependsOn("test", "build")
    group = "build"
    description = "테스트 후 빌드를 수행합니다."
}

spotless {
    java {
        googleJavaFormat() // Google Java Style 적용
        target("src/**/*.java")
    }
    kotlinGradle {
        ktlint()
        target("*.kts")
    }
}

pitest {
    junit5PluginVersion.set("1.2.1")
    targetClasses.set(listOf("com.koreaap.*")) // mutation test 대상 패키지
    targetTests.set(listOf("com.koreaap.*"))
    threads.set(4)
    outputFormats.set(listOf("HTML"))
    timestampedReports.set(false)
}
