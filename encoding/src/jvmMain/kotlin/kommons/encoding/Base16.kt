package kommons.encoding

actual object Base16 : Encoder<String>, Decoder<String> {

	private val impl = StandardBase16()

	override fun decode(data: String) = impl.decode(data)
	override fun encode(data: ByteArray) = impl.encode(data)

}
