package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ob2 {
    public final String a;
    public final String b;
    public final String c;
    public final Rect d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final String i;
    public final boolean j;

    public ob2(String str, String str2, String str3, Rect rect, boolean z, boolean z2, boolean z3, int i, String str4, boolean z4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = rect;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = i;
        this.i = str4;
        this.j = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ob2)) {
            return false;
        }
        ob2 ob2Var = (ob2) obj;
        return g31.a(this.a, ob2Var.a) && g31.a(this.b, ob2Var.b) && g31.a(this.c, ob2Var.c) && g31.a(this.d, ob2Var.d) && this.e == ob2Var.e && this.f == ob2Var.f && this.g == ob2Var.g && this.h == ob2Var.h && g31.a(this.i, ob2Var.i) && this.j == ob2Var.j;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return Boolean.hashCode(this.j) + ky0.d(ky0.a(this.h, ky0.e(ky0.e(ky0.e((this.d.hashCode() + ky0.d((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.c)) * 31, 31, this.e), 31, this.f), 31, this.g), 31), 31, this.i);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("ScreenElement(text=", this.a, ", viewId=", this.b, ", className=");
        sbQ.append(this.c);
        sbQ.append(", bounds=");
        sbQ.append(this.d);
        sbQ.append(", isClickable=");
        sbQ.append(this.e);
        sbQ.append(", isEditable=");
        sbQ.append(this.f);
        sbQ.append(", isScrollable=");
        sbQ.append(this.g);
        sbQ.append(", depth=");
        sbQ.append(this.h);
        sbQ.append(", hintText=");
        sbQ.append(this.i);
        sbQ.append(", isFocused=");
        sbQ.append(this.j);
        sbQ.append(")");
        return sbQ.toString();
    }

    public /* synthetic */ ob2(String str, String str2, Rect rect) {
        this(str, null, str2, rect, false, false, false, 1, "", false);
    }
}
