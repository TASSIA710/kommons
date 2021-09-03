package net.tassia.security.digest.impl

import net.tassia.security.digest.DigestParameters

/**
 * The [DigestParameters] to use, when a digest does not actually support any parameters.
 * This is essentially just an empty class.
 *
 * The serialized from of this is an empty byte array.
 *
 * @see NPDigestType
 *
 * @since Kommons 1.0
 * @author Tassilo
 */
object NoParameters : DigestParameters()
