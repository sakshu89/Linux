package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.media.Image;
import android.media.ImageReader;
import android.text.TextUtils;
import android.view.Surface;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s9 implements bz0 {
    public final /* synthetic */ int a;
    public boolean b;
    public Object c;
    public final Object e;

    public s9(ys ysVar) {
        boolean z = true;
        this.a = 1;
        this.c = ysVar;
        this.e = q82.A(ysVar);
        int[] iArr = (int[]) ysVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i : iArr) {
                if (i != 18) {
                }
            }
            z = false;
        } else {
            z = false;
        }
        this.b = z;
    }

    public static boolean c(ig0 ig0Var, ig0 ig0Var2) {
        boolean zB = ig0Var2.b();
        int i = ig0Var2.a;
        hh1.e("Fully specified range is not actually fully specified.", zB);
        int i2 = ig0Var.a;
        if (i2 == 2 && i == 1) {
            return false;
        }
        if (i2 != 2 && i2 != 0 && i2 != i) {
            return false;
        }
        int i3 = ig0Var.b;
        return i3 == 0 || i3 == ig0Var2.b;
    }

    public static boolean d(ig0 ig0Var, ig0 ig0Var2, HashSet hashSet) {
        if (hashSet.contains(ig0Var2)) {
            return c(ig0Var, ig0Var2);
        }
        ig0Var.toString();
        ig0Var2.toString();
        xq4.c(3, "DynamicRangeResolver");
        return false;
    }

    public static ig0 f(ig0 ig0Var, LinkedHashSet linkedHashSet, HashSet hashSet) {
        if (ig0Var.a == 1) {
            return null;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ig0 ig0Var2 = (ig0) it.next();
            hh1.d(ig0Var2, "Fully specified DynamicRange cannot be null.");
            int i = ig0Var2.a;
            hh1.e("Fully specified DynamicRange must have fully defined encoding.", ig0Var2.b());
            if (i != 1 && d(ig0Var, ig0Var2, hashSet)) {
                return ig0Var2;
            }
        }
        return null;
    }

    public static void k(HashSet hashSet, ig0 ig0Var, q82 q82Var) {
        hh1.e("Cannot update already-empty constraints.", !hashSet.isEmpty());
        Set setA = ((kg0) q82Var.a).a(ig0Var);
        if (setA.isEmpty()) {
            return;
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet.retainAll(setA);
        if (hashSet.isEmpty()) {
            og.j("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  ", ig0Var, "\nConstraints:\n  ", TextUtils.join("\n  ", setA), "\nExisting constraints:\n  ", TextUtils.join("\n  ", hashSet2));
        }
    }

    @Override // defpackage.bz0
    public int a() {
        int height;
        synchronized (this.e) {
            height = ((ImageReader) this.c).getHeight();
        }
        return height;
    }

    @Override // defpackage.bz0
    public int b() {
        int width;
        synchronized (this.e) {
            width = ((ImageReader) this.c).getWidth();
        }
        return width;
    }

    @Override // defpackage.bz0
    public void close() {
        synchronized (this.e) {
            ((ImageReader) this.c).close();
        }
    }

    @Override // defpackage.bz0
    public zy0 e() {
        Image imageAcquireLatestImage;
        synchronized (this.e) {
            try {
                imageAcquireLatestImage = ((ImageReader) this.c).acquireLatestImage();
            } catch (RuntimeException e) {
                if (!"ImageReaderContext is not initialized".equals(e.getMessage())) {
                    throw e;
                }
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return null;
            }
            return new q9(imageAcquireLatestImage);
        }
    }

    public e80 g() {
        iz izVar = (iz) this.e;
        int i = izVar.b;
        int i2 = izVar.c;
        if (i < i2) {
            return e80.b;
        }
        return i > i2 ? e80.a : e80.c;
    }

    @Override // defpackage.bz0
    public Surface getSurface() {
        Surface surface;
        synchronized (this.e) {
            surface = ((ImageReader) this.c).getSurface();
        }
        return surface;
    }

    @Override // defpackage.bz0
    public int h() {
        int imageFormat;
        synchronized (this.e) {
            imageFormat = ((ImageReader) this.c).getImageFormat();
        }
        return imageFormat;
    }

    public void i() {
        if (this.b) {
            ny2.b((ny2) this.e, (oz2) this.c);
        }
    }

    @Override // defpackage.bz0
    public void j() {
        synchronized (this.e) {
            this.b = true;
            ((ImageReader) this.c).setOnImageAvailableListener(null, null);
        }
    }

    @Override // defpackage.bz0
    public void l(final az0 az0Var, final Executor executor) {
        synchronized (this.e) {
            this.b = false;
            ((ImageReader) this.c).setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: r9
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    s9 s9Var = this.a;
                    Executor executor2 = executor;
                    az0 az0Var2 = az0Var;
                    synchronized (s9Var.e) {
                        try {
                            if (!s9Var.b) {
                                executor2.execute(new o8(1, s9Var, az0Var2));
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }, jg1.g());
        }
    }

    public long m(ty2 ty2Var, long j, boolean z, lf2 lf2Var) {
        ny2 ny2Var = (ny2) this.e;
        long jC = ny2.c(ny2Var, ty2Var, j, z, false, lf2Var, false);
        if (!oz2.a(jC, (oz2) this.c)) {
            this.b = false;
        }
        ny2Var.q(oz2.c(jC) ? rv0.c : rv0.b);
        return jC;
    }

    @Override // defpackage.bz0
    public int n() {
        int maxImages;
        synchronized (this.e) {
            maxImages = ((ImageReader) this.c).getMaxImages();
        }
        return maxImages;
    }

    public void o(xd4 xd4Var) {
        synchronized (this.e) {
            try {
                if (((ArrayDeque) this.c) == null) {
                    this.c = new ArrayDeque();
                }
                ((ArrayDeque) this.c).add(xd4Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bz0
    public zy0 p() {
        Image imageAcquireNextImage;
        synchronized (this.e) {
            try {
                imageAcquireNextImage = ((ImageReader) this.c).acquireNextImage();
            } catch (RuntimeException e) {
                if (!"ImageReaderContext is not initialized".equals(e.getMessage())) {
                    throw e;
                }
                imageAcquireNextImage = null;
            }
            if (imageAcquireNextImage == null) {
                return null;
            }
            return new q9(imageAcquireNextImage);
        }
    }

    public void q(et4 et4Var) {
        xd4 xd4Var;
        synchronized (this.e) {
            if (((ArrayDeque) this.c) != null && !this.b) {
                this.b = true;
                while (true) {
                    synchronized (this.e) {
                        try {
                            xd4Var = (xd4) ((ArrayDeque) this.c).poll();
                            if (xd4Var == null) {
                                this.b = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    xd4Var.a(et4Var);
                }
            }
        }
    }

    public String toString() {
        switch (this.a) {
            case 2:
                return "SingleSelectionLayout(isStartHandle=" + this.b + ", crossed=" + g() + ", info=\n\t" + ((iz) this.e) + ')';
            default:
                return super.toString();
        }
    }

    public s9(ImageReader imageReader) {
        this.a = 0;
        this.e = new Object();
        this.b = true;
        this.c = imageReader;
    }

    public s9() {
        this.a = 4;
        this.e = new Object();
    }

    public s9(boolean z, jf2 jf2Var, iz izVar) {
        this.a = 2;
        this.b = z;
        this.c = jf2Var;
        this.e = izVar;
    }

    public s9(ny2 ny2Var) {
        this.a = 3;
        this.e = ny2Var;
        this.b = true;
    }
}
