package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class il2 implements jl2 {
    public final String a;
    public final d73 b;
    public final n43 c;
    public final String d;

    public il2(String str, d73 d73Var, n43 n43Var, String str2) {
        str.getClass();
        this.a = str;
        this.b = d73Var;
        this.c = n43Var;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof il2)) {
            return false;
        }
        il2 il2Var = (il2) obj;
        return g31.a(this.a, il2Var.a) && g31.a(this.b, il2Var.b) && g31.a(this.c, il2Var.c) && g31.a(this.d, il2Var.d);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        n43 n43Var = this.c;
        int iHashCode2 = (iHashCode + (n43Var == null ? 0 : n43Var.hashCode())) * 31;
        String str = this.d;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "Success(spoken=" + this.a + ", verification=" + this.b + ", undo=" + this.c + ", detail=" + this.d + ")";
    }

    public /* synthetic */ il2(String str, d73 d73Var, n43 n43Var, String str2, int i) {
        this(str, d73Var, (i & 4) != 0 ? null : n43Var, (i & 8) != 0 ? null : str2);
    }
}
