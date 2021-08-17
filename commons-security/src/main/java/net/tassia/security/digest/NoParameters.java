package net.tassia.security.digest;

/**
 * An empty parameter class.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
public final class NoParameters extends DigestParameters {

	/**
	 * The singleton instance.
	 */
	public static final NoParameters INSTANCE = new NoParameters();

	/**
	 * Singleton class.
	 */
	private NoParameters() {
	}

}
