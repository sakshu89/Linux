package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g9 {
    public final Context a;
    public final jc0 b;
    public final long c;
    public final qt1 d;

    public g9(Context context, jc0 jc0Var, long j, qt1 qt1Var) {
        this.a = context;
        this.b = jc0Var;
        this.c = j;
        this.d = qt1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!g9.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        g9 g9Var = (g9) obj;
        return g31.a(this.a, g9Var.a) && g31.a(this.b, g9Var.b) && sz.c(this.c, g9Var.c) && g31.a(this.d, g9Var.d);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        int i = sz.h;
        return this.d.hashCode() + cq.c(iHashCode, 31, this.c);
    }
}
