package defpackage;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nl {
    public final ColorFilter a;
    public final long b;
    public final int c;

    public nl(int i, long j) {
        ColorFilter porterDuffColorFilter;
        if (Build.VERSION.SDK_INT >= 29) {
            t6.e();
            porterDuffColorFilter = t6.c(ki4.g(j), jc4.b(i));
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(ki4.g(j), jc4.c(i));
        }
        this.a = porterDuffColorFilter;
        this.b = j;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nl)) {
            return false;
        }
        nl nlVar = (nl) obj;
        return sz.c(this.b, nlVar.b) && this.c == nlVar.c;
    }

    public final int hashCode() {
        int i = sz.h;
        return Integer.hashCode(this.c) + (Long.hashCode(this.b) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BlendModeColorFilter(color=");
        ky0.v(this.b, sb, ", blendMode=");
        sb.append((Object) mf4.c(this.c));
        sb.append(')');
        return sb.toString();
    }
}
