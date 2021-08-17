package net.tassia.security.digests;

import net.tassia.security.digest.DigestInstance;
import net.tassia.security.digest.NoParameterDigest;
import net.tassia.security.digest.NoParameters;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA384Digest extends NoParameterDigest {

	/**
     * The singleton instance.
	 */
	public static final SHA384Digest INSTANCE = new SHA384Digest();

	/**
	 * Singleton class.
	 */
	private SHA384Digest() {
		super("sha384", "SHA-384");
	}

	@Override
	public DigestInstance<NoParameters> create() {
		try {
			MessageDigest internal = MessageDigest.getInstance("SHA-384");
			return new NativeNoParameterInstance(INSTANCE, internal);
		} catch (NoSuchAlgorithmException ex) {
			throw new AssertionError("SHA-384 is not supported on this system.");
		}
	}

}
