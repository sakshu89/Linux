package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jz2 {
    public final hp2 a;
    public final hp2 b;
    public final hp2 c;
    public final hp2 d;

    public jz2(hp2 hp2Var, hp2 hp2Var2, hp2 hp2Var3, hp2 hp2Var4) {
        this.a = hp2Var;
        this.b = hp2Var2;
        this.c = hp2Var3;
        this.d = hp2Var4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof jz2)) {
            return false;
        }
        jz2 jz2Var = (jz2) obj;
        return g31.a(this.a, jz2Var.a) && g31.a(this.b, jz2Var.b) && g31.a(this.c, jz2Var.c) && g31.a(this.d, jz2Var.d);
    }

    public final int hashCode() {
        hp2 hp2Var = this.a;
        int iHashCode = (hp2Var != null ? hp2Var.hashCode() : 0) * 31;
        hp2 hp2Var2 = this.b;
        int iHashCode2 = (iHashCode + (hp2Var2 != null ? hp2Var2.hashCode() : 0)) * 31;
        hp2 hp2Var3 = this.c;
        int iHashCode3 = (iHashCode2 + (hp2Var3 != null ? hp2Var3.hashCode() : 0)) * 31;
        hp2 hp2Var4 = this.d;
        return iHashCode3 + (hp2Var4 != null ? hp2Var4.hashCode() : 0);
    }
}
