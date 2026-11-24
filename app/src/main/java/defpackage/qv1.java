package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qv1 implements rv1 {
    public final f5 a;
    public final String b;
    public final yx c;
    public final boolean d;

    public qv1(f5 f5Var, String str, yx yxVar, boolean z) {
        str.getClass();
        this.a = f5Var;
        this.b = str;
        this.c = yxVar;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qv1)) {
            return false;
        }
        qv1 qv1Var = (qv1) obj;
        return this.a.equals(qv1Var.a) && g31.a(this.b, qv1Var.b) && this.c.equals(qv1Var.c) && this.d == qv1Var.d;
    }

    @Override // defpackage.rv1
    public final f5 getIntent() {
        return this.a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + ((this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b)) * 31);
    }

    public final String toString() {
        return "Question(intent=" + this.a + ", skillId=" + this.b + ", clarification=" + this.c + ", alreadyConfirmed=" + this.d + ")";
    }
}
