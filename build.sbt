import Dependencies._

ThisBuild / scalaVersion       := "2.13.0"
ThisBuild / crossScalaVersions := Seq("2.12.8")
ThisBuild / version            := "1.0.0"
ThisBuild / organization       := "dev.bgahagan"
ThisBuild / organizationName   := "bgahagan"
ThisBuild / organizationHomepage := Some(url("https://bgahagan.dev/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/bgahagan/scala-regex-interpolation"),
    "scm:git@github.com:bgahagan/scala-regex-interpolation.git"
  )
)
ThisBuild / developers := List(
  Developer(
    name  = "Bryan Gahagan",
    url   = url("https://bgahagan.dev")
  )
)

ThisBuild / description := "String interpolation of regex capture groups in scala match statements"
ThisBuild / licenses := List("MIT" -> new URL("https://github.com/bgahagan/scala-regex-interpolation/blob/master/LICENSE"))
ThisBuild / homepage := Some(url("https://github.com/bgahagan/scala-regex-interpolation/"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

lazy val root = (project in file("."))
  .settings(
    name := "scala-regex-interpolation",
    libraryDependencies += scalaTest % Test
  )

