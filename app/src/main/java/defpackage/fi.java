package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fi {
    public final st2 a;
    public final st2 b;
    public final ArrayList c;

    public fi(st2 st2Var, st2 st2Var2, ArrayList arrayList) {
        if (st2Var == null) {
            dk0.n("Null primarySurfaceEdge");
            throw null;
        }
        this.a = st2Var;
        if (st2Var2 == null) {
            dk0.n("Null secondarySurfaceEdge");
            throw null;
        }
        this.b = st2Var2;
        this.c = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fi)) {
            return false;
        }
        fi fiVar = (fi) obj;
        return this.a.equals(fiVar.a) && this.b.equals(fiVar.b) && this.c.equals(fiVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() ^ ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003);
    }

    public final String toString() {
        return "In{primarySurfaceEdge=" + this.a + ", secondarySurfaceEdge=" + this.b + ", outConfigs=" + this.c + "}";
    }
}
