package defpackage;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import com.project.sonic.ui.camera.CaptureActivity;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r02 extends FrameLayout {
    public o02 a;
    public s02 b;
    public final rb2 c;
    public final l02 e;
    public boolean f;
    public final pl1 i;
    public final AtomicReference j;
    public final t02 k;
    public ut n;
    public final n02 s;
    public final m02 t;
    public final py0 u;

    /* JADX WARN: Type inference failed for: r0v6, types: [m02] */
    public r02(CaptureActivity captureActivity) {
        super(captureActivity, null, 0, 0);
        this.a = o02.PERFORMANCE;
        l02 l02Var = new l02();
        l02Var.h = p02.FILL_CENTER;
        this.e = l02Var;
        this.f = true;
        this.i = new pl1(q02.a);
        this.j = new AtomicReference();
        this.k = new t02(l02Var);
        this.s = new n02(this);
        this.t = new View.OnLayoutChangeListener() { // from class: m02
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
                    return;
                }
                r02 r02Var = this.a;
                r02Var.a();
                vc4.b();
                r02Var.getViewPort();
            }
        };
        this.u = new py0(9, this);
        vc4.b();
        Resources.Theme theme = captureActivity.getTheme();
        int[] iArr = l22.a;
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(null, iArr, 0, 0);
        u73.b(this, captureActivity, iArr, null, typedArrayObtainStyledAttributes, 0);
        try {
            int integer = typedArrayObtainStyledAttributes.getInteger(1, l02Var.h.a);
            for (p02 p02Var : p02.values()) {
                if (p02Var.a == integer) {
                    setScaleType(p02Var);
                    int integer2 = typedArrayObtainStyledAttributes.getInteger(0, 0);
                    for (o02 o02Var : o02.values()) {
                        if (o02Var.a == integer2) {
                            setImplementationMode(o02Var);
                            typedArrayObtainStyledAttributes.recycle();
                            new su0(captureActivity, new dk0(16));
                            if (getBackground() == null) {
                                setBackgroundColor(getContext().getColor(R.color.black));
                            }
                            rb2 rb2Var = new rb2(captureActivity, null, 0, 0);
                            rb2Var.setBackgroundColor(-1);
                            rb2Var.setAlpha(0.0f);
                            rb2Var.setElevation(Float.MAX_VALUE);
                            this.c = rb2Var;
                            rb2Var.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            return;
                        }
                    }
                    throw new IllegalArgumentException("Unknown implementation mode id " + integer2);
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + integer);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static boolean b(fu2 fu2Var, o02 o02Var) {
        boolean zEquals = fu2Var.d.i().d().equals("androidx.camera.camera2.legacy");
        boolean z = (vc0.a.d(SurfaceViewStretchedQuirk.class) == null && vc0.a.d(SurfaceViewNotCroppedByParentQuirk.class) == null) ? false : true;
        if (!zEquals && !z) {
            int iOrdinal = o02Var.ordinal();
            if (iOrdinal == 0) {
                return false;
            }
            if (iOrdinal != 1) {
                dk0.y(o02Var, "Invalid implementation mode: ");
                return false;
            }
        }
        return true;
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    private qy0 getScreenFlashInternal() {
        return this.c.getScreenFlash();
    }

    private int getViewPortScaleType() {
        int iOrdinal = getScaleType().ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5) {
                    dk0.x(getScaleType(), "Unexpected scale type: ");
                    return 0;
                }
            }
        }
        return i;
    }

    private void setScreenFlashUiInfo(qy0 qy0Var) {
        xq4.c(3, "PreviewView");
    }

    public final void a() {
        Rect rect;
        Display display;
        ut utVar;
        vc4.b();
        if (this.b != null) {
            if (this.f && (display = getDisplay()) != null && (utVar = this.n) != null) {
                l02 l02Var = this.e;
                int iF = utVar.f(display.getRotation());
                int rotation = display.getRotation();
                if (l02Var.g) {
                    l02Var.c = iF;
                    l02Var.e = rotation;
                }
            }
            this.b.f();
        }
        t02 t02Var = this.k;
        Size size = new Size(getWidth(), getHeight());
        int layoutDirection = getLayoutDirection();
        t02Var.getClass();
        vc4.b();
        synchronized (t02Var) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0 && (rect = t02Var.b) != null) {
                    t02Var.a.a(size, layoutDirection, rect);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Bitmap getBitmap() {
        vc4.b();
        s02 s02Var = this.b;
        if (s02Var == null) {
            return null;
        }
        FrameLayout frameLayout = s02Var.b;
        Bitmap bitmapB = s02Var.b();
        if (bitmapB == null) {
            return null;
        }
        l02 l02Var = s02Var.c;
        Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
        int layoutDirection = frameLayout.getLayoutDirection();
        if (!l02Var.f()) {
            return bitmapB;
        }
        Matrix matrixD = l02Var.d();
        RectF rectFE = l02Var.e(size, layoutDirection);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), bitmapB.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(matrixD);
        matrix.postScale(rectFE.width() / l02Var.a.getWidth(), rectFE.height() / l02Var.a.getHeight());
        matrix.postTranslate(rectFE.left, rectFE.top);
        canvas.drawBitmap(bitmapB, matrix, new Paint(7));
        return bitmapCreateBitmap;
    }

    public ht getController() {
        vc4.b();
        return null;
    }

    public o02 getImplementationMode() {
        vc4.b();
        return this.a;
    }

    public jj1 getMeteringPointFactory() {
        vc4.b();
        return this.k;
    }

    public ct1 getOutputTransform() {
        Matrix matrixC;
        l02 l02Var = this.e;
        vc4.b();
        try {
            matrixC = l02Var.c(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrixC = null;
        }
        Rect rect = l02Var.b;
        if (matrixC == null || rect == null) {
            xq4.c(3, "PreviewView");
            return null;
        }
        RectF rectF = z13.a;
        RectF rectF2 = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(z13.a, rectF2, Matrix.ScaleToFit.FILL);
        matrixC.preConcat(matrix);
        if (this.b instanceof f03) {
            matrixC.postConcat(getMatrix());
        } else if (!getMatrix().isIdentity()) {
            xq4.d("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        new Size(rect.width(), rect.height());
        return new ct1();
    }

    public jd1 getPreviewStreamState() {
        return this.i;
    }

    public p02 getScaleType() {
        vc4.b();
        return this.e.h;
    }

    public qy0 getScreenFlash() {
        return getScreenFlashInternal();
    }

    public Matrix getSensorToViewTransform() {
        vc4.b();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        Size size = new Size(getWidth(), getHeight());
        int layoutDirection = getLayoutDirection();
        l02 l02Var = this.e;
        if (!l02Var.f()) {
            return null;
        }
        Matrix matrix = new Matrix(l02Var.d);
        matrix.postConcat(l02Var.c(size, layoutDirection));
        return matrix;
    }

    public f02 getSurfaceProvider() {
        vc4.b();
        return this.u;
    }

    public i83 getViewPort() {
        vc4.b();
        if (getDisplay() == null) {
            return null;
        }
        getDisplay().getRotation();
        vc4.b();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        new Rational(getWidth(), getHeight());
        getViewPortScaleType();
        getLayoutDirection();
        return new i83();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.s, new Handler(Looper.getMainLooper()));
        }
        addOnLayoutChangeListener(this.t);
        s02 s02Var = this.b;
        if (s02Var != null) {
            s02Var.c();
        }
        vc4.b();
        getViewPort();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.t);
        s02 s02Var = this.b;
        if (s02Var != null) {
            s02Var.d();
        }
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.s);
    }

    public void setController(ht htVar) {
        vc4.b();
        vc4.b();
        getViewPort();
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public void setImplementationMode(o02 o02Var) {
        vc4.b();
        this.a = o02Var;
    }

    public void setScaleType(p02 p02Var) {
        vc4.b();
        this.e.h = p02Var;
        a();
        vc4.b();
        getViewPort();
    }

    public void setScreenFlashOverlayColor(int i) {
        this.c.setBackgroundColor(i);
    }

    public void setScreenFlashWindow(Window window) {
        vc4.b();
        this.c.setScreenFlashWindow(window);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }
}
