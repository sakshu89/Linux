package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends nu2 implements vq0 {
    public final /* synthetic */ int f = 1;
    public int i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object n;
    public final /* synthetic */ Object s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(h60 h60Var, String str, Locale locale, boolean z, x50 x50Var) {
        super(2, x50Var);
        this.k = h60Var;
        this.n = str;
        this.s = locale;
        this.j = z;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                break;
        }
        return ((u0) q(x50Var, s70Var)).s(q43Var);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.s;
        Object obj3 = this.n;
        Object obj4 = this.k;
        switch (i) {
            case 0:
                return new u0((ol1) obj4, (b02) obj3, this.j, (ky) obj2, x50Var);
            default:
                return new u0((h60) obj4, (String) obj3, (Locale) obj2, this.j, x50Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
    
        if (((defpackage.ol1) r4).a(r3, r10) == r7) goto L25;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            int r0 = r10.f
            boolean r1 = r10.j
            java.lang.Object r2 = r10.s
            java.lang.Object r3 = r10.n
            java.lang.Object r4 = r10.k
            r5 = 0
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            t70 r7 = defpackage.t70.a
            r8 = 1
            switch(r0) {
                case 0: goto L37;
                default: goto L13;
            }
        L13:
            int r0 = r10.i
            if (r0 == 0) goto L22
            if (r0 != r8) goto L1d
            defpackage.bz3.g(r11)
            goto L36
        L1d:
            defpackage.og.n(r6)
            r11 = r5
            goto L36
        L22:
            defpackage.bz3.g(r11)
            h60 r4 = (defpackage.h60) r4
            co2 r11 = r4.b
            java.lang.String r3 = (java.lang.String) r3
            java.util.Locale r2 = (java.util.Locale) r2
            r10.i = r8
            java.lang.Object r11 = r11.b(r3, r2, r1, r10)
            if (r11 != r7) goto L36
            r11 = r7
        L36:
            return r11
        L37:
            b02 r3 = (defpackage.b02) r3
            int r0 = r10.i
            r9 = 2
            if (r0 == 0) goto L4e
            if (r0 == r8) goto L4a
            if (r0 != r9) goto L46
            defpackage.bz3.g(r11)
            goto L68
        L46:
            defpackage.og.n(r6)
            goto L73
        L4a:
            defpackage.bz3.g(r11)
            goto L5c
        L4e:
            defpackage.bz3.g(r11)
            long r5 = defpackage.ly.a
            r10.i = r8
            java.lang.Object r11 = defpackage.bm4.b(r5, r10)
            if (r11 != r7) goto L5c
            goto L66
        L5c:
            ol1 r4 = (defpackage.ol1) r4
            r10.i = r9
            java.lang.Object r10 = r4.a(r3, r10)
            if (r10 != r7) goto L68
        L66:
            r5 = r7
            goto L73
        L68:
            ky r2 = (defpackage.ky) r2
            if (r1 == 0) goto L6f
            r2.n0 = r3
            goto L71
        L6f:
            r2.j0 = r3
        L71:
            q43 r5 = defpackage.q43.a
        L73:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u0.s(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(ol1 ol1Var, b02 b02Var, boolean z, ky kyVar, x50 x50Var) {
        super(2, x50Var);
        this.k = ol1Var;
        this.n = b02Var;
        this.j = z;
        this.s = kyVar;
    }
}
