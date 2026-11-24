package defpackage;

import android.util.Size;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mj {
    public final Size a;
    public final HashMap b;
    public final Size c;
    public final HashMap d;
    public final Size e;
    public final HashMap f;
    public final HashMap g;

    public mj(Size size, HashMap map, Size size2, HashMap map2, Size size3, HashMap map3, HashMap map4) {
        if (size == null) {
            dk0.n("Null analysisSize");
            throw null;
        }
        this.a = size;
        this.b = map;
        if (size2 == null) {
            dk0.n("Null previewSize");
            throw null;
        }
        this.c = size2;
        this.d = map2;
        if (size3 == null) {
            dk0.n("Null recordSize");
            throw null;
        }
        this.e = size3;
        this.f = map3;
        this.g = map4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof mj)) {
            return false;
        }
        mj mjVar = (mj) obj;
        return this.a.equals(mjVar.a) && this.b.equals(mjVar.b) && this.c.equals(mjVar.c) && this.d.equals(mjVar.d) && this.e.equals(mjVar.e) && this.f.equals(mjVar.f) && this.g.equals(mjVar.g);
    }

    public final int hashCode() {
        return this.g.hashCode() ^ ((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003);
    }

    public final String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.a + ", s720pSizeMap=" + this.b + ", previewSize=" + this.c + ", s1440pSizeMap=" + this.d + ", recordSize=" + this.e + ", maximumSizeMap=" + this.f + ", ultraMaximumSizeMap=" + this.g + "}";
    }
}
