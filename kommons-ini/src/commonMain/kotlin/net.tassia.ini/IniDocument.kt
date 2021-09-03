package net.tassia.ini

/**
 * Represents an entire INI document.
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
class IniDocument {

	/**
	 * The root section of the INI document.
	 */
	val root: IniSection = IniSection(null)

	/**
	 * All other, non-root sections.
	 */
	private val sections = mutableMapOf<String, IniSection>()



	/**
	 * Returns the section with the specified name. This method will create a new section,
	 * if one does not exist already.
	 *
	 * @param name the name of the section
	 * @return the section
	 */
	fun section(name: String): IniSection {
		return sections.getOrPut(name) { IniSection(name) }
	}



	/**
	 * Gets a property. The path can be a nested path. If it contains a '`.`', it will search
	 * in the following format: `{SECTION}.{PATH}`
	 *
	 * @param path the path
	 * @return the property, or the `null` if not found
	 */
	operator fun get(path: String): String? {
		if (path.contains(".")) {
			// Search in child section
			val index = path.lastIndexOf(".")
			val section = path.substring(0, index)
			val key = path.substring(index + 1)
			return section(section)[key]

		}

		// Just search root section
		return root[path]
	}

	/**
	 * Gets a property. The path can be a nested path. If it contains a '`.`', it will search
	 * in the following format: `{SECTION}.{PATH}`
	 *
	 * @param path the path
	 * @param fallback the fallback value
	 * @return the property, or the fallback value if not found
	 */
	operator fun get(path: String, fallback: String): String {
		return get(path) ?: fallback
	}

	/**
	 * Updates a property. The path can be a nested path. If it contains a '`.`', it will search
	 * in the following format: `{SECTION}.{PATH}`
	 *
	 * @param path the path
	 * @param value the value
	 * @return the previous value
	 */
	operator fun set(path: String, value: Any?): String? {
		// Just remove
		if (value == null) {
			return remove(path)
		}

		if (path.contains(".")) {
			// Update child section
			val index = path.lastIndexOf(".")
			val section = path.substring(0, index)
			val key = path.substring(index + 1)
			return section(section).put(key, value.toString())

		}

		// Update root section
		return root.put(path, value.toString())
	}

	/**
	 * Removes a property. The path can be a nested path. If it contains a '`.`', it will search
	 * in the following format: `{SECTION}.{PATH}`
	 *
	 * @param path the path
	 * @return the previous value
	 */
	fun remove(path: String): String? {
		if (path.contains(".")) {
			// Delete from child section
			val index = path.lastIndexOf(".")
			val section = path.substring(0, index)
			val key = path.substring(index + 1)
			return section(section).remove(key)
		}

		// Delete from root section
		return root.remove(path)
	}

}
