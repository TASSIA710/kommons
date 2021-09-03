package net.tassia.io

import kotlin.random.Random
import kotlin.random.nextUInt
import kotlin.random.nextULong
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class TestByteArrays {

	private val iterations: IntRange = 0 until 4096 * 8

	private fun <T> runTest(size: Int, read: ByteArray.(Int) -> T, write: ByteArray.(Int, T) -> Unit, gen: () -> T) {
		for (i in iterations) {

			val buffer = ByteArray(size + 2)
			val value = gen()

			buffer.write(1, value)
			assertEquals(value, buffer.read(1))

		}
	}



	@Test
	fun testBytes() {
		for (i in iterations) {
			val data = Random.nextBytes(Random.nextInt(4096))
			val buffer = ByteArray(data.size + 2)

			buffer.putBytes(1, data)

			val data2 = ByteArray(data.size)
			buffer.getBytes(1, data2)
			assertContentEquals(data, data2)
		}
	}

	@Test
	fun testByte() {
		runTest(Byte.SIZE_BYTES, ByteArray::getByte, ByteArray::putByte) { Random.nextInt().toByte() }
	}

	@Test
	fun testUByte() {
		runTest(UByte.SIZE_BYTES, ByteArray::getUByte, ByteArray::putUByte) { Random.nextInt().toUByte() }
	}

	@Test
	fun testShort() {
		runTest(Short.SIZE_BYTES, ByteArray::getShort, ByteArray::putShort) { Random.nextInt().toShort() }
	}

	@Test
	fun testUShort() {
		runTest(UShort.SIZE_BYTES, ByteArray::getUShort, ByteArray::putUShort) { Random.nextInt().toUShort() }
	}

	@Test
	fun testInt() {
		runTest(Int.SIZE_BYTES, ByteArray::getInt, ByteArray::putInt) { Random.nextInt() }
	}

	@Test
	fun testUInt() {
		runTest(UInt.SIZE_BYTES, ByteArray::getUInt, ByteArray::putUInt) { Random.nextUInt() }
	}

	@Test
	fun testLong() {
		runTest(Long.SIZE_BYTES, ByteArray::getLong, ByteArray::putLong) { Random.nextLong() }
	}

	@Test
	fun testULong() {
		runTest(ULong.SIZE_BYTES, ByteArray::getULong, ByteArray::putULong) { Random.nextULong() }
	}

	@Test
	fun testFloat() {
		runTest(Float.SIZE_BYTES, ByteArray::getFloat, ByteArray::putFloat) { Random.nextFloat() }
	}

	@Test
	fun testDouble() {
		runTest(Double.SIZE_BYTES, ByteArray::getDouble, ByteArray::putDouble) { Random.nextDouble() }
	}

}
