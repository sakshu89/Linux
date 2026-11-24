package defpackage;

import android.os.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g30 implements z20 {
    public mk2 H;
    public kv1 X;
    public g30 Y;
    public int Z;
    public final a30 a;
    public final b43 b;
    public final q82 c0;
    public final i52 d0;
    public final x20 e0;
    public final jm1 f;
    public int f0;
    public final ol2 i;
    public final gm1 j;
    public final hm1 k;
    public final hm1 n;
    public final gm1 s;
    public final yw t;
    public final yw u;
    public final gm1 v;
    public gm1 w;
    public boolean x;
    public final AtomicReference c = new AtomicReference(null);
    public final Object e = new Object();

    public g30(a30 a30Var, b43 b43Var) {
        this.a = a30Var;
        this.b = b43Var;
        jm1 jm1Var = new jm1(new hm1());
        this.f = jm1Var;
        ol2 ol2Var = new ol2();
        if (a30Var.d()) {
            ol2Var.t = new ml1();
        }
        if (a30Var.f()) {
            ol2Var.b();
        }
        this.i = ol2Var;
        this.j = tz3.b();
        this.k = new hm1();
        this.n = new hm1();
        this.s = tz3.b();
        yw ywVar = new yw();
        this.t = ywVar;
        yw ywVar2 = new yw();
        this.u = ywVar2;
        this.v = tz3.b();
        this.w = tz3.b();
        q82 q82Var = new q82(a30Var);
        this.c0 = q82Var;
        this.d0 = new i52();
        x20 x20Var = new x20(b43Var, a30Var, ol2Var, jm1Var, ywVar, ywVar2, q82Var, this);
        a30Var.p(x20Var);
        this.e0 = x20Var;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[Catch: all -> 0x004f, LOOP:0: B:11:0x001f->B:23:0x0059, LOOP_END, TryCatch #0 {all -> 0x004f, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0012, B:11:0x001f, B:13:0x002f, B:15:0x003b, B:17:0x0044, B:20:0x0051, B:23:0x0059, B:24:0x005c), top: B:29:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0061 A[EDGE_INSN: B:31:0x0061->B:25:0x0061 BREAK  A[LOOP:0: B:11:0x001f->B:23:0x0059], SYNTHETIC] */
    public final void A(Object obj) {
        synchronized (this.e) {
            try {
                v(obj);
                Object objG = this.s.g(obj);
                if (objG != null) {
                    if (objG instanceof hm1) {
                        hm1 hm1Var = (hm1) objG;
                        Object[] objArr = hm1Var.b;
                        long[] jArr = hm1Var.a;
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
                                            v((qc0) objArr[(i << 3) + i3]);
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
                    } else {
                        v((qc0) objG);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void B(vq0 vq0Var) {
        boolean zI = i();
        q();
        a30 a30Var = this.a;
        if (!zI) {
            a30Var.a(this, vq0Var);
            return;
        }
        x20 x20Var = this.e0;
        x20Var.z = 100;
        x20Var.y = true;
        a30Var.a(this, vq0Var);
        x20Var.s();
    }

    public final void a() {
        this.c.set(null);
        this.t.a.a();
        this.u.a.a();
        jm1 jm1Var = this.f;
        if (jm1Var.a.g()) {
            return;
        }
        i52 i52Var = this.d0;
        try {
            i52Var.g(jm1Var, this.e0.z());
            i52Var.b();
        } finally {
            i52Var.a();
        }
    }

    public final void b(Object obj, boolean z) {
        Object objG = this.j.g(obj);
        if (objG == null) {
            return;
        }
        boolean z2 = objG instanceof hm1;
        s31 s31Var = s31.a;
        hm1 hm1Var = this.k;
        hm1 hm1Var2 = this.n;
        gm1 gm1Var = this.v;
        if (!z2) {
            a42 a42Var = (a42) objG;
            if (tz3.c(gm1Var, obj, a42Var) || a42Var.b(obj) == s31Var) {
                return;
            }
            if (a42Var.g == null || z) {
                hm1Var.a(a42Var);
                return;
            } else {
                hm1Var2.a(a42Var);
                return;
            }
        }
        hm1 hm1Var3 = (hm1) objG;
        Object[] objArr = hm1Var3.b;
        long[] jArr = hm1Var3.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        a42 a42Var2 = (a42) objArr[(i << 3) + i3];
                        if (!tz3.c(gm1Var, obj, a42Var2) && a42Var2.b(obj) != s31Var) {
                            if (a42Var2.g == null || z) {
                                hm1Var.a(a42Var2);
                            } else {
                                hm1Var2.a(a42Var2);
                            }
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:220:0x0122 A[EDGE_INSN: B:220:0x0122->B:215:0x0122 BREAK  A[LOOP:13: B:63:0x0151->B:74:0x0185], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x0185 A[LOOP:13: B:63:0x0151->B:74:0x0185, LOOP_END] */
    public final void c(Set set, boolean z) {
        long j;
        long j2;
        long j3;
        char c;
        long[] jArr;
        long[] jArr2;
        long j4;
        boolean zC;
        long[] jArr3;
        long j5;
        long[] jArr4;
        long[] jArr5;
        long j6;
        boolean zG;
        long[] jArr6;
        long j7;
        long[] jArr7;
        long[] jArr8;
        char c2;
        long j8;
        int i;
        int i2;
        boolean z2 = set instanceof ab2;
        gm1 gm1Var = this.s;
        Object obj = null;
        int i3 = 8;
        if (z2) {
            hm1 hm1Var = ((ab2) set).a;
            Object[] objArr = hm1Var.b;
            long[] jArr9 = hm1Var.a;
            int length = jArr9.length - 2;
            if (length >= 0) {
                int i4 = 0;
                j = 128;
                j2 = 255;
                while (true) {
                    long j9 = jArr9[i4];
                    char c3 = 7;
                    j3 = -9187201950435737472L;
                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8 - ((~(i4 - length)) >>> 31);
                        int i6 = 0;
                        while (i6 < i5) {
                            if ((j9 & 255) < 128) {
                                Object obj2 = objArr[(i4 << 3) + i6];
                                c2 = c3;
                                if (obj2 instanceof a42) {
                                    ((a42) obj2).b(obj);
                                } else {
                                    b(obj2, z);
                                    Object objG = gm1Var.g(obj2);
                                    if (objG != null) {
                                        if (objG instanceof hm1) {
                                            hm1 hm1Var2 = (hm1) objG;
                                            Object[] objArr2 = hm1Var2.b;
                                            long[] jArr10 = hm1Var2.a;
                                            int length2 = jArr10.length - 2;
                                            if (length2 >= 0) {
                                                int i7 = i3;
                                                i = length;
                                                int i8 = 0;
                                                while (true) {
                                                    long j10 = jArr10[i8];
                                                    j8 = j9;
                                                    long[] jArr11 = jArr10;
                                                    if ((((~j10) << c2) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                                        int i10 = 0;
                                                        while (i10 < i9) {
                                                            if ((j10 & 255) < 128) {
                                                                b((qc0) objArr2[(i8 << 3) + i10], z);
                                                            }
                                                            j10 >>= i7;
                                                            i10++;
                                                            jArr9 = jArr9;
                                                        }
                                                        jArr8 = jArr9;
                                                        if (i9 != i7) {
                                                            break;
                                                        }
                                                    } else {
                                                        jArr8 = jArr9;
                                                    }
                                                    if (i8 == length2) {
                                                        break;
                                                    }
                                                    i8++;
                                                    jArr10 = jArr11;
                                                    j9 = j8;
                                                    jArr9 = jArr8;
                                                    i7 = 8;
                                                }
                                            }
                                        } else {
                                            jArr8 = jArr9;
                                            j8 = j9;
                                            i = length;
                                            b((qc0) objG, z);
                                        }
                                    }
                                    i2 = 8;
                                }
                                jArr8 = jArr9;
                                j8 = j9;
                                i = length;
                                i2 = 8;
                            } else {
                                jArr8 = jArr9;
                                c2 = c3;
                                j8 = j9;
                                i = length;
                                i2 = i3;
                            }
                            j9 = j8 >> i2;
                            i6++;
                            length = i;
                            i3 = i2;
                            c3 = c2;
                            jArr9 = jArr8;
                            obj = null;
                        }
                        jArr7 = jArr9;
                        c = c3;
                        int i11 = length;
                        if (i5 != i3) {
                            break;
                        } else {
                            length = i11;
                        }
                    } else {
                        jArr7 = jArr9;
                        c = 7;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    jArr9 = jArr7;
                    obj = null;
                    i3 = 8;
                }
            } else {
                j = 128;
                j2 = 255;
                j3 = -9187201950435737472L;
                c = 7;
            }
        } else {
            j = 128;
            j2 = 255;
            j3 = -9187201950435737472L;
            c = 7;
            for (Object obj3 : set) {
                if (obj3 instanceof a42) {
                    ((a42) obj3).b(null);
                } else {
                    b(obj3, z);
                    Object objG2 = gm1Var.g(obj3);
                    if (objG2 != null) {
                        if (objG2 instanceof hm1) {
                            hm1 hm1Var3 = (hm1) objG2;
                            Object[] objArr3 = hm1Var3.b;
                            long[] jArr12 = hm1Var3.a;
                            int length3 = jArr12.length - 2;
                            if (length3 >= 0) {
                                int i12 = 0;
                                while (true) {
                                    long j11 = jArr12[i12];
                                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i12 != length3) {
                                            break;
                                            break;
                                        }
                                        i12++;
                                    } else {
                                        int i13 = 8 - ((~(i12 - length3)) >>> 31);
                                        for (int i14 = 0; i14 < i13; i14++) {
                                            if ((j11 & 255) < 128) {
                                                b((qc0) objArr3[(i12 << 3) + i14], z);
                                            }
                                            j11 >>= 8;
                                        }
                                        if (i13 != 8) {
                                            break;
                                        } else if (i12 != length3) {
                                            break;
                                        } else {
                                            i12++;
                                        }
                                    }
                                }
                            }
                        } else {
                            b((qc0) objG2, z);
                        }
                    }
                }
            }
        }
        gm1 gm1Var2 = this.j;
        hm1 hm1Var4 = this.k;
        if (z) {
            hm1 hm1Var5 = this.n;
            if (hm1Var5.h()) {
                long[] jArr13 = gm1Var2.a;
                int length4 = jArr13.length - 2;
                if (length4 >= 0) {
                    int i15 = 0;
                    while (true) {
                        long j12 = jArr13[i15];
                        if ((((~j12) << c) & j12 & j3) != j3) {
                            int i16 = 8 - ((~(i15 - length4)) >>> 31);
                            int i17 = 0;
                            while (i17 < i16) {
                                if ((j12 & j2) < j) {
                                    int i18 = (i15 << 3) + i17;
                                    Object obj4 = gm1Var2.b[i18];
                                    Object obj5 = gm1Var2.c[i18];
                                    if (obj5 instanceof hm1) {
                                        hm1 hm1Var6 = (hm1) obj5;
                                        Object[] objArr4 = hm1Var6.b;
                                        long[] jArr14 = hm1Var6.a;
                                        int length5 = jArr14.length - 2;
                                        if (length5 >= 0) {
                                            j6 = j12;
                                            int i19 = 0;
                                            while (true) {
                                                long j13 = jArr14[i19];
                                                Object[] objArr5 = objArr4;
                                                long[] jArr15 = jArr14;
                                                if ((((~j13) << c) & j13 & j3) != j3) {
                                                    int i20 = 8 - ((~(i19 - length5)) >>> 31);
                                                    int i21 = 0;
                                                    while (i21 < i20) {
                                                        if ((j13 & j2) < j) {
                                                            jArr6 = jArr13;
                                                            int i22 = (i19 << 3) + i21;
                                                            j7 = j13;
                                                            a42 a42Var = (a42) objArr5[i22];
                                                            if (hm1Var5.c(a42Var) || hm1Var4.c(a42Var)) {
                                                                hm1Var6.m(i22);
                                                            }
                                                        } else {
                                                            jArr6 = jArr13;
                                                            j7 = j13;
                                                        }
                                                        j13 = j7 >> 8;
                                                        i21++;
                                                        jArr13 = jArr6;
                                                    }
                                                    jArr5 = jArr13;
                                                    if (i20 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    jArr5 = jArr13;
                                                }
                                                if (i19 == length5) {
                                                    break;
                                                }
                                                i19++;
                                                objArr4 = objArr5;
                                                jArr14 = jArr15;
                                                jArr13 = jArr5;
                                            }
                                        } else {
                                            jArr5 = jArr13;
                                            j6 = j12;
                                        }
                                        zG = hm1Var6.g();
                                    } else {
                                        jArr5 = jArr13;
                                        j6 = j12;
                                        obj5.getClass();
                                        a42 a42Var2 = (a42) obj5;
                                        zG = hm1Var5.c(a42Var2) || hm1Var4.c(a42Var2);
                                    }
                                    if (zG) {
                                        gm1Var2.l(i18);
                                    }
                                } else {
                                    jArr5 = jArr13;
                                    j6 = j12;
                                }
                                j12 = j6 >> 8;
                                i17++;
                                jArr13 = jArr5;
                            }
                            jArr4 = jArr13;
                            if (i16 != 8) {
                                break;
                            }
                        } else {
                            jArr4 = jArr13;
                        }
                        if (i15 == length4) {
                            break;
                        }
                        i15++;
                        jArr13 = jArr4;
                    }
                }
                hm1Var5.b();
                h();
                return;
            }
        }
        if (hm1Var4.h()) {
            long[] jArr16 = gm1Var2.a;
            int length6 = jArr16.length - 2;
            if (length6 >= 0) {
                int i23 = 0;
                while (true) {
                    long j14 = jArr16[i23];
                    if ((((~j14) << c) & j14 & j3) != j3) {
                        int i24 = 8 - ((~(i23 - length6)) >>> 31);
                        int i25 = 0;
                        while (i25 < i24) {
                            if ((j14 & j2) < j) {
                                int i26 = (i23 << 3) + i25;
                                Object obj6 = gm1Var2.b[i26];
                                Object obj7 = gm1Var2.c[i26];
                                if (obj7 instanceof hm1) {
                                    hm1 hm1Var7 = (hm1) obj7;
                                    Object[] objArr6 = hm1Var7.b;
                                    long[] jArr17 = hm1Var7.a;
                                    int length7 = jArr17.length - 2;
                                    if (length7 >= 0) {
                                        j4 = j14;
                                        int i27 = 0;
                                        while (true) {
                                            long j15 = jArr17[i27];
                                            Object[] objArr7 = objArr6;
                                            long[] jArr18 = jArr17;
                                            if ((((~j15) << c) & j15 & j3) != j3) {
                                                int i28 = 8 - ((~(i27 - length7)) >>> 31);
                                                int i29 = 0;
                                                while (i29 < i28) {
                                                    if ((j15 & j2) < j) {
                                                        jArr3 = jArr16;
                                                        int i30 = (i27 << 3) + i29;
                                                        j5 = j15;
                                                        if (hm1Var4.c((a42) objArr7[i30])) {
                                                            hm1Var7.m(i30);
                                                        }
                                                    } else {
                                                        jArr3 = jArr16;
                                                        j5 = j15;
                                                    }
                                                    j15 = j5 >> 8;
                                                    i29++;
                                                    jArr16 = jArr3;
                                                }
                                                jArr2 = jArr16;
                                                if (i28 != 8) {
                                                    break;
                                                }
                                            } else {
                                                jArr2 = jArr16;
                                            }
                                            if (i27 == length7) {
                                                break;
                                            }
                                            i27++;
                                            objArr6 = objArr7;
                                            jArr17 = jArr18;
                                            jArr16 = jArr2;
                                        }
                                    } else {
                                        jArr2 = jArr16;
                                        j4 = j14;
                                    }
                                    zC = hm1Var7.g();
                                } else {
                                    jArr2 = jArr16;
                                    j4 = j14;
                                    obj7.getClass();
                                    zC = hm1Var4.c((a42) obj7);
                                }
                                if (zC) {
                                    gm1Var2.l(i26);
                                }
                            } else {
                                jArr2 = jArr16;
                                j4 = j14;
                            }
                            j14 = j4 >> 8;
                            i25++;
                            jArr16 = jArr2;
                        }
                        jArr = jArr16;
                        if (i24 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr16;
                    }
                    if (i23 == length6) {
                        break;
                    }
                    i23++;
                    jArr16 = jArr;
                }
            }
            h();
            hm1Var4.b();
        }
    }

    public final void d() {
        synchronized (this.e) {
            try {
                e(this.t);
                o();
            } catch (Throwable th) {
                try {
                    if (!this.f.a.g()) {
                        i52 i52Var = this.d0;
                        try {
                            i52Var.g(this.f, this.e0.z());
                            i52Var.b();
                        } finally {
                            i52Var.a();
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    a();
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:164:0x0136 A[EDGE_INSN: B:164:0x0136->B:82:0x0136 BREAK  A[LOOP:2: B:152:0x00e9->B:80:0x012c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x012c A[Catch: all -> 0x011c, LOOP:2: B:152:0x00e9->B:80:0x012c, LOOP_END, TryCatch #7 {all -> 0x011c, blocks: (B:64:0x00e9, B:66:0x00f8, B:68:0x0102, B:70:0x0108, B:72:0x0118, B:76:0x0121, B:82:0x0136, B:90:0x0158, B:93:0x016b, B:80:0x012c, B:85:0x0140, B:99:0x0189, B:101:0x0195), top: B:152:0x00e9 }] */
    public final void e(yw ywVar) throws Throwable {
        xf xfVar;
        i52 i52Var;
        i52 i52Var2;
        long[] jArr;
        int i;
        long[] jArr2;
        i52 i52Var3;
        long j;
        char c;
        long j2;
        int i2;
        boolean zG;
        long j3;
        yw ywVar2 = this.u;
        x20 x20Var = this.e0;
        e30 e30VarZ = x20Var.z();
        i52 i52Var4 = this.d0;
        i52Var4.g(this.f, e30VarZ);
        try {
            if (ywVar.a.c()) {
                try {
                    if (ywVar2.a.c() && this.X == null) {
                        i52Var4.b();
                    }
                    return;
                } finally {
                    i52Var4.a();
                }
            }
            kv1 kv1Var = this.X;
            if (kv1Var == null || (xfVar = kv1Var.l) == null) {
                xfVar = this.b;
            }
            try {
                Trace.beginSection(xfVar.equals(kv1Var != null ? kv1Var.l : null) ? "Compose:recordChanges" : "Compose:applyChanges");
                try {
                    kv1 kv1Var2 = this.X;
                    if (kv1Var2 == null || (i52Var = kv1Var2.k) == null) {
                        i52Var = i52Var4;
                    }
                    rl2 rl2VarF = this.i.f();
                    int i3 = 0;
                    try {
                        ywVar.a(xfVar, rl2VarF, i52Var, x20Var.z());
                        rl2VarF.e(true);
                        xfVar.e();
                        Trace.endSection();
                        i52Var4.c();
                        i52Var4.d();
                        if (this.x) {
                            Trace.beginSection("Compose:unobserve");
                            try {
                                this.x = false;
                                gm1 gm1Var = this.j;
                                long[] jArr3 = gm1Var.a;
                                int length = jArr3.length - 2;
                                if (length >= 0) {
                                    int i4 = 0;
                                    while (true) {
                                        long j4 = jArr3[i4];
                                        char c2 = 7;
                                        long j5 = -9187201950435737472L;
                                        if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i5 = 8;
                                            int i6 = 8 - ((~(i4 - length)) >>> 31);
                                            int i7 = i3;
                                            while (i7 < i6) {
                                                if ((j4 & 255) < 128) {
                                                    c = c2;
                                                    int i8 = (i4 << 3) + i7;
                                                    j2 = j5;
                                                    Object obj = gm1Var.b[i8];
                                                    Object obj2 = gm1Var.c[i8];
                                                    if (obj2 instanceof hm1) {
                                                        hm1 hm1Var = (hm1) obj2;
                                                        Object[] objArr = hm1Var.b;
                                                        long[] jArr4 = hm1Var.a;
                                                        int i9 = i5;
                                                        int length2 = jArr4.length - 2;
                                                        i = i7;
                                                        jArr2 = jArr3;
                                                        i52Var3 = i52Var4;
                                                        if (length2 >= 0) {
                                                            int i10 = 0;
                                                            while (true) {
                                                                try {
                                                                    long j6 = jArr4[i10];
                                                                    j = j4;
                                                                    long[] jArr5 = jArr4;
                                                                    if ((((~j6) << c) & j6 & j2) == j2) {
                                                                        if (i10 != length2) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i10++;
                                                                        jArr4 = jArr5;
                                                                        j4 = j;
                                                                        i9 = 8;
                                                                    } else {
                                                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                                        for (int i12 = 0; i12 < i11; i12++) {
                                                                            if ((j6 & 255) < 128) {
                                                                                j3 = j6;
                                                                                int i13 = (i10 << 3) + i12;
                                                                                if (!((a42) objArr[i13]).a()) {
                                                                                    hm1Var.m(i13);
                                                                                }
                                                                            } else {
                                                                                j3 = j6;
                                                                            }
                                                                            j6 = j3 >> i9;
                                                                        }
                                                                        if (i11 != i9) {
                                                                            break;
                                                                        }
                                                                        if (i10 != length2) {
                                                                            break;
                                                                        }
                                                                        i10++;
                                                                        jArr4 = jArr5;
                                                                        j4 = j;
                                                                        i9 = 8;
                                                                    }
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    Trace.endSection();
                                                                    throw th;
                                                                }
                                                            }
                                                        } else {
                                                            j = j4;
                                                        }
                                                        zG = hm1Var.g();
                                                    } else {
                                                        i = i7;
                                                        jArr2 = jArr3;
                                                        i52Var3 = i52Var4;
                                                        j = j4;
                                                        obj2.getClass();
                                                        zG = !((a42) obj2).a();
                                                    }
                                                    if (zG) {
                                                        gm1Var.l(i8);
                                                    }
                                                    i2 = 8;
                                                } else {
                                                    i = i7;
                                                    jArr2 = jArr3;
                                                    i52Var3 = i52Var4;
                                                    j = j4;
                                                    c = c2;
                                                    j2 = j5;
                                                    i2 = i5;
                                                }
                                                j4 = j >> i2;
                                                i7 = i + 1;
                                                i5 = i2;
                                                c2 = c;
                                                j5 = j2;
                                                i52Var4 = i52Var3;
                                                jArr3 = jArr2;
                                            }
                                            jArr = jArr3;
                                            i52Var2 = i52Var4;
                                            if (i6 != i5) {
                                                break;
                                            }
                                        } else {
                                            jArr = jArr3;
                                            i52Var2 = i52Var4;
                                        }
                                        if (i4 == length) {
                                            break;
                                        }
                                        i4++;
                                        i52Var4 = i52Var2;
                                        jArr3 = jArr;
                                        i3 = 0;
                                    }
                                } else {
                                    i52Var2 = i52Var4;
                                }
                                h();
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            i52Var2 = i52Var4;
                        }
                        try {
                            if (ywVar2.a.c() && this.X == null) {
                                i52Var2.b();
                            }
                            return;
                        } finally {
                            i52Var2.a();
                        }
                    } catch (Throwable th3) {
                        try {
                            rl2VarF.e(false);
                            throw th3;
                        } catch (Throwable th4) {
                            th = th4;
                            Trace.endSection();
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
        try {
            if (ywVar2.a.c() && this.X == null) {
                i52Var4.b();
            }
            throw th;
        } finally {
            i52Var4.a();
        }
    }

    public final void f() {
        synchronized (this.e) {
            try {
                if (this.u.a.d()) {
                    e(this.u);
                }
            } catch (Throwable th) {
                try {
                    if (!this.f.a.g()) {
                        i52 i52Var = this.d0;
                        try {
                            i52Var.g(this.f, this.e0.z());
                            i52Var.b();
                        } finally {
                            i52Var.a();
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    a();
                    throw th2;
                }
            }
        }
    }

    public final void g() {
        synchronized (this.e) {
            try {
                this.e0.v = null;
                if (!this.f.a.g()) {
                    i52 i52Var = this.d0;
                    try {
                        i52Var.g(this.f, this.e0.z());
                        i52Var.b();
                        i52Var.a();
                    } catch (Throwable th) {
                        i52Var.a();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                try {
                    if (!this.f.a.g()) {
                        i52 i52Var2 = this.d0;
                        try {
                            i52Var2.g(this.f, this.e0.z());
                            i52Var2.b();
                        } finally {
                            i52Var2.a();
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    a();
                    throw th3;
                }
            }
        }
    }

    public final void h() {
        long j;
        char c;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        int i2;
        long j4;
        char c2;
        long j5;
        long j6;
        int i3;
        boolean zG;
        int i4;
        int i5;
        gm1 gm1Var = this.s;
        long[] jArr3 = gm1Var.a;
        int length = jArr3.length - 2;
        long j7 = 255;
        char c3 = 7;
        long j8 = -9187201950435737472L;
        int i6 = 8;
        if (length >= 0) {
            int i7 = 0;
            while (true) {
                long j9 = jArr3[i7];
                j3 = 128;
                if ((((~j9) << c3) & j9 & j8) != j8) {
                    int i8 = 8 - ((~(i7 - length)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j9 & j7) < 128) {
                            j4 = j7;
                            int i10 = (i7 << 3) + i9;
                            Object obj = gm1Var.b[i10];
                            Object obj2 = gm1Var.c[i10];
                            c2 = c3;
                            boolean z = obj2 instanceof hm1;
                            j5 = j8;
                            gm1 gm1Var2 = this.j;
                            if (z) {
                                hm1 hm1Var = (hm1) obj2;
                                Object[] objArr = hm1Var.b;
                                long[] jArr4 = hm1Var.a;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    int i11 = i6;
                                    j6 = j9;
                                    int i12 = 0;
                                    while (true) {
                                        long j10 = jArr4[i12];
                                        jArr2 = jArr3;
                                        i = length;
                                        if ((((~j10) << c2) & j10 & j5) != j5) {
                                            int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                            int i14 = 0;
                                            while (i14 < i13) {
                                                if ((j10 & j4) < 128) {
                                                    i4 = i14;
                                                    int i15 = (i12 << 3) + i4;
                                                    i5 = i9;
                                                    if (!gm1Var2.c((qc0) objArr[i15])) {
                                                        hm1Var.m(i15);
                                                    }
                                                } else {
                                                    i4 = i14;
                                                    i5 = i9;
                                                }
                                                j10 >>= i11;
                                                i14 = i4 + 1;
                                                i9 = i5;
                                            }
                                            i2 = i9;
                                            if (i13 != i11) {
                                                break;
                                            }
                                        } else {
                                            i2 = i9;
                                        }
                                        if (i12 == length2) {
                                            break;
                                        }
                                        i12++;
                                        jArr3 = jArr2;
                                        length = i;
                                        i9 = i2;
                                        i11 = 8;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    i = length;
                                    i2 = i9;
                                    j6 = j9;
                                }
                                zG = hm1Var.g();
                            } else {
                                jArr2 = jArr3;
                                i = length;
                                i2 = i9;
                                j6 = j9;
                                obj2.getClass();
                                zG = !gm1Var2.c((qc0) obj2);
                            }
                            if (zG) {
                                gm1Var.l(i10);
                            }
                            i3 = 8;
                        } else {
                            jArr2 = jArr3;
                            i = length;
                            i2 = i9;
                            j4 = j7;
                            c2 = c3;
                            j5 = j8;
                            j6 = j9;
                            i3 = i6;
                        }
                        j9 = j6 >> i3;
                        i9 = i2 + 1;
                        i6 = i3;
                        c3 = c2;
                        j7 = j4;
                        j8 = j5;
                        jArr3 = jArr2;
                        length = i;
                    }
                    jArr = jArr3;
                    int i16 = length;
                    j = j7;
                    c = c3;
                    j2 = j8;
                    if (i8 != i6) {
                        break;
                    } else {
                        length = i16;
                    }
                } else {
                    jArr = jArr3;
                    j = j7;
                    c = c3;
                    j2 = j8;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                c3 = c;
                j7 = j;
                j8 = j2;
                jArr3 = jArr;
                i6 = 8;
            }
        } else {
            j = 255;
            c = 7;
            j2 = -9187201950435737472L;
            j3 = 128;
        }
        hm1 hm1Var2 = this.n;
        if (!hm1Var2.h()) {
            return;
        }
        Object[] objArr2 = hm1Var2.b;
        long[] jArr5 = hm1Var2.a;
        int length3 = jArr5.length - 2;
        if (length3 < 0) {
            return;
        }
        int i17 = 0;
        while (true) {
            long j11 = jArr5[i17];
            if ((((~j11) << c) & j11 & j2) != j2) {
                int i18 = 8 - ((~(i17 - length3)) >>> 31);
                for (int i19 = 0; i19 < i18; i19++) {
                    if ((j11 & j) < j3) {
                        int i20 = (i17 << 3) + i19;
                        if (((a42) objArr2[i20]).g == null) {
                            hm1Var2.m(i20);
                        }
                    }
                    j11 >>= 8;
                }
                if (i18 != 8) {
                    return;
                }
            }
            if (i17 == length3) {
                return;
            } else {
                i17++;
            }
        }
    }

    public final boolean i() {
        boolean z;
        synchronized (this.e) {
            z = true;
            if (this.f0 != 1) {
                z = false;
            }
            if (z) {
                this.f0 = 0;
            }
        }
        return z;
    }

    public final void j(vq0 vq0Var) {
        try {
            synchronized (this.e) {
                n();
                gm1 gm1Var = this.w;
                this.w = tz3.b();
                try {
                    x20 x20Var = this.e0;
                    mk2 mk2Var = this.H;
                    if (!x20Var.e.a.c()) {
                        y20.a("Expected applyChanges() to have been called");
                    }
                    x20Var.P = mk2Var;
                    try {
                        x20Var.n(gm1Var, vq0Var);
                        x20Var.P = null;
                    } catch (Throwable th) {
                        x20Var.P = null;
                        throw th;
                    }
                } catch (Throwable th2) {
                    this.w = gm1Var;
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                if (!this.f.a.g()) {
                    i52 i52Var = this.d0;
                    try {
                        i52Var.g(this.f, this.e0.z());
                        i52Var.b();
                    } finally {
                        i52Var.a();
                    }
                }
                throw th3;
            } catch (Throwable th4) {
                a();
                throw th4;
            }
        }
    }

    public final kv1 k(boolean z, vq0 vq0Var) {
        if (this.X != null) {
            dz1.b("A pausable composition is in progress");
        }
        kv1 kv1Var = new kv1(this, this.a, this.e0, this.f, vq0Var, z, this.b, this.e);
        this.X = kv1Var;
        return kv1Var;
    }

    public final void l() {
        synchronized (this.e) {
            try {
                if (this.X != null) {
                    dz1.b("Deactivate is not supported while pausable composition is in progress");
                }
                boolean z = this.i.b > 0;
                if (z || !this.f.a.g()) {
                    Trace.beginSection("Compose:deactivate");
                    try {
                        i52 i52Var = this.d0;
                        try {
                            i52Var.g(this.f, this.e0.z());
                            if (z) {
                                rl2 rl2VarF = this.i.f();
                                try {
                                    rl2VarF.n(rl2VarF.t, new km(2, this.d0, rl2VarF));
                                    rl2VarF.e(true);
                                    this.b.e();
                                    i52Var.c();
                                } catch (Throwable th) {
                                    rl2VarF.e(false);
                                    throw th;
                                }
                            }
                            i52Var.b();
                            i52Var.a();
                            Trace.endSection();
                        } catch (Throwable th2) {
                            i52Var.a();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
                this.j.a();
                this.s.a();
                this.w.a();
                this.t.a.a();
                this.u.a.a();
                x20 x20Var = this.e0;
                x20Var.E.clear();
                x20Var.s.clear();
                x20Var.e.a.a();
                x20Var.v = null;
                this.f0 = 1;
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public final void m() {
        synchronized (this.e) {
            try {
                if (this.e0.F) {
                    dz1.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (this.f0 != 3) {
                    this.f0 = 3;
                    yw ywVar = this.e0.L;
                    if (ywVar != null) {
                        e(ywVar);
                    }
                    int i = 1;
                    boolean z = this.i.b > 0;
                    if (z || !this.f.a.g()) {
                        i52 i52Var = this.d0;
                        try {
                            i52Var.g(this.f, this.e0.z());
                            if (z) {
                                rl2 rl2VarF = this.i.f();
                                try {
                                    rl2VarF.n(rl2VarF.t, new ha(i, this.d0));
                                    rl2VarF.H();
                                    rl2VarF.e(true);
                                    this.b.k();
                                    this.b.e();
                                    i52Var.c();
                                } catch (Throwable th) {
                                    rl2VarF.e(false);
                                    throw th;
                                }
                            }
                            i52Var.b();
                            i52Var.a();
                        } catch (Throwable th2) {
                            i52Var.a();
                            throw th2;
                        }
                    }
                    x20 x20Var = this.e0;
                    x20Var.getClass();
                    Trace.beginSection("Compose:Composer.dispose");
                    try {
                        x20Var.b.u(x20Var);
                        x20Var.E.clear();
                        x20Var.s.clear();
                        x20Var.e.a.a();
                        x20Var.v = null;
                        x20Var.a.k();
                        Trace.endSection();
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        this.a.v(this);
    }

    public final void n() {
        AtomicReference atomicReference = this.c;
        Object obj = ky3.a;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            if (andSet.equals(obj)) {
                y20.b("pending composition has not been applied");
                og.k();
                return;
            }
            if (andSet instanceof Set) {
                c((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                y20.b("corrupt pendingModifications drain: " + atomicReference);
                og.k();
                return;
            }
            for (Set set : (Set[]) andSet) {
                c(set, true);
            }
        }
    }

    public final void o() {
        AtomicReference atomicReference = this.c;
        Object andSet = atomicReference.getAndSet(null);
        if (g31.a(andSet, ky3.a)) {
            return;
        }
        if (andSet instanceof Set) {
            c((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                c(set, false);
            }
            return;
        }
        if (andSet == null) {
            if (this.X == null) {
                y20.a("calling recordModificationsOf and applyChanges concurrently is not supported");
            }
        } else {
            y20.b("corrupt pendingModifications drain: " + atomicReference);
            og.k();
        }
    }

    public final void p() {
        mi0 mi0Var = mi0.a;
        AtomicReference atomicReference = this.c;
        Object andSet = atomicReference.getAndSet(mi0Var);
        if (g31.a(andSet, ky3.a) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            c((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            y20.b("corrupt pendingModifications drain: " + atomicReference);
            og.k();
            return;
        }
        for (Set set : (Set[]) andSet) {
            c(set, false);
        }
    }

    public final void q() {
        String str;
        int i = this.f0;
        if (i != 0) {
            if (i == 1) {
                str = "The composition should be activated before setting content.";
            } else if (i != 2) {
                str = i != 3 ? "" : "The composition is disposed";
            } else {
                str = "A previous pausable composition for this composition was cancelled. This composition must be disposed.";
            }
            dz1.b(str);
        }
        if (this.X == null) {
            return;
        }
        dz1.b("A pausable composition is in progress");
    }

    public final void r(ArrayList arrayList) {
        jm1 jm1Var = this.f;
        x20 x20Var = this.e0;
        if (arrayList.size() > 0) {
            ((bl1) ((wt1) arrayList.get(0)).a).getClass();
            y20.a("Check failed");
        }
        try {
            x20Var.getClass();
            try {
                x20Var.B(arrayList);
                x20Var.i();
            } catch (Throwable th) {
                x20Var.a();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                if (!jm1Var.a.g()) {
                    i52 i52Var = this.d0;
                    try {
                        i52Var.g(jm1Var, x20Var.z());
                        i52Var.b();
                    } finally {
                        i52Var.a();
                    }
                }
                throw th2;
            } catch (Throwable th3) {
                a();
                throw th3;
            }
        }
    }

    public final s31 s(a42 a42Var, Object obj) {
        g30 g30Var;
        int i = a42Var.b;
        if ((i & 2) != 0) {
            a42Var.b = i | 4;
        }
        j6 j6Var = a42Var.c;
        if (j6Var == null || !j6Var.a()) {
            return s31.a;
        }
        if (this.i.g(j6Var)) {
            if (a42Var.d == null) {
                return s31.a;
            }
            s31 s31VarU = u(a42Var, j6Var, obj);
            if (s31VarU != s31.a) {
                this.c0.w();
            }
            return s31VarU;
        }
        synchronized (this.e) {
            g30Var = this.Y;
        }
        if (g30Var != null) {
            x20 x20Var = g30Var.e0;
            if (x20Var.F && x20Var.b0(a42Var, obj)) {
                return s31.e;
            }
        }
        return s31.a;
    }

    public final void t() {
        g30 g30Var;
        synchronized (this.e) {
            try {
                for (Object obj : this.i.c) {
                    a42 a42Var = obj instanceof a42 ? (a42) obj : null;
                    if (a42Var != null && (g30Var = a42Var.a) != null) {
                        g30Var.s(a42Var, null);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca A[Catch: all -> 0x0042, LOOP:0: B:48:0x0089->B:62:0x00ca, LOOP_END, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x000b, B:6:0x0010, B:8:0x0018, B:10:0x001f, B:14:0x0029, B:16:0x002f, B:13:0x0024, B:25:0x0047, B:27:0x004d, B:32:0x0058, B:36:0x005e, B:37:0x0067, B:40:0x006d, B:41:0x0073, B:43:0x0079, B:45:0x007d, B:48:0x0089, B:50:0x0099, B:52:0x00a5, B:54:0x00af, B:58:0x00be, B:62:0x00ca, B:63:0x00cd, B:66:0x00d2), top: B:79:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00d2 A[Catch: all -> 0x0042, EDGE_INSN: B:66:0x00d2->B:67:0x00d7 BREAK  A[LOOP:0: B:48:0x0089->B:62:0x00ca], TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x000b, B:6:0x0010, B:8:0x0018, B:10:0x001f, B:14:0x0029, B:16:0x002f, B:13:0x0024, B:25:0x0047, B:27:0x004d, B:32:0x0058, B:36:0x005e, B:37:0x0067, B:40:0x006d, B:41:0x0073, B:43:0x0079, B:45:0x007d, B:48:0x0089, B:50:0x0099, B:52:0x00a5, B:54:0x00af, B:58:0x00be, B:62:0x00ca, B:63:0x00cd, B:66:0x00d2), top: B:79:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:82:0x00d2 A[SYNTHETIC] */
    public final s31 u(a42 a42Var, j6 j6Var, Object obj) {
        synchronized (this.e) {
            try {
                g30 g30Var = this.Y;
                g30 g30Var2 = null;
                if (g30Var != null) {
                    ol2 ol2Var = this.i;
                    int i = this.Z;
                    if (ol2Var.j) {
                        y20.a("Writer is active");
                    }
                    if (i < 0 || i >= ol2Var.b) {
                        y20.a("Invalid group index");
                    }
                    if (ol2Var.g(j6Var)) {
                        int i2 = ol2Var.a[(i * 5) + 3] + i;
                        int i3 = j6Var.a;
                        if (i > i3 || i3 >= i2) {
                            g30Var = null;
                        }
                    } else {
                        g30Var = null;
                    }
                    g30Var2 = g30Var;
                }
                if (g30Var2 == null) {
                    x20 x20Var = this.e0;
                    if (!(x20Var.F && x20Var.b0(a42Var, obj))) {
                        if (obj != null) {
                            boolean z = obj instanceof qc0;
                            gm1 gm1Var = this.w;
                            if (z) {
                                Object objG = gm1Var.g(a42Var);
                                if (objG != null) {
                                    if (!(objG instanceof hm1)) {
                                        if (objG != fl4.k) {
                                            tz3.a(this.w, a42Var, obj);
                                            break;
                                        }
                                    } else {
                                        hm1 hm1Var = (hm1) objG;
                                        Object[] objArr = hm1Var.b;
                                        long[] jArr = hm1Var.a;
                                        int length = jArr.length - 2;
                                        if (length < 0) {
                                            tz3.a(this.w, a42Var, obj);
                                            break;
                                        }
                                        int i4 = 0;
                                        loop0: while (true) {
                                            long j = jArr[i4];
                                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                                if (i4 == length) {
                                                    tz3.a(this.w, a42Var, obj);
                                                    break;
                                                }
                                                i4++;
                                            } else {
                                                int i5 = 8;
                                                int i6 = 8 - ((~(i4 - length)) >>> 31);
                                                int i7 = 0;
                                                while (i7 < i6) {
                                                    if ((j & 255) < 128 && objArr[(i4 << 3) + i7] == fl4.k) {
                                                        break loop0;
                                                    }
                                                    j >>= i5;
                                                    i7++;
                                                    i5 = i5;
                                                }
                                                if (i6 == i5) {
                                                    if (i4 == length) {
                                                        i4++;
                                                    }
                                                }
                                                tz3.a(this.w, a42Var, obj);
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    tz3.a(this.w, a42Var, obj);
                                    break;
                                }
                            } else {
                                gm1Var.m(a42Var, fl4.k);
                            }
                        } else {
                            this.w.m(a42Var, fl4.k);
                        }
                    } else {
                        return s31.e;
                    }
                }
                if (g30Var2 != null) {
                    return g30Var2.u(a42Var, j6Var, obj);
                }
                this.a.l(this);
                return this.e0.F ? s31.c : s31.b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v(Object obj) {
        Object objG = this.j.g(obj);
        if (objG == null) {
            return;
        }
        boolean z = objG instanceof hm1;
        s31 s31Var = s31.e;
        gm1 gm1Var = this.v;
        if (!z) {
            a42 a42Var = (a42) objG;
            if (a42Var.b(obj) == s31Var) {
                tz3.a(gm1Var, obj, a42Var);
                return;
            }
            return;
        }
        hm1 hm1Var = (hm1) objG;
        Object[] objArr = hm1Var.b;
        long[] jArr = hm1Var.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        a42 a42Var2 = (a42) objArr[(i << 3) + i3];
                        if (a42Var2.b(obj) == s31Var) {
                            tz3.a(gm1Var, obj, a42Var2);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x005b A[LOOP:0: B:7:0x001c->B:21:0x005b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x007b A[SYNTHETIC] */
    public final boolean w(Set set) {
        boolean z = set instanceof ab2;
        gm1 gm1Var = this.s;
        gm1 gm1Var2 = this.j;
        if (z) {
            hm1 hm1Var = ((ab2) set).a;
            Object[] objArr = hm1Var.b;
            long[] jArr = hm1Var.a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i3];
                                if (gm1Var2.c(obj) || gm1Var.c(obj)) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 == 8) {
                            if (i != length) {
                                i++;
                            }
                        }
                    } else if (i != length) {
                        i++;
                    }
                }
                return true;
            }
        } else {
            for (Object obj2 : set) {
                if (gm1Var2.c(obj2) || gm1Var.c(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean x() {
        synchronized (this.e) {
            kv1 kv1Var = this.X;
            boolean zD = false;
            if (kv1Var != null && (kv1Var.h.get() != mv1.f || kv1Var.i != tc4.a())) {
                AtomicReference atomicReference = kv1Var.h;
                mv1 mv1Var = mv1.i;
                mv1 mv1Var2 = mv1.e;
                while (!atomicReference.compareAndSet(mv1Var, mv1Var2) && atomicReference.get() == mv1Var) {
                }
                kv1Var.l.a.a(9);
                return false;
            }
            n();
            try {
                gm1 gm1Var = this.w;
                this.w = tz3.b();
                try {
                    x20 x20Var = this.e0;
                    mk2 mk2Var = this.H;
                    bs1 bs1Var = x20Var.e.a;
                    if (!bs1Var.c()) {
                        y20.a("Expected applyChanges() to have been called");
                    }
                    if (gm1Var.e > 0 || !x20Var.s.isEmpty()) {
                        x20Var.P = mk2Var;
                        try {
                            x20Var.n(gm1Var, null);
                            x20Var.P = null;
                            zD = bs1Var.d();
                        } catch (Throwable th) {
                            x20Var.P = null;
                            throw th;
                        }
                    }
                    if (!zD) {
                        o();
                    }
                    return zD;
                } catch (Throwable th2) {
                    this.w = gm1Var;
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    if (!this.f.a.g()) {
                        i52 i52Var = this.d0;
                        try {
                            i52Var.g(this.f, this.e0.z());
                            i52Var.b();
                        } finally {
                            i52Var.a();
                        }
                    }
                    throw th3;
                } catch (Throwable th4) {
                    a();
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(ab2 ab2Var) {
        Object obj;
        while (true) {
            Object obj2 = this.c.get();
            if (obj2 == null || obj2.equals(ky3.a)) {
                obj = ab2Var;
            } else if (obj2 instanceof Set) {
                obj = new Set[]{obj2, ab2Var};
            } else {
                if (!(obj2 instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.c).toString());
                }
                Set[] setArr = (Set[]) obj2;
                int length = setArr.length;
                Object[] objArrCopyOf = Arrays.copyOf(setArr, length + 1);
                objArrCopyOf[length] = ab2Var;
                obj = objArrCopyOf;
            }
            AtomicReference atomicReference = this.c;
            do {
                if (atomicReference.compareAndSet(obj2, obj)) {
                    if (obj2 == null) {
                        synchronized (this.e) {
                            o();
                        }
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c5 A[LOOP:0: B:30:0x0077->B:45:0x00c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c8 A[EDGE_INSN: B:52:0x00c8->B:46:0x00c8 BREAK  A[LOOP:0: B:30:0x0077->B:45:0x00c5], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public final void z(Object obj) {
        a42 a42VarX;
        int i;
        boolean z;
        x20 x20Var = this.e0;
        if (x20Var.A <= 0 && (a42VarX = x20Var.x()) != null) {
            int i2 = a42VarX.b | 1;
            a42VarX.b = i2;
            if ((i2 & 32) == 0) {
                ul1 ul1Var = a42VarX.f;
                if (ul1Var == null) {
                    ul1Var = new ul1();
                    a42VarX.f = ul1Var;
                }
                int i3 = a42VarX.e;
                int iC = ul1Var.c(obj);
                if (iC < 0) {
                    iC = ~iC;
                    i = -1;
                } else {
                    i = ul1Var.c[iC];
                }
                ul1Var.b[iC] = obj;
                ul1Var.c[iC] = i3;
                if (i == a42VarX.e) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            this.c0.w();
            if (z) {
                return;
            }
            if (obj instanceof or2) {
                ((or2) obj).f(1);
            }
            tz3.a(this.j, obj, a42VarX);
            if (obj instanceof qc0) {
                qc0 qc0Var = (qc0) obj;
                pc0 pc0VarH = qc0Var.h();
                gm1 gm1Var = this.s;
                tz3.d(gm1Var, obj);
                ul1 ul1Var2 = pc0VarH.e;
                Object[] objArr = ul1Var2.b;
                long[] jArr = ul1Var2.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i4 = 0;
                    while (true) {
                        long j = jArr[i4];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i4 != length) {
                                break;
                                break;
                            }
                            i4++;
                        } else {
                            int i5 = 8;
                            int i6 = 8 - ((~(i4 - length)) >>> 31);
                            int i7 = 0;
                            while (i7 < i6) {
                                if ((j & 255) < 128) {
                                    nr2 nr2Var = (nr2) objArr[(i4 << 3) + i7];
                                    if (nr2Var instanceof or2) {
                                        ((or2) nr2Var).f(1);
                                    }
                                    tz3.a(gm1Var, nr2Var, obj);
                                }
                                j >>= i5;
                                i7++;
                                i5 = i5;
                            }
                            if (i6 != i5) {
                                break;
                            } else if (i4 != length) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                }
                Object obj2 = pc0VarH.f;
                gm1 gm1Var2 = a42VarX.g;
                if (gm1Var2 == null) {
                    gm1Var2 = new gm1();
                    a42VarX.g = gm1Var2;
                }
                gm1Var2.m(qc0Var, obj2);
            }
        }
    }
}
