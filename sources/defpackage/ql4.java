package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ql4 {
    public static final j70 a(j70 j70Var, j70 j70Var2, boolean z) {
        Boolean bool = Boolean.FALSE;
        int i = 5;
        boolean zBooleanValue = ((Boolean) j70Var.y(new ag(i), bool)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) j70Var2.y(new ag(i), bool)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return j70Var.r(j70Var2);
        }
        ag agVar = new ag(3);
        gi0 gi0Var = gi0.a;
        j70 j70Var3 = (j70) j70Var.y(agVar, gi0Var);
        Object objY = j70Var2;
        if (zBooleanValue2) {
            objY = j70Var2.y(new ag(4), gi0Var);
        }
        return j70Var3.r((j70) objY);
    }

    public static final j70 b(s70 s70Var, j70 j70Var) {
        j70 j70VarA = a(s70Var.o(), j70Var, true);
        xa0 xa0Var = ld0.a;
        return (j70VarA == xa0Var || j70VarA.v(qs4.c) != null) ? j70VarA : j70VarA.r(xa0Var);
    }

    public static final l43 c(x50 x50Var, j70 j70Var, Object obj) {
        l43 l43Var = null;
        if ((x50Var instanceof u70) && j70Var.v(bw.c) != null) {
            u70 u70VarD = (u70) x50Var;
            while (!(u70VarD instanceof id0) && (u70VarD = u70VarD.d()) != null) {
                if (u70VarD instanceof l43) {
                    l43Var = (l43) u70VarD;
                    break;
                }
            }
            if (l43Var != null) {
                l43Var.y0(j70Var, obj);
            }
        }
        return l43Var;
    }
}
