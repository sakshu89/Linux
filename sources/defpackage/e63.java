package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class e63 {
    public static final gy0 a = new gy0(lp1.a, 0, 0);

    public static final a23 a(q83 q83Var, be beVar) {
        a23 a23VarA = q83Var.a(beVar);
        int length = beVar.b.length();
        be beVar2 = a23VarA.a;
        mp1 mp1Var = a23VarA.b;
        int length2 = beVar2.b.length();
        int iMin = Math.min(length, 100);
        for (int i = 0; i < iMin; i++) {
            b(mp1Var.l(i), length2, i);
        }
        b(mp1Var.l(length), length2, length);
        int iMin2 = Math.min(length2, 100);
        for (int i2 = 0; i2 < iMin2; i2++) {
            c(mp1Var.k(i2), length, i2);
        }
        c(mp1Var.k(length2), length, length2);
        return new a23(beVar2, new gy0(mp1Var, beVar.b.length(), beVar2.b.length()));
    }

    public static final void b(int i, int i2, int i3) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbP = cq.p("OffsetMapping.originalToTransformed returned invalid mapping: ", i3, " -> ", i, " is not in range of transformed text [0, ");
        sbP.append(i2);
        sbP.append(']');
        c11.c(sbP.toString());
    }

    public static final void c(int i, int i2, int i3) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbP = cq.p("OffsetMapping.transformedToOriginal returned invalid mapping: ", i3, " -> ", i, " is not in range of original text [0, ");
        sbP.append(i2);
        sbP.append(']');
        c11.c(sbP.toString());
    }
}
