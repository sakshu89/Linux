package defpackage;

import java.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x2 extends w2 {
    public static x2 e;
    public static x2 f;
    public static x2 g;
    public static final p62 h = p62.b;
    public static final p62 i = p62.a;
    public final /* synthetic */ int c;
    public Object d;

    @Override // defpackage.w2
    public final int[] a(int i2) {
        int iD;
        switch (this.c) {
            case 0:
                int length = c().length();
                if (length <= 0 || i2 >= length) {
                    return null;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                do {
                    BreakIterator breakIterator = (BreakIterator) this.d;
                    if (breakIterator == null) {
                        g31.f("impl");
                        throw null;
                    }
                    boolean zIsBoundary = breakIterator.isBoundary(i2);
                    BreakIterator breakIterator2 = (BreakIterator) this.d;
                    if (zIsBoundary) {
                        if (breakIterator2 == null) {
                            g31.f("impl");
                            throw null;
                        }
                        int iFollowing = breakIterator2.following(i2);
                        if (iFollowing == -1) {
                            return null;
                        }
                        return b(i2, iFollowing);
                    }
                    if (breakIterator2 == null) {
                        g31.f("impl");
                        throw null;
                    }
                    i2 = breakIterator2.following(i2);
                } while (i2 != -1);
                return null;
            case 1:
                if (c().length() <= 0 || i2 >= c().length()) {
                    return null;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                while (!h(i2) && (!h(i2) || (i2 != 0 && h(i2 - 1)))) {
                    BreakIterator breakIterator3 = (BreakIterator) this.d;
                    if (breakIterator3 == null) {
                        g31.f("impl");
                        throw null;
                    }
                    i2 = breakIterator3.following(i2);
                    if (i2 == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator4 = (BreakIterator) this.d;
                if (breakIterator4 == null) {
                    g31.f("impl");
                    throw null;
                }
                int iFollowing2 = breakIterator4.following(i2);
                if (iFollowing2 == -1 || !g(iFollowing2)) {
                    return null;
                }
                return b(i2, iFollowing2);
            default:
                if (c().length() <= 0 || i2 >= c().length()) {
                    return null;
                }
                gz2 gz2Var = (gz2) this.d;
                p62 p62Var = h;
                if (i2 < 0) {
                    if (gz2Var == null) {
                        g31.f("layoutResult");
                        throw null;
                    }
                    iD = gz2Var.b.d(0);
                } else {
                    if (gz2Var == null) {
                        g31.f("layoutResult");
                        throw null;
                    }
                    int iD2 = gz2Var.b.d(i2);
                    iD = e(iD2, p62Var) == i2 ? iD2 : iD2 + 1;
                }
                gz2 gz2Var2 = (gz2) this.d;
                if (gz2Var2 == null) {
                    g31.f("layoutResult");
                    throw null;
                }
                if (iD >= gz2Var2.b.f) {
                    return null;
                }
                return b(e(iD, p62Var), e(iD, i) + 1);
        }
    }

    @Override // defpackage.w2
    public final int[] d(int i2) {
        int iD;
        switch (this.c) {
            case 0:
                int length = c().length();
                if (length <= 0 || i2 <= 0) {
                    return null;
                }
                if (i2 > length) {
                    i2 = length;
                }
                do {
                    BreakIterator breakIterator = (BreakIterator) this.d;
                    if (breakIterator == null) {
                        g31.f("impl");
                        throw null;
                    }
                    boolean zIsBoundary = breakIterator.isBoundary(i2);
                    BreakIterator breakIterator2 = (BreakIterator) this.d;
                    if (zIsBoundary) {
                        if (breakIterator2 == null) {
                            g31.f("impl");
                            throw null;
                        }
                        int iPreceding = breakIterator2.preceding(i2);
                        if (iPreceding == -1) {
                            return null;
                        }
                        return b(iPreceding, i2);
                    }
                    if (breakIterator2 == null) {
                        g31.f("impl");
                        throw null;
                    }
                    i2 = breakIterator2.preceding(i2);
                } while (i2 != -1);
                return null;
            case 1:
                int length2 = c().length();
                if (length2 <= 0 || i2 <= 0) {
                    return null;
                }
                if (i2 > length2) {
                    i2 = length2;
                }
                while (i2 > 0 && !h(i2 - 1) && !g(i2)) {
                    BreakIterator breakIterator3 = (BreakIterator) this.d;
                    if (breakIterator3 == null) {
                        g31.f("impl");
                        throw null;
                    }
                    i2 = breakIterator3.preceding(i2);
                    if (i2 == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator4 = (BreakIterator) this.d;
                if (breakIterator4 == null) {
                    g31.f("impl");
                    throw null;
                }
                int iPreceding2 = breakIterator4.preceding(i2);
                if (iPreceding2 == -1 || !h(iPreceding2)) {
                    return null;
                }
                if (iPreceding2 == 0 || !h(iPreceding2 - 1)) {
                    return b(iPreceding2, i2);
                }
                return null;
            default:
                if (c().length() <= 0 || i2 <= 0) {
                    return null;
                }
                int length3 = c().length();
                gz2 gz2Var = (gz2) this.d;
                p62 p62Var = i;
                if (i2 > length3) {
                    if (gz2Var == null) {
                        g31.f("layoutResult");
                        throw null;
                    }
                    iD = gz2Var.b.d(c().length());
                } else {
                    if (gz2Var == null) {
                        g31.f("layoutResult");
                        throw null;
                    }
                    int iD2 = gz2Var.b.d(i2);
                    iD = e(iD2, p62Var) + 1 == i2 ? iD2 : iD2 - 1;
                }
                if (iD < 0) {
                    return null;
                }
                return b(e(iD, h), e(iD, p62Var) + 1);
        }
    }

    public int e(int i2, p62 p62Var) {
        gz2 gz2Var = (gz2) this.d;
        if (gz2Var == null) {
            g31.f("layoutResult");
            throw null;
        }
        int iF = gz2Var.f(i2);
        gz2 gz2Var2 = (gz2) this.d;
        if (gz2Var2 == null) {
            g31.f("layoutResult");
            throw null;
        }
        p62 p62VarG = gz2Var2.g(iF);
        gz2 gz2Var3 = (gz2) this.d;
        if (p62Var != p62VarG) {
            if (gz2Var3 != null) {
                return gz2Var3.f(i2);
            }
            g31.f("layoutResult");
            throw null;
        }
        if (gz2Var3 != null) {
            return gz2Var3.b.c(i2, false) - 1;
        }
        g31.f("layoutResult");
        throw null;
    }

    public void f(String str) {
        switch (this.c) {
            case 0:
                this.a = str;
                BreakIterator breakIterator = (BreakIterator) this.d;
                if (breakIterator != null) {
                    breakIterator.setText(str);
                    return;
                } else {
                    g31.f("impl");
                    throw null;
                }
            default:
                this.a = str;
                BreakIterator breakIterator2 = (BreakIterator) this.d;
                if (breakIterator2 != null) {
                    breakIterator2.setText(str);
                    return;
                } else {
                    g31.f("impl");
                    throw null;
                }
        }
    }

    public boolean g(int i2) {
        if (i2 <= 0 || !h(i2 - 1)) {
            return false;
        }
        return i2 == c().length() || !h(i2);
    }

    public boolean h(int i2) {
        if (i2 < 0 || i2 >= c().length()) {
            return false;
        }
        return Character.isLetterOrDigit(c().codePointAt(i2));
    }
}
