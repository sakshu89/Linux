package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.os.Parcel;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.Log;
import com.google.android.gms.common.internal.a;
import com.ibm.icu.text.BreakIterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class q82 implements qk, x22, az1, wz, dp1, ch {
    public static q82 b;
    public static final r82 c = new r82(0, 0, 0, false, false);
    public static final vt0 e = new vt0(1);
    public static final xy f = new xy(22);
    public Object a;

    /* JADX WARN: Code duplicated, block: B:14:0x0024 A[PHI: r9
      0x0024: PHI (r9v1 int) = (r9v0 int), (r9v3 int), (r9v4 int) binds: [B:5:0x0014, B:10:0x001d, B:12:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:19:0x002d  */
    public q82(int[] iArr, float[] fArr, float[][] fArr2) {
        int i;
        int length = fArr.length - 1;
        yf[][] yfVarArr = new yf[length][];
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (i4 < length) {
            int i5 = iArr[i4];
            int i6 = 3;
            if (i5 == 0) {
                i = i6;
            } else if (i5 == 1) {
                i2 = 1;
                i = i2;
            } else {
                if (i5 != 2) {
                    if (i5 != 3) {
                        i6 = 4;
                        if (i5 != 4) {
                            i6 = 5;
                            if (i5 != 5) {
                                i = i3;
                            } else {
                                i = i6;
                            }
                        } else {
                            i = i6;
                        }
                    } else {
                        if (i2 != 1) {
                            i2 = 1;
                        }
                        i = i2;
                    }
                }
                i2 = 2;
                i = i2;
            }
            float[] fArr3 = fArr2[i4];
            int i7 = i4 + 1;
            float[] fArr4 = fArr2[i7];
            float f2 = fArr[i4];
            float f3 = fArr[i7];
            int length2 = (fArr3.length % 2) + (fArr3.length / 2);
            yf[] yfVarArr2 = new yf[length2];
            int i8 = 0;
            while (i8 < length2) {
                int i9 = i8 * 2;
                yf[] yfVarArr3 = yfVarArr2;
                int i10 = i8;
                int i11 = i9 + 1;
                yfVarArr3[i10] = new yf(i, f2, f3, fArr3[i9], fArr3[i11], fArr4[i9], fArr4[i11]);
                i8 = i10 + 1;
                yfVarArr2 = yfVarArr3;
            }
            yfVarArr[i4] = yfVarArr2;
            i4 = i7;
            i3 = i;
        }
        this.a = yfVarArr;
    }

    public static q82 A(ys ysVar) {
        DynamicRangeProfiles dynamicRangeProfilesG;
        int i = Build.VERSION.SDK_INT;
        q82 q82Var = null;
        if (i >= 33 && (dynamicRangeProfilesG = c3.g(ysVar.a(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES))) != null) {
            hh1.e("DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.", i >= 33);
            q82Var = new q82(new lg0(dynamicRangeProfilesG));
        }
        return q82Var == null ? mg0.a : q82Var;
    }

    public static synchronized q82 D() {
        try {
            if (b == null) {
                b = new q82();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public fr2 B() {
        return (fr2) ((jr2) this.a).getValue();
    }

    public gr2 C() {
        oh0 oh0VarA = oh0.a();
        if (oh0VarA.c() == 1) {
            return new oz0(true);
        }
        ku1 ku1VarG = o44.g(Boolean.FALSE);
        oh0VarA.h(new oa0(ku1VarG, this));
        return ku1VarG;
    }

    public KeyListener E(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((l11) ((q82) this.a).a).getClass();
        if (keyListener instanceof vh0) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new vh0(keyListener);
    }

    public void F(float f2, float f3, float f4, float f5) {
        kf kfVar = (kf) this.a;
        cw cwVarM = kfVar.m();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (kfVar.r() >> 32)) - (f4 + f2);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (kfVar.r() & 4294967295L)) - (f5 + f3))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        if (Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) < 0.0f || Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) < 0.0f) {
            y01.a("Width and height must be greater than or equal to zero");
        }
        kfVar.G(jFloatToRawIntBits);
        cwVarM.g(f2, f3);
    }

    public void G(float f2, long j) {
        cw cwVarM = ((kf) this.a).m();
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        cwVarM.g(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
        cwVarM.c(f2);
        cwVarM.g(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
    }

    public void H(float f2, float f3, long j) {
        cw cwVarM = ((kf) this.a).m();
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        cwVarM.g(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
        cwVarM.b(f2, f3);
        cwVarM.g(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
    }

    public void I(boolean z) {
        ci0 ci0Var = (ci0) ((l11) ((q82) this.a).a).c;
        if (ci0Var.c != z) {
            if (ci0Var.b != null) {
                oh0 oh0VarA = oh0.a();
                bi0 bi0Var = ci0Var.b;
                oh0VarA.getClass();
                hh1.d(bi0Var, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = oh0VarA.a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    oh0VarA.b.remove(bi0Var);
                    reentrantReadWriteLock.writeLock().unlock();
                } catch (Throwable th) {
                    reentrantReadWriteLock.writeLock().unlock();
                    throw th;
                }
            }
            ci0Var.c = z;
            if (z) {
                ci0.a(ci0Var.a, oh0.a().c());
            }
        }
    }

    public void J(float f2, float f3) {
        ((kf) this.a).m().g(f2, f3);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    public void K(fr2 fr2Var) {
        Object value;
        fr2 fr2Var2;
        fr2Var.getClass();
        jr2 jr2Var = (jr2) this.a;
        do {
            value = jr2Var.getValue();
            fr2Var2 = (fr2) value;
            if (fr2Var2 instanceof w22 ? true : g31.a(fr2Var2, i43.b)) {
                fr2Var2 = fr2Var;
            } else if (fr2Var2 instanceof y80) {
                if (fr2Var.a > fr2Var2.a) {
                    fr2Var2 = fr2Var;
                }
            } else if (!(fr2Var2 instanceof wl0)) {
                dk0.l();
                return;
            }
        } while (!jr2Var.h(value, fr2Var2));
    }

    public void L() {
        ry0 ry0Var = (ry0) this.a;
        synchronized (ry0Var.p) {
            try {
                Integer num = (Integer) ry0Var.p.getAndSet(null);
                if (num == null) {
                    return;
                }
                if (num.intValue() != ry0Var.C()) {
                    ry0Var.F();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ch
    /* JADX INFO: renamed from: apply */
    public wc1 mo28apply(Object obj) {
        return oz3.d(((dr0) this.a).apply(obj));
    }

    @Override // defpackage.wz
    public long l() {
        cc0 cc0Var = (cc0) this.a;
        long jL = cc0Var.c0.l();
        if (jL != 16) {
            return jL;
        }
        f82 f82Var = (f82) ij4.a(cc0Var, i82.a);
        if (f82Var != null) {
            long j = f82Var.a;
            if (j != 16) {
                return j;
            }
        }
        return ((sz) ij4.a(cc0Var, g50.a)).a;
    }

    @Override // defpackage.az1
    public long m(i21 i21Var, long j, z61 z61Var, long j2) {
        long j3 = ((e21) ((fq0) this.a).a()).a;
        int iA = bl4.a(i21Var.a + ((int) (j3 >> 32)), (int) (j2 >> 32), (int) (j >> 32), z61Var == z61.a);
        return (((long) bl4.a(i21Var.b + ((int) (j3 & 4294967295L)), (int) (j2 & 4294967295L), (int) (j & 4294967295L), true)) & 4294967295L) | (((long) iA) << 32);
    }

    @Override // defpackage.x22
    public s30 n() {
        return (s30) this.a;
    }

    @Override // defpackage.qk
    public void o(x30 x30Var) {
        boolean z = x30Var.b == 0;
        a aVar = (a) this.a;
        if (z) {
            aVar.k(null, aVar.w);
            return;
        }
        wj1 wj1Var = aVar.o;
        if (wj1Var != null) {
            ((pu0) wj1Var.b).b(x30Var);
        }
    }

    @Override // defpackage.dp1
    public void u(Object obj) {
        ob1 ob1Var = (ob1) obj;
        cd0 cd0Var = (cd0) this.a;
        if (ob1Var == null || !cd0Var.t) {
            return;
        }
        throw new IllegalStateException("Fragment " + cd0Var + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public gu v(kf kfVar) throws IOException {
        vw vwVar = (vw) this.a;
        URL url = (URL) kfVar.b;
        yq4.a("CctTransportBackend");
        new StringBuilder("Making request to: ").append(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(vwVar.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/2.3.3 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) kfVar.e;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    uf1 uf1Var = vwVar.a;
                    th thVar = (th) kfVar.c;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    u41 u41Var = (u41) uf1Var.b;
                    v41 v41Var = new v41(bufferedWriter, u41Var.a, u41Var.b, u41Var.c, u41Var.e);
                    v41Var.e(thVar);
                    v41Var.g();
                    v41Var.b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    yq4.a("CctTransportBackend");
                    httpURLConnection.getHeaderField("Content-Type");
                    yq4.a("CctTransportBackend");
                    httpURLConnection.getHeaderField("Content-Encoding");
                    yq4.a("CctTransportBackend");
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new gu(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new gu(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            gu guVar = new gu(responseCode, null, si.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return guVar;
                        } catch (Throwable th) {
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (ConnectException e2) {
            e = e2;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new gu(BreakIterator.WORD_IDEO_LIMIT, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new gu(BreakIterator.WORD_IDEO_LIMIT, null, 0L);
        } catch (IOException e4) {
            e = e4;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new gu(400, null, 0L);
        } catch (ri0 e5) {
            e = e5;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new gu(400, null, 0L);
        }
    }

    public void w() {
        ((a30) this.a).getClass();
    }

    public void x(byte b2) {
        ((Parcel) this.a).writeByte(b2);
    }

    public void y(float f2) {
        ((Parcel) this.a).writeFloat(f2);
    }

    public void z(long j) {
        long jB = b03.b(j);
        byte b2 = 0;
        if (!c03.a(jB, 0L)) {
            if (c03.a(jB, 4294967296L)) {
                b2 = 1;
            } else if (c03.a(jB, 8589934592L)) {
                b2 = 2;
            }
        }
        x(b2);
        if (c03.a(b03.b(j), 0L)) {
            return;
        }
        y(b03.c(j));
    }

    public /* synthetic */ q82(Object obj) {
        this.a = obj;
    }

    public q82(ve veVar, int i) {
        switch (i) {
            case 24:
                this.a = new l11(veVar);
                break;
            default:
                this.a = new q82(veVar, 24);
                break;
        }
    }

    public q82(int i) {
        pi1 pi1Var;
        switch (i) {
            case 2:
                bv3 bv3Var = bv3.c;
                wj1 wj1Var = new wj1(24, new wu3[]{su0.n, f});
                Charset charset = nu3.a;
                this.a = wj1Var;
                break;
            case 6:
                this.a = new AtomicInteger(0);
                break;
            case 18:
                this.a = o54.a(i43.b);
                break;
            default:
                w12 w12Var = w12.c;
                try {
                    pi1Var = (pi1) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
                } catch (Exception unused) {
                    pi1Var = e;
                }
                pi1[] pi1VarArr = {vt0.b, pi1Var};
                ng1 ng1Var = new ng1();
                ng1Var.a = pi1VarArr;
                Charset charset2 = x21.a;
                this.a = ng1Var;
                break;
        }
    }
}
