package defpackage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ev0 implements xu0 {
    public static final dv0 w = new dv0();
    public final of0 b;
    public final fw c;
    public final z73 d;
    public final Resources e;
    public final Rect f;
    public Paint g;
    public int h;
    public int i;
    public long j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public float p;
    public boolean q;
    public float r;
    public float s;
    public float t;
    public long u;
    public long v;

    public ev0(of0 of0Var) {
        fw fwVar = new fw();
        ew ewVar = new ew();
        this.b = of0Var;
        this.c = fwVar;
        z73 z73Var = new z73(of0Var, fwVar, ewVar);
        this.d = z73Var;
        this.e = of0Var.getResources();
        this.f = new Rect();
        of0Var.addView(z73Var);
        z73Var.setClipBounds(null);
        this.j = 0L;
        View.generateViewId();
        this.n = 3;
        this.o = 0;
        this.p = 1.0f;
        this.r = 1.0f;
        this.s = 1.0f;
        long j = sz.b;
        this.u = j;
        this.v = j;
    }

    @Override // defpackage.xu0
    public final void A(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.v = j;
            this.d.setOutlineSpotShadowColor(ki4.g(j));
        }
    }

    @Override // defpackage.xu0
    public final void B(float f) {
        this.s = f;
        this.d.setScaleY(f);
    }

    @Override // defpackage.xu0
    public final Matrix C() {
        return this.d.getMatrix();
    }

    @Override // defpackage.xu0
    public final void D(int i, int i2, long j) {
        boolean zA = l21.a(this.j, j);
        z73 z73Var = this.d;
        if (zA) {
            int i3 = this.h;
            if (i3 != i) {
                z73Var.offsetLeftAndRight(i - i3);
            }
            int i4 = this.i;
            if (i4 != i2) {
                z73Var.offsetTopAndBottom(i2 - i4);
            }
        } else {
            if (this.m || z73Var.getClipToOutline()) {
                this.k = true;
            }
            int i5 = (int) (j >> 32);
            int i6 = (int) (4294967295L & j);
            z73Var.layout(i, i2, i + i5, i2 + i6);
            this.j = j;
            if (this.q) {
                z73Var.setPivotX(i5 / 2.0f);
                z73Var.setPivotY(i6 / 2.0f);
            }
        }
        this.h = i;
        this.i = i2;
    }

    @Override // defpackage.xu0
    public final float E() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final void F(float f) {
        this.d.setCameraDistance(f * this.e.getDisplayMetrics().densityDpi);
    }

    @Override // defpackage.xu0
    public final float G() {
        return this.t;
    }

    @Override // defpackage.xu0
    public final float I() {
        return this.s;
    }

    @Override // defpackage.xu0
    public final float J() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final int K() {
        return this.n;
    }

    @Override // defpackage.xu0
    public final void L(long j) {
        long j2 = 9223372034707292159L & j;
        z73 z73Var = this.d;
        if (j2 != 9205357640488583168L) {
            this.q = false;
            z73Var.setPivotX(Float.intBitsToFloat((int) (j >> 32)));
            z73Var.setPivotY(Float.intBitsToFloat((int) (j & 4294967295L)));
        } else {
            if (Build.VERSION.SDK_INT >= 28) {
                z73Var.resetPivot();
                return;
            }
            this.q = true;
            z73Var.setPivotX(((int) (this.j >> 32)) / 2.0f);
            z73Var.setPivotY(((int) (this.j & 4294967295L)) / 2.0f);
        }
    }

    @Override // defpackage.xu0
    public final long M() {
        return this.u;
    }

    public final void N(int i) {
        z73 z73Var = this.d;
        boolean z = true;
        if (i == 1) {
            z73Var.setLayerType(2, this.g);
        } else {
            Paint paint = this.g;
            if (i == 2) {
                z73Var.setLayerType(0, paint);
                z = false;
            } else {
                z73Var.setLayerType(0, paint);
            }
        }
        z73Var.setCanUseCompositingLayer$ui_graphics(z);
    }

    public final void O() {
        int i = this.o;
        if (i != 1 && this.n == 3) {
            N(i);
        } else {
            N(1);
        }
    }

    @Override // defpackage.xu0
    public final float a() {
        return this.p;
    }

    @Override // defpackage.xu0
    public final void b() {
        this.d.setRotationX(0.0f);
    }

    @Override // defpackage.xu0
    public final void c(float f) {
        this.p = f;
        this.d.setAlpha(f);
    }

    @Override // defpackage.xu0
    public final float d() {
        return this.r;
    }

    @Override // defpackage.xu0
    public final void e(float f) {
        this.t = f;
        this.d.setElevation(f);
    }

    @Override // defpackage.xu0
    public final float f() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final void g() {
        this.d.setTranslationY(0.0f);
    }

    @Override // defpackage.xu0
    public final void h() {
        this.d.setRotationY(0.0f);
    }

    @Override // defpackage.xu0
    public final long i() {
        return this.v;
    }

    @Override // defpackage.xu0
    public final void j(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.u = j;
            this.d.setOutlineAmbientShadowColor(ki4.g(j));
        }
    }

    @Override // defpackage.xu0
    public final void k(Outline outline, long j) {
        z73 z73Var = this.d;
        z73Var.f = outline;
        z73Var.invalidateOutline();
        if ((this.m || z73Var.getClipToOutline()) && outline != null) {
            z73Var.setClipToOutline(true);
            if (this.m) {
                this.m = false;
                this.k = true;
            }
        }
        this.l = outline != null;
    }

    @Override // defpackage.xu0
    public final void l() {
        Paint paint = this.g;
        if (paint == null) {
            paint = new Paint();
            this.g = paint;
        }
        paint.setColorFilter(null);
        O();
    }

    @Override // defpackage.xu0
    public final void m(float f) {
        this.r = f;
        this.d.setScaleX(f);
    }

    @Override // defpackage.xu0
    public final void n(int i) {
        this.n = i;
        Paint paint = this.g;
        if (paint == null) {
            paint = new Paint();
            this.g = paint;
        }
        paint.setXfermode(new PorterDuffXfermode(jc4.c(i)));
        O();
    }

    @Override // defpackage.xu0
    public final float o() {
        return this.d.getCameraDistance() / this.e.getDisplayMetrics().densityDpi;
    }

    @Override // defpackage.xu0
    public final void p() {
        this.b.removeViewInLayout(this.d);
    }

    @Override // defpackage.xu0
    public final float q() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final void r() {
        this.d.setTranslationX(0.0f);
    }

    @Override // defpackage.xu0
    public final void s(cw cwVar) {
        Rect rect;
        boolean z = this.k;
        z73 z73Var = this.d;
        if (z) {
            if ((this.m || z73Var.getClipToOutline()) && !this.l) {
                rect = this.f;
                rect.left = 0;
                rect.top = 0;
                rect.right = z73Var.getWidth();
                rect.bottom = z73Var.getHeight();
            } else {
                rect = null;
            }
            z73Var.setClipBounds(rect);
        }
        Canvas canvas = v6.a;
        if (((u6) cwVar).a.isHardwareAccelerated()) {
            this.b.a(cwVar, z73Var, z73Var.getDrawingTime());
        }
    }

    @Override // defpackage.xu0
    public final void t(boolean z) {
        boolean z2 = false;
        this.m = z && !this.l;
        this.k = true;
        if (z && this.l) {
            z2 = true;
        }
        this.d.setClipToOutline(z2);
    }

    @Override // defpackage.xu0
    public final int u() {
        return this.o;
    }

    @Override // defpackage.xu0
    public final float v() {
        return 0.0f;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.xu0
    public final void w(jc0 jc0Var, z61 z61Var, vu0 vu0Var, h6 h6Var) {
        z73 z73Var = this.d;
        ViewParent parent = z73Var.getParent();
        of0 of0Var = this.b;
        if (parent == null) {
            of0Var.addView(z73Var);
        }
        z73Var.j = jc0Var;
        z73Var.k = z61Var;
        z73Var.n = h6Var;
        z73Var.s = vu0Var;
        if (z73Var.isAttachedToWindow()) {
            z73Var.setVisibility(4);
            z73Var.setVisibility(0);
            try {
                fw fwVar = this.c;
                dv0 dv0Var = w;
                u6 u6Var = fwVar.a;
                Canvas canvas = u6Var.a;
                u6Var.a = dv0Var;
                of0Var.a(u6Var, z73Var, z73Var.getDrawingTime());
                fwVar.a.a = canvas;
            } catch (ClassCastException unused) {
            }
        }
    }

    @Override // defpackage.xu0
    public final nl x() {
        return null;
    }

    @Override // defpackage.xu0
    public final void y(int i) {
        this.o = i;
        O();
    }

    @Override // defpackage.xu0
    public final void z() {
        this.d.setRotation(0.0f);
    }
}
