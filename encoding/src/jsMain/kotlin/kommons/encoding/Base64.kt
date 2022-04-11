package kommons.encoding

actual object Base64 : Encoder<String>, Decoder<String> {

	private val impl = StandardBase64(StandardBase64.DefaultTable)

	override fun decode(data: String) = impl.decode(data)
	override fun encode(data: ByteArray) = impl.encode(data)

	actual object Url : Encoder<String>, Decoder<String> {

		private val impl = StandardBase64(StandardBase64.UrlTable)

		override fun decode(data: String) = impl.decode(data)
		override fun encode(data: ByteArray) = impl.encode(data)

	}

}
