package defpackage;

import android.graphics.Rect;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vp2 {
    public final String a;
    public final Rect b;
    public final List c;

    public vp2(String str, Rect rect, List list) {
        str.getClass();
        this.a = str;
        this.b = rect;
        this.c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vp2)) {
            return false;
        }
        vp2 vp2Var = (vp2) obj;
        return g31.a(this.a, vp2Var.a) && this.b.equals(vp2Var.b) && this.c.equals(vp2Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "OcrLine(text=" + this.a + ", bounds=" + this.b + ", elements=" + this.c + ")";
    }
}
