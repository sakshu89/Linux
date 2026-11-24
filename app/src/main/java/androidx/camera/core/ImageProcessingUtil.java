package androidx.camera.core;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.Surface;
import defpackage.dk0;
import defpackage.hh1;
import defpackage.m92;
import defpackage.og;
import defpackage.rk2;
import defpackage.xq4;
import defpackage.yy0;
import defpackage.zy0;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageProcessingUtil {
    public static int a;

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    public static zy0 a(m92 m92Var, byte[] bArr) {
        hh1.b(m92Var.h() == 256);
        bArr.getClass();
        Surface surface = m92Var.getSurface();
        surface.getClass();
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            xq4.a("ImageProcessingUtil", "Failed to enqueue JPEG image.");
            return null;
        }
        zy0 zy0VarE = m92Var.e();
        if (zy0VarE == null) {
            xq4.a("ImageProcessingUtil", "Failed to get acquire JPEG image.");
        }
        return zy0VarE;
    }

    public static Bitmap b(zy0 zy0Var) {
        if (zy0Var.getFormat() != 35) {
            og.i("Input image format must be YUV_420_888");
            return null;
        }
        int iB = zy0Var.b();
        int iA = zy0Var.a();
        int iS = zy0Var.g()[0].s();
        int iS2 = zy0Var.g()[1].s();
        int iS3 = zy0Var.g()[2].s();
        int iR = zy0Var.g()[0].r();
        int iR2 = zy0Var.g()[1].r();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zy0Var.b(), zy0Var.a(), Bitmap.Config.ARGB_8888);
        if (nativeConvertAndroid420ToBitmap(zy0Var.g()[0].p(), iS, zy0Var.g()[1].p(), iS2, zy0Var.g()[2].p(), iS3, iR, iR2, bitmapCreateBitmap, bitmapCreateBitmap.getRowBytes(), iB, iA) == 0) {
            return bitmapCreateBitmap;
        }
        dk0.r("YUV to RGB conversion failed");
        return null;
    }

    public static rk2 c(zy0 zy0Var, m92 m92Var, ByteBuffer byteBuffer, int i) {
        if (zy0Var.getFormat() != 35 || zy0Var.g().length != 3) {
            xq4.a("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return null;
        }
        System.currentTimeMillis();
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            xq4.a("ImageProcessingUtil", "Unsupported rotation degrees for rotate RGB");
            return null;
        }
        if (nativeConvertAndroid420ToABGR(zy0Var.g()[0].p(), zy0Var.g()[0].s(), zy0Var.g()[1].p(), zy0Var.g()[1].s(), zy0Var.g()[2].p(), zy0Var.g()[2].s(), zy0Var.g()[0].r(), zy0Var.g()[1].r(), m92Var.getSurface(), byteBuffer, zy0Var.b(), zy0Var.a(), 0, 0, 0, i) != 0) {
            xq4.a("ImageProcessingUtil", "YUV to RGB conversion failure");
            return null;
        }
        if (Log.isLoggable("MH", 3)) {
            Locale locale = Locale.US;
            System.currentTimeMillis();
            xq4.c(3, "ImageProcessingUtil");
            a++;
        }
        zy0 zy0VarE = m92Var.e();
        if (zy0VarE == null) {
            xq4.a("ImageProcessingUtil", "YUV to RGB acquireLatestImage failure");
            return null;
        }
        rk2 rk2Var = new rk2(zy0VarE);
        rk2Var.c(new yy0(zy0VarE, zy0Var));
        return rk2Var;
    }

    public static void d(Bitmap bitmap, ByteBuffer byteBuffer, int i) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, bitmap.getRowBytes(), i, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    public static void e(Bitmap bitmap, ByteBuffer byteBuffer, int i) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    public static void f(byte[] bArr, Surface surface) {
        surface.getClass();
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            xq4.a("ImageProcessingUtil", "Failed to enqueue JPEG image.");
        }
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, Surface surface, ByteBuffer byteBuffer4, int i6, int i7, int i8, int i9, int i10, int i11);

    private static native int nativeConvertAndroid420ToBitmap(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, Bitmap bitmap, int i6, int i7, int i8);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z);

    private static native int nativeWriteJpegToSurface(byte[] bArr, Surface surface);
}
