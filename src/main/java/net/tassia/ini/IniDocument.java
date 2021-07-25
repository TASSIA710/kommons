package net.tassia.ini;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an entire INI document.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public class IniDocument {

	/**
	 * The root sections.
	 */
	private final IniSection root;

	/**
	 * All other, named sections.
	 */
	private final Map<String, IniSection> sections;



	/**
	 * Creates a new, empty INI document.
	 */
	public IniDocument() {
		this.root = new IniSection(null);
		this.sections = new HashMap<>();
	}



	/**
	 * Returns the root section of this document.
	 *
	 * @return the root section
	 */
	public IniSection getRoot() {
		return root;
	}

	/**
	 * Returns the section with the specified name. This method will create a new section,
	 * if one does not exist already.
	 *
	 * @param name the name of the section
	 * @return the section
	 */
	public IniSection getSection(String name) {
		return sections.computeIfAbsent(name, IniSection::new);
	}



	/**
	 * Gets a property. The path can be a nested path. If it contains a '<code>.</code>', it will search
	 * in the following format: <code>&lt;SECTION&gt;.&lt;PATH&gt;</code>
	 *
	 * @param path the path
	 * @return the property, or the <code>null</code> if not found
	 */
	public String getProperty(String path) {
		if (path.contains(".")) {
			// Search in child section
			int index = path.lastIndexOf(".");
			String section = path.substring(0, index);
			String key = path.substring(index + 1);
			return getSection(section).get(key);

		} else {
			// Just search root section
			return root.get(path);

		}
	}

	/**
	 * Gets a property. The path can be a nested path. If it contains a '<code>.</code>', it will search
	 * in the following format: <code>&lt;SECTION&gt;.&lt;PATH&gt;</code>
	 *
	 * @param path the path
	 * @param fallback the fallback value
	 * @return the property, or the fallback value if not found
	 */
	public String getProperty(String path, String fallback) {
		if (path.contains(".")) {
			// Search in child section
			int index = path.lastIndexOf(".");
			String section = path.substring(0, index);
			String key = path.substring(index + 1);
			return getSection(section).getOrDefault(key, fallback);

		} else {
			// Just search root section
			return root.getOrDefault(path, fallback);

		}
	}

	/**
	 * Updates a property. The path can be a nested path. If it contains a '<code>.</code>', it will search
	 * in the following format: <code>&lt;SECTION&gt;.&lt;PATH&gt;</code>
	 *
	 * @param path the path
	 * @param value the value
	 */
	public void setProperty(String path, Object value) {
		if (path.contains(".")) {
			// Update child section
			int index = path.lastIndexOf(".");
			String section = path.substring(0, index);
			String key = path.substring(index + 1);
			getSection(section).put(key, value.toString());

		} else {
			// Update root section
			this.root.put(path, value.toString());

		}
	}

}
