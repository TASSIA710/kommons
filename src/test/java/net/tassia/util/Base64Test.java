package net.tassia.util;

import net.tassia.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class Base64Test {

	@Test
	public void testRandomized() {
		for (int i = 0; i < Tests.ENTROPY_ITERATIONS; i++) {
			byte[] data = Tests.randomData();

			String encoded = Base64.ENCODER.encode(data);
			byte[] decoded = Base64.DECODER.decode(encoded);

			Assertions.assertArrayEquals(data, decoded);
		}
	}

	private void testReference(String text, String expected) {
		byte[] data = text.getBytes(StandardCharsets.UTF_8);
		String encoded = Base64.ENCODER.encode(data);
		Assertions.assertEquals(expected, encoded);

		byte[] decoded = Base64.DECODER.decode(expected);
		String decodedText = new String(decoded, StandardCharsets.UTF_8);
		Assertions.assertEquals(text, decodedText);
	}

	@Test
	public void testReferences() {
		// Source: https://en.wikipedia.org/wiki/Base64
		testReference(
			"Man is distinguished, not only by his reason, but by this singular passion from other animals, which is a lust of the mind, that by a perseverance of delight in the continued and indefatigable generation of knowledge, exceeds the short vehemence of any carnal pleasure.",
			"TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlzIHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2YgdGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGludWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRoZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4="
		);
		testReference("any carnal pleasure.", "YW55IGNhcm5hbCBwbGVhc3VyZS4=");
		testReference("any carnal pleasure", "YW55IGNhcm5hbCBwbGVhc3VyZQ==");
		testReference("any carnal pleasur", "YW55IGNhcm5hbCBwbGVhc3Vy");
		testReference("any carnal pleasu", "YW55IGNhcm5hbCBwbGVhc3U=");
		testReference("any carnal pleas", "YW55IGNhcm5hbCBwbGVhcw==");
		testReference("pleasure.", "cGxlYXN1cmUu");
		testReference("leasure.", "bGVhc3VyZS4=");
		testReference("easure.", "ZWFzdXJlLg==");
		testReference("asure.", "YXN1cmUu");
		testReference("sure.", "c3VyZS4=");
	}

}
