package voicevox

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object predef:
  private[voicevox] trait CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (inline t: T)
     inline def int: CInt = eq.apply(t).toInt
     inline def uint: CUnsignedInt = eq.apply(t)
     inline def value: CUnsignedInt = eq.apply(t)


object enumerations:
  import predef.*
  /**
   * ハードウェアアクセラレーションモードを設定する設定値
  
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  opaque type VoicevoxAccelerationMode = CUnsignedInt
  object VoicevoxAccelerationMode extends CEnumU[VoicevoxAccelerationMode]:
    given _tag: Tag[VoicevoxAccelerationMode] = Tag.UInt
    inline def define(inline a: Long): VoicevoxAccelerationMode = a.toUInt
    val VOICEVOX_ACCELERATION_MODE_AUTO = define(0)
    val VOICEVOX_ACCELERATION_MODE_CPU = define(1)
    val VOICEVOX_ACCELERATION_MODE_GPU = define(2)
    inline def getName(inline value: VoicevoxAccelerationMode): Option[String] =
      inline value match
        case VOICEVOX_ACCELERATION_MODE_AUTO => Some("VOICEVOX_ACCELERATION_MODE_AUTO")
        case VOICEVOX_ACCELERATION_MODE_CPU => Some("VOICEVOX_ACCELERATION_MODE_CPU")
        case VOICEVOX_ACCELERATION_MODE_GPU => Some("VOICEVOX_ACCELERATION_MODE_GPU")
        case _ => None
    extension (a: VoicevoxAccelerationMode)
      inline def &(b: VoicevoxAccelerationMode): VoicevoxAccelerationMode = a & b
      inline def |(b: VoicevoxAccelerationMode): VoicevoxAccelerationMode = a | b
      inline def is(b: VoicevoxAccelerationMode): Boolean = (a & b) == b

  /**
   * 処理結果を示す結果コード
  
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  opaque type VoicevoxResultCode = CUnsignedInt
  object VoicevoxResultCode extends CEnumU[VoicevoxResultCode]:
    given _tag: Tag[VoicevoxResultCode] = Tag.UInt
    inline def define(inline a: Long): VoicevoxResultCode = a.toUInt
    val VOICEVOX_RESULT_OK = define(0)
    val VOICEVOX_RESULT_NOT_LOADED_OPENJTALK_DICT_ERROR = define(1)
    val VOICEVOX_RESULT_LOAD_MODEL_ERROR = define(2)
    val VOICEVOX_RESULT_GET_SUPPORTED_DEVICES_ERROR = define(3)
    val VOICEVOX_RESULT_GPU_SUPPORT_ERROR = define(4)
    val VOICEVOX_RESULT_LOAD_METAS_ERROR = define(5)
    val VOICEVOX_RESULT_UNINITIALIZED_STATUS_ERROR = define(6)
    val VOICEVOX_RESULT_INVALID_SPEAKER_ID_ERROR = define(7)
    val VOICEVOX_RESULT_INVALID_MODEL_INDEX_ERROR = define(8)
    val VOICEVOX_RESULT_INFERENCE_ERROR = define(9)
    val VOICEVOX_RESULT_EXTRACT_FULL_CONTEXT_LABEL_ERROR = define(10)
    val VOICEVOX_RESULT_INVALID_UTF8_INPUT_ERROR = define(11)
    val VOICEVOX_RESULT_PARSE_KANA_ERROR = define(12)
    val VOICEVOX_RESULT_INVALID_AUDIO_QUERY_ERROR = define(13)
    inline def getName(inline value: VoicevoxResultCode): Option[String] =
      inline value match
        case VOICEVOX_RESULT_OK => Some("VOICEVOX_RESULT_OK")
        case VOICEVOX_RESULT_NOT_LOADED_OPENJTALK_DICT_ERROR => Some("VOICEVOX_RESULT_NOT_LOADED_OPENJTALK_DICT_ERROR")
        case VOICEVOX_RESULT_LOAD_MODEL_ERROR => Some("VOICEVOX_RESULT_LOAD_MODEL_ERROR")
        case VOICEVOX_RESULT_GET_SUPPORTED_DEVICES_ERROR => Some("VOICEVOX_RESULT_GET_SUPPORTED_DEVICES_ERROR")
        case VOICEVOX_RESULT_GPU_SUPPORT_ERROR => Some("VOICEVOX_RESULT_GPU_SUPPORT_ERROR")
        case VOICEVOX_RESULT_LOAD_METAS_ERROR => Some("VOICEVOX_RESULT_LOAD_METAS_ERROR")
        case VOICEVOX_RESULT_UNINITIALIZED_STATUS_ERROR => Some("VOICEVOX_RESULT_UNINITIALIZED_STATUS_ERROR")
        case VOICEVOX_RESULT_INVALID_SPEAKER_ID_ERROR => Some("VOICEVOX_RESULT_INVALID_SPEAKER_ID_ERROR")
        case VOICEVOX_RESULT_INVALID_MODEL_INDEX_ERROR => Some("VOICEVOX_RESULT_INVALID_MODEL_INDEX_ERROR")
        case VOICEVOX_RESULT_INFERENCE_ERROR => Some("VOICEVOX_RESULT_INFERENCE_ERROR")
        case VOICEVOX_RESULT_EXTRACT_FULL_CONTEXT_LABEL_ERROR => Some("VOICEVOX_RESULT_EXTRACT_FULL_CONTEXT_LABEL_ERROR")
        case VOICEVOX_RESULT_INVALID_UTF8_INPUT_ERROR => Some("VOICEVOX_RESULT_INVALID_UTF8_INPUT_ERROR")
        case VOICEVOX_RESULT_PARSE_KANA_ERROR => Some("VOICEVOX_RESULT_PARSE_KANA_ERROR")
        case VOICEVOX_RESULT_INVALID_AUDIO_QUERY_ERROR => Some("VOICEVOX_RESULT_INVALID_AUDIO_QUERY_ERROR")
        case _ => None
    extension (a: VoicevoxResultCode)
      inline def &(b: VoicevoxResultCode): VoicevoxResultCode = a & b
      inline def |(b: VoicevoxResultCode): VoicevoxResultCode = a | b
      inline def is(b: VoicevoxResultCode): Boolean = (a & b) == b

object aliases:
  import _root_.voicevox.enumerations.*
  import _root_.voicevox.predef.*
  import _root_.voicevox.aliases.*
  import _root_.voicevox.structs.*
  // /**
  //  * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  // */
  // type VoicevoxAccelerationMode = int32_t
  // object VoicevoxAccelerationMode: 
  //   given _tag: Tag[VoicevoxAccelerationMode] = int32_t._tag
  //   inline def apply(inline o: int32_t): VoicevoxAccelerationMode = o
  //   extension (v: VoicevoxAccelerationMode)
  //     inline def value: int32_t = v

  // /**
  //  * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  // */
  // type VoicevoxResultCode = int32_t
  // object VoicevoxResultCode: 
  //   given _tag: Tag[VoicevoxResultCode] = int32_t._tag
  //   inline def apply(inline o: int32_t): VoicevoxResultCode = o
  //   extension (v: VoicevoxResultCode)
  //     inline def value: int32_t = v

  type int32_t = scala.scalanative.unsafe.CInt
  object int32_t: 
    val _tag: Tag[int32_t] = summon[Tag[scala.scalanative.unsafe.CInt]]
    inline def apply(inline o: scala.scalanative.unsafe.CInt): int32_t = o
    extension (v: int32_t)
      inline def value: scala.scalanative.unsafe.CInt = v

  type int64_t = scala.Long
  object int64_t: 
    val _tag: Tag[int64_t] = summon[Tag[scala.Long]]
    inline def apply(inline o: scala.Long): int64_t = o
    extension (v: int64_t)
      inline def value: scala.Long = v

  type uint16_t = scala.scalanative.unsigned.UShort
  object uint16_t: 
    val _tag: Tag[uint16_t] = summon[Tag[scala.scalanative.unsigned.UShort]]
    inline def apply(inline o: scala.scalanative.unsigned.UShort): uint16_t = o
    extension (v: uint16_t)
      inline def value: scala.scalanative.unsigned.UShort = v

  type uint32_t = scala.scalanative.unsigned.UInt
  object uint32_t: 
    val _tag: Tag[uint32_t] = summon[Tag[scala.scalanative.unsigned.UInt]]
    inline def apply(inline o: scala.scalanative.unsigned.UInt): uint32_t = o
    extension (v: uint32_t)
      inline def value: scala.scalanative.unsigned.UInt = v

  type uint8_t = scala.scalanative.unsigned.UByte
  object uint8_t: 
    val _tag: Tag[uint8_t] = summon[Tag[scala.scalanative.unsigned.UByte]]
    inline def apply(inline o: scala.scalanative.unsigned.UByte): uint8_t = o
    extension (v: uint8_t)
      inline def value: scala.scalanative.unsigned.UByte = v

  /**
   * [bindgen] header: /usr/include/stdint.h
  */
  opaque type uintptr_t = CUnsignedLongInt
  object uintptr_t: 
    given _tag: Tag[uintptr_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): uintptr_t = o
    extension (v: uintptr_t)
      inline def value: CUnsignedLongInt = v

