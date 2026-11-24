package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r3 implements v3 {
    public final String a;
    public final List b;
    public final List c;
    public final List d;

    public r3(String str, List list, ArrayList arrayList, ArrayList arrayList2, int i) {
        List list2 = (i & 4) != 0 ? list : arrayList;
        List list3 = (i & 8) != 0 ? ii0.a : arrayList2;
        str.getClass();
        list.getClass();
        list2.getClass();
        this.a = str;
        this.b = list;
        this.c = list2;
        this.d = list3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r3)) {
            return false;
        }
        r3 r3Var = (r3) obj;
        return g31.a(this.a, r3Var.a) && g31.a(this.b, r3Var.b) && this.c.equals(r3Var.c) && this.d.equals(r3Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Ambiguous(target=" + this.a + ", candidates=" + this.b + ", values=" + this.c + ", spotifyCandidates=" + this.d + ")";
    }
}
