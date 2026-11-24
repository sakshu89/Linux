package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class of implements rf {
    public final String a;
    public final List b;

    public of(String str, List list) {
        this.a = str;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof of)) {
            return false;
        }
        of ofVar = (of) obj;
        return this.a.equals(ofVar.a) && this.b.equals(ofVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Ambiguous(query=" + this.a + ", candidates=" + this.b + ")";
    }
}
