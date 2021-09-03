package net.tassia

/**
 * Declares that an object is merely used as a namespace.
 *
 * Namespaces are currently not supported in Kotlin and, in fact, might
 * just never get added.
 *
 * Thus, the only way to declare real static properties and functions is by declaring them on package-level
 * or in an object with the `JvmStatic` annotation. It is fine for extension functions to be declared on
 * package-level, but for constants it might start to get quite messy.
 *
 * The downside of declaring constants in an object as is that always a class for the object is created.
 * This annotation allows 3rd party compilers to detect objects you simply use as a namespace and
 * 1. convert to a single class, or
 * 2. move all static properties and functions to the parent class (on companion objects), or
 * 3. do nothing, as this isn't really a big performance drawback.
 *
 * Furthermore, this annotation allows for easy refactoring of your code base,
 * if actual namespaces will ever get added.
 *
 * **Requirements for a namespace**
 * - The object must extend [kotlin.Any] and implement no interfaces.
 * - The object must never be passed as a value.
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
annotation class Namespace
