package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xv1 {
    public final tv1 a = new tv1(2);
    public wv1 b;

    public final synchronized void a() {
        this.b = null;
    }

    public final synchronized wv1 b() {
        wv1 wv1Var = this.b;
        if (wv1Var == null) {
            return null;
        }
        if (((Number) this.a.a()).longValue() - wv1Var.e <= 120000) {
            return wv1Var;
        }
        this.b = null;
        return null;
    }

    public final synchronized void c(String str, String str2, String str3, List list) {
        str.getClass();
        list.getClass();
        this.b = new wv1(str, str2, list, ((Number) this.a.a()).longValue(), str3);
    }
}
