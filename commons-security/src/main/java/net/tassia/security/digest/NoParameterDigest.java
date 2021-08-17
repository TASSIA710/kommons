package net.tassia.security.digest;

/**
 * A message digest that has no parameters.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public abstract class NoParameterDigest extends Digest<NoParameters> {

	/**
	 * Creates a new message digest with the given information.
	 *
	 * @param identifier the identifier
	 * @param displayName the display name
	 */
	public NoParameterDigest(String identifier, String displayName) {
		super(identifier, displayName);
	}



	@Override
	public NoParameters getDefaultParameters() {
		return NoParameters.INSTANCE;
	}

	@Override
	public DigestInstance<NoParameters> create(NoParameters parameters) {
		return create();
	}

	@Override
	public byte[] serialize(NoParameters parameters) {
		return new byte[0];
	}

	@Override
	public NoParameters deserialize(byte[] buffer) {
		return NoParameters.INSTANCE;
	}



	/**
	 * Creates a new digest instance.
	 *
	 * @return the created digest instance
	 */
	public abstract DigestInstance<NoParameters> create();

}