object structs:
  import _root_.voicevox.enumerations.*
  import _root_.voicevox.predef.*
  import _root_.voicevox.aliases.*
  import _root_.voicevox.structs.*
  /**
   * Audio query のオプション
  
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  opaque type VoicevoxAudioQueryOptions = CStruct1[Boolean]
  object VoicevoxAudioQueryOptions:
    given _tag: Tag[VoicevoxAudioQueryOptions] = Tag.materializeCStruct1Tag[Boolean]
    def apply()(using Zone): Ptr[VoicevoxAudioQueryOptions] = scala.scalanative.unsafe.alloc[VoicevoxAudioQueryOptions](1)
    def apply(kana : Boolean)(using Zone): Ptr[VoicevoxAudioQueryOptions] = 
      val ____ptr = apply()
      (!____ptr).kana = kana
      ____ptr
    extension (struct: VoicevoxAudioQueryOptions)
      def kana : Boolean = struct._1
      def kana_=(value: Boolean): Unit = !struct.at1 = value

  /**
   * 初期化オプション
  
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  opaque type VoicevoxInitializeOptions = CStruct4[VoicevoxAccelerationMode, uint16_t, Boolean, CString]
  object VoicevoxInitializeOptions:
    given _tag: Tag[VoicevoxInitializeOptions] = Tag.materializeCStruct4Tag[VoicevoxAccelerationMode, uint16_t, Boolean, CString]
    def apply()(using Zone): Ptr[VoicevoxInitializeOptions] = scala.scalanative.unsafe.alloc[VoicevoxInitializeOptions](1)
    def apply(acceleration_mode : VoicevoxAccelerationMode, cpu_num_threads : uint16_t, load_all_models : Boolean, open_jtalk_dict_dir : CString)(using Zone): Ptr[VoicevoxInitializeOptions] = 
      val ____ptr = apply()
      (!____ptr).acceleration_mode = acceleration_mode
      (!____ptr).cpu_num_threads = cpu_num_threads
      (!____ptr).load_all_models = load_all_models
      (!____ptr).open_jtalk_dict_dir = open_jtalk_dict_dir
      ____ptr
    extension (struct: VoicevoxInitializeOptions)
      def acceleration_mode : VoicevoxAccelerationMode = struct._1
      def acceleration_mode_=(value: VoicevoxAccelerationMode): Unit = !struct.at1 = value
      def cpu_num_threads : uint16_t = struct._2
      def cpu_num_threads_=(value: uint16_t): Unit = !struct.at2 = value
      def load_all_models : Boolean = struct._3
      def load_all_models_=(value: Boolean): Unit = !struct.at3 = value
      def open_jtalk_dict_dir : CString = struct._4
      def open_jtalk_dict_dir_=(value: CString): Unit = !struct.at4 = value

  /**
   * `voicevox_synthesis` のオプション
  
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  opaque type VoicevoxSynthesisOptions = CStruct1[Boolean]
  object VoicevoxSynthesisOptions:
    given _tag: Tag[VoicevoxSynthesisOptions] = Tag.materializeCStruct1Tag[Boolean]
    def apply()(using Zone): Ptr[VoicevoxSynthesisOptions] = scala.scalanative.unsafe.alloc[VoicevoxSynthesisOptions](1)
    def apply(enable_interrogative_upspeak : Boolean)(using Zone): Ptr[VoicevoxSynthesisOptions] = 
      val ____ptr = apply()
      (!____ptr).enable_interrogative_upspeak = enable_interrogative_upspeak
      ____ptr
    extension (struct: VoicevoxSynthesisOptions)
      def enable_interrogative_upspeak : Boolean = struct._1
      def enable_interrogative_upspeak_=(value: Boolean): Unit = !struct.at1 = value

  /**
   * テキスト音声合成オプション
  
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  opaque type VoicevoxTtsOptions = CStruct2[Boolean, Boolean]
  object VoicevoxTtsOptions:
    given _tag: Tag[VoicevoxTtsOptions] = Tag.materializeCStruct2Tag[Boolean, Boolean]
    def apply()(using Zone): Ptr[VoicevoxTtsOptions] = scala.scalanative.unsafe.alloc[VoicevoxTtsOptions](1)
    def apply(kana : Boolean, enable_interrogative_upspeak : Boolean)(using Zone): Ptr[VoicevoxTtsOptions] = 
      val ____ptr = apply()
      (!____ptr).kana = kana
      (!____ptr).enable_interrogative_upspeak = enable_interrogative_upspeak
      ____ptr
    extension (struct: VoicevoxTtsOptions)
      def kana : Boolean = struct._1
      def kana_=(value: Boolean): Unit = !struct.at1 = value
      def enable_interrogative_upspeak : Boolean = struct._2
      def enable_interrogative_upspeak_=(value: Boolean): Unit = !struct.at2 = value


@extern
private[voicevox] object extern_functions:
  import _root_.voicevox.enumerations.*
  import _root_.voicevox.predef.*
  import _root_.voicevox.aliases.*
  import _root_.voicevox.structs.*
  private[voicevox] def __sn_wrap_voicevox_voicevox_audio_query(text : CString, speaker_id : uint32_t, options : Ptr[VoicevoxAudioQueryOptions], output_audio_query_json : Ptr[CString]): VoicevoxResultCode = extern

  private[voicevox] def __sn_wrap_voicevox_voicevox_initialize(options : Ptr[VoicevoxInitializeOptions]): VoicevoxResultCode = extern

  private[voicevox] def __sn_wrap_voicevox_voicevox_make_default_audio_query_options(__return : Ptr[VoicevoxAudioQueryOptions]): Unit = extern

  private[voicevox] def __sn_wrap_voicevox_voicevox_make_default_initialize_options(__return : Ptr[VoicevoxInitializeOptions]): Unit = extern

  private[voicevox] def __sn_wrap_voicevox_voicevox_make_default_synthesis_options(__return : Ptr[VoicevoxSynthesisOptions]): Unit = extern

  private[voicevox] def __sn_wrap_voicevox_voicevox_make_default_tts_options(__return : Ptr[VoicevoxTtsOptions]): Unit = extern

  private[voicevox] def __sn_wrap_voicevox_voicevox_synthesis(audio_query_json : CString, speaker_id : uint32_t, options : Ptr[VoicevoxSynthesisOptions], output_wav_length : Ptr[uintptr_t], output_wav : Ptr[Ptr[uint8_t]]): VoicevoxResultCode = extern

  private[voicevox] def __sn_wrap_voicevox_voicevox_tts(text : CString, speaker_id : uint32_t, options : Ptr[VoicevoxTtsOptions], output_wav_length : Ptr[uintptr_t], output_wav : Ptr[Ptr[uint8_t]]): VoicevoxResultCode = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_audio_query_json_free(audio_query_json : CString): Unit = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_decode(length : uintptr_t, phoneme_size : uintptr_t, f0 : Ptr[Float], phoneme_vector : Ptr[Float], speaker_id : uint32_t, output_decode_data_length : Ptr[uintptr_t], output_decode_data : Ptr[Ptr[Float]]): VoicevoxResultCode = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_decode_data_free(decode_data : Ptr[Float]): Unit = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_error_result_to_message(result_code : VoicevoxResultCode): CString = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_finalize(): Unit = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_get_metas_json(): CString = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_get_supported_devices_json(): CString = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_get_version(): CString = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_is_gpu_mode(): Boolean = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_is_model_loaded(speaker_id : uint32_t): Boolean = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_load_model(speaker_id : uint32_t): VoicevoxResultCode = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_predict_duration(length : uintptr_t, phoneme_vector : Ptr[int64_t], speaker_id : uint32_t, output_predict_duration_data_length : Ptr[uintptr_t], output_predict_duration_data : Ptr[Ptr[Float]]): VoicevoxResultCode = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_predict_duration_data_free(predict_duration_data : Ptr[Float]): Unit = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_predict_intonation(length : uintptr_t, vowel_phoneme_vector : Ptr[int64_t], consonant_phoneme_vector : Ptr[int64_t], start_accent_vector : Ptr[int64_t], end_accent_vector : Ptr[int64_t], start_accent_phrase_vector : Ptr[int64_t], end_accent_phrase_vector : Ptr[int64_t], speaker_id : uint32_t, output_predict_intonation_data_length : Ptr[uintptr_t], output_predict_intonation_data : Ptr[Ptr[Float]]): VoicevoxResultCode = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_predict_intonation_data_free(predict_intonation_data : Ptr[Float]): Unit = extern

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_wav_free(wav : Ptr[uint8_t]): Unit = extern


object functions:
  import _root_.voicevox.enumerations.*
  import _root_.voicevox.predef.*
  import _root_.voicevox.aliases.*
  import _root_.voicevox.structs.*
  import extern_functions.*
  export extern_functions.*

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_audio_query(text : CString, speaker_id : uint32_t, options : VoicevoxAudioQueryOptions, output_audio_query_json : Ptr[CString])(using Zone): VoicevoxResultCode = 
    val __ptr_0: Ptr[VoicevoxAudioQueryOptions] = alloc[VoicevoxAudioQueryOptions](1)
    !(__ptr_0 + 0) = options
    __sn_wrap_voicevox_voicevox_audio_query(text, speaker_id, (__ptr_0 + 0), output_audio_query_json)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_audio_query(text : CString, speaker_id : uint32_t, options : Ptr[VoicevoxAudioQueryOptions], output_audio_query_json : Ptr[CString]): VoicevoxResultCode = 
    __sn_wrap_voicevox_voicevox_audio_query(text, speaker_id, options, output_audio_query_json)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_initialize(options : VoicevoxInitializeOptions)(using Zone): VoicevoxResultCode = 
    val __ptr_0: Ptr[VoicevoxInitializeOptions] = alloc[VoicevoxInitializeOptions](1)
    !(__ptr_0 + 0) = options
    __sn_wrap_voicevox_voicevox_initialize((__ptr_0 + 0))

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_initialize(options : Ptr[VoicevoxInitializeOptions]): VoicevoxResultCode = 
    __sn_wrap_voicevox_voicevox_initialize(options)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_make_default_audio_query_options()(using Zone): VoicevoxAudioQueryOptions = 
    val __ptr_0: Ptr[VoicevoxAudioQueryOptions] = alloc[VoicevoxAudioQueryOptions](1)
    __sn_wrap_voicevox_voicevox_make_default_audio_query_options((__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_make_default_audio_query_options()(__return : Ptr[VoicevoxAudioQueryOptions]): Unit = 
    __sn_wrap_voicevox_voicevox_make_default_audio_query_options(__return)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_make_default_initialize_options()(__return : Ptr[VoicevoxInitializeOptions]): Unit = 
    __sn_wrap_voicevox_voicevox_make_default_initialize_options(__return)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_make_default_initialize_options()(using Zone): VoicevoxInitializeOptions = 
    val __ptr_0: Ptr[VoicevoxInitializeOptions] = alloc[VoicevoxInitializeOptions](1)
    __sn_wrap_voicevox_voicevox_make_default_initialize_options((__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_make_default_synthesis_options()(using Zone): VoicevoxSynthesisOptions = 
    val __ptr_0: Ptr[VoicevoxSynthesisOptions] = alloc[VoicevoxSynthesisOptions](1)
    __sn_wrap_voicevox_voicevox_make_default_synthesis_options((__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_make_default_synthesis_options()(__return : Ptr[VoicevoxSynthesisOptions]): Unit = 
    __sn_wrap_voicevox_voicevox_make_default_synthesis_options(__return)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_make_default_tts_options()(using Zone): VoicevoxTtsOptions = 
    val __ptr_0: Ptr[VoicevoxTtsOptions] = alloc[VoicevoxTtsOptions](1)
    __sn_wrap_voicevox_voicevox_make_default_tts_options((__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_make_default_tts_options()(__return : Ptr[VoicevoxTtsOptions]): Unit = 
    __sn_wrap_voicevox_voicevox_make_default_tts_options(__return)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_synthesis(audio_query_json : CString, speaker_id : uint32_t, options : VoicevoxSynthesisOptions, output_wav_length : Ptr[uintptr_t], output_wav : Ptr[Ptr[uint8_t]])(using Zone): VoicevoxResultCode = 
    val __ptr_0: Ptr[VoicevoxSynthesisOptions] = alloc[VoicevoxSynthesisOptions](1)
    !(__ptr_0 + 0) = options
    __sn_wrap_voicevox_voicevox_synthesis(audio_query_json, speaker_id, (__ptr_0 + 0), output_wav_length, output_wav)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_synthesis(audio_query_json : CString, speaker_id : uint32_t, options : Ptr[VoicevoxSynthesisOptions], output_wav_length : Ptr[uintptr_t], output_wav : Ptr[Ptr[uint8_t]]): VoicevoxResultCode = 
    __sn_wrap_voicevox_voicevox_synthesis(audio_query_json, speaker_id, options, output_wav_length, output_wav)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_tts(text : CString, speaker_id : uint32_t, options : Ptr[VoicevoxTtsOptions], output_wav_length : Ptr[uintptr_t], output_wav : Ptr[Ptr[uint8_t]]): VoicevoxResultCode = 
    __sn_wrap_voicevox_voicevox_tts(text, speaker_id, options, output_wav_length, output_wav)

  /**
   * [bindgen] header: /home/windymelt/src/github.com/windymelt/voicevox-scala-exercise/src/main/resources/scala-native/voicevox_core.h
  */
  def voicevox_tts(text : CString, speaker_id : uint32_t, options : VoicevoxTtsOptions, output_wav_length : Ptr[uintptr_t], output_wav : Ptr[Ptr[uint8_t]])(using Zone): VoicevoxResultCode = 
    val __ptr_0: Ptr[VoicevoxTtsOptions] = alloc[VoicevoxTtsOptions](1)
    !(__ptr_0 + 0) = options
    __sn_wrap_voicevox_voicevox_tts(text, speaker_id, (__ptr_0 + 0), output_wav_length, output_wav)

