enablePlugins(ScalaJSPlugin)

enablePlugins(ScalaJSBundlerPlugin) // only needed for your JS dependencies, not for Laminar

name := "Laminar Examples"

version := "0.1-SNAPSHOT"

normalizedName := "laminarexamples"

organization := "com.raquo"

scalaVersion := "2.13.5"

crossScalaVersions := Seq("2.12.13", "2.13.5", "3.0.0")

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "1.0.0"

npmDependencies in Compile ++= Seq(
  "jquery" -> "2.1.3"
)

libraryDependencies ++= Seq(
  "com.raquo" %%% "laminar" % "0.13.1",
  "com.lihaoyi" %%% "upickle" % "1.3.13",
  "com.raquo" %%% "waypoint" % "0.4.1",
  "com.raquo" %%% "domtestutils" % Versions.ScalaDomTestUtils % Test,
  "org.scalatest" %%% "scalatest" % Versions.ScalaTest % Test,
  "be.doeraene" %%% "scalajs-jquery" % "1.0.0" % Test
)

Compile / npmDependencies += "@material/mwc-button" -> "0.18.0"

Compile / npmDependencies += "@material/mwc-linear-progress" -> "0.18.0"

Compile / npmDependencies += "@material/mwc-slider" -> "0.18.0"

scalaJSUseMainModuleInitializer := true

Compile / fastOptJS / scalaJSLinkerConfig ~= { _.withSourceMap(false) }

Compile / fullOptJS / scalaJSLinkerConfig ~= { _.withSourceMap(false) }

useYarn := true

(Test / requireJsDomEnv) := true

(Test / parallelExecution) := false

