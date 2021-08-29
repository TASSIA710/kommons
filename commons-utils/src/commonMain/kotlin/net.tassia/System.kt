package net.tassia

/**
 * This object allows for accessing system-based functions.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
@Namespace
expect object System {

	/**
	 * This field contains the current platform.
	 */
	internal val PLATFORM: Platform



	/**
	 * Returns the current time since the UNIX epoch (1st Jan 1970) in seconds.
	 *
	 * @return the current time in seconds
	 */
	fun currentTime(): Long

	/**
	 * Returns the current time since the UNIX epoch (1st Jan 1970) in milliseconds.
	 *
	 * @return the current time in milliseconds
	 */
	fun currentTimeMillis(): Long



	/**
	 * Exits the "current process". This can mean different things depending on the platform.
	 *
	 * On the JVM and in Native applications, this quite literally is defined as exiting the process.
	 *
	 * On JS/NodeJS, it might mean exiting the application, on JS/Browser, it might mean closing the window.
	 *
	 * **Note:** This method should never return.
	 * In the rare case it does, it will automatically throw an exception.
	 *
	 * @param status the exit code
	 */
	fun exit(status: Int)

}
