package net.tassia.security.digests;

import net.tassia.security.digest.DigestInstance;
import net.tassia.security.digest.NoParameterDigest;
import net.tassia.security.digest.NoParameters;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA224Digest extends NoParameterDigest {

	/**
     * The singleton instance.
	 */
	public static final SHA224Digest INSTANCE = new SHA224Digest();

	/**
	 * Singleton class.
	 */
	private SHA224Digest() {
		super("sha224", "SHA-224");
	}

	@Override
	public DigestInstance<NoParameters> create() {
		try {
			MessageDigest internal = MessageDigest.getInstance("SHA-224");
			return new NativeNoParameterInstance(INSTANCE, internal);
		} catch (NoSuchAlgorithmException ex) {
			throw new AssertionError("SHA-224 is not supported on this system.");
		}
	}

}
