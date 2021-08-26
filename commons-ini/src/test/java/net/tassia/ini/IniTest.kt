package net.tassia.ini

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.InputStream

@DisplayName("INI")
class IniTest {

	private fun getResource(path: String): String {
		return IniTest::class.java.getResourceAsStream(path)?.use { it.readAllBytes() }
			?.let { String(it, Charsets.UTF_8) } ?: throw AssertionError("Test resource does not exist: $path")
	}

	@Test
	@DisplayName("Test #1")
	fun test1() {

		val str = getResource("/net/tassia/ini/test1.ini")
		val parser = IniParser(str)
		val doc = parser.readDocument()

		Assertions.assertEquals(2, doc.root.size)

		Assertions.assertEquals(1, doc.getSection("Section1").size)
		Assertions.assertEquals(1, doc.getSection("Section 2").size)

		Assertions.assertEquals("Hello World!", doc.getProperty("ROOT_PROPERTY"))
		Assertions.assertEquals("", doc.getProperty("ROOT_EMPTY_PROPERTY"))

		Assertions.assertEquals("1", doc.getProperty("Section1.SOME_PROP"))
		Assertions.assertEquals("2", doc.getProperty("Section 2.SOME_PROP"))

	}

}
