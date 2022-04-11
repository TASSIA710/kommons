package kommons.encoding

/**
 * Provides a standard fallback implementation for Base64,
 * in case the platform does not support a faster, native implementation.
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 */
internal open class StandardBase64(table: CharArray) : Encoder<String>, Decoder<String> {

	private val table = table.copyOf()



	override fun decode(data: String): ByteArray {
		TODO()
	}



	override fun encode(data: ByteArray): String {
		TODO()
	}



	companion object {

		val DefaultTable: CharArray
			inline get() = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray()

		val UrlTable: CharArray
			inline get() = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray()

	}

}
