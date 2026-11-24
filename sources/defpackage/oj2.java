package defpackage;

import android.app.role.RoleManager;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oj2 extends b83 {
    public final f0 b;
    public final j5 c;
    public final h61 d;
    public final co2 e;
    public final n f;
    public final zv1 g;
    public final mt0 h;
    public final ps0 i;
    public final jr2 j;
    public yq2 k;

    public oj2(Context context, f0 f0Var, j5 j5Var, h61 h61Var, co2 co2Var, n nVar, zv1 zv1Var, mt0 mt0Var, ps0 ps0Var) {
        f0Var.getClass();
        j5Var.getClass();
        h61Var.getClass();
        co2Var.getClass();
        nVar.getClass();
        zv1Var.getClass();
        mt0Var.getClass();
        ps0Var.getClass();
        this.b = f0Var;
        this.c = j5Var;
        this.d = h61Var;
        this.e = co2Var;
        this.f = nVar;
        this.g = zv1Var;
        this.h = mt0Var;
        this.i = ps0Var;
        l61 l61Var = l61.e;
        x50 x50Var = null;
        e51 e51Var = e51.e;
        r51 r51Var = r51.a;
        l82 l82Var = l82.e;
        b60 b60Var = b60.LIVE;
        ii0 ii0Var = ii0.a;
        this.j = o54.a(new gj2(false, "offline", null, false, e51Var, r51Var, false, l82Var, false, b60Var, "Aoede", "auto", null, false, false, l61Var, true, ii0Var, ii0Var, false, null, null));
        uf4.b(gb4.c(this), null, new jj2(this, x50Var, 0), 3);
        uf4.b(gb4.c(this), null, new mf(this, x50Var, 5), 3);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00ce A[Catch: Exception -> 0x003f, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, Exception -> 0x003f, blocks: (B:13:0x0036, B:22:0x004d, B:39:0x00c6, B:41:0x00ce, B:49:0x00f7, B:51:0x0133, B:53:0x013a, B:43:0x00d6, B:45:0x00da, B:46:0x00e4, B:48:0x00e8, B:57:0x014a, B:58:0x014f, B:23:0x0052, B:36:0x00b5, B:33:0x00ab), top: B:67:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d6 A[Catch: Exception -> 0x003f, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, Exception -> 0x003f, blocks: (B:13:0x0036, B:22:0x004d, B:39:0x00c6, B:41:0x00ce, B:49:0x00f7, B:51:0x0133, B:53:0x013a, B:43:0x00d6, B:45:0x00da, B:46:0x00e4, B:48:0x00e8, B:57:0x014a, B:58:0x014f, B:23:0x0052, B:36:0x00b5, B:33:0x00ab), top: B:67:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00da A[Catch: Exception -> 0x003f, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, Exception -> 0x003f, blocks: (B:13:0x0036, B:22:0x004d, B:39:0x00c6, B:41:0x00ce, B:49:0x00f7, B:51:0x0133, B:53:0x013a, B:43:0x00d6, B:45:0x00da, B:46:0x00e4, B:48:0x00e8, B:57:0x014a, B:58:0x014f, B:23:0x0052, B:36:0x00b5, B:33:0x00ab), top: B:67:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4 A[Catch: Exception -> 0x003f, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, Exception -> 0x003f, blocks: (B:13:0x0036, B:22:0x004d, B:39:0x00c6, B:41:0x00ce, B:49:0x00f7, B:51:0x0133, B:53:0x013a, B:43:0x00d6, B:45:0x00da, B:46:0x00e4, B:48:0x00e8, B:57:0x014a, B:58:0x014f, B:23:0x0052, B:36:0x00b5, B:33:0x00ab), top: B:67:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e8 A[Catch: Exception -> 0x003f, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, Exception -> 0x003f, blocks: (B:13:0x0036, B:22:0x004d, B:39:0x00c6, B:41:0x00ce, B:49:0x00f7, B:51:0x0133, B:53:0x013a, B:43:0x00d6, B:45:0x00da, B:46:0x00e4, B:48:0x00e8, B:57:0x014a, B:58:0x014f, B:23:0x0052, B:36:0x00b5, B:33:0x00ab), top: B:67:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:53:0x013a A[Catch: Exception -> 0x003f, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, Exception -> 0x003f, blocks: (B:13:0x0036, B:22:0x004d, B:39:0x00c6, B:41:0x00ce, B:49:0x00f7, B:51:0x0133, B:53:0x013a, B:43:0x00d6, B:45:0x00da, B:46:0x00e4, B:48:0x00e8, B:57:0x014a, B:58:0x014f, B:23:0x0052, B:36:0x00b5, B:33:0x00ab), top: B:67:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0147 A[LOOP:0: B:49:0x00f7->B:56:0x0147, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x014a A[Catch: Exception -> 0x003f, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, Exception -> 0x003f, blocks: (B:13:0x0036, B:22:0x004d, B:39:0x00c6, B:41:0x00ce, B:49:0x00f7, B:51:0x0133, B:53:0x013a, B:43:0x00d6, B:45:0x00da, B:46:0x00e4, B:48:0x00e8, B:57:0x014a, B:58:0x014f, B:23:0x0052, B:36:0x00b5, B:33:0x00ab), top: B:67:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0133 A[EDGE_INSN: B:68:0x0133->B:51:0x0133 BREAK  A[LOOP:0: B:49:0x00f7->B:56:0x0147], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public static final Object e(oj2 oj2Var, String str, y50 y50Var) throws Throwable {
        kj2 kj2Var;
        Object value;
        Object value2;
        Object value3;
        h hVar;
        String str2;
        s51 o51Var;
        s51 s51Var;
        Object value4;
        s51 s51Var2;
        ps0 ps0Var;
        n nVar = oj2Var.f;
        jr2 jr2Var = oj2Var.j;
        if (y50Var instanceof kj2) {
            kj2Var = (kj2) y50Var;
            int i = kj2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                kj2Var.j = i - Integer.MIN_VALUE;
            } else {
                kj2Var = new kj2(oj2Var, y50Var);
            }
        } else {
            kj2Var = new kj2(oj2Var, y50Var);
        }
        Object objP = kj2Var.f;
        int i2 = kj2Var.j;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        try {
            if (i2 == 0) {
                bz3.g(objP);
                c cVar = (c) nVar.a.get("gemini");
                ms0 ms0Var = cVar instanceof ms0 ? (ms0) cVar : null;
                if (ms0Var != null) {
                    do {
                        value3 = jr2Var.getValue();
                    } while (!jr2Var.h(value3, gj2.a((gj2) value3, false, null, null, false, null, q51.a, false, null, false, null, null, null, null, false, false, null, false, null, null, false, null, str, 1048543)));
                    kj2Var.j = 1;
                    objP = ms0Var.p(kj2Var);
                    if (objP == t70Var) {
                    }
                    return t70Var;
                }
                return q43Var;
            }
            if (i2 == 1) {
                bz3.g(objP);
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bz3.g(objP);
                    ((i72) objP).getClass();
                    return q43Var;
                }
                hVar = kj2Var.e;
                bz3.g(objP);
            }
            str2 = (String) objP;
            if (hVar instanceof f) {
                o51Var = new p51();
            } else if (hVar instanceof g) {
                o51Var = new o51(((g) hVar).a, null);
            } else {
                if (hVar instanceof e) {
                    throw new b10();
                }
                o51Var = new o51(((e) hVar).a, ((e) hVar).b);
            }
            s51Var = o51Var;
            while (true) {
                value4 = jr2Var.getValue();
                s51Var2 = s51Var;
                if (jr2Var.h(value4, gj2.a((gj2) value4, false, null, str2, false, null, s51Var, false, null, false, null, null, null, null, false, false, null, false, null, null, false, null, null, 2097115))) {
                    break;
                }
                s51Var = s51Var2;
            }
            nVar.e();
            if (s51Var2 instanceof p51) {
                ps0Var = oj2Var.i;
                kj2Var.e = null;
                kj2Var.j = 3;
                if (ps0Var.a(true, kj2Var) == t70Var) {
                    return t70Var;
                }
            }
            return q43Var;
            hVar = (h) objP;
            f0 f0Var = oj2Var.b;
            kj2Var.e = hVar;
            kj2Var.j = 2;
            objP = f0Var.h("gemini", kj2Var);
            if (objP != t70Var) {
                str2 = (String) objP;
                if (hVar instanceof f) {
                    o51Var = new p51();
                } else if (hVar instanceof g) {
                    o51Var = new o51(((g) hVar).a, null);
                } else {
                    if (hVar instanceof e) {
                        throw new b10();
                    }
                    o51Var = new o51(((e) hVar).a, ((e) hVar).b);
                }
                s51Var = o51Var;
                while (true) {
                    value4 = jr2Var.getValue();
                    s51Var2 = s51Var;
                    if (jr2Var.h(value4, gj2.a((gj2) value4, false, null, str2, false, null, s51Var, false, null, false, null, null, null, null, false, false, null, false, null, null, false, null, null, 2097115))) {
                        break;
                        break;
                    }
                    s51Var = s51Var2;
                }
                nVar.e();
                if (s51Var2 instanceof p51) {
                    ps0Var = oj2Var.i;
                    kj2Var.e = null;
                    kj2Var.j = 3;
                    if (ps0Var.a(true, kj2Var) == t70Var) {
                    }
                }
                return q43Var;
            }
            return t70Var;
        } catch (CancellationException e) {
            do {
                value2 = jr2Var.getValue();
            } while (!jr2Var.h(value2, gj2.a((gj2) value2, false, null, null, false, null, r51.a, false, null, false, null, null, null, null, false, false, null, false, null, null, false, null, null, 2097119)));
            throw e;
        } catch (Exception e2) {
            w30 w30VarB = oj4.b(e2);
            do {
                value = jr2Var.getValue();
            } while (!jr2Var.h(value, gj2.a((gj2) value, false, null, null, false, null, new o51(oj4.d(w30VarB), oj4.e(w30VarB, e2.getClass().getSimpleName() + ": " + e2.getMessage())), false, null, false, null, null, null, null, false, false, null, false, null, null, false, null, null, 2097119)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object f(oj2 oj2Var, y50 y50Var) {
        lj2 lj2Var;
        j5 j5Var = oj2Var.c;
        if (y50Var instanceof lj2) {
            lj2Var = (lj2) y50Var;
            int i = lj2Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                lj2Var.i = i - Integer.MIN_VALUE;
            } else {
                lj2Var = new lj2(oj2Var, y50Var);
            }
        } else {
            lj2Var = new lj2(oj2Var, y50Var);
        }
        Object objC = lj2Var.e;
        int i2 = lj2Var.i;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objC);
            lj2Var.i = 1;
            objC = rn4.c(j5Var.b, lj2Var);
            if (objC != t70Var) {
            }
            return t70Var;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(objC);
                return q43Var;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(objC);
        if (((g5) objC).d == b60.LIVE) {
            lj2Var.i = 2;
            if (j5Var.b(false, lj2Var) == t70Var) {
                return t70Var;
            }
        }
        return q43Var;
    }

    public static final void g(oj2 oj2Var) {
        oj2Var.getClass();
        uf4.b(gb4.c(oj2Var), null, new mj2(oj2Var, null), 3);
    }

    public final void h() {
        yq2 yq2Var = this.k;
        x50 x50Var = null;
        if (yq2Var != null) {
            yq2Var.e(null);
        }
        this.h.o();
        this.k = uf4.b(gb4.c(this), null, new jj2(this, x50Var, 1), 3);
    }

    public final void i(String str) {
        jr2 jr2Var;
        Object value;
        do {
            jr2Var = this.j;
            value = jr2Var.getValue();
        } while (!jr2Var.h(value, gj2.a((gj2) value, false, null, null, false, null, null, false, null, false, null, null, null, null, false, false, null, false, null, null, false, str, null, 3145727)));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x00b7  */
    public final void j() {
        boolean z;
        jr2 jr2Var;
        Object value;
        zv1 zv1Var = this.g;
        boolean zC = zv1Var.c("android.permission.RECORD_AUDIO");
        Context context = zv1Var.a;
        i92 i92Var = new i92("android.permission.RECORD_AUDIO", "Microphone", "Hear your voice commands", zC);
        i92 i92Var2 = new i92("android.permission.READ_CONTACTS", "Contacts", "Resolve contact names for calls and messages", zv1Var.c("android.permission.READ_CONTACTS"));
        i92 i92Var3 = new i92("android.permission.CALL_PHONE", "Calls", "Place calls when asked", zv1Var.c("android.permission.CALL_PHONE"));
        int i = Build.VERSION.SDK_INT;
        List listI = nz.i(i92Var, i92Var2, i92Var3, new i92("android.permission.POST_NOTIFICATIONS", "Notifications", "Display continuous listening notification", i < 33 ? true : zv1Var.c("android.permission.POST_NOTIFICATIONS")));
        List listI2 = nz.i(new op2(np2.c, "Screen control", "Inspect and click on-screen elements", dc4.b(context), true), new op2(np2.f, "Display over other apps", "Draw glowing edge when listening", Settings.canDrawOverlays(context), true), new op2(np2.b, "Notification access", "See what's playing in music apps", zv1Var.a(), true), new op2(np2.a, "Screen brightness", "Adjust screen brightness when requested", Settings.System.canWrite(context), true));
        if (i >= 29) {
            RoleManager roleManagerD = bv0.d(context.getSystemService(bv0.h()));
            if (roleManagerD == null || !roleManagerD.isRoleHeld("android.app.role.ASSISTANT")) {
                z = false;
            } else {
                z = true;
            }
        } else {
            String string = Settings.Secure.getString(context.getContentResolver(), "assistant");
            if (string != null) {
                String packageName = context.getPackageName();
                packageName.getClass();
                if (js2.k(string, packageName, false)) {
                    z = true;
                }
            }
            z = false;
        }
        do {
            jr2Var = this.j;
            value = jr2Var.getValue();
        } while (!jr2Var.h(value, gj2.a((gj2) value, false, null, null, false, null, null, false, null, false, null, null, null, null, false, false, null, false, listI, listI2, z, null, null, 3276799)));
    }
}
