package net.tassia.ini;

import java.util.HashMap;
import java.util.Objects;

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



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof IniSection)) return false;
		IniSection that = (IniSection) o;
		return this.sectionName.equals(that.sectionName) && super.equals(that);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), sectionName);
	}

}
