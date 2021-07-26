package net.tassia.ini;

import net.tassia.util.Parser;

public class IniParser extends Parser {

	public IniParser(String source) {
		super(source);
	}



	public IniDocument readDocument() {
		IniDocument doc = new IniDocument();
		IniSection section = doc.getRoot();

		// Main loop
		while (true) {

			skipWhitespace();
			if (hasEndReached()) break;

			// Comment?
			if (isNext('#') || isNext(';')) {
				readUntil('\n');
				continue;
			}

			// Section
			if (isNext('[')) {
				String sectionName = readUntil(']').trim();
				if (!isNext(']')) throw new IllegalArgumentException("Invalid INI file format.");
				section = doc.getSection(sectionName);
				continue;
			}

			// Key
			String key = readWhile((c) -> c != '=' && c != '\n').trim();
			String value = "";
			if (isNext('=')) {
				value = readWhile((c) -> c != '\n').trim();
			}
			section.put(key, value);

		}

		return doc;
	}

}
