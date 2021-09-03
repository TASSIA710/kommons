package net.tassia

/**
 * Sugar-syntax for the ternary operator (which doesn't exist in Kotlin).
 *
 * **Note:** This function always evaluates both values, no matter the expression result.
 *
 * @param test the expression to check
 * @param onTrue the value if the expression is `true`
 * @param onFalse the value if the expression is `false`
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <T> either(test: Boolean, onTrue: T, onFalse: T): T {
	return if (test) onTrue else onFalse
}

/**
 * Sugar-syntax for the ternary operator (which doesn't exist in Kotlin).
 * If the expression is `true`, the `onTrue` function is called.
 * Otherwise, the `onFalse` function is called respectively.
 *
 * @param test the expression to check
 * @param onTrue the value if the expression is `true`
 * @param onFalse the value if the expression is `false`
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
inline fun <T> either(test: Boolean, onTrue: () -> T, onFalse: () -> T): T {
	return if (test) onTrue() else onFalse()
}

/**
 * Sugar-syntax for the ternary operator (which doesn't exist in Kotlin).
 *
 * **Note:** This function always evaluates the `onFalse` value, no matter the expression result.
 *
 * @param test the expression to check
 * @param onTrue the value if the expression is `true`
 * @param onFalse the value if the expression is `false`
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
inline fun <T> either(test: Boolean, onTrue: () -> T, onFalse: T): T {
	return if (test) onTrue() else onFalse
}

/**
 * Sugar-syntax for the ternary operator (which doesn't exist in Kotlin).
 *
 * **Note:** This function always evaluates the `onTrue` value, no matter the expression result.
 *
 * @param test the expression to check
 * @param onTrue the value if the expression is `true`
 * @param onFalse the value if the expression is `false`
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
inline fun <T> either(test: Boolean, onTrue: T, onFalse: () -> T): T {
	return if (test) onTrue else onFalse()
}
