package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageReader;
import android.util.Size;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nr4 implements zn, i70, dm, b23, ao1, wy, ks4, rg0 {
    public static nr4 b;
    public static final r8 c = new r8(1);
    public static final r8 e = new r8(2);
    public static final nr4 f = new nr4(2);
    public static final z61 i = z61.a;
    public static final kc0 j = new kc0(1.0f, 1.0f);
    public static final /* synthetic */ nr4 k = new nr4(3);
    public static final nr4 n = new nr4(4);
    public static final nr4 s = new nr4(5);
    public static final nr4 t = new nr4(6);
    public static final /* synthetic */ nr4 u = new nr4(7);
    public final /* synthetic */ int a;

    public nr4(ta taVar) {
        this.a = 19;
    }

    public static final xx g(nr4 nr4Var, String str) {
        xx xxVar = new xx(str);
        xx.d.put(str, xxVar);
        return xxVar;
    }

    public static oo l(String str) {
        if (str.length() % 2 != 0) {
            og.g("Unexpected hex string: ".concat(str));
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (e8.b(str.charAt(i3 + 1)) + (e8.b(str.charAt(i3)) << 4));
        }
        return new oo(bArr);
    }

    public static oo m(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(px.a);
        bytes.getClass();
        oo ooVar = new oo(bytes);
        ooVar.c = str;
        return ooVar;
    }

    public static oo o(byte[] bArr) {
        oo ooVar = oo.e;
        int length = bArr.length;
        sg.a(bArr.length, 0L, length);
        return new oo(qg.j(0, bArr, length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r7v0, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [dk1] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // defpackage.ao1
    public boolean a(dk1 dk1Var) {
        var pm1Var = 0;
        while (true) {
            int i2 = 0;
            if (dk1Var == 0) {
                return false;
            }
            if (dk1Var instanceof qy1) {
                if (((qy1) dk1Var).q0()) {
                    return true;
                }
            } else if ((dk1Var.c & 16) != 0 && (dk1Var instanceof zb0)) {
                dk1 dk1Var2 = ((zb0) dk1Var).H;
                pm1Var = pm1Var;
                dk1Var = dk1Var;
                while (dk1Var2 != null) {
                    if ((dk1Var2.c & 16) != 0) {
                        i2++;
                        pm1Var = pm1Var;
                        if (i2 == 1) {
                            dk1Var = dk1Var2;
                        } else {
                            if (pm1Var == 0) {
                                pm1Var = new pm1(new dk1[16]);
                            }
                            if (dk1Var != 0) {
                                pm1Var.b(dk1Var);
                                dk1Var = 0;
                            }
                            pm1Var.b(dk1Var2);
                        }
                    }
                    dk1Var2 = dk1Var2.i;
                    pm1Var = pm1Var;
                    dk1Var = dk1Var;
                }
                if (i2 == 1) {
                }
            }
            dk1Var = cm4.b(pm1Var);
        }
    }

    @Override // defpackage.b23
    public Object apply(Object obj) throws Throwable {
        Throwable th;
        m92 m92Var;
        Bitmap bitmapA;
        m92 m92Var2 = null;
        xj0 xj0Var = null;
        switch (this.a) {
            case 7:
                return (byte[]) obj;
            case 13:
                wi wiVar = (wi) obj;
                try {
                    try {
                        int i2 = wiVar.c;
                        Object obj2 = wiVar.a;
                        int i3 = wiVar.f;
                        if (i2 == 35) {
                            zy0 zy0Var = (zy0) obj2;
                            boolean z = i3 % 180 != 0;
                            m92Var = new m92(new s9(ImageReader.newInstance(z ? zy0Var.a() : zy0Var.b(), z ? zy0Var.b() : zy0Var.a(), 1, 2)));
                            try {
                                rk2 rk2VarC = ImageProcessingUtil.c(zy0Var, m92Var, ByteBuffer.allocateDirect(zy0Var.b() * zy0Var.a() * 4), i3);
                                zy0Var.close();
                                if (rk2VarC == null) {
                                    throw new ty0("Can't covert YUV to RGB", null);
                                }
                                bitmapA = so4.a(rk2VarC);
                                rk2VarC.close();
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                throw new ty0("Can't convert " + (wiVar.c == 35 ? "YUV" : "JPEG") + " to bitmap", e);
                            } catch (Throwable th2) {
                                th = th2;
                                m92Var2 = m92Var;
                                if (m92Var2 == null) {
                                    throw th;
                                }
                                m92Var2.close();
                                throw th;
                            }
                        } else {
                            if (i2 != 256) {
                                throw new IllegalArgumentException("Invalid postview image format : " + wiVar.c);
                            }
                            zy0 zy0Var2 = (zy0) obj2;
                            Bitmap bitmapA2 = so4.a(zy0Var2);
                            zy0Var2.close();
                            Matrix matrix = new Matrix();
                            matrix.postRotate(i3);
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapA2, 0, 0, bitmapA2.getWidth(), bitmapA2.getHeight(), matrix, true);
                            m92Var = null;
                            bitmapA = bitmapCreateBitmap;
                        }
                        if (m92Var != null) {
                            m92Var.close();
                        }
                        return bitmapA;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (UnsupportedOperationException e3) {
                    e = e3;
                }
                break;
            default:
                zi ziVar = (zi) obj;
                zy0 zy0Var3 = ziVar.b;
                g12 g12Var = ziVar.a;
                if (so4.b(zy0Var3.getFormat())) {
                    try {
                        oc ocVar = xj0.b;
                        ByteBuffer byteBufferP = zy0Var3.g()[0].p();
                        byteBufferP.rewind();
                        byte[] bArr = new byte[byteBufferP.capacity()];
                        byteBufferP.get(bArr);
                        xj0Var = new xj0(new jk0(new ByteArrayInputStream(bArr)));
                        zy0Var3.g()[0].p().rewind();
                    } catch (IOException e4) {
                        throw new ty0("Failed to extract EXIF data.", e4);
                    }
                    break;
                }
                xj0 xj0Var2 = xj0Var;
                int i4 = 10;
                if (((ImageCaptureRotationOptionQuirk) uc0.a.d(ImageCaptureRotationOptionQuirk.class)) != null) {
                    bi biVar = lw.i;
                } else if (so4.b(zy0Var3.getFormat())) {
                    hh1.d(xj0Var2, "JPEG image must have exif.");
                    Size size = new Size(zy0Var3.b(), zy0Var3.a());
                    int iA = g12Var.d - xj0Var2.a();
                    Size size2 = z13.c(z13.g(iA)) ? new Size(size.getHeight(), size.getWidth()) : size;
                    Matrix matrixA = z13.a(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), new RectF(0.0f, 0.0f, size2.getWidth(), size2.getHeight()), iA, false);
                    RectF rectF = new RectF(g12Var.c);
                    matrixA.mapRect(rectF);
                    rectF.sort();
                    Rect rect = new Rect();
                    rectF.round(rect);
                    int iA2 = xj0Var2.a();
                    Matrix matrix2 = new Matrix(g12Var.f);
                    matrix2.postConcat(matrixA);
                    ls y74Var = zy0Var3.m() instanceof ms ? ((ms) zy0Var3.m()).a : new y74(i4);
                    zy0Var3.getFormat();
                    return new wi(zy0Var3, xj0Var2, zy0Var3.getFormat(), size2, rect, iA2, matrix2, y74Var);
                }
                Rect rect2 = g12Var.c;
                int i5 = g12Var.d;
                Matrix matrix3 = g12Var.f;
                ls y74Var2 = zy0Var3.m() instanceof ms ? ((ms) zy0Var3.m()).a : new y74(i4);
                Size size3 = new Size(zy0Var3.b(), zy0Var3.a());
                if (so4.b(zy0Var3.getFormat())) {
                    hh1.d(xj0Var2, "JPEG image must have Exif.");
                }
                return new wi(zy0Var3, xj0Var2, zy0Var3.getFormat(), size3, rect2, i5, matrix3, y74Var2);
        }
    }

    @Override // defpackage.zn
    public jc0 b() {
        return j;
    }

    @Override // defpackage.zn
    public long c() {
        return 9205357640488583168L;
    }

    @Override // defpackage.ao1
    public int d() {
        return 16;
    }

    @Override // defpackage.rg0
    public qg0 e(Context context, String str, pg0 pg0Var) {
        qg0 qg0Var = new qg0();
        int iQ = pg0Var.q(context, str, true);
        qg0Var.b = iQ;
        if (iQ != 0) {
            qg0Var.c = 1;
            return qg0Var;
        }
        int iL = pg0Var.l(context, str);
        qg0Var.a = iL;
        if (iL != 0) {
            qg0Var.c = -1;
        }
        return qg0Var;
    }

    public boolean equals(Object obj) {
        switch (this.a) {
            case 17:
                return (obj instanceof x52) || obj == this;
            default:
                return super.equals(obj);
        }
    }

    @Override // defpackage.ks4
    public Object f(Object obj) {
        switch (this.a) {
            case 22:
                ct4 ct4Var = (ct4) obj;
                return new qw2(ct4Var.a, ct4Var.b, ct4Var.c, "", null);
            default:
                rp4 rp4Var = (rp4) obj;
                v54 v54Var = rp4Var.b;
                String str = rp4Var.i;
                List listC = bh4.c(v54Var);
                String str2 = rp4Var.e;
                if (hi4.c(str2)) {
                    str2 = "";
                }
                String str3 = str2;
                Rect rectB = bh4.b(listC);
                if (hi4.c(str)) {
                    str = "und";
                }
                float f2 = rp4Var.b.f;
                jz3 jz3Var = nz3.f;
                q04 q04Var = q04.k;
                return new qw2(str3, rectB, listC, str, null);
        }
    }

    @Override // defpackage.zn
    public z61 getLayoutDirection() {
        return i;
    }

    @Override // defpackage.wy
    public long h() {
        return System.currentTimeMillis();
    }

    public int hashCode() {
        switch (this.a) {
            case 17:
                return u42.a(x52.class).hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override // defpackage.ao1
    public void i(n71 n71Var, long j2, pw0 pw0Var, int i2, boolean z) {
        n71Var.A(j2, pw0Var, i2, z);
    }

    @Override // defpackage.ao1
    public boolean j(n71 n71Var) {
        return true;
    }

    @Override // defpackage.dm
    public long k(iz izVar, int i2) {
        String str = ((gz2) izVar.e).a.a.b;
        return hc4.a(pa4.b(str, i2), pa4.a(str, i2));
    }

    public synchronized xx n(String str) {
        xx xxVar;
        String strConcat;
        try {
            str.getClass();
            LinkedHashMap linkedHashMap = xx.d;
            xxVar = (xx) linkedHashMap.get(str);
            if (xxVar == null) {
                if (js2.k(str, "TLS_", false)) {
                    strConcat = "SSL_".concat(str.substring(4));
                } else {
                    strConcat = js2.k(str, "SSL_", false) ? "TLS_".concat(str.substring(4)) : str;
                }
                xxVar = (xx) linkedHashMap.get(strConcat);
                if (xxVar == null) {
                    xxVar = new xx(str);
                }
                linkedHashMap.put(str, xxVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return xxVar;
    }

    public /* synthetic */ nr4(int i2) {
        this.a = i2;
    }
}
