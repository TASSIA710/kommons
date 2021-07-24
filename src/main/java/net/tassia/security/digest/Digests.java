package net.tassia.security.digest;

import net.tassia.security.digests.MD5Digest;
import net.tassia.security.digests.SHA1Digest;
import net.tassia.security.digests.SHA224Digest;
import net.tassia.util.Base64;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities for digests.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public final class Digests {

	public static final Pattern DIGEST_STRING_PATTERN = Pattern.compile("\\$([A-z0-9]*)\\$([A-z0-9_=-]*)\\$([A-z0-9_=-]*)\\$([A-z0-9_=-]*)");

	/**
	 * An array containing all available digests.
	 */
	@SuppressWarnings("unchecked")
	private static Digest<? extends DigestParameters>[] DIGESTS = new Digest[] {
		MD5Digest.INSTANCE, SHA1Digest.INSTANCE, SHA224Digest.INSTANCE
	};





	/**
	 * Tries to find a digest by both its {@link Digest#identifier} and {@link Digest#displayName}.
	 *
	 * @param search the search string
	 * @return the digest, or <code>null</code> if not found
	 */
	public static Digest<? extends DigestParameters> getDigest(String search) {
		for (Digest<?> digest : Digests.DIGESTS) {
			if (digest.identifier.equals(search) || digest.displayName.equals(search)) {
				return digest;
			}
		}
		return null;
	}

	/**
	 * Returns an array containing all available digests.
	 *
	 * @return all digests
	 */
	public static Digest<? extends DigestParameters>[] getDigests() {
		return Arrays.copyOf(Digests.DIGESTS, Digests.DIGESTS.length);
	}

	/**
	 * Registers a new digest.
	 *
	 * @param digest the digest
	 */
	public static void registerDigest(Digest<?> digest) {
		Digest<?>[] digests = new Digest<?>[Digests.DIGESTS.length + 1];
		System.arraycopy(Digests.DIGESTS, 0, digests, 0, Digests.DIGESTS.length);
		digests[digests.length - 1] = digest;
		Digests.DIGESTS = digests;
	}





	public static <P extends DigestParameters> String digest(Digest<P> digest, byte[] salt, byte[] data) {
		return digest(digest, digest.getDefaultParameters(), salt, data);
	}

	public static <P extends DigestParameters> String digest(Digest<P> digest, P parameters, byte[] salt, byte[] data) {
		byte[] digestData = digest.create(parameters).digest(salt, data);
		return buildDigestString(digest, parameters, salt, digestData);
	}





	/**
	 * Builds a digest string.
	 *
	 * @param type the digest type
	 * @param parameters the parameters
	 * @param salt the salt
	 * @param digest the digest data
	 * @param <P> the parameters
	 * @return a digest string
	 */
	public static <P extends DigestParameters> String buildDigestString(Digest<P> type, P parameters, byte[] salt, byte[] digest) {
		String params = Base64.URL_ENCODER.encode(type.serialize(parameters));
		String saltString = Base64.URL_ENCODER.encode(salt);
		String digestString = Base64.URL_ENCODER.encode(digest);
		return String.format("$%s$%s$%s$%s", type.identifier, params, saltString, digestString);
	}

	/**
	 * Verifies the given digest string against the given data.
	 *
	 * @param digestString the digest string (see {@link #buildDigestString(Digest, DigestParameters, byte[], byte[])})
	 * @param data the data to verify
	 * @return <code>true</code> if match, <code>false</code> if not
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static boolean verify(String digestString, byte[] data) {
		Matcher match = DIGEST_STRING_PATTERN.matcher(digestString);
		if (!match.matches() || !match.group(0).equals(digestString)) {
			throw new IllegalArgumentException(digestString + " is not a valid digest string.");
		}

		Digest type = getDigest(match.group(1));
		if (type == null) {
			throw new IllegalStateException(match.group(1) + " is not a supported digest.");
		}

		byte[] paramsSerialized = Base64.URL_DECODER.decode(match.group(2));
		DigestParameters params = type.deserialize(paramsSerialized);

		byte[] salt = Base64.URL_DECODER.decode(match.group(3));
		byte[] actualDigest = Base64.URL_DECODER.decode(match.group(4));

		byte[] expectedDigest = type.create(params).digest(salt, data);
		return Arrays.equals(actualDigest, expectedDigest);
	}





	/**
	 * Static class.
	 */
	private Digests() {
	}

}
