package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mk0 {
    public static final mk0 b = new mk0(new k23((al0) null, (zw) null, (LinkedHashMap) null, 127));
    public static final mk0 c = new mk0(new k23((al0) null, (zw) null, (LinkedHashMap) null, 95));
    public final k23 a;

    public mk0(k23 k23Var) {
        this.a = k23Var;
    }

    public final mk0 a(mk0 mk0Var) {
        k23 k23Var = mk0Var.a;
        al0 al0Var = k23Var.a;
        k23 k23Var2 = this.a;
        if (al0Var == null) {
            al0Var = k23Var2.a;
        }
        zw zwVar = k23Var.b;
        if (zwVar == null) {
            zwVar = k23Var2.b;
        }
        return new mk0(new k23(al0Var, zwVar, k23Var.c || k23Var2.c, bh1.e(k23Var2.d, k23Var.d)));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof mk0) && ((mk0) obj).a.equals(this.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        if (equals(b)) {
            return "ExitTransition.None";
        }
        if (equals(c)) {
            return "ExitTransition.KeepUntilTransitionsFinished";
        }
        StringBuilder sb = new StringBuilder("ExitTransition: \nFade - ");
        k23 k23Var = this.a;
        al0 al0Var = k23Var.a;
        sb.append(al0Var != null ? al0Var.toString() : null);
        sb.append(",\nSlide - null,\nShrink - ");
        zw zwVar = k23Var.b;
        sb.append(zwVar != null ? zwVar.toString() : null);
        sb.append(",\nScale - null,\nKeepUntilTransitionsFinished - ");
        sb.append(k23Var.c);
        return sb.toString();
    }
}
