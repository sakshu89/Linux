package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pv1 implements rv1 {
    public final f5 a;
    public final String b;
    public final ArrayList c;
    public final boolean d;

    public pv1(f5 f5Var, String str, ArrayList arrayList, boolean z) {
        f5Var.getClass();
        str.getClass();
        this.a = f5Var;
        this.b = str;
        this.c = arrayList;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pv1)) {
            return false;
        }
        pv1 pv1Var = (pv1) obj;
        return g31.a(this.a, pv1Var.a) && g31.a(this.b, pv1Var.b) && this.c.equals(pv1Var.c) && this.d == pv1Var.d;
    }

    @Override // defpackage.rv1
    public final f5 getIntent() {
        return this.a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + ((this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b)) * 31);
    }

    public final String toString() {
        return "Permission(intent=" + this.a + ", skillId=" + this.b + ", permissions=" + this.c + ", alreadyConfirmed=" + this.d + ")";
    }
}
