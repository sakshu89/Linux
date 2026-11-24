package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ci extends y70 {
    public final Context a;
    public final wy b;
    public final wy c;
    public final String d;

    public ci(Context context, wy wyVar, wy wyVar2, String str) {
        if (context == null) {
            dk0.n("Null applicationContext");
            throw null;
        }
        this.a = context;
        if (wyVar == null) {
            dk0.n("Null wallClock");
            throw null;
        }
        this.b = wyVar;
        if (wyVar2 == null) {
            dk0.n("Null monotonicClock");
            throw null;
        }
        this.c = wyVar2;
        if (str != null) {
            this.d = str;
        } else {
            dk0.n("Null backendName");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y70) {
            ci ciVar = (ci) ((y70) obj);
            if (this.a.equals(ciVar.a) && this.b.equals(ciVar.b) && this.c.equals(ciVar.c) && this.d.equals(ciVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.d.hashCode() ^ ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.a);
        sb.append(", wallClock=");
        sb.append(this.b);
        sb.append(", monotonicClock=");
        sb.append(this.c);
        sb.append(", backendName=");
        return cq.n(sb, this.d, "}");
    }
}
