# Utilities

*Coming soon.*





## Installation

### Gradle Kotlin

```kotlin
repositories {
    maven("https://nexus.tassia.net/repository/maven-public/")
}

dependencies {
    implementation("net.tassia.kommons", "kommons-utils", "1.0.0")
}
```

### Gradle Groovy

```groovy
repositories {
    maven {
        url = uri('https://nexus.tassia.net/repository/maven-public/')
    }
}

dependencies {
    implementation 'net.tassia.kommons:kommons-utils:1.0.0'
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>tassia-nexus</id>
        <url>https://nexus.tassia.net/repository/maven-public/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>net.tassia.kommons</groupId>
        <artifactId>kommons-utils</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### Other

[➥ View Artifact](https://nexus.tassia.net/#browse/browse:maven-public:net/tassia/kommons/kommons-utils/1.0.0)
