package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l01 {
    public final ae2 a;
    public g01 b;
    public j01 c;
    public i01 d;
    public h01 e;
    public uo4 f;
    public py0 g;
    public long h = 9205357640488583168L;
    public fw0 i;
    public final m01 j;
    public final m01 k;
    public long l;

    public l01(ae2 ae2Var) {
        this.a = ae2Var;
        m01 m01Var = new m01();
        m01Var.b = new ArrayList();
        this.j = m01Var;
        m01 m01Var2 = new m01();
        m01Var2.b = new ArrayList();
        this.k = m01Var2;
        this.l = 0L;
    }

    public static void c(l01 l01Var, e01 e01Var, long j, long j2, int i) {
        if ((i & 4) != 0) {
            j2 = 0;
        }
        ae2 ae2Var = l01Var.a;
        i01 i01Var = l01Var.d;
        if (i01Var == null) {
            i01Var = new i01();
            i01Var.a = null;
            i01Var.b = Long.MAX_VALUE;
            i01Var.c = false;
            l01Var.d = i01Var;
        }
        i01Var.a = e01Var;
        i01Var.b = j;
        fw0 fw0Var = l01Var.i;
        js1 js1Var = ae2Var.X;
        if (fw0Var == null) {
            l01Var.i = new fw0(js1Var);
        } else {
            fw0Var.b = js1Var;
            fw0Var.a = j2;
        }
        i01Var.c = false;
        l01Var.f = i01Var;
    }

    public final void a() {
        g01 g01Var = this.b;
        f01 f01Var = f01.c;
        if (g01Var == null) {
            g01Var = new g01();
            g01Var.a = f01Var;
            g01Var.b = false;
            this.b = g01Var;
        }
        g01Var.a = f01Var;
        g01Var.b = false;
        this.f = g01Var;
    }

    public final void b(e01 e01Var, long j, fw0 fw0Var) {
        h01 h01Var = this.e;
        if (h01Var == null) {
            h01Var = new h01();
            h01Var.a = null;
            h01Var.b = Long.MAX_VALUE;
            this.e = h01Var;
        }
        h01Var.a = e01Var;
        h01Var.b = j;
        fw0Var.a = 0L;
        this.f = h01Var;
    }

    public final py0 d() {
        py0 py0Var = this.g;
        if (py0Var != null) {
            return py0Var;
        }
        og.i("Velocity Tracker not initialized.");
        return null;
    }

    public final void e(e01 e01Var, d01 d01Var, long j) {
        ae2 ae2Var = this.a;
        long jA = cm4.f(ae2Var).a(0L);
        if (!jp1.b(this.h, 9205357640488583168L) && !jp1.b(jA, this.h)) {
            this.l = jp1.e(this.l, jp1.d(jA, this.h));
        }
        this.h = jA;
        js1 js1Var = ae2Var.X;
        js1Var.getClass();
        if (Math.abs(Float.intBitsToFloat((int) (js1Var == js1.a ? j & 4294967295L : j >> 32))) > 2.0f) {
            vo4.a(d(), e01Var, ae2Var.X, d01Var, this.j, this.l);
            m01 m01Var = this.k;
            ArrayList arrayList = m01Var.b;
            if (arrayList.size() == 3) {
                int i = m01Var.a;
                m01Var.a = i + 1;
                arrayList.set(i, new jp1(j));
            } else {
                arrayList.add(new jp1(j));
            }
            if (m01Var.a == 3) {
                m01Var.a = 0;
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(Float.valueOf(Float.intBitsToFloat((int) (((jp1) arrayList.get(i2)).a >> 32))));
            }
            float fR = (float) mz.r(arrayList2);
            ArrayList arrayList3 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(Float.valueOf(Float.intBitsToFloat((int) (((jp1) arrayList.get(i3)).a & 4294967295L))));
            }
            ae2Var.S0(new se0((((long) Float.floatToRawIntBits((float) mz.r(arrayList3))) & 4294967295L) | (((long) Float.floatToRawIntBits(fR)) << 32), true));
        }
    }

    public final void f(e01 e01Var, e01 e01Var2, d01 d01Var, long j) {
        if (this.g == null) {
            this.g = new py0(22);
        }
        this.l = 0L;
        py0 py0VarD = d();
        ae2 ae2Var = this.a;
        vo4.a(py0VarD, e01Var, ae2Var.X, d01Var, this.j, this.l);
        long jD = jp1.d(vo4.c(e01Var2, ae2Var.X, d01Var), j);
        ae2Var.Y.getClass();
        this.h = cm4.f(ae2Var).a(0L);
        ae2Var.S0(new te0(jD));
        m01 m01Var = this.k;
        m01Var.a = 0;
        m01Var.b.clear();
    }
}
