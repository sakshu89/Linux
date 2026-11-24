package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kv0 extends d63 {
    public float[] b;
    public final ArrayList c = new ArrayList();
    public boolean d = true;
    public long e = sz.g;
    public List f;
    public boolean g;
    public na h;
    public hq0 i;
    public final h6 j;
    public String k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public boolean s;

    public kv0() {
        int i = o63.a;
        this.f = ii0.a;
        this.g = true;
        this.j = new h6(15, this);
        this.k = "";
        this.o = 1.0f;
        this.p = 1.0f;
        this.s = true;
    }

    @Override // defpackage.d63
    public final void a(rf0 rf0Var) {
        if (this.s) {
            float[] fArrA = this.b;
            if (fArrA == null) {
                fArrA = ih1.a();
                this.b = fArrA;
            } else {
                ih1.d(fArrA);
            }
            ih1.f(fArrA, this.q + this.m, this.r + this.n);
            float f = this.l;
            if (fArrA.length >= 16) {
                double d = ((double) f) * 0.017453292519943295d;
                float fSin = (float) Math.sin(d);
                float fCos = (float) Math.cos(d);
                float f2 = fArrA[0];
                float f3 = fArrA[4];
                float f4 = (fSin * f3) + (fCos * f2);
                float f5 = -fSin;
                float f6 = (f3 * fCos) + (f2 * f5);
                float f7 = fArrA[1];
                float f8 = fArrA[5];
                float f9 = (fSin * f8) + (fCos * f7);
                float f10 = (f8 * fCos) + (f7 * f5);
                float f11 = fArrA[2];
                float f12 = fArrA[6];
                float f13 = (fSin * f12) + (fCos * f11);
                float f14 = (f12 * fCos) + (f11 * f5);
                float f15 = fArrA[3];
                float f16 = fArrA[7];
                float f17 = (fSin * f16) + (fCos * f15);
                fArrA[0] = f4;
                fArrA[1] = f9;
                fArrA[2] = f13;
                fArrA[3] = f17;
                fArrA[4] = f6;
                fArrA[5] = f10;
                fArrA[6] = f14;
                fArrA[7] = (fCos * f16) + (f5 * f15);
            }
            float f18 = this.o;
            float f19 = this.p;
            if (fArrA.length >= 16) {
                fArrA[0] = fArrA[0] * f18;
                fArrA[1] = fArrA[1] * f18;
                fArrA[2] = fArrA[2] * f18;
                fArrA[3] = fArrA[3] * f18;
                fArrA[4] = fArrA[4] * f19;
                fArrA[5] = fArrA[5] * f19;
                fArrA[6] = fArrA[6] * f19;
                fArrA[7] = fArrA[7] * f19;
                fArrA[8] = fArrA[8] * 1.0f;
                fArrA[9] = fArrA[9] * 1.0f;
                fArrA[10] = fArrA[10] * 1.0f;
                fArrA[11] = fArrA[11] * 1.0f;
            }
            ih1.f(fArrA, -this.m, -this.n);
            this.s = false;
        }
        if (this.g) {
            if (!this.f.isEmpty()) {
                na naVarA = this.h;
                if (naVarA == null) {
                    naVarA = pa.a();
                    this.h = naVarA;
                }
                sg.c(this.f, naVarA);
            }
            this.g = false;
        }
        kf kfVarC = rf0Var.C();
        long jR = kfVarC.r();
        kfVarC.m().m();
        try {
            kf kfVar = (kf) ((q82) kfVarC.b).a;
            float[] fArr = this.b;
            if (fArr != null) {
                kfVar.m().r(fArr);
            }
            na naVar = this.h;
            if (!this.f.isEmpty() && naVar != null) {
                kfVar.m().t(naVar);
            }
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((d63) arrayList.get(i)).a(rf0Var);
            }
        } finally {
            cq.t(kfVarC, jR);
        }
    }

    @Override // defpackage.d63
    public final hq0 b() {
        return this.i;
    }

    @Override // defpackage.d63
    public final void d(h6 h6Var) {
        this.i = h6Var;
    }

    public final void e(int i, d63 d63Var) {
        ArrayList arrayList = this.c;
        if (i < arrayList.size()) {
            arrayList.set(i, d63Var);
        } else {
            arrayList.add(d63Var);
        }
        g(d63Var);
        d63Var.d(this.j);
        c();
    }

    public final void f(long j) {
        if (this.d && j != 16) {
            long j2 = this.e;
            if (j2 == 16) {
                this.e = j;
                return;
            }
            int i = o63.a;
            if (sz.h(j2) == sz.h(j) && sz.g(j2) == sz.g(j) && sz.e(j2) == sz.e(j)) {
                return;
            }
            this.d = false;
            this.e = sz.g;
        }
    }

    public final void g(d63 d63Var) {
        if (!(d63Var instanceof ou1)) {
            if (d63Var instanceof kv0) {
                kv0 kv0Var = (kv0) d63Var;
                if (kv0Var.d && this.d) {
                    f(kv0Var.e);
                    return;
                } else {
                    this.d = false;
                    this.e = sz.g;
                    return;
                }
            }
            return;
        }
        ou1 ou1Var = (ou1) d63Var;
        hn hnVar = ou1Var.b;
        if (this.d && hnVar != null) {
            if (hnVar instanceof cn2) {
                f(((cn2) hnVar).a);
            } else {
                this.d = false;
                this.e = sz.g;
            }
        }
        hn hnVar2 = ou1Var.g;
        if (this.d && hnVar2 != null) {
            if (hnVar2 instanceof cn2) {
                f(((cn2) hnVar2).a);
            } else {
                this.d = false;
                this.e = sz.g;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("VGroup: ");
        sb.append(this.k);
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d63 d63Var = (d63) arrayList.get(i);
            sb.append("\t");
            sb.append(d63Var.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
