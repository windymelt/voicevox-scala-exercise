import voicevox.all.*
import scala.scalanative.unsafe.{Zone, fromCString}
import com.github.tarao.record4s.%
import com.github.tarao.record4s.circe.Codec.decoder
import io.circe.generic.auto.*
import io.circe.parser.parse

type Style = % {
  val name: String
  val id: Int
}

type Voice = % {
  val name: String
  val styles: Seq[Style]
  val speaker_uuid: String
  val version: String
}

object Main {
  def main(args: Array[String]): Unit = Zone { implicit z =>
    println("Hello, world!")
    val conf = VoicevoxInitializeOptions()
    print("initializing voicevox...")
    voicevox_initialize(conf)
    println("done.")
    val ver = fromCString(voicevox_get_version())
    println(ver)
    val meta = fromCString(voicevox_get_metas_json())
    val parsedMeta = parse(meta).right.get.as[Seq[Voice]]
    println(parsedMeta)
    voicevox_finalize()
  }
}
