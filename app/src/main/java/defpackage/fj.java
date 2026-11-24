package defpackage;

import android.util.Range;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fj {
    public static final Range f = new Range(0, 0);
    public final Size a;
    public final ig0 b;
    public final Range c;
    public final s30 d;
    public final boolean e;

    public fj(Size size, ig0 ig0Var, Range range, s30 s30Var, boolean z) {
        this.a = size;
        this.b = ig0Var;
        this.c = range;
        this.d = s30Var;
        this.e = z;
    }

    public final cj a() {
        cj cjVar = new cj();
        cjVar.b = this.a;
        cjVar.a = this.b;
        cjVar.c = this.c;
        cjVar.e = this.d;
        cjVar.f = Boolean.valueOf(this.e);
        return cjVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fj) {
            fj fjVar = (fj) obj;
            if (this.a.equals(fjVar.a) && this.b.equals(fjVar.b) && this.c.equals(fjVar.c)) {
                s30 s30Var = fjVar.d;
                s30 s30Var2 = this.d;
                if (s30Var2 != null ? s30Var2.equals(s30Var) : s30Var == null) {
                    if (this.e == fjVar.e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003;
        s30 s30Var = this.d;
        return (this.e ? 1231 : 1237) ^ ((iHashCode ^ (s30Var == null ? 0 : s30Var.hashCode())) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StreamSpec{resolution=");
        sb.append(this.a);
        sb.append(", dynamicRange=");
        sb.append(this.b);
        sb.append(", expectedFrameRateRange=");
        sb.append(this.c);
        sb.append(", implementationOptions=");
        sb.append(this.d);
        sb.append(", zslDisabled=");
        return ky0.o(sb, this.e, "}");
    }
}
