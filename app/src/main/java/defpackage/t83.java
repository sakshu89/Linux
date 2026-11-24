package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t83 implements z83 {
    public final String a;
    public final ArrayList b;

    public t83(String str, ArrayList arrayList) {
        this.a = str;
        this.b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t83)) {
            return false;
        }
        t83 t83Var = (t83) obj;
        return this.a.equals(t83Var.a) && this.b.equals(t83Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Heard(text=" + this.a + ", alternatives=" + this.b + ")";
    }
}
