# Kommons

![](https://img.shields.io/github/license/TASSIA710/kommons?label=License)
![](https://img.shields.io/github/v/release/TASSIA710/kommons?label=Stable)
![](https://img.shields.io/github/v/release/TASSIA710/kommons?label=Preview&include_prereleases)
![](https://img.shields.io/github/workflow/status/TASSIA710/kommons/Build/main?label=Build)

Adds multiplatform utilities, that save you time!

**Supported Platform:**

- [x] JVM
- [ ] JS/IR & JS/Legacy
- [ ] Native (all)





## Features

### Annotations

Kommons provides annotations, that may, or may not, be useful, depending on your use case.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/annotations/README.md)



### Assertions

Kommons provides a simple, lightweight, multiplatform framework for writing assertions semantically.
Your assertions can even include more heavy calculations, as Kotlins' inline functions allow for
the assertion framework, to only evaluate the assertion if enabled.

**Example 1:**
```kotlin
assert { expect(41) eq 42 }
```

**Result**:
> ```
> ╔══════════ « Assertion Failed » ══════════
> ║
> ║   What went wrong?
> ║     ➥ A different value was expected.
> ║
> ║   Where's the difference?
> ║     ├─ Expected: 42
> ║     └─ But got: 41
> ║
> ║   Interpretive Representation
> ║     ├─ Assertion: THIS == THAT
> ║     ├─ THIS: 42 (Int @ 2a)
> ║     └─ THAT: 41 (Int @ 29)
> ║
> ╚══════════════════════════════════════════
> ```

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/assertions/README.md)



### Encoding

Kommons provides easy ways to encode data in Base16 (hexadecimal) and Base64.

**Example 1:**
```kotlin
println("SGVsbG8gV29ybGQh".base64().decodeToString())
```

**Result:**
> Hello World!

**Example 2:**
```kotlin
println(byteArrayOf(
    0x3F, 0x5F, 0x7F
).base16())
```

**Result:**
> 3f5f7f

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/encoding/README.md)



### INI Files

Kommons adds an easy way to read and write INI files.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/ini-files/README.md)



### I/O Utilities

While streams are not supported in multiplatform projects, Kommons adds utilities to at least easily
convert primitives (like Longs) to byte arrays and vice versa.

**Coming soon:** Stream utilities for the JVM target.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/io/README.md)



### Logging

Kommons does not come with its own logging framework (yet), but it provides lightweight handlers
and formatters for the standard Java logging library.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/logging/README.md)



### Parser

Kommons also adds utilities for easily parsing textual inputs.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/parser/README.md)



### Security

The security library of Kommons add multiplatform security utils, such as MD5, SHA1,
but also introduces it's own features, such as an encoded digest string.

**Example 1:**
```kotlin
// See: https://en.wikipedia.org/wiki/SHA-1#Example_hashes
val data = "The quick brown fox jumps over the lazy dog".encodeToByteArray()
val hash = data.sha1().base16() // -> 2fd4e1c67a2d28fced849ee1bb76e7391b93eb12
```

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/security/README.md)



### Utilities

Besides all other features, Kommons also adds a bunch of smaller utilities, such as easily defining
time durations, useful ANSI constants, array concatenations, multiplatform system calls and more.

**Example 1:**
```kotlin
println(arrayOf("A", "B", "C").smartConcat())
```

**Result:**
> A, B and C

**Example 2:**
```kotlin
println(2.years)
```

**Result:**
> *2 years in milliseconds as a Long, a number so big, I'm not going to write it here.*

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/utils/README.md)



### UUIDs

Kommons also adds a multiplatform implementation of a UUID, as defined by RFC 4122.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/module/uuid/README.md)





## Installation

### Gradle Kotlin

```kotlin
repositories {
    maven("https://nexus.tassia.net/repository/maven-public/")
}

dependencies {
    implementation("net.tassia", "kommons-bom", "1.0.0")
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
    implementation 'net.tassia:kommons-bom:1.0.0'
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
        <groupId>net.tassia</groupId>
        <artifactId>kommons-bom</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### Other

[➥ View Artifact](https://nexus.tassia.net/#browse/browse:maven-public:net%2Ftassia%2Fkommons-bom%2F1.0.0)
