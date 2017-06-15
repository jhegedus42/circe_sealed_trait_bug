import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

/**
  * Application settings. Configure the build for your application here.
  * You normally don't have to touch the actual build definition after this.
  */
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
//       "-Ylog-classpath"
//    "-Xlog-implicits"
  )

  /** Declare global dependency versions here to avoid mismatches in multi part dependencies */
  object versions {
    val scala = "2.11.8"
    val scalaDom = "0.9.1"
    val scalajsReact = "0.11.3"
    val scalaCSS = "0.5.0"

    val akka = "2.4.18"
    val in_memory_journal = "2.4.18.0"

    val akkaHttp = "10.0.5"

    val monocleVersion = "1.4.0"

  }

  /**
    * These dependencies are shared between JS and JVM projects
    * the special %%% function selects the correct version for each project
    */
  val scalaTest = Seq("org.scalatest" %% "scalatest" % "3.0.1" % "test",
                      "org.specs2" %% "specs2-core" % "3.8.9" % "test")

  val circeVersion = "0.7.0"

  val sharedDependencies = Def.setting(
    (Seq(
      "com.github.johnreedlol" %% "scala-trace-debug" % "4.5.0", //todolater start using this, maybe ?
      "de.heikoseeberger" %% "akka-http-circe" % "1.15.0",
      "com.lihaoyi" %%% "scalatags" % "0.6.2",
      "com.github.julien-truffaut" %%% "monocle-core" % versions.monocleVersion,
      "com.github.julien-truffaut" %%% "monocle-macro" % versions.monocleVersion,
      "org.scalaz" %% "scalaz-core" % "7.2.8",
//          "com.netaporter" %%% "scala-uri" % "0.4.16",
      "com.github.julien-truffaut" %% "monocle-law" % versions.monocleVersion % "test"
    ) ++
//        scalaTest ++
      Seq(
        "io.circe" %%% "circe-core",
        "io.circe" %%% "circe-generic",
        "io.circe" %%% "circe-parser"
      ).map(_ % circeVersion)))

  /** Dependencies only used by the JVM project */
  val jvmDependencies = Def.setting(
    (Seq(
      "ch.megard" %% "akka-http-cors" % "0.2.1",
      "com.github.dnvriend" %% "akka-persistence-inmemory" % versions.in_memory_journal,
      "com.typesafe.akka" %% "akka-persistence" % versions.akka,
      "org.iq80.leveldb" % "leveldb" % "0.7",
      "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8",
      "com.typesafe.akka" %% "akka-actor" % versions.akka,
      "com.typesafe.akka" %% "akka-slf4j" % versions.akka,
//          "ch.qos.logback"    % "logback-classic"            % "1.1.2",
      "com.typesafe.akka" %% "akka-http" % versions.akkaHttp,
      "com.typesafe.akka" %% "akka-http-testkit" % "10.0.5",
      "org.slf4j" % "slf4j-simple" % "1.7.25",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.5"
    ) ++ scalaTest))

  /** Dependencies only used by the JS project (note the use of %%% instead of %%) */
  val scalajsDependencies = Def.setting(
    Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % versions.scalajsReact,
      "com.github.japgolly.scalajs-react" %%% "extra" % versions.scalajsReact,
      "com.github.japgolly.scalacss" %%% "ext-react" % versions.scalaCSS,
      "org.scala-js" %%% "scalajs-dom" % versions.scalaDom,
      "com.github.chandu0101.scalajs-react-components" %%% "core" % "0.5.0",
      "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
    ))
}
