package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class lm1 extends bm2 {
    public static final int[] n = new int[0];
    public final hq0 e;
    public final hq0 f;
    public int g;
    public hm1 h;
    public ArrayList i;
    public gm2 j;
    public int[] k;
    public int l;
    public boolean m;

    public lm1(long j, gm2 gm2Var, hq0 hq0Var, hq0 hq0Var2) {
        super(j, gm2Var);
        this.e = hq0Var;
        this.f = hq0Var2;
        this.j = gm2.f;
        this.k = n;
        this.l = 1;
    }

    public final void A(long j) {
        synchronized (im2.c) {
            this.j = this.j.g(j);
        }
    }

    public void B(hm1 hm1Var) {
        this.h = hm1Var;
    }

    public lm1 C(hq0 hq0Var, hq0 hq0Var2) {
        dn1 dn1Var;
        if (this.c) {
            dz1.a("Cannot use a disposed snapshot");
        }
        if (this.m && this.d < 0) {
            dz1.b("Unsupported operation on a disposed or applied snapshot");
        }
        A(g());
        Object obj = im2.c;
        synchronized (obj) {
            long j = im2.e;
            im2.e = j + 1;
            im2.d = im2.d.g(j);
            gm2 gm2VarD = d();
            r(gm2VarD.g(j));
            dn1Var = new dn1(j, im2.d(gm2VarD, g() + 1, j), im2.k(hq0Var, e(), true), im2.l(hq0Var2, i()), this);
        }
        if (this.m || this.c) {
            return dn1Var;
        }
        long jG = g();
        synchronized (obj) {
            long j2 = im2.e;
            im2.e = j2 + 1;
            s(j2);
            im2.d = im2.d.g(g());
        }
        r(im2.d(d(), jG + 1, g()));
        return dn1Var;
    }

    @Override // defpackage.bm2
    public final void b() {
        im2.d = im2.d.b(g()).a(this.j);
    }

    @Override // defpackage.bm2
    public void c() {
        if (this.c) {
            return;
        }
        this.c = true;
        synchronized (im2.c) {
            o();
        }
        l();
    }

    @Override // defpackage.bm2
    public boolean f() {
        return false;
    }

    @Override // defpackage.bm2
    public int h() {
        return this.g;
    }

    @Override // defpackage.bm2
    public hq0 i() {
        return this.f;
    }

    @Override // defpackage.bm2
    public void k() {
        this.l++;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007d  */
    /* JADX WARN: Code duplicated, block: B:34:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x008e A[LOOP:0: B:18:0x0039->B:35:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x0091 A[EDGE_INSN: B:39:0x0091->B:36:0x0091 BREAK  A[LOOP:0: B:18:0x0039->B:35:0x008e], SYNTHETIC] */
    @Override // defpackage.bm2
    public void l() {
        if (this.l <= 0) {
            dz1.a("no pending nested snapshots");
        }
        int i = this.l - 1;
        this.l = i;
        if (i != 0 || this.m) {
            return;
        }
        hm1 hm1VarX = x();
        if (hm1VarX != null) {
            if (this.m) {
                dz1.b("Unsupported operation on a snapshot that has been applied");
            }
            B(null);
            long jG = g();
            Object[] objArr = hm1VarX.b;
            long[] jArr = hm1VarX.a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i2 != length) {
                            break;
                            break;
                        }
                        i2++;
                    } else {
                        int i3 = 8 - ((~(i2 - length)) >>> 31);
                        for (int i4 = 0; i4 < i3; i4++) {
                            if ((255 & j) < 128) {
                                for (qr2 qr2VarA = ((nr2) objArr[(i2 << 3) + i4]).a(); qr2VarA != null; qr2VarA = qr2VarA.b) {
                                    long j2 = qr2VarA.a;
                                    if (j2 != jG) {
                                        if (mz.s(Long.valueOf(j2), this.j)) {
                                            sa2 sa2Var = im2.a;
                                            qr2VarA.a = 0L;
                                        }
                                    } else {
                                        sa2 sa2Var2 = im2.a;
                                        qr2VarA.a = 0L;
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i3 != 8) {
                            break;
                        } else if (i2 != length) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        a();
    }

    @Override // defpackage.bm2
    public void m() {
        if (this.m || this.c) {
            return;
        }
        v();
    }

    @Override // defpackage.bm2
    public void n(nr2 nr2Var) {
        hm1 hm1VarX = x();
        if (hm1VarX == null) {
            hm1 hm1Var = za2.a;
            hm1VarX = new hm1();
            B(hm1VarX);
        }
        hm1VarX.a(nr2Var);
    }

    @Override // defpackage.bm2
    public final void p() {
        int length = this.k.length;
        for (int i = 0; i < length; i++) {
            im2.u(this.k[i]);
        }
        o();
    }

    @Override // defpackage.bm2
    public void t(int i) {
        this.g = i;
    }

    @Override // defpackage.bm2
    public bm2 u(hq0 hq0Var) {
        en1 en1Var;
        if (this.c) {
            dz1.a("Cannot use a disposed snapshot");
        }
        if (this.m && this.d < 0) {
            dz1.b("Unsupported operation on a disposed or applied snapshot");
        }
        long jG = g();
        A(g());
        Object obj = im2.c;
        synchronized (obj) {
            long j = im2.e;
            im2.e = j + 1;
            im2.d = im2.d.g(j);
            en1Var = new en1(j, im2.d(d(), jG + 1, j), im2.k(hq0Var, e(), true), this);
        }
        if (this.m || this.c) {
            return en1Var;
        }
        long jG2 = g();
        synchronized (obj) {
            long j2 = im2.e;
            im2.e = j2 + 1;
            s(j2);
            im2.d = im2.d.g(g());
        }
        r(im2.d(d(), jG2 + 1, g()));
        return en1Var;
    }

    public final void v() {
        A(g());
        if (this.m || this.c) {
            return;
        }
        long jG = g();
        synchronized (im2.c) {
            long j = im2.e;
            im2.e = j + 1;
            s(j);
            im2.d = im2.d.g(g());
        }
        r(im2.d(d(), jG + 1, g()));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x014a A[EDGE_INSN: B:101:0x014a->B:77:0x014a BREAK  A[LOOP:4: B:66:0x011b->B:76:0x0147], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0108 A[Catch: all -> 0x00fe, LOOP:2: B:48:0x00d6->B:60:0x0108, LOOP_END, TryCatch #1 {all -> 0x00fe, blocks: (B:43:0x00ba, B:45:0x00ca, B:48:0x00d6, B:50:0x00e2, B:52:0x00ec, B:54:0x00f2, B:57:0x0100, B:63:0x0111, B:66:0x011b, B:68:0x0125, B:70:0x012f, B:72:0x0135, B:73:0x013f, B:76:0x0147, B:77:0x014a, B:79:0x014e, B:81:0x0155, B:82:0x0161, B:60:0x0108), top: B:91:0x00ba }] */
    /* JADX WARN: Code duplicated, block: B:61:0x010b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0145 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0147 A[Catch: all -> 0x00fe, LOOP:4: B:66:0x011b->B:76:0x0147, LOOP_END, TryCatch #1 {all -> 0x00fe, blocks: (B:43:0x00ba, B:45:0x00ca, B:48:0x00d6, B:50:0x00e2, B:52:0x00ec, B:54:0x00f2, B:57:0x0100, B:63:0x0111, B:66:0x011b, B:68:0x0125, B:70:0x012f, B:72:0x0135, B:73:0x013f, B:76:0x0147, B:77:0x014a, B:79:0x014e, B:81:0x0155, B:82:0x0161, B:60:0x0108), top: B:91:0x00ba }] */
    /* JADX WARN: Code duplicated, block: B:96:0x010f A[EDGE_INSN: B:96:0x010f->B:62:0x010f BREAK  A[LOOP:2: B:48:0x00d6->B:60:0x0108], SYNTHETIC] */
    public k44 w() {
        HashMap mapB;
        List list;
        hm1 hm1Var;
        long j;
        long j2;
        hm1 hm1VarX = x();
        if (hm1VarX != null) {
            long j3 = im2.j.b;
            mapB = im2.b(j3, this, im2.d.b(j3));
        } else {
            mapB = null;
        }
        ii0 ii0Var = ii0.a;
        synchronized (im2.c) {
            try {
                im2.c(this);
                if (hm1VarX == null || hm1VarX.d == 0) {
                    b();
                    hu0 hu0Var = im2.j;
                    hm1 hm1Var2 = hu0Var.h;
                    im2.v(hu0Var, im2.a);
                    if (hm1Var2 == null || !hm1Var2.h()) {
                        list = ii0Var;
                        hm1Var = null;
                    } else {
                        list = im2.h;
                        hm1Var = hm1Var2;
                    }
                } else {
                    hu0 hu0Var2 = im2.j;
                    k44 k44VarZ = z(im2.e, hm1VarX, mapB, im2.d.b(hu0Var2.b));
                    if (!k44VarZ.equals(dm2.a)) {
                        return k44VarZ;
                    }
                    b();
                    hm1Var = hu0Var2.h;
                    im2.v(hu0Var2, im2.a);
                    B(null);
                    hu0Var2.h = null;
                    list = im2.h;
                }
                this.m = true;
                if (hm1Var != null) {
                    ab2 ab2Var = new ab2(hm1Var);
                    if (!hm1Var.g()) {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ((vq0) list.get(i)).e(ab2Var, this);
                        }
                    }
                }
                if (hm1VarX != null && hm1VarX.h()) {
                    ab2 ab2Var2 = new ab2(hm1VarX);
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((vq0) list.get(i2)).e(ab2Var2, this);
                    }
                }
                synchronized (im2.c) {
                    try {
                        p();
                        im2.f();
                        if (hm1Var != null) {
                            Object[] objArr = hm1Var.b;
                            long[] jArr = hm1Var.a;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                j = 128;
                                while (true) {
                                    long j4 = jArr[i3];
                                    j2 = 255;
                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i3 != length) {
                                            break;
                                            break;
                                        }
                                        i3++;
                                    } else {
                                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                                        for (int i5 = 0; i5 < i4; i5++) {
                                            if ((j4 & 255) < 128) {
                                                im2.q((nr2) objArr[(i3 << 3) + i5]);
                                            }
                                            j4 >>= 8;
                                        }
                                        if (i4 != 8) {
                                            break;
                                        }
                                        if (i3 != length) {
                                            break;
                                        }
                                        i3++;
                                    }
                                }
                            } else {
                                j = 128;
                                j2 = 255;
                            }
                        } else {
                            j = 128;
                            j2 = 255;
                        }
                        if (hm1VarX != null) {
                            Object[] objArr2 = hm1VarX.b;
                            long[] jArr2 = hm1VarX.a;
                            int length2 = jArr2.length - 2;
                            if (length2 >= 0) {
                                int i6 = 0;
                                while (true) {
                                    long j5 = jArr2[i6];
                                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i6 != length2) {
                                            break;
                                            break;
                                        }
                                        i6++;
                                    } else {
                                        int i7 = 8 - ((~(i6 - length2)) >>> 31);
                                        for (int i8 = 0; i8 < i7; i8++) {
                                            if ((j5 & j2) < j) {
                                                im2.q((nr2) objArr2[(i6 << 3) + i8]);
                                            }
                                            j5 >>= 8;
                                        }
                                        if (i7 != 8) {
                                            break;
                                        }
                                        if (i6 != length2) {
                                            break;
                                        }
                                        i6++;
                                    }
                                }
                            }
                        }
                        ArrayList arrayList = this.i;
                        if (arrayList != null) {
                            int size3 = arrayList.size();
                            for (int i9 = 0; i9 < size3; i9++) {
                                im2.q((nr2) arrayList.get(i9));
                            }
                        }
                        this.i = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return dm2.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public hm1 x() {
        return this.h;
    }

    @Override // defpackage.bm2
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public hq0 e() {
        return this.e;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0171  */
    /* JADX WARN: Code duplicated, block: B:69:0x017b  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a7 A[LOOP:3: B:79:0x01a5->B:80:0x01a7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:84:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:88:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final k44 z(long j, hm1 hm1Var, HashMap map, gm2 gm2Var) {
        ArrayList arrayList;
        ArrayList arrayListG;
        ArrayList arrayList2;
        int size;
        int i;
        ArrayList arrayList3;
        int size2;
        int i2;
        nr2 nr2Var;
        qr2 qr2Var;
        gm2 gm2Var2;
        Object[] objArr;
        long[] jArr;
        gm2 gm2Var3;
        Object[] objArr2;
        long[] jArr2;
        int i3;
        long j2;
        ArrayList arrayList4;
        qr2 qr2VarB;
        gm2 gm2VarF = d().g(g()).f(this.j);
        Object[] objArr3 = hm1Var.b;
        long[] jArr3 = hm1Var.a;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i4 = 0;
            arrayList2 = null;
            arrayListG = null;
            while (true) {
                long j3 = jArr3[i4];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j3 & 255) < 128) {
                            objArr2 = objArr3;
                            nr2 nr2Var2 = (nr2) objArr3[(i4 << 3) + i6];
                            jArr2 = jArr3;
                            qr2 qr2VarA = nr2Var2.a();
                            i3 = i6;
                            ArrayList arrayList5 = arrayList2;
                            qr2 qr2VarS = im2.s(qr2VarA, j, gm2Var);
                            if (qr2VarS == null) {
                                arrayList4 = arrayListG;
                                j2 = j3;
                            } else {
                                arrayList4 = arrayListG;
                                j2 = j3;
                                qr2 qr2VarS2 = im2.s(qr2VarA, g(), gm2VarF);
                                if (qr2VarS2 != null && qr2VarS2.a != 1 && !qr2VarS.equals(qr2VarS2)) {
                                    gm2Var3 = gm2VarF;
                                    qr2 qr2VarS3 = im2.s(qr2VarA, g(), d());
                                    if (qr2VarS3 == null) {
                                        im2.r();
                                        throw null;
                                    }
                                    if (map == null || (qr2VarB = (qr2) map.get(qr2VarS)) == null) {
                                        qr2VarB = nr2Var2.b(qr2VarS2, qr2VarS, qr2VarS3);
                                    }
                                    if (qr2VarB == null) {
                                        return new cm2(this);
                                    }
                                    if (!qr2VarB.equals(qr2VarS3)) {
                                        if (qr2VarB.equals(qr2VarS)) {
                                            ArrayList arrayList6 = arrayList5 == null ? new ArrayList() : arrayList5;
                                            arrayList6.add(new wt1(nr2Var2, qr2VarS.b(g())));
                                            arrayListG = arrayList4 == null ? new ArrayList() : arrayList4;
                                            arrayListG.add(nr2Var2);
                                            arrayList2 = arrayList6;
                                        } else {
                                            arrayList2 = arrayList5 == null ? new ArrayList() : arrayList5;
                                            arrayList2.add(!qr2VarB.equals(qr2VarS2) ? new wt1(nr2Var2, qr2VarB) : new wt1(nr2Var2, qr2VarS2.b(g())));
                                        }
                                    }
                                    arrayListG = arrayList4;
                                }
                                arrayList2 = arrayList5;
                                arrayListG = arrayList4;
                            }
                            gm2Var3 = gm2VarF;
                            arrayList2 = arrayList5;
                            arrayListG = arrayList4;
                        } else {
                            gm2Var3 = gm2VarF;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i3 = i6;
                            j2 = j3;
                        }
                        j3 = j2 >> 8;
                        i6 = i3 + 1;
                        jArr3 = jArr2;
                        objArr3 = objArr2;
                        gm2VarF = gm2Var3;
                    }
                    gm2Var2 = gm2VarF;
                    objArr = objArr3;
                    jArr = jArr3;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    gm2Var2 = gm2VarF;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                if (i4 != length) {
                    i4++;
                    jArr3 = jArr;
                    objArr3 = objArr;
                    gm2VarF = gm2Var2;
                } else {
                    arrayList = arrayList2;
                }
            }
            if (arrayList2 != null) {
                v();
                size2 = arrayList2.size();
                for (i2 = 0; i2 < size2; i2++) {
                    wt1 wt1Var = (wt1) arrayList2.get(i2);
                    nr2Var = (nr2) wt1Var.a;
                    qr2Var = (qr2) wt1Var.b;
                    qr2Var.a = j;
                    synchronized (im2.c) {
                        qr2Var.b = nr2Var.a();
                        nr2Var.d(qr2Var);
                    }
                }
            }
            if (arrayListG != null) {
                size = arrayListG.size();
                for (i = 0; i < size; i++) {
                    hm1Var.l((nr2) arrayListG.get(i));
                }
                arrayList3 = this.i;
                if (arrayList3 != null) {
                    arrayListG = mz.G(arrayList3, arrayListG);
                }
                this.i = arrayListG;
            }
            return dm2.a;
        }
        arrayList = null;
        arrayListG = null;
        arrayList2 = arrayList;
        if (arrayList2 != null) {
            v();
            size2 = arrayList2.size();
            while (i2 < size2) {
                wt1 wt1Var2 = (wt1) arrayList2.get(i2);
                nr2Var = (nr2) wt1Var2.a;
                qr2Var = (qr2) wt1Var2.b;
                qr2Var.a = j;
                synchronized (im2.c) {
                    qr2Var.b = nr2Var.a();
                    nr2Var.d(qr2Var);
                }
            }
        }
        if (arrayListG != null) {
            size = arrayListG.size();
            while (i < size) {
                hm1Var.l((nr2) arrayListG.get(i));
            }
            arrayList3 = this.i;
            if (arrayList3 != null) {
                arrayListG = mz.G(arrayList3, arrayListG);
            }
            this.i = arrayListG;
        }
        return dm2.a;
    }
}
