package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q8 implements ta0, View.OnAttachStateChangeListener {
    public final r7 a;
    public final g7 b;
    public l11 c;
    public final ArrayList e = new ArrayList();
    public final long f = 100;
    public n8 i = n8.a;
    public boolean j = true;
    public final un k = nh4.a(1, 6, null);
    public final Handler n = new Handler(Looper.getMainLooper());
    public ml1 s;
    public long t;
    public final ml1 u;
    public hg2 v;
    public boolean w;
    public final s7 x;

    public q8(r7 r7Var, g7 g7Var) {
        this.a = r7Var;
        this.b = g7Var;
        ml1 ml1Var = d21.a;
        ml1Var.getClass();
        this.s = ml1Var;
        this.u = new ml1();
        this.v = new hg2(r7Var.getSemanticsOwner().a(), ml1Var);
        this.x = new s7(1, this);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0046 A[PHI: r1
      0x0046: PHI (r1v3 pn) = (r1v1 pn), (r1v2 pn), (r1v5 pn) binds: [B:16:0x0039, B:29:0x007c, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0051 A[PHI: r1 r8
      0x0051: PHI (r1v2 pn) = (r1v3 pn), (r1v4 pn) binds: [B:18:0x004e, B:15:0x0033] A[DONT_GENERATE, DONT_INLINE]
      0x0051: PHI (r8v3 java.lang.Object) = (r8v10 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x004e, B:15:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0059  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:0x0069  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007c -> B:17:0x0046). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(defpackage.y50 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof defpackage.p8
            if (r0 == 0) goto L13
            r0 = r8
            p8 r0 = (defpackage.p8) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            p8 r0 = new p8
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f
            int r1 = r0.j
            r2 = 2
            r3 = 1
            t70 r4 = defpackage.t70.a
            if (r1 == 0) goto L39
            if (r1 == r3) goto L33
            if (r1 != r2) goto L2c
            pn r1 = r0.e
            defpackage.bz3.g(r8)
            goto L46
        L2c:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r7)
            r7 = 0
            return r7
        L33:
            pn r1 = r0.e
            defpackage.bz3.g(r8)
            goto L51
        L39:
            defpackage.bz3.g(r8)
            un r8 = r7.k
            r8.getClass()
            pn r1 = new pn
            r1.<init>(r8)
        L46:
            r0.e = r1
            r0.j = r3
            java.lang.Object r8 = r1.b(r0)
            if (r8 != r4) goto L51
            goto L7e
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L7f
            r1.c()
            boolean r8 = r7.d()
            if (r8 == 0) goto L65
            r7.e()
        L65:
            boolean r8 = r7.w
            if (r8 != 0) goto L72
            r7.w = r3
            android.os.Handler r8 = r7.n
            s7 r5 = r7.x
            r8.post(r5)
        L72:
            r0.e = r1
            r0.j = r2
            long r5 = r7.f
            java.lang.Object r8 = defpackage.bm4.b(r5, r0)
            if (r8 != r4) goto L46
        L7e:
            return r4
        L7f:
            q43 r7 = defpackage.q43.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q8.a(y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0173 A[EDGE_INSN: B:105:0x0173->B:80:0x0173 BREAK  A[LOOP:4: B:48:0x00e9->B:79:0x016c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00cb A[LOOP:2: B:21:0x006f->B:42:0x00cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x016a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x016c A[LOOP:4: B:48:0x00e9->B:79:0x016c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:99:0x00d4 A[EDGE_INSN: B:99:0x00d4->B:44:0x00d4 BREAK  A[LOOP:2: B:21:0x006f->B:42:0x00cb], SYNTHETIC] */
    public final void b(c21 c21Var) {
        int[] iArr;
        int[] iArr2;
        long j;
        char c;
        long j2;
        int i;
        int i2;
        long j3;
        long j4;
        c21 c21Var2 = c21Var;
        int[] iArr3 = c21Var2.b;
        long[] jArr = c21Var2.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j5 = jArr[i3];
            char c2 = 7;
            long j6 = -9187201950435737472L;
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j5 & 255) < 128) {
                        int i7 = iArr3[(i3 << 3) + i6];
                        c = c2;
                        hg2 hg2Var = (hg2) this.u.b(i7);
                        ig2 ig2Var = (ig2) c21Var2.b(i7);
                        gg2 gg2Var = ig2Var != null ? ig2Var.a : null;
                        if (gg2Var == null) {
                            throw cq.e("no value for specified key");
                        }
                        j2 = j6;
                        int i8 = gg2Var.g;
                        gm1 gm1Var = gg2Var.d.a;
                        if (hg2Var == null) {
                            Object[] objArr = gm1Var.b;
                            long[] jArr2 = gm1Var.a;
                            int length2 = jArr2.length - 2;
                            iArr2 = iArr3;
                            if (length2 >= 0) {
                                int i9 = i4;
                                int i10 = 0;
                                while (true) {
                                    long j7 = jArr2[i10];
                                    j = j5;
                                    if ((((~j7) << c) & j7 & j2) != j2) {
                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                        for (int i12 = 0; i12 < i11; i12++) {
                                            if ((j7 & 255) < 128) {
                                                j4 = j7;
                                                ng2 ng2Var = (ng2) objArr[(i10 << 3) + i12];
                                                ng2 ng2Var2 = kg2.A;
                                                if (g31.a(ng2Var, ng2Var2)) {
                                                    Object objG = gm1Var.g(ng2Var2);
                                                    if (objG == null) {
                                                        objG = null;
                                                    }
                                                    List list = (List) objG;
                                                    g(i8, String.valueOf(list != null ? (be) mz.y(list) : null));
                                                }
                                            } else {
                                                j4 = j7;
                                            }
                                            j7 = j4 >> i9;
                                        }
                                        if (i11 != i9) {
                                            break;
                                        }
                                        if (i10 != length2) {
                                            break;
                                        }
                                        i10++;
                                        j5 = j;
                                        i9 = 8;
                                    } else if (i10 != length2) {
                                        break;
                                        break;
                                    } else {
                                        i10++;
                                        j5 = j;
                                        i9 = 8;
                                    }
                                }
                            } else {
                                j = j5;
                            }
                        } else {
                            iArr2 = iArr3;
                            j = j5;
                            Object[] objArr2 = gm1Var.b;
                            long[] jArr3 = gm1Var.a;
                            int length3 = jArr3.length - 2;
                            if (length3 >= 0) {
                                long[] jArr4 = jArr3;
                                int i13 = 0;
                                while (true) {
                                    long j8 = jArr4[i13];
                                    long[] jArr5 = jArr4;
                                    i = i6;
                                    if ((((~j8) << c) & j8 & j2) != j2) {
                                        int i14 = 8 - ((~(i13 - length3)) >>> 31);
                                        int i15 = 0;
                                        while (i15 < i14) {
                                            if ((j8 & 255) < 128) {
                                                j3 = j8;
                                                ng2 ng2Var3 = (ng2) objArr2[(i13 << 3) + i15];
                                                ng2 ng2Var4 = kg2.A;
                                                if (g31.a(ng2Var3, ng2Var4)) {
                                                    Object objG2 = hg2Var.a.a.g(ng2Var4);
                                                    if (objG2 == null) {
                                                        objG2 = null;
                                                    }
                                                    List list2 = (List) objG2;
                                                    be beVar = list2 != null ? (be) mz.y(list2) : null;
                                                    Object objG3 = gm1Var.g(ng2Var4);
                                                    if (objG3 == null) {
                                                        objG3 = null;
                                                    }
                                                    List list3 = (List) objG3;
                                                    be beVar2 = list3 != null ? (be) mz.y(list3) : null;
                                                    if (!g31.a(beVar, beVar2)) {
                                                        g(i8, String.valueOf(beVar2));
                                                    }
                                                }
                                            } else {
                                                j3 = j8;
                                            }
                                            i15++;
                                            j8 = j3 >> 8;
                                        }
                                        if (i14 != 8) {
                                            break;
                                        }
                                        if (i13 != length3) {
                                            break;
                                        }
                                        i13++;
                                        i6 = i;
                                        jArr4 = jArr5;
                                    } else if (i13 != length3) {
                                        break;
                                        break;
                                    } else {
                                        i13++;
                                        i6 = i;
                                        jArr4 = jArr5;
                                    }
                                }
                            }
                            i2 = 8;
                        }
                        i = i6;
                        i2 = 8;
                    } else {
                        iArr2 = iArr3;
                        j = j5;
                        c = c2;
                        j2 = j6;
                        i = i6;
                        i2 = i4;
                    }
                    j5 = j >> i2;
                    i6 = i + 1;
                    i4 = i2;
                    c2 = c;
                    j6 = j2;
                    iArr3 = iArr2;
                    c21Var2 = c21Var;
                }
                iArr = iArr3;
                if (i5 != i4) {
                    return;
                }
            } else {
                iArr = iArr3;
            }
            if (i3 == length) {
                return;
            }
            i3++;
            c21Var2 = c21Var;
            iArr3 = iArr;
        }
    }

    public final c21 c() {
        if (this.j) {
            this.j = false;
            this.s = o44.c(this.a.getSemanticsOwner(), j7.i);
            this.t = System.currentTimeMillis();
        }
        return this.s;
    }

    public final boolean d() {
        return this.c != null;
    }

    public final void e() {
        l11 l11Var = this.c;
        if (l11Var == null) {
            return;
        }
        Object obj = l11Var.c;
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        ArrayList arrayList = this.e;
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d50 d50Var = (d50) arrayList.get(i);
            int iOrdinal = d50Var.c.ordinal();
            if (iOrdinal == 0) {
                py0 py0Var = d50Var.d;
                if (py0Var != null) {
                    ViewStructure viewStructure = (ViewStructure) py0Var.b;
                    if (Build.VERSION.SDK_INT >= 29) {
                        f50.d(t6.d(obj), viewStructure);
                    }
                }
            } else {
                if (iOrdinal != 1) {
                    dk0.l();
                    return;
                }
                AutofillId autofillIdB = l11Var.B(d50Var.a);
                if (autofillIdB != null && Build.VERSION.SDK_INT >= 29) {
                    f50.e(t6.d(obj), autofillIdB);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            f50.g(t6.d(obj), ((View) l11Var.b).getAutofillId(), new long[]{Long.MIN_VALUE});
        }
        arrayList.clear();
    }

    public final void f(gg2 gg2Var, hg2 hg2Var) {
        i8 i8Var = new i8(1, hg2Var, this);
        gg2Var.getClass();
        List listI = gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0);
        int size = listI.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = listI.get(i2);
            if (c().a(((gg2) obj).g)) {
                i8Var.e(Integer.valueOf(i), obj);
                i++;
            }
        }
        List listI2 = gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0);
        int size2 = listI2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            gg2 gg2Var2 = (gg2) listI2.get(i3);
            c21 c21VarC = c();
            int i4 = gg2Var2.g;
            if (c21VarC.a(i4)) {
                ml1 ml1Var = this.u;
                if (ml1Var.a(i4)) {
                    Object objB = ml1Var.b(i4);
                    if (objB == null) {
                        throw cq.e("node not present in pruned tree before this change");
                    }
                    f(gg2Var2, (hg2) objB);
                } else {
                    continue;
                }
            }
        }
    }

    public final void g(int i, String str) {
        l11 l11Var;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29 && (l11Var = this.c) != null) {
            AutofillId autofillIdB = l11Var.B(i);
            if (autofillIdB == null) {
                throw cq.e("Invalid content capture ID");
            }
            if (i2 >= 29) {
                f50.f(t6.d(l11Var.c), autofillIdB, str);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0187  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    public final void h(int i, gg2 gg2Var) {
        hq0 hq0Var;
        int i2;
        l42 l42VarA;
        py0 py0Var;
        hq0 hq0Var2;
        if (d()) {
            gm1 gm1Var = gg2Var.d.a;
            Object objG = gm1Var.g(kg2.C);
            if (objG == null) {
                objG = null;
            }
            Boolean bool = (Boolean) objG;
            if (this.i == n8.a && g31.a(bool, Boolean.TRUE)) {
                Object objG2 = gm1Var.g(bg2.m);
                if (objG2 == null) {
                    objG2 = null;
                }
                b2 b2Var = (b2) objG2;
                if (b2Var != null && (hq0Var2 = (hq0) b2Var.b) != null) {
                }
            } else if (this.i == n8.b && g31.a(bool, Boolean.FALSE)) {
                Object objG3 = gm1Var.g(bg2.m);
                if (objG3 == null) {
                    objG3 = null;
                }
                b2 b2Var2 = (b2) objG3;
                if (b2Var2 != null && (hq0Var = (hq0) b2Var2.b) != null) {
                }
            }
            int i3 = gg2Var.g;
            l11 l11Var = this.c;
            if (l11Var != null && (i2 = Build.VERSION.SDK_INT) >= 29) {
                AutofillId autofillId = this.a.getAutofillId();
                gg2 gg2VarL = gg2Var.l();
                int i4 = gg2Var.g;
                if (gg2VarL == null || (autofillId = l11Var.B(gg2VarL.g)) != null) {
                    py0 py0Var2 = i2 >= 29 ? new py0(23, f50.c(t6.d(l11Var.c), autofillId, i4)) : null;
                    if (py0Var2 == null) {
                        py0Var = null;
                    } else {
                        ViewStructure viewStructure = (ViewStructure) py0Var2.b;
                        cg2 cg2Var = gg2Var.d;
                        ng2 ng2Var = kg2.J;
                        gm1 gm1Var2 = cg2Var.a;
                        if (gm1Var2.c(ng2Var)) {
                            py0Var = null;
                        } else {
                            Bundle extras = viewStructure.getExtras();
                            if (extras != null) {
                                extras.putLong("android.view.contentcapture.EventTimestamp", this.t);
                                extras.putInt("android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX", i);
                            }
                            Object objG4 = gm1Var2.g(kg2.y);
                            if (objG4 == null) {
                                objG4 = null;
                            }
                            String str = (String) objG4;
                            if (str != null) {
                                viewStructure.setId(i4, null, null, str);
                            }
                            Object objG5 = gm1Var2.g(kg2.m);
                            if (objG5 == null) {
                                objG5 = null;
                            }
                            if (((Boolean) objG5) != null) {
                                viewStructure.setClassName("android.widget.ViewGroup");
                            }
                            Object objG6 = gm1Var2.g(kg2.A);
                            if (objG6 == null) {
                                objG6 = null;
                            }
                            List list = (List) objG6;
                            if (list != null) {
                                viewStructure.setClassName("android.widget.TextView");
                                viewStructure.setText(vc1.a(list, "\n", null, 62));
                            }
                            Object objG7 = gm1Var2.g(kg2.E);
                            if (objG7 == null) {
                                objG7 = null;
                            }
                            be beVar = (be) objG7;
                            if (beVar != null) {
                                viewStructure.setClassName("android.widget.EditText");
                                viewStructure.setText(beVar);
                            }
                            Object objG8 = gm1Var2.g(kg2.a);
                            if (objG8 == null) {
                                objG8 = null;
                            }
                            List list2 = (List) objG8;
                            if (list2 != null) {
                                viewStructure.setContentDescription(vc1.a(list2, "\n", null, 62));
                            }
                            Object objG9 = gm1Var2.g(kg2.x);
                            if (objG9 == null) {
                                objG9 = null;
                            }
                            if (((m82) objG9) != null) {
                                viewStructure.setClassName("android.widget.Button");
                            }
                            gz2 gz2VarA = e34.a(cg2Var);
                            if (gz2VarA != null) {
                                fz2 fz2Var = gz2VarA.a;
                                yz2 yz2Var = fz2Var.b;
                                jc0 jc0Var = fz2Var.g;
                                viewStructure.setTextStyle(jc0Var.l() * jc0Var.b() * b03.c(yz2Var.a.b), 0, 0, 0);
                            }
                            co1 co1VarD = gg2Var.d();
                            if (co1VarD == null) {
                                l42VarA = l42.e;
                            } else {
                                co1 co1Var = co1VarD.V0().w ? co1VarD : null;
                                if (co1Var != null) {
                                    l42VarA = gg2Var.a(co1Var);
                                } else {
                                    l42VarA = l42.e;
                                }
                            }
                            float f = l42VarA.a;
                            float f2 = l42VarA.b;
                            viewStructure.setDimens((int) f, (int) f2, 0, 0, (int) (l42VarA.c - f), (int) (l42VarA.d - f2));
                            py0Var = py0Var2;
                        }
                    }
                } else {
                    py0Var = null;
                }
            } else {
                py0Var = null;
            }
            if (py0Var != null) {
                this.e.add(new d50(i3, this.t, e50.a, py0Var));
            }
            List listI = gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0);
            int size = listI.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                Object obj = listI.get(i6);
                if (c().a(((gg2) obj).g)) {
                    h(i5, (gg2) obj);
                    i5++;
                }
            }
        }
    }

    public final void i(gg2 gg2Var) {
        if (d()) {
            this.e.add(new d50(gg2Var.g, this.t, e50.b, null));
            List listI = gg2Var.i((4 & 1) != 0 ? !gg2Var.b : false, (4 & 2) == 0);
            int size = listI.size();
            for (int i = 0; i < size; i++) {
                i((gg2) listI.get(i));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x005b A[LOOP:0: B:5:0x0017->B:15:0x005b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x005e A[EDGE_INSN: B:19:0x005e->B:16:0x005e BREAK  A[LOOP:0: B:5:0x0017->B:15:0x005b], SYNTHETIC] */
    public final void k() {
        ml1 ml1Var = this.u;
        ml1Var.c();
        c21 c21VarC = c();
        int[] iArr = c21VarC.b;
        Object[] objArr = c21VarC.c;
        long[] jArr = c21VarC.a;
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
                            int i4 = (i << 3) + i3;
                            ml1Var.h(iArr[i4], new hg2(((ig2) objArr[i4]).a, c()));
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
        this.v = new hg2(this.a.getSemanticsOwner().a(), c());
    }

    @Override // defpackage.ta0
    public final void onStart(ob1 ob1Var) {
        this.c = (l11) this.b.a();
        h(-1, this.a.getSemanticsOwner().a());
        e();
    }

    @Override // defpackage.ta0
    public final void onStop(ob1 ob1Var) {
        i(this.a.getSemanticsOwner().a());
        e();
        this.c = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.n.removeCallbacks(this.x);
        this.c = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
