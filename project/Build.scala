import sbt._
import Keys._
import org.sbtidea.SbtIdeaPlugin._
import sbtassembly.Plugin._
import AssemblyKeys._


object BuildSettings {
  val buildOrganization = "io.github.rmuhamedgaliev"
  val buildVersion      = "1.0"
  val buildScalaVersion = "2.11.1"
  val projectName = "root"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version      := buildVersion,
    scalaVersion := buildScalaVersion,
    ideaExcludeFolders := ".idea" :: ".idea_modules" :: Nil,
    scalacOptions ++= Seq("-encoding", "UTF-8", "-Xlint", "-deprecation", "-unchecked", "-feature"),
    crossPaths := false
  )
}

object  Resolvers {
  val typeSafe = "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"
}

object Dependencies {
  val scalaTestV = "2.2.0"

  val scalaTest = "org.scalatest" % "scalatest_2.11" % scalaTestV % "test"
}

object SkeletonBuild extends Build {
  import Resolvers._
  import Dependencies._
  import BuildSettings._

  val rootDependencies = Seq (
    scalaTest
  )

  lazy val root = Project(
    projectName,
    file("."),
    settings = buildSettings ++ assemblySettings ++ Seq (
      jarName in assembly := projectName + ".jar",
      mainClass in assembly := Some(buildOrganization + ".Main"),
      libraryDependencies ++= rootDependencies
    )
  )

}
