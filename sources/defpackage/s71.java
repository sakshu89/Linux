package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s71 implements xs2, qh1 {
    public final /* synthetic */ v71 a;
    public final /* synthetic */ b81 b;

    public s71(b81 b81Var) {
        this.b = b81Var;
        this.a = b81Var.k;
    }

    @Override // defpackage.xs2
    public final List F(vq0 vq0Var, Object obj) {
        b81 b81Var = this.b;
        n71 n71Var = b81Var.a;
        gm1 gm1Var = b81Var.j;
        n71 n71Var2 = (n71) gm1Var.g(obj);
        if (n71Var2 != null && ((pm1) ((wl1) n71Var.o()).b).j(n71Var2) < b81Var.e) {
            return n71Var2.m();
        }
        gm1 gm1Var2 = b81Var.u;
        gm1 gm1Var3 = b81Var.s;
        pm1 pm1Var = b81Var.v;
        if (pm1Var.c < b81Var.f) {
            z01.a("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
        }
        n71 n71Var3 = (n71) gm1Var.g(obj);
        int i = pm1Var.c;
        int i2 = b81Var.f;
        if (i == i2) {
            pm1Var.b(obj);
        } else {
            Object[] objArr = pm1Var.a;
            Object obj2 = objArr[i2];
            objArr[i2] = obj;
        }
        b81Var.f++;
        boolean zB = gm1Var3.b(obj);
        if (zB || n71Var3 != null) {
            if (!zB && n71Var3 != null) {
                b81Var.j(((pm1) ((wl1) n71Var.o()).b).j(n71Var3), ((pm1) ((wl1) n71Var.o()).b).c);
                b81Var.x++;
                gm1Var.k(obj);
                gm1Var3.m(obj, n71Var3);
                gm1Var2.m(obj, b81Var.f(obj));
                if (n71Var.H()) {
                    b81Var.h();
                }
            }
            n71 n71Var4 = (n71) gm1Var3.g(obj);
            t71 t71Var = n71Var4 != null ? (t71) b81Var.i.g(n71Var4) : null;
            if (t71Var != null && t71Var.d) {
                b81Var.m(n71Var4, obj, false, vq0Var);
            }
            if ((t71Var != null ? t71Var.f : null) != null) {
                b81Var.d(t71Var, true);
            }
        } else {
            b81Var.k(obj, vq0Var, false);
            gm1Var2.m(obj, b81Var.f(obj));
        }
        n71 n71Var5 = (n71) gm1Var3.g(obj);
        if (n71Var5 == null) {
            return ii0.a;
        }
        List listS0 = n71Var5.p0.p.s0();
        wl1 wl1Var = (wl1) listS0;
        int i3 = ((pm1) wl1Var.b).c;
        for (int i4 = 0; i4 < i3; i4++) {
            ((nh1) wl1Var.get(i4)).i.b = true;
        }
        return listS0;
    }

    @Override // defpackage.jc0
    public final float I(long j) {
        return this.a.I(j);
    }

    @Override // defpackage.qh1
    public final ph1 O(int i, int i2, Map map, hq0 hq0Var, hq0 hq0Var2) {
        return this.a.O(i, i2, map, hq0Var, hq0Var2);
    }

    @Override // defpackage.jc0
    public final int R(float f) {
        return this.a.R(f);
    }

    @Override // defpackage.jc0
    public final long a0(long j) {
        return this.a.a0(j);
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.a.b;
    }

    @Override // defpackage.jc0
    public final float d0(long j) {
        return this.a.d0(j);
    }

    @Override // defpackage.z21
    public final z61 getLayoutDirection() {
        return this.a.a;
    }

    @Override // defpackage.qh1
    public final ph1 j0(int i, int i2, Map map, hq0 hq0Var) {
        return this.a.O(i, i2, map, null, hq0Var);
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.a.c;
    }

    @Override // defpackage.jc0
    public final long l0(float f) {
        return this.a.l0(f);
    }

    @Override // defpackage.jc0
    public final float r0(int i) {
        return this.a.r0(i);
    }

    @Override // defpackage.z21
    public final boolean s() {
        return this.a.s();
    }

    @Override // defpackage.jc0
    public final float u0(float f) {
        return f / this.a.b();
    }

    @Override // defpackage.jc0
    public final long v(float f) {
        return this.a.v(f);
    }

    @Override // defpackage.jc0
    public final long w(long j) {
        return this.a.w(j);
    }

    @Override // defpackage.jc0
    public final float x(float f) {
        return this.a.b() * f;
    }
}
