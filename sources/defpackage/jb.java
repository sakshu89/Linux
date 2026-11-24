package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jb implements md3, ms4 {
    public boolean a;
    public Object b;

    public jb(boolean z) {
        this.b = Collections.synchronizedList(new ArrayList());
        this.a = z;
    }

    @Override // defpackage.md3
    public float b() {
        return ((Float) ((Range) this.b).getUpper()).floatValue();
    }

    public CameraCaptureSession.CaptureCallback c(CameraCaptureSession.CaptureCallback captureCallback) {
        if (!this.a) {
            return captureCallback;
        }
        iq iqVar = new iq(3);
        wc1 wc1Var = (wc1) iqVar.b;
        ((List) this.b).add(wc1Var);
        wc1Var.a(new dc(this, iqVar, wc1Var, 10), xg4.a());
        return new cr(Arrays.asList(iqVar, captureCallback));
    }

    public wc1 d() {
        List list = (List) this.b;
        if (list.isEmpty()) {
            return mz0.c;
        }
        uc1 uc1Var = new uc1(new ArrayList(new ArrayList(list)), false, xg4.a());
        dk0 dk0Var = new dk0(19);
        return oz3.e(oz3.g(uc1Var, new q82(dk0Var), xg4.a()));
    }

    @Override // defpackage.md3
    public void e(yr yrVar) {
        yrVar.f(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(1.0f));
        if (!this.a || Build.VERSION.SDK_INT < 34) {
            return;
        }
        yrVar.f(CaptureRequest.CONTROL_SETTINGS_OVERRIDE, 1);
    }

    @Override // defpackage.md3
    public float f() {
        return ((Float) ((Range) this.b).getLower()).floatValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object h(long j, long j2, y50 y50Var) {
        vd2 vd2Var;
        long jD;
        if (y50Var instanceof vd2) {
            vd2Var = (vd2) y50Var;
            int i = vd2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                vd2Var.j = i - Integer.MIN_VALUE;
            } else {
                vd2Var = new vd2(this, y50Var);
            }
        } else {
            vd2Var = new vd2(this, y50Var);
        }
        Object objA = vd2Var.f;
        int i2 = vd2Var.j;
        if (i2 == 0) {
            bz3.g(objA);
            jD = 0;
            if (this.a) {
                he2 he2Var = (he2) this.b;
                if (!he2Var.i) {
                    vd2Var.e = j2;
                    vd2Var.j = 1;
                    objA = he2Var.a(j2, vd2Var);
                    t70 t70Var = t70.a;
                    if (objA == t70Var) {
                        return t70Var;
                    }
                }
                jD = x63.d(j2, jD);
            }
            return new x63(jD);
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        j2 = vd2Var.e;
        bz3.g(objA);
        jD = ((x63) objA).a;
        jD = x63.d(j2, jD);
        return new x63(jD);
    }

    public void i() {
        LinkedList linkedList = new LinkedList((List) this.b);
        while (!linkedList.isEmpty()) {
            wc1 wc1Var = (wc1) linkedList.poll();
            Objects.requireNonNull(wc1Var);
            wc1Var.cancel(true);
        }
    }

    @Override // defpackage.ms4
    public t9 zza() {
        lj1 lj1Var = new lj1(8);
        hn4 hn4Var = this.a ? hn4.TYPE_THICK : hn4.TYPE_THIN;
        in4 in4Var = (in4) this.b;
        lj1Var.d = hn4Var;
        wj1 wj1Var = new wj1(26, false);
        wj1Var.b = in4Var;
        lj1Var.f = new pq4(wj1Var);
        return new t9(lj1Var, 0);
    }

    public /* synthetic */ jb(boolean z, Enum r2) {
        this.a = z;
        this.b = r2;
    }

    public /* synthetic */ jb(Object obj, boolean z) {
        this.b = obj;
        this.a = z;
    }

    @Override // defpackage.md3
    public void g() {
    }

    @Override // defpackage.md3
    public void a(TotalCaptureResult totalCaptureResult) {
    }
}
