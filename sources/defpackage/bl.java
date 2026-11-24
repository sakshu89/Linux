package defpackage;

import android.os.Trace;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bl implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Serializable c;
    public final /* synthetic */ Serializable e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object i;

    public /* synthetic */ bl(Object obj, Serializable serializable, Serializable serializable2, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = serializable;
        this.e = serializable2;
        this.f = obj2;
        this.i = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        lm1 lm1VarC;
        int i = this.a;
        Object obj = this.i;
        Object obj2 = this.f;
        Serializable serializable = this.e;
        Serializable serializable2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                yz2 yz2Var = (yz2) obj3;
                z61 z61Var = (z61) serializable2;
                String str = (String) serializable;
                jc0 jc0Var = (jc0) obj2;
                qo0 qo0Var = (qo0) obj;
                Trace.beginSection("BackgroundTextMeasurement");
                try {
                    bm2 bm2VarJ = im2.j();
                    lm1 lm1Var = bm2VarJ instanceof lm1 ? (lm1) bm2VarJ : null;
                    if (lm1Var == null || (lm1VarC = lm1Var.C(null, null)) == null) {
                        throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
                    }
                    try {
                        bm2 bm2VarJ2 = lm1VarC.j();
                        try {
                            yz2 yz2VarB = lc4.b(yz2Var, z61Var);
                            ii0 ii0Var = ii0.a;
                            new ma(str, yz2VarB, ii0Var, ii0Var, qo0Var, jc0Var).c();
                            bm2.q(bm2VarJ2);
                            lm1VarC.w().a();
                            lm1VarC.c();
                            Trace.endSection();
                            return;
                        } catch (Throwable th) {
                            bm2.q(bm2VarJ2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            lm1VarC.c();
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    Trace.endSection();
                    throw th4;
                }
            default:
                on2.w((AtomicBoolean) serializable2, (t42) serializable, (pn2) obj2, (j12) obj, (z83) obj3);
                return;
        }
    }
}
