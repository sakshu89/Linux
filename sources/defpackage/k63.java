package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k63 extends d63 {
    public final kv0 b;
    public String c;
    public boolean d;
    public final nf0 e;
    public fq0 f;
    public final ku1 g;
    public nl h;
    public final ku1 i;
    public long j;
    public float k;
    public float l;
    public final j63 m;

    public k63(kv0 kv0Var) {
        this.b = kv0Var;
        kv0Var.i = new j63(this, 0);
        this.c = "";
        this.d = true;
        this.e = new nf0();
        this.f = k30.u;
        this.g = o44.g(null);
        this.i = o44.g(new xk2(0L));
        this.j = 9205357640488583168L;
        this.k = 1.0f;
        this.l = 1.0f;
        this.m = new j63(this, 1);
    }

    @Override // defpackage.d63
    public final void a(rf0 rf0Var) {
        e(rf0Var, 1.0f, null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0060  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:51:0x010b  */
    public final void e(rf0 rf0Var, float f, nl nlVar) {
        int i;
        nl nlVar2;
        p9 p9VarA;
        char c;
        long j;
        long jB;
        nl nlVar3;
        int i2;
        int i3;
        kv0 kv0Var = this.b;
        boolean z = kv0Var.d;
        ku1 ku1Var = this.g;
        if (!z || kv0Var.e == 16) {
            i = 0;
        } else {
            nl nlVar4 = (nl) ku1Var.getValue();
            int i4 = o63.a;
            if (!(nlVar4 instanceof nl) ? nlVar4 == null : (i3 = nlVar4.c) == 5 || i3 == 3) {
                i = 0;
            } else if (!(nlVar instanceof nl) ? nlVar == null : (i2 = nlVar.c) == 5 || i2 == 3) {
                i = 0;
            } else {
                i = 1;
            }
        }
        boolean z2 = this.d;
        nf0 nf0Var = this.e;
        if (z2 || !xk2.a(this.j, rf0Var.c())) {
            if (i == 1) {
                jB = kv0Var.e;
                int i5 = o63.a;
                if (sz.d(jB) != 1.0f) {
                    jB = sz.b(1.0f, jB);
                }
                nlVar2 = new nl(5, jB);
            } else {
                nlVar2 = null;
            }
            this.h = nlVar2;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (rf0Var.c() >> 32));
            ku1 ku1Var2 = this.i;
            this.k = fIntBitsToFloat / Float.intBitsToFloat((int) (((xk2) ku1Var2.getValue()).a >> 32));
            this.l = Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L)) / Float.intBitsToFloat((int) (((xk2) ku1Var2.getValue()).a & 4294967295L));
            long jCeil = (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (rf0Var.c() >> 32))))) << 32) | (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L))))) & 4294967295L);
            z61 layoutDirection = rf0Var.getLayoutDirection();
            p9VarA = nf0Var.a;
            u6 u6VarA = nf0Var.b;
            if (p9VarA != null || u6VarA == null) {
                c = ' ';
                j = 4294967295L;
            } else {
                int i6 = (int) (jCeil >> 32);
                Bitmap bitmap = p9VarA.a;
                c = ' ';
                j = 4294967295L;
                if (i6 > bitmap.getWidth() || ((int) (jCeil & 4294967295L)) > bitmap.getHeight() || nf0Var.d != i) {
                }
                nf0Var.c = jCeil;
                ew ewVar = nf0Var.e;
                long jA = cp4.a(jCeil);
                dw dwVar = ewVar.a;
                jc0 jc0Var = dwVar.a;
                z61 z61Var = dwVar.b;
                cw cwVar = dwVar.c;
                u6 u6Var = u6VarA;
                long j2 = dwVar.d;
                dwVar.a = rf0Var;
                dwVar.b = layoutDirection;
                dwVar.c = u6Var;
                dwVar.d = jA;
                u6Var.m();
                rf0.E(ewVar, sz.b, 0L, 62);
                this.m.j(ewVar);
                u6Var.j();
                dw dwVar2 = ewVar.a;
                dwVar2.a = jc0Var;
                dwVar2.b = z61Var;
                dwVar2.c = cwVar;
                dwVar2.d = j2;
                p9VarA.a.prepareToDraw();
                this.d = false;
                this.j = rf0Var.c();
            }
            p9VarA = ro4.a((int) (jCeil >> c), (int) (jCeil & j), i);
            u6VarA = bh4.a(p9VarA);
            nf0Var.a = p9VarA;
            nf0Var.b = u6VarA;
            nf0Var.d = i;
            nf0Var.c = jCeil;
            ew ewVar2 = nf0Var.e;
            long jA2 = cp4.a(jCeil);
            dw dwVar3 = ewVar2.a;
            jc0 jc0Var2 = dwVar3.a;
            z61 z61Var2 = dwVar3.b;
            cw cwVar2 = dwVar3.c;
            u6 u6Var2 = u6VarA;
            long j3 = dwVar3.d;
            dwVar3.a = rf0Var;
            dwVar3.b = layoutDirection;
            dwVar3.c = u6Var2;
            dwVar3.d = jA2;
            u6Var2.m();
            rf0.E(ewVar2, sz.b, 0L, 62);
            this.m.j(ewVar2);
            u6Var2.j();
            dw dwVar4 = ewVar2.a;
            dwVar4.a = jc0Var2;
            dwVar4.b = z61Var2;
            dwVar4.c = cwVar2;
            dwVar4.d = j3;
            p9VarA.a.prepareToDraw();
            this.d = false;
            this.j = rf0Var.c();
        } else {
            p9 p9Var = nf0Var.a;
            if (i != (p9Var != null ? p9Var.a() : 0)) {
                if (i == 1) {
                    jB = kv0Var.e;
                    int i7 = o63.a;
                    if (sz.d(jB) != 1.0f) {
                        jB = sz.b(1.0f, jB);
                    }
                    nlVar2 = new nl(5, jB);
                } else {
                    nlVar2 = null;
                }
                this.h = nlVar2;
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (rf0Var.c() >> 32));
                ku1 ku1Var3 = this.i;
                this.k = fIntBitsToFloat2 / Float.intBitsToFloat((int) (((xk2) ku1Var3.getValue()).a >> 32));
                this.l = Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L)) / Float.intBitsToFloat((int) (((xk2) ku1Var3.getValue()).a & 4294967295L));
                long jCeil2 = (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (rf0Var.c() >> 32))))) << 32) | (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (rf0Var.c() & 4294967295L))))) & 4294967295L);
                z61 layoutDirection2 = rf0Var.getLayoutDirection();
                p9VarA = nf0Var.a;
                u6 u6VarA2 = nf0Var.b;
                if (p9VarA != null) {
                    c = ' ';
                    j = 4294967295L;
                    p9VarA = ro4.a((int) (jCeil2 >> c), (int) (jCeil2 & j), i);
                    u6VarA2 = bh4.a(p9VarA);
                    nf0Var.a = p9VarA;
                    nf0Var.b = u6VarA2;
                    nf0Var.d = i;
                } else {
                    c = ' ';
                    j = 4294967295L;
                    p9VarA = ro4.a((int) (jCeil2 >> c), (int) (jCeil2 & j), i);
                    u6VarA2 = bh4.a(p9VarA);
                    nf0Var.a = p9VarA;
                    nf0Var.b = u6VarA2;
                    nf0Var.d = i;
                }
                nf0Var.c = jCeil2;
                ew ewVar3 = nf0Var.e;
                long jA3 = cp4.a(jCeil2);
                dw dwVar5 = ewVar3.a;
                jc0 jc0Var3 = dwVar5.a;
                z61 z61Var3 = dwVar5.b;
                cw cwVar3 = dwVar5.c;
                u6 u6Var3 = u6VarA2;
                long j4 = dwVar5.d;
                dwVar5.a = rf0Var;
                dwVar5.b = layoutDirection2;
                dwVar5.c = u6Var3;
                dwVar5.d = jA3;
                u6Var3.m();
                rf0.E(ewVar3, sz.b, 0L, 62);
                this.m.j(ewVar3);
                u6Var3.j();
                dw dwVar6 = ewVar3.a;
                dwVar6.a = jc0Var3;
                dwVar6.b = z61Var3;
                dwVar6.c = cwVar3;
                dwVar6.d = j4;
                p9VarA.a.prepareToDraw();
                this.d = false;
                this.j = rf0Var.c();
            }
        }
        if (nlVar != null) {
            nlVar3 = nlVar;
        } else {
            nlVar3 = ((nl) ku1Var.getValue()) != null ? (nl) ku1Var.getValue() : this.h;
        }
        p9 p9Var2 = nf0Var.a;
        if (p9Var2 == null) {
            z01.b("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        rf0.T(rf0Var, p9Var2, nf0Var.c, 0L, f, nlVar3, 0, 858);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Params: \tname: ");
        sb.append(this.c);
        sb.append("\n\tviewportWidth: ");
        ku1 ku1Var = this.i;
        sb.append(Float.intBitsToFloat((int) (((xk2) ku1Var.getValue()).a >> 32)));
        sb.append("\n\tviewportHeight: ");
        sb.append(Float.intBitsToFloat((int) (((xk2) ku1Var.getValue()).a & 4294967295L)));
        sb.append("\n");
        return sb.toString();
    }
}
