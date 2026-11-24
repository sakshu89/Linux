package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class v12 extends pp implements c51 {
    public final boolean j;

    public v12(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.j = false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v12) {
            v12 v12Var = (v12) obj;
            return f().equals(v12Var.f()) && this.e.equals(v12Var.e) && this.f.equals(v12Var.f) && g31.a(this.b, v12Var.b);
        }
        if (obj instanceof c51) {
            return obj.equals(h());
        }
        return false;
    }

    public final w41 h() {
        if (this.j) {
            return this;
        }
        w41 w41Var = this.a;
        if (w41Var != null) {
            return w41Var;
        }
        w41 w41VarD = d();
        this.a = w41VarD;
        return w41VarD;
    }

    public final int hashCode() {
        return this.f.hashCode() + ky0.d(f().hashCode() * 31, 31, this.e);
    }

    public final String toString() {
        w41 w41VarH = h();
        return w41VarH != this ? w41VarH.toString() : cq.n(new StringBuilder("property "), this.e, " (Kotlin reflection is not available)");
    }
}
