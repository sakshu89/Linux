package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z93 {
    public final String a;
    public final List b;
    public final String c;
    public int d;
    public boolean e;
    public boolean f;
    public final List g;
    public final List h;

    public z93(int i, String str, String str2, List list) {
        str2 = (i & 4) != 0 ? null : str2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        str.getClass();
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = 0;
        this.e = false;
        this.f = false;
        this.g = arrayList;
        this.h = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z93)) {
            return false;
        }
        z93 z93Var = (z93) obj;
        return g31.a(this.a, z93Var.a) && g31.a(this.b, z93Var.b) && g31.a(this.c, z93Var.c) && this.d == z93Var.d && this.e == z93Var.e && this.f == z93Var.f && g31.a(this.g, z93Var.g) && g31.a(this.h, z93Var.h);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        String str = this.c;
        return this.h.hashCode() + ((this.g.hashCode() + ky0.e(ky0.e(ky0.a(this.d, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31), 31, this.e), 31, this.f)) * 31);
    }

    public final String toString() {
        return "Draft(body=" + this.a + ", targets=" + this.b + ", packageName=" + this.c + ", next=" + this.d + ", needsOpen=" + this.e + ", needsDraftVerification=" + this.f + ", confirmed=" + this.g + ", unconfirmed=" + this.h + ")";
    }
}
