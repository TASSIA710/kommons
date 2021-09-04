package net.tassia

import net.tassia.parser.Parser
import net.tassia.parser.StringParser

fun String.decodeToVersion(): Version {
	val parser = StringParser(this)
	return parser.readVersion().also {
		require(parser.hasEndReached) { "Invalid version string: $this" }
	}
}

fun Parser.readVersion(): Version {
	// Read basics
	val major = readDigit()
	require(isNext('.'))
	val minor = readDigit()
	require(isNext('.'))
	val patch = readDigit()
	require(isNext('.'))
	val build = readDigit()

	// Read misc.
	val extension = readExtension()
	val branch = readGitBranch()
	val head = readGitHead()

	// Done!
	return Version(major, minor, patch, build, extension, branch, head)
}

private fun Parser.readDigit(): Int {
	return readWhile { it.isDigit() }.toInt()
}

private fun Parser.readExtension(): String? {
	if (!isNext('-')) return null
	return readWhile { it.isLetterOrDigit() || it == '-' || it == '_' || it == '/' }
}

private fun Parser.readGitBranch(): String? {
	if (!isNext('#')) return null
	return readWhile { it.isLetterOrDigit() || it == '-' || it == '_' || it == '/' }
}

private fun Parser.readGitHead(): String? {
	if (!isNext('@')) return null
	return readWhile { it.isDigit() || it in 'a'..'f' }
}
