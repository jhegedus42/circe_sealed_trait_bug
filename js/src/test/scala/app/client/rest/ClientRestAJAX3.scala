package app.client.rest


import app.shared.{SharedError2}

object ClientRestAJAX3 {


  def getEntity() {
    val x = "bla"
    import io.circe._
    import io.circe.generic.auto._
    import io.circe.parser._
    decode[SharedError2](x)
    ???
  }
}

