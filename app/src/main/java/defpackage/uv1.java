package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uv1 {
    public final tv1 a = new tv1(0);
    public sv1 b;

    public final synchronized void a() {
        this.b = null;
    }

    public final synchronized sv1 b() {
        sv1 sv1Var = this.b;
        if (sv1Var == null) {
            return null;
        }
        if (((Number) this.a.a()).longValue() - sv1Var.e <= 30000) {
            return sv1Var;
        }
        this.b = null;
        return null;
    }

    public final synchronized sv1 c(String str, String str2, Integer num, String str3, String str4) {
        Integer num2;
        Integer num3;
        String str5;
        str.getClass();
        sv1 sv1Var = this.b;
        if (sv1Var == null) {
            return null;
        }
        if (((Number) this.a.a()).longValue() - sv1Var.e > 30000) {
            this.b = null;
            return null;
        }
        if (!cs2.A(sv1Var.b) && !cs2.A(str) && sv1Var.b.equals(str) && ((num2 = sv1Var.f) == null || num2.equals(num))) {
            String str6 = sv1Var.g;
            boolean z = false;
            boolean z2 = (str6 == null || str3 == null || !wz3.a(str6, str3)) ? false : true;
            if (str.equals("com.google.android.youtube")) {
                x42 x42Var = yc3.a;
                if (yc3.m(sv1Var.a) && (num3 = sv1Var.f) != null && num3.equals(num) && (str5 = sv1Var.i) != null && str5.equals(str4)) {
                    z = true;
                }
            }
            if ((sv1Var.g == null || z2) && (z2 || z || !(cs2.A(sv1Var.c) || cs2.A(str2) || !sv1Var.c.equals(str2)))) {
                return sv1Var;
            }
            this.b = null;
            return null;
        }
        this.b = null;
        return null;
    }

    public final synchronized void d(String str, String str2, String str3, String str4, Integer num, String str5, Map map, String str6) {
        str4.getClass();
        map.getClass();
        if (cs2.A(str)) {
            return;
        }
        this.b = new sv1(str, str2, str3, str4, ((Number) this.a.a()).longValue(), num, str5, bh1.h(map), str6);
    }
}
