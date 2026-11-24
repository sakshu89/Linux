package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z32 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ z32(int i, String str, nb2 nb2Var) {
        this.a = 1;
        this.b = i;
        this.c = str;
        this.e = nb2Var;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a4  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        z20 z20Var;
        long[] jArr;
        z20 z20Var2;
        long[] jArr2;
        int i;
        int i2 = this.a;
        boolean z = true;
        q43 q43Var = q43.a;
        int i3 = 0;
        int i4 = this.b;
        Object obj2 = this.e;
        Object obj3 = this.c;
        switch (i2) {
            case 0:
                a42 a42Var = (a42) obj3;
                ul1 ul1Var = (ul1) obj2;
                z20 z20Var3 = (z20) obj;
                if (a42Var.e == i4 && g31.a(ul1Var, a42Var.f) && (z20Var3 instanceof g30)) {
                    long[] jArr3 = ul1Var.a;
                    int length = jArr3.length - 2;
                    if (length >= 0) {
                        int i5 = 0;
                        while (true) {
                            long j = jArr3[i5];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i6 = 8;
                                int i7 = 8 - ((~(i5 - length)) >>> 31);
                                int i8 = i3;
                                while (i8 < i7) {
                                    if ((255 & j) < 128) {
                                        int i9 = (i5 << 3) + i8;
                                        Object obj4 = ul1Var.b[i9];
                                        boolean z2 = ul1Var.c[i9] != i4;
                                        if (z2) {
                                            i = i6;
                                            g30 g30Var = (g30) z20Var3;
                                            z20Var2 = z20Var3;
                                            gm1 gm1Var = g30Var.j;
                                            tz3.c(gm1Var, obj4, a42Var);
                                            jArr2 = jArr3;
                                            if (obj4 instanceof qc0) {
                                                qc0 qc0Var = (qc0) obj4;
                                                if (!gm1Var.c(qc0Var)) {
                                                    tz3.d(g30Var.s, qc0Var);
                                                }
                                                gm1 gm1Var2 = a42Var.g;
                                                if (gm1Var2 != null) {
                                                    gm1Var2.k(obj4);
                                                }
                                            }
                                        } else {
                                            z20Var2 = z20Var3;
                                            jArr2 = jArr3;
                                            i = i6;
                                        }
                                        if (z2) {
                                            ul1Var.f(i9);
                                        }
                                    } else {
                                        z20Var2 = z20Var3;
                                        jArr2 = jArr3;
                                        i = i6;
                                    }
                                    j >>= i;
                                    i8++;
                                    i6 = i;
                                    z20Var3 = z20Var2;
                                    jArr3 = jArr2;
                                }
                                z20Var = z20Var3;
                                jArr = jArr3;
                                if (i7 == i6) {
                                }
                            } else {
                                z20Var = z20Var3;
                                jArr = jArr3;
                            }
                            if (i5 != length) {
                                i5++;
                                z20Var3 = z20Var;
                                jArr3 = jArr;
                                i3 = 0;
                            }
                        }
                    }
                }
                return q43Var;
            case 1:
                String str = (String) obj3;
                nb2 nb2Var = (nb2) obj2;
                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
                accessibilityNodeInfo.getClass();
                CharSequence packageName = accessibilityNodeInfo.getPackageName();
                if (!g31.a(packageName != null ? packageName.toString() : null, "com.google.android.youtube") || accessibilityNodeInfo.getWindowId() != i4) {
                    z = false;
                } else if (str != null) {
                    nb2Var.getClass();
                    if (!nb2.r(accessibilityNodeInfo, str)) {
                        z = false;
                    }
                }
                return Boolean.valueOf(z);
            case 2:
                id2 id2Var = (id2) obj3;
                zw1 zw1Var = (zw1) obj2;
                yw1 yw1Var = (yw1) obj;
                int iG = id2Var.x.a.g();
                if (iG < 0) {
                    iG = 0;
                }
                if (iG <= i4) {
                    i4 = iG;
                }
                int i10 = -i4;
                boolean z3 = id2Var.H;
                int i11 = z3 ? 0 : i10;
                if (!z3) {
                    i10 = 0;
                }
                yw1Var.a = true;
                yw1.m(yw1Var, zw1Var, i11, i10);
                yw1Var.a = false;
                return q43Var;
            default:
                l73 l73Var = (l73) obj3;
                zw1 zw1Var2 = (zw1) obj2;
                yw1 yw1Var2 = (yw1) obj;
                int i12 = l73Var.b;
                fy2 fy2Var = l73Var.a;
                a23 a23Var = l73Var.c;
                hz2 hz2Var = (hz2) l73Var.d.a();
                fy2Var.a(js1.a, ub4.a(yw1Var2, i12, a23Var, hz2Var != null ? hz2Var.a : null, false, zw1Var2.a), i4, zw1Var2.b);
                yw1.k(yw1Var2, zw1Var2, 0, Math.round(-fy2Var.a.g()));
                return q43Var;
        }
    }

    public /* synthetic */ z32(int i, int i2, Object obj, Object obj2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
        this.e = obj2;
    }

    public /* synthetic */ z32(l73 l73Var, zw1 zw1Var, int i) {
        this.a = 3;
        this.c = l73Var;
        this.e = zw1Var;
        this.b = i;
    }
}
