package kommons.encoding

/**
 * An [Encoder] and [Decoder] for translating binary-data from and to Base64.
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 */
expect object Base64 : Encoder<String>, Decoder<String> {

	/**
	 * A Base64 [Encoder] and [Decoder], unlike [Base64], this one uses the URL Base64 format.
	 *
	 * @since Kommons 1.0
	 * @author Tassilo Lemke
	 */
	object Url : Encoder<String>, Decoder<String>

}
