package net.tassia.security.digests;

import net.tassia.security.digest.Digest;
import net.tassia.security.digest.DigestInstance;
import net.tassia.security.digest.NoParameters;

import java.security.MessageDigest;

final class NativeNoParameterInstance extends DigestInstance<NoParameters> {

	private final MessageDigest internal;

	public NativeNoParameterInstance(Digest<NoParameters> digest, MessageDigest internal) {
		super(digest);
		this.internal = internal;
	}

	@Override
	public byte[] digest(byte[] salt, byte[] data) {
		internal.reset();
		internal.update(salt);
		internal.update(data);
		return internal.digest();
	}

}
