package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cl2 {
    public final q03 a;
    public final l82 b;
    public final boolean c;
    public final Locale d;
    public final boolean e;
    public final i60 f;

    public cl2(q03 q03Var, l82 l82Var, boolean z, Locale locale, boolean z2, i60 i60Var) {
        i60Var.getClass();
        this.a = q03Var;
        this.b = l82Var;
        this.c = z;
        this.d = locale;
        this.e = z2;
        this.f = i60Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cl2)) {
            return false;
        }
        cl2 cl2Var = (cl2) obj;
        return this.a == cl2Var.a && this.b == cl2Var.b && this.c == cl2Var.c && this.d.equals(cl2Var.d) && this.e == cl2Var.e && g31.a(this.f, cl2Var.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + ky0.e((this.d.hashCode() + ky0.e((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31, this.c)) * 31, 31, this.e);
    }

    public final String toString() {
        return "SkillContext(tier=" + this.a + ", confirmationThreshold=" + this.b + ", isOnline=" + this.c + ", locale=" + this.d + ", userConfirmed=" + this.e + ", conversation=" + this.f + ")";
    }
}
