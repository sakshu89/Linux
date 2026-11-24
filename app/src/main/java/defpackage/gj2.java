package defpackage;

import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gj2 {
    public final boolean a;
    public final String b;
    public final String c;
    public final boolean d;
    public final e51 e;
    public final s51 f;
    public final boolean g;
    public final l82 h;
    public final boolean i;
    public final b60 j;
    public final String k;
    public final String l;
    public final String m;
    public final boolean n;
    public final boolean o;
    public final l61 p;
    public final boolean q;
    public final List r;
    public final List s;
    public final boolean t;
    public final String u;
    public final String v;

    public gj2(boolean z, String str, String str2, boolean z2, e51 e51Var, s51 s51Var, boolean z3, l82 l82Var, boolean z4, b60 b60Var, String str3, String str4, String str5, boolean z5, boolean z6, l61 l61Var, boolean z7, List list, List list2, boolean z8, String str6, String str7) {
        e51Var.getClass();
        s51Var.getClass();
        l82Var.getClass();
        b60Var.getClass();
        l61Var.getClass();
        list.getClass();
        list2.getClass();
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = z2;
        this.e = e51Var;
        this.f = s51Var;
        this.g = z3;
        this.h = l82Var;
        this.i = z4;
        this.j = b60Var;
        this.k = str3;
        this.l = str4;
        this.m = str5;
        this.n = z5;
        this.o = z6;
        this.p = l61Var;
        this.q = z7;
        this.r = list;
        this.s = list2;
        this.t = z8;
        this.u = str6;
        this.v = str7;
    }

    public static gj2 a(gj2 gj2Var, boolean z, String str, String str2, boolean z2, e51 e51Var, s51 s51Var, boolean z3, l82 l82Var, boolean z4, b60 b60Var, String str3, String str4, String str5, boolean z5, boolean z6, l61 l61Var, boolean z7, List list, List list2, boolean z8, String str6, String str7, int i) {
        boolean z9 = (i & 1) != 0 ? gj2Var.a : z;
        String str8 = (i & 2) != 0 ? gj2Var.b : str;
        String str9 = (i & 4) != 0 ? gj2Var.c : str2;
        boolean z10 = (i & 8) != 0 ? gj2Var.d : z2;
        e51 e51Var2 = (i & 16) != 0 ? gj2Var.e : e51Var;
        s51 s51Var2 = (i & 32) != 0 ? gj2Var.f : s51Var;
        boolean z11 = (i & 64) != 0 ? gj2Var.g : z3;
        l82 l82Var2 = (i & 128) != 0 ? gj2Var.h : l82Var;
        boolean z12 = (i & 256) != 0 ? gj2Var.i : z4;
        b60 b60Var2 = (i & 512) != 0 ? gj2Var.j : b60Var;
        String str10 = (i & 1024) != 0 ? gj2Var.k : str3;
        String str11 = (i & 2048) != 0 ? gj2Var.l : str4;
        String str12 = (i & 4096) != 0 ? gj2Var.m : str5;
        boolean z13 = (i & 8192) != 0 ? gj2Var.n : z5;
        boolean z14 = z9;
        boolean z15 = (i & 16384) != 0 ? gj2Var.o : z6;
        l61 l61Var2 = (i & 32768) != 0 ? gj2Var.p : l61Var;
        boolean z16 = (i & 65536) != 0 ? gj2Var.q : z7;
        List list3 = (i & Normalizer.INPUT_IS_FCD) != 0 ? gj2Var.r : list;
        List list4 = (i & ArabicShaping.TASHKEEL_BEGIN) != 0 ? gj2Var.s : list2;
        boolean z17 = (i & ArabicShaping.TASHKEEL_RESIZE) != 0 ? gj2Var.t : z8;
        String str13 = (i & 1048576) != 0 ? gj2Var.u : str6;
        String str14 = (i & ArabicShaping.SEEN_TWOCELL_NEAR) != 0 ? gj2Var.v : str7;
        gj2Var.getClass();
        e51Var2.getClass();
        s51Var2.getClass();
        l82Var2.getClass();
        b60Var2.getClass();
        l61Var2.getClass();
        list3.getClass();
        list4.getClass();
        return new gj2(z14, str8, str9, z10, e51Var2, s51Var2, z11, l82Var2, z12, b60Var2, str10, str11, str12, z13, z15, l61Var2, z16, list3, list4, z17, str13, str14);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gj2)) {
            return false;
        }
        gj2 gj2Var = (gj2) obj;
        return this.a == gj2Var.a && this.b.equals(gj2Var.b) && g31.a(this.c, gj2Var.c) && this.d == gj2Var.d && this.e == gj2Var.e && g31.a(this.f, gj2Var.f) && this.g == gj2Var.g && this.h == gj2Var.h && this.i == gj2Var.i && this.j == gj2Var.j && this.k.equals(gj2Var.k) && this.l.equals(gj2Var.l) && g31.a(this.m, gj2Var.m) && this.n == gj2Var.n && this.o == gj2Var.o && this.p == gj2Var.p && this.q == gj2Var.q && g31.a(this.r, gj2Var.r) && g31.a(this.s, gj2Var.s) && this.t == gj2Var.t && g31.a(this.u, gj2Var.u) && g31.a(this.v, gj2Var.v);
    }

    public final int hashCode() {
        int iD = ky0.d(Boolean.hashCode(this.a) * 31, 31, this.b);
        String str = this.c;
        int iD2 = ky0.d(ky0.d((this.j.hashCode() + ky0.e((this.h.hashCode() + ky0.e((this.f.hashCode() + ((this.e.hashCode() + ky0.e((iD + (str == null ? 0 : str.hashCode())) * 31, 31, this.d)) * 31)) * 31, 31, this.g)) * 31, 31, this.i)) * 31, 31, this.k), 31, this.l);
        String str2 = this.m;
        int iE = ky0.e((this.s.hashCode() + ((this.r.hashCode() + ky0.e((this.p.hashCode() + ky0.e(ky0.e((iD2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.n), 31, this.o)) * 31, 31, this.q)) * 31)) * 31, 31, this.t);
        String str3 = this.u;
        int iHashCode = (iE + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.v;
        return iHashCode + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        return "SettingsUiState(cloudEnabled=" + this.a + ", providerId=" + this.b + ", activeModel=" + this.c + ", hasKey=" + this.d + ", keyBacking=" + this.e + ", keyTest=" + this.f + ", supportsModelSelection=" + this.g + ", confirmationThreshold=" + this.h + ", ambientListening=" + this.i + ", conversationMode=" + this.j + ", liveVoice=" + this.k + ", liveModel=" + this.l + ", activeLiveModel=" + this.m + ", screenReadingEnabled=" + this.n + ", directWhatsAppMessages=" + this.o + ", language=" + this.p + ", honorificEnabled=" + this.q + ", runtimePermissions=" + this.r + ", specialPermissions=" + this.s + ", isAssistantRoleHeld=" + this.t + ", notice=" + this.u + ", resolutionNotice=" + this.v + ")";
    }
}
