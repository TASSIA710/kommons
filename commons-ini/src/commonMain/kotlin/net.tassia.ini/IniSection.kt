package net.tassia.ini

/**
 * Represents an INI section. Sections are prefixed by `[{SECTION NAME}]` in a `.ini` file.
 *
 * @param sectionName the name of this section, will be `null` for the root section
 *
 * @since Commons 1.0
 * @author Tassilo
 */
@Suppress("OVERRIDE_BY_INLINE", "NOTHING_TO_INLINE")
class IniSection(val sectionName: String?) : MutableMap<String, String> {

	/**
	 * The internal storage map that holds all the values.
	 */
	@PublishedApi
	internal val storage: MutableMap<String, String> = mutableMapOf()



	override val size: Int
		inline get() = storage.size

	override val entries: MutableSet<MutableMap.MutableEntry<String, String>>
		inline get() = storage.entries

	override val keys: MutableSet<String>
		inline get() = storage.keys

	override val values: MutableCollection<String>
		inline get() = storage.values



	override inline fun containsKey(key: String): Boolean {
		return storage.containsKey(key)
	}

	override inline fun containsValue(value: String): Boolean {
		return storage.containsValue(value)
	}

	override inline operator fun get(key: String): String? {
		return storage[key]
	}

	override inline fun isEmpty(): Boolean {
		return storage.isEmpty()
	}

	override inline fun clear() {
		storage.clear()
	}

	override inline fun put(key: String, value: String): String? {
		return storage.put(key, value)
	}

	override inline fun putAll(from: Map<out String, String>) {
		storage.putAll(from)
	}

	override inline fun remove(key: String): String? {
		return storage.remove(key)
	}



	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || this::class != other::class) return false

		other as IniSection

		if (sectionName != other.sectionName) return false
		if (storage != other.storage) return false

		return true
	}

	override fun hashCode(): Int {
		var result = sectionName.hashCode()
		result = 31 * result + storage.hashCode()
		return result
	}

}
