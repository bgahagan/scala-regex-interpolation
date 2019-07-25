import Dependencies._

ThisBuild / scalaVersion       := "2.13.0"
ThisBuild / crossScalaVersions := Seq("2.12.8", scalaVersion.value)
ThisBuild / organization       := "dev.bgahagan"
ThisBuild / description        := "String interpolation of regex capture groups in scala match statements"


import xerial.sbt.Sonatype._
val gitHub = GitHubHosting("bgahagan", "scala-regex-interpolation", "scala-regex-interpolation@bgahagan.dev")
sonatypeProjectHosting := Some(gitHub)

ThisBuild / licenses := List("MIT" -> new URL("https://github.com/bgahagan/scala-regex-interpolation/blob/master/LICENSE"))

ThisBuild / publishTo := sonatypePublishTo.value

ThisBuild / publishMavenStyle := true

lazy val root = (project in file("."))
  .settings(
    name := gitHub.repository,
    libraryDependencies += scalaTest % Test
  )

credentials += Credentials(
  "GnuPG Key ID",
  "gpg",
  "6FFAF1538F282F76",
  "ignored"
)

releaseCrossBuild := true
import ReleaseTransformations._
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  //releaseStepCommand(s"""sonatypeOpen "${organization.value}" "Release ${version.value}""""),
  publishArtifacts,
  releaseStepCommand("sonatypeRelease"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
