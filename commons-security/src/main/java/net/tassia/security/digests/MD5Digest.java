package net.tassia.security.digests;

import net.tassia.security.digest.DigestInstance;
import net.tassia.security.digest.NoParameters;
import net.tassia.security.digest.NoParameterDigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Digest extends NoParameterDigest {

	/**
	 * The singleton instance.
	 */
	public static final MD5Digest INSTANCE = new MD5Digest();

	/**
	 * Singleton class.
	 */
	private MD5Digest() {
		super("md5", "MD5");
	}

	@Override
	public DigestInstance<NoParameters> create() {
		try {
			MessageDigest internal = MessageDigest.getInstance("MD5");
			return new NativeNoParameterInstance(INSTANCE, internal);
		} catch (NoSuchAlgorithmException ex) {
			throw new AssertionError("MD5 is not supported on this system.");
		}
	}

}
