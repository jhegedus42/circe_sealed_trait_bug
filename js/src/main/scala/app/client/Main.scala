package app.client

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport("Main")
object Main extends js.JSApp {
  @JSExport
  def main(): Unit = {
    println("hello")
  }

}
