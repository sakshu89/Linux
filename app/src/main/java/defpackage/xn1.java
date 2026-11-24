package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xn1 extends ho1 {
    public final dk1 c;
    public final c10 d;
    public final if1 e;
    public co1 f;
    public gy1 g;
    public boolean h;
    public boolean i;
    public boolean j;

    public xn1(dk1 dk1Var) {
        this.c = dk1Var;
        c10 c10Var = new c10();
        c10Var.b = new long[2];
        this.d = c10Var;
        this.e = new if1(2);
        this.i = true;
        this.j = true;
    }

    /* JADX WARN: Code duplicated, block: B:172:0x031a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v0, types: [dk1] */
    /* JADX WARN: Type inference failed for: r5v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44, types: [dk1] */
    /* JADX WARN: Type inference failed for: r5v45, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v52 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    @Override // defpackage.ho1
    public final boolean a(if1 if1Var, y61 y61Var, l11 l11Var, boolean z) {
        c10 c10Var;
        if1 if1Var2;
        Object obj;
        boolean z2;
        boolean z3;
        gy1 gy1Var;
        int i;
        int i2;
        boolean z4;
        boolean zA = super.a(if1Var, y61Var, l11Var, z);
        ?? B = this.c;
        boolean z5 = true;
        if (B.w) {
            ?? pm1Var = 0;
            while (B != 0) {
                if (B instanceof qy1) {
                    this.f = cm4.e((qy1) B, 16);
                } else if ((B.c & 16) != 0 && (B instanceof zb0)) {
                    dk1 dk1Var = ((zb0) B).H;
                    int i3 = 0;
                    B = B;
                    pm1Var = pm1Var;
                    while (dk1Var != null) {
                        if ((dk1Var.c & 16) != 0) {
                            i3++;
                            pm1Var = pm1Var;
                            if (i3 == 1) {
                                B = dk1Var;
                            } else {
                                if (pm1Var == 0) {
                                    pm1Var = new pm1(new dk1[16]);
                                }
                                if (B != 0) {
                                    pm1Var.b(B);
                                    B = 0;
                                }
                                pm1Var.b(dk1Var);
                            }
                        }
                        dk1Var = dk1Var.i;
                        B = B;
                        pm1Var = pm1Var;
                    }
                    if (i3 == 1) {
                    }
                }
                B = cm4.b(pm1Var);
            }
            if (this.f != null) {
                int iF = if1Var.f();
                int i4 = 0;
                while (true) {
                    c10Var = this.d;
                    if1Var2 = this.e;
                    if (i4 >= iF) {
                        break;
                    }
                    long jC = if1Var.c(i4);
                    ny1 ny1Var = (ny1) if1Var.g(i4);
                    if (c10Var.d(jC)) {
                        boolean z6 = z5;
                        long j = ny1Var.g;
                        ArrayList arrayList = ny1Var.k;
                        long j2 = ny1Var.c;
                        if ((((j & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0 && (((j2 & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0) {
                            z4 = z6;
                            ii0 ii0Var = ii0.a;
                            ArrayList arrayList2 = new ArrayList((arrayList == null ? ii0Var : arrayList).size());
                            List list = arrayList == null ? ii0Var : arrayList;
                            int size = list.size();
                            int i5 = 0;
                            while (i5 < size) {
                                List list2 = list;
                                lw0 lw0Var = (lw0) list.get(i5);
                                if1 if1Var3 = if1Var2;
                                long j3 = jC;
                                long j4 = lw0Var.b;
                                if ((((j4 & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0) {
                                    long j5 = lw0Var.a;
                                    co1 co1Var = this.f;
                                    co1Var.getClass();
                                    arrayList2.add(new lw0(j5, co1Var.H(y61Var, j4), lw0Var.c));
                                }
                                i5++;
                                size = size;
                                list = list2;
                                if1Var2 = if1Var3;
                                jC = j3;
                                ny1Var = ny1Var;
                            }
                            if1 if1Var4 = if1Var2;
                            long j6 = jC;
                            co1 co1Var2 = this.f;
                            co1Var2.getClass();
                            long jH = co1Var2.H(y61Var, j);
                            co1 co1Var3 = this.f;
                            co1Var3.getClass();
                            ny1 ny1Var2 = new ny1(ny1Var.a, ny1Var.b, co1Var3.H(y61Var, j2), ny1Var.d, ny1Var.e, ny1Var.f, jH, ny1Var.h, ny1Var.i, arrayList2, ny1Var.j, ny1Var.l);
                            ny1 ny1Var3 = ny1Var.o;
                            if (ny1Var3 == null) {
                                ny1Var3 = ny1Var;
                            }
                            ny1Var2.o = ny1Var3;
                            ny1 ny1Var4 = ny1Var.o;
                            if (ny1Var4 != null) {
                                ny1Var = ny1Var4;
                            }
                            ny1Var2.o = ny1Var;
                            if1Var4.d(j6, ny1Var2);
                        } else {
                            z4 = z6;
                        }
                    } else {
                        z4 = z5;
                    }
                    i4++;
                    iF = iF;
                    z5 = z4;
                    zA = zA;
                }
                boolean z7 = zA;
                boolean z8 = z5;
                if (if1Var2.f() == 0) {
                    c10Var.a = 0;
                    this.a.h();
                    return z8;
                }
                int i6 = c10Var.a;
                while (true) {
                    i6--;
                    if (-1 >= i6) {
                        break;
                    }
                    long j7 = ((long[]) c10Var.b)[i6];
                    if (if1Var.a) {
                        int i7 = if1Var.e;
                        long[] jArr = if1Var.b;
                        Object[] objArr = if1Var.c;
                        int i8 = 0;
                        for (int i9 = 0; i9 < i7; i9++) {
                            Object obj2 = objArr[i9];
                            if (obj2 != m24.a) {
                                if (i9 != i8) {
                                    jArr[i8] = jArr[i9];
                                    objArr[i8] = obj2;
                                    objArr[i9] = null;
                                }
                                i8++;
                            }
                        }
                        if1Var.a = false;
                        if1Var.e = i8;
                    }
                    if (ny3.b(if1Var.b, if1Var.e, j7) < 0 && i6 < (i2 = c10Var.a)) {
                        int i10 = i2 - 1;
                        int i11 = i6;
                        while (i11 < i10) {
                            long[] jArr2 = (long[]) c10Var.b;
                            int i12 = i11 + 1;
                            jArr2[i11] = jArr2[i12];
                            i11 = i12;
                        }
                        c10Var.a--;
                    }
                }
                ArrayList arrayList3 = new ArrayList(if1Var2.f());
                int iF2 = if1Var2.f();
                for (int i13 = 0; i13 < iF2; i13++) {
                    arrayList3.add(if1Var2.g(i13));
                }
                gy1 gy1Var2 = new gy1(arrayList3, l11Var);
                int size2 = arrayList3.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size2) {
                        obj = null;
                        break;
                    }
                    obj = arrayList3.get(i14);
                    if (l11Var.g(((ny1) obj).a)) {
                        break;
                    }
                    i14++;
                }
                ny1 ny1Var5 = (ny1) obj;
                if (ny1Var5 != null) {
                    boolean z9 = ny1Var5.d;
                    if (z) {
                        z2 = false;
                        if (!this.i && (z9 || ny1Var5.h)) {
                            co1 co1Var4 = this.f;
                            co1Var4.getClass();
                            long j8 = co1Var4.c;
                            long j9 = ny1Var5.c;
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (j9 >> 32));
                            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j9 & 4294967295L));
                            int i15 = (int) (j8 >> 32);
                            this.i = !((fIntBitsToFloat2 > ((float) ((int) (j8 & 4294967295L))) ? z8 : false) | (fIntBitsToFloat2 < 0.0f ? z8 : false) | (fIntBitsToFloat > ((float) i15) ? z8 : false) | (fIntBitsToFloat < 0.0f ? z8 : false));
                        }
                    } else {
                        z2 = false;
                        this.i = false;
                    }
                    boolean z10 = this.i;
                    boolean z11 = this.h;
                    if (z10 == z11 || !((i = gy1Var2.f) == 3 || i == 4 || i == 5)) {
                        int i16 = gy1Var2.f;
                        if (i16 == 4 && z11 && !this.j) {
                            gy1Var2.f = 3;
                        } else if (i16 == 5 && z10 && z9) {
                            gy1Var2.f = 3;
                        }
                    } else {
                        gy1Var2.f = z10 ? 4 : 5;
                    }
                } else {
                    z2 = false;
                }
                if (!z7 && gy1Var2.f == 3 && (gy1Var = this.g) != null) {
                    ?? r1 = gy1Var.a;
                    int size3 = r1.size();
                    ?? r4 = gy1Var2.a;
                    if (size3 != r4.size()) {
                        z3 = z8;
                        break;
                    }
                    int size4 = r4.size();
                    ?? r5 = z2;
                    while (true) {
                        if (r5 >= size4) {
                            z3 = z2;
                            break;
                        }
                        if (!jp1.b(((ny1) r1.get(r5)).c, ((ny1) r4.get(r5)).c)) {
                            z3 = z8;
                            break;
                        }
                        r5++;
                    }
                } else {
                    z3 = z8;
                    break;
                }
                this.g = gy1Var2;
                return z3;
            }
        }
        return true;
    }

    @Override // defpackage.ho1
    public final void b(l11 l11Var) {
        super.b(l11Var);
        gy1 gy1Var = this.g;
        if (gy1Var == null) {
            return;
        }
        this.h = this.i;
        List list = gy1Var.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ny1 ny1Var = (ny1) list.get(i);
            boolean z = ny1Var.d;
            long j = ny1Var.a;
            boolean zG = l11Var.g(j);
            boolean z2 = this.i;
            if ((!z && !zG) || (!z && !z2)) {
                this.d.n(j);
            }
        }
        this.i = false;
        this.j = gy1Var.f == 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [pm1] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [pm1] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r8v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [dk1] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [dk1] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void c() {
        pm1 pm1Var = this.a;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((xn1) objArr[i2]).c();
        }
        ?? B = this.c;
        ?? pm1Var2 = 0;
        while (B != 0) {
            if (B instanceof qy1) {
                ((qy1) B).h0();
            } else if ((B.c & 16) != 0 && (B instanceof zb0)) {
                dk1 dk1Var = ((zb0) B).H;
                int i3 = 0;
                pm1Var2 = pm1Var2;
                B = B;
                while (dk1Var != null) {
                    if ((dk1Var.c & 16) != 0) {
                        i3++;
                        pm1Var2 = pm1Var2;
                        if (i3 == 1) {
                            B = dk1Var;
                        } else {
                            if (pm1Var2 == 0) {
                                pm1Var2 = new pm1(new dk1[16]);
                            }
                            if (B != 0) {
                                pm1Var2.b(B);
                                B = 0;
                            }
                            pm1Var2.b(dk1Var);
                        }
                    }
                    dk1Var = dk1Var.i;
                    pm1Var2 = pm1Var2;
                    B = B;
                }
                if (i3 == 1) {
                }
            }
            B = cm4.b(pm1Var2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean d(l11 l11Var) {
        if1 if1Var = this.e;
        boolean z = false;
        z = false;
        if (if1Var.f() != 0) {
            dk1 dk1Var = this.c;
            if (dk1Var.w) {
                gy1 gy1Var = this.g;
                gy1Var.getClass();
                co1 co1Var = this.f;
                co1Var.getClass();
                long j = co1Var.c;
                ?? B = dk1Var;
                ?? pm1Var = 0;
                while (B != 0) {
                    if (B instanceof qy1) {
                        ((qy1) B).H(gy1Var, hy1.c, j);
                    } else if ((B.c & 16) != 0 && (B instanceof zb0)) {
                        dk1 dk1Var2 = ((zb0) B).H;
                        int i = 0;
                        B = B;
                        pm1Var = pm1Var;
                        while (dk1Var2 != null) {
                            if ((dk1Var2.c & 16) != 0) {
                                i++;
                                pm1Var = pm1Var;
                                if (i == 1) {
                                    B = dk1Var2;
                                } else {
                                    if (pm1Var == 0) {
                                        pm1Var = new pm1(new dk1[16]);
                                    }
                                    if (B != 0) {
                                        pm1Var.b(B);
                                        B = 0;
                                    }
                                    pm1Var.b(dk1Var2);
                                }
                            }
                            dk1Var2 = dk1Var2.i;
                            B = B;
                            pm1Var = pm1Var;
                        }
                        if (i == 1) {
                        }
                    }
                    B = cm4.b(pm1Var);
                }
                if (dk1Var.w) {
                    pm1 pm1Var2 = this.a;
                    Object[] objArr = pm1Var2.a;
                    int i2 = pm1Var2.c;
                    for (int i3 = 0; i3 < i2; i3++) {
                        ((xn1) objArr[i3]).d(l11Var);
                    }
                }
                z = true;
            }
        }
        b(l11Var);
        if1Var.a();
        this.f = null;
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [dk1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [dk1] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [dk1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [pm1] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r6v10, types: [dk1] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [pm1] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [pm1] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public final boolean e(l11 l11Var, boolean z) {
        if (this.e.f() == 0) {
            return false;
        }
        ?? B = this.c;
        if (!B.w) {
            return false;
        }
        gy1 gy1Var = this.g;
        gy1Var.getClass();
        co1 co1Var = this.f;
        co1Var.getClass();
        long j = co1Var.c;
        ?? B2 = B;
        ?? pm1Var = 0;
        while (B2 != 0) {
            if (B2 instanceof qy1) {
                ((qy1) B2).H(gy1Var, hy1.a, j);
            } else if ((B2.c & 16) != 0 && (B2 instanceof zb0)) {
                dk1 dk1Var = ((zb0) B2).H;
                int i = 0;
                B2 = B2;
                pm1Var = pm1Var;
                while (dk1Var != null) {
                    if ((dk1Var.c & 16) != 0) {
                        i++;
                        pm1Var = pm1Var;
                        if (i == 1) {
                            B2 = dk1Var;
                        } else {
                            if (pm1Var == 0) {
                                pm1Var = new pm1(new dk1[16]);
                            }
                            if (B2 != 0) {
                                pm1Var.b(B2);
                                B2 = 0;
                            }
                            pm1Var.b(dk1Var);
                        }
                    }
                    dk1Var = dk1Var.i;
                    B2 = B2;
                    pm1Var = pm1Var;
                }
                if (i == 1) {
                }
            }
            B2 = cm4.b(pm1Var);
        }
        if (B.w) {
            pm1 pm1Var2 = this.a;
            Object[] objArr = pm1Var2.a;
            int i2 = pm1Var2.c;
            for (int i3 = 0; i3 < i2; i3++) {
                xn1 xn1Var = (xn1) objArr[i3];
                this.f.getClass();
                xn1Var.e(l11Var, z);
            }
        }
        if (B.w) {
            ?? pm1Var3 = 0;
            while (B != 0) {
                if (B instanceof qy1) {
                    ((qy1) B).H(gy1Var, hy1.b, j);
                } else if ((B.c & 16) != 0 && (B instanceof zb0)) {
                    dk1 dk1Var2 = ((zb0) B).H;
                    int i4 = 0;
                    B = B;
                    pm1Var3 = pm1Var3;
                    while (dk1Var2 != null) {
                        if ((dk1Var2.c & 16) != 0) {
                            i4++;
                            pm1Var3 = pm1Var3;
                            if (i4 == 1) {
                                B = dk1Var2;
                            } else {
                                if (pm1Var3 == 0) {
                                    pm1Var3 = new pm1(new dk1[16]);
                                }
                                if (B != 0) {
                                    pm1Var3.b(B);
                                    B = 0;
                                }
                                pm1Var3.b(dk1Var2);
                            }
                        }
                        dk1Var2 = dk1Var2.i;
                        B = B;
                        pm1Var3 = pm1Var3;
                    }
                    if (i4 == 1) {
                    }
                }
                B = cm4.b(pm1Var3);
            }
        }
        return true;
    }

    public final void f(long j, yl1 yl1Var) {
        c10 c10Var = this.d;
        if (c10Var.d(j) && yl1Var.g(this) < 0) {
            c10Var.n(j);
            this.e.e(j);
        }
        pm1 pm1Var = this.a;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((xn1) objArr[i2]).f(j, yl1Var);
        }
    }

    public final String toString() {
        return "Node(modifierNode=" + this.c + ", children=" + this.a + ", pointerIds=" + this.d + ')';
    }
}
