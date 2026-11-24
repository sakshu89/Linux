package defpackage;

import android.util.Range;
import android.util.Size;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rh {
    public final hj a;
    public final int b;
    public final Size c;
    public final ig0 d;
    public final List e;
    public final s30 f;
    public final Range g;

    public rh(hj hjVar, int i, Size size, ig0 ig0Var, List list, s30 s30Var, Range range) {
        if (hjVar == null) {
            dk0.n("Null surfaceConfig");
            throw null;
        }
        this.a = hjVar;
        this.b = i;
        if (size == null) {
            dk0.n("Null size");
            throw null;
        }
        this.c = size;
        if (ig0Var == null) {
            dk0.n("Null dynamicRange");
            throw null;
        }
        this.d = ig0Var;
        if (list == null) {
            dk0.n("Null captureTypes");
            throw null;
        }
        this.e = list;
        this.f = s30Var;
        this.g = range;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof rh) {
            rh rhVar = (rh) obj;
            if (this.a.equals(rhVar.a) && this.b == rhVar.b && this.c.equals(rhVar.c) && this.d.equals(rhVar.d) && this.e.equals(rhVar.e)) {
                s30 s30Var = rhVar.f;
                s30 s30Var2 = this.f;
                if (s30Var2 != null ? s30Var2.equals(s30Var) : s30Var == null) {
                    Range range = rhVar.g;
                    Range range2 = this.g;
                    if (range2 != null ? range2.equals(range) : range == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        s30 s30Var = this.f;
        int iHashCode2 = (iHashCode ^ (s30Var == null ? 0 : s30Var.hashCode())) * 1000003;
        Range range = this.g;
        return iHashCode2 ^ (range != null ? range.hashCode() : 0);
    }

    public final String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.a + ", imageFormat=" + this.b + ", size=" + this.c + ", dynamicRange=" + this.d + ", captureTypes=" + this.e + ", implementationOptions=" + this.f + ", targetFrameRate=" + this.g + "}";
    }
}
