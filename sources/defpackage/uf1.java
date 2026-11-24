package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import android.util.Base64;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;
import com.ibm.icu.lang.UCharacterEnums;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class uf1 implements ir0, md3, up {
    public static uf1 e;
    public final /* synthetic */ int a;
    public Object b;
    public static final Object c = new Object();
    public static final fl4 f = new fl4(20);

    public uf1(int i) {
        this.a = i;
        switch (i) {
            case 10:
                this.b = new wj1(25);
                break;
            case 13:
                TimeUnit.MINUTES.getClass();
                this.b = new r32(mw2.h);
                break;
            case 16:
                this.b = new ep2(py3.a);
                break;
            case 17:
                this.b = (SmallDisplaySizeQuirk) wc0.a.d(SmallDisplaySizeQuirk.class);
                break;
            case 18:
                break;
            case 19:
                this.b = (ExtraSupportedSurfaceCombinationsQuirk) wc0.a.d(ExtraSupportedSurfaceCombinationsQuirk.class);
                break;
            case 22:
                this.b = new ArrayList(20);
                break;
            case 24:
                this.b = (LargeJpegImageQuirk) uc0.a.d(LargeJpegImageQuirk.class);
                break;
            case 28:
                this.b = new LinkedHashMap(0, 0.75f, true);
                break;
            case 29:
                this.b = (ExtraCroppingQuirk) wc0.a.d(ExtraCroppingQuirk.class);
                break;
            default:
                this.b = new AtomicReference(null);
                break;
        }
    }

    public static uf1 q() {
        uf1 uf1Var;
        synchronized (c) {
            try {
                if (e == null) {
                    HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                    handlerThread.start();
                    e = new uf1(handlerThread.getLooper());
                }
                uf1Var = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uf1Var;
    }

    public static wi v(li liVar) throws ty0 {
        wi wiVar = liVar.a;
        zy0 zy0Var = (zy0) wiVar.a;
        Rect rect = wiVar.e;
        try {
            byte[] bArrC = so4.c(zy0Var, rect, liVar.b, wiVar.f);
            try {
                xj0 xj0Var = new xj0(new jk0(new ByteArrayInputStream(bArrC)));
                Size size = new Size(rect.width(), rect.height());
                Rect rect2 = new Rect(0, 0, rect.width(), rect.height());
                int i = wiVar.f;
                Matrix matrix = wiVar.g;
                RectF rectF = z13.a;
                Matrix matrix2 = new Matrix(matrix);
                matrix2.postTranslate(-rect.left, -rect.top);
                return new wi(bArrC, xj0Var, 256, size, rect2, i, matrix2, wiVar.h);
            } catch (IOException e2) {
                throw new ty0("Failed to extract Exif from YUV-generated JPEG", e2);
            }
        } catch (dz0 e3) {
            throw new ty0("Failed to encode the image to JPEG.", e3);
        }
    }

    public static et4 y(Callable callable) {
        iw2 iw2Var = new iw2();
        aa4.a.execute(new or0(12, callable, iw2Var));
        return iw2Var.a;
    }

    @Override // defpackage.md3
    public float b() {
        Float f2 = (Float) ((ys) this.b).a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f2 != null && f2.floatValue() >= 1.0f) {
            return f2.floatValue();
        }
        return 1.0f;
    }

    @Override // defpackage.ir0
    public /* bridge */ /* synthetic */ void c(Object obj) {
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        switch (this.a) {
            case 21:
                jr0 jr0Var = (jr0) this.b;
                hh1.e("The result can only set once!", jr0Var.b == null);
                jr0Var.b = tpVar;
                return "FutureChain[" + jr0Var + "]";
            default:
                uc1 uc1Var = (uc1) this.b;
                hh1.e("The result can only set once!", uc1Var.i == null);
                uc1Var.i = tpVar;
                return "ListFuture[" + this + "]";
        }
    }

    @Override // defpackage.md3
    public float f() {
        return 1.0f;
    }

    public void h(n71 n71Var) {
        if (!n71Var.H()) {
            z01.b("DepthSortedSet.add called on an unattached node");
        }
        ((ep2) this.b).add(n71Var);
    }

    @Override // defpackage.ir0
    public void i(Throwable th) {
        synchronized (((tw) this.b).a) {
            try {
                ((tw) this.b).d.q();
                int iX = cq.x(((tw) this.b).i);
                if ((iX == 3 || iX == 5 || iX == 6) && !(th instanceof CancellationException)) {
                    xq4.e("CaptureSession", "Opening session with fail ".concat(cq.z(((tw) this.b).i)), th);
                    ((tw) this.b).d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Object j(Object obj) throws Exception {
        wi wiVarV;
        li liVar = (li) obj;
        wi wiVar = liVar.a;
        try {
            int i = wiVar.c;
            Object obj2 = wiVar.a;
            if (i == 35) {
                wiVarV = v(liVar);
            } else {
                if (i != 256 && i != 4101) {
                    throw new IllegalArgumentException("Unexpected format: " + i);
                }
                wiVarV = u(liVar, i);
            }
            ((zy0) obj2).close();
            return wiVarV;
        } catch (Throwable th) {
            ((zy0) wiVar.a).close();
            throw th;
        }
    }

    public ew0 k() {
        return new ew0((String[]) ((ArrayList) this.b).toArray(new String[0]));
    }

    public void l() {
        ((et4) ((wj1) this.b).b).g(null);
    }

    public long m() {
        int i = sz.h;
        long j = ((Parcel) this.b).readLong();
        long j2 = 63 & j;
        return j2 < 16 ? j : (j & (-64)) | (j2 + 1);
    }

    public long n() {
        long j;
        Parcel parcel = (Parcel) this.b;
        byte b = parcel.readByte();
        if (b == 1) {
            j = 4294967296L;
        } else {
            j = b == 2 ? 8589934592L : 0L;
        }
        return c03.a(j, 0L) ? b03.c : nc4.d(parcel.readFloat(), j);
    }

    public b83 o(dy dyVar) {
        String canonicalName;
        String strA;
        p6 p6Var = (p6) this.b;
        Map map = dy.b;
        Class cls = dyVar.a;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            canonicalName = null;
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            canonicalName = (!componentType.isPrimitive() || (strA = th4.a(componentType.getName())) == null) ? null : strA.concat("Array");
            if (canonicalName == null) {
                canonicalName = "kotlin.Array";
            }
        } else {
            String strA2 = th4.a(cls.getName());
            canonicalName = strA2 == null ? cls.getCanonicalName() : strA2;
        }
        if (canonicalName != null) {
            return p6Var.n(dyVar, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        og.i("Local and anonymous classes can not be ViewModels");
        return null;
    }

    public ByteBuffer p() {
        return ((Image.Plane) this.b).getBuffer();
    }

    public int r() {
        return ((Image.Plane) this.b).getPixelStride();
    }

    public int s() {
        return ((Image.Plane) this.b).getRowStride();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0070 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    public int t(byte[] bArr) {
        int i;
        byte b;
        if (((LargeJpegImageQuirk) this.b) == null || !(("Samsung".equalsIgnoreCase(Build.BRAND) && LargeJpegImageQuirk.a.contains(Build.MODEL.toUpperCase(Locale.US))) || LargeJpegImageQuirk.b() || bArr.length > 10000000)) {
            return bArr.length;
        }
        int i2 = 2;
        while (i2 + 4 <= bArr.length && (b = bArr[i2]) == -1) {
            int i3 = i2 + 2;
            int i4 = ((bArr[i3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8) | (bArr[i2 + 3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
            if (b == -1 && bArr[i2 + 1] == -38) {
                while (true) {
                    i = i3 + 2;
                    if (i > bArr.length) {
                        break;
                    }
                    if (bArr[i3] != -1 || bArr[i3 + 1] != -39) {
                        i3++;
                    }
                    if (i != -1) {
                        return i;
                    }
                    return bArr.length;
                }
            }
            i2 += i4 + 2;
        }
        i = -1;
        if (i != -1) {
            return i;
        }
        return bArr.length;
    }

    public String toString() {
        switch (this.a) {
            case 16:
                return ((ep2) this.b).toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r1 != (-1)) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.wi u(defpackage.li r11, int r12) {
        /*
            r10 = this;
            wi r11 = r11.a
            java.lang.Object r10 = r10.b
            py0 r10 = (defpackage.py0) r10
            java.lang.Object r0 = r11.a
            zy0 r0 = (defpackage.zy0) r0
            java.lang.Object r10 = r10.b
            androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk r10 = (androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk) r10
            r1 = 0
            if (r10 != 0) goto L29
            uf1[] r10 = r0.g()
            r10 = r10[r1]
            java.nio.ByteBuffer r10 = r10.p()
            int r0 = r10.capacity()
            byte[] r0 = new byte[r0]
            r10.rewind()
            r10.get(r0)
        L27:
            r2 = r0
            goto L84
        L29:
            uf1[] r10 = r0.g()
            r10 = r10[r1]
            java.nio.ByteBuffer r10 = r10.p()
            int r0 = r10.capacity()
            byte[] r2 = new byte[r0]
            r10.rewind()
            r10.get(r2)
            r3 = 2
            r4 = r3
        L41:
            int r5 = r4 + 4
            r6 = -1
            if (r5 > r0) goto L68
            r5 = r2[r4]
            if (r5 == r6) goto L4b
            goto L68
        L4b:
            if (r5 != r6) goto L56
            int r5 = r4 + 1
            r5 = r2[r5]
            r6 = -38
            if (r5 != r6) goto L56
            goto L7b
        L56:
            int r5 = r4 + 2
            r5 = r2[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 8
            int r6 = r4 + 3
            r6 = r2[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r5 = r5 | r6
            int r5 = r5 + r3
            int r4 = r4 + r5
            goto L41
        L68:
            int r1 = r3 + 1
            if (r1 <= r0) goto L6e
            r1 = r6
            goto L79
        L6e:
            r4 = r2[r3]
            if (r4 != r6) goto L9a
            r4 = r2[r1]
            r5 = -40
            if (r4 != r5) goto L9a
            r1 = r3
        L79:
            if (r1 == r6) goto L84
        L7b:
            int r10 = r10.limit()
            byte[] r0 = java.util.Arrays.copyOfRange(r2, r1, r10)
            goto L27
        L84:
            xj0 r3 = r11.b
            java.util.Objects.requireNonNull(r3)
            android.util.Size r5 = r11.d
            android.graphics.Rect r6 = r11.e
            int r7 = r11.f
            android.graphics.Matrix r8 = r11.g
            ls r9 = r11.h
            wi r1 = new wi
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r1
        L9a:
            r4 = r12
            r3 = r1
            r12 = r4
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf1.u(li, int):wi");
    }

    public boolean w(n71 n71Var) {
        if (!n71Var.H()) {
            z01.b("DepthSortedSet.remove called on an unattached node");
        }
        return ((ep2) this.b).remove(n71Var);
    }

    public void x(String str) {
        ArrayList arrayList = (ArrayList) this.b;
        int i = 0;
        while (i < arrayList.size()) {
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }

    public void z(int i, Object obj, db2 db2Var) {
        kz kzVar = (kz) this.b;
        kzVar.B(i, 3);
        db2Var.e((j1) obj, kzVar.a);
        kzVar.B(i, 4);
    }

    @Override // defpackage.md3
    public void g() {
    }

    @Override // defpackage.md3
    public void a(TotalCaptureResult totalCaptureResult) {
    }

    @Override // defpackage.md3
    public void e(yr yrVar) {
    }

    public uf1(Looper looper) {
        this.a = 0;
        we3 we3Var = new we3(looper);
        Looper.getMainLooper();
        this.b = we3Var;
    }

    public /* synthetic */ uf1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public uf1(kz kzVar) {
        this.a = 12;
        x21.a(kzVar, "output");
        this.b = kzVar;
        kzVar.a = this;
    }

    public uf1(boolean z) {
        this.a = 5;
        this.b = new AtomicBoolean(z);
    }

    public uf1(cq0 cq0Var, int i) {
        this.a = i;
        switch (i) {
            case 23:
                this.b = new py0(cq0Var);
                break;
            default:
                AeFpsRangeLegacyQuirk aeFpsRangeLegacyQuirk = (AeFpsRangeLegacyQuirk) cq0Var.d(AeFpsRangeLegacyQuirk.class);
                if (aeFpsRangeLegacyQuirk == null) {
                    this.b = null;
                } else {
                    this.b = aeFpsRangeLegacyQuirk.a;
                }
                break;
        }
    }

    public uf1(g83 g83Var, e83 e83Var, b80 b80Var) {
        this.a = 1;
        g83Var.getClass();
        e83Var.getClass();
        b80Var.getClass();
        this.b = new p6(g83Var, e83Var, b80Var);
    }

    public uf1(String str) {
        this.a = 15;
        Parcel parcelObtain = Parcel.obtain();
        this.b = parcelObtain;
        byte[] bArrDecode = Base64.decode(str, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }
}
