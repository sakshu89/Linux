package defpackage;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kj {
    public final int a;
    public final Surface b;

    public kj(int i, Surface surface) {
        this.a = i;
        if (surface != null) {
            this.b = surface;
        } else {
            dk0.n("Null surface");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kj)) {
            return false;
        }
        kj kjVar = (kj) obj;
        return this.a == kjVar.a && this.b.equals(kjVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "Result{resultCode=" + this.a + ", surface=" + this.b + "}";
    }
}
