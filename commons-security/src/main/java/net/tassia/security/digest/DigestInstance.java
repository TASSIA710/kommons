package net.tassia.security.digest;

/**
 * An actual digest instance. You should absolutely avoid using the same instance from different threads.
 *
 * @param <P> the parameters
 *
 * @since Common 1.0
 * @author Tassilo
 */
public abstract class DigestInstance<P extends DigestParameters> {

	/**
	 * The digest.
	 */
	public final Digest<P> digest;



	/**
	 * Creates a new digest instance with the given base digest.
	 *
	 * @param digest the base digest
	 */
	public DigestInstance(Digest<P> digest) {
		this.digest = digest;
	}



	/**
	 * Creates a digest.
	 *
	 * @param salt the salt
	 * @param data the data
	 * @return the digest
	 */
	public abstract byte[] digest(byte[] salt, byte[] data);

}
