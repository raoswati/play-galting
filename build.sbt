import _root_.io.gatling.sbt.GatlingPlugin
import _root_.sbt.Keys._


name := """play-gatling-tutorial-one"""

version := "1.0-SNAPSHOT"


lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .enablePlugins(GatlingPlugin)
  .configs(GTest)
  .settings(inConfig(GTest)(Defaults.testSettings): _*)


scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.2" % "test",
  "io.gatling" % "gatling-test-framework" % "2.2.2" % "test"

)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

lazy val GTest = config("gatling") extend (Test)

scalaSource in GTest := baseDirectory.value / "/gatling/simulation"