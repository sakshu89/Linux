#include <jni.h>
#include <string>
#include "cactus_engine.h"
static std::string jstr(JNIEnv* e,jstring s){const char*p=e->GetStringUTFChars(s,nullptr);std::string o=p?p:"";if(p)e->ReleaseStringUTFChars(s,p);return o;}
static jstring js(JNIEnv*e,const char*s){return e->NewStringUTF(s?s:"");}
extern "C" JNIEXPORT jlong JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeLoad(JNIEnv*e,jobject,jstring path){auto h=cactus_init(jstr(e,path).c_str(),nullptr,false);return reinterpret_cast<jlong>(h);}
extern "C" JNIEXPORT jstring JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeComplete(JNIEnv*e,jobject,jlong hp,jstring messages,jstring tools){if(!hp)return js(e,"{\"function_calls\":[],\"error\":\"needle runtime not loaded\"}");auto r=cactus_complete(reinterpret_cast<cactus_model_t>(hp),jstr(e,messages).c_str(),nullptr,jstr(e,tools).c_str(),nullptr);return js(e,r?r:"{\"function_calls\":[]}");}
extern "C" JNIEXPORT void JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeFree(JNIEnv*,jobject,jlong hp){if(hp)cactus_destroy(reinterpret_cast<cactus_model_t>(hp));}
