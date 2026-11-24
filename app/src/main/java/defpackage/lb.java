package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lb extends dk1 implements h30, qf0, w61 {
    public final boolean H;
    public final float X;
    public final q82 Y;
    public final bc0 Z;
    public ux c0;
    public float d0;
    public boolean f0;
    public g82 h0;
    public h82 i0;
    public final ol1 x;
    public long e0 = 0;
    public final yl1 g0 = new yl1();

    public lb(ol1 ol1Var, boolean z, float f, q82 q82Var, bc0 bc0Var) {
        this.x = ol1Var;
        this.H = z;
        this.X = f;
        this.Y = q82Var;
        this.Z = bc0Var;
    }

    @Override // defpackage.dk1
    public final void A0() {
        uf4.b(w0(), null, new p0(this, null, 27), 3);
    }

    @Override // defpackage.dk1
    public final void B0() {
        g82 g82Var = this.h0;
        if (g82Var != null) {
            this.i0 = null;
            vm4.a(this);
            q91 q91Var = g82Var.e;
            h82 h82Var = (h82) ((LinkedHashMap) q91Var.b).get(this);
            if (h82Var != null) {
                h82Var.c();
                LinkedHashMap linkedHashMap = (LinkedHashMap) q91Var.b;
                h82 h82Var2 = (h82) linkedHashMap.get(this);
                if (h82Var2 != null) {
                }
                linkedHashMap.remove(this);
                g82Var.c.add(h82Var);
            }
        }
    }

    public final void I0(d02 d02Var) {
        h82 h82Var;
        if (!(d02Var instanceof b02)) {
            if (d02Var instanceof c02) {
                h82 h82Var2 = this.i0;
                if (h82Var2 != null) {
                    h82Var2.d();
                    return;
                }
                return;
            }
            if (!(d02Var instanceof a02) || (h82Var = this.i0) == null) {
                return;
            }
            h82Var.d();
            return;
        }
        b02 b02Var = (b02) d02Var;
        long j = this.e0;
        float f = this.d0;
        g82 g82Var = this.h0;
        int i = 0;
        if (g82Var == null) {
            Object obj = (View) ij4.a(this, AndroidCompositionLocals_androidKt.f);
            while (!(obj instanceof ViewGroup)) {
                ViewParent parent = ((View) obj).getParent();
                if (!(parent instanceof View)) {
                    dk0.s("Couldn't find a valid parent for ", obj, ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?");
                    return;
                }
                obj = parent;
            }
            ViewGroup viewGroup = (ViewGroup) obj;
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    g82 g82Var2 = new g82(viewGroup.getContext());
                    viewGroup.addView(g82Var2);
                    g82Var = g82Var2;
                    break;
                } else {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof g82) {
                        g82Var = (g82) childAt;
                        break;
                    }
                    i2++;
                }
            }
            this.h0 = g82Var;
        }
        ArrayList arrayList = g82Var.b;
        q91 q91Var = g82Var.e;
        LinkedHashMap linkedHashMap = (LinkedHashMap) q91Var.b;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) q91Var.b;
        LinkedHashMap linkedHashMap3 = (LinkedHashMap) q91Var.c;
        h82 h82Var3 = (h82) linkedHashMap.get(this);
        if (h82Var3 == null) {
            ArrayList arrayList2 = g82Var.c;
            arrayList2.getClass();
            h82Var3 = (h82) (arrayList2.isEmpty() ? null : arrayList2.remove(0));
            if (h82Var3 == null) {
                if (g82Var.f > nz.g(arrayList)) {
                    h82Var3 = new h82(g82Var.getContext());
                    g82Var.addView(h82Var3);
                    arrayList.add(h82Var3);
                } else {
                    h82Var3 = (h82) arrayList.get(g82Var.f);
                    lb lbVar = (lb) linkedHashMap3.get(h82Var3);
                    if (lbVar != null) {
                        lbVar.i0 = null;
                        vm4.a(lbVar);
                        h82 h82Var4 = (h82) linkedHashMap2.get(lbVar);
                        if (h82Var4 != null) {
                        }
                        linkedHashMap2.remove(lbVar);
                        h82Var3.c();
                    }
                }
                int i3 = g82Var.f;
                if (i3 < g82Var.a - 1) {
                    g82Var.f = i3 + 1;
                } else {
                    g82Var.f = 0;
                }
            }
            linkedHashMap2.put(this, h82Var3);
            linkedHashMap3.put(h82Var3, this);
        }
        int iF = hh1.f(f);
        long jL = this.Y.l();
        this.Z.a();
        h82 h82Var5 = h82Var3;
        h82Var5.b(b02Var, this.H, j, iF, jL, new kb(i, this));
        this.i0 = h82Var5;
        vm4.a(this);
    }

    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        ew ewVar = p71Var.a;
        p71Var.a();
        ux uxVar = this.c0;
        if (uxVar != null) {
            float f = this.d0;
            long jL = this.Y.l();
            float fFloatValue = ((Number) ((bd) uxVar.c).d()).floatValue();
            if (fFloatValue > 0.0f) {
                long jB = sz.b(fFloatValue, jL);
                if (uxVar.a) {
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (ewVar.c() >> 32));
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (ewVar.c() & 4294967295L));
                    kf kfVar = ewVar.b;
                    long jR = kfVar.r();
                    kfVar.m().m();
                    try {
                        ((kf) ((q82) kfVar.b).a).m().f(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2, 1);
                        rf0.P(p71Var, jB, f, 0L, 0.0f, 124);
                        cq.t(kfVar, jR);
                    } catch (Throwable th) {
                        cq.t(kfVar, jR);
                        throw th;
                    }
                } else {
                    rf0.P(p71Var, jB, f, 0L, 0.0f, 124);
                }
            }
        }
        cw cwVarM = ewVar.b.m();
        h82 h82Var = this.i0;
        if (h82Var != null) {
            long j = this.e0;
            int iF = hh1.f(this.d0);
            long jL2 = this.Y.l();
            this.Z.a();
            h82Var.e(iF, j, jL2);
            h82Var.draw(v6.a(cwVarM));
        }
    }

    @Override // defpackage.w61
    public final void r(long j) {
        float fX;
        this.f0 = true;
        jc0 jc0Var = cm4.g(this).h0;
        this.e0 = cp4.a(j);
        float f = this.X;
        if (Float.isNaN(f)) {
            long j2 = this.e0;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            fX = jp1.c((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)) / 2.0f;
            if (this.H) {
                fX += jc0Var.x(10.0f);
            }
        } else {
            fX = jc0Var.x(f);
        }
        this.d0 = fX;
        yl1 yl1Var = this.g0;
        Object[] objArr = yl1Var.a;
        int i = yl1Var.b;
        for (int i2 = 0; i2 < i; i2++) {
            I0((d02) objArr[i2]);
        }
        yl1Var.d();
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
