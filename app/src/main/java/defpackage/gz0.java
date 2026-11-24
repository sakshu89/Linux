package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gz0 {
    public final fz0 a;
    public final int b;

    public gz0(fz0 fz0Var, int i) {
        this.a = fz0Var;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gz0)) {
            return false;
        }
        gz0 gz0Var = (gz0) obj;
        return this.a.equals(gz0Var.a) && this.b == gz0Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ImageVectorEntry(imageVector=");
        sb.append(this.a);
        sb.append(", configFlags=");
        return ky0.m(sb, this.b, ')');
    }
}
