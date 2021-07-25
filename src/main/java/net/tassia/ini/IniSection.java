package net.tassia.ini;

import java.util.HashMap;

/**
 * Represents an INI section. Sections are prefixed by <code>[&lt;SECTION NAME&gt;]</code> in a <code>.ini</code> file.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public class IniSection extends HashMap<String, String> {

	/**
	 * The name of this section. Will be <code>null</code> for the root section.
	 */
	public final String sectionName;



	/**
	 * Creates a new section.
	 *
	 * @param sectionName the name of this section, may be <code>null</code>
	 */
	public IniSection(String sectionName) {
		this.sectionName = sectionName;
	}

}
