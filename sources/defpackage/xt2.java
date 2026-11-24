package defpackage;

import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xt2 implements Closeable {
    public final Surface b;
    public final int c;
    public final Size e;
    public final float[] f;
    public s40 i;
    public Executor j;
    public final wp s;
    public final tp t;
    public final Object a = new Object();
    public boolean k = false;
    public boolean n = false;

    public xt2(Surface surface, int i, Size size, ij ijVar, ij ijVar2) {
        float[] fArr = new float[16];
        this.f = fArr;
        this.b = surface;
        this.c = i;
        this.e = size;
        c(fArr, new float[16], ijVar);
        c(new float[16], new float[16], ijVar2);
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        try {
            this.t = tpVar;
            tpVar.a = "SurfaceOutputImpl close future complete";
        } catch (Exception e) {
            wpVar.b(e);
        }
        this.s = wpVar;
    }

    public static void c(float[] fArr, float[] fArr2, ij ijVar) {
        Matrix.setIdentityM(fArr, 0);
        if (ijVar == null) {
            return;
        }
        Size size = ijVar.a;
        boolean z = ijVar.e;
        int i = ijVar.d;
        cr4.b(fArr);
        cr4.a(fArr, i);
        if (z) {
            Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
            Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
        }
        Size sizeF = z13.f(size, i);
        android.graphics.Matrix matrixA = z13.a(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), new RectF(0.0f, 0.0f, sizeF.getWidth(), sizeF.getHeight()), i, z);
        RectF rectF = new RectF(ijVar.b);
        matrixA.mapRect(rectF);
        float width = rectF.left / sizeF.getWidth();
        float height = ((sizeF.getHeight() - rectF.height()) - rectF.top) / sizeF.getHeight();
        float fWidth = rectF.width() / sizeF.getWidth();
        float fHeight = rectF.height() / sizeF.getHeight();
        Matrix.translateM(fArr, 0, width, height, 0.0f);
        Matrix.scaleM(fArr, 0, fWidth, fHeight, 1.0f);
        wt wtVar = ijVar.c;
        Matrix.setIdentityM(fArr2, 0);
        cr4.b(fArr2);
        if (wtVar != null) {
            hh1.e("Camera has no transform.", wtVar.g());
            cr4.a(fArr2, wtVar.i().a());
            if (wtVar.i().b() == 0) {
                Matrix.translateM(fArr2, 0, 1.0f, 0.0f, 0.0f);
                Matrix.scaleM(fArr2, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        Matrix.invertM(fArr2, 0, fArr2, 0);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.a) {
            try {
                if (!this.n) {
                    this.n = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.t.a(null);
    }

    public final Surface e(xv0 xv0Var, s40 s40Var) {
        boolean z;
        synchronized (this.a) {
            this.j = xv0Var;
            this.i = s40Var;
            z = this.k;
        }
        if (z) {
            j();
        }
        return this.b;
    }

    public final void j() {
        Executor executor;
        s40 s40Var;
        AtomicReference atomicReference = new AtomicReference();
        synchronized (this.a) {
            try {
                if (this.j == null || (s40Var = this.i) == null) {
                    this.k = true;
                } else if (!this.n) {
                    atomicReference.set(s40Var);
                    executor = this.j;
                    this.k = false;
                }
                executor = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executor != null) {
            try {
                executor.execute(new v62(3, this, atomicReference));
            } catch (RejectedExecutionException unused) {
                xq4.c(3, "SurfaceOutputImpl");
            }
        }
    }
}
