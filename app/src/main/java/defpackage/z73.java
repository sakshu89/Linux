package defpackage;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z73 extends View {
    public static final wy1 t = new wy1(1);
    public final of0 a;
    public final fw b;
    public final ew c;
    public boolean e;
    public Outline f;
    public boolean i;
    public jc0 j;
    public z61 k;
    public hq0 n;
    public vu0 s;

    public z73(of0 of0Var, fw fwVar, ew ewVar) {
        super(of0Var.getContext());
        this.a = of0Var;
        this.b = fwVar;
        this.c = ewVar;
        setOutlineProvider(t);
        this.i = true;
        this.j = yy3.c;
        this.k = z61.a;
        xu0.a.getClass();
        this.n = j7.i0;
        setWillNotDraw(false);
        setClipBounds(null);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
        fw fwVar = this.b;
        u6 u6Var = fwVar.a;
        Canvas canvas2 = u6Var.a;
        u6Var.a = canvas;
        jc0 jc0Var = this.j;
        z61 z61Var = this.k;
        float width = getWidth();
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32);
        vu0 vu0Var = this.s;
        hq0 hq0Var = this.n;
        ew ewVar = this.c;
        kf kfVar = ewVar.b;
        dw dwVar = ((ew) kfVar.e).a;
        jc0 jc0Var2 = dwVar.a;
        z61 z61Var2 = dwVar.b;
        cw cwVarM = kfVar.m();
        kf kfVar2 = ewVar.b;
        long jR = kfVar2.r();
        vu0 vu0Var2 = (vu0) kfVar2.c;
        kfVar2.E(jc0Var);
        kfVar2.F(z61Var);
        kfVar2.D(u6Var);
        kfVar2.G(jFloatToRawIntBits);
        kfVar2.c = vu0Var;
        u6Var.m();
        try {
            hq0Var.j(ewVar);
            u6Var.j();
            kfVar2.E(jc0Var2);
            kfVar2.F(z61Var2);
            kfVar2.D(cwVarM);
            kfVar2.G(jR);
            kfVar2.c = vu0Var2;
            fwVar.a.a = canvas2;
            this.e = false;
        } catch (Throwable th) {
            u6Var.j();
            kfVar2.E(jc0Var2);
            kfVar2.F(z61Var2);
            kfVar2.D(cwVarM);
            kfVar2.G(jR);
            kfVar2.c = vu0Var2;
            throw th;
        }
    }

    public final boolean getCanUseCompositingLayer$ui_graphics() {
        return this.i;
    }

    public final fw getCanvasHolder() {
        return this.b;
    }

    public final View getOwnerView() {
        return this.a;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return this.i;
    }

    @Override // android.view.View
    public final void invalidate() {
        if (this.e) {
            return;
        }
        this.e = true;
        super.invalidate();
    }

    public final void setCanUseCompositingLayer$ui_graphics(boolean z) {
        if (this.i != z) {
            this.i = z;
            invalidate();
        }
    }

    public final void setInvalidated(boolean z) {
        this.e = z;
    }

    @Override // android.view.View
    public final void forceLayout() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
