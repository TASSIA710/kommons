package net.tassia.ini;

import net.tassia.io.Streams;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class IniTest {

	private String getResource(String path) {
		try (InputStream in = IniTest.class.getResourceAsStream(path)) {
			if (in == null) {
				throw new AssertionError("Resource " + path + " not found.");
			}
			byte[] data = Streams.readAllBytes(in);
			return new String(data, StandardCharsets.UTF_8);
		} catch (IOException ex) {
			throw new AssertionError(ex);
		}
	}

	@Test
	public void test1() {
		String str = getResource("/net/tassia/ini/test1.ini");
		IniParser parser = new IniParser(str);
		IniDocument doc = parser.readDocument();

		assertEquals(2, doc.getRoot().size());
		assertEquals(1, doc.getSection("Section1").size());
		assertEquals(1, doc.getSection("Section 2").size());

		assertEquals("Hello World!", doc.getProperty("ROOT_PROPERTY"));
		assertEquals("", doc.getProperty("ROOT_EMPTY_PROPERTY"));

		assertEquals("1", doc.getProperty("Section1.SOME_PROP"));
		assertEquals("2", doc.getProperty("Section 2.SOME_PROP"));
	}

}
