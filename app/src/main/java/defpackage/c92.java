package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c92 {
    public float a;
    public boolean b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c92)) {
            return false;
        }
        c92 c92Var = (c92) obj;
        return Float.compare(this.a, c92Var.a) == 0 && this.b == c92Var.b;
    }

    public final int hashCode() {
        return ky0.e(Float.hashCode(this.a) * 31, 961, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RowColumnParentData(weight=");
        sb.append(this.a);
        sb.append(", fill=");
        return ky0.o(sb, this.b, ", crossAxisAlignment=null, flowLayoutData=null)");
    }
}
