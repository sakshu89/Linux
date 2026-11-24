package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yl2 {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final AccessibilityNodeInfo f;
    public final ArrayList g;

    public yl2(String str, int i, String str2, String str3, String str4, AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = accessibilityNodeInfo;
        this.g = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yl2)) {
            return false;
        }
        yl2 yl2Var = (yl2) obj;
        return this.a.equals(yl2Var.a) && this.b == yl2Var.b && this.c.equals(yl2Var.c) && this.d.equals(yl2Var.d) && this.e.equals(yl2Var.e) && g31.a(this.f, yl2Var.f) && this.g.equals(yl2Var.g);
    }

    public final int hashCode() {
        int iD = ky0.d(ky0.d(ky0.d(ky0.a(this.b, this.a.hashCode() * 31, 31), 31, this.c), 31, this.d), 31, this.e);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f;
        return this.g.hashCode() + ((iD + (accessibilityNodeInfo == null ? 0 : accessibilityNodeInfo.hashCode())) * 31);
    }

    public final String toString() {
        return "View(packageName=" + this.a + ", windowId=" + this.b + ", recipient=" + this.c + ", body=" + this.d + ", composerId=" + this.e + ", send=" + this.f + ", messages=" + this.g + ")";
    }
}
