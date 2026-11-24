#include <jni.h>
#include <fstream>
#include <iterator>
#include <string>
#include <vector>
#include "cactus.h"

static std::string jstr(JNIEnv* e,jstring s){const char*p=e->GetStringUTFChars(s,nullptr);std::string o=p?p:"";if(p)e->ReleaseStringUTFChars(s,p);return o;}
static jstring js(JNIEnv*e,const char*s){return e->NewStringUTF(s?s:"");}

// Cactus 4 exposes a process-wide engine: load the .cact weights, then initialise once.
extern "C" JNIEXPORT jlong JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeLoad(JNIEnv*e,jobject,jstring path){
    std::ifstream f(jstr(e,path),std::ios::binary);
    if(!f) return 0;
    std::vector<unsigned char> data((std::istreambuf_iterator<char>(f)),std::istreambuf_iterator<char>());
    if(data.empty()) return 0;
    if(cactus_load(data.data(),static_cast<unsigned long long>(data.size()))<0) return 0;
    if(cactus_init("","",nullptr)<0) return 0;
    return 1;
}

extern "C" JNIEXPORT jstring JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeComplete(JNIEnv*e,jobject,jlong hp,jstring messages,jstring tools){
    (void)tools;
    if(!hp) return js(e,"{\"function_calls\":[],\"error\":\"needle runtime not loaded\"}");
    std::string input=jstr(e,messages);
    std::vector<char> out(65536);
    int rc=cactus_complete(input.c_str(),nullptr,0,512,out.data(),static_cast<int>(out.size()));
    if(rc<0) return js(e,"{\"function_calls\":[],\"error\":\"needle completion failed\"}");
    return js(e,out.data());
}

extern "C" JNIEXPORT void JNICALL Java_com_project_sonic_linux_runtime_NeedleRuntime_nativeFree(JNIEnv*,jobject,jlong hp){
    if(hp) cactus_reset();
}
