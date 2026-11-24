package defpackage;

import android.hardware.camera2.TotalCaptureResult;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rr implements nr {
    public final kq a;
    public final Executor b;
    public final ScheduledExecutorService c;
    public final qy0 d;
    public final wj1 e;

    public rr(kq kqVar, ch2 ch2Var, xv0 xv0Var, wj1 wj1Var) {
        this.a = kqVar;
        this.b = ch2Var;
        this.c = xv0Var;
        this.e = wj1Var;
        qy0 qy0Var = kqVar.q;
        Objects.requireNonNull(qy0Var);
        this.d = qy0Var;
    }

    @Override // defpackage.nr
    public final boolean a() {
        return false;
    }

    @Override // defpackage.nr
    public final wc1 b(TotalCaptureResult totalCaptureResult) {
        int i = 3;
        xq4.c(3, "Camera2CapturePipeline");
        AtomicReference atomicReference = new AtomicReference();
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        int i2 = 0;
        try {
            atomicReference.set(new pr(0, tpVar));
            tpVar.a = "OnScreenFlashUiApplied";
        } catch (Exception e) {
            wpVar.b(e);
        }
        tp tpVar2 = new tp();
        tpVar2.c = new o62();
        wp wpVar2 = new wp(tpVar2);
        tpVar2.b = wpVar2;
        tpVar2.a = cq.class;
        int i3 = 2;
        try {
            xg4.c().execute(new dc(this, atomicReference, tpVar2, 2));
            tpVar2.a = "OnScreenFlashStart";
        } catch (Exception e2) {
            wpVar2.b(e2);
        }
        jr0 jr0VarB = jr0.b(wpVar2);
        qr qrVar = new qr(this, i2);
        Executor executor = this.b;
        int i4 = 1;
        xw xwVarG = oz3.g(oz3.g(oz3.g(oz3.g(oz3.g(jr0VarB, qrVar, executor), new qr(this, i4), executor), new qq(i4, this, wpVar), executor), new qr(this, i3), executor), new qr(this, i), executor);
        og ogVar = new og(13);
        return oz3.g(xwVarG, new q82(ogVar), xg4.a());
    }

    @Override // defpackage.nr
    public final void c() {
        kq kqVar = this.a;
        zn0 zn0Var = kqVar.h;
        xq4.c(3, "Camera2CapturePipeline");
        if (this.e.q()) {
            kqVar.l(false);
        }
        zn0Var.b(false).a(new c7(1), this.b);
        zn0Var.a(false, true);
        xv0 xv0VarC = xg4.c();
        qy0 qy0Var = this.d;
        Objects.requireNonNull(qy0Var);
        xv0VarC.execute(new s7(8, qy0Var));
    }
}
