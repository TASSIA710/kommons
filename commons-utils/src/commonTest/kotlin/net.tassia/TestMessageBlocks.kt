package net.tassia

import kotlin.test.Test
import kotlin.test.assertEquals

class TestMessageBlocks {

	private val expect1ascii = """
		+---------- << AssertionFailed >> ----------
		|
		|	What went wrong?
		|	  -> Single line describing the problem.
		|
		|	Where's the difference?
		|	  +- Expected: 'String123'
		|	  +- But got: 'String321'
		|
		|	Also cool: Nested blocks!
		|	  +- Sub Text 1
		|	  |    +- Sub-Sub Text 1
		|	  |    +- Sub-Sub Text 2
		|	  +- Sub Text 2
		|	  |    -> Single line.
		|	  +- Sub Text 3
		|	  +- Sub Text 4
		|	       +- Sub-Sub Text 1
		|	       +- Sub-Sub Text 2
		|
		+-------------------------------------------
	""".trimIndent().trim()

	private val expect1utf8 = """
		╔══════════ « AssertionFailed » ══════════
		║
		║	What went wrong?
		║	  ➥ Single line describing the problem.
		║
		║	Where's the difference?
		║	  ├─ Expected: 'String123'
		║	  └─ But got: 'String321'
		║
		║	Also cool: Nested blocks!
		║	  ├─ Sub Text 1
		║	  │    ├─ Sub-Sub Text 1
		║	  │    └─ Sub-Sub Text 2
		║	  ├─ Sub Text 2
		║	  │    ➥ Single line.
		║	  ├─ Sub Text 3
		║	  └─ Sub Text 4
		║	       ├─ Sub-Sub Text 1
		║	       └─ Sub-Sub Text 2
		║
		╚═════════════════════════════════════════
	""".trimIndent().trim()

	@Test
	fun test1() {
		val msg = MessageBlock("AssertionFailed") {

			child("What went wrong?") {
				child("Single line describing the problem.")
			}

			child("Where's the difference?") {
				child("Expected: 'String123'")
				child("But got: 'String321'")
			}

			child("Also cool: Nested blocks!") {
				child("Sub Text 1") {
					child("Sub-Sub Text 1")
					child("Sub-Sub Text 2")
				}
				child("Sub Text 2") {
					child("Single line.")
				}
				child("Sub Text 3")
				child("Sub Text 4") {
					child("Sub-Sub Text 1")
					child("Sub-Sub Text 2")
				}
			}

		}

		assertEquals(expect1ascii, msg.buildASCII())
		assertEquals(expect1utf8, msg.buildUTF8())
	}

}
