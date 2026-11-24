package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ov1 implements rv1 {
    public final f5 a;
    public final String b;
    public final String c;
    public final l82 d;

    public ov1(f5 f5Var, String str, String str2, l82 l82Var) {
        str.getClass();
        l82Var.getClass();
        this.a = f5Var;
        this.b = str;
        this.c = str2;
        this.d = l82Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ov1)) {
            return false;
        }
        ov1 ov1Var = (ov1) obj;
        return this.a.equals(ov1Var.a) && g31.a(this.b, ov1Var.b) && this.c.equals(ov1Var.c) && this.d == ov1Var.d;
    }

    @Override // defpackage.rv1
    public final f5 getIntent() {
        return this.a;
    }

    public final int hashCode() {
        return this.d.hashCode() + ky0.d(ky0.d(this.a.hashCode() * 31, 31, this.b), 31, this.c);
    }

    public final String toString() {
        return "Confirmation(intent=" + this.a + ", skillId=" + this.b + ", prompt=" + this.c + ", risk=" + this.d + ")";
    }
}
