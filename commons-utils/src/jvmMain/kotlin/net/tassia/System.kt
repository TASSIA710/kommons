package net.tassia

import kotlin.system.exitProcess
import java.lang.System as NativeSystem

@Namespace
actual object System {

	internal actual val PLATFORM: Platform = Platform.JVM



	actual fun currentTime(): Long {
		return currentTimeMillis() / 1000L
	}

	actual fun currentTimeMillis(): Long {
		return NativeSystem.currentTimeMillis()
	}



	actual fun exit(status: Int) {
		exitProcess(status)
	}

}
