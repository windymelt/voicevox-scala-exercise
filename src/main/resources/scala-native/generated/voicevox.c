#include <string.h>
#include "voicevox_core.h"

VoicevoxResultCode __sn_wrap_voicevox_voicevox_audio_query(const char * text, uint32_t speaker_id, struct VoicevoxAudioQueryOptions *options, char ** output_audio_query_json) {
 return voicevox_audio_query(text, speaker_id, *options, output_audio_query_json);
};


VoicevoxResultCode __sn_wrap_voicevox_voicevox_initialize(struct VoicevoxInitializeOptions *options) {
 return voicevox_initialize(*options);
};


void __sn_wrap_voicevox_voicevox_make_default_audio_query_options(VoicevoxAudioQueryOptions *____return) {
  VoicevoxAudioQueryOptions ____ret = voicevox_make_default_audio_query_options();
  memcpy(____return, &____ret, sizeof(VoicevoxAudioQueryOptions));
}


void __sn_wrap_voicevox_voicevox_make_default_initialize_options(VoicevoxInitializeOptions *____return) {
  VoicevoxInitializeOptions ____ret = voicevox_make_default_initialize_options();
  memcpy(____return, &____ret, sizeof(VoicevoxInitializeOptions));
}


void __sn_wrap_voicevox_voicevox_make_default_synthesis_options(VoicevoxSynthesisOptions *____return) {
  VoicevoxSynthesisOptions ____ret = voicevox_make_default_synthesis_options();
  memcpy(____return, &____ret, sizeof(VoicevoxSynthesisOptions));
}


void __sn_wrap_voicevox_voicevox_make_default_tts_options(VoicevoxTtsOptions *____return) {
  VoicevoxTtsOptions ____ret = voicevox_make_default_tts_options();
  memcpy(____return, &____ret, sizeof(VoicevoxTtsOptions));
}


VoicevoxResultCode __sn_wrap_voicevox_voicevox_synthesis(const char * audio_query_json, uint32_t speaker_id, struct VoicevoxSynthesisOptions *options, uintptr_t * output_wav_length, uint8_t ** output_wav) {
 return voicevox_synthesis(audio_query_json, speaker_id, *options, output_wav_length, output_wav);
};


VoicevoxResultCode __sn_wrap_voicevox_voicevox_tts(const char * text, uint32_t speaker_id, struct VoicevoxTtsOptions *options, uintptr_t * output_wav_length, uint8_t ** output_wav) {
 return voicevox_tts(text, speaker_id, *options, output_wav_length, output_wav);
};


