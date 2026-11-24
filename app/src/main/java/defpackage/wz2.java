package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wz2 {
    public final String a;
    public String b;
    public boolean c = false;
    public du1 d = null;

    public wz2(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wz2)) {
            return false;
        }
        wz2 wz2Var = (wz2) obj;
        return g31.a(this.a, wz2Var.a) && g31.a(this.b, wz2Var.b) && this.c == wz2Var.c && g31.a(this.d, wz2Var.d);
    }

    public final int hashCode() {
        int iE = ky0.e(ky0.d(this.a.hashCode() * 31, 31, this.b), 31, this.c);
        du1 du1Var = this.d;
        return iE + (du1Var == null ? 0 : du1Var.hashCode());
    }

    public final String toString() {
        return "TextSubstitution(layoutCache=" + this.d + ", isShowingSubstitution=" + this.c + ')';
    }
}
