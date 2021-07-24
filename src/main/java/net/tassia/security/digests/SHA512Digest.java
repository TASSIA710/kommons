package net.tassia.security.digests;

import net.tassia.security.digest.DigestInstance;
import net.tassia.security.digest.NoParameterDigest;
import net.tassia.security.digest.NoParameters;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA512Digest extends NoParameterDigest {

	/**
     * The singleton instance.
	 */
	public static final SHA512Digest INSTANCE = new SHA512Digest();

	/**
	 * Singleton class.
	 */
	private SHA512Digest() {
		super("sha512", "SHA-512");
	}

	@Override
	public DigestInstance<NoParameters> create() {
		try {
			MessageDigest internal = MessageDigest.getInstance("SHA-512");
			return new NativeNoParameterInstance(INSTANCE, internal);
		} catch (NoSuchAlgorithmException ex) {
			throw new AssertionError("SHA-512 is not supported on this system.");
		}
	}

}
