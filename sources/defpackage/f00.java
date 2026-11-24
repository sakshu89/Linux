package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f00 implements uy2 {
    public final long a;

    public f00(long j) {
        this.a = j;
        if (j != 16) {
            return;
        }
        a11.a("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
    }

    @Override // defpackage.uy2
    public final float a() {
        return sz.d(this.a);
    }

    @Override // defpackage.uy2
    public final long c() {
        return this.a;
    }

    @Override // defpackage.uy2
    public final hn d() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f00) && sz.c(this.a, ((f00) obj).a);
    }

    public final int hashCode() {
        int i = sz.h;
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return "ColorStyle(value=" + ((Object) sz.i(this.a)) + ')';
    }
}
