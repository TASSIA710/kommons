package net.tassia.security.digest;

import net.tassia.security.digests.SHA384Digest;
import net.tassia.util.Base16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class SHA384Test {

	private void testReference(String text, String expected) {
		byte[] data = text.getBytes(StandardCharsets.UTF_8);
		byte[] hash = SHA384Digest.INSTANCE.create().digest(new byte[0], data);
		Assertions.assertEquals(expected, Base16.ENCODER.encode(hash));
	}

	@Test
	public void testReferences() {
		testReference("", "38b060a751ac96384cd9327eb1b1e36a21fdb71114be07434c0cc7bf63f6e1da274edebfe76f65fbd51ad2f14898b95b");
	}

}
