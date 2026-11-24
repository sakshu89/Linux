package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wl2 {
    public final AccessibilityNodeInfo a;
    public final List b;

    public wl2(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        this.a = accessibilityNodeInfo;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wl2)) {
            return false;
        }
        wl2 wl2Var = (wl2) obj;
        return this.a.equals(wl2Var.a) && this.b.equals(wl2Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Node(node=" + this.a + ", path=" + this.b + ")";
    }
}
