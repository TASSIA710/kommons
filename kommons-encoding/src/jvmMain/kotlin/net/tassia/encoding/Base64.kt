package net.tassia.encoding

import java.util.Base64 as NativeBase64

actual object Base64 : Encoder, Decoder {

	override fun encode(data: ByteArray): String {
		return NativeBase64.getEncoder().encodeToString(data)
	}

	override fun decode(encoded: String): ByteArray {
		return NativeBase64.getDecoder().decode(encoded)
	}

}
