package kommons.encoding

/**
 * An [Encoder] and [Decoder] for translating binary-data from and to Base16 (hexadecimal).
 *
 * By specification, this implementation uses the following character table:
 * ```
 * 0123456789abcdef
 * ```
 *
 * @since Kommons 1.0
 * @author Tassilo Lemke
 */
expect object Base16 : Encoder<String>, Decoder<String>
