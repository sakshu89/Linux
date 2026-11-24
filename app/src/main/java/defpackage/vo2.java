package defpackage;

import com.project.sonic.background.SonicVoiceService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vo2 implements nm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ SonicVoiceService b;
    public final /* synthetic */ t42 c;

    public /* synthetic */ vo2(SonicVoiceService sonicVoiceService, t42 t42Var, int i) {
        this.a = i;
        this.b = sonicVoiceService;
        this.c = t42Var;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        if (r12 == r9) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(defpackage.e5 r11, defpackage.x50 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof defpackage.xo2
            if (r0 == 0) goto L14
            r0 = r12
            xo2 r0 = (defpackage.xo2) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.k = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            xo2 r0 = new xo2
            r0.<init>(r10, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r7.i
            int r0 = r7.k
            r1 = 0
            r2 = 2
            r3 = 1
            com.project.sonic.background.SonicVoiceService r8 = r10.b
            t70 r9 = defpackage.t70.a
            if (r0 == 0) goto L3e
            if (r0 == r3) goto L38
            if (r0 != r2) goto L32
            t42 r10 = r7.f
            defpackage.bz3.g(r12)
            goto La4
        L32:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r10)
            return r1
        L38:
            e5 r11 = r7.e
            defpackage.bz3.g(r12)
            goto L66
        L3e:
            defpackage.bz3.g(r12)
            dt1 r12 = r8.f()
            el1 r0 = defpackage.rn2.a
            r0.getClass()
            rn2 r0 = defpackage.el1.p(r11)
            r12.d(r0)
            boolean r12 = r11 instanceof defpackage.z4
            if (r12 == 0) goto Lbb
            j5 r12 = r8.g()
            r7.e = r11
            r7.k = r3
            i5 r12 = r12.b
            java.lang.Object r12 = defpackage.rn4.c(r12, r7)
            if (r12 != r9) goto L66
            goto La3
        L66:
            g5 r12 = (defpackage.g5) r12
            b60 r0 = r12.d
            b60 r4 = defpackage.b60.LIVE
            if (r0 == r4) goto Lad
            r0 = r1
            h60 r1 = r8.u
            if (r1 == 0) goto La7
            z4 r11 = (defpackage.z4) r11
            l5 r11 = r11.a
            r4 = r2
            java.lang.String r2 = r11.c
            l61 r5 = r12.h
            java.util.Locale r5 = r5.b
            boolean r11 = r11.k
            boolean r6 = r8.Z
            if (r6 != 0) goto L89
            boolean r12 = r12.c
            if (r12 == 0) goto L89
            goto L8a
        L89:
            r3 = 0
        L8a:
            r7.e = r0
            t42 r10 = r10.c
            r7.f = r10
            r7.k = r4
            j r6 = new j
            r12 = 20
            r6.<init>(r12)
            r4 = r5
            r5 = r3
            r3 = r4
            r4 = r11
            java.lang.Object r12 = r1.a(r2, r3, r4, r5, r6, r7)
            if (r12 != r9) goto La4
        La3:
            return r9
        La4:
            r10.a = r12
            goto Lad
        La7:
            java.lang.String r10 = "playback"
            defpackage.g31.f(r10)
            throw r0
        Lad:
            fw0 r10 = r8.X
            r10.c()
            dt1 r10 = r8.f()
            rn2 r11 = defpackage.rn2.b
            r10.d(r11)
        Lbb:
            q43 r10 = defpackage.q43.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vo2.a(e5, x50):java.lang.Object");
    }

    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) {
        switch (this.a) {
            case 0:
                z83 z83Var = (z83) obj;
                if (g31.a(z83Var, v83.a)) {
                    this.b.f().d(rn2.c);
                } else if (!(z83Var instanceof u83) && !(z83Var instanceof w83) && !g31.a(z83Var, r83.a)) {
                    this.c.a = z83Var;
                }
                return q43.a;
            default:
                return a((e5) obj, x50Var);
        }
    }
}
