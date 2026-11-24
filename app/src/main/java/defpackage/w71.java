package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w71 implements ph1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ph1 b;
    public final /* synthetic */ b81 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ph1 e;

    public /* synthetic */ w71(ph1 ph1Var, b81 b81Var, int i, ph1 ph1Var2, int i2) {
        this.a = i2;
        this.c = b81Var;
        this.d = i;
        this.e = ph1Var2;
        this.b = ph1Var;
    }

    @Override // defpackage.ph1
    public final int a() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.a();
    }

    @Override // defpackage.ph1
    public final int b() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.b();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x008b A[LOOP:0: B:11:0x002f->B:30:0x008b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x008e A[SYNTHETIC] */
    @Override // defpackage.ph1
    public final void c() {
        int i = this.a;
        ph1 ph1Var = this.e;
        int i2 = this.d;
        b81 b81Var = this.c;
        switch (i) {
            case 0:
                b81Var.f = i2;
                ph1Var.c();
                pm1 pm1Var = b81Var.v;
                gm1 gm1Var = b81Var.u;
                long[] jArr = gm1Var.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i3 = 0;
                    while (true) {
                        long j = jArr[i3];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i4 = 8 - ((~(i3 - length)) >>> 31);
                            for (int i5 = 0; i5 < i4; i5++) {
                                if ((255 & j) < 128) {
                                    int i6 = (i3 << 3) + i5;
                                    Object obj = gm1Var.b[i6];
                                    us2 us2Var = (us2) gm1Var.c[i6];
                                    int iJ = pm1Var.j(obj);
                                    if (iJ < 0 || iJ >= b81Var.f) {
                                        if (iJ >= 0) {
                                            Object[] objArr = pm1Var.a;
                                            Object obj2 = objArr[iJ];
                                            objArr[iJ] = na4.b;
                                        }
                                        if (b81Var.s.b(obj)) {
                                            us2Var.a();
                                        }
                                        gm1Var.l(i6);
                                    }
                                }
                                j >>= 8;
                            }
                            if (i4 == 8) {
                                if (i3 != length) {
                                    i3++;
                                }
                            }
                        } else if (i3 != length) {
                            i3++;
                        }
                    }
                }
                b81Var.g(b81Var.e);
                break;
            default:
                b81Var.e = i2;
                ph1Var.c();
                if (b81Var.a.n == null) {
                    b81Var.g(b81Var.e);
                }
                break;
        }
    }

    @Override // defpackage.ph1
    public final Map d() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.d();
    }

    @Override // defpackage.ph1
    public final hq0 e() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.e();
    }
}
