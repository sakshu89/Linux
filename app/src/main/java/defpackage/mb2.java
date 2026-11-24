package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mb2 {
    public final AccessibilityNodeInfo a;
    public final String b;
    public final Rect c;

    public mb2(AccessibilityNodeInfo accessibilityNodeInfo, String str, Rect rect) {
        str.getClass();
        this.a = accessibilityNodeInfo;
        this.b = str;
        this.c = rect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mb2)) {
            return false;
        }
        mb2 mb2Var = (mb2) obj;
        return this.a.equals(mb2Var.a) && g31.a(this.b, mb2Var.b) && this.c.equals(mb2Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return "VisibleVideo(node=" + this.a + ", title=" + this.b + ", bounds=" + this.c + ")";
    }
}
