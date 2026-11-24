package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qc0 extends or2 implements gr2 {
    public final fq0 b;
    public final om2 c;
    public pc0 e = new pc0(im2.j().g());

    public qc0(fq0 fq0Var, ak1 ak1Var) {
        this.b = fq0Var;
        this.c = ak1Var;
    }

    @Override // defpackage.nr2
    public final qr2 a() {
        return this.e;
    }

    @Override // defpackage.nr2
    public final void d(qr2 qr2Var) {
        qr2Var.getClass();
        this.e = (pc0) qr2Var;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x009c A[EDGE_INSN: B:101:0x009c->B:31:0x009c BREAK  A[LOOP:1: B:16:0x0049->B:30:0x0099], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0099 A[Catch: all -> 0x0038, LOOP:1: B:16:0x0049->B:30:0x0099, LOOP_END, TryCatch #3 {all -> 0x0038, blocks: (B:8:0x0023, B:10:0x002f, B:13:0x003b, B:16:0x0049, B:18:0x0059, B:20:0x0065, B:22:0x006f, B:24:0x0087, B:26:0x008d, B:30:0x0099, B:31:0x009c), top: B:96:0x0023 }] */
    public final pc0 g(pc0 pc0Var, bm2 bm2Var, boolean z, fq0 fq0Var) {
        pc0 pc0Var2;
        om2 om2Var;
        int i;
        if (pc0Var.c(this, bm2Var)) {
            if (z) {
                pm1 pm1VarA = o44.a();
                Object[] objArr = pm1VarA.a;
                int i2 = pm1VarA.c;
                for (int i3 = 0; i3 < i2; i3++) {
                    ((w20) objArr[i3]).b();
                }
                try {
                    ul1 ul1Var = pc0Var.e;
                    kf kfVar = pm2.a;
                    j21 j21Var = (j21) kfVar.l();
                    if (j21Var == null) {
                        j21Var = new j21();
                        kfVar.C(j21Var);
                    }
                    int i4 = j21Var.a;
                    Object[] objArr2 = ul1Var.b;
                    int[] iArr = ul1Var.c;
                    long[] jArr = ul1Var.a;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i5 = 0;
                        while (true) {
                            long j = jArr[i5];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i5 != length) {
                                    break;
                                    break;
                                }
                                i5++;
                            } else {
                                int i6 = 8;
                                int i7 = 8 - ((~(i5 - length)) >>> 31);
                                int i8 = 0;
                                while (i8 < i7) {
                                    if ((j & 255) < 128) {
                                        int i9 = (i5 << 3) + i8;
                                        nr2 nr2Var = (nr2) objArr2[i9];
                                        i = i6;
                                        j21Var.a = i4 + iArr[i9];
                                        hq0 hq0VarE = bm2Var.e();
                                        if (hq0VarE != null) {
                                            hq0VarE.j(nr2Var);
                                        }
                                    } else {
                                        i = i6;
                                    }
                                    j >>= i;
                                    i8++;
                                    i6 = i;
                                }
                                if (i7 != i6) {
                                    break;
                                }
                                if (i5 != length) {
                                    break;
                                }
                                i5++;
                            }
                        }
                    }
                    j21Var.a = i4;
                } finally {
                    Object[] objArr3 = pm1VarA.a;
                    int i10 = pm1VarA.c;
                    for (int i11 = 0; i11 < i10; i11++) {
                        ((w20) objArr3[i11]).a();
                    }
                }
            }
            return pc0Var;
        }
        ul1 ul1Var2 = new ul1();
        kf kfVar2 = pm2.a;
        j21 j21Var2 = (j21) kfVar2.l();
        if (j21Var2 == null) {
            j21Var2 = new j21();
            kfVar2.C(j21Var2);
        }
        int i12 = j21Var2.a;
        pm1 pm1VarA2 = o44.a();
        Object[] objArr4 = pm1VarA2.a;
        int i13 = pm1VarA2.c;
        for (int i14 = 0; i14 < i13; i14++) {
            ((w20) objArr4[i14]).b();
        }
        try {
            j21Var2.a = i12 + 1;
            Object objC = i44.c(new h2(this, j21Var2, ul1Var2, i12, 1), fq0Var);
            j21Var2.a = i12;
            Object[] objArr5 = pm1VarA2.a;
            int i15 = pm1VarA2.c;
            for (int i16 = 0; i16 < i15; i16++) {
                ((w20) objArr5[i16]).a();
            }
            Object obj = im2.c;
            synchronized (obj) {
                try {
                    bm2 bm2VarJ = im2.j();
                    Object obj2 = pc0Var.f;
                    if (obj2 == pc0.h || (om2Var = this.c) == null || !om2Var.b(objC, obj2)) {
                        pc0 pc0Var3 = this.e;
                        synchronized (obj) {
                            qr2 qr2VarM = im2.m(pc0Var3, this);
                            qr2VarM.a(pc0Var3);
                            qr2VarM.a = bm2VarJ.g();
                            pc0Var2 = (pc0) qr2VarM;
                            pc0Var2.e = ul1Var2;
                            pc0Var2.g = pc0Var2.d(this, bm2VarJ);
                            pc0Var2.f = objC;
                        }
                        return pc0Var2;
                    }
                    pc0Var.e = ul1Var2;
                    pc0Var.g = pc0Var.d(this, bm2VarJ);
                    pc0Var2 = pc0Var;
                } catch (Throwable th) {
                    throw th;
                }
            }
            j21 j21Var3 = (j21) pm2.a.l();
            if (j21Var3 == null || j21Var3.a != 0) {
                return pc0Var2;
            }
            im2.j().m();
            synchronized (obj) {
                bm2 bm2VarJ2 = im2.j();
                pc0Var2.c = bm2VarJ2.g();
                pc0Var2.d = bm2VarJ2.h();
                return pc0Var2;
            }
        } catch (Throwable th2) {
            Object[] objArr6 = pm1VarA2.a;
            int i17 = pm1VarA2.c;
            for (int i18 = 0; i18 < i17; i18++) {
                ((w20) objArr6[i18]).a();
            }
            throw th2;
        }
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        hq0 hq0VarE = im2.j().e();
        if (hq0VarE != null) {
            hq0VarE.j(this);
        }
        bm2 bm2VarJ = im2.j();
        return g((pc0) im2.i(this.e, bm2VarJ), bm2VarJ, true, this.b).f;
    }

    public final pc0 h() {
        bm2 bm2VarJ = im2.j();
        return g((pc0) im2.i(this.e, bm2VarJ), bm2VarJ, false, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DerivedState(value=");
        pc0 pc0Var = (pc0) im2.h(this.e);
        sb.append(pc0Var.c(this, im2.j()) ? String.valueOf(pc0Var.f) : "<Not calculated>");
        sb.append(")@");
        sb.append(hashCode());
        return sb.toString();
    }
}
