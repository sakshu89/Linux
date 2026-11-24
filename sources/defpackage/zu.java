package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zu {
    public final AccessibilityNodeInfo a;
    public final String b;

    public zu(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        this.a = accessibilityNodeInfo;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zu)) {
            return false;
        }
        zu zuVar = (zu) obj;
        return this.a.equals(zuVar.a) && this.b.equals(zuVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Control(node=" + this.a + ", label=" + this.b + ")";
    }
}
