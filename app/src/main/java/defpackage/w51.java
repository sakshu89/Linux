package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w51 {
    public final Float a;
    public tg0 b;

    public w51(Float f, tg0 tg0Var) {
        this.a = f;
        this.b = tg0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w51)) {
            return false;
        }
        w51 w51Var = (w51) obj;
        return w51Var.a.equals(this.a) && g31.a(w51Var.b, this.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + ky0.a(0, this.a.hashCode() * 31, 31);
    }
}
