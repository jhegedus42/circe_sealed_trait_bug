package app.shared

sealed trait SharedError2 {
  val description: String
}

case class InvalidUUIDError2(description: String)  extends SharedError2

