package app.shared
import io.circe._, io.circe.generic.semiauto._

sealed trait SharedError2 {
  val description: String
}


case class InvalidUUIDError2(description: String)  extends SharedError2

object SharedError2 // does not help
{

  implicit val fooDecoder: Decoder[SharedError2] = deriveDecoder[SharedError2]
}