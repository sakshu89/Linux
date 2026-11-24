package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i60 {
    public static final i60 i = new i60(0, null, null, null, null, null, null, null);
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public i60(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i60)) {
            return false;
        }
        i60 i60Var = (i60) obj;
        if (this.a != i60Var.a) {
            return false;
        }
        String str = i60Var.b;
        String str2 = this.b;
        if (str2 == null) {
            if (str == null) {
                zA = true;
            } else {
                zA = false;
            }
        } else if (str == null) {
            zA = false;
        } else {
            zA = g31.a(str2, str);
        }
        return zA && g31.a(this.c, i60Var.c) && g31.a(this.d, i60Var.d) && g31.a(this.e, i60Var.e) && g31.a(this.f, i60Var.f) && g31.a(this.g, i60Var.g) && g31.a(this.h, i60Var.h);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.g;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.h;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        String str = this.b;
        if (str == null) {
            str = "null";
        }
        return "ConversationSnapshot(turnIndex=" + this.a + ", lastAction=" + str + ", lastContactName=" + this.c + ", lastContactNumber=" + this.d + ", lastAppPackage=" + this.e + ", lastMediaPackage=" + this.f + ", lastQuery=" + this.g + ", lastReferent=" + this.h + ")";
    }
}
