package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bw1 implements ew1 {
    public final ArrayList a;
    public final String b;

    public bw1(String str, ArrayList arrayList) {
        this.a = arrayList;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bw1)) {
            return false;
        }
        bw1 bw1Var = (bw1) obj;
        return this.a.equals(bw1Var.a) && this.b.equals(bw1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Ask(permissions=" + this.a + ", rationale=" + this.b + ")";
    }
}
