package net.tassia.encoding

import net.tassia.encoding.Decoder as IDecoder
import net.tassia.encoding.Encoder as IEncoder

class Base16 private constructor() {

	object Decoder : IDecoder {

		private fun decode(char: Char): Int {
			return when (char) {
				'0' -> 0x00; '1' -> 0x01; '2' -> 0x02; '3' -> 0x03
				'4' -> 0x04; '5' -> 0x05; '6' -> 0x06; '7' -> 0x07
				'8' -> 0x08; '9' -> 0x09; 'a' -> 0x0A; 'b' -> 0x0B
				'c' -> 0x0C; 'd' -> 0x0D; 'e' -> 0x0E; 'f' -> 0x0F
				else -> throw IllegalArgumentException("Invalid Base16 character: $char")
			}
		}

		override fun decode(encoded: String): ByteArray {
			return ByteArray(encoded.length / 2) {
				val decoded1 = decode(encoded[it * 2 + 0])
				val decoded2 = decode(encoded[it * 2 + 1])
				return@ByteArray ((decoded1 shl 4) + decoded2).toByte()
			}
		}

	}

	object Encoder : IEncoder {

		private val table: Array<Char> = arrayOf(
			'0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
		)

		override fun encode(data: ByteArray): String {
			val table = this.table
			val buffer =  CharArray(data.size * 2)

			for (i in data.indices) {
				val value = data[i].toInt()
				buffer[i * 2 + 0] = table[(value shr 4) and 0xF]
				buffer[i * 2 + 1] = table[value and 0xF]
			}

			return buffer.concatToString()
		}

	}

}
