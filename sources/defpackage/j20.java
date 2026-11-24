package defpackage;

import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j20 implements ScrollCaptureCallback {
    public final gg2 a;
    public final i21 b;
    public final py0 c;
    public final r7 d;
    public final w50 e;
    public final rw0 f;

    public j20(gg2 gg2Var, i21 i21Var, w50 w50Var, py0 py0Var, r7 r7Var) {
        this.a = gg2Var;
        this.b = i21Var;
        this.c = py0Var;
        this.d = r7Var;
        this.e = new w50(w50Var.a.r(fd0.b));
        this.f = new rw0(i21Var.d - i21Var.b, new i20(this, null));
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        if (r10 == r6) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(defpackage.j20 r12, android.view.ScrollCaptureSession r13, defpackage.i21 r14, defpackage.y50 r15) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j20.a(j20, android.view.ScrollCaptureSession, i21, y50):java.lang.Object");
    }

    public final void onScrollCaptureEnd(Runnable runnable) {
        uf4.b(this.e, io1.b, new p0(this, runnable, null, 11), 2);
    }

    public final void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer consumer) {
        yq2 yq2VarB = uf4.b(this.e, null, new aa(this, scrollCaptureSession, rect, consumer, null, 2), 3);
        yq2VarB.C(new h6(8, cancellationSignal));
        cancellationSignal.setOnCancelListener(new k20(0, yq2VarB));
    }

    public final void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer consumer) {
        consumer.accept(py3.a(this.b));
    }

    public final void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.f.b = 0.0f;
        ((ku1) this.c.b).setValue(Boolean.TRUE);
        runnable.run();
    }
}
