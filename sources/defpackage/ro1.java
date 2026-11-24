package defpackage;

import com.ibm.icu.impl.locale.LanguageTag;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ro1 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final Long g;
    public final Long h;

    public ro1(String str, String str2, String str3, String str4, String str5, boolean z, Long l, Long l2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = z;
        this.g = l;
        this.h = l2;
    }

    public final String a() {
        String str = LanguageTag.SEP;
        String str2 = this.c;
        if (str2 == null) {
            str2 = LanguageTag.SEP;
        }
        String str3 = this.d;
        if (str3 != null) {
            str = str3;
        }
        return "package=" + this.a + " playing=" + this.f + " title=" + str2 + " artist=" + str;
    }

    public final String b() {
        String str = this.b;
        String str2 = this.c;
        if (str2 == null) {
            return cq.v("Something is playing", str != null ? " in ".concat(str) : "", ", but the app isn't saying what.");
        }
        String str3 = this.d;
        String strConcat = str3 != null ? " by ".concat(str3) : null;
        if (strConcat == null) {
            strConcat = "";
        }
        String strConcat2 = str != null ? ", on ".concat(str) : null;
        return ky0.k(str2, strConcat, strConcat2 != null ? strConcat2 : "", ".");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ro1)) {
            return false;
        }
        ro1 ro1Var = (ro1) obj;
        return this.a.equals(ro1Var.a) && g31.a(this.b, ro1Var.b) && g31.a(this.c, ro1Var.c) && g31.a(this.d, ro1Var.d) && g31.a(this.e, ro1Var.e) && this.f == ro1Var.f && g31.a(this.g, ro1Var.g) && g31.a(this.h, ro1Var.h);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int iE = ky0.e((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31, 31, this.f);
        Long l = this.g;
        int iHashCode5 = (iE + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.h;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("NowPlaying(packageName=", this.a, ", appLabel=", this.b, ", title=");
        sbQ.append(this.c);
        sbQ.append(", artist=");
        sbQ.append(this.d);
        sbQ.append(", album=");
        sbQ.append(this.e);
        sbQ.append(", isPlaying=");
        sbQ.append(this.f);
        sbQ.append(", positionMillis=");
        sbQ.append(this.g);
        sbQ.append(", durationMillis=");
        sbQ.append(this.h);
        sbQ.append(")");
        return sbQ.toString();
    }
}
