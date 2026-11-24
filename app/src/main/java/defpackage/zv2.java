package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zv2 implements ew2 {
    public final ArrayList a;
    public final List b;

    public zv2(ArrayList arrayList, List list) {
        this.a = arrayList;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zv2)) {
            return false;
        }
        zv2 zv2Var = (zv2) obj;
        return this.a.equals(zv2Var.a) && this.b.equals(zv2Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "AmbiguousCandidates(candidates=" + this.a + ", nodes=" + this.b + ")";
    }
}
