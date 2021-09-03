@file:Suppress("NOTHING_TO_INLINE")
package net.tassia.io

import net.tassia.assertions.assert
import net.tassia.assertions.le

inline fun ByteArray.putBytes(offset: Int, x: ByteArray) {
	assert { expect(offset + x.size) le size }
	for (i in x.indices) {
		this[offset + i] = x[i]
	}
}

inline fun ByteArray.putByte(offset: Int, x: Byte) {
	assert { expect(offset + Byte.SIZE_BYTES) le size }
	this[offset] = x
}

inline fun ByteArray.putUByte(offset: Int, x: UByte) {
	putByte(offset, x.toByte())
}

inline fun ByteArray.putShort(offset: Int, x: Short) {
	assert { expect(offset + Short.SIZE_BYTES) le size }
	val temp = x.toInt()
	this[offset + 0] = (temp shr 8 and 0xFF).toByte()
	this[offset + 1] = (temp and 0xFF).toByte()
}

inline fun ByteArray.putUShort(offset: Int, x: UShort) {
	putShort(offset, x.toShort())
}

inline fun ByteArray.putInt(offset: Int, x: Int) {
	assert { expect(offset + Int.SIZE_BYTES) le size }
	this[offset + 0] = (x shr 24 and 0xFF).toByte()
	this[offset + 1] = (x shr 16 and 0xFF).toByte()
	this[offset + 2] = (x shr 8 and 0xFF).toByte()
	this[offset + 3] = (x and 0xFF).toByte()
}

inline fun ByteArray.putUInt(offset: Int, x: UInt) {
	putInt(offset, x.toInt())
}

inline fun ByteArray.putLong(offset: Int, x: Long) {
	assert { expect(offset + Long.SIZE_BYTES) le size }
	this[offset + 0] = (x shr 56 and 0xFF).toByte()
	this[offset + 1] = (x shr 48 and 0xFF).toByte()
	this[offset + 2] = (x shr 40 and 0xFF).toByte()
	this[offset + 3] = (x shr 32 and 0xFF).toByte()
	this[offset + 4] = (x shr 24 and 0xFF).toByte()
	this[offset + 5] = (x shr 16 and 0xFF).toByte()
	this[offset + 6] = (x shr 8 and 0xFF).toByte()
	this[offset + 7] = (x and 0xFF).toByte()
}

inline fun ByteArray.putULong(offset: Int, x: ULong) {
	putLong(offset, x.toLong())
}

inline fun ByteArray.putFloat(offset: Int, x: Float) {
	putInt(offset, x.toRawBits())
}

inline fun ByteArray.putDouble(offset: Int, x: Double) {
	putLong(offset, x.toRawBits())
}



inline fun ByteArray.getBytes(offset: Int, buffer: ByteArray) {
	assert { expect(offset + buffer.size) le size }
	for (i in buffer.indices) {
		buffer[i] = this[offset + i]
	}
}

inline fun ByteArray.getByte(offset: Int): Byte {
	assert { expect(offset + Byte.SIZE_BYTES) le size }
	return this[offset]
}

inline fun ByteArray.getUByte(offset: Int): UByte {
	return getByte(offset).toUByte()
}

inline fun ByteArray.getShort(offset: Int): Short {
	assert { expect(offset + Short.SIZE_BYTES) le size }
	var temp = this[offset].toInt() and 0xFF
	temp = (temp shl 8) or (this[offset + 1].toInt() and 0xFF)
	return temp.toShort()
}

inline fun ByteArray.getUShort(offset: Int): UShort {
	return getShort(offset).toUShort()
}

inline fun ByteArray.getInt(offset: Int): Int {
	assert { expect(offset + Int.SIZE_BYTES) le size }
	var temp = this[offset].toInt() and 0xFF
	temp = temp shl 8 or (this[offset + 1].toInt() and 0xFF)
	temp = temp shl 8 or (this[offset + 2].toInt() and 0xFF)
	temp = temp shl 8 or (this[offset + 3].toInt() and 0xFF)
	return temp
}

inline fun ByteArray.getUInt(offset: Int): UInt {
	return getInt(offset).toUInt()
}

inline fun ByteArray.getLong(offset: Int): Long {
	assert { expect(offset + Long.SIZE_BYTES) le size }
	var temp = this[offset].toLong()
	temp = temp shl 8 or (this[offset + 1].toLong() and 0xFF)
	temp = temp shl 8 or (this[offset + 2].toLong() and 0xFF)
	temp = temp shl 8 or (this[offset + 3].toLong() and 0xFF)
	temp = temp shl 8 or (this[offset + 4].toLong() and 0xFF)
	temp = temp shl 8 or (this[offset + 5].toLong() and 0xFF)
	temp = temp shl 8 or (this[offset + 6].toLong() and 0xFF)
	temp = temp shl 8 or (this[offset + 7].toLong() and 0xFF)
	return temp
}

inline fun ByteArray.getULong(offset: Int): ULong {
	return getLong(offset).toULong()
}

inline fun ByteArray.getFloat(offset: Int): Float {
	return Float.fromBits(getInt(offset))
}

inline fun ByteArray.getDouble(offset: Int): Double {
	return Double.fromBits(getLong(offset))
}
