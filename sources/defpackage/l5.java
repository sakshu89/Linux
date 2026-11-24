package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l5 {
    public final String a;
    public final e33 b;
    public final String c;
    public final f5 d;
    public final String e;
    public final String f;
    public final String g;
    public final e73 h;
    public final h52 i;
    public final n43 j;
    public final boolean k;
    public final String l;

    public l5(String str, e33 e33Var, String str2, f5 f5Var, String str3, String str4, String str5, e73 e73Var, h52 h52Var, n43 n43Var, String str6, int i) {
        f5Var = (i & 8) != 0 ? null : f5Var;
        str3 = (i & 16) != 0 ? null : str3;
        str4 = (i & 32) != 0 ? null : str4;
        str5 = (i & 64) != 0 ? null : str5;
        e73Var = (i & 128) != 0 ? null : e73Var;
        h52Var = (i & 256) != 0 ? null : h52Var;
        n43Var = (i & 512) != 0 ? null : n43Var;
        boolean z = (i & 1024) == 0;
        str6 = (i & 2048) != 0 ? null : str6;
        str.getClass();
        str2.getClass();
        this.a = str;
        this.b = e33Var;
        this.c = str2;
        this.d = f5Var;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = e73Var;
        this.i = h52Var;
        this.j = n43Var;
        this.k = z;
        this.l = str6;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this != obj) {
            if (obj instanceof l5) {
                l5 l5Var = (l5) obj;
                if (g31.a(this.a, l5Var.a) && this.b == l5Var.b && g31.a(this.c, l5Var.c) && g31.a(this.d, l5Var.d)) {
                    String str = l5Var.e;
                    String str2 = this.e;
                    if (str2 == null) {
                        if (str == null) {
                            zEquals = true;
                        } else {
                            zEquals = false;
                        }
                    } else if (str == null) {
                        zEquals = false;
                    } else {
                        zEquals = str2.equals(str);
                    }
                    if (zEquals && g31.a(this.f, l5Var.f) && g31.a(this.g, l5Var.g) && g31.a(this.h, l5Var.h) && g31.a(this.i, l5Var.i) && g31.a(this.j, l5Var.j) && this.k == l5Var.k && g31.a(this.l, l5Var.l)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iD = ky0.d((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c);
        f5 f5Var = this.d;
        int iHashCode = (iD + (f5Var == null ? 0 : f5Var.hashCode())) * 31;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        e73 e73Var = this.h;
        int iHashCode5 = (iHashCode4 + (e73Var == null ? 0 : e73Var.hashCode())) * 31;
        h52 h52Var = this.i;
        int iHashCode6 = (iHashCode5 + (h52Var == null ? 0 : h52Var.hashCode())) * 31;
        n43 n43Var = this.j;
        int iE = ky0.e((iHashCode6 + (n43Var == null ? 0 : n43Var.hashCode())) * 31, 31, this.k);
        String str4 = this.l;
        return iE + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        String str = this.e;
        if (str == null) {
            str = "null";
        }
        return "AgentTurn(utterance=" + this.a + ", status=" + this.b + ", spoken=" + this.c + ", intent=" + this.d + ", skillId=" + str + ", detail=" + this.f + ", limitation=" + this.g + ", verification=" + this.h + ", remedy=" + this.i + ", undo=" + this.j + ", honorific=" + this.k + ", technical=" + this.l + ")";
    }
}
