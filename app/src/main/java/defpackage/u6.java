package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u6 implements cw {
    public Canvas a = v6.a;
    public Rect b;
    public Rect c;

    @Override // defpackage.cw
    public final void a(p9 p9Var, fa faVar) {
        this.a.drawBitmap(zc4.a(p9Var), Float.intBitsToFloat(0), Float.intBitsToFloat(0), faVar.a);
    }

    @Override // defpackage.cw
    public final void b(float f, float f2) {
        this.a.scale(f, f2);
    }

    @Override // defpackage.cw
    public final void c(float f) {
        this.a.rotate(f);
    }

    @Override // defpackage.cw
    public final void d(float f, long j, fa faVar) {
        this.a.drawCircle(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), f, faVar.a);
    }

    @Override // defpackage.cw
    public final void e(p9 p9Var, long j, long j2, long j3, fa faVar) {
        if (this.b == null) {
            this.b = new Rect();
            this.c = new Rect();
        }
        Canvas canvas = this.a;
        Bitmap bitmapA = zc4.a(p9Var);
        Rect rect = this.b;
        rect.getClass();
        int i = (int) (j >> 32);
        rect.left = i;
        int i2 = (int) (j & 4294967295L);
        rect.top = i2;
        rect.right = i + ((int) (j2 >> 32));
        rect.bottom = i2 + ((int) (j2 & 4294967295L));
        Rect rect2 = this.c;
        rect2.getClass();
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = (int) (j3 >> 32);
        rect2.bottom = (int) (j3 & 4294967295L);
        canvas.drawBitmap(bitmapA, rect, rect2, faVar.a);
    }

    @Override // defpackage.cw
    public final void f(float f, float f2, float f3, float f4, int i) {
        this.a.clipRect(f, f2, f3, f4, i == 0 ? Region.Op.DIFFERENCE : Region.Op.INTERSECT);
    }

    @Override // defpackage.cw
    public final void g(float f, float f2) {
        this.a.translate(f, f2);
    }

    @Override // defpackage.cw
    public final void h(na naVar, fa faVar) {
        Canvas canvas = this.a;
        if (naVar instanceof na) {
            canvas.drawPath(naVar.a, faVar.a);
        } else {
            dk0.r("Unable to obtain android.graphics.Path");
        }
    }

    @Override // defpackage.cw
    public final void i(float f, float f2, float f3, float f4, fa faVar) {
        this.a.drawOval(f, f2, f3, f4, faVar.a);
    }

    @Override // defpackage.cw
    public final void j() {
        this.a.restore();
    }

    @Override // defpackage.cw
    public final void k(float f, float f2, float f3, float f4, float f5, float f6, fa faVar) {
        this.a.drawRoundRect(f, f2, f3, f4, f5, f6, faVar.a);
    }

    @Override // defpackage.cw
    public final void m() {
        this.a.save();
    }

    @Override // defpackage.cw
    public final void n(long j, long j2, fa faVar) {
        this.a.drawLine(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), faVar.a);
    }

    @Override // defpackage.cw
    public final void o() {
        fh4.a(this.a, false);
    }

    @Override // defpackage.cw
    public final void p(l42 l42Var, fa faVar) {
        this.a.saveLayer(l42Var.a, l42Var.b, l42Var.c, l42Var.d, faVar.a, 31);
    }

    @Override // defpackage.cw
    public final void q(float f, float f2, float f3, float f4, fa faVar) {
        this.a.drawRect(f, f2, f3, f4, faVar.a);
    }

    @Override // defpackage.cw
    public final void r(float[] fArr) {
        if (dr4.a(fArr)) {
            return;
        }
        Matrix matrix = new Matrix();
        hd4.c(matrix, fArr);
        this.a.concat(matrix);
    }

    @Override // defpackage.cw
    public final void s() {
        fh4.a(this.a, true);
    }

    @Override // defpackage.cw
    public final void t(na naVar) {
        Canvas canvas = this.a;
        if (naVar instanceof na) {
            canvas.clipPath(naVar.a, Region.Op.INTERSECT);
        } else {
            dk0.r("Unable to obtain android.graphics.Path");
        }
    }

    @Override // defpackage.cw
    public final void u(float f, float f2, float f3, float f4, float f5, float f6, fa faVar) {
        this.a.drawArc(f, f2, f3, f4, f5, f6, false, faVar.a);
    }
}
