package net.tassia

/**
 * Concatenates all elements of this array.
 *
 * @param separator the separator to insert in between elements
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Commons 1.0
 * @author Tassilo
 */
fun Array<String>.concat(separator: (Int) -> String, start: Int = 0, end: Int = this.size): String {
	return this.toList().concat(separator, start, end)
}

/**
 * Concatenates all elements of this array.
 *
 * @param separator the separator to insert in between elements
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Commons 1.0
 * @author Tassilo
 */
fun Array<String>.concat(separator: String, start: Int = 0, end: Int = this.size): String {
	return this.concat({separator}, start, end)
}

/**
 * Concatenates all elements of this array. The elements are concatenated using `", "` in between,
 * and using `" and "` between the last and second last element.
 *
 * For example:
 * ```
 * arrayOf("A", "B", "C").smartConcat()
 * ```
 * will result in "A, B and C".
 *
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Commons 1.0
 * @author Tassilo
 */
fun Array<String>.smartConcat(start: Int = 0, end: Int = this.size): String {
	return this.concat({ either(it != end - 1, ", ", " and ") }, start, end)
}

/**
 * Concatenates all elements of this array.
 *
 * @param separator the separator to insert in between elements
 * @param transform the function to use to convert the elements to strings
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Commons 1.0
 * @author Tassilo
 */
fun <T : Any> Array<T>.concat(separator: (Int) -> String, transform: (T) -> String = Any::toString, start: Int = 0, end: Int = this.size): String {
	return this.map(transform).concat(separator, start, end)
}

/**
 * Concatenates all elements of this array.
 *
 * @param separator the separator to insert in between elements
 * @param transform the function to use to convert the elements to strings
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Commons 1.0
 * @author Tassilo
 */
fun <T : Any> Array<T>.concat(separator: String, transform: (T) -> String = Any::toString, start: Int = 0, end: Int = this.size): String {
	return this.map(transform).concat(separator, start, end)
}

/**
 * Concatenates all elements of this array. The elements are concatenated using `", "` in between,
 * and using `" and "` between the last and second last element.
 *
 * For example:
 * ```
 * arrayOf("A", "B", "C").smartConcat()
 * ```
 * will result in "A, B and C".
 *
 * @param transform the function to use to convert the elements to strings
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Commons 1.0
 * @author Tassilo
 */
fun <T : Any> Array<T>.smartConcat(transform: (T) -> String = Any::toString, start: Int = 0, end: Int = this.size): String {
	return this.map(transform).smartConcat(start, end)
}
