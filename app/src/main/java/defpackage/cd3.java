package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cd3 {
    public final AccessibilityNodeInfo a;
    public final int b;
    public final Rect c;

    public cd3(AccessibilityNodeInfo accessibilityNodeInfo, int i, Rect rect) {
        this.a = accessibilityNodeInfo;
        this.b = i;
        this.c = rect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cd3)) {
            return false;
        }
        cd3 cd3Var = (cd3) obj;
        return this.a.equals(cd3Var.a) && this.b == cd3Var.b && this.c.equals(cd3Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "Candidate(node=" + this.a + ", rank=" + this.b + ", bounds=" + this.c + ")";
    }
}
