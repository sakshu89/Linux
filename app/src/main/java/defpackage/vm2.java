package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vm2 {
    public final hq0 a;
    public Object b;
    public ul1 c;
    public boolean j;
    public int k;
    public int d = -1;
    public final gm1 e = tz3.b();
    public final gm1 f = new gm1();
    public final hm1 g = new hm1();
    public final pm1 h = new pm1(new qc0[16]);
    public final w20 i = new w20(1, this);
    public final gm1 l = tz3.b();
    public final HashMap m = new HashMap();

    public vm2(hq0 hq0Var) {
        this.a = hq0Var;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16781. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final boolean a(java.util.Set r46) {
        /*
            Method dump skipped, instruction units count: 1678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vm2.a(java.util.Set):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x008d A[LOOP:0: B:15:0x0048->B:28:0x008d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x0090 A[EDGE_INSN: B:37:0x0090->B:29:0x0090 BREAK  A[LOOP:0: B:15:0x0048->B:28:0x008d], SYNTHETIC] */
    public final void b(Object obj, int i, Object obj2, ul1 ul1Var) {
        int i2;
        if (this.k > 0) {
            return;
        }
        int iC = ul1Var.c(obj);
        if (iC < 0) {
            iC = ~iC;
            i2 = -1;
        } else {
            i2 = ul1Var.c[iC];
        }
        ul1Var.b[iC] = obj;
        ul1Var.c[iC] = i;
        if ((obj instanceof qc0) && i2 != i) {
            pc0 pc0VarH = ((qc0) obj).h();
            this.m.put(obj, pc0VarH.f);
            ul1 ul1Var2 = pc0VarH.e;
            gm1 gm1Var = this.l;
            tz3.d(gm1Var, obj);
            Object[] objArr = ul1Var2.b;
            long[] jArr = ul1Var2.a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i3 = 0;
                while (true) {
                    long j = jArr[i3];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i3 != length) {
                            break;
                            break;
                        }
                        i3++;
                    } else {
                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                        for (int i5 = 0; i5 < i4; i5++) {
                            if ((j & 255) < 128) {
                                nr2 nr2Var = (nr2) objArr[(i3 << 3) + i5];
                                if (nr2Var instanceof or2) {
                                    ((or2) nr2Var).f(2);
                                }
                                tz3.a(gm1Var, nr2Var, obj);
                            }
                            j >>= 8;
                        }
                        if (i4 != 8) {
                            break;
                        } else if (i3 != length) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
        if (i2 == -1) {
            if (obj instanceof or2) {
                ((or2) obj).f(2);
            }
            tz3.a(this.e, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00cb  */
    public final void c() {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean z;
        Object obj;
        long j3;
        Object obj2;
        gm1 gm1Var = this.f;
        long[] jArr3 = gm1Var.a;
        int length = jArr3.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j4 = jArr3[i2];
            char c2 = 7;
            long j5 = -9187201950435737472L;
            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((j4 & 255) < 128) {
                        int i6 = (i2 << 3) + i5;
                        c = c2;
                        Object obj3 = gm1Var.b[i6];
                        j2 = j5;
                        ul1 ul1Var = (ul1) gm1Var.c[i6];
                        obj3.getClass();
                        boolean zY = ((jt1) obj3).y();
                        if (zY) {
                            jArr2 = jArr3;
                            j = j4;
                            z = zY;
                        } else {
                            Object[] objArr = ul1Var.b;
                            int[] iArr = ul1Var.c;
                            long[] jArr4 = ul1Var.a;
                            int i7 = i3;
                            int length2 = jArr4.length - 2;
                            if (length2 >= 0) {
                                jArr2 = jArr3;
                                j = j4;
                                int i8 = 0;
                                while (true) {
                                    long j6 = jArr4[i8];
                                    long[] jArr5 = jArr4;
                                    z = zY;
                                    if ((((~j6) << c) & j6 & j2) != j2) {
                                        int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                        int i10 = 0;
                                        while (i10 < i9) {
                                            if ((j6 & 255) < 128) {
                                                int i11 = (i8 << 3) + i10;
                                                j3 = j6;
                                                Object obj4 = objArr[i11];
                                                int i12 = iArr[i11];
                                                gm1 gm1Var2 = this.e;
                                                tz3.c(gm1Var2, obj4, obj3);
                                                obj2 = obj3;
                                                if ((obj4 instanceof qc0) && !gm1Var2.c(obj4)) {
                                                    tz3.d(this.l, obj4);
                                                    this.m.remove(obj4);
                                                }
                                            } else {
                                                j3 = j6;
                                                obj2 = obj3;
                                            }
                                            j6 = j3 >> i7;
                                            i10++;
                                            obj3 = obj2;
                                        }
                                        obj = obj3;
                                        if (i9 != i7) {
                                            break;
                                        }
                                    } else {
                                        obj = obj3;
                                    }
                                    if (i8 == length2) {
                                        break;
                                    }
                                    i8++;
                                    zY = z;
                                    jArr4 = jArr5;
                                    obj3 = obj;
                                    i7 = 8;
                                }
                            } else {
                                jArr2 = jArr3;
                                j = j4;
                                z = zY;
                            }
                        }
                        if (!z) {
                            gm1Var.l(i6);
                        }
                        i = 8;
                    } else {
                        jArr2 = jArr3;
                        j = j4;
                        c = c2;
                        j2 = j5;
                        i = i3;
                    }
                    i5++;
                    i3 = i;
                    j4 = j >> i;
                    c2 = c;
                    j5 = j2;
                    jArr3 = jArr2;
                }
                jArr = jArr3;
                if (i4 != i3) {
                    return;
                }
            } else {
                jArr = jArr3;
            }
            if (i2 == length) {
                return;
            }
            i2++;
            jArr3 = jArr;
        }
    }
}
