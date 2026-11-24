package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kz0 {
    public static final kz0 g = new kz0(false, 0, true, 1, 1, ne1.c);
    public final boolean a;
    public final int b;
    public final boolean c;
    public final int d;
    public final int e;
    public final ne1 f;

    public kz0(boolean z, int i, boolean z2, int i2, int i3, ne1 ne1Var) {
        this.a = z;
        this.b = i;
        this.c = z2;
        this.d = i2;
        this.e = i3;
        this.f = ne1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kz0)) {
            return false;
        }
        kz0 kz0Var = (kz0) obj;
        return this.a == kz0Var.a && this.b == kz0Var.b && this.c == kz0Var.c && this.d == kz0Var.d && this.e == kz0Var.e && g31.a(this.f, kz0Var.f);
    }

    public final int hashCode() {
        return this.f.a.hashCode() + ky0.a(this.e, ky0.a(this.d, ky0.e(ky0.a(this.b, Boolean.hashCode(this.a) * 31, 31), 31, this.c), 31), 961);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ImeOptions(singleLine=");
        sb.append(this.a);
        sb.append(", capitalization=");
        int i = this.b;
        if (i == -1) {
            str = "Unspecified";
        } else if (i == 0) {
            str = "None";
        } else if (i == 1) {
            str = "Characters";
        } else if (i == 2) {
            str = "Words";
        } else {
            str = i == 3 ? "Sentences" : "Invalid";
        }
        sb.append((Object) str);
        sb.append(", autoCorrect=");
        sb.append(this.c);
        sb.append(", keyboardType=");
        sb.append((Object) v51.a(this.d));
        sb.append(", imeAction=");
        sb.append((Object) jz0.a(this.e));
        sb.append(", platformImeOptions=null, hintLocales=");
        sb.append(this.f);
        sb.append(')');
        return sb.toString();
    }
}
