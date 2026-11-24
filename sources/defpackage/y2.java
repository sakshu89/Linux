package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y2 extends w2 {
    public static y2 e;
    public static final p62 f = p62.b;
    public static final p62 g = p62.a;
    public gz2 c;
    public gg2 d;

    @Override // defpackage.w2
    public final int[] a(int i) {
        int iE;
        if (c().length() > 0 && i < c().length()) {
            try {
                gg2 gg2Var = this.d;
                if (gg2Var == null) {
                    g31.f("node");
                    throw null;
                }
                l42 l42VarG = gg2Var.g();
                int iRound = Math.round(l42VarG.d - l42VarG.b);
                if (i <= 0) {
                    i = 0;
                }
                gz2 gz2Var = this.c;
                if (gz2Var == null) {
                    g31.f("layoutResult");
                    throw null;
                }
                int iD = gz2Var.b.d(i);
                gz2 gz2Var2 = this.c;
                if (gz2Var2 == null) {
                    g31.f("layoutResult");
                    throw null;
                }
                float f2 = gz2Var2.b.f(iD) + iRound;
                gz2 gz2Var3 = this.c;
                if (gz2Var3 == null) {
                    g31.f("layoutResult");
                    throw null;
                }
                fl1 fl1Var = gz2Var3.b;
                float f3 = fl1Var.f(fl1Var.f - 1);
                gz2 gz2Var4 = this.c;
                if (f2 < f3) {
                    if (gz2Var4 == null) {
                        g31.f("layoutResult");
                        throw null;
                    }
                    iE = gz2Var4.b.e(f2);
                } else {
                    if (gz2Var4 == null) {
                        g31.f("layoutResult");
                        throw null;
                    }
                    iE = gz2Var4.b.f;
                }
                return b(i, e(iE - 1, g) + 1);
            } catch (IllegalStateException unused) {
            }
        }
        return null;
    }

    @Override // defpackage.w2
    public final int[] d(int i) {
        int iE;
        if (c().length() > 0 && i > 0) {
            try {
                gg2 gg2Var = this.d;
                if (gg2Var == null) {
                    g31.f("node");
                    throw null;
                }
                l42 l42VarG = gg2Var.g();
                int iRound = Math.round(l42VarG.d - l42VarG.b);
                int length = c().length();
                if (length <= i) {
                    i = length;
                }
                gz2 gz2Var = this.c;
                if (gz2Var == null) {
                    g31.f("layoutResult");
                    throw null;
                }
                int iD = gz2Var.b.d(i);
                gz2 gz2Var2 = this.c;
                if (gz2Var2 == null) {
                    g31.f("layoutResult");
                    throw null;
                }
                float f2 = gz2Var2.b.f(iD) - iRound;
                if (f2 > 0.0f) {
                    gz2 gz2Var3 = this.c;
                    if (gz2Var3 == null) {
                        g31.f("layoutResult");
                        throw null;
                    }
                    iE = gz2Var3.b.e(f2);
                } else {
                    iE = 0;
                }
                if (i == c().length() && iE < iD) {
                    iE++;
                }
                return b(e(iE, f), i);
            } catch (IllegalStateException unused) {
            }
        }
        return null;
    }

    public final int e(int i, p62 p62Var) {
        gz2 gz2Var = this.c;
        if (gz2Var == null) {
            g31.f("layoutResult");
            throw null;
        }
        int iF = gz2Var.f(i);
        gz2 gz2Var2 = this.c;
        if (gz2Var2 == null) {
            g31.f("layoutResult");
            throw null;
        }
        p62 p62VarG = gz2Var2.g(iF);
        gz2 gz2Var3 = this.c;
        if (p62Var != p62VarG) {
            if (gz2Var3 != null) {
                return gz2Var3.f(i);
            }
            g31.f("layoutResult");
            throw null;
        }
        if (gz2Var3 != null) {
            return gz2Var3.b.c(i, false) - 1;
        }
        g31.f("layoutResult");
        throw null;
    }
}
