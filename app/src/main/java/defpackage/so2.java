package defpackage;

import android.speech.SpeechRecognizer;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class so2 extends b83 {
    public boolean A;
    public l61 B;
    public boolean C;
    public boolean D;
    public boolean E;
    public String F;
    public boolean G;
    public boolean H;
    public final in2 b;
    public final pn2 c;
    public final co2 d;
    public final l93 e;
    public final f40 f;
    public final zv1 g;
    public final j5 h;
    public final oj1 i;
    public final r2 j;
    public final mt0 k;
    public final h60 l;
    public final ii1 m;
    public final jr2 n;
    public final jr2 o;
    public final un p;
    public final un q;
    public boolean r;
    public Boolean s;
    public boolean t;
    public long u;
    public b60 v;
    public boolean w;
    public boolean x;
    public long y;
    public yq2 z;

    public so2(in2 in2Var, pn2 pn2Var, co2 co2Var, l93 l93Var, f40 f40Var, zv1 zv1Var, j5 j5Var, oj1 oj1Var, r2 r2Var, mt0 mt0Var, h60 h60Var, bh bhVar, ii1 ii1Var) {
        in2Var.getClass();
        pn2Var.getClass();
        co2Var.getClass();
        l93Var.getClass();
        f40Var.getClass();
        zv1Var.getClass();
        j5Var.getClass();
        oj1Var.getClass();
        r2Var.getClass();
        mt0Var.getClass();
        h60Var.getClass();
        bhVar.getClass();
        this.b = in2Var;
        this.c = pn2Var;
        this.d = co2Var;
        this.e = l93Var;
        this.f = f40Var;
        this.g = zv1Var;
        this.h = j5Var;
        this.i = oj1Var;
        this.j = r2Var;
        this.k = mt0Var;
        this.l = h60Var;
        this.m = ii1Var;
        rn2 rn2Var = rn2.b;
        ii0 ii0Var = ii0.a;
        this.n = o54.a(new eo2(rn2Var, "TAP TO SPEAK", "", null, null, ii0Var, null, ii0Var, false, false, true, false, false, null, 0L));
        this.o = o54.a(Float.valueOf(0.0f));
        x50 x50Var = null;
        this.p = nh4.a(-2, 6, null);
        this.q = nh4.a(1, 4, nn.b);
        this.v = b60.LIVE;
        this.B = l61.e;
        this.C = true;
        q();
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 0), 3);
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 1), 3);
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 2), 3);
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 3), 3);
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 4), 3);
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 5), 3);
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 6), 3);
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 7), 3);
        uf4.b(gb4.c(this), null, new fo2(this, x50Var, 8), 3);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0053  */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:49:0x00da  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0086 -> B:13:0x002f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00da -> B:18:0x0048). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object e(defpackage.so2 r13, defpackage.y50 r14) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.so2.e(so2, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public static final Object f(so2 so2Var, y50 y50Var) {
        oo2 oo2Var;
        long j;
        Object value;
        Object value2;
        un unVar = so2Var.p;
        jr2 jr2Var = so2Var.n;
        if (y50Var instanceof oo2) {
            oo2Var = (oo2) y50Var;
            int i = oo2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                oo2Var.j = i - Integer.MIN_VALUE;
            } else {
                oo2Var = new oo2(so2Var, y50Var);
            }
        } else {
            oo2Var = new oo2(so2Var, y50Var);
        }
        Object objC = oo2Var.f;
        int i2 = oo2Var.j;
        if (i2 == 0) {
            bz3.g(objC);
            long j2 = so2Var.u;
            j5 j5Var = so2Var.h;
            oo2Var.e = j2;
            oo2Var.j = 1;
            objC = rn4.c(j5Var.b, oo2Var);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
            j = j2;
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = oo2Var.e;
            bz3.g(objC);
        }
        g5 g5Var = (g5) objC;
        long j3 = so2Var.u;
        q43 q43Var = q43.a;
        if (j == j3 && g5Var.c && so2Var.s == null) {
            so2Var.v = g5Var.d;
            if (so2Var.g.c("android.permission.RECORD_AUDIO")) {
                so2Var.r = true;
                do {
                    value = jr2Var.getValue();
                } while (!jr2Var.h(value, eo2.a((eo2) value, null, so2Var.o() ? "LIVE" : "SAY \"WAKE UP SONIC\"", null, null, null, null, null, null, false, true, false, false, false, null, 0L, 32253)));
                if (so2Var.o()) {
                    unVar.s(new c43(true, false));
                    return q43Var;
                }
                if (so2Var.w) {
                    unVar.s(e43.a);
                    so2Var.q.s(new ho2(true));
                }
            } else {
                s(so2Var);
                do {
                    value2 = jr2Var.getValue();
                } while (!jr2Var.h(value2, eo2.a((eo2) value2, null, null, null, null, null, null, null, null, false, false, false, false, false, "Ambient listening was switched off — the microphone permission is no longer granted.", 0L, 24063)));
            }
        }
        return q43Var;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0297 A[PHI: r8
      0x0297: PHI (r8v3 t70) = (r8v2 t70), (r8v4 t70), (r8v4 t70), (r8v4 t70) binds: [B:50:0x0103, B:129:0x0295, B:103:0x024d, B:94:0x022a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:131:0x0298 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [ho2, java.lang.String, t42] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* JADX WARN: Type inference failed for: r52v0, types: [so2] */
    public static final Object g(so2 so2Var, ho2 ho2Var, y50 y50Var) {
        po2 po2Var;
        Object value;
        t70 t70Var;
        in2 in2Var;
        boolean z;
        t42 t42Var;
        Object r4;
        Object objU;
        ho2 ho2Var2 = ho2Var;
        in2 in2Var2 = so2Var.b;
        pn2 pn2Var = so2Var.c;
        jr2 jr2Var = so2Var.o;
        jr2 jr2Var2 = so2Var.n;
        if (y50Var instanceof po2) {
            po2Var = (po2) y50Var;
            int i = po2Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                po2Var.n = i - Integer.MIN_VALUE;
            } else {
                po2Var = new po2(so2Var, y50Var);
            }
        } else {
            po2Var = new po2(so2Var, y50Var);
        }
        Object obj = po2Var.j;
        int i2 = po2Var.n;
        rn2 rn2Var = rn2.c;
        t70 t70Var2 = t70.a;
        char c = 3;
        char c2 = 2;
        q43 q43Var = q43.a;
        boolean z2 = true;
        Object obj2 = null;
        try {
            if (i2 == 0) {
                char c3 = 4;
                bz3.g(obj);
                if (!so2Var.o()) {
                    so2Var.q();
                    if (!SpeechRecognizer.isRecognitionAvailable(pn2Var.a)) {
                        s(so2Var);
                        so2Var.l("No speech recognition service on this device. Typing still works.");
                        return q43Var;
                    }
                    while (true) {
                        Object value2 = jr2Var2.getValue();
                        t70Var = t70Var2;
                        eo2 eo2Var = (eo2) value2;
                        String str = ho2Var2.a ? "SAY \"WAKE UP SONIC\"" : "LISTENING";
                        in2Var = in2Var2;
                        z = z2 ? 1 : 0;
                        if (jr2Var2.h(value2, eo2.a(eo2Var, rn2Var, str, null, null, null, null, null, null, true, false, false, false, false, null, 0L, 24316))) {
                            break;
                        }
                        z2 = z ? 1 : 0;
                        t70Var2 = t70Var;
                        in2Var2 = in2Var;
                        obj2 = null;
                        c = 3;
                        c2 = 2;
                        c3 = 4;
                    }
                    t42Var = new t42();
                    var r15 = (!ho2Var2.a || so2Var.H) ? 0 : z ? 1 : 0;
                    so2Var.x = z;
                    sp spVarC = pn2.c(pn2Var, r15, so2Var.B.b, 4);
                    qo2 qo2Var = new qo2((so2) so2Var, t42Var);
                    po2Var.e = ho2Var2;
                    po2Var.f = t42Var;
                    po2Var.i = r15;
                    po2Var.n = z ? 1 : 0;
                    if (spVarC.a(qo2Var, po2Var) != t70Var) {
                        r4 = r15;
                    }
                    return t70Var;
                }
                return q43Var;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    bz3.g(obj);
                    return q43Var;
                }
                if (i2 == 3) {
                    bz3.g(obj);
                    return q43Var;
                }
                if (i2 == 4) {
                    bz3.g(obj);
                    return q43Var;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i3 = po2Var.i;
            t42 t42Var2 = po2Var.f;
            ho2Var2 = po2Var.e;
            bz3.g(obj);
            in2Var = in2Var2;
            t42Var = t42Var2;
            t70Var = t70Var2;
            z = true;
            r4 = i3;
            so2Var.x = false;
            Float f = new Float(0.0f);
            jr2Var.getClass();
            var r11 = 0;
            jr2Var.j(null, f);
            while (true) {
                Object value3 = jr2Var2.getValue();
                if (jr2Var2.h(value3, eo2.a((eo2) value3, null, null, null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32511))) {
                    break;
                }
                r11 = 0;
            }
            z83 z83Var = (z83) t42Var.a;
            if (!(z83Var instanceof t83)) {
                if (z83Var instanceof x83) {
                    so2Var.l(r11);
                    if (so2Var.r) {
                        po2Var.e = r11;
                        po2Var.f = r11;
                        po2Var.i = r4;
                        po2Var.n = 3;
                        if (bm4.b(600L, po2Var) == t70Var) {
                            return t70Var;
                        }
                    }
                    return q43Var;
                }
                if (z83Var instanceof y83) {
                    if (r4 != 0) {
                        so2Var.H = z;
                    }
                    so2Var.l(r4 != 0 ? "On-device recognition isn't installed, so SONIC will use the standard recogniser." : ((y83) z83Var).a);
                    return q43Var;
                }
                if (!(z83Var instanceof s83)) {
                    so2Var.l(null);
                    return q43Var;
                }
                s83 s83Var = (s83) z83Var;
                boolean z3 = s83Var.b;
                if (z3) {
                    s(so2Var);
                }
                so2Var.l(s83Var.a);
                if (!z3 && so2Var.r) {
                    long j = s83Var.c ? 1000L : 400L;
                    po2Var.e = null;
                    po2Var.f = null;
                    po2Var.i = r4;
                    po2Var.n = 4;
                    if (bm4.b(j, po2Var) == t70Var) {
                        return t70Var;
                    }
                }
                return q43Var;
            }
            t83 t83Var = (t83) z83Var;
            String str2 = t83Var.a;
            boolean z4 = ho2Var2.a;
            ArrayList arrayList = t83Var.b;
            po2Var.e = r11;
            po2Var.f = r11;
            po2Var.i = r4;
            po2Var.n = 2;
            boolean zM = in2Var.m();
            l93 l93Var = so2Var.e;
            boolean z5 = (!z4 || zM || System.nanoTime() / 1000000 < so2Var.y) ? false : z;
            l93Var.getClass();
            x4 x4VarA = l93.a(str2, z5);
            boolean z6 = x4VarA instanceof t4;
            if (z6 && xy.o(((t4) x4VarA).a)) {
                so2Var.p();
            } else {
                c63 c63Var = z4 ? c63.c : c63.b;
                if (z6) {
                    so2Var.A = z;
                    String str3 = ((t4) x4VarA).a;
                    so2Var.q();
                    objU = so2Var.u(in2Var.l(str3, c63Var, arrayList), po2Var);
                    if (objU != t70Var) {
                        objU = q43Var;
                    }
                    if (objU != t70Var) {
                    }
                    if (objU == t70Var) {
                        return t70Var;
                    }
                    return q43Var;
                }
                if (x4VarA instanceof u4) {
                    while (true) {
                        Object value4 = jr2Var2.getValue();
                        eo2 eo2Var2 = (eo2) value4;
                        rn2 rn2Var2 = rn2Var;
                        if (jr2Var2.h(value4, eo2.a(eo2Var2, rn2Var, "LISTENING", "", null, str2, null, null, null, false, false, false, false, false, null, eo2Var2.o + (if4.b(str2) ? 1L : 0L), 16360))) {
                            break;
                        }
                        rn2Var = rn2Var2;
                    }
                    so2Var.A = z;
                    so2Var.y = (System.nanoTime() / 1000000) + 15000;
                    if (!so2Var.r && so2Var.w) {
                        so2Var.q.s(new ho2(false));
                    }
                } else {
                    if (!x4VarA.equals(v4.a)) {
                        dk0.l();
                        return null;
                    }
                    so2Var.l(null);
                }
            }
            objU = q43Var;
            if (objU == t70Var) {
                return t70Var;
            }
            return q43Var;
        } catch (Throwable th) {
            so2Var.x = false;
            Float f2 = new Float(0.0f);
            jr2Var.getClass();
            jr2Var.j(null, f2);
            do {
                value = jr2Var2.getValue();
            } while (!jr2Var2.h(value, eo2.a((eo2) value, null, null, null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32511)));
            throw th;
        }
    }

    public static String m(rn2 rn2Var) {
        switch (rn2Var.ordinal()) {
            case 6:
                return "DONE";
            case 7:
                return "UNCONFIRMED";
            case 8:
                return "NOT SURE";
            case 9:
                return "BLOCKED";
            case 10:
                return "FAILED";
            case 11:
                return "CONFIRM";
            case 12:
                return "WHICH ONE?";
            case 13:
                return "PERMISSION";
            case 14:
                return "OFFLINE";
            default:
                return "TAP TO SPEAK";
        }
    }

    public static /* synthetic */ void s(so2 so2Var) {
        so2Var.r(false, new tv1(12));
    }

    @Override // defpackage.b83
    public final void d() throws IllegalAccessException, InvocationTargetException {
        if (this.i.b == this) {
            this.l.b();
            this.d.c();
            this.c.d();
        }
    }

    public final void h(boolean z) {
        jr2 jr2Var;
        yq2 yq2Var;
        so2 so2Var = this;
        boolean z2 = z;
        if (!z2 || so2Var.k()) {
            so2Var.r(z2, new hk(so2Var, z2, 4));
            while (true) {
                jr2Var = so2Var.n;
                Object value = jr2Var.getValue();
                if (jr2Var.h(value, eo2.a((eo2) value, null, null, null, null, null, null, null, null, false, z2, false, false, false, null, 0L, 24063))) {
                    break;
                }
                so2Var = this;
                z2 = z;
            }
            if (!o()) {
                if (z || ((eo2) jr2Var.getValue()).a != rn2.c) {
                    return;
                }
                w();
                return;
            }
            if (this.x && (yq2Var = this.z) != null) {
                yq2Var.e(null);
            }
            if (z) {
                return;
            }
            this.k.o();
        }
    }

    public final void i() {
        jr2 jr2Var;
        Object value;
        eo2 eo2VarA;
        do {
            jr2Var = this.n;
            value = jr2Var.getValue();
            eo2VarA = (eo2) value;
            if (this.b.g.e.a.getValue() == null) {
                rn2 rn2Var = eo2VarA.a;
                boolean z = eo2VarA.i;
                if (!rn2Var.b() && !eo2VarA.a.a()) {
                    h52 h52Var = eo2VarA.g;
                    if (!(h52Var instanceof d52) ? !(!(h52Var instanceof f52) || !((f52) h52Var).a.equals("android.settings.ACCESSIBILITY_SETTINGS") || !this.j.j()) : !(!((d52) h52Var).a.equals("screen_reading") || !this.D)) {
                        eo2VarA = eo2.a(eo2VarA, z ? rn2.c : n(), z ? "LISTENING" : "TAP TO SPEAK", "", null, null, ii0.a, null, null, false, false, false, false, false, null, 0L, 32656);
                    }
                }
            }
        } while (!jr2Var.h(value, eo2VarA));
    }

    public final void j() {
        jr2 jr2Var;
        Object value;
        if (!this.r) {
            do {
                jr2Var = this.n;
                value = jr2Var.getValue();
            } while (!jr2Var.h(value, eo2.a((eo2) value, null, null, null, null, null, null, null, null, false, false, false, false, false, "Tap the orb to start Sonic.", 0L, 24575)));
        } else {
            if (((ee1) this.k.l.a.getValue()).a) {
                return;
            }
            this.p.s(new c43(true, false));
        }
    }

    public final boolean k() {
        jr2 jr2Var;
        Object value;
        rn2 rn2Var;
        if (this.g.c("android.permission.RECORD_AUDIO")) {
            return true;
        }
        this.t = true;
        do {
            jr2Var = this.n;
            value = jr2Var.getValue();
            rn2Var = rn2.x;
        } while (!jr2Var.h(value, eo2.a((eo2) value, rn2Var, m(rn2Var), "SONIC needs the microphone to hear you.", "Nothing is recorded until you tap to speak or turn on ambient listening.", null, ii0.a, new e52(nz.h("android.permission.RECORD_AUDIO"), "Allow microphone"), null, false, false, false, false, false, null, 0L, 32656)));
        this.p.s(new f43(nz.h("android.permission.RECORD_AUDIO")));
        return false;
    }

    public final void l(String str) {
        jr2 jr2Var;
        Object value;
        eo2 eo2VarA;
        do {
            jr2Var = this.n;
            value = jr2Var.getValue();
            eo2 eo2Var = (eo2) value;
            eo2VarA = eo2.a(eo2Var, null, null, null, null, null, null, null, null, false, this.r, false, false, false, str, 0L, 23807);
            if (!eo2Var.a.b()) {
                eo2VarA = eo2.a(eo2VarA, n(), "TAP TO SPEAK", null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32764);
            }
        } while (!jr2Var.h(value, eo2VarA));
    }

    public final rn2 n() {
        return ((eo2) this.n.getValue()).k ? rn2.b : rn2.H;
    }

    public final boolean o() {
        return this.v == b60.LIVE;
    }

    public final void p() {
        jr2 jr2Var;
        Object value;
        s(this);
        this.A = false;
        while (!(this.q.p() instanceof lx)) {
        }
        this.l.b();
        this.d.c();
        this.k.o();
        this.p.s(new c43(false, false));
        yq2 yq2Var = this.z;
        x50 x50Var = null;
        if (yq2Var != null) {
            yq2Var.e(null);
        }
        Float fValueOf = Float.valueOf(0.0f);
        jr2 jr2Var2 = this.o;
        jr2Var2.getClass();
        jr2Var2.j(null, fValueOf);
        this.c.d();
        if (this.b.g.e.a.getValue() != null) {
            uf4.b(gb4.c(this), null, new fo2(this, x50Var, 12), 3);
        }
        do {
            jr2Var = this.n;
            value = jr2Var.getValue();
        } while (!jr2Var.h(value, eo2.a((eo2) value, rn2.b, "SONIC IS OFF", "Assistant shut down.", "Tap the orb to start again.", null, ii0.a, null, null, false, false, false, false, false, null, 0L, 21648)));
    }

    public final void q() {
        so2 so2Var = this;
        boolean zA = so2Var.f.a();
        while (true) {
            jr2 jr2Var = so2Var.n;
            Object value = jr2Var.getValue();
            eo2 eo2Var = (eo2) value;
            rn2 rn2Var = eo2Var.a;
            rn2 rn2Var2 = rn2.H;
            rn2 rn2Var3 = rn2.b;
            if (rn2Var == rn2Var3 || rn2Var == rn2Var2) {
                rn2Var = zA ? rn2Var3 : rn2Var2;
            }
            if (jr2Var.h(value, eo2.a(eo2Var, rn2Var, null, null, null, null, null, null, null, false, false, zA, false, false, null, 0L, 31742))) {
                return;
            } else {
                so2Var = this;
            }
        }
    }

    public final void r(boolean z, fq0 fq0Var) {
        if (!z) {
            this.F = null;
            this.t = false;
        }
        this.r = z;
        this.E = !z;
        this.s = Boolean.valueOf(z);
        long j = this.u + 1;
        this.u = j;
        uf4.b(gb4.c(this), null, new no2(this, z, j, fq0Var, null), 3);
    }

    public final void t(e5 e5Var) {
        Object value;
        eo2 eo2Var;
        rn2 rn2VarN;
        String strM;
        String str;
        Object value2;
        Object value3;
        Object value4;
        e5 e5Var2 = e5Var;
        boolean z = e5Var2 instanceof a5;
        ii0 ii0Var = ii0.a;
        jr2 jr2Var = this.n;
        if (!z) {
            if (e5Var2 instanceof c5) {
                return;
            }
            if (g31.a(e5Var2, b5.a)) {
                do {
                    value4 = jr2Var.getValue();
                } while (!jr2Var.h(value4, eo2.a((eo2) value4, rn2.f, "THINKING", null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32764)));
                return;
            }
            if (e5Var2 instanceof y4) {
                do {
                    value3 = jr2Var.getValue();
                } while (!jr2Var.h(value3, eo2.a((eo2) value3, rn2.i, "EXECUTING", null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32764)));
                return;
            }
            if (e5Var2 instanceof d5) {
                do {
                    value2 = jr2Var.getValue();
                } while (!jr2Var.h(value2, eo2.a((eo2) value2, rn2.j, "VERIFYING", null, null, null, null, null, null, false, false, false, false, false, null, 0L, 32764)));
                return;
            }
            if (!(e5Var2 instanceof z4)) {
                dk0.l();
                return;
            }
            z4 z4Var = (z4) e5Var2;
            l5 l5Var = z4Var.a;
            e33 e33Var = l5Var.b;
            rn2.a.getClass();
            rn2 rn2VarQ = el1.q(e33Var);
            rv1 rv1Var = z4Var.b;
            qv1 qv1Var = rv1Var instanceof qv1 ? (qv1) rv1Var : null;
            yx yxVar = qv1Var != null ? qv1Var.c : null;
            f5 f5Var = l5Var.d;
            String str2 = f5Var != null ? f5Var.a : null;
            if (str2 == null ? false : str2.equals("meta.shutdown")) {
                p();
                return;
            }
            do {
                value = jr2Var.getValue();
                eo2Var = (eo2) value;
                rn2VarN = rn2VarQ == rn2.b ? n() : rn2VarQ;
                strM = m(rn2VarQ);
                if (yxVar == null || (str = yxVar.a) == null) {
                    str = l5Var.c;
                }
            } while (!jr2Var.h(value, eo2.a(eo2Var, rn2VarN, strM, str, yxVar != null ? null : l5Var.f, null, yxVar != null ? mz.L(yxVar.c, 4) : ii0Var, l5Var.i, null, false, false, false, false, false, null, 0L, 32656)));
            i();
            return;
        }
        while (true) {
            Object value5 = jr2Var.getValue();
            jr2 jr2Var2 = jr2Var;
            if (jr2Var2.h(value5, eo2.a((eo2) value5, rn2.e, "PROCESSING", "", null, ((a5) e5Var2).a, ii0Var, null, null, false, false, false, false, false, null, 0L, 24448))) {
                return;
            }
            jr2Var = jr2Var2;
            e5Var2 = e5Var;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003d A[PHI: r2 r3
      0x003d: PHI (r2v3 ro2) = (r2v13 ro2), (r2v2 ro2) binds: [B:20:0x0058, B:15:0x0038] A[DONT_GENERATE, DONT_INLINE]
      0x003d: PHI (r3v1 t42) = (r3v4 t42), (r3v11 t42) binds: [B:20:0x0058, B:15:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:19:0x0046  */
    /* JADX WARN: Code duplicated, block: B:25:0x0063  */
    /* JADX WARN: Code duplicated, block: B:27:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    /* JADX WARN: Code duplicated, block: B:34:0x0086  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:50:0x0104  */
    /* JADX WARN: Code duplicated, block: B:52:0x0108  */
    /* JADX WARN: Code duplicated, block: B:54:0x0113  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a4 -> B:38:0x00a5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object u(defpackage.l90 r29, defpackage.y50 r30) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.so2.u(l90, y50):java.lang.Object");
    }

    public final void v(boolean z) {
        jr2 jr2Var;
        Object value;
        if (!z) {
            h(false);
            return;
        }
        do {
            jr2Var = this.n;
            value = jr2Var.getValue();
        } while (!jr2Var.h(value, eo2.a((eo2) value, null, null, null, null, null, null, null, null, false, false, false, false, false, "Tap the orb to start Sonic.", 0L, 24575)));
    }

    public final void w() {
        s(this);
        this.A = false;
        while (!(this.q.p() instanceof lx)) {
        }
        this.l.b();
        yq2 yq2Var = this.z;
        if (yq2Var != null) {
            yq2Var.e(null);
        }
        Float fValueOf = Float.valueOf(0.0f);
        jr2 jr2Var = this.o;
        jr2Var.getClass();
        jr2Var.j(null, fValueOf);
        l(null);
    }
}
