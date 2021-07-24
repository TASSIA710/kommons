package net.tassia.security.digest;

/**
 * A message digest.
 *
 * @param <P> parameters
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public abstract class Digest<P extends DigestParameters> {

	/**
	 * The identifier of this message digest.
	 */
	public final String identifier;

	/**
	 * The display name of this message digest.
	 */
	public final String displayName;



	/**
	 * Creates a new message digest with the given information.
	 *
	 * @param identifier the identifier
	 * @param displayName the display name
	 */
	public Digest(String identifier, String displayName) {
		this.identifier = identifier;
		this.displayName = displayName;
	}



	/**
	 * Returns the default parameters.
	 *
	 * @return default parameters
	 */
	public abstract P getDefaultParameters();

	/**
	 * Creates a new instance using the given parameters.
	 *
	 * @param parameters the parameters
	 * @return the digest instance
	 */
	public abstract DigestInstance<P> create(P parameters);



	/**
	 * Serializes the given parameters.
	 *
	 * @param parameters the parameters
	 * @return bytes containing the data
	 */
	public abstract byte[] serialize(P parameters);

	/**
	 * Deserializes the given bytes back to parameters.
	 *
	 * @param buffer the bytes
	 * @return the parameters
	 */
	public abstract P deserialize(byte[] buffer);

}
