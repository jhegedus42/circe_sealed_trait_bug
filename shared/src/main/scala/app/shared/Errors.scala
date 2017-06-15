package app.shared

sealed trait SharedError2 {
  val description: String
}


import io.circe._, io.circe.generic.semiauto._

case class InvalidUUIDError2(description: String)  extends SharedError2

object SharedError2 // does not help
{

  implicit val fooDecoder: Decoder[SharedError2] = deriveDecoder[SharedError2]
}
