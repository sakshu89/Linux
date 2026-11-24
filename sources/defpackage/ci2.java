package defpackage;

import android.content.Context;
import android.content.Intent;
import com.ibm.icu.impl.number.Padder;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ci2 implements bl2 {
    public final Context a;
    public final n21 b;
    public final si2 c;
    public final e40 d;
    public final Set e;
    public final l82 f;
    public final an1 g;

    public ci2(Context context, n21 n21Var, si2 si2Var, e40 e40Var) {
        n21Var.getClass();
        si2Var.getClass();
        e40Var.getClass();
        this.a = context;
        this.b = n21Var;
        this.c = si2Var;
        this.d = e40Var;
        this.e = wh2.c(new w3("device.settings.open"), new w3("device.wifi.settings"), new w3("device.bluetooth.settings"), new w3("device.wifi.enable"), new w3("device.wifi.disable"), new w3("device.wifi.toggle"), new w3("device.bluetooth.enable"), new w3("device.bluetooth.disable"), new w3("device.bluetooth.toggle"));
        this.f = l82.a;
        this.g = new an1();
    }

    public static String p(String str) {
        if (g31.a(str, "wifi")) {
            return "Wi-Fi";
        }
        return g31.a(str, "bluetooth") ? "Bluetooth" : "Settings";
    }

    public static fl2 q(String str, t61 t61Var) {
        String strP;
        String str2;
        String str3;
        boolean z = t61Var instanceof r61;
        if (z) {
            strP = p(str);
            str2 = "Android blocked opening ";
        } else {
            strP = p(str);
            str2 = "I couldn't open ";
        }
        String strV = cq.v(str2, strP, " settings.");
        if (t61Var instanceof q61) {
            str3 = ((q61) t61Var).a;
        } else if (z) {
            str3 = ((r61) t61Var).a;
        } else if (t61Var instanceof s61) {
            str3 = ((s61) t61Var).a;
        } else if (t61Var instanceof o61) {
            str3 = ((o61) t61Var).a;
        } else {
            if (!(t61Var instanceof p61)) {
                dk0.l();
                return null;
            }
            str3 = "Unexpected launch result";
        }
        return new fl2(strV, str3, null, false, 12);
    }

    public static el2 r(String str, String str2) {
        return new el2(cq.v("SONIC needs ", p(str), " permission to verify its state."), new z22(nz.h(str2)), new e52(nz.h(str2), "Allow"));
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.e;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "device.settings";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Opens the right settings screen and manages device settings.";
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086 A[Catch: all -> 0x00a0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0099  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a4 A[Catch: all -> 0x00a0, TRY_ENTER, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ac A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c6 A[Catch: all -> 0x00a0, TRY_ENTER, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ce A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00df  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e6 A[Catch: all -> 0x00a0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00f0 A[Catch: all -> 0x00a0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0102  */
    /* JADX WARN: Code duplicated, block: B:72:0x0109 A[Catch: all -> 0x00a0, TRY_ENTER, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0111 A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0123  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:80:0x0129 A[Catch: all -> 0x00a0, TRY_ENTER, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0131 A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0141  */
    /* JADX WARN: Code duplicated, block: B:88:0x0147 A[Catch: all -> 0x00a0, TRY_ENTER, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:90:0x014f A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0157 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:94:0x015f A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0164 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:36:0x007a, B:39:0x0086, B:47:0x00a4, B:49:0x00ac, B:55:0x00c6, B:57:0x00ce, B:63:0x00e6, B:66:0x00f0, B:72:0x0109, B:74:0x0111, B:80:0x0129, B:82:0x0131, B:88:0x0147, B:90:0x014f, B:92:0x0157, B:94:0x015f, B:95:0x0164, B:98:0x016e), top: B:104:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:97:0x016c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2 */
    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) throws Throwable {
        ai2 ai2Var;
        an1 an1Var;
        int i;
        String str;
        String strC;
        jl2 jl2VarN;
        jl2 jl2Var;
        an1 an1Var2;
        Object objO;
        Object objO2;
        Object objO3;
        Object objO4;
        Object objO5;
        Object objO6;
        if (x50Var instanceof ai2) {
            ai2Var = (ai2) x50Var;
            int i2 = ai2Var.n;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ai2Var.n = i2 - Integer.MIN_VALUE;
            } else {
                ai2Var = new ai2(this, (y50) x50Var);
            }
        } else {
            ai2Var = new ai2(this, (y50) x50Var);
        }
        Object obj = ai2Var.j;
        int i3 = ai2Var.n;
        t70 t70Var = t70.a;
        try {
            switch (i3) {
                case 0:
                    bz3.g(obj);
                    ai2Var.e = f5Var;
                    an1Var = this.g;
                    ai2Var.f = an1Var;
                    i = 0;
                    ai2Var.i = 0;
                    ai2Var.n = 1;
                    if (an1Var.e(ai2Var) != t70Var) {
                        try {
                            str = f5Var.a;
                            if (g31.a(str, "device.wifi.enable")) {
                                Boolean bool = Boolean.TRUE;
                                ai2Var.e = null;
                                ai2Var.f = an1Var;
                                ai2Var.i = i;
                                ai2Var.n = 2;
                                objO6 = o("wifi", bool, ai2Var);
                                if (objO6 != t70Var) {
                                    an1 an1Var3 = an1Var;
                                    obj = objO6;
                                    an1Var2 = an1Var3;
                                    jl2Var = (jl2) obj;
                                    an1Var2.h(null);
                                    return jl2Var;
                                }
                            } else if (g31.a(str, "device.wifi.disable")) {
                                Boolean bool2 = Boolean.FALSE;
                                ai2Var.e = null;
                                ai2Var.f = an1Var;
                                ai2Var.i = i;
                                ai2Var.n = 3;
                                objO5 = o("wifi", bool2, ai2Var);
                                if (objO5 != t70Var) {
                                    an1 an1Var4 = an1Var;
                                    obj = objO5;
                                    an1Var2 = an1Var4;
                                    jl2Var = (jl2) obj;
                                    an1Var2.h(null);
                                    return jl2Var;
                                }
                            } else if (g31.a(str, "device.wifi.toggle")) {
                                ai2Var.e = null;
                                ai2Var.f = an1Var;
                                ai2Var.i = i;
                                ai2Var.n = 4;
                                objO4 = o("wifi", null, ai2Var);
                                if (objO4 != t70Var) {
                                    an1 an1Var5 = an1Var;
                                    obj = objO4;
                                    an1Var2 = an1Var5;
                                    jl2Var = (jl2) obj;
                                    an1Var2.h(null);
                                    return jl2Var;
                                }
                            } else if (g31.a(str, "device.bluetooth.enable")) {
                                Boolean bool3 = Boolean.TRUE;
                                ai2Var.e = null;
                                ai2Var.f = an1Var;
                                ai2Var.i = i;
                                ai2Var.n = 5;
                                objO3 = o("bluetooth", bool3, ai2Var);
                                if (objO3 != t70Var) {
                                    an1 an1Var6 = an1Var;
                                    obj = objO3;
                                    an1Var2 = an1Var6;
                                    jl2Var = (jl2) obj;
                                    an1Var2.h(null);
                                    return jl2Var;
                                }
                            } else {
                                if (g31.a(str, "device.bluetooth.disable")) {
                                    if (g31.a(str, "device.bluetooth.toggle")) {
                                        ai2Var.e = null;
                                        ai2Var.f = an1Var;
                                        ai2Var.i = i;
                                        ai2Var.n = 7;
                                        objO = o("bluetooth", null, ai2Var);
                                        if (objO != t70Var) {
                                            an1 an1Var7 = an1Var;
                                            obj = objO;
                                            an1Var2 = an1Var7;
                                            jl2Var = (jl2) obj;
                                        }
                                    } else {
                                        if (g31.a(str, "device.wifi.settings")) {
                                            jl2VarN = n("wifi");
                                        } else if (g31.a(str, "device.bluetooth.settings")) {
                                            jl2VarN = n("bluetooth");
                                        } else {
                                            strC = f5Var.c("settings_page");
                                            if (strC == null) {
                                                strC = "general";
                                            }
                                            jl2VarN = n(strC);
                                        }
                                        an1 an1Var8 = an1Var;
                                        jl2Var = jl2VarN;
                                        an1Var2 = an1Var8;
                                    }
                                    an1Var2.h(null);
                                    return jl2Var;
                                }
                                Boolean bool4 = Boolean.FALSE;
                                ai2Var.e = null;
                                ai2Var.f = an1Var;
                                ai2Var.i = i;
                                ai2Var.n = 6;
                                objO2 = o("bluetooth", bool4, ai2Var);
                                if (objO2 != t70Var) {
                                    an1 an1Var9 = an1Var;
                                    obj = objO2;
                                    an1Var2 = an1Var9;
                                    jl2Var = (jl2) obj;
                                    an1Var2.h(null);
                                    return jl2Var;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            this = an1Var;
                            this.h(null);
                            throw th;
                        }
                    }
                    return t70Var;
                case 1:
                    int i4 = ai2Var.i;
                    an1 an1Var10 = ai2Var.f;
                    f5 f5Var2 = ai2Var.e;
                    bz3.g(obj);
                    an1Var = an1Var10;
                    i = i4;
                    f5Var = f5Var2;
                    str = f5Var.a;
                    if (g31.a(str, "device.wifi.enable")) {
                        Boolean bool5 = Boolean.TRUE;
                        ai2Var.e = null;
                        ai2Var.f = an1Var;
                        ai2Var.i = i;
                        ai2Var.n = 2;
                        objO6 = o("wifi", bool5, ai2Var);
                        if (objO6 != t70Var) {
                            an1 an1Var11 = an1Var;
                            obj = objO6;
                            an1Var2 = an1Var11;
                            jl2Var = (jl2) obj;
                            an1Var2.h(null);
                            return jl2Var;
                        }
                    } else if (g31.a(str, "device.wifi.disable")) {
                        Boolean bool6 = Boolean.FALSE;
                        ai2Var.e = null;
                        ai2Var.f = an1Var;
                        ai2Var.i = i;
                        ai2Var.n = 3;
                        objO5 = o("wifi", bool6, ai2Var);
                        if (objO5 != t70Var) {
                            an1 an1Var12 = an1Var;
                            obj = objO5;
                            an1Var2 = an1Var12;
                            jl2Var = (jl2) obj;
                            an1Var2.h(null);
                            return jl2Var;
                        }
                    } else if (g31.a(str, "device.wifi.toggle")) {
                        ai2Var.e = null;
                        ai2Var.f = an1Var;
                        ai2Var.i = i;
                        ai2Var.n = 4;
                        objO4 = o("wifi", null, ai2Var);
                        if (objO4 != t70Var) {
                            an1 an1Var13 = an1Var;
                            obj = objO4;
                            an1Var2 = an1Var13;
                            jl2Var = (jl2) obj;
                            an1Var2.h(null);
                            return jl2Var;
                        }
                    } else if (g31.a(str, "device.bluetooth.enable")) {
                        Boolean bool7 = Boolean.TRUE;
                        ai2Var.e = null;
                        ai2Var.f = an1Var;
                        ai2Var.i = i;
                        ai2Var.n = 5;
                        objO3 = o("bluetooth", bool7, ai2Var);
                        if (objO3 != t70Var) {
                            an1 an1Var14 = an1Var;
                            obj = objO3;
                            an1Var2 = an1Var14;
                            jl2Var = (jl2) obj;
                            an1Var2.h(null);
                            return jl2Var;
                        }
                    } else {
                        if (g31.a(str, "device.bluetooth.disable")) {
                            if (g31.a(str, "device.bluetooth.toggle")) {
                                ai2Var.e = null;
                                ai2Var.f = an1Var;
                                ai2Var.i = i;
                                ai2Var.n = 7;
                                objO = o("bluetooth", null, ai2Var);
                                if (objO != t70Var) {
                                    an1 an1Var15 = an1Var;
                                    obj = objO;
                                    an1Var2 = an1Var15;
                                    jl2Var = (jl2) obj;
                                }
                            } else {
                                if (g31.a(str, "device.wifi.settings")) {
                                    jl2VarN = n("wifi");
                                } else if (g31.a(str, "device.bluetooth.settings")) {
                                    jl2VarN = n("bluetooth");
                                } else {
                                    strC = f5Var.c("settings_page");
                                    if (strC == null) {
                                        strC = "general";
                                    }
                                    jl2VarN = n(strC);
                                }
                                an1 an1Var16 = an1Var;
                                jl2Var = jl2VarN;
                                an1Var2 = an1Var16;
                            }
                            an1Var2.h(null);
                            return jl2Var;
                        }
                        Boolean bool8 = Boolean.FALSE;
                        ai2Var.e = null;
                        ai2Var.f = an1Var;
                        ai2Var.i = i;
                        ai2Var.n = 6;
                        objO2 = o("bluetooth", bool8, ai2Var);
                        if (objO2 != t70Var) {
                            an1 an1Var17 = an1Var;
                            obj = objO2;
                            an1Var2 = an1Var17;
                            jl2Var = (jl2) obj;
                            an1Var2.h(null);
                            return jl2Var;
                        }
                    }
                    return t70Var;
                case 2:
                    an1Var2 = ai2Var.f;
                    bz3.g(obj);
                    jl2Var = (jl2) obj;
                    an1Var2.h(null);
                    return jl2Var;
                case 3:
                    an1Var2 = ai2Var.f;
                    bz3.g(obj);
                    jl2Var = (jl2) obj;
                    an1Var2.h(null);
                    return jl2Var;
                case 4:
                    an1Var2 = ai2Var.f;
                    bz3.g(obj);
                    jl2Var = (jl2) obj;
                    an1Var2.h(null);
                    return jl2Var;
                case 5:
                    an1Var2 = ai2Var.f;
                    bz3.g(obj);
                    jl2Var = (jl2) obj;
                    an1Var2.h(null);
                    return jl2Var;
                case 6:
                    an1Var2 = ai2Var.f;
                    bz3.g(obj);
                    jl2Var = (jl2) obj;
                    an1Var2.h(null);
                    return jl2Var;
                case 7:
                    an1Var2 = ai2Var.f;
                    bz3.g(obj);
                    jl2Var = (jl2) obj;
                    an1Var2.h(null);
                    return jl2Var;
                default:
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        return a32.a;
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final List k() {
        return ii0.a;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.f;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "Settings shortcuts";
    }

    public final jl2 n(String str) {
        wt1 wt1Var;
        String strV;
        if (str.equals("wifi") || str.equals("bluetooth")) {
            this.d.b(str, null);
        }
        String packageName = this.a.getPackageName();
        packageName.getClass();
        ni2 ni2VarC = i34.c(str, packageName);
        Intent intent = ni2VarC.a;
        String str2 = ni2VarC.b;
        n21 n21Var = this.b;
        t61 t61VarA = n21Var.a(intent, str2);
        if (t61VarA instanceof q61) {
            Intent intent2 = new Intent("android.settings.SETTINGS");
            wt1Var = new wt1(n21Var.a(intent2, "settings"), new ni2(intent2, "settings", false));
        } else {
            wt1Var = new wt1(t61VarA, ni2VarC);
        }
        t61 t61Var = (t61) wt1Var.a;
        ni2 ni2Var = (ni2) wt1Var.b;
        if (!(t61Var instanceof p61)) {
            return q(str, t61Var);
        }
        p22 p22VarF = (str.equals("wifi") || str.equals("bluetooth")) ? this.c.f(str) : null;
        int i = p22VarF == null ? -1 : zh2.a[p22VarF.ordinal()];
        if (i != 1) {
            strV = i != 2 ? "" : cq.v(Padder.FALLBACK_PADDING_STRING, p(str), " is off.");
        } else {
            strV = cq.v(Padder.FALLBACK_PADDING_STRING, p(str), " is on.");
        }
        return new il2(ky0.l("I've opened ", ni2Var.b, ".", ni2Var != ni2VarC ? " That exact screen isn't on this phone, so this is the closest." : "", strV), new d73("device.settings.open", "Settings launch accepted by ".concat(((p61) t61Var).a)), null, null, 12);
    }

    /* JADX WARN: Code duplicated, block: B:174:0x0388  */
    /* JADX WARN: Code duplicated, block: B:23:0x007a  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:57:0x0124  */
    /* JADX WARN: Code duplicated, block: B:58:0x0126  */
    /* JADX WARN: Code duplicated, block: B:61:0x013a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0143  */
    /* JADX WARN: Code duplicated, block: B:64:0x0149  */
    /* JADX WARN: Code duplicated, block: B:67:0x0162  */
    /* JADX WARN: Code duplicated, block: B:71:0x0179  */
    /* JADX WARN: Code duplicated, block: B:74:0x0186  */
    /* JADX WARN: Code duplicated, block: B:76:0x018b  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:90:0x01cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:92:0x01cf  */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b8, code lost:
    
        if ((r1 instanceof defpackage.ej2) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e4, code lost:
    
        if (r1 == r15) goto L95;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x00fe, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r12v0, types: [si2] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x009a -> B:33:0x009f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r27, java.lang.Boolean r28, defpackage.y50 r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci2.o(java.lang.String, java.lang.Boolean, y50):java.lang.Object");
    }

    @Override // defpackage.bl2
    public final void f() {
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
