package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vv2 {
    public static final nv2 a = new nv2(3, null);

    /* JADX WARN: Code duplicated, block: B:17:0x0049 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0052  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0047 -> B:18:0x004a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(defpackage.su2 r5, boolean r6, defpackage.hy1 r7, defpackage.pk r8) {
        /*
            boolean r0 = r8 instanceof defpackage.ov2
            if (r0 == 0) goto L13
            r0 = r8
            ov2 r0 = (defpackage.ov2) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            ov2 r0 = new ov2
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.j
            int r1 = r0.k
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2f
            boolean r5 = r0.i
            hy1 r6 = r0.f
            su2 r7 = r0.e
            defpackage.bz3.g(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L4a
        L2f:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r5)
            r5 = 0
            return r5
        L36:
            defpackage.bz3.g(r8)
        L39:
            r0.e = r5
            r0.f = r7
            r0.i = r6
            r0.k = r2
            java.lang.Object r8 = r5.a(r7, r0)
            t70 r1 = defpackage.t70.a
            if (r8 != r1) goto L4a
            return r1
        L4a:
            gy1 r8 = (defpackage.gy1) r8
            boolean r1 = c(r8, r6)
            if (r1 == 0) goto L39
            java.util.List r5 = r8.a
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vv2.a(su2, boolean, hy1, pk):java.lang.Object");
    }

    public static boolean c(gy1 gy1Var, boolean z) {
        List list = gy1Var.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ny1 ny1Var = (ny1) list.get(i);
            if (!(z ? y11.a(ny1Var) : y11.b(ny1Var))) {
                return false;
            }
        }
        return true;
    }

    public static yq2 d(s70 s70Var, f41 f41Var, vq0 vq0Var) {
        return uf4.b(s70Var, null, new r0(f41Var, vq0Var, null, 19), 1);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:30:0x008f  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cd A[LOOP:1: B:23:0x006e->B:44:0x00cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00ad -> B:13:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object e(defpackage.su2 r17, defpackage.hy1 r18, defpackage.pk r19) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vv2.e(su2, hy1, pk):java.lang.Object");
    }
}
