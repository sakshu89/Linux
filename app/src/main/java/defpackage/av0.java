package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class av0 implements xu0 {
    public static final AtomicBoolean w = new AtomicBoolean(true);
    public final fw b;
    public final ew c;
    public final RenderNode d;
    public long e;
    public Paint f;
    public Matrix g;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public float l;
    public boolean m;
    public float n;
    public float o;
    public float p;
    public long q;
    public long r;
    public float s;
    public boolean t;
    public boolean u;
    public boolean v;

    public av0(r7 r7Var, fw fwVar, ew ewVar) {
        this.b = fwVar;
        this.c = ewVar;
        RenderNode renderNodeCreate = RenderNode.create("Compose", r7Var);
        this.d = renderNodeCreate;
        this.e = 0L;
        this.i = 0L;
        if (w.getAndSet(false)) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            if (Build.VERSION.SDK_INT >= 28) {
                t52.c(renderNodeCreate, t52.a(renderNodeCreate));
                t52.d(renderNodeCreate, t52.b(renderNodeCreate));
            }
            s52.a(renderNodeCreate);
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
        }
        renderNodeCreate.setClipToBounds(false);
        O(0);
        this.j = 0;
        this.k = 3;
        this.l = 1.0f;
        this.n = 1.0f;
        this.o = 1.0f;
        long j = sz.b;
        this.q = j;
        this.r = j;
        this.s = 8.0f;
    }

    @Override // defpackage.xu0
    public final void A(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.r = j;
            t52.d(this.d, ki4.g(j));
        }
    }

    @Override // defpackage.xu0
    public final void B(float f) {
        this.o = f;
        this.d.setScaleY(f);
    }

    @Override // defpackage.xu0
    public final Matrix C() {
        Matrix matrix = this.g;
        if (matrix == null) {
            matrix = new Matrix();
            this.g = matrix;
        }
        this.d.getMatrix(matrix);
        return matrix;
    }

    @Override // defpackage.xu0
    public final void D(int i, int i2, long j) {
        int i3 = (int) (j >> 32);
        int i4 = (int) (4294967295L & j);
        this.d.setLeftTopRightBottom(i, i2, i + i3, i2 + i4);
        if (l21.a(this.e, j)) {
            return;
        }
        if (this.m) {
            this.d.setPivotX(i3 / 2.0f);
            this.d.setPivotY(i4 / 2.0f);
        }
        this.e = j;
    }

    @Override // defpackage.xu0
    public final float E() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final void F(float f) {
        this.s = f;
        this.d.setCameraDistance(-f);
    }

    @Override // defpackage.xu0
    public final float G() {
        return this.p;
    }

    @Override // defpackage.xu0
    public final boolean H() {
        return this.d.isValid();
    }

    @Override // defpackage.xu0
    public final float I() {
        return this.o;
    }

    @Override // defpackage.xu0
    public final float J() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final int K() {
        return this.k;
    }

    @Override // defpackage.xu0
    public final void L(long j) {
        if ((9223372034707292159L & j) == 9205357640488583168L) {
            this.m = true;
            this.d.setPivotX(((int) (this.e >> 32)) / 2.0f);
            this.d.setPivotY(((int) (4294967295L & this.e)) / 2.0f);
        } else {
            this.m = false;
            this.d.setPivotX(Float.intBitsToFloat((int) (j >> 32)));
            this.d.setPivotY(Float.intBitsToFloat((int) (j & 4294967295L)));
        }
    }

    @Override // defpackage.xu0
    public final long M() {
        return this.q;
    }

    public final void N() {
        boolean z = this.t;
        boolean z2 = false;
        boolean z3 = z && !this.h;
        if (z && this.h) {
            z2 = true;
        }
        if (z3 != this.u) {
            this.u = z3;
            this.d.setClipToBounds(z3);
        }
        if (z2 != this.v) {
            this.v = z2;
            this.d.setClipToOutline(z2);
        }
    }

    public final void O(int i) {
        RenderNode renderNode = this.d;
        if (i == 1) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.f);
            renderNode.setHasOverlappingRendering(true);
        } else if (i == 2) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.f);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.f);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    public final void P() {
        int i = this.j;
        if (i != 1 && this.k == 3) {
            O(i);
        } else {
            O(1);
        }
    }

    @Override // defpackage.xu0
    public final float a() {
        return this.l;
    }

    @Override // defpackage.xu0
    public final void b() {
        this.d.setRotationX(0.0f);
    }

    @Override // defpackage.xu0
    public final void c(float f) {
        this.l = f;
        this.d.setAlpha(f);
    }

    @Override // defpackage.xu0
    public final float d() {
        return this.n;
    }

    @Override // defpackage.xu0
    public final void e(float f) {
        this.p = f;
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
        return this.r;
    }

    @Override // defpackage.xu0
    public final void j(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.q = j;
            t52.c(this.d, ki4.g(j));
        }
    }

    @Override // defpackage.xu0
    public final void k(Outline outline, long j) {
        this.i = j;
        this.d.setOutline(outline);
        this.h = outline != null;
        N();
    }

    @Override // defpackage.xu0
    public final void l() {
        P();
    }

    @Override // defpackage.xu0
    public final void m(float f) {
        this.n = f;
        this.d.setScaleX(f);
    }

    @Override // defpackage.xu0
    public final void n(int i) {
        if (this.k == i) {
            return;
        }
        this.k = i;
        Paint paint = this.f;
        if (paint == null) {
            paint = new Paint();
            this.f = paint;
        }
        paint.setXfermode(new PorterDuffXfermode(jc4.c(i)));
        P();
    }

    @Override // defpackage.xu0
    public final float o() {
        return this.s;
    }

    @Override // defpackage.xu0
    public final void p() {
        s52.a(this.d);
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
        Canvas canvas = v6.a;
        DisplayListCanvas displayListCanvas = ((u6) cwVar).a;
        displayListCanvas.getClass();
        displayListCanvas.drawRenderNode(this.d);
    }

    @Override // defpackage.xu0
    public final void t(boolean z) {
        this.t = z;
        N();
    }

    @Override // defpackage.xu0
    public final int u() {
        return this.j;
    }

    @Override // defpackage.xu0
    public final float v() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final void w(jc0 jc0Var, z61 z61Var, vu0 vu0Var, h6 h6Var) {
        Canvas canvasStart = this.d.start(Math.max((int) (this.e >> 32), (int) (this.i >> 32)), Math.max((int) (this.e & 4294967295L), (int) (this.i & 4294967295L)));
        try {
            u6 u6Var = this.b.a;
            Canvas canvas = u6Var.a;
            u6Var.a = canvasStart;
            ew ewVar = this.c;
            kf kfVar = ewVar.b;
            long jA = cp4.a(this.e);
            dw dwVar = ((ew) kfVar.e).a;
            jc0 jc0Var2 = dwVar.a;
            z61 z61Var2 = dwVar.b;
            cw cwVarM = kfVar.m();
            long jR = kfVar.r();
            vu0 vu0Var2 = (vu0) kfVar.c;
            kfVar.E(jc0Var);
            kfVar.F(z61Var);
            kfVar.D(u6Var);
            kfVar.G(jA);
            kfVar.c = vu0Var;
            u6Var.m();
            try {
                h6Var.j(ewVar);
                u6Var.j();
                kfVar.E(jc0Var2);
                kfVar.F(z61Var2);
                kfVar.D(cwVarM);
                kfVar.G(jR);
                kfVar.c = vu0Var2;
                u6Var.a = canvas;
                this.d.end(canvasStart);
            } catch (Throwable th) {
                u6Var.j();
                kf kfVar2 = ewVar.b;
                kfVar2.E(jc0Var2);
                kfVar2.F(z61Var2);
                kfVar2.D(cwVarM);
                kfVar2.G(jR);
                kfVar2.c = vu0Var2;
                throw th;
            }
        } catch (Throwable th2) {
            this.d.end(canvasStart);
            throw th2;
        }
    }

    @Override // defpackage.xu0
    public final nl x() {
        return null;
    }

    @Override // defpackage.xu0
    public final void y(int i) {
        this.j = i;
        P();
    }

    @Override // defpackage.xu0
    public final void z() {
        this.d.setRotation(0.0f);
    }
}
