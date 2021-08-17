package net.tassia.security.digests;

import net.tassia.security.digest.DigestInstance;
import net.tassia.security.digest.NoParameterDigest;
import net.tassia.security.digest.NoParameters;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA1Digest extends NoParameterDigest {

	/**
     * The singleton instance.
	 */
	public static final SHA1Digest INSTANCE = new SHA1Digest();

	/**
	 * Singleton class.
	 */
	private SHA1Digest() {
		super("sha1", "SHA-1");
	}

	@Override
	public DigestInstance<NoParameters> create() {
		try {
			MessageDigest internal = MessageDigest.getInstance("SHA-1");
			return new NativeNoParameterInstance(INSTANCE, internal);
		} catch (NoSuchAlgorithmException ex) {
			throw new AssertionError("SHA-1 is not supported on this system.");
		}
	}

}
