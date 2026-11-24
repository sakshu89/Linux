package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iu2 extends s02 {
    public SurfaceView e;
    public final hu2 f;

    public iu2(FrameLayout frameLayout, l02 l02Var) {
        super(frameLayout, l02Var);
        this.f = new hu2(this);
    }

    @Override // defpackage.s02
    public final View a() {
        return this.e;
    }

    @Override // defpackage.s02
    public final Bitmap b() {
        SurfaceView surfaceView = this.e;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.e.getHolder().getSurface().isValid()) {
            return null;
        }
        final Semaphore semaphore = new Semaphore(0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.e.getWidth(), this.e.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
        handlerThread.start();
        PixelCopy.request(this.e, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: gu2
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                if (i == 0) {
                    xq4.c(3, "SurfaceViewImpl");
                } else {
                    xq4.a("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i);
                }
                semaphore.release();
            }
        }, new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(1, 100L, TimeUnit.MILLISECONDS)) {
                xq4.a("SurfaceViewImpl", "Timed out while trying to acquire screenshot.");
            }
            return bitmapCreateBitmap;
        } catch (InterruptedException e) {
            xq4.b("SurfaceViewImpl", "Interrupted while trying to acquire screenshot.", e);
            return bitmapCreateBitmap;
        } finally {
            handlerThread.quitSafely();
        }
    }

    @Override // defpackage.s02
    public final void e(fu2 fu2Var, rw rwVar) {
        SurfaceView surfaceView = this.e;
        boolean zEquals = Objects.equals(this.a, fu2Var.b);
        if (surfaceView == null || !zEquals) {
            Size size = fu2Var.b;
            this.a = size;
            size.getClass();
            FrameLayout frameLayout = this.b;
            SurfaceView surfaceView2 = new SurfaceView(frameLayout.getContext());
            this.e = surfaceView2;
            surfaceView2.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
            frameLayout.removeAllViews();
            frameLayout.addView(this.e);
            this.e.getHolder().addCallback(this.f);
        }
        Executor executorB = al4.b(this.e.getContext());
        s7 s7Var = new s7(28, rwVar);
        o62 o62Var = fu2Var.j.c;
        if (o62Var != null) {
            o62Var.a(s7Var, executorB);
        }
        this.e.post(new dc(this, fu2Var, rwVar, 13));
    }

    @Override // defpackage.s02
    public final wc1 g() {
        return mz0.c;
    }

    @Override // defpackage.s02
    public final void c() {
    }

    @Override // defpackage.s02
    public final void d() {
    }
}
