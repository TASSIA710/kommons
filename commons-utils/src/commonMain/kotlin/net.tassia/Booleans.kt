package net.tassia

/**
 * If this boolean is `true` this value contains *"enable"*, otherwise *"disable"*.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Boolean.enable: String
	inline get() = either(this, "enable", "disable")

/**
 * If this boolean is `true` this value contains *"disable"*, otherwise *"enable"*.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Boolean.disable: String
	inline get() = (!this).enable



/**
 * If this boolean is `true` this value contains *"enabled"*, otherwise *"disabled"*.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Boolean.enabled: String
	inline get() = either(this, "enabled", "disabled")

/**
 * If this boolean is `true` this value contains *"disabled"*, otherwise *"enabled"*.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Boolean.disabled: String
	inline get() = (!this).enabled


/**
 * If this boolean is `true` this value contains *"yes"*, otherwise *"no"*.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Boolean.yes: String
	inline get() = either(this, "yes", "no")

/**
 * If this boolean is `true` this value contains *"no"*, otherwise *"yes"*.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Boolean.no: String
	inline get() = (!this).yes



/**
 * If this boolean is `true` this value contains *"valid"*, otherwise *"invalid"*.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Boolean.valid: String
	inline get() = either(this, "valid", "invalid")

/**
 * If this boolean is `true` this value contains *"invalid"*, otherwise *"valid"*.
 *
 * @since Commons 1.0
 * @author Tassilo
 */
val Boolean.invalid: String
	inline get() = (!this).valid
