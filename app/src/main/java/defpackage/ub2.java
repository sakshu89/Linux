package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ub2 {
    public final AccessibilityNodeInfo a;
    public final String b;

    public ub2(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        this.a = accessibilityNodeInfo;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ub2)) {
            return false;
        }
        ub2 ub2Var = (ub2) obj;
        return this.a.equals(ub2Var.a) && g31.a(this.b, ub2Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "Row(node=" + this.a + ", label=" + this.b + ")";
    }
}
