package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zb2 {
    public final AccessibilityNodeInfo a;
    public final AccessibilityNodeInfo b;
    public final String c;
    public final Rect d;
    public final String e;

    public zb2(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2, String str, Rect rect, String str2) {
        str.getClass();
        this.a = accessibilityNodeInfo;
        this.b = accessibilityNodeInfo2;
        this.c = str;
        this.d = rect;
        this.e = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zb2)) {
            return false;
        }
        zb2 zb2Var = (zb2) obj;
        return g31.a(this.a, zb2Var.a) && g31.a(this.b, zb2Var.b) && g31.a(this.c, zb2Var.c) && g31.a(this.d, zb2Var.d) && g31.a(this.e, zb2Var.e);
    }

    public final int hashCode() {
        int iHashCode = (this.d.hashCode() + ky0.d((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c)) * 31;
        String str = this.e;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Row(node=");
        sb.append(this.a);
        sb.append(", control=");
        sb.append(this.b);
        sb.append(", name=");
        sb.append(this.c);
        sb.append(", bounds=");
        sb.append(this.d);
        sb.append(", contentType=");
        return cq.n(sb, this.e, ")");
    }
}
