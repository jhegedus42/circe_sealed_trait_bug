name := "IM root project"

//scalaVersion in ThisBuild := "2.11.8"

lazy val root = project
  .in(file("."))
  .aggregate(imJS, imJVM)
  .settings(
    scalaVersion := Settings.versions.scala,
    publish := {},
    publishLocal := {}
  )

lazy val im = crossProject
  .in(file("."))
  .settings(
    libraryDependencies ++= Settings.sharedDependencies.value,
    addCompilerPlugin(
      "org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
    scalaVersion := Settings.versions.scala,
    name := "im",
    version := "0.1-SNAPSHOT"
  )
  .jvmSettings(
    libraryDependencies ++= Settings.jvmDependencies.value,
    mainClass in Compile := Some("app.Server")
  )
  .jsSettings(
    mainClass in Compile := Some("app.client.Main"),
    libraryDependencies ++= Settings.scalajsDependencies.value,
    persistLauncher in Compile := true,
    persistLauncher in Test := false,
                               jsDependencies += RuntimeDOM
  )

lazy val imJVM = im.jvm
lazy val imJS = im.js

persistLauncher in Compile := true

persistLauncher in Test := false
