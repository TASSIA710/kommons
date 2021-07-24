package net.tassia.security.digest;

import net.tassia.security.digests.MD5Digest;
import net.tassia.util.Base16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class MD5Test {

	private void testReference(String text, String expected) {
		byte[] data = text.getBytes(StandardCharsets.UTF_8);
		byte[] hash = MD5Digest.INSTANCE.create().digest(new byte[0], data);
		Assertions.assertEquals(expected, Base16.ENCODER.encode(hash));
	}

	@Test
	public void testReferences() {
		testReference("The quick brown fox jumps over the lazy dog", "9e107d9d372bb6826bd81d3542a419d6");
		testReference("The quick brown fox jumps over the lazy dog.", "e4d909c290d0fb1ca068ffaddf22cbd0");
		testReference("", "d41d8cd98f00b204e9800998ecf8427e");
	}

}
