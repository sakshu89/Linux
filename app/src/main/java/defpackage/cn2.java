package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cn2 extends hn {
    public final long a;

    public cn2(long j) {
        this.a = j;
    }

    @Override // defpackage.hn
    public final void a(float f, long j, fa faVar) {
        faVar.c(1.0f);
        long jB = this.a;
        if (f != 1.0f) {
            jB = sz.b(sz.d(jB) * f, jB);
        }
        faVar.e(jB);
        if (faVar.c != null) {
            faVar.h(null);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cn2) {
            return sz.c(this.a, ((cn2) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        int i = sz.h;
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return "SolidColor(value=" + ((Object) sz.i(this.a)) + ')';
    }
}
