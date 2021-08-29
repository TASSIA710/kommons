package net.tassia

import kotlin.test.Test
import kotlin.test.assertEquals

class TestBooleans {

	@Test
	fun testEnableTrue() {
		assertEquals("enable", true.enable)
	}

	@Test
	fun testEnableFalse() {
		assertEquals("disable", false.enable)
	}



	@Test
	fun testDisableTrue() {
		assertEquals("disable", true.disable)
	}

	@Test
	fun testDisableFalse() {
		assertEquals("enable", false.disable)
	}



	@Test
	fun testEnabledTrue() {
		assertEquals("enabled", true.enabled)
	}

	@Test
	fun testEnabledFalse() {
		assertEquals("disabled", false.enabled)
	}



	@Test
	fun testDisabledTrue() {
		assertEquals("disabled", true.disabled)
	}

	@Test
	fun testDisabledFalse() {
		assertEquals("enabled", false.disabled)
	}



	@Test
	fun testYesTrue() {
		assertEquals("yes", true.yes)
	}

	@Test
	fun testYesFalse() {
		assertEquals("no", false.yes)
	}



	@Test
	fun testNoTrue() {
		assertEquals("no", true.no)
	}

	@Test
	fun testNoFalse() {
		assertEquals("yes", false.no)
	}



	@Test
	fun testValidTrue() {
		assertEquals("valid", true.valid)
	}

	@Test
	fun testValidFalse() {
		assertEquals("invalid", false.valid)
	}



	@Test
	fun testInvalidTrue() {
		assertEquals("invalid", true.invalid)
	}

	@Test
	fun testInvalidFalse() {
		assertEquals("valid", false.invalid)
	}

}
