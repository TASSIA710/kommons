package net.tassia

/**
 * Assuming this number represents seconds, this value contains the milliseconds representative.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Int.secs: Long
	inline get() = this * SECOND

/**
 * Assuming this number represents minutes, this value contains the milliseconds representative.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Int.mins: Long
	inline get() = this * MINUTE

/**
 * Assuming this number represents hours, this value contains the milliseconds representative.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Int.hours: Long
	inline get() = this * HOUR

/**
 * Assuming this number represents days, this value contains the milliseconds representative.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Int.days: Long
	inline get() = this * DAY

/**
 * Assuming this number represents weeks, this value contains the milliseconds representative.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Int.weeks: Long
	inline get() = this * WEEK

/**
 * Assuming this number represents months, this value contains the milliseconds representative.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Int.months: Long
	inline get() = this * MONTH

/**
 * Assuming this number represents years, this value contains the milliseconds representative.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Int.years: Long
	inline get() = this * YEAR
