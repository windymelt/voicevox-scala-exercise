scalaVersion := "3.3.0"

enablePlugins(ScalaNativePlugin, BindgenPlugin)

val circeVersion = "0.14.6"

libraryDependencies ++= Seq(
  "io.circe" %%% "circe-core",
  "io.circe" %%% "circe-generic",
  "io.circe" %%% "circe-parser"
).map(_ % circeVersion)

libraryDependencies ++= Seq(
  "com.github.tarao" %%% "record4s" % "0.10.0",
  "com.github.tarao" %%% "record4s-circe" % "0.10.0"
)

// set to Debug for compilation details (Info is default)
logLevel := Level.Info

// import to add Scala Native options
import scala.scalanative.build._

// defaults set with common options shown
nativeConfig := {
  val c = nativeConfig.value
  c.withLTO(LTO.none) // thin
    .withMode(Mode.debug) // releaseFast
    .withGC(GC.immix) // commix
    .withLinkingOptions(
      List("-lvoicevox_core", "-lonnxruntime", "-L", "/usr/local/lib/")
    )
    .withCompileOptions(Seq("-I", ((Compile / resourceDirectory).value / "scala-native").toString))
}

import bindgen.interface.Binding
import bindgen.plugin.BindgenMode.Manual
bindgenMode := Manual(
  scalaDir = ((Compile / sourceDirectory).value / "scala" / "generated"),
  cDir = (Compile / resourceDirectory).value / "scala-native" / "generated",
)
bindgenBindings := Seq(
  Binding
    .builder(
      (Compile / resourceDirectory).value / "scala-native" / "voicevox_core.h",
      "voicevox"
    )
    .addCImport("voicevox_core.h")
    .build
  )
