package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jb2 implements lb2 {
    public final AccessibilityNodeInfo a;
    public final String b;

    public jb2(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        accessibilityNodeInfo.getClass();
        str.getClass();
        this.a = accessibilityNodeInfo;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jb2)) {
            return false;
        }
        jb2 jb2Var = (jb2) obj;
        return g31.a(this.a, jb2Var.a) && g31.a(this.b, jb2Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Found(node=" + this.a + ", label=" + this.b + ")";
    }
}
