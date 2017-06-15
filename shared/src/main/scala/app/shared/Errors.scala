package app.shared

sealed trait SharedError2 {
  val description: String
}

case class InvalidUUIDError2(description: String)  extends SharedError2

object SharedError2 // does not help