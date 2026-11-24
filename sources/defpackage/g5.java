package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g5 {
    public final l82 a;
    public final q03 b;
    public final boolean c;
    public final b60 d;
    public final String e;
    public final String f;
    public final boolean g;
    public final l61 h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    public g5(l82 l82Var, q03 q03Var, boolean z, b60 b60Var, String str, String str2, boolean z2, l61 l61Var, boolean z3, boolean z4, boolean z5) {
        l61Var.getClass();
        this.a = l82Var;
        this.b = q03Var;
        this.c = z;
        this.d = b60Var;
        this.e = str;
        this.f = str2;
        this.g = z2;
        this.h = l61Var;
        this.i = z3;
        this.j = z4;
        this.k = z5;
    }

    public final boolean a() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g5)) {
            return false;
        }
        g5 g5Var = (g5) obj;
        return this.a == g5Var.a && this.b == g5Var.b && this.c == g5Var.c && this.d == g5Var.d && this.e.equals(g5Var.e) && this.f.equals(g5Var.f) && this.g == g5Var.g && this.h == g5Var.h && this.i == g5Var.i && this.j == g5Var.j && this.k == g5Var.k;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.k) + ky0.e(ky0.e((this.h.hashCode() + ky0.e(ky0.d(ky0.d((this.d.hashCode() + ky0.e((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c)) * 31, 31, this.e), 31, this.f), 31, this.g)) * 31, 31, this.i), 31, this.j);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AgentSettings(confirmationThreshold=");
        sb.append(this.a);
        sb.append(", tier=");
        sb.append(this.b);
        sb.append(", ambientListening=");
        sb.append(this.c);
        sb.append(", conversationMode=");
        sb.append(this.d);
        sb.append(", liveVoice=");
        sb.append(this.e);
        sb.append(", liveModel=");
        sb.append(this.f);
        sb.append(", setupComplete=");
        sb.append(this.g);
        sb.append(", language=");
        sb.append(this.h);
        sb.append(", screenReadingEnabled=");
        sb.append(this.i);
        sb.append(", directWhatsAppMessages=");
        sb.append(this.j);
        sb.append(", honorificEnabled=");
        return ky0.o(sb, this.k, ")");
    }
}
