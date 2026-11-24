package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ec2 {
    public final sv1 a;
    public final fc2 b;

    public ec2(sv1 sv1Var, fc2 fc2Var) {
        fc2Var.getClass();
        this.a = sv1Var;
        this.b = fc2Var;
    }

    public final sv1 a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ec2)) {
            return false;
        }
        ec2 ec2Var = (ec2) obj;
        return this.a.equals(ec2Var.a) && g31.a(this.b, ec2Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "DeepRecovery(action=" + this.a + ", frame=" + this.b + ")";
    }
}
