package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gp1 {
    public final String a;
    public final Rect b;

    public gp1(String str, Rect rect) {
        this.a = str;
        this.b = rect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gp1)) {
            return false;
        }
        gp1 gp1Var = (gp1) obj;
        return this.a.equals(gp1Var.a) && this.b.equals(gp1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "OcrElement(text=" + this.a + ", bounds=" + this.b + ")";
    }
}
