#include <jni.h>
#include <string>
#include <vector>
#include "llama.h"

struct LlamaHandle { llama_model * model; llama_context * ctx; llama_sampler * sampler; const llama_vocab * vocab; };
static std::string jstr(JNIEnv* e, jstring s){ const char* p=e->GetStringUTFChars(s,nullptr); std::string out=p?p:""; if(p)e->ReleaseStringUTFChars(s,p); return out; }
static jstring js(JNIEnv* e,const std::string& s){ return e->NewStringUTF(s.c_str()); }

extern "C" JNIEXPORT jlong JNICALL Java_com_project_sonic_linux_runtime_LlamaRuntime_nativeLoad(JNIEnv* e,jobject,jstring path){
    llama_backend_init();
    auto mp=llama_model_default_params(); mp.n_gpu_layers=0;
    auto *m=llama_model_load_from_file(jstr(e,path).c_str(),mp); if(!m) return 0;
    auto cp=llama_context_default_params(); cp.n_ctx=4096; cp.n_batch=512; cp.n_threads=4; cp.n_threads_batch=4; cp.no_perf=true;
    auto *c=llama_init_from_model(m,cp); if(!c){llama_model_free(m);return 0;}
    auto sp=llama_sampler_chain_default_params(); sp.no_perf=true;
    auto *s=llama_sampler_chain_init(sp); llama_sampler_chain_add(s,llama_sampler_init_greedy());
    auto *h=new LlamaHandle{m,c,s,llama_model_get_vocab(m)}; return reinterpret_cast<jlong>(h);
}

extern "C" JNIEXPORT jstring JNICALL Java_com_project_sonic_linux_runtime_LlamaRuntime_nativeComplete(JNIEnv* e,jobject,jlong hp,jstring prompt){
    auto *h=reinterpret_cast<LlamaHandle*>(hp); if(!h) return js(e,"[linux] model not loaded");
    std::string p=jstr(e,prompt); int n=-llama_tokenize(h->vocab,p.c_str(),(int)p.size(),nullptr,0,true,true); if(n<=0)return js(e,"[linux] tokenization failed");
    std::vector<llama_token> toks(n); if(llama_tokenize(h->vocab,p.c_str(),(int)p.size(),toks.data(),n,true,true)<0)return js(e,"[linux] tokenization failed");
    llama_batch batch=llama_batch_get_one(toks.data(),(int)toks.size()); if(llama_decode(h->ctx,batch)!=0)return js(e,"[linux] decode failed");
    std::string out; for(int i=0;i<512;i++){
        auto id=llama_sampler_sample(h->sampler,h->ctx,-1); if(llama_vocab_is_eog(h->vocab,id)) break;
        char buf[512]; int nb=llama_token_to_piece(h->vocab,id,buf,sizeof(buf),0,true); if(nb>0)out.append(buf,nb);
        llama_sampler_accept(h->sampler,id);
        llama_batch one=llama_batch_get_one(&id,1); if(llama_decode(h->ctx,one)!=0)break;
    }
    return js(e,out);
}
extern "C" JNIEXPORT void JNICALL Java_com_project_sonic_linux_runtime_LlamaRuntime_nativeFree(JNIEnv*,jobject,jlong hp){auto*h=reinterpret_cast<LlamaHandle*>(hp);if(!h)return;llama_sampler_free(h->sampler);llama_free(h->ctx);llama_model_free(h->model);delete h;}
