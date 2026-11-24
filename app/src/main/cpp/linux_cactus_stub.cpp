#include <jni.h>
extern "C" JNIEXPORT jlong JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeLoad(JNIEnv*, jobject, jstring){return 0;}
extern "C" JNIEXPORT jstring JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeComplete(JNIEnv* e,jobject,jlong,jstring,jstring){return e->NewStringUTF("{\"function_calls\":[]}");}
extern "C" JNIEXPORT void JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeFree(JNIEnv*,jobject,jlong){}
