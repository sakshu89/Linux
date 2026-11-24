package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qf implements rf {
    public final x11 a;
    public final String b;

    public qf(x11 x11Var, String str) {
        x11Var.getClass();
        this.a = x11Var;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qf)) {
            return false;
        }
        qf qfVar = (qf) obj;
        return g31.a(this.a, qfVar.a) && this.b.equals(qfVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Resolved(app=" + this.a + ", how=" + this.b + ")";
    }
}
