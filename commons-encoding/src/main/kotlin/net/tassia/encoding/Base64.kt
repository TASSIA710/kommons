package net.tassia.encoding

import java.util.Base64 as NB64
import net.tassia.encoding.Decoder as IDecoder
import net.tassia.encoding.Encoder as IEncoder

object Base64 {

	val Decoder: IDecoder = NativeBase64Decoder(NB64.getDecoder())
	val Encoder: IEncoder = NativeBase64Encoder(NB64.getEncoder())

	val MimeDecoder: IDecoder = NativeBase64Decoder(NB64.getMimeDecoder())
	val MimeEncoder: IEncoder = NativeBase64Encoder(NB64.getMimeEncoder())

	val UrlDecoder: IDecoder = NativeBase64Decoder(NB64.getUrlDecoder())
	val UrlEncoder: IEncoder = NativeBase64Encoder(NB64.getUrlEncoder())



	private open class NativeBase64Decoder(private val internal: NB64.Decoder) : IDecoder {
		override fun decode(encoded: String): ByteArray {
			return internal.decode(encoded)
		}
	}

	private open class NativeBase64Encoder(private val internal: NB64.Encoder) : IEncoder {
		override fun encode(data: ByteArray): String {
			return internal.encodeToString(data)
		}
	}

}
