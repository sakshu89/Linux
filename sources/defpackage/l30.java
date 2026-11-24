package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class l30 {
    public static final sr2 a = new sr2(f8.v);
    public static final sr2 b = new sr2(f8.w);
    public static final sr2 c = new sr2(f8.H);
    public static final sr2 d = new sr2(f8.x);
    public static final sr2 e = new sr2(f8.Y);
    public static final sr2 f = new sr2(f8.X);
    public static final sr2 g = new sr2(f8.g0);
    public static final sr2 h = new sr2(f8.c0);
    public static final sr2 i = new sr2(f8.d0);
    public static final sr2 j = new sr2(f8.f0);
    public static final sr2 k = new sr2(f8.e0);
    public static final sr2 l = new sr2(f8.h0);
    public static final sr2 m = new sr2(f8.i0);
    public static final sr2 n = new sr2(f8.j0);
    public static final sr2 o = new sr2(f8.n0);
    public static final sr2 p = new sr2(f8.m0);
    public static final sr2 q = new sr2(f8.o0);
    public static final sr2 r = new sr2(k30.c);
    public static final sr2 s = new sr2(k30.e);
    public static final sr2 t = new sr2(k30.f);
    public static final sr2 u = new sr2(f8.k0);
    public static final m30 v = new m30(f8.l0);
    public static final sr2 w = new sr2(f8.Z);

    public static final void a(it1 it1Var, tc tcVar, vq0 vq0Var, x20 x20Var, int i2) {
        x20Var.X(1925803616);
        int i3 = (x20Var.f(it1Var) ? 4 : 2) | i2 | (x20Var.f(tcVar) ? 32 : 16) | (x20Var.h(vq0Var) ? 256 : 128);
        if (x20Var.O(i3 & 1, (i3 & 147) != 146)) {
            r7 r7Var = (r7) it1Var;
            a22 a22VarA = a.a(r7Var.getAccessibilityManager());
            a22 a22VarA2 = b.a(r7Var.getAutofill());
            a22 a22VarA3 = d.a(r7Var.getAutofillManager());
            a22 a22VarA4 = c.a(r7Var.getAutofillTree());
            a22 a22VarA5 = e.a(r7Var.getClipboardManager());
            a22 a22VarA6 = f.a(r7Var.getClipboard());
            a22 a22VarA7 = h.a(r7Var.getDensity());
            a22 a22VarA8 = i.a(r7Var.getFocusOwner());
            a22 a22VarA9 = j.a(r7Var.getFontLoader());
            a22VarA9.c = false;
            a22 a22VarA10 = k.a(r7Var.getFontFamilyResolver());
            a22VarA10.c = false;
            kj4.b(new a22[]{a22VarA, a22VarA2, a22VarA3, a22VarA4, a22VarA5, a22VarA6, a22VarA7, a22VarA8, a22VarA9, a22VarA10, l.a(r7Var.getHapticFeedBack()), m.a(r7Var.getInputModeManager()), n.a(r7Var.getLayoutDirection()), o.a(r7Var.getTextInputService()), p.a(r7Var.getSoftwareKeyboardController()), q.a(r7Var.getTextToolbar()), r.a(tcVar), s.a(r7Var.getViewConfiguration()), t.a(r7Var.getWindowInfo()), u.a(r7Var.getPointerIconService()), g.a(r7Var.getGraphicsContext()), ke1.a.a(r7Var.getRetainedValuesStore())}, vq0Var, x20Var, ((i3 >> 3) & 112) | 8);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new h8(it1Var, tcVar, vq0Var, i2);
        }
    }

    public static final void b(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
