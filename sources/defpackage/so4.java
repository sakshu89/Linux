package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Build;
import androidx.camera.core.ImageProcessingUtil;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class so4 {
    public static Bitmap a(zy0 zy0Var) {
        int format = zy0Var.getFormat();
        if (format == 1) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zy0Var.b(), zy0Var.a(), Bitmap.Config.ARGB_8888);
            zy0Var.g()[0].p().rewind();
            ImageProcessingUtil.e(bitmapCreateBitmap, zy0Var.g()[0].p(), zy0Var.g()[0].s());
            return bitmapCreateBitmap;
        }
        if (format == 35) {
            return ImageProcessingUtil.b(zy0Var);
        }
        if (format != 256 && format != 4101) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + zy0Var.getFormat() + ", only ImageFormat.YUV_420_888 and PixelFormat.RGBA_8888 are supported");
        }
        if (!b(zy0Var.getFormat())) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + zy0Var.getFormat());
        }
        ByteBuffer byteBufferP = zy0Var.g()[0].p();
        int iCapacity = byteBufferP.capacity();
        byte[] bArr = new byte[iCapacity];
        byteBufferP.rewind();
        byteBufferP.get(bArr);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, iCapacity, null);
        if (bitmapDecodeByteArray != null) {
            return bitmapDecodeByteArray;
        }
        dk0.r("Decode jpeg byte array failed");
        return null;
    }

    public static boolean b(int i) {
        return i == 256 || i == 4101;
    }

    public static byte[] c(zy0 zy0Var, Rect rect, int i, int i2) {
        if (zy0Var.getFormat() != 35) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + zy0Var.getFormat());
        }
        uf1 uf1Var = zy0Var.g()[0];
        uf1 uf1Var2 = zy0Var.g()[1];
        int i3 = 2;
        uf1 uf1Var3 = zy0Var.g()[2];
        ByteBuffer byteBufferP = uf1Var.p();
        ByteBuffer byteBufferP2 = uf1Var2.p();
        ByteBuffer byteBufferP3 = uf1Var3.p();
        byteBufferP.rewind();
        byteBufferP2.rewind();
        byteBufferP3.rewind();
        int iRemaining = byteBufferP.remaining();
        byte[] bArr = new byte[((zy0Var.a() * zy0Var.b()) / 2) + iRemaining];
        int iB = 0;
        for (int i4 = 0; i4 < zy0Var.a(); i4++) {
            byteBufferP.get(bArr, iB, zy0Var.b());
            iB += zy0Var.b();
            byteBufferP.position(Math.min(iRemaining, uf1Var.s() + (byteBufferP.position() - zy0Var.b())));
        }
        int iA = zy0Var.a() / 2;
        int iB2 = zy0Var.b() / 2;
        int iS = uf1Var3.s();
        int iS2 = uf1Var2.s();
        int iR = uf1Var3.r();
        int iR2 = uf1Var2.r();
        byte[] bArr2 = new byte[iS];
        byte[] bArr3 = new byte[iS2];
        int i5 = 0;
        while (i5 < iA) {
            int i6 = i3;
            byteBufferP3.get(bArr2, 0, Math.min(iS, byteBufferP3.remaining()));
            byteBufferP2.get(bArr3, 0, Math.min(iS2, byteBufferP2.remaining()));
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < iB2; i9++) {
                int i10 = iB + 1;
                bArr[iB] = bArr2[i7];
                iB += 2;
                bArr[i10] = bArr3[i8];
                i7 += iR;
                i8 += iR2;
            }
            i5++;
            i3 = i6;
        }
        int i11 = i3;
        YuvImage yuvImage = new YuvImage(bArr, 17, zy0Var.b(), zy0Var.a(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        lk0[] lk0VarArr = ck0.c;
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        bk0 bk0Var = new bk0();
        String strValueOf = String.valueOf(1);
        ArrayList arrayList = bk0Var.a;
        bk0Var.c("Orientation", strValueOf, arrayList);
        bk0Var.c("XResolution", "72/1", arrayList);
        bk0Var.c("YResolution", "72/1", arrayList);
        bk0Var.c("ResolutionUnit", String.valueOf(i11), arrayList);
        bk0Var.c("YCbCrPositioning", String.valueOf(1), arrayList);
        bk0Var.c("Make", Build.MANUFACTURER, arrayList);
        bk0Var.c("Model", Build.MODEL, arrayList);
        if (zy0Var.m() != null) {
            zy0Var.m().a(bk0Var);
        }
        bk0Var.d(i2);
        bk0Var.c("ImageWidth", String.valueOf(zy0Var.b()), arrayList);
        bk0Var.c("ImageLength", String.valueOf(zy0Var.a()), arrayList);
        ArrayList list = Collections.list(new ak0(bk0Var));
        if (!((Map) list.get(1)).isEmpty()) {
            bk0Var.b("ExposureProgram", String.valueOf(0), list);
            bk0Var.b("ExifVersion", "0230", list);
            bk0Var.b("ComponentsConfiguration", "1,2,3,0", list);
            bk0Var.b("MeteringMode", String.valueOf(0), list);
            bk0Var.b("LightSource", String.valueOf(0), list);
            bk0Var.b("FlashpixVersion", "0100", list);
            bk0Var.b("FocalPlaneResolutionUnit", String.valueOf(i11), list);
            bk0Var.b("FileSource", String.valueOf(3), list);
            bk0Var.b("SceneType", String.valueOf(1), list);
            bk0Var.b("CustomRendered", String.valueOf(0), list);
            bk0Var.b("SceneCaptureType", String.valueOf(0), list);
            bk0Var.b("Contrast", String.valueOf(0), list);
            bk0Var.b("Saturation", String.valueOf(0), list);
            bk0Var.b("Sharpness", String.valueOf(0), list);
        }
        if (!((Map) list.get(i11)).isEmpty()) {
            bk0Var.b("GPSVersionID", "2300", list);
            bk0Var.b("GPSSpeedRef", "K", list);
            bk0Var.b("GPSTrackRef", "T", list);
            bk0Var.b("GPSImgDirectionRef", "T", list);
            bk0Var.b("GPSDestBearingRef", "T", list);
            bk0Var.b("GPSDestDistanceRef", "K", list);
        }
        if (yuvImage.compressToJpeg(rect == null ? new Rect(0, 0, zy0Var.b(), zy0Var.a()) : rect, i, new kk0(byteArrayOutputStream, new ck0(bk0Var.b, list)))) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new dz0("YuvImage failed to encode jpeg.");
    }
}
