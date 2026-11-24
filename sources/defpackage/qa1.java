package defpackage;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qa1 {
    public final y9 a;
    public final l11 b;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ty2 j;
    public gz2 k;
    public mp1 l;
    public l42 m;
    public l42 n;
    public final Object c = new Object();
    public final CursorAnchorInfo.Builder o = new CursorAnchorInfo.Builder();
    public final float[] p = ih1.a();
    public final Matrix q = new Matrix();

    public qa1(y9 y9Var, l11 l11Var) {
        this.a = y9Var;
        this.b = l11Var;
    }

    public final void a() {
        l11 l11Var = this.b;
        InputMethodManager inputMethodManagerY = l11Var.y();
        View view = (View) l11Var.b;
        if (!inputMethodManagerY.isActive(view) || this.j == null || this.l == null || this.k == null || this.m == null || this.n == null) {
            return;
        }
        float[] fArr = this.p;
        ih1.d(fArr);
        y61 y61Var = (y61) this.a.k.Y.getValue();
        if (y61Var != null) {
            if (!y61Var.B()) {
                y61Var = null;
            }
            if (y61Var != null) {
                y61Var.D(fArr);
            }
        }
        l42 l42Var = this.n;
        l42Var.getClass();
        float f = -l42Var.a;
        l42 l42Var2 = this.n;
        l42Var2.getClass();
        ih1.f(fArr, f, -l42Var2.b);
        Matrix matrix = this.q;
        hd4.c(matrix, fArr);
        ty2 ty2Var = this.j;
        ty2Var.getClass();
        long j = ty2Var.b;
        mp1 mp1Var = this.l;
        mp1Var.getClass();
        gz2 gz2Var = this.k;
        gz2Var.getClass();
        fl1 fl1Var = gz2Var.b;
        l42 l42Var3 = this.m;
        l42Var3.getClass();
        float f2 = l42Var3.d;
        float f3 = l42Var3.b;
        l42 l42Var4 = this.n;
        l42Var4.getClass();
        boolean z = this.f;
        boolean z2 = this.g;
        boolean z3 = this.h;
        boolean z4 = this.i;
        CursorAnchorInfo.Builder builder = this.o;
        builder.reset();
        builder.setMatrix(matrix);
        oz2 oz2Var = ty2Var.c;
        int iF = oz2.f(j);
        builder.setSelectionRange(iF, oz2.e(j));
        p62 p62Var = p62.b;
        if (z && iF >= 0) {
            int iL = mp1Var.l(iF);
            l42 l42VarC = gz2Var.c(iL);
            float fB = ky3.b(l42VarC.a, 0.0f, (int) (gz2Var.c >> 32));
            boolean zA = hq4.a(l42Var3, fB, l42VarC.b);
            boolean zA2 = hq4.a(l42Var3, fB, l42VarC.d);
            boolean z5 = gz2Var.a(iL) == p62Var;
            int i = (zA || zA2) ? 1 : 0;
            if (!zA || !zA2) {
                i |= 2;
            }
            if (z5) {
                i |= 4;
            }
            float f4 = l42VarC.b;
            float f5 = l42VarC.d;
            builder.setInsertionMarkerLocation(fB, f4, f5, f5, i);
        }
        CursorAnchorInfo.Builder builder2 = builder;
        if (z2) {
            int iF2 = oz2Var != null ? oz2.f(oz2Var.a) : -1;
            int iE = oz2Var != null ? oz2.e(oz2Var.a) : -1;
            if (iF2 >= 0 && iF2 < iE) {
                builder2.setComposingText(iF2, ty2Var.a.b.subSequence(iF2, iE));
                int iL2 = mp1Var.l(iF2);
                int iL3 = mp1Var.l(iE);
                float[] fArr2 = new float[(iL3 - iL2) * 4];
                fl1Var.a(hc4.a(iL2, iL3), fArr2);
                while (iF2 < iE) {
                    int iL4 = mp1Var.l(iF2);
                    int i2 = (iL4 - iL2) * 4;
                    float f6 = fArr2[i2];
                    CursorAnchorInfo.Builder builder3 = builder2;
                    float f7 = fArr2[i2 + 1];
                    int i3 = iL2;
                    float f8 = fArr2[i2 + 2];
                    float f9 = fArr2[i2 + 3];
                    int i4 = iE;
                    int i5 = (l42Var3.a < f8 ? 1 : 0) & (f6 < l42Var3.c ? 1 : 0) & (f3 < f9 ? 1 : 0) & (f7 < f2 ? 1 : 0);
                    if (!hq4.a(l42Var3, f6, f7) || !hq4.a(l42Var3, f8, f9)) {
                        i5 |= 2;
                    }
                    if (gz2Var.a(iL4) == p62Var) {
                        i5 |= 4;
                    }
                    int i6 = iF2;
                    builder3.addCharacterBounds(i6, f6, f7, f8, f9, i5);
                    builder2 = builder3;
                    iF2 = i6 + 1;
                    iL2 = i3;
                    iE = i4;
                }
            }
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33 && z3) {
            builder2.setEditorBoundsInfo(c3.l().setEditorBounds(py3.b(l42Var4)).setHandwritingBounds(py3.b(l42Var4)).build());
        }
        if (i7 >= 34 && z4 && !l42Var3.f()) {
            int i8 = fl1Var.f - 1;
            if (i8 < 0) {
                i8 = 0;
            }
            int iC = ky3.c(fl1Var.e(f3), 0, i8);
            int iC2 = ky3.c(fl1Var.e(f2), 0, i8);
            if (iC <= iC2) {
                while (true) {
                    builder2.addVisibleLineBounds(gz2Var.d(iC), fl1Var.f(iC), gz2Var.e(iC), fl1Var.b(iC));
                    if (iC == iC2) {
                        break;
                    } else {
                        iC++;
                    }
                }
            }
        }
        l11Var.y().updateCursorAnchorInfo(view, builder2.build());
        this.e = false;
    }
}
