package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fc2 {
    public final String a;
    public final int b;
    public final Rect c;

    public fc2(String str, int i, Rect rect) {
        this.a = str;
        this.b = i;
        this.c = rect;
    }

    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fc2)) {
            return false;
        }
        fc2 fc2Var = (fc2) obj;
        return this.a.equals(fc2Var.a) && this.b == fc2Var.b && this.c.equals(fc2Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "ScreenFrame(packageName=" + this.a + ", windowId=" + this.b + ", bounds=" + this.c + ")";
    }
}
