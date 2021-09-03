package net.tassia

/**
 * A short-hand for "equalsIgnoreCase".
 *
 * @param that the string to compare to
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
@Suppress("NOTHING_TO_INLINE")
inline infix fun String?.eqic(that: String?): Boolean {
	return this.equals(that, true)
}
