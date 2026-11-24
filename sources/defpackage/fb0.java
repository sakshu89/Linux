package defpackage;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fb0 implements yt2, SurfaceTexture.OnFrameAvailableListener {
    public final qq1 a;
    public final HandlerThread b;
    public final xv0 c;
    public final Handler d;
    public final AtomicBoolean e;
    public final float[] f;
    public final float[] g;
    public final LinkedHashMap h;
    public int i;
    public boolean j;
    public final ArrayList k;

    public fb0(ig0 ig0Var) {
        Map map = Collections.EMPTY_MAP;
        this.e = new AtomicBoolean(false);
        this.f = new float[16];
        this.g = new float[16];
        this.h = new LinkedHashMap();
        this.i = 0;
        this.j = false;
        this.k = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.d = handler;
        this.c = new xv0(handler);
        this.a = new qq1();
        try {
            h(ig0Var);
        } catch (RuntimeException e) {
            a();
            throw e;
        }
    }

    @Override // defpackage.yt2
    public final void a() {
        if (this.e.getAndSet(true)) {
            return;
        }
        e(new s7(17, this), new c7(1));
    }

    @Override // defpackage.yt2
    public final void b(xt2 xt2Var) {
        if (this.e.get()) {
            xt2Var.close();
            return;
        }
        o8 o8Var = new o8(11, this, xt2Var);
        Objects.requireNonNull(xt2Var);
        e(o8Var, new s7(16, xt2Var));
    }

    @Override // defpackage.yt2
    public final void c(fu2 fu2Var) {
        if (this.e.get()) {
            fu2Var.c();
        } else {
            e(new o8(13, this, fu2Var), new db0(fu2Var, 0));
        }
    }

    public final void d() {
        if (this.j && this.i == 0) {
            LinkedHashMap linkedHashMap = this.h;
            Iterator it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((xt2) it.next()).close();
            }
            ArrayList arrayList = this.k;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((di) obj).c.b(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            linkedHashMap.clear();
            qq1 qq1Var = this.a;
            if (((AtomicBoolean) qq1Var.c).getAndSet(false)) {
                ur0.c((Thread) qq1Var.f);
                qq1Var.q();
            }
            this.b.quit();
        }
    }

    public final void e(Runnable runnable, Runnable runnable2) {
        try {
            this.c.execute(new dc(this, runnable2, runnable, 5));
        } catch (RejectedExecutionException e) {
            xq4.e("DefaultSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    public final void f(Exception exc) {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((di) obj).c.b(exc);
        }
        arrayList.clear();
    }

    public final Bitmap g(Size size, float[] fArr, int i) {
        float[] fArr2 = (float[]) fArr.clone();
        cr4.a(fArr2, i);
        cr4.b(fArr2);
        Size sizeF = z13.f(size, i);
        qq1 qq1Var = this.a;
        qq1Var.getClass();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(sizeF.getHeight() * sizeF.getWidth() * 4);
        hh1.a("ByteBuffer capacity is not equal to width * height * 4.", byteBufferAllocateDirect.capacity() == (sizeF.getHeight() * sizeF.getWidth()) * 4);
        hh1.a("ByteBuffer is not direct.", byteBufferAllocateDirect.isDirect());
        int[] iArr = ur0.a;
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        ur0.b("glGenTextures");
        int i2 = iArr2[0];
        GLES20.glActiveTexture(33985);
        ur0.b("glActiveTexture");
        GLES20.glBindTexture(3553, i2);
        ur0.b("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, sizeF.getWidth(), sizeF.getHeight(), 0, 6407, 5121, null);
        ur0.b("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int[] iArr3 = new int[1];
        GLES20.glGenFramebuffers(1, iArr3, 0);
        ur0.b("glGenFramebuffers");
        int i3 = iArr3[0];
        GLES20.glBindFramebuffer(36160, i3);
        ur0.b("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        ur0.b("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        ur0.b("glActiveTexture");
        GLES20.glBindTexture(36197, qq1Var.a);
        ur0.b("glBindTexture");
        qq1Var.s = null;
        GLES20.glViewport(0, 0, sizeF.getWidth(), sizeF.getHeight());
        GLES20.glScissor(0, 0, sizeF.getWidth(), sizeF.getHeight());
        sr0 sr0Var = (sr0) qq1Var.u;
        sr0Var.getClass();
        if (sr0Var instanceof tr0) {
            GLES20.glUniformMatrix4fv(((tr0) sr0Var).f, 1, false, fArr2, 0);
            ur0.b("glUniformMatrix4fv");
        }
        GLES20.glDrawArrays(5, 0, 4);
        ur0.b("glDrawArrays");
        GLES20.glReadPixels(0, 0, sizeF.getWidth(), sizeF.getHeight(), 6408, 5121, byteBufferAllocateDirect);
        ur0.b("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
        ur0.b("glDeleteTextures");
        GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
        ur0.b("glDeleteFramebuffers");
        int i4 = qq1Var.a;
        GLES20.glActiveTexture(33984);
        ur0.b("glActiveTexture");
        GLES20.glBindTexture(36197, i4);
        ur0.b("glBindTexture");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizeF.getWidth(), sizeF.getHeight(), Bitmap.Config.ARGB_8888);
        byteBufferAllocateDirect.rewind();
        ImageProcessingUtil.e(bitmapCreateBitmap, byteBufferAllocateDirect, sizeF.getWidth() * 4);
        return bitmapCreateBitmap;
    }

    public final void h(ig0 ig0Var) {
        Map map = Collections.EMPTY_MAP;
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            e(new dc(this, ig0Var, tpVar), new c7(1));
            tpVar.a = "Init GlRenderer";
        } catch (Exception e) {
            wpVar.b(e);
        }
        try {
            wpVar.get();
        } catch (InterruptedException | ExecutionException e2) {
            e = e2;
            if (e instanceof ExecutionException) {
                e = e.getCause();
            }
            if (!(e instanceof RuntimeException)) {
                throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
            }
            throw ((RuntimeException) e);
        }
    }

    public final void i(b33 b33Var) {
        ArrayList arrayList = this.k;
        if (arrayList.isEmpty()) {
            return;
        }
        if (b33Var == null) {
            f(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator it = arrayList.iterator();
                int i = -1;
                int i2 = -1;
                Bitmap bitmapG = null;
                byte[] byteArray = null;
                while (it.hasNext()) {
                    di diVar = (di) it.next();
                    int i3 = diVar.b;
                    int i4 = diVar.a;
                    if (i != i3 || bitmapG == null) {
                        if (bitmapG != null) {
                            bitmapG.recycle();
                        }
                        bitmapG = g((Size) b33Var.b, (float[]) b33Var.c, i3);
                        i2 = -1;
                        i = i3;
                    }
                    if (i2 != i4) {
                        byteArrayOutputStream.reset();
                        bitmapG.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                        byteArray = byteArrayOutputStream.toByteArray();
                        i2 = i4;
                    }
                    Surface surface = (Surface) b33Var.a;
                    Objects.requireNonNull(byteArray);
                    ImageProcessingUtil.f(byteArray, surface);
                    diVar.c.a(null);
                    it.remove();
                }
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            f(e);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.e.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        float[] fArr = this.f;
        surfaceTexture.getTransformMatrix(fArr);
        b33 b33Var = null;
        for (Map.Entry entry : this.h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            xt2 xt2Var = (xt2) entry.getKey();
            float[] fArr2 = xt2Var.f;
            float[] fArr3 = this.g;
            Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
            int i = xt2Var.c;
            if (i == 34) {
                try {
                    this.a.s(surfaceTexture.getTimestamp(), fArr3, surface);
                } catch (RuntimeException e) {
                    xq4.b("DefaultSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            } else {
                hh1.e("Unsupported format: " + i, i == 256);
                hh1.e("Only one JPEG output is supported.", b33Var == null);
                b33Var = new b33(surface, xt2Var.e, (float[]) fArr3.clone());
            }
        }
        try {
            i(b33Var);
        } catch (RuntimeException e2) {
            f(e2);
        }
    }
}
