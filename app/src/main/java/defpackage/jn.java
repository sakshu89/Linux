package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jn implements uy2 {
    public final tj2 a;
    public final float b;

    public jn(tj2 tj2Var, float f) {
        this.a = tj2Var;
        this.b = f;
    }

    @Override // defpackage.uy2
    public final float a() {
        return this.b;
    }

    @Override // defpackage.uy2
    public final long c() {
        int i = sz.h;
        return sz.g;
    }

    @Override // defpackage.uy2
    public final hn d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jn)) {
            return false;
        }
        jn jnVar = (jn) obj;
        return g31.a(this.a, jnVar.a) && Float.compare(this.b, jnVar.b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BrushStyle(value=");
        sb.append(this.a);
        sb.append(", alpha=");
        return cq.m(sb, this.b, ')');
    }
}
