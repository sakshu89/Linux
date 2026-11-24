package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e40 {
    public final e4 a = new e4(8);
    public d40 b;

    public final synchronized d40 a() {
        d40 d40Var = this.b;
        if (d40Var == null) {
            return null;
        }
        if (((Number) this.a.a()).longValue() - d40Var.c <= 30000) {
            return d40Var;
        }
        this.b = null;
        return null;
    }

    public final synchronized void b(String str, Boolean bool) {
        str.getClass();
        String string = cs2.V(str).toString();
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = string.toLowerCase(locale);
        lowerCase.getClass();
        if (lowerCase.equals("wifi") || lowerCase.equals("bluetooth")) {
            this.b = new d40(lowerCase, bool, ((Number) this.a.a()).longValue());
        }
    }
}
