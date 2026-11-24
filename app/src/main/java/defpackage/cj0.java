package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cj0 {
    public static final cj0 b = new cj0(new k23((al0) null, (zw) null, (LinkedHashMap) null, 127));
    public final k23 a;

    public cj0(k23 k23Var) {
        this.a = k23Var;
    }

    public final cj0 a(cj0 cj0Var) {
        k23 k23Var = cj0Var.a;
        al0 al0Var = k23Var.a;
        k23 k23Var2 = this.a;
        if (al0Var == null) {
            al0Var = k23Var2.a;
        }
        zw zwVar = k23Var.b;
        if (zwVar == null) {
            zwVar = k23Var2.b;
        }
        return new cj0(new k23(al0Var, zwVar, bh1.e(k23Var2.d, k23Var.d), 32));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof cj0) && ((cj0) obj).a.equals(this.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        if (equals(b)) {
            return "EnterTransition.None";
        }
        StringBuilder sb = new StringBuilder("EnterTransition: \nFade - ");
        k23 k23Var = this.a;
        al0 al0Var = k23Var.a;
        sb.append(al0Var != null ? al0Var.toString() : null);
        sb.append(",\nSlide - null,\nShrink - ");
        zw zwVar = k23Var.b;
        return cq.n(sb, zwVar != null ? zwVar.toString() : null, ",\nScale - null");
    }
}
