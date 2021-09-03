package net.tassia

/**
 * Concatenates all elements of this collection.
 *
 * @param separator the separator to insert in between elements
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
fun Collection<String>.concat(separator: (Int) -> String, start: Int = 0, end: Int = this.size): String {
	val builder = StringBuilder()

	for ((index, element) in this.withIndex()) {
		if (index in start until end) {
			if (index != start) {
				builder.append(separator(index))
			}
			builder.append(element)
		}
	}

	return builder.toString()
}

/**
 * Concatenates all elements of this collection.
 *
 * @param separator the separator to insert in between elements
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
fun Collection<String>.concat(separator: String, start: Int = 0, end: Int = this.size): String {
	return this.concat({separator}, start, end)
}

/**
 * Concatenates all elements of this collection. The elements are concatenated using `", "` in between,
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
 * @since Kommons 1.0
 * @author Tassilo
 */
fun Collection<String>.smartConcat(start: Int = 0, end: Int = this.size): String {
	return this.concat({ either(it != end - 1, ", ", " and ") }, start, end)
}

/**
 * Concatenates all elements of this collection.
 *
 * @param separator the separator to insert in between elements
 * @param transform the function to use to convert the elements to strings
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
fun <T : Any> Collection<T>.concat(separator: (Int) -> String, transform: (T) -> String = Any::toString, start: Int = 0, end: Int = this.size): String {
	return this.map(transform).concat(separator, start, end)
}

/**
 * Concatenates all elements of this collection.
 *
 * @param separator the separator to insert in between elements
 * @param transform the function to use to convert the elements to strings
 * @param start the index of the element to start at
 * @param end the index of the element to end at (exclusive)
 *
 * @return a concatenated string
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
fun <T : Any> Collection<T>.concat(separator: String, transform: (T) -> String = Any::toString, start: Int = 0, end: Int = this.size): String {
	return this.map(transform).concat(separator, start, end)
}

/**
 * Concatenates all elements of this collection. The elements are concatenated using `", "` in between,
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
 * @since Kommons 1.0
 * @author Tassilo
 */
fun <T : Any> Collection<T>.smartConcat(transform: (T) -> String = Any::toString, start: Int = 0, end: Int = this.size): String {
	return this.map(transform).smartConcat(start, end)
}
