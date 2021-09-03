package net.tassia.assertions

internal fun <T : Any?> T.toDisplayString(): String {
	if (this == null) {
		return "null"
	}
	return when (this) {
		is Boolean, is Int -> this.toString()
		is Long -> "${this}L"
		is Float -> "${this}F"
		is Double -> "${this}D"
		else -> this.toRepresentativeString()
	}
}

internal fun <T : Any?> T.toRepresentativeString(): String {
	val className = this?.let { it::class.simpleName } ?: "null"
	val hashCode = this.hashCode().toString(16)
	return toString() + " ($className @ $hashCode)"
}
