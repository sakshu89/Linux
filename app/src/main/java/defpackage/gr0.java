package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class gr0 extends pp implements fr0, w41, rq0 {
    public final int j;

    public gr0(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.j = i;
    }

    @Override // defpackage.fr0
    public final int b() {
        return this.j;
    }

    @Override // defpackage.pp
    public final w41 d() {
        u42.a.getClass();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    public final boolean equals(Object obj) {
        ?? r2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof gr0) {
            gr0 gr0Var = (gr0) obj;
            return this.e.equals(gr0Var.e) && this.f.equals(gr0Var.f) && g31.a(this.b, gr0Var.b) && f().equals(gr0Var.f());
        }
        if (!(obj instanceof gr0)) {
            return false;
        }
        w41 w41Var = this.a;
        if (w41Var == null) {
            d();
            this.a = this;
            this = this;
        } else {
            r2 = w41Var;
        }
        return obj.equals(r2);
    }

    public final int hashCode() {
        f();
        return this.f.hashCode() + ky0.d(f().hashCode() * 31, 31, this.e);
    }

    public final String toString() {
        w41 w41Var = this.a;
        if (w41Var == null) {
            d();
            this.a = this;
            w41Var = this;
        }
        if (w41Var != this) {
            return w41Var.toString();
        }
        String str = this.e;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : cq.v("function ", str, " (Kotlin reflection is not available)");
    }

    public gr0(int i, Class cls, String str, String str2, int i2) {
        this(i, op.a, cls, str, str2, i2, 0);
    }
}
