package defpackage;

import android.graphics.Rect;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hp1 {
    public final String a;
    public final String b;
    public final String c;
    public final Rect d;
    public final ArrayList e;

    public hp1(String str, String str2, String str3, Rect rect, ArrayList arrayList) {
        str.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = rect;
        this.e = arrayList;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        String str = this.b;
        if (str != null && !cs2.A(str)) {
            sb.append(" by " + str);
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hp1)) {
            return false;
        }
        hp1 hp1Var = (hp1) obj;
        return g31.a(this.a, hp1Var.a) && g31.a(this.b, hp1Var.b) && this.c.equals(hp1Var.c) && this.d.equals(hp1Var.d) && this.e.equals(hp1Var.e);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return this.e.hashCode() + ((this.d.hashCode() + ky0.d((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.c)) * 31);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("OcrRow(title=", this.a, ", artist=", this.b, ", type=");
        sbQ.append(this.c);
        sbQ.append(", bounds=");
        sbQ.append(this.d);
        sbQ.append(", elements=");
        sbQ.append(this.e);
        sbQ.append(")");
        return sbQ.toString();
    }
}
