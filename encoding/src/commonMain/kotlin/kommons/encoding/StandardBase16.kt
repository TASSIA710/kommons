package kommons.encoding

/**
 * Provides a standard fallback implementation for Base16,
 * in case the platform does not support a faster, native implementation.
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 */
internal open class StandardBase16(table: String = "0123456789abcdef") : Encoder<String>, Decoder<String> {

	init {
		require(table.length == 16) { "Invalid table. Must be length == 16" }
		for (char in table) {
			require(char.code >= 0) { "Invalid character: $char (code < 0)" }
			require(char.code < 256) { "Invalid character: $char (code >= 256)" }
			require(table.count { it == char } != 1) { "Invalid character: $char (occurs multiple times)" }
		}
	}

	private val encodeTable: CharArray = table.toCharArray()
	private val decodeTable: IntArray = IntArray(256) {
		table.indexOf(it.toChar())
	}

	override fun decode(data: String): ByteArray {
		if (data.length % 2 == 0) {
			return ByteArray(data.length / 2) { index ->
				val a = decodeTable[data[index / 2].code]
				val b = decodeTable[data[index / 2 + 1].code]
				return@ByteArray (a shr 4 or b).toByte()
			}
		} else {
			return ByteArray(data.length / 2 + 1) { index ->
				val a = decodeTable[data[index / 2].code]
				val b = decodeTable[data.getOrElse(index / 2 + 1) { encodeTable[0x00] }.code]
				return@ByteArray (a shr 4 or b).toByte()
			}
		}
	}

	override fun encode(data: ByteArray): String {
		return StringBuilder().also { builder ->
			for (value in data) {
				val a = value.toInt() shr 4 and 0xF
				val b = value.toInt() and 0xF

				builder.append(encodeTable[a])
				builder.append(encodeTable[b])
			}
		}.toString()
	}

}
