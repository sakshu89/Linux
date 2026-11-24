package defpackage;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j80 {
    public final r7 a;
    public final kf b;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ty2 j;
    public gz2 k;
    public mp1 l;
    public l42 n;
    public l42 o;
    public final Object c = new Object();
    public hq0 m = j7.X;
    public final CursorAnchorInfo.Builder p = new CursorAnchorInfo.Builder();
    public final float[] q = ih1.a();
    public final Matrix r = new Matrix();

    public j80(r7 r7Var, kf kfVar) {
        this.a = r7Var;
        this.b = kfVar;
    }

    public final void a() {
        kf kfVar = this.b;
        f81 f81Var = (f81) kfVar.c;
        InputMethodManager inputMethodManager = (InputMethodManager) f81Var.getValue();
        View view = (View) kfVar.b;
        if (inputMethodManager.isActive(view)) {
            hq0 hq0Var = this.m;
            float[] fArr = this.q;
            hq0Var.j(new ih1(fArr));
            this.a.o(fArr);
            Matrix matrix = this.r;
            hd4.c(matrix, fArr);
            ty2 ty2Var = this.j;
            ty2Var.getClass();
            long j = ty2Var.b;
            mp1 mp1Var = this.l;
            mp1Var.getClass();
            gz2 gz2Var = this.k;
            gz2Var.getClass();
            fl1 fl1Var = gz2Var.b;
            l42 l42Var = this.n;
            l42Var.getClass();
            float f = l42Var.d;
            float f2 = l42Var.b;
            l42 l42Var2 = this.o;
            l42Var2.getClass();
            boolean z = this.f;
            boolean z2 = this.g;
            boolean z3 = this.h;
            boolean z4 = this.i;
            CursorAnchorInfo.Builder builder = this.p;
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
                boolean zA = vl4.a(l42Var, fB, l42VarC.b);
                boolean zA2 = vl4.a(l42Var, fB, l42VarC.d);
                boolean z5 = gz2Var.a(iL) == p62Var;
                int i = (zA || zA2) ? 1 : 0;
                if (!zA || !zA2) {
                    i |= 2;
                }
                if (z5) {
                    i |= 4;
                }
                float f3 = l42VarC.b;
                float f4 = l42VarC.d;
                builder.setInsertionMarkerLocation(fB, f3, f4, f4, i);
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
                        float f5 = fArr2[i2];
                        CursorAnchorInfo.Builder builder3 = builder2;
                        float f6 = fArr2[i2 + 1];
                        int i3 = iE;
                        float f7 = fArr2[i2 + 2];
                        float f8 = fArr2[i2 + 3];
                        int i4 = iF2;
                        int i5 = (l42Var.a < f7 ? 1 : 0) & (f5 < l42Var.c ? 1 : 0) & (f2 < f8 ? 1 : 0) & (f6 < f ? 1 : 0);
                        if (!vl4.a(l42Var, f5, f6) || !vl4.a(l42Var, f7, f8)) {
                            i5 |= 2;
                        }
                        if (gz2Var.a(iL4) == p62Var) {
                            i5 |= 4;
                        }
                        builder3.addCharacterBounds(i4, f5, f6, f7, f8, i5);
                        builder2 = builder3;
                        iF2 = i4 + 1;
                        iE = i3;
                    }
                }
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 33 && z3) {
                builder2.setEditorBoundsInfo(c3.l().setEditorBounds(py3.b(l42Var2)).setHandwritingBounds(py3.b(l42Var2)).build());
            }
            if (i6 >= 34 && z4 && !l42Var.f()) {
                int i7 = fl1Var.f - 1;
                if (i7 < 0) {
                    i7 = 0;
                }
                int iC = ky3.c(fl1Var.e(f2), 0, i7);
                int iC2 = ky3.c(fl1Var.e(f), 0, i7);
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
            ((InputMethodManager) f81Var.getValue()).updateCursorAnchorInfo(view, builder2.build());
            this.e = false;
        }
    }
}
