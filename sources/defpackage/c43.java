package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c43 implements h43 {
    public final boolean a;
    public final boolean b;

    public c43(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c43)) {
            return false;
        }
        c43 c43Var = (c43) obj;
        return this.a == c43Var.a && this.b == c43Var.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Boolean.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "LiveConversation(start=" + this.a + ", activate=" + this.b + ")";
    }
}
