package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eo2 {
    public final rn2 a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final List f;
    public final h52 g;
    public final List h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final String n;
    public final long o;

    public eo2(rn2 rn2Var, String str, String str2, String str3, String str4, List list, h52 h52Var, List list2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str5, long j) {
        rn2Var.getClass();
        list.getClass();
        list2.getClass();
        this.a = rn2Var;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = list;
        this.g = h52Var;
        this.h = list2;
        this.i = z;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        this.m = z5;
        this.n = str5;
        this.o = j;
    }

    public static eo2 a(eo2 eo2Var, rn2 rn2Var, String str, String str2, String str3, String str4, List list, h52 h52Var, List list2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str5, long j, int i) {
        rn2 rn2Var2 = (i & 1) != 0 ? eo2Var.a : rn2Var;
        String str6 = (i & 2) != 0 ? eo2Var.b : str;
        String str7 = (i & 4) != 0 ? eo2Var.c : str2;
        String str8 = (i & 8) != 0 ? eo2Var.d : str3;
        String str9 = (i & 16) != 0 ? eo2Var.e : str4;
        List list3 = (i & 32) != 0 ? eo2Var.f : list;
        h52 h52Var2 = (i & 64) != 0 ? eo2Var.g : h52Var;
        List list4 = (i & 128) != 0 ? eo2Var.h : list2;
        boolean z6 = (i & 256) != 0 ? eo2Var.i : z;
        boolean z7 = (i & 512) != 0 ? eo2Var.j : z2;
        boolean z8 = (i & 1024) != 0 ? eo2Var.k : z3;
        boolean z9 = (i & 2048) != 0 ? eo2Var.l : z4;
        boolean z10 = (i & 4096) != 0 ? eo2Var.m : z5;
        String str10 = (i & 8192) != 0 ? eo2Var.n : str5;
        rn2 rn2Var3 = rn2Var2;
        long j2 = (i & 16384) != 0 ? eo2Var.o : j;
        eo2Var.getClass();
        rn2Var3.getClass();
        str6.getClass();
        str7.getClass();
        list3.getClass();
        list4.getClass();
        return new eo2(rn2Var3, str6, str7, str8, str9, list3, h52Var2, list4, z6, z7, z8, z9, z10, str10, j2);
    }

    public final boolean b() {
        return this.a == rn2.w && !this.f.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eo2)) {
            return false;
        }
        eo2 eo2Var = (eo2) obj;
        return this.a == eo2Var.a && this.b.equals(eo2Var.b) && this.c.equals(eo2Var.c) && g31.a(this.d, eo2Var.d) && g31.a(this.e, eo2Var.e) && g31.a(this.f, eo2Var.f) && g31.a(this.g, eo2Var.g) && g31.a(this.h, eo2Var.h) && this.i == eo2Var.i && this.j == eo2Var.j && this.k == eo2Var.k && this.l == eo2Var.l && this.m == eo2Var.m && g31.a(this.n, eo2Var.n) && this.o == eo2Var.o;
    }

    public final int hashCode() {
        int iD = ky0.d(ky0.d(this.a.hashCode() * 31, 31, this.b), 31, this.c);
        String str = this.d;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode2 = (this.f.hashCode() + ((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        h52 h52Var = this.g;
        int iE = ky0.e(ky0.e(ky0.e(ky0.e(ky0.e((this.h.hashCode() + ((iHashCode2 + (h52Var == null ? 0 : h52Var.hashCode())) * 31)) * 31, 31, this.i), 31, this.j), 31, this.k), 31, this.l), 31, this.m);
        String str3 = this.n;
        return Long.hashCode(this.o) + ((iE + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "SonicUiState(phase=" + this.a + ", headline=" + this.b + ", message=" + this.c + ", detail=" + this.d + ", heard=" + this.e + ", options=" + this.f + ", remedy=" + this.g + ", transcript=" + this.h + ", isMicOpen=" + this.i + ", isAmbient=" + this.j + ", isOnline=" + this.k + ", isSpeaking=" + this.l + ", isMuted=" + this.m + ", notice=" + this.n + ", assistantEntryId=" + this.o + ")";
    }
}
