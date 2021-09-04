package net.tassia

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Version (

	@SerialName("major")
	val major: Int,

	@SerialName("minor")
	val minor: Int,

	@SerialName("patch")
	val patch: Int,

	@SerialName("build")
	val build: Int,


	@SerialName("extension")
	val extension: String?,


	@SerialName("git_branch")
	val gitBranch: String?,

	@SerialName("git_head")
	val gitHead: String?,

) : Comparable<Version> {

	/**
	 * The Git head. Limited to the first 7 chars.
	 */
	val gitShortHead: String?
		inline get() = gitHead?.substring(0, 7)



	override fun compareTo(other: Version): Int {
		if (this.major != other.major) return this.major - other.major
		if (this.minor != other.minor) return this.minor - other.minor
		if (this.patch != other.patch) return this.patch - other.patch
		if (this.build != other.build) return this.build - other.build
		return 0
	}



	fun encodeToString(): String {
		val builder = StringBuilder()
		builder.append("$major.$minor.$patch.$build")
		extension?.also { builder.append("-$it") }
		gitBranch?.also { builder.append("#$it") }
		gitHead?.also { builder.append("@$it") }
		return builder.toString()
	}

}
