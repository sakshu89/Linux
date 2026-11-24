package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cj2 implements fj2 {
    public final String a;
    public final Boolean b;
    public final boolean c;

    public cj2(String str, Boolean bool, boolean z) {
        str.getClass();
        this.a = str;
        this.b = bool;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cj2)) {
            return false;
        }
        cj2 cj2Var = (cj2) obj;
        return g31.a(this.a, cj2Var.a) && g31.a(this.b, cj2Var.b) && this.c == cj2Var.c;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Boolean bool = this.b;
        return Boolean.hashCode(this.c) + ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TimedOut(setting=");
        sb.append(this.a);
        sb.append(", lastObservedOn=");
        sb.append(this.b);
        sb.append(", clickDispatched=");
        return ky0.o(sb, this.c, ")");
    }
}
