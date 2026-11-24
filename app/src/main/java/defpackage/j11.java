package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j11 {
    public final h11 a;

    public j11(h11 h11Var) {
        this.a = h11Var;
    }

    public static j11 a(Object obj) {
        if (obj == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 31 ? new j11(new i11(obj)) : new j11(new h11(obj));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j11)) {
            return false;
        }
        return this.a.equals(((j11) obj).a);
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    public final String toString() {
        return this.a.a.toString();
    }
}
