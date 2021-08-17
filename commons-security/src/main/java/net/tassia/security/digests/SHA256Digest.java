package net.tassia.security.digests;

import net.tassia.security.digest.DigestInstance;
import net.tassia.security.digest.NoParameterDigest;
import net.tassia.security.digest.NoParameters;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA256Digest extends NoParameterDigest {

	/**
     * The singleton instance.
	 */
	public static final SHA256Digest INSTANCE = new SHA256Digest();

	/**
	 * Singleton class.
	 */
	private SHA256Digest() {
		super("sha256", "SHA-256");
	}

	@Override
	public DigestInstance<NoParameters> create() {
		try {
			MessageDigest internal = MessageDigest.getInstance("SHA-256");
			return new NativeNoParameterInstance(INSTANCE, internal);
		} catch (NoSuchAlgorithmException ex) {
			throw new AssertionError("SHA-256 is not supported on this system.");
		}
	}

}
