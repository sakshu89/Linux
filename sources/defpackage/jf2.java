package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jf2 {
    public final if2 a;
    public final if2 b;
    public final boolean c;

    public jf2(if2 if2Var, if2 if2Var2, boolean z) {
        this.a = if2Var;
        this.b = if2Var2;
        this.c = z;
    }

    public static jf2 a(jf2 jf2Var, if2 if2Var, if2 if2Var2, boolean z, int i) {
        if ((i & 1) != 0) {
            if2Var = jf2Var.a;
        }
        if ((i & 2) != 0) {
            if2Var2 = jf2Var.b;
        }
        jf2Var.getClass();
        return new jf2(if2Var, if2Var2, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jf2)) {
            return false;
        }
        jf2 jf2Var = (jf2) obj;
        return g31.a(this.a, jf2Var.a) && g31.a(this.b, jf2Var.b) && this.c == jf2Var.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "Selection(start=" + this.a + ", end=" + this.b + ", handlesCrossed=" + this.c + ')';
    }
}
