package net.tassia.security.digest

import net.tassia.security.digest.impl.NPDigestType

expect object MD5 : NPDigestType
expect object SHA1 : NPDigestType
expect object SHA256 : NPDigestType
expect object SHA512 : NPDigestType
