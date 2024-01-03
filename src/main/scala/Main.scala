import voicevox.all.*
import scala.scalanative.unsafe.*
import com.github.tarao.record4s.%
import com.github.tarao.record4s.circe.Codec.decoder
import io.circe.generic.auto.*
import io.circe.parser.parse
import scala.scalanative.libc.stdlib
import scala.scalanative.unsigned.UInt
import scala.scalanative.unsigned.UnsignedRichInt
import scala.scalanative.unsafe.UnsafeRichArray
import voicevox.structs.VoicevoxAudioQueryOptions
import java.nio.charset.Charset

// Define some structure that corresponds JSON that VOICEVOX core returns.
// Extensible records by record4s.
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
  // `Zone` protects code from memory leak and dungling pointers.
  // Allocated heap memory is released automatically when leaving `Zone`.
  def main(args: Array[String]): Unit = Zone { implicit z =>
    println("Hello, world!")
    
    // All structs and enums are exported from voicevox.all.*
    val conf = VoicevoxInitializeOptions(
      acceleration_mode = VoicevoxAccelerationMode.VOICEVOX_ACCELERATION_MODE_AUTO,
      cpu_num_threads = 0.toUShort,
      load_all_models = false,
      // C API requires CString on Scala Native (due to inner layout).
      // We can write CString literal using `c` interpolator.
      // CAVEAT: c interpolator does not work for UTF-8 string e.g. c"日本語"
      open_jtalk_dict_dir = c"./voicevox_core/open_jtalk_dic_utf_8-1.11"
    )
    print("initializing voicevox...")

    // At first, initialize VOICEVOX.
    // All functions are exported from voicevox.all.*
    voicevox_initialize(conf)
    println("done.")
    // To convert CString -> String, use scala.scalanative.unsafe.fromCString
    val ver = fromCString(voicevox_get_version())
    println(ver)
    val meta = fromCString(voicevox_get_metas_json())

    // Parsing JSON. Circe is one of nice JSON library that supports Scala Native.
    val parsedMeta = parse(meta).right.get.as[Seq[Voice]]
    val zunda = parsedMeta.right.get.find(v => v.name == "ずんだもん")
    val zundaNormal = zunda.get.styles.find(_.name == "ノーマル").get
    // We can convert Int -> UInt (of Scala Native) using `.toUInt`.
    // This method is provided from `scala.scalanative.unsigned.UnsignedRichInt`.
    val zundaNormalId = zundaNormal.id.toUInt
    println(zundaNormal)

    // Load model for ずんだもん(ノーマル).
    voicevox_load_model(zundaNormalId)
    val opts = VoicevoxTtsOptions()

    // `voicevox_tts` returns array of bytes i.e. Ptr[uint8_t].
    // To retrieve Ptr[uint8_t],
    // we give Ptr[Ptr[uint8_t]] (i.e. "pointer to array of bytes") to `voicevox_tts`.
    // To allocate empty pointer, we use `alloc` and give `Ptr[voicevox.aliases.uint8_t]` as type params.
    // This means "Give me pointer for Ptr[voicevox.aliases.uint8_t]".
    // Due to this is just a pointer, we give 1 as size to allocate.
    val wav = alloc[Ptr[voicevox.aliases.uint8_t]](1)
    // For trivial allocation, we can use `stackalloc`.
    // `alloc` acquires memory from heap, and `stackalloc` acquires it from stack.
    val wavlen = stackalloc[voicevox.aliases.uintptr_t](1)
    // To create UTF-8 CString, we have to use `toCString` and specify Charset.
    val text = toCString("こんにちは、スカラからボイスボックスを呼び出しています。", Charset.forName("UTF-8"))

    // Run TTS. The function stores pointer for length of array into `wavlen`.
    // The function stores pointer for wav buffer into `wav`.
    val tts = voicevox_tts(
      text,
      zundaNormalId,
      opts,
      wavlen,
      wav
    )
    println(s"Length: ${(!wavlen).value} bytes")

    // Convert `Ptr[Ptr[voicevox.aliases.uint8_t]]` to `LazyList[Byte]`.
    // TODO: use better way to convert it
    val wavIter = LazyList.unfold(0){
      case n if n <= (!wavlen).value.toLong =>
        Some((!wav).apply(n).toByte, n+1)
      case _ => None
    }

    // Export to file
    os.write.over(os.pwd / "voicevox.wav", wavIter.toArray)
    println("Wrote to voicevox.wav")

    // Free voicevox resources.
    voicevox_wav_free(!wav)
    voicevox_finalize()
  }
}
