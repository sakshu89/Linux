package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class id2 extends dk1 implements f71, eg2 {
    public boolean H;
    public md2 x;

    @Override // defpackage.f71
    public final int B(mf1 mf1Var, jh1 jh1Var, int i) {
        if (!this.H) {
            i = Integer.MAX_VALUE;
        }
        return jh1Var.e0(i);
    }

    @Override // defpackage.f71
    public final int S(mf1 mf1Var, jh1 jh1Var, int i) {
        if (this.H) {
            i = Integer.MAX_VALUE;
        }
        return jh1Var.V(i);
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        rh4.a(j, this.H ? js1.a : js1.b);
        zw1 zw1VarE = jh1Var.e(q40.a(j, 0, this.H ? q40.h(j) : Integer.MAX_VALUE, 0, this.H ? Integer.MAX_VALUE : q40.g(j), 5));
        int i = zw1VarE.a;
        int iH = q40.h(j);
        if (i > iH) {
            i = iH;
        }
        int i2 = zw1VarE.b;
        int iG = q40.g(j);
        if (i2 > iG) {
            i2 = iG;
        }
        int i3 = zw1VarE.b - i2;
        int i4 = zw1VarE.a - i;
        if (!this.H) {
            i3 = i4;
        }
        md2 md2Var = this.x;
        hu1 hu1Var = md2Var.e;
        hu1 hu1Var2 = md2Var.a;
        hu1Var.h(i3);
        bm2 bm2VarA = i44.a();
        hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
        bm2 bm2VarB = i44.b(bm2VarA);
        try {
            if (hu1Var2.g() > i3) {
                hu1Var2.h(i3);
            }
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            this.x.b.h(this.H ? i2 : i);
            this.x.c.h(this.H ? zw1VarE.b : zw1VarE.a);
            return qh1Var.j0(i, i2, ji0.a, new z32(i3, 2, this, zw1VarE));
        } catch (Throwable th) {
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            throw th;
        }
    }

    @Override // defpackage.f71
    public final int e(mf1 mf1Var, jh1 jh1Var, int i) {
        if (this.H) {
            i = Integer.MAX_VALUE;
        }
        return jh1Var.c0(i);
    }

    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        c51[] c51VarArr = mg2.a;
        ng2 ng2Var = kg2.m;
        c51[] c51VarArr2 = mg2.a;
        c51 c51Var = c51VarArr2[6];
        og2Var.a(ng2Var, Boolean.TRUE);
        final int i = 0;
        final int i2 = 1;
        ed2 ed2Var = new ed2(new fq0(this) { // from class: hd2
            public final /* synthetic */ id2 b;

            {
                this.b = this;
            }

            @Override // defpackage.fq0
            public final Object a() {
                int iG;
                int i3 = i;
                id2 id2Var = this.b;
                switch (i3) {
                    case 0:
                        iG = id2Var.x.a.g();
                        break;
                    default:
                        iG = id2Var.x.e.g();
                        break;
                }
                return Float.valueOf(iG);
            }
        }, new fq0(this) { // from class: hd2
            public final /* synthetic */ id2 b;

            {
                this.b = this;
            }

            @Override // defpackage.fq0
            public final Object a() {
                int iG;
                int i3 = i2;
                id2 id2Var = this.b;
                switch (i3) {
                    case 0:
                        iG = id2Var.x.a.g();
                        break;
                    default:
                        iG = id2Var.x.e.g();
                        break;
                }
                return Float.valueOf(iG);
            }
        });
        if (this.H) {
            ng2 ng2Var2 = kg2.v;
            c51 c51Var2 = c51VarArr2[13];
            og2Var.a(ng2Var2, ed2Var);
        } else {
            ng2 ng2Var3 = kg2.u;
            c51 c51Var3 = c51VarArr2[12];
            og2Var.a(ng2Var3, ed2Var);
        }
    }

    @Override // defpackage.f71
    public final int n(mf1 mf1Var, jh1 jh1Var, int i) {
        if (!this.H) {
            i = Integer.MAX_VALUE;
        }
        return jh1Var.f(i);
    }
}
