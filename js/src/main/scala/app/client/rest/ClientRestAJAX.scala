/**
  * Created by joco on 11/05/2017.
  */
package app.client.rest

import app.shared.{SharedError2}

object ClientRestAJAX2 {


  def getEntity() {
    val x = "bla"
    import io.circe._
    import io.circe.generic.auto._
    import io.circe.parser._
    import io.circe._, io.circe.generic.semiauto._


//    implicit val fooDecoder: Decoder[SharedError2] = deriveDecoder[SharedError2]

    import SharedError2.fooDecoder
    decode[SharedError2](x)(SharedError2.fooDecoder)
    ???
  }
}


