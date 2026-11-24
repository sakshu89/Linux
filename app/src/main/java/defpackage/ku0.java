package defpackage;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.widget.EdgeEffect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ku0 extends zb0 implements qf0 {
    public final /* synthetic */ int X = 1;
    public final f9 Y;
    public final xg0 Z;
    public Object c0;

    public ku0(tu2 tu2Var, f9 f9Var, xg0 xg0Var, qt1 qt1Var) {
        this.Y = f9Var;
        this.Z = xg0Var;
        this.c0 = qt1Var;
        I0(tu2Var);
    }

    public static boolean L0(float f, EdgeEffect edgeEffect, Canvas canvas) {
        if (f == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(f);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    public static boolean M0(float f, long j, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(f);
        canvas.translate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        boolean zM0;
        long j;
        char c;
        boolean z;
        boolean zL0;
        int i = this.X;
        f9 f9Var = this.Y;
        xg0 xg0Var = this.Z;
        switch (i) {
            case 0:
                qt1 qt1Var = (qt1) this.c0;
                ew ewVar = p71Var.a;
                f9Var.i(ewVar.c());
                if (xk2.c(ewVar.c())) {
                    p71Var.a();
                    return;
                }
                p71Var.a();
                f9Var.d.getValue();
                Canvas canvasA = v6.a(ewVar.b.m());
                boolean zF = xg0.f(xg0Var.f);
                z61 z61Var = z61.a;
                if (zF) {
                    EdgeEffect edgeEffectC = xg0Var.c();
                    float f = -Float.intBitsToFloat((int) (ewVar.c() & 4294967295L));
                    zM0 = M0(270.0f, (((long) Float.floatToRawIntBits(p71Var.x(p71Var.getLayoutDirection() == z61Var ? qt1Var.a : qt1Var.c))) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32), edgeEffectC, canvasA);
                } else {
                    zM0 = false;
                }
                if (xg0.f(xg0Var.d)) {
                    EdgeEffect edgeEffectE = xg0Var.e();
                    zM0 = M0(0.0f, (((long) Float.floatToRawIntBits(p71Var.x(qt1Var.b))) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32), edgeEffectE, canvasA) || zM0;
                }
                if (xg0.f(xg0Var.g)) {
                    EdgeEffect edgeEffectD = xg0Var.d();
                    zM0 = M0(90.0f, (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(p71Var.x(p71Var.getLayoutDirection() == z61Var ? qt1Var.c : qt1Var.a) + (-((float) hh1.f(Float.intBitsToFloat((int) (ewVar.c() >> 32))))))) & 4294967295L), edgeEffectD, canvasA) || zM0;
                }
                if (xg0.f(xg0Var.e)) {
                    EdgeEffect edgeEffectB = xg0Var.b();
                    float fX = p71Var.x(qt1Var.d);
                    zM0 = M0(180.0f, (((long) Float.floatToRawIntBits(-Float.intBitsToFloat((int) (ewVar.c() >> 32)))) << 32) | (((long) Float.floatToRawIntBits((-Float.intBitsToFloat((int) (ewVar.c() & 4294967295L))) + fX)) & 4294967295L), edgeEffectB, canvasA) || zM0;
                }
                if (zM0) {
                    f9Var.d();
                    return;
                }
                return;
            default:
                ew ewVar2 = p71Var.a;
                f9Var.i(ewVar2.c());
                Canvas canvasA2 = v6.a(ewVar2.b.m());
                f9Var.d.getValue();
                if (xk2.c(ewVar2.c())) {
                    p71Var.a();
                    return;
                }
                if (!canvasA2.isHardwareAccelerated()) {
                    EdgeEffect edgeEffect = xg0Var.d;
                    if (edgeEffect != null) {
                        edgeEffect.finish();
                    }
                    EdgeEffect edgeEffect2 = xg0Var.e;
                    if (edgeEffect2 != null) {
                        edgeEffect2.finish();
                    }
                    EdgeEffect edgeEffect3 = xg0Var.f;
                    if (edgeEffect3 != null) {
                        edgeEffect3.finish();
                    }
                    EdgeEffect edgeEffect4 = xg0Var.g;
                    if (edgeEffect4 != null) {
                        edgeEffect4.finish();
                    }
                    EdgeEffect edgeEffect5 = xg0Var.h;
                    if (edgeEffect5 != null) {
                        edgeEffect5.finish();
                    }
                    EdgeEffect edgeEffect6 = xg0Var.i;
                    if (edgeEffect6 != null) {
                        edgeEffect6.finish();
                    }
                    EdgeEffect edgeEffect7 = xg0Var.j;
                    if (edgeEffect7 != null) {
                        edgeEffect7.finish();
                    }
                    EdgeEffect edgeEffect8 = xg0Var.k;
                    if (edgeEffect8 != null) {
                        edgeEffect8.finish();
                    }
                    p71Var.a();
                    return;
                }
                float fX2 = p71Var.x(30.0f);
                boolean z2 = xg0.f(xg0Var.d) || xg0.g(xg0Var.h) || xg0.f(xg0Var.e) || xg0.g(xg0Var.i);
                boolean z3 = xg0.f(xg0Var.f) || xg0.g(xg0Var.j) || xg0.f(xg0Var.g) || xg0.g(xg0Var.k);
                if (z2 && z3) {
                    j = 4294967295L;
                    c = ' ';
                    N0().setPosition(0, 0, canvasA2.getWidth(), canvasA2.getHeight());
                } else {
                    j = 4294967295L;
                    c = ' ';
                    if (z2) {
                        N0().setPosition(0, 0, (hh1.f(fX2) * 2) + canvasA2.getWidth(), canvasA2.getHeight());
                    } else {
                        if (!z3) {
                            p71Var.a();
                            return;
                        }
                        N0().setPosition(0, 0, canvasA2.getWidth(), (hh1.f(fX2) * 2) + canvasA2.getHeight());
                    }
                }
                RecordingCanvas recordingCanvasBeginRecording = N0().beginRecording();
                boolean zG = xg0.g(xg0Var.j);
                js1 js1Var = js1.b;
                if (zG) {
                    EdgeEffect edgeEffectA = xg0Var.j;
                    if (edgeEffectA == null) {
                        edgeEffectA = xg0Var.a(js1Var);
                        xg0Var.j = edgeEffectA;
                    }
                    L0(90.0f, edgeEffectA, recordingCanvasBeginRecording);
                    edgeEffectA.finish();
                }
                if (xg0.f(xg0Var.f)) {
                    EdgeEffect edgeEffectC2 = xg0Var.c();
                    zL0 = L0(270.0f, edgeEffectC2, recordingCanvasBeginRecording);
                    if (xg0.g(xg0Var.f)) {
                        z = z3;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (f9Var.c() & j));
                        EdgeEffect edgeEffectA2 = xg0Var.j;
                        if (edgeEffectA2 == null) {
                            edgeEffectA2 = xg0Var.a(js1Var);
                            xg0Var.j = edgeEffectA2;
                        }
                        int i2 = Build.VERSION.SDK_INT;
                        float fC = i2 >= 31 ? le.c(edgeEffectC2) : 0.0f;
                        float f2 = 1.0f - fIntBitsToFloat;
                        if (i2 >= 31) {
                            le.d(edgeEffectA2, fC, f2);
                        } else {
                            edgeEffectA2.onPull(fC, f2);
                        }
                    } else {
                        z = z3;
                    }
                } else {
                    z = z3;
                    zL0 = false;
                }
                boolean zG2 = xg0.g(xg0Var.h);
                js1 js1Var2 = js1.a;
                if (zG2) {
                    EdgeEffect edgeEffectA3 = xg0Var.h;
                    if (edgeEffectA3 == null) {
                        edgeEffectA3 = xg0Var.a(js1Var2);
                        xg0Var.h = edgeEffectA3;
                    }
                    L0(180.0f, edgeEffectA3, recordingCanvasBeginRecording);
                    edgeEffectA3.finish();
                }
                if (xg0.f(xg0Var.d)) {
                    EdgeEffect edgeEffectE2 = xg0Var.e();
                    zL0 = L0(0.0f, edgeEffectE2, recordingCanvasBeginRecording) || zL0;
                    if (xg0.g(xg0Var.d)) {
                        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (f9Var.c() >> c));
                        EdgeEffect edgeEffectA4 = xg0Var.h;
                        if (edgeEffectA4 == null) {
                            edgeEffectA4 = xg0Var.a(js1Var2);
                            xg0Var.h = edgeEffectA4;
                        }
                        int i3 = Build.VERSION.SDK_INT;
                        float fC2 = i3 >= 31 ? le.c(edgeEffectE2) : 0.0f;
                        if (i3 >= 31) {
                            le.d(edgeEffectA4, fC2, fIntBitsToFloat2);
                        } else {
                            edgeEffectA4.onPull(fC2, fIntBitsToFloat2);
                        }
                    }
                }
                if (xg0.g(xg0Var.k)) {
                    EdgeEffect edgeEffectA5 = xg0Var.k;
                    if (edgeEffectA5 == null) {
                        edgeEffectA5 = xg0Var.a(js1Var);
                        xg0Var.k = edgeEffectA5;
                    }
                    L0(270.0f, edgeEffectA5, recordingCanvasBeginRecording);
                    edgeEffectA5.finish();
                }
                if (xg0.f(xg0Var.g)) {
                    EdgeEffect edgeEffectD2 = xg0Var.d();
                    zL0 = L0(90.0f, edgeEffectD2, recordingCanvasBeginRecording) || zL0;
                    if (xg0.g(xg0Var.g)) {
                        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (f9Var.c() & j));
                        EdgeEffect edgeEffectA6 = xg0Var.k;
                        if (edgeEffectA6 == null) {
                            edgeEffectA6 = xg0Var.a(js1Var);
                            xg0Var.k = edgeEffectA6;
                        }
                        int i4 = Build.VERSION.SDK_INT;
                        float fC3 = i4 >= 31 ? le.c(edgeEffectD2) : 0.0f;
                        if (i4 >= 31) {
                            le.d(edgeEffectA6, fC3, fIntBitsToFloat3);
                        } else {
                            edgeEffectA6.onPull(fC3, fIntBitsToFloat3);
                        }
                    }
                }
                if (xg0.g(xg0Var.i)) {
                    EdgeEffect edgeEffectA7 = xg0Var.i;
                    if (edgeEffectA7 == null) {
                        edgeEffectA7 = xg0Var.a(js1Var2);
                        xg0Var.i = edgeEffectA7;
                    }
                    L0(0.0f, edgeEffectA7, recordingCanvasBeginRecording);
                    edgeEffectA7.finish();
                }
                if (xg0.f(xg0Var.e)) {
                    EdgeEffect edgeEffectB2 = xg0Var.b();
                    boolean z4 = L0(180.0f, edgeEffectB2, recordingCanvasBeginRecording) || zL0;
                    if (xg0.g(xg0Var.e)) {
                        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (f9Var.c() >> c));
                        EdgeEffect edgeEffectA8 = xg0Var.i;
                        if (edgeEffectA8 == null) {
                            edgeEffectA8 = xg0Var.a(js1Var2);
                            xg0Var.i = edgeEffectA8;
                        }
                        int i5 = Build.VERSION.SDK_INT;
                        float fC4 = i5 >= 31 ? le.c(edgeEffectB2) : 0.0f;
                        float f3 = 1.0f - fIntBitsToFloat4;
                        if (i5 >= 31) {
                            le.d(edgeEffectA8, fC4, f3);
                        } else {
                            edgeEffectA8.onPull(fC4, f3);
                        }
                    }
                    zL0 = z4;
                }
                if (zL0) {
                    f9Var.d();
                }
                float f4 = z ? 0.0f : fX2;
                float f5 = z2 ? 0.0f : fX2;
                z61 layoutDirection = p71Var.getLayoutDirection();
                u6 u6Var = new u6();
                u6Var.a = recordingCanvasBeginRecording;
                long jC = ewVar2.c();
                kf kfVar = ewVar2.b;
                dw dwVar = ((ew) kfVar.e).a;
                jc0 jc0Var = dwVar.a;
                z61 z61Var2 = dwVar.b;
                cw cwVarM = kfVar.m();
                long jR = ewVar2.b.r();
                kf kfVar2 = ewVar2.b;
                vu0 vu0Var = (vu0) kfVar2.c;
                kfVar2.E(p71Var);
                kfVar2.F(layoutDirection);
                kfVar2.D(u6Var);
                kfVar2.G(jC);
                kfVar2.c = null;
                u6Var.m();
                try {
                    ((q82) ewVar2.b.b).J(f4, f5);
                    try {
                        p71Var.a();
                        float f6 = -f4;
                        float f7 = -f5;
                        ((q82) ewVar2.b.b).J(f6, f7);
                        u6Var.j();
                        kf kfVar3 = ewVar2.b;
                        kfVar3.E(jc0Var);
                        kfVar3.F(z61Var2);
                        kfVar3.D(cwVarM);
                        kfVar3.G(jR);
                        kfVar3.c = vu0Var;
                        N0().endRecording();
                        int iSave = canvasA2.save();
                        canvasA2.translate(f6, f7);
                        canvasA2.drawRenderNode(N0());
                        canvasA2.restoreToCount(iSave);
                        return;
                    } catch (Throwable th) {
                        ((q82) ewVar2.b.b).J(-f4, -f5);
                        throw th;
                    }
                } catch (Throwable th2) {
                    u6Var.j();
                    kf kfVar4 = ewVar2.b;
                    kfVar4.E(jc0Var);
                    kfVar4.F(z61Var2);
                    kfVar4.D(cwVarM);
                    kfVar4.G(jR);
                    kfVar4.c = vu0Var;
                    throw th2;
                }
        }
    }

    public RenderNode N0() {
        RenderNode renderNode = (RenderNode) this.c0;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNodeF = bv0.f();
        this.c0 = renderNodeF;
        return renderNodeF;
    }

    public ku0(tu2 tu2Var, f9 f9Var, xg0 xg0Var) {
        this.Y = f9Var;
        this.Z = xg0Var;
        I0(tu2Var);
    }
}
