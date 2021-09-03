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

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/annotations/README.md)



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

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/assertions/README.md)



### Encoding

Kommons provides easy ways to encode data in Base16 (hexadecimal) and Base64.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/encoding/README.md)



### INI Files

Kommons adds an easy way to read and write INI files.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/ini-files/README.md)



### I/O Utilities

While streams are not supported in multiplatform projects, Kommons adds utilities to at least easily
convert primitives (like Longs) to byte arrays and vice versa.

**Coming soon:** Stream utilities for the JVM target.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/io/README.md)



### Logging

Kommons does not come with its own logging framework (yet), but it provides lightweight handlers
and formatters for the standard Java logging library.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/logging/README.md)



### Parser

Kommons also adds utilities for easily parsing textual inputs.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/parser/README.md)



### Security

The security library of Kommons add multiplatform security utils, such as MD5, SHA1,
but also introduces it's own features, such as an encoded digest string.

**Example 1:**
```kotlin
// See: https://en.wikipedia.org/wiki/SHA-1#Example_hashes
val data = "The quick brown fox jumps over the lazy dog".encodeToByteArray()
val hash = data.sha1().base16() // -> 2fd4e1c67a2d28fced849ee1bb76e7391b93eb12
```

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/security/README.md)



### Utilities

Besides all other features, Kommons also adds a bunch of smaller utilities, such as easily defining
time durations, useful ANSI constants, array concatenations, multiplatform system calls and more.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/utils/README.md)



### UUIDs

Kommons also adds a multiplatform implementation of a UUID, as defined by RFC 4122.

[➥ Further Reading](https://github.com/TASSIA710/kommons/blob/main/docs/uuid/README.md)





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

*Coming soon.*
