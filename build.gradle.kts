plugins {
	java
	id("org.springframework.boot") version "3.0.5"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.s3"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.15")
	// https://mvnrepository.com/artifact/org.projectlombok/lombok
	compileOnly("org.projectlombok:lombok:1.18.24")
	annotationProcessor("org.projectlombok:lombok:1.18.24")

//	implementation(platform("com.amazonaws:aws-java-sdk-bom:2.20.56"))
	implementation("software.amazon.awssdk:s3:2.20.26")

	// https://mvnrepository.com/artifact/org.projectlombok/lombok-mapstruct-binding
	//	implementation("org.projectlombok:lombok-mapstruct-binding:0.1.0")
}

tasks {
	withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
		enabled = true
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
