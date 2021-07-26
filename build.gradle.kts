group = "net.tassia"
version = "1.0.0-P2"

plugins {
	java; `java-library`; `maven-publish`
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
	useJUnitPlatform()
}

java {
	withJavadocJar()
	withSourcesJar()

	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
		}
	}
	repositories {
		maven("https://nexus.tassia.net/repository/maven-releases/") {
			credentials {
				username = (findProperty("publishMavenUsername") as String?) ?: "N/A"
				password = (findProperty("publishMavenPassword") as String?) ?: "N/A"
			}
		}
	}
}
