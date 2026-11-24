package defpackage;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jv0 {
    public final ed3 a;
    public final AccessibilityNodeInfo b;
    public final Rect c;
    public final boolean d;
    public final String e;

    public jv0(ed3 ed3Var, AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, boolean z, String str) {
        this.a = ed3Var;
        this.b = accessibilityNodeInfo;
        this.c = rect;
        this.d = z;
        this.e = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jv0)) {
            return false;
        }
        jv0 jv0Var = (jv0) obj;
        return this.a == jv0Var.a && this.b.equals(jv0Var.b) && this.c.equals(jv0Var.c) && this.d == jv0Var.d && this.e.equals(jv0Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ky0.e((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31, 31, this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GroundedYouTubeTarget(type=");
        sb.append(this.a);
        sb.append(", node=");
        sb.append(this.b);
        sb.append(", bounds=");
        sb.append(this.c);
        sb.append(", isAlreadySatisfied=");
        sb.append(this.d);
        sb.append(", label=");
        return cq.n(sb, this.e, ")");
    }
}
