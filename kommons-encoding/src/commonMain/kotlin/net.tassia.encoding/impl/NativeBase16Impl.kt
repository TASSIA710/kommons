package net.tassia.encoding.impl

import net.tassia.encoding.Decoder
import net.tassia.encoding.Encoder

object NativeBase16Impl : Encoder, Decoder {

	private val table: CharArray = charArrayOf(
		'0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
	)

	override fun encode(data: ByteArray): String {
		val buffer = CharArray(data.size * 2)
		for (i in data.indices) {
			val v = data[i].toInt()
			buffer[i * 2 + 0] = table[v and 0xF0 shr 4]
			buffer[i * 2 + 1] = table[v and 0xF]
		}
		return buffer.concatToString()
	}

	override fun decode(encoded: String): ByteArray {
		val chars = encoded.toCharArray()
		val buffer = ByteArray(chars.size / 2)
		for (i in buffer.indices) {
			val a = decodeChar(chars[i * 2 + 0])
			val b = decodeChar(chars[i * 2 + 1])
			buffer[i] = a.shl(4).plus(b).toByte()
		}
		return buffer
	}

	@Suppress("NOTHING_TO_INLINE")
	private inline fun decodeChar(x: Char): Int {
		return when (x) {
			'0' -> 0x00; '1' -> 0x01; '2' -> 0x02; '3' -> 0x03
			'4' -> 0x04; '5' -> 0x05; '6' -> 0x06; '7' -> 0x07
			'8' -> 0x08; '9' -> 0x09; 'a' -> 0x0A; 'b' -> 0x0B
			'c' -> 0x0C; 'd' -> 0x0D; 'e' -> 0x0E; 'f' -> 0x0F
			else -> throw IllegalArgumentException("Illegal Base16 character: $x")
		}
	}

}
