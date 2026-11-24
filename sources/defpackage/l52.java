package defpackage;

import android.os.Looper;
import android.speech.SpeechRecognizer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l52 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    public /* synthetic */ l52(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
        this.f = obj4;
        this.i = obj5;
        this.j = obj6;
    }

    @Override // defpackage.fq0
    public final Object a() {
        boolean z = false;
        boolean z2 = true;
        switch (this.a) {
            case 0:
                x92 x92Var = (x92) this.b;
                qa2 qa2Var = (qa2) this.c;
                ba2 ba2Var = (ba2) this.e;
                String str = (String) this.f;
                Object obj = this.i;
                Object[] objArr = (Object[]) this.j;
                if (x92Var.b != ba2Var) {
                    x92Var.b = ba2Var;
                    z = true;
                }
                if (g31.a(x92Var.c, str)) {
                    z2 = z;
                } else {
                    x92Var.c = str;
                }
                x92Var.a = qa2Var;
                x92Var.e = obj;
                x92Var.f = objArr;
                kf kfVar = x92Var.i;
                if (kfVar != null && z2) {
                    kfVar.I();
                    x92Var.i = null;
                    x92Var.c();
                }
                break;
            case 1:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.b;
                t42 t42Var = (t42) this.c;
                pn2 pn2Var = (pn2) this.e;
                t42 t42Var2 = (t42) this.f;
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) this.i;
                j12 j12Var = (j12) this.j;
                atomicBoolean.set(true);
                Runnable runnable = (Runnable) t42Var.a;
                if (runnable != null) {
                    pn2Var.b.removeCallbacks(runnable);
                }
                dc dcVar = new dc(t42Var2, atomicBoolean2, j12Var, pn2Var);
                if (g31.a(Looper.myLooper(), Looper.getMainLooper())) {
                    dcVar.run();
                } else {
                    pn2Var.b.post(dcVar);
                }
                break;
            default:
                AtomicBoolean atomicBoolean3 = (AtomicBoolean) this.b;
                j12 j12Var2 = (j12) this.c;
                pn2 pn2Var2 = (pn2) this.e;
                SpeechRecognizer speechRecognizer = (SpeechRecognizer) this.f;
                on2.w((AtomicBoolean) this.i, (t42) this.j, pn2Var2, j12Var2, new x83("Microphone stopped."));
                if (atomicBoolean3.compareAndSet(false, true)) {
                    try {
                        speechRecognizer.setRecognitionListener(null);
                        speechRecognizer.cancel();
                        speechRecognizer.destroy();
                        break;
                    } catch (Throwable unused) {
                    }
                }
                if (pn2Var2.c == speechRecognizer) {
                    pn2Var2.c = null;
                    pn2Var2.d = null;
                }
                break;
        }
        return q43.a;
    }
}
