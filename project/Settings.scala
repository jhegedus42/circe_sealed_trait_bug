import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._


object Settings {

  val name = "scalajs-spa"

  val version = "1.1.4"

  val scalacOptions = Seq(
    "-Xlint",
    "-unchecked",
    "-deprecation",
    "-feature",
    "-Yrangepos" //,
  )

  object versions {
    val scala = "2.11.8"
  }

  val circeVersion = "0.8.0"

  val sharedDependencies = Def.setting(
    (Seq(
        "io.circe" %%% "circe-core",
        "io.circe" %%% "circe-generic",
        "io.circe" %%% "circe-parser"
      ).map(_ % circeVersion)))

  val jvmDependencies = Def.setting( (Seq( ) ))

  val scalajsDependencies = Def.setting( Seq( ))
}
