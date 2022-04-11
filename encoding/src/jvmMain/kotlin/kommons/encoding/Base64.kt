package kommons.encoding

import java.util.Base64 as NativeBase64

actual object Base64 : Encoder<String>, Decoder<String> {

	override fun decode(data: String): ByteArray {
		return NativeBase64.getDecoder().decode(data)
	}

	override fun encode(data: ByteArray): String {
		return NativeBase64.getEncoder().encodeToString(data)
	}



	actual object Url : Encoder<String>, Decoder<String> {

		override fun decode(data: String): ByteArray {
			return NativeBase64.getUrlDecoder().decode(data)
		}

		override fun encode(data: ByteArray): String {
			return NativeBase64.getEncoder().encodeToString(data)
		}

	}

}
