import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object Settings {

//  val ex=exclude("com.chuusai","shapeless")
  /** The name of your application */
  val name = "scalajs-spa"

  /** The version of your application */
  val version = "1.1.4"

//  val targetDir = (classDirectory in Compile).value / "web"

  /** Options for the scala compiler */
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

  val scalaTest = Seq("org.scalatest" %% "scalatest" % "3.0.1" % "test",
                      "org.specs2" %% "specs2-core" % "3.8.9" % "test")

  val circeVersion = "0.7.0"

  val sharedDependencies = Def.setting(
    (Seq( ) ++ Seq(
        "io.circe" %%% "circe-core",
        "io.circe" %%% "circe-generic",
        "io.circe" %%% "circe-parser"
      ).map(_ % circeVersion)))

  /** Dependencies only used by the JVM project */
  val jvmDependencies = Def.setting(
    (Seq( ) ++ scalaTest))

  /** Dependencies only used by the JS project (note the use of %%% instead of %%) */
  val scalajsDependencies = Def.setting(
    Seq(
      "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
    ))
}
