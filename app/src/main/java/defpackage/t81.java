package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t81 {
    public final gm1 a;
    public t9 b;
    public final hm1 c;
    public final ArrayList d;
    public final ArrayList e;
    public final ArrayList f;
    public final ArrayList g;
    public final ArrayList h;
    public final ek1 i;

    public t81() {
        long[] jArr = ya2.a;
        this.a = new gm1();
        hm1 hm1Var = za2.a;
        this.c = new hm1();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new q81(this);
    }

    public static int e(int[] iArr, y91 y91Var) {
        y91Var.getClass();
        int i = iArr[0] + y91Var.l;
        iArr[0] = i;
        return Math.max(0, i);
    }

    public final long a() {
        ArrayList arrayList = this.h;
        if (arrayList.size() <= 0) {
            return 0L;
        }
        ky0.x(arrayList.get(0));
        throw null;
    }

    public final void b(int i, int i2, ArrayList arrayList, t9 t9Var, v91 v91Var, boolean z, boolean z2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        hm1 hm1Var;
        t9 t9Var2 = this.b;
        this.b = t9Var;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            y91 y91Var = (y91) arrayList.get(i8);
            int size2 = y91Var.b.size();
            for (int i9 = 0; i9 < size2; i9++) {
                ((zw1) y91Var.b.get(i9)).k();
            }
        }
        gm1 gm1Var = this.a;
        if (gm1Var.i()) {
            c();
            return;
        }
        boolean z3 = z || !z2;
        Object[] objArr = gm1Var.b;
        long[] jArr = gm1Var.a;
        int length = jArr.length - 2;
        hm1 hm1Var2 = this.c;
        int i10 = 8;
        boolean z4 = z3;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j = jArr[i11];
                hm1 hm1Var3 = hm1Var2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    long j2 = j;
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j2 & 255) < 128) {
                            hm1Var = hm1Var3;
                            hm1Var.a(objArr[(i11 << 3) + i13]);
                        } else {
                            hm1Var = hm1Var3;
                        }
                        j2 >>= 8;
                        i13++;
                        hm1Var3 = hm1Var;
                    }
                    hm1Var2 = hm1Var3;
                    if (i12 != 8) {
                        break;
                    }
                } else {
                    hm1Var2 = hm1Var3;
                }
                if (i11 == length) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        int size3 = arrayList.size();
        for (int i14 = 0; i14 < size3; i14++) {
            y91 y91Var2 = (y91) arrayList.get(i14);
            Object obj = y91Var2.g;
            List list = y91Var2.b;
            hm1Var2.l(obj);
            int size4 = list.size();
            for (int i15 = 0; i15 < size4; i15++) {
                ((zw1) list.get(i15)).k();
            }
            ky0.x(gm1Var.k(y91Var2.g));
        }
        int[] iArr = new int[1];
        ArrayList arrayList2 = this.e;
        ArrayList arrayList3 = this.d;
        if (z4 && t9Var2 != null) {
            if (arrayList3.isEmpty()) {
                i7 = 0;
            } else {
                if (arrayList3.size() > 1) {
                    qz.p(arrayList3, new s81(t9Var2, 2));
                }
                if (arrayList3.size() > 0) {
                    y91 y91Var3 = (y91) arrayList3.get(0);
                    e(iArr, y91Var3);
                    Object objG = gm1Var.g(y91Var3.g);
                    objG.getClass();
                    ky0.x(objG);
                    y91Var3.a(0);
                    throw null;
                }
                i7 = 0;
                Arrays.fill(iArr, 0, 1, 0);
            }
            if (!arrayList2.isEmpty()) {
                if (arrayList2.size() > 1) {
                    qz.p(arrayList2, new s81(t9Var2, i7));
                }
                if (arrayList2.size() > 0) {
                    y91 y91Var4 = (y91) arrayList2.get(i7);
                    e(iArr, y91Var4);
                    Object objG2 = gm1Var.g(y91Var4.g);
                    objG2.getClass();
                    ky0.x(objG2);
                    y91Var4.a(i7);
                    throw null;
                }
                Arrays.fill(iArr, i7, 1, i7);
            }
        }
        Object[] objArr2 = hm1Var2.b;
        long[] jArr2 = hm1Var2.a;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i16 = 0;
            while (true) {
                long j3 = jArr2[i16];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i17 = 8 - ((~(i16 - length2)) >>> 31);
                    int i18 = 0;
                    while (i18 < i17) {
                        if ((j3 & 255) < 128) {
                            ky0.x(gm1Var.g(objArr2[(i16 << 3) + i18]));
                        }
                        j3 >>= i10;
                        i18++;
                        i10 = i10;
                    }
                    i6 = i10;
                    if (i17 != i6) {
                        break;
                    }
                } else {
                    i6 = i10;
                }
                if (i16 == length2) {
                    break;
                }
                i16++;
                i10 = i6;
            }
        }
        ArrayList arrayList4 = this.f;
        if (arrayList4.isEmpty()) {
            i5 = 1;
        } else {
            if (arrayList4.size() > 1) {
                qz.p(arrayList4, new s81(t9Var, 3));
            }
            int size5 = arrayList4.size();
            for (int i19 = 0; i19 < size5; i19++) {
                y91 y91Var5 = (y91) arrayList4.get(i19);
                Object objG3 = gm1Var.g(y91Var5.g);
                objG3.getClass();
                ky0.x(objG3);
                y91Var5.c((z ? (int) (4294967295L & ((y91) mz.x(arrayList)).a(0)) : 0) - e(iArr, y91Var5), i, i2);
                if (z4) {
                    d(y91Var5, true);
                    throw null;
                }
            }
            i5 = 1;
            Arrays.fill(iArr, 0, 1, 0);
        }
        ArrayList arrayList5 = this.g;
        if (!arrayList5.isEmpty()) {
            if (arrayList5.size() > i5) {
                qz.p(arrayList5, new s81(t9Var, i5));
            }
            int size6 = arrayList5.size();
            for (int i20 = 0; i20 < size6; i20++) {
                y91 y91Var6 = (y91) arrayList5.get(i20);
                Object objG4 = gm1Var.g(y91Var6.g);
                objG4.getClass();
                ky0.x(objG4);
                y91Var6.c((0 - y91Var6.l) + e(iArr, y91Var6), i, i2);
                if (z4) {
                    d(y91Var6, true);
                    throw null;
                }
            }
        }
        Collections.reverse(arrayList4);
        arrayList.addAll(0, arrayList4);
        arrayList.addAll(arrayList5);
        arrayList3.clear();
        arrayList2.clear();
        arrayList4.clear();
        arrayList5.clear();
        hm1Var2.b();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x004a A[LOOP:0: B:7:0x0013->B:18:0x004a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:22:0x004d A[EDGE_INSN: B:22:0x004d->B:19:0x004d BREAK  A[LOOP:0: B:7:0x0013->B:18:0x004a], SYNTHETIC] */
    public final void c() {
        gm1 gm1Var = this.a;
        if (gm1Var.j()) {
            Object[] objArr = gm1Var.c;
            long[] jArr = gm1Var.a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                ky0.x(objArr[(i << 3) + i3]);
                                throw null;
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            gm1Var.a();
        }
    }

    public final void d(y91 y91Var, boolean z) {
        Object objG = this.a.g(y91Var.g);
        objG.getClass();
        ky0.x(objG);
        throw null;
    }
}
