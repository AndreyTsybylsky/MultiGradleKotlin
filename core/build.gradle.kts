plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-server:3.141.59")
    implementation("org.projectlombok:lombok:1.18.22")
    implementation("io.github.bonigarcia:webdrivermanager:5.0.2")
    implementation("io.github.bonigarcia:webdrivermanager:5.0.2")
    implementation("org.apache.logging.log4j:log4j-core:2.14.1")
    implementation("org.apache.logging.log4j:log4j-api:2.14.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}