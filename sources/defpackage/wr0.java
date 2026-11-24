package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wr0 implements xr0 {
    public final int a;
    public final String b;
    public final Throwable c;

    public wr0(int i, String str, Exception exc) {
        str.getClass();
        this.a = i;
        this.b = str;
        this.c = exc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wr0)) {
            return false;
        }
        wr0 wr0Var = (wr0) obj;
        return this.a == wr0Var.a && g31.a(this.b, wr0Var.b) && g31.a(this.c, wr0Var.c);
    }

    public final int hashCode() {
        int iD = ky0.d(Integer.hashCode(this.a) * 31, 31, this.b);
        Throwable th = this.c;
        return iD + (th == null ? 0 : th.hashCode());
    }

    public final String toString() {
        return "Error(code=" + this.a + ", message=" + this.b + ", cause=" + this.c + ")";
    }
}