object types:
  export _root_.voicevox.structs.*
  export _root_.voicevox.aliases.*
  export _root_.voicevox.enumerations.*

object all:
  export _root_.voicevox.enumerations.VoicevoxAccelerationMode
  export _root_.voicevox.enumerations.VoicevoxResultCode
  // export _root_.voicevox.aliases.VoicevoxAccelerationMode
  // export _root_.voicevox.aliases.VoicevoxResultCode
  export _root_.voicevox.aliases.int32_t
  export _root_.voicevox.aliases.int64_t
  export _root_.voicevox.aliases.uint16_t
  export _root_.voicevox.aliases.uint32_t
  export _root_.voicevox.aliases.uint8_t
  export _root_.voicevox.aliases.uintptr_t
  export _root_.voicevox.structs.VoicevoxAudioQueryOptions
  export _root_.voicevox.structs.VoicevoxInitializeOptions
  export _root_.voicevox.structs.VoicevoxSynthesisOptions
  export _root_.voicevox.structs.VoicevoxTtsOptions
  export _root_.voicevox.functions.voicevox_audio_query_json_free
  export _root_.voicevox.functions.voicevox_decode
  export _root_.voicevox.functions.voicevox_decode_data_free
  export _root_.voicevox.functions.voicevox_error_result_to_message
  export _root_.voicevox.functions.voicevox_finalize
  export _root_.voicevox.functions.voicevox_get_metas_json
  export _root_.voicevox.functions.voicevox_get_supported_devices_json
  export _root_.voicevox.functions.voicevox_get_version
  export _root_.voicevox.functions.voicevox_is_gpu_mode
  export _root_.voicevox.functions.voicevox_is_model_loaded
  export _root_.voicevox.functions.voicevox_load_model
  export _root_.voicevox.functions.voicevox_predict_duration
  export _root_.voicevox.functions.voicevox_predict_duration_data_free
  export _root_.voicevox.functions.voicevox_predict_intonation
  export _root_.voicevox.functions.voicevox_predict_intonation_data_free
  export _root_.voicevox.functions.voicevox_wav_free
  export _root_.voicevox.functions.voicevox_audio_query
  export _root_.voicevox.functions.voicevox_initialize
  export _root_.voicevox.functions.voicevox_make_default_audio_query_options
  export _root_.voicevox.functions.voicevox_make_default_initialize_options
  export _root_.voicevox.functions.voicevox_make_default_synthesis_options
  export _root_.voicevox.functions.voicevox_make_default_tts_options
  export _root_.voicevox.functions.voicevox_synthesis
  export _root_.voicevox.functions.voicevox_tts
