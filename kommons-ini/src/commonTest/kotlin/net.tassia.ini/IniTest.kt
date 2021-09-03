package net.tassia.ini

import net.tassia.parser.StringParser
import kotlin.test.Test
import kotlin.test.assertEquals

class IniTest {

	@Test
	fun test1() {

		val parser = StringParser(iniTestDocument1)
		val doc = parser.readIniDocument()

		assertEquals(2, doc.root.size)

		assertEquals(1, doc.section("Section1").size)
		assertEquals(1, doc.section("Section 2").size)

		assertEquals("Hello World!", doc["ROOT_PROPERTY"])
		assertEquals("", doc["ROOT_EMPTY_PROPERTY"])

		assertEquals("1", doc["Section1.SOME_PROP"])
		assertEquals("2", doc["Section 2.SOME_PROP"])

	}

}
