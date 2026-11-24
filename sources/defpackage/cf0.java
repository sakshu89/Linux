package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cf0 {
    public static final float a = 0.125f / 18.0f;

    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b A[LOOP:0: B:23:0x0067->B:27:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x007f A[EDGE_INSN: B:54:0x007f->B:29:0x007f BREAK  A[LOOP:0: B:23:0x0067->B:27:0x007b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005a -> B:22:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(defpackage.su2 r12, long r13, defpackage.y50 r15) {
        /*
            boolean r0 = r15 instanceof defpackage.we0
            if (r0 == 0) goto L13
            r0 = r15
            we0 r0 = (defpackage.we0) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            we0 r0 = new we0
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.i
            int r1 = r0.j
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2d
            s42 r12 = r0.f
            su2 r13 = r0.e
            defpackage.bz3.g(r15)
            r11 = r13
            r13 = r12
            r12 = r11
            goto L5d
        L2d:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r12)
            return r3
        L33:
            defpackage.bz3.g(r15)
            tu2 r15 = r12.i
            gy1 r15 = r15.Z
            boolean r15 = e(r15, r13)
            if (r15 == 0) goto L42
            goto Lc2
        L42:
            s42 r15 = new s42
            r15.<init>()
            r15.a = r13
        L49:
            r0.e = r12
            r0.f = r15
            r0.j = r2
            hy1 r13 = defpackage.hy1.b
            java.lang.Object r13 = r12.a(r13, r0)
            t70 r14 = defpackage.t70.a
            if (r13 != r14) goto L5a
            return r14
        L5a:
            r11 = r15
            r15 = r13
            r13 = r11
        L5d:
            gy1 r15 = (defpackage.gy1) r15
            java.util.List r14 = r15.a
            int r1 = r14.size()
            r4 = 0
            r5 = r4
        L67:
            if (r5 >= r1) goto L7e
            java.lang.Object r6 = r14.get(r5)
            r7 = r6
            ny1 r7 = (defpackage.ny1) r7
            long r7 = r7.a
            long r9 = r13.a
            boolean r7 = defpackage.f31.d(r7, r9)
            if (r7 == 0) goto L7b
            goto L7f
        L7b:
            int r5 = r5 + 1
            goto L67
        L7e:
            r6 = r3
        L7f:
            ny1 r6 = (defpackage.ny1) r6
            if (r6 != 0) goto L85
            r6 = r3
            goto Lb9
        L85:
            boolean r14 = defpackage.y11.d(r6)
            if (r14 == 0) goto Lad
            java.util.List r14 = r15.a
            int r15 = r14.size()
        L91:
            if (r4 >= r15) goto La2
            java.lang.Object r1 = r14.get(r4)
            r5 = r1
            ny1 r5 = (defpackage.ny1) r5
            boolean r5 = r5.d
            if (r5 == 0) goto L9f
            goto La3
        L9f:
            int r4 = r4 + 1
            goto L91
        La2:
            r1 = r3
        La3:
            ny1 r1 = (defpackage.ny1) r1
            if (r1 != 0) goto La8
            goto Lb9
        La8:
            long r14 = r1.a
            r13.a = r14
            goto Lc3
        Lad:
            long r14 = defpackage.y11.f(r6, r2)
            r4 = 0
            boolean r14 = defpackage.jp1.b(r14, r4)
            if (r14 != 0) goto Lc3
        Lb9:
            if (r6 == 0) goto Lc2
            boolean r12 = r6.b()
            if (r12 != 0) goto Lc2
            return r6
        Lc2:
            return r3
        Lc3:
            r15 = r13
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cf0.a(su2, long, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [t42] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    public static final Object b(su2 su2Var, long j, y50 y50Var) {
        xe0 xe0Var;
        Object obj;
        ny1 ny1Var;
        o42 o42Var;
        if (y50Var instanceof xe0) {
            xe0Var = (xe0) y50Var;
            int i = xe0Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                xe0Var.k = i - Integer.MIN_VALUE;
            } else {
                xe0Var = new xe0(y50Var);
            }
        } else {
            xe0Var = new xe0(y50Var);
        }
        Object obj2 = xe0Var.j;
        int i2 = xe0Var.k;
        try {
            if (i2 == 0) {
                bz3.g(obj2);
                if (!e(su2Var.i.Z, j)) {
                    List list = su2Var.i.Z.a;
                    int size = list.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            obj = null;
                            break;
                        }
                        obj = list.get(i3);
                        if (f31.d(((ny1) obj).a, j)) {
                            break;
                        }
                        i3++;
                    }
                    ny1Var = (ny1) obj;
                    if (ny1Var != null) {
                        t42 t42Var = new t42();
                        t42 t42Var2 = new t42();
                        t42Var2.a = ny1Var;
                        long jC = su2Var.e().c();
                        o42 o42Var2 = new o42();
                        vq0 ye0Var = new ye0(o42Var2, t42Var2, t42Var, null);
                        xe0Var.e = ny1Var;
                        xe0Var.f = t42Var;
                        xe0Var.i = o42Var2;
                        xe0Var.k = 1;
                        Object objN = su2Var.n(jC, ye0Var, xe0Var);
                        Object obj3 = t70.a;
                        if (objN == obj3) {
                            return obj3;
                        }
                        o42Var = o42Var2;
                        j = t42Var;
                    }
                }
                return null;
            }
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            o42Var = xe0Var.i;
            t42 t42Var3 = xe0Var.f;
            ny1Var = xe0Var.e;
            bz3.g(obj2);
            j = t42Var3;
            if (o42Var.a) {
                ny1 ny1Var2 = (ny1) j.a;
                return ny1Var2 == null ? ny1Var : ny1Var2;
            }
            return null;
        } catch (iy1 unused) {
            ny1 ny1Var3 = (ny1) j.a;
            return ny1Var3 == null ? ny1Var : ny1Var3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c6 A[LOOP:0: B:26:0x00ac->B:30:0x00c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x00d2 A[EDGE_INSN: B:69:0x00d2->B:32:0x00d2 BREAK  A[LOOP:0: B:26:0x00ac->B:30:0x00c6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x015e -> B:63:0x0164). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object c(defpackage.su2 r21, long r22, defpackage.ha r24, defpackage.pk r25) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cf0.c(su2, long, ha, pk):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object d(defpackage.su2 r4, long r5, defpackage.hq0 r7, defpackage.y50 r8) {
        /*
            boolean r0 = r8 instanceof defpackage.bf0
            if (r0 == 0) goto L13
            r0 = r8
            bf0 r0 = (defpackage.bf0) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            bf0 r0 = new bf0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.i
            int r1 = r0.j
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2b
            hq0 r4 = r0.f
            su2 r5 = r0.e
            defpackage.bz3.g(r8)
            r7 = r4
            r4 = r5
            goto L44
        L2b:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r4)
            r4 = 0
            return r4
        L32:
            defpackage.bz3.g(r8)
        L35:
            r0.e = r4
            r0.f = r7
            r0.j = r2
            java.lang.Object r8 = a(r4, r5, r0)
            t70 r5 = defpackage.t70.a
            if (r8 != r5) goto L44
            return r5
        L44:
            ny1 r8 = (defpackage.ny1) r8
            if (r8 != 0) goto L4b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L4b:
            boolean r5 = defpackage.y11.d(r8)
            if (r5 == 0) goto L54
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L54:
            r7.j(r8)
            long r5 = r8.a
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cf0.d(su2, long, hq0, y50):java.lang.Object");
    }

    public static final boolean e(gy1 gy1Var, long j) {
        Object obj;
        List list = gy1Var.a;
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list.get(i);
            if (f31.d(((ny1) obj).a, j)) {
                break;
            }
            i++;
        }
        ny1 ny1Var = (ny1) obj;
        if (ny1Var != null && ny1Var.d) {
            z = true;
        }
        return true ^ z;
    }

    public static final float f(w73 w73Var, int i) {
        return i == 2 ? w73Var.d() * a : w73Var.d();
    }
}
