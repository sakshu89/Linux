package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ee1 {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;

    public /* synthetic */ ee1(String str, int i) {
        this((i & 1) == 0, false, "", "", (i & 16) != 0 ? null : str);
    }

    public static ee1 a(ee1 ee1Var, boolean z, String str, String str2, String str3, int i) {
        boolean z2 = (i & 1) != 0 ? ee1Var.a : false;
        if ((i & 2) != 0) {
            z = ee1Var.b;
        }
        if ((i & 4) != 0) {
            str = ee1Var.c;
        }
        if ((i & 8) != 0) {
            str2 = ee1Var.d;
        }
        if ((i & 16) != 0) {
            str3 = ee1Var.e;
        }
        String str4 = str3;
        ee1Var.getClass();
        ee1Var.getClass();
        str.getClass();
        str2.getClass();
        String str5 = str2;
        return new ee1(z2, z, str, str5, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ee1)) {
            return false;
        }
        ee1 ee1Var = (ee1) obj;
        return this.a == ee1Var.a && this.b == ee1Var.b && g31.a(this.c, ee1Var.c) && g31.a(this.d, ee1Var.d) && g31.a(this.e, ee1Var.e);
    }

    public final int hashCode() {
        int iD = ky0.d(ky0.d(ky0.e(Boolean.hashCode(this.a) * 31, 31, this.b), 31, this.c), 31, this.d);
        String str = this.e;
        return Boolean.hashCode(false) + ((iD + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LiveState(active=");
        sb.append(this.a);
        sb.append(", speaking=");
        sb.append(this.b);
        sb.append(", heard=");
        sb.append(this.c);
        sb.append(", reply=");
        sb.append(this.d);
        sb.append(", notice=");
        return cq.n(sb, this.e, ", localListening=false)");
    }

    public ee1(boolean z, boolean z2, String str, String str2, String str3) {
        this.a = z;
        this.b = z2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }
}
