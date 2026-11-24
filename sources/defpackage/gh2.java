package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gh2 extends fh2 {
    public static gh2 d(r53 r53Var, Size size) {
        if (((as) r53Var.d(r53.Q, null)) == null) {
            dk0.x((String) r53Var.d(yv2.M, r53Var.toString()), "Implementation is missing option unpacker for ");
            return null;
        }
        gh2 gh2Var = new gh2();
        kh2 kh2Var = (kh2) r53Var.d(r53.O, null);
        gs1 gs1Var = gs1.c;
        int i = kh2.a().g.c;
        if (kh2Var != null) {
            i = kh2Var.g.c;
            for (CameraDevice.StateCallback stateCallback : kh2Var.c) {
                ArrayList arrayList = gh2Var.c;
                if (!arrayList.contains(stateCallback)) {
                    arrayList.add(stateCallback);
                }
            }
            for (CameraCaptureSession.StateCallback stateCallback2 : kh2Var.d) {
                ArrayList arrayList2 = gh2Var.d;
                if (!arrayList2.contains(stateCallback2)) {
                    arrayList2.add(stateCallback2);
                }
            }
            gh2Var.b.a(kh2Var.g.e);
            gs1Var = kh2Var.g.b;
        }
        ur urVar = gh2Var.b;
        urVar.getClass();
        urVar.e = zl1.o(gs1Var);
        if (r53Var instanceof h02) {
            Rational rational = i02.a;
            if (((PreviewPixelHDRnetQuirk) wc0.a.d(PreviewPixelHDRnetQuirk.class)) != null && !i02.a.equals(new Rational(size.getWidth(), size.getHeight()))) {
                zl1 zl1VarM = zl1.m();
                zl1VarM.v(zr.M(CaptureRequest.TONEMAP_MODE), 2);
                gh2Var.b.c(new zr(gs1.l(zl1VarM)));
            }
        }
        gh2Var.b.a = ((Integer) r53Var.d(zr.i, Integer.valueOf(i))).intValue();
        CameraDevice.StateCallback stateCallback3 = (CameraDevice.StateCallback) r53Var.d(zr.k, new nt());
        ArrayList arrayList3 = gh2Var.c;
        if (!arrayList3.contains(stateCallback3)) {
            arrayList3.add(stateCallback3);
        }
        CameraCaptureSession.StateCallback stateCallback4 = (CameraCaptureSession.StateCallback) r53Var.d(zr.n, new ws());
        ArrayList arrayList4 = gh2Var.d;
        if (!arrayList4.contains(stateCallback4)) {
            arrayList4.add(stateCallback4);
        }
        kw kwVar = new kw((CameraCaptureSession.CaptureCallback) r53Var.d(zr.s, new dr()));
        gh2Var.b.b(kwVar);
        ArrayList arrayList5 = gh2Var.e;
        if (!arrayList5.contains(kwVar)) {
            arrayList5.add(kwVar);
        }
        bi biVar = r53.b0;
        Integer num = (Integer) r53Var.d(biVar, 0);
        int iIntValue = num.intValue();
        if (iIntValue != 0) {
            ur urVar2 = gh2Var.b;
            urVar2.getClass();
            if (iIntValue != 0) {
                ((zl1) urVar2.e).v(biVar, num);
            }
        }
        int iQ = r53Var.q();
        if (iQ != 0) {
            ur urVar3 = gh2Var.b;
            urVar3.getClass();
            if (iQ != 0) {
                ((zl1) urVar3.e).v(r53.a0, Integer.valueOf(iQ));
            }
        }
        zl1 zl1VarM2 = zl1.m();
        bi biVar2 = zr.t;
        zl1VarM2.v(biVar2, (String) r53Var.d(biVar2, null));
        bi biVar3 = zr.j;
        Long l = (Long) r53Var.d(biVar3, -1L);
        l.getClass();
        zl1VarM2.v(biVar3, l);
        gh2Var.b.c(zl1VarM2);
        gh2Var.b.c(yr.e(r53Var).d());
        return gh2Var;
    }

    public final void a(s30 s30Var) {
        this.b.c(s30Var);
    }

    public final void b(ob0 ob0Var, ig0 ig0Var, int i) {
        cj cjVarA = dj.a(ob0Var);
        if (ig0Var == null) {
            dk0.n("Null dynamicRange");
            return;
        }
        cjVarA.a = ig0Var;
        cjVarA.e = Integer.valueOf(i);
        this.a.add(cjVarA.h());
        ((HashSet) this.b.d).add(ob0Var);
    }

    public final kh2 c() {
        return new kh2(new ArrayList(this.a), new ArrayList(this.c), new ArrayList(this.d), new ArrayList(this.e), this.b.d(), this.f, this.g, this.h);
    }
}
