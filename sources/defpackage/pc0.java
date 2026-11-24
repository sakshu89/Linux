package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pc0 extends qr2 {
    public static final Object h = new Object();
    public long c;
    public int d;
    public ul1 e;
    public Object f;
    public int g;

    public pc0(long j) {
        super(j);
        ul1 ul1Var = xo1.a;
        ul1Var.getClass();
        this.e = ul1Var;
        this.f = h;
    }

    @Override // defpackage.qr2
    public final void a(qr2 qr2Var) {
        qr2Var.getClass();
        pc0 pc0Var = (pc0) qr2Var;
        this.e = pc0Var.e;
        this.f = pc0Var.f;
        this.g = pc0Var.g;
    }

    @Override // defpackage.qr2
    public final qr2 b(long j) {
        return new pc0(j);
    }

    public final boolean c(qc0 qc0Var, bm2 bm2Var) {
        boolean z;
        boolean z2;
        Object obj = im2.c;
        synchronized (obj) {
            z = true;
            z2 = (this.c == bm2Var.g() && this.d == bm2Var.h()) ? false : true;
        }
        if (this.f == h || (z2 && this.g != d(qc0Var, bm2Var))) {
            z = false;
        }
        if (!z || !z2) {
            return z;
        }
        synchronized (obj) {
            this.c = bm2Var.g();
            this.d = bm2Var.h();
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00cc A[LOOP:3: B:44:0x00ca->B:45:0x00cc, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r15v9, types: [int] */
    public final int d(qc0 qc0Var, bm2 bm2Var) {
        ul1 ul1Var;
        int iIdentityHashCode;
        Object[] objArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        qr2 qr2VarI;
        synchronized (im2.c) {
            ul1Var = this.e;
        }
        int i7 = 7;
        if (ul1Var.e == 0) {
            return 7;
        }
        pm1 pm1VarA = o44.a();
        Object[] objArr2 = pm1VarA.a;
        int i8 = pm1VarA.c;
        boolean z = false;
        for (int i9 = 0; i9 < i8; i9++) {
            ((w20) objArr2[i9]).b();
        }
        try {
            Object[] objArr3 = ul1Var.b;
            int[] iArr = ul1Var.c;
            long[] jArr = ul1Var.a;
            int length = jArr.length - 2;
            if (length >= 0) {
                iIdentityHashCode = 7;
                int i10 = 0;
                while (true) {
                    long j = jArr[i10];
                    if ((((~j) << i7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i11 = 8;
                        int i12 = 8 - ((~(i10 - length)) >>> 31);
                        for (?? r14 = z; r14 < i12; r14++) {
                            if ((255 & j) < 128) {
                                ?? r15 = (i10 << 3) + r14;
                                i5 = i7;
                                nr2 nr2Var = (nr2) objArr3[r15];
                                i6 = i11;
                                if (iArr[r15] == 1) {
                                    if (nr2Var instanceof qc0) {
                                        qc0 qc0Var2 = (qc0) nr2Var;
                                        qr2VarI = qc0Var2.g((pc0) im2.i(qc0Var2.e, bm2Var), bm2Var, z, qc0Var2.b);
                                    } else {
                                        qr2VarI = im2.i(nr2Var.a(), bm2Var);
                                    }
                                    iIdentityHashCode = (((iIdentityHashCode * 31) + System.identityHashCode(qr2VarI)) * 31) + Long.hashCode(qr2VarI.a);
                                }
                            } else {
                                i5 = i7;
                                i6 = i11;
                            }
                            j >>= i6;
                            i7 = i5;
                            i11 = i6;
                            length = length;
                            z = false;
                        }
                        i3 = i7;
                        i4 = length;
                        if (i12 != i11) {
                            break;
                        }
                    } else {
                        i3 = i7;
                        i4 = length;
                    }
                    if (i10 != i4) {
                        i10++;
                        i7 = i3;
                        length = i4;
                        z = false;
                    } else {
                        i7 = iIdentityHashCode;
                    }
                }
                objArr = pm1VarA.a;
                i = pm1VarA.c;
                for (i2 = 0; i2 < i; i2++) {
                    ((w20) objArr[i2]).a();
                }
                return iIdentityHashCode;
            }
            iIdentityHashCode = i7;
            objArr = pm1VarA.a;
            i = pm1VarA.c;
            while (i2 < i) {
                ((w20) objArr[i2]).a();
            }
            return iIdentityHashCode;
        } catch (Throwable th) {
            Object[] objArr4 = pm1VarA.a;
            int i13 = pm1VarA.c;
            for (int i14 = 0; i14 < i13; i14++) {
                ((w20) objArr4[i14]).a();
            }
            throw th;
        }
    }
}
