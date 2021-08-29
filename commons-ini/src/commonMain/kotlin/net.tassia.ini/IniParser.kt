package net.tassia.ini

import net.tassia.parser.Parser

fun Parser.readIniDocument(): IniDocument {

	val doc = IniDocument()
	var section = doc.root

	// Main loop
	while (true) {

		skipWhitespace()
		if (hasEndReached) break

		// Comment?
		if (isNext('#') || isNext(';')) {
			readUntil('\n')
			continue
		}

		// Section
		if (isNext('[')) {
			val sectionName = readUntil(']').trim()
			if (!isNext(']')) throw IllegalArgumentException("Invalid INI file format.")
			section = doc.section(sectionName)
			continue
		}

		// Key
		val key = readWhile { it != '=' && it != '\n' }.trim()
		var value = ""
		if (isNext('=')) {
			value = readWhile { it != '\n' }.trim()
		}
		section[key] = value

	}

	return doc

}
