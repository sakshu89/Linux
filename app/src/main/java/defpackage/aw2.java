package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class aw2 implements ew2 {
    public final Rect a;
    public final String b;
    public final float c;

    public aw2(Rect rect, String str, float f) {
        this.a = rect;
        this.b = str;
        this.c = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aw2)) {
            return false;
        }
        aw2 aw2Var = (aw2) obj;
        return this.a.equals(aw2Var.a) && this.b.equals(aw2Var.b) && Float.compare(this.c, aw2Var.c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.c) + ky0.d(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return "GroundedBounds(bounds=" + this.a + ", label=" + this.b + ", confidence=" + this.c + ")";
    }
}
