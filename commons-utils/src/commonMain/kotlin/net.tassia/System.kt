package net.tassia

@Namespace
expect object System {

	internal val PLATFORM: Platform

	fun currentTime(): Long
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
