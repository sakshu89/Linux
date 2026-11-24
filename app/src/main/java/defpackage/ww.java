package defpackage;

import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ww {
    public static final ww c = new ww(mz.Q(new ArrayList()), null);
    public final Set a;
    public final jh4 b;

    public ww(Set set, jh4 jh4Var) {
        this.a = set;
        this.b = jh4Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ww)) {
            return false;
        }
        ww wwVar = (ww) obj;
        return wwVar.a.equals(this.a) && g31.a(wwVar.b, this.b);
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() + 1517) * 41;
        jh4 jh4Var = this.b;
        return iHashCode + (jh4Var != null ? jh4Var.hashCode() : 0);
    }
}
