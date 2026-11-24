package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bw2 implements ew2 {
    public final AccessibilityNodeInfo a;
    public final String b;
    public final float c;
    public final boolean d;

    public bw2(AccessibilityNodeInfo accessibilityNodeInfo, String str, float f, boolean z) {
        accessibilityNodeInfo.getClass();
        str.getClass();
        this.a = accessibilityNodeInfo;
        this.b = str;
        this.c = f;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bw2)) {
            return false;
        }
        bw2 bw2Var = (bw2) obj;
        return g31.a(this.a, bw2Var.a) && g31.a(this.b, bw2Var.b) && Float.compare(this.c, bw2Var.c) == 0 && this.d == bw2Var.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + cq.b(ky0.d(this.a.hashCode() * 31, 31, this.b), this.c, 31);
    }

    public final String toString() {
        return "GroundedNode(node=" + this.a + ", label=" + this.b + ", confidence=" + this.c + ", allowAncestorClick=" + this.d + ")";
    }
}
