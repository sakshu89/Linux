package defpackage;

import android.hardware.camera2.TotalCaptureResult;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mr {
    public final int a;
    public final Executor b;
    public final ScheduledExecutorService c;
    public final kq d;
    public final ph e;
    public final boolean f;
    public long g = 1000000000;
    public final ArrayList h = new ArrayList();
    public final kr i = new kr(this);

    public mr(int i, ch2 ch2Var, xv0 xv0Var, kq kqVar, boolean z, ph phVar) {
        this.a = i;
        this.b = ch2Var;
        this.c = xv0Var;
        this.d = kqVar;
        this.f = z;
        this.e = phVar;
    }

    public final wc1 a(final int i) {
        boolean zIsEmpty = this.h.isEmpty();
        wc1 wc1Var = mz0.c;
        if (zIsEmpty) {
            return wc1Var;
        }
        if (this.i.a()) {
            or orVar = new or(null);
            kq kqVar = this.d;
            kqVar.j(orVar);
            o8 o8Var = new o8(9, kqVar, orVar);
            ch2 ch2Var = kqVar.c;
            wp wpVar = orVar.b;
            wpVar.b.a(o8Var, ch2Var);
            wc1Var = wpVar;
        }
        jr0 jr0VarB = jr0.b(wc1Var);
        ch chVar = new ch() { // from class: ir
            @Override // defpackage.ch
            /* JADX INFO: renamed from: apply */
            public final wc1 mo28apply(Object obj) {
                TotalCaptureResult totalCaptureResult = (TotalCaptureResult) obj;
                boolean zG = ur.g(i, totalCaptureResult);
                mr mrVar = this.a;
                if (zG) {
                    mrVar.g = 5000000000L;
                }
                return mrVar.i.b(totalCaptureResult);
            }
        };
        Executor executor = this.b;
        return oz3.g(oz3.g(jr0VarB, chVar, executor), new zq(2, this), executor);
    }
}
