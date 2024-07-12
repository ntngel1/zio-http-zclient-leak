ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "zio-http-leak"
  )

libraryDependencies += "dev.zio" %% "zio" % "2.1.6"
libraryDependencies += "dev.zio" %% "zio-http" % "3.0.0-RC9"

