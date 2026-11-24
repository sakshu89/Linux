package defpackage;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fa {
    public final Paint a;
    public int b = 3;
    public Shader c;
    public nl d;

    public fa(Paint paint) {
        this.a = paint;
    }

    public final int a() {
        Paint.Cap strokeCap = this.a.getStrokeCap();
        int i = strokeCap == null ? -1 : ga.a[strokeCap.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    public final int b() {
        Paint.Join strokeJoin = this.a.getStrokeJoin();
        int i = strokeJoin == null ? -1 : ga.b[strokeJoin.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 2;
    }

    public final void c(float f) {
        this.a.setAlpha((int) Math.rint(f * 255.0f));
    }

    public final void d(int i) {
        if (this.b == i) {
            return;
        }
        this.b = i;
        int i2 = Build.VERSION.SDK_INT;
        Paint paint = this.a;
        if (i2 >= 29) {
            paint.setBlendMode(jc4.b(i));
        } else {
            paint.setXfermode(new PorterDuffXfermode(jc4.c(i)));
        }
    }

    public final void e(long j) {
        this.a.setColor(ki4.g(j));
    }

    public final void f(nl nlVar) {
        this.d = nlVar;
        this.a.setColorFilter(nlVar != null ? nlVar.a : null);
    }

    public final void g(int i) {
        this.a.setFilterBitmap(!(i == 0));
    }

    public final void h(Shader shader) {
        this.c = shader;
        this.a.setShader(shader);
    }

    public final void i(int i) {
        Paint.Cap cap;
        if (i == 2) {
            cap = Paint.Cap.SQUARE;
        } else if (i == 1) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = i == 0 ? Paint.Cap.BUTT : Paint.Cap.BUTT;
        }
        this.a.setStrokeCap(cap);
    }

    public final void j(int i) {
        Paint.Join join;
        if (i == 0) {
            join = Paint.Join.MITER;
        } else if (i == 2) {
            join = Paint.Join.BEVEL;
        } else {
            join = i == 1 ? Paint.Join.ROUND : Paint.Join.MITER;
        }
        this.a.setStrokeJoin(join);
    }

    public final void k(float f) {
        this.a.setStrokeWidth(f);
    }

    public final void l(int i) {
        this.a.setStyle(i == 1 ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
