package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cv0 implements xu0 {
    public final fw b;
    public final ew c;
    public final RenderNode d;
    public long e;
    public Paint f;
    public Matrix g;
    public boolean h;
    public float i;
    public int j;
    public float k;
    public float l;
    public float m;
    public long n;
    public long o;
    public float p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;

    public cv0() {
        fw fwVar = new fw();
        ew ewVar = new ew();
        this.b = fwVar;
        this.c = ewVar;
        RenderNode renderNodeC = xs0.c();
        this.d = renderNodeC;
        this.e = 0L;
        renderNodeC.setClipToBounds(false);
        O(renderNodeC, 0);
        this.i = 1.0f;
        this.j = 3;
        this.k = 1.0f;
        this.l = 1.0f;
        long j = sz.b;
        this.n = j;
        this.o = j;
        this.p = 8.0f;
        this.t = 0;
    }

    @Override // defpackage.xu0
    public final void A(long j) {
        this.o = j;
        this.d.setSpotShadowColor(ki4.g(j));
    }

    @Override // defpackage.xu0
    public final void B(float f) {
        this.l = f;
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
        this.d.setPosition(i, i2, ((int) (j >> 32)) + i, ((int) (4294967295L & j)) + i2);
        this.e = cp4.a(j);
    }

    @Override // defpackage.xu0
    public final float E() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final void F(float f) {
        this.p = f;
        this.d.setCameraDistance(f);
    }

    @Override // defpackage.xu0
    public final float G() {
        return this.m;
    }

    @Override // defpackage.xu0
    public final boolean H() {
        return this.d.hasDisplayList();
    }

    @Override // defpackage.xu0
    public final float I() {
        return this.l;
    }

    @Override // defpackage.xu0
    public final float J() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final int K() {
        return this.j;
    }

    @Override // defpackage.xu0
    public final void L(long j) {
        long j2 = 9223372034707292159L & j;
        RenderNode renderNode = this.d;
        if (j2 == 9205357640488583168L) {
            renderNode.resetPivot();
        } else {
            renderNode.setPivotX(Float.intBitsToFloat((int) (j >> 32)));
            this.d.setPivotY(Float.intBitsToFloat((int) (j & 4294967295L)));
        }
    }

    @Override // defpackage.xu0
    public final long M() {
        return this.n;
    }

    public final void N() {
        boolean z = this.q;
        boolean z2 = false;
        boolean z3 = z && !this.h;
        if (z && this.h) {
            z2 = true;
        }
        if (z3 != this.r) {
            this.r = z3;
            this.d.setClipToBounds(z3);
        }
        if (z2 != this.s) {
            this.s = z2;
            this.d.setClipToOutline(z2);
        }
    }

    public final void O(RenderNode renderNode, int i) {
        Paint paint = this.f;
        if (i == 1) {
            renderNode.setUseCompositingLayer(true, paint);
            renderNode.setHasOverlappingRendering(true);
        } else if (i == 2) {
            renderNode.setUseCompositingLayer(false, paint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, paint);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    public final void P() {
        int i = this.t;
        if (i != 1 && this.j == 3) {
            O(this.d, i);
        } else {
            O(this.d, 1);
        }
    }

    @Override // defpackage.xu0
    public final float a() {
        return this.i;
    }

    @Override // defpackage.xu0
    public final void b() {
        this.d.setRotationX(0.0f);
    }

    @Override // defpackage.xu0
    public final void c(float f) {
        this.i = f;
        this.d.setAlpha(f);
    }

    @Override // defpackage.xu0
    public final float d() {
        return this.k;
    }

    @Override // defpackage.xu0
    public final void e(float f) {
        this.m = f;
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
        return this.o;
    }

    @Override // defpackage.xu0
    public final void j(long j) {
        this.n = j;
        this.d.setAmbientShadowColor(ki4.g(j));
    }

    @Override // defpackage.xu0
    public final void k(Outline outline, long j) {
        this.d.setOutline(outline);
        this.h = outline != null;
        N();
    }

    @Override // defpackage.xu0
    public final void l() {
        Paint paint = this.f;
        if (paint == null) {
            paint = new Paint();
            this.f = paint;
        }
        paint.setColorFilter(null);
        P();
    }

    @Override // defpackage.xu0
    public final void m(float f) {
        this.k = f;
        this.d.setScaleX(f);
    }

    @Override // defpackage.xu0
    public final void n(int i) {
        this.j = i;
        Paint paint = this.f;
        if (paint == null) {
            paint = new Paint();
            this.f = paint;
        }
        paint.setBlendMode(jc4.b(i));
        P();
    }

    @Override // defpackage.xu0
    public final float o() {
        return this.p;
    }

    @Override // defpackage.xu0
    public final void p() {
        this.d.discardDisplayList();
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
        ((u6) cwVar).a.drawRenderNode(this.d);
    }

    @Override // defpackage.xu0
    public final void t(boolean z) {
        this.q = z;
        N();
    }

    @Override // defpackage.xu0
    public final int u() {
        return this.t;
    }

    @Override // defpackage.xu0
    public final float v() {
        return 0.0f;
    }

    @Override // defpackage.xu0
    public final void w(jc0 jc0Var, z61 z61Var, vu0 vu0Var, h6 h6Var) {
        ew ewVar = this.c;
        RecordingCanvas recordingCanvasBeginRecording = this.d.beginRecording();
        try {
            fw fwVar = this.b;
            u6 u6Var = fwVar.a;
            Canvas canvas = u6Var.a;
            u6Var.a = recordingCanvasBeginRecording;
            kf kfVar = ewVar.b;
            kfVar.E(jc0Var);
            kfVar.F(z61Var);
            kfVar.c = vu0Var;
            kfVar.G(this.e);
            kfVar.D(u6Var);
            h6Var.j(ewVar);
            fwVar.a.a = canvas;
        } finally {
            this.d.endRecording();
        }
    }

    @Override // defpackage.xu0
    public final nl x() {
        return null;
    }

    @Override // defpackage.xu0
    public final void y(int i) {
        this.t = i;
        P();
    }

    @Override // defpackage.xu0
    public final void z() {
        this.d.setRotationZ(0.0f);
    }
}
