package progfun.exceptions

final case class InvalidInputDataException(private val message: String)
    extends Exception(message)
