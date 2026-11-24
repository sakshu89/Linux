package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class go2 implements nm0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ so2 b;

    public /* synthetic */ go2(so2 so2Var, int i) {
        this.a = i;
        this.b = so2Var;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) throws IllegalAccessException, InvocationTargetException {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        Object value6;
        yq2 yq2Var;
        rn2 rn2Var;
        String str;
        int i = this.a;
        q43 q43Var = q43.a;
        so2 so2Var = this.b;
        switch (i) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                if (!so2Var.o()) {
                    jr2 jr2Var = so2Var.n;
                    do {
                        value = jr2Var.getValue();
                    } while (!jr2Var.h(value, eo2.a((eo2) value, null, null, null, null, null, null, null, null, false, false, false, zBooleanValue, false, null, 0L, 30719)));
                }
                break;
            case 1:
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                jr2 jr2Var2 = so2Var.n;
                do {
                    value2 = jr2Var2.getValue();
                } while (!jr2Var2.h(value2, eo2.a((eo2) value2, null, null, null, null, null, null, null, null, false, false, false, false, zBooleanValue2, null, 0L, 28671)));
                break;
            case 2:
                boolean zBooleanValue3 = ((Boolean) obj).booleanValue();
                if (!so2Var.o()) {
                    jr2 jr2Var3 = so2Var.n;
                    if (zBooleanValue3) {
                        do {
                            value3 = jr2Var3.getValue();
                        } while (!jr2Var3.h(value3, eo2.a((eo2) value3, null, null, null, null, null, null, null, null, false, false, false, false, false, null, 0L, 24575)));
                    } else {
                        do {
                            value4 = jr2Var3.getValue();
                        } while (!jr2Var3.h(value4, eo2.a((eo2) value4, null, null, null, null, null, null, null, null, false, false, false, false, false, "Voice pack not ready. Tap DOWNLOAD HINDI VOICE in Setup.", 0L, 24575)));
                    }
                }
                break;
            case 3:
                List list = (List) obj;
                jr2 jr2Var4 = so2Var.n;
                do {
                    value5 = jr2Var4.getValue();
                } while (!jr2Var4.h(value5, eo2.a((eo2) value5, null, null, null, null, null, null, null, list, false, false, false, false, false, null, 0L, 32639)));
                break;
            case 4:
                g5 g5Var = (g5) obj;
                so2Var.D = g5Var.i;
                so2Var.B = g5Var.h;
                so2Var.v = g5Var.d;
                if (!so2Var.o()) {
                    so2Var.F = null;
                }
                Boolean bool = so2Var.s;
                boolean zBooleanValue4 = bool != null ? bool.booleanValue() : g5Var.c;
                if (zBooleanValue4) {
                    so2Var.E = false;
                }
                if (so2Var.r && !zBooleanValue4) {
                    if (so2Var.i.b == so2Var) {
                        so2Var.l.b();
                    }
                    if (so2Var.x && (yq2Var = so2Var.z) != null) {
                        yq2Var.e(null);
                    }
                }
                so2Var.r = zBooleanValue4;
                jr2 jr2Var5 = so2Var.n;
                do {
                    value6 = jr2Var5.getValue();
                } while (!jr2Var5.h(value6, eo2.a((eo2) value6, null, null, null, null, null, null, null, null, false, zBooleanValue4, false, false, false, null, 0L, 32255)));
                so2Var.i();
                break;
            case 5:
                ((Boolean) obj).getClass();
                so2Var.i();
                break;
            case 6:
                so2Var.t((e5) obj);
                break;
            default:
                ee1 ee1Var = (ee1) obj;
                boolean z = ee1Var.a;
                String str2 = ee1Var.d;
                String str3 = ee1Var.e;
                boolean z2 = true;
                boolean z3 = z && !so2Var.G;
                so2Var.G = z;
                if (so2Var.o()) {
                    boolean z4 = so2Var.E;
                    boolean z5 = !z4 && ee1Var.a;
                    rn2 rn2Var2 = rn2.c;
                    rn2 rn2Var3 = z5 ? rn2Var2 : (z4 || str3 == null || !cs2.n(str3, "failed", true)) ? rn2.b : rn2.u;
                    jr2 jr2Var6 = so2Var.n;
                    while (true) {
                        Object value7 = jr2Var6.getValue();
                        jr2 jr2Var7 = jr2Var6;
                        eo2 eo2Var = (eo2) value7;
                        boolean z6 = (so2Var.b.g.e.a.getValue() != null || eo2Var.a.b()) ? z2 : false;
                        boolean z7 = (so2Var.E || !ee1Var.b) ? false : z2;
                        String str4 = so2Var.F;
                        if (str4 == null) {
                            str4 = ee1Var.c;
                        }
                        String str5 = str4;
                        String str6 = ((!z6 || cs2.A(eo2Var.c)) && !cs2.A(str2)) ? str2 : eo2Var.c;
                        String str7 = so2Var.E ? null : str3;
                        String str8 = (!z6 && z5) ? "LIVE" : eo2Var.b;
                        if (z6) {
                            rn2Var = eo2Var.a;
                        } else if (z3 && z5) {
                            rn2Var = rn2Var3;
                        } else {
                            Set setC = wh2.c(rn2.i, rn2.e, rn2.j);
                            rn2Var = eo2Var.a;
                            if (!setC.contains(rn2Var) && (z5 || rn2Var == rn2Var2)) {
                                rn2Var = rn2Var3;
                            }
                        }
                        if (!jr2Var7.h(value7, eo2.a(eo2Var, rn2Var, str8, str6, null, str5, null, null, null, z5, false, false, z7, false, str7, 0L, 22248))) {
                            jr2Var6 = jr2Var7;
                            z2 = true;
                        } else if (z3 && so2Var.r && !so2Var.E && (str = so2Var.F) != null) {
                            so2Var.F = null;
                            if (!so2Var.k.n(str)) {
                                so2Var.F = str;
                            }
                        }
                    }
                }
                break;
        }
        return q43Var;
    }
}
