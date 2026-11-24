#include <jni.h>
extern "C" JNIEXPORT jlong JNICALL Java_com_project_sonic_linux_runtime_LlamaRuntime_nativeLoad(JNIEnv*, jobject, jstring){return 0;}
extern "C" JNIEXPORT jstring JNICALL Java_com_project_sonic_linux_runtime_LlamaRuntime_nativeComplete(JNIEnv* e,jobject,jlong,jstring){return e->NewStringUTF("LLAMA runtime unavailable in this build");}
extern "C" JNIEXPORT void JNICALL Java_com_project_sonic_linux_runtime_LlamaRuntime_nativeFree(JNIEnv*,jobject,jlong){}
