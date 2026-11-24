package defpackage;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Size;
import android.view.Surface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class qq1 implements u63 {
    public int a;
    public int[] b;
    public final Object c;
    public final Object e;
    public Object f;
    public Object i;
    public Object j;
    public Object k;
    public Object n;
    public Object s;
    public Object t;
    public Object u;
    public Object v;

    public qq1(float f, float f2, float f3) {
        int i;
        this.a = 1353;
        this.c = new float[2706];
        this.b = new int[1353];
        this.e = new float[1353];
        this.f = new float[1353];
        this.i = new float[1353];
        this.j = new float[1353];
        this.k = new float[1353];
        this.n = new float[1353];
        this.s = new float[1353];
        this.t = new float[1353];
        this.u = new float[1353];
        this.v = new float[1353];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            float f4 = i2 / 32.0f;
            double d = 3.141592653589793d;
            float fSin = (float) Math.sin(((double) f4) * 3.141592653589793d);
            float f5 = f3 - f2;
            float fMin = Math.min(((0.021f * f4) + 0.009f) * f, ((0.022f * f4) + 0.01f) * f5) * fSin;
            int i4 = 0;
            while (true) {
                float f6 = i4 / 40.0f;
                ((float[]) this.e)[i3] = f6 * f;
                ((float[]) this.f)[i3] = (f4 * f5) + f2;
                float fSin2 = (i2 == 0 || i2 == 32 || i4 == 0 || i4 == 40) ? 0.0f : (float) Math.sin(((double) f6) * d);
                ((float[]) this.i)[i3] = fMin * fSin2;
                ((float[]) this.j)[i3] = 0.19f * fSin * fSin2;
                float f7 = (f6 * 1.7f) + (26.0f * f4);
                double d2 = f7;
                i = i2;
                ((float[]) this.k)[i3] = (float) Math.sin(d2);
                ((float[]) this.n)[i3] = (float) Math.cos(d2);
                double d3 = (2.0f * f7) + 0.8f;
                ((float[]) this.s)[i3] = (float) Math.sin(d3);
                ((float[]) this.t)[i3] = (float) Math.cos(d3);
                double d4 = (f7 * 3.0f) - 0.6f;
                ((float[]) this.u)[i3] = (float) Math.sin(d4);
                ((float[]) this.v)[i3] = (float) Math.cos(d4);
                i3++;
                if (i4 == 40) {
                    break;
                }
                i4++;
                i2 = i;
                d = 3.141592653589793d;
            }
            if (i == 32) {
                return;
            } else {
                i2 = i + 1;
            }
        }
    }

    public void b(ig0 ig0Var, p6 p6Var) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.i = eGLDisplayEglGetDisplay;
        if (Objects.equals(eGLDisplayEglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            og.n("Unable to get EGL14 display");
            return;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize((EGLDisplay) this.i, iArr, 0, iArr, 1)) {
            this.i = EGL14.EGL_NO_DISPLAY;
            og.n("Unable to initialize EGL14");
            return;
        }
        if (p6Var != null) {
            p6Var.b = iArr[0] + "." + iArr[1];
        }
        int i = ig0Var.a() ? 10 : 8;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig((EGLDisplay) this.i, new int[]{12324, i, 12323, i, 12322, i, 12321, ig0Var.a() ? 2 : 8, 12325, 0, 12326, 0, 12352, ig0Var.a() ? 64 : 4, 12610, ig0Var.a() ? -1 : 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            og.n("Unable to find a suitable EGLConfig");
            return;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext((EGLDisplay) this.i, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, ig0Var.a() ? 3 : 2, 12344}, 0);
        ur0.a("eglCreateContext");
        this.k = eGLConfig;
        this.j = eGLContextEglCreateContext;
        EGL14.eglQueryContext((EGLDisplay) this.i, eGLContextEglCreateContext, 12440, new int[1], 0);
    }

    public vi c(Surface surface) {
        try {
            try {
                EGLDisplay eGLDisplay = (EGLDisplay) this.i;
                EGLConfig eGLConfig = (EGLConfig) this.k;
                Objects.requireNonNull(eGLConfig);
                EGLSurface eGLSurfaceI = ur0.i(eGLDisplay, eGLConfig, surface, this.b);
                EGLDisplay eGLDisplay2 = (EGLDisplay) this.i;
                int[] iArr = new int[1];
                EGL14.eglQuerySurface(eGLDisplay2, eGLSurfaceI, 12375, iArr, 0);
                int i = iArr[0];
                int[] iArr2 = new int[1];
                EGL14.eglQuerySurface(eGLDisplay2, eGLSurfaceI, 12374, iArr2, 0);
                Size size = new Size(i, iArr2[0]);
                return new vi(eGLSurfaceI, size.getWidth(), size.getHeight());
            } catch (IllegalArgumentException | IllegalStateException e) {
                e = e;
                xq4.e("OpenGlRenderer", "Failed to create EGL surface: " + e.getMessage(), e);
                return null;
            }
        } catch (IllegalArgumentException e2) {
            e = e2;
            xq4.e("OpenGlRenderer", "Failed to create EGL surface: " + e.getMessage(), e);
            return null;
        }
    }

    public void d() {
        EGLDisplay eGLDisplay = (EGLDisplay) this.i;
        EGLConfig eGLConfig = (EGLConfig) this.k;
        Objects.requireNonNull(eGLConfig);
        int[] iArr = ur0.a;
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
        ur0.a("eglCreatePbufferSurface");
        if (eGLSurfaceEglCreatePbufferSurface != null) {
            this.n = eGLSurfaceEglCreatePbufferSurface;
        } else {
            og.n("surface was null");
        }
    }

    @Override // defpackage.u63
    public int e() {
        return 0;
    }

    @Override // defpackage.s63
    public vd f(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        long j2 = j / 1000000;
        int[] iArr = t63.a;
        long j3 = this.a;
        if (j2 < 0) {
            j2 = 0;
        }
        long j4 = j2 > j3 ? j3 : j2;
        if (j4 < 0) {
            return vdVar3;
        }
        n(vdVar, vdVar2, vdVar3);
        vd vdVar4 = (vd) this.k;
        vdVar4.getClass();
        int i = 0;
        if (((q82) this.v) != t63.c) {
            int i2 = (int) j4;
            float fJ = j(i(i2), i2, false);
            float[] fArr = (float[]) this.u;
            yf[][] yfVarArr = (yf[][]) ((q82) this.v).a;
            float f = yfVarArr[0][0].a;
            float f2 = yfVarArr[yfVarArr.length - 1][0].b;
            if (fJ < f) {
                fJ = f;
            }
            if (fJ <= f2) {
                f2 = fJ;
            }
            int length = fArr.length;
            boolean z = false;
            for (yf[] yfVarArr2 : yfVarArr) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < length - 1) {
                    yf yfVar = yfVarArr2[i4];
                    if (f2 <= yfVar.b) {
                        if (yfVar.p) {
                            fArr[i3] = yfVar.q;
                            fArr[i3 + 1] = yfVar.r;
                        } else {
                            yfVar.c(f2);
                            fArr[i3] = yfVar.a();
                            fArr[i3 + 1] = yfVar.b();
                        }
                        z = true;
                    }
                    i3 += 2;
                    i4++;
                }
                if (z) {
                    break;
                }
            }
            int length2 = fArr.length;
            while (i < length2) {
                vdVar4.e(fArr[i], i);
                i++;
            }
        } else {
            vd vdVarH = h((j4 - 1) * 1000000, vdVar, vdVar2, vdVar3);
            vd vdVarH2 = h(j4 * 1000000, vdVar, vdVar2, vdVar3);
            int iB = vdVarH.b();
            while (i < iB) {
                vdVar4.e((vdVarH.a(i) - vdVarH2.a(i)) * 1000.0f, i);
                i++;
            }
        }
        return vdVar4;
    }

    @Override // defpackage.u63
    public int g() {
        return this.a;
    }

    @Override // defpackage.s63
    public vd h(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        vd vdVar4;
        vd vdVar5;
        vd vdVar6 = vdVar;
        vd vdVar7 = vdVar2;
        ll1 ll1Var = (ll1) this.c;
        long j2 = j / 1000000;
        int[] iArr = t63.a;
        int i = this.a;
        long j3 = i;
        if (j2 < 0) {
            j2 = 0;
        }
        if (j2 <= j3) {
            j3 = j2;
        }
        int i2 = (int) j3;
        ml1 ml1Var = (ml1) this.e;
        w63 w63Var = (w63) ml1Var.b(i2);
        if (w63Var != null) {
            return w63Var.a;
        }
        if (i2 >= i) {
            return vdVar7;
        }
        if (i2 <= 0) {
            return vdVar6;
        }
        n(vdVar6, vdVar7, vdVar3);
        vd vdVar8 = (vd) this.j;
        vdVar8.getClass();
        int i3 = 0;
        if (((q82) this.v) != t63.c) {
            float fJ = j(i(i2), i2, false);
            float[] fArr = (float[]) this.t;
            yf[][] yfVarArr = (yf[][]) ((q82) this.v).a;
            int length = yfVarArr.length - 1;
            float f = yfVarArr[0][0].a;
            float f2 = yfVarArr[length][0].b;
            int length2 = fArr.length;
            if (fJ < f || fJ > f2) {
                if (fJ > f2) {
                    f = f2;
                } else {
                    length = 0;
                }
                float f3 = fJ - f;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length2 - 1) {
                    yf yfVar = yfVarArr[length][i5];
                    boolean z = yfVar.p;
                    float f4 = yfVar.r;
                    float f5 = yfVar.q;
                    if (z) {
                        float f6 = yfVar.a;
                        float f7 = yfVar.k;
                        float f8 = yfVar.c;
                        fArr[i4] = (f5 * f3) + ((yfVar.e - f8) * (f - f6) * f7) + f8;
                        float f9 = (f - f6) * f7;
                        float f10 = yfVar.d;
                        fArr[i4 + 1] = (f4 * f3) + ((yfVar.f - f10) * f9) + f10;
                    } else {
                        yfVar.c(f);
                        fArr[i4] = (yfVar.a() * f3) + (yfVar.n * yfVar.h) + f5;
                        fArr[i4 + 1] = (yfVar.b() * f3) + (yfVar.o * yfVar.i) + f4;
                    }
                    i4 += 2;
                    i5++;
                    yfVarArr = yfVarArr;
                }
            } else {
                int length3 = yfVarArr.length;
                int i6 = 0;
                boolean z2 = false;
                while (i6 < length3) {
                    int i7 = i3;
                    int i8 = i7;
                    while (i7 < length2 - 1) {
                        yf yfVar2 = yfVarArr[i6][i8];
                        if (fJ <= yfVar2.b) {
                            if (yfVar2.p) {
                                float f11 = yfVar2.a;
                                float f12 = yfVar2.k;
                                float f13 = yfVar2.c;
                                fArr[i7] = ((yfVar2.e - f13) * (fJ - f11) * f12) + f13;
                                float f14 = yfVar2.d;
                                fArr[i7 + 1] = ((yfVar2.f - f14) * (fJ - f11) * f12) + f14;
                            } else {
                                yfVar2.c(fJ);
                                fArr[i7] = (yfVar2.n * yfVar2.h) + yfVar2.q;
                                fArr[i7 + 1] = (yfVar2.o * yfVar2.i) + yfVar2.r;
                            }
                            z2 = true;
                        }
                        i7 += 2;
                        i8++;
                    }
                    if (z2) {
                        break;
                    }
                    i6++;
                    i3 = 0;
                }
            }
            int length4 = fArr.length;
            for (int i9 = 0; i9 < length4; i9++) {
                vdVar8.e(fArr[i9], i9);
            }
        } else {
            int i10 = i(i2);
            float fJ2 = j(i10, i2, true);
            w63 w63Var2 = (w63) ml1Var.b(ll1Var.c(i10));
            if (w63Var2 != null && (vdVar5 = w63Var2.a) != null) {
                vdVar6 = vdVar5;
            }
            w63 w63Var3 = (w63) ml1Var.b(ll1Var.c(i10 + 1));
            if (w63Var3 != null && (vdVar4 = w63Var3.a) != null) {
                vdVar7 = vdVar4;
            }
            int iB = vdVar8.b();
            for (int i11 = 0; i11 < iB; i11++) {
                vdVar8.e((vdVar7.a(i11) * fJ2) + ((1.0f - fJ2) * vdVar6.a(i11)), i11);
            }
        }
        return vdVar8;
    }

    public int i(int i) {
        int i2;
        ll1 ll1Var = (ll1) this.c;
        int i3 = ll1Var.b;
        int i4 = 0;
        if (i3 <= 0) {
            og.o("");
            return 0;
        }
        int i5 = i3 - 1;
        while (true) {
            if (i4 <= i5) {
                i2 = (i4 + i5) >>> 1;
                int i6 = ll1Var.a[i2];
                if (i6 >= i) {
                    if (i6 <= i) {
                        break;
                    }
                    i5 = i2 - 1;
                } else {
                    i4 = i2 + 1;
                }
            } else {
                i2 = -(i4 + 1);
                break;
            }
        }
        return i2 < -1 ? -(i2 + 2) : i2;
    }

    public float j(int i, int i2, boolean z) {
        tg0 tg0Var;
        float f;
        ll1 ll1Var = (ll1) this.c;
        if (i >= ll1Var.b - 1) {
            f = i2;
        } else {
            int iC = ll1Var.c(i);
            int iC2 = ll1Var.c(i + 1);
            if (i2 != iC) {
                int i3 = iC2 - iC;
                w63 w63Var = (w63) ((ml1) this.e).b(iC);
                if (w63Var == null || (tg0Var = w63Var.b) == null) {
                    tg0Var = (tg0) this.f;
                }
                float f2 = i3;
                float fB = tg0Var.b((i2 - iC) / f2);
                return z ? fB : ((f2 * fB) + iC) / 1000.0f;
            }
            f = iC;
        }
        return f / 1000.0f;
    }

    public xt1 l(ig0 ig0Var) {
        ur0.d((AtomicBoolean) this.c, false);
        try {
            b(ig0Var, null);
            d();
            o((EGLSurface) this.n);
            String strGlGetString = GLES20.glGetString(7939);
            String strEglQueryString = EGL14.eglQueryString((EGLDisplay) this.i, 12373);
            if (strGlGetString == null) {
                strGlGetString = "";
            }
            if (strEglQueryString == null) {
                strEglQueryString = "";
            }
            return new xt1(strGlGetString, strEglQueryString);
        } catch (IllegalStateException e) {
            xq4.e("OpenGlRenderer", "Failed to get GL or EGL extensions: " + e.getMessage(), e);
            return new xt1("", "");
        } finally {
            q();
        }
    }

    public ji m(ig0 ig0Var) {
        Map map = Collections.EMPTY_MAP;
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.c;
        ur0.d(atomicBoolean, false);
        p6 p6Var = new p6();
        p6Var.a = "0.0";
        p6Var.b = "0.0";
        p6Var.c = "";
        p6Var.e = "";
        try {
            if (ig0Var.a()) {
                xt1 xt1VarL = l(ig0Var);
                String str = (String) xt1VarL.a;
                String str2 = (String) xt1VarL.b;
                if (!str.contains("GL_EXT_YUV_target")) {
                    xq4.d("OpenGlRenderer", "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                    ig0Var = ig0.d;
                }
                this.b = ur0.f(str2, ig0Var);
                p6Var.c = str;
                p6Var.e = str2;
            }
            b(ig0Var, p6Var);
            d();
            o((EGLSurface) this.n);
            p6Var.a = ur0.j();
            this.t = ur0.g(ig0Var);
            int iH = ur0.h();
            this.a = iH;
            t(iH);
            this.f = Thread.currentThread();
            atomicBoolean.set(true);
            if ("".isEmpty()) {
                return new ji((String) p6Var.a, (String) p6Var.b, (String) p6Var.c, (String) p6Var.e);
            }
            og.n("Missing required properties:".concat(""));
            return null;
        } catch (IllegalArgumentException e) {
            e = e;
            q();
            throw e;
        } catch (IllegalStateException e2) {
            e = e2;
            q();
            throw e;
        }
    }

    public void n(vd vdVar, vd vdVar2, vd vdVar3) {
        float[] fArr;
        ml1 ml1Var = (ml1) this.e;
        ll1 ll1Var = (ll1) this.c;
        boolean z = ((q82) this.v) != t63.c;
        if (((vd) this.j) == null) {
            this.j = vdVar.c();
            this.k = vdVar3.c();
            int i = ll1Var.b;
            float[] fArr2 = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                fArr2[i2] = ll1Var.c(i2) / 1000.0f;
            }
            this.i = fArr2;
            int i3 = ll1Var.b;
            int[] iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                iArr[i4] = 0;
            }
            this.b = iArr;
        }
        if (z) {
            if (((q82) this.v) != t63.c && g31.a((vd) this.n, vdVar) && g31.a((vd) this.s, vdVar2)) {
                return;
            }
            this.n = vdVar;
            this.s = vdVar2;
            int iB = vdVar.b() + (vdVar.b() % 2);
            this.t = new float[iB];
            this.u = new float[iB];
            int i5 = ll1Var.b;
            float[][] fArr3 = new float[i5][];
            for (int i6 = 0; i6 < i5; i6++) {
                int iC = ll1Var.c(i6);
                w63 w63Var = (w63) ml1Var.b(iC);
                if (iC == 0 && w63Var == null) {
                    fArr = new float[iB];
                    for (int i7 = 0; i7 < iB; i7++) {
                        fArr[i7] = vdVar.a(i7);
                    }
                } else if (iC == this.a && w63Var == null) {
                    fArr = new float[iB];
                    for (int i8 = 0; i8 < iB; i8++) {
                        fArr[i8] = vdVar2.a(i8);
                    }
                } else {
                    w63Var.getClass();
                    vd vdVar4 = w63Var.a;
                    float[] fArr4 = new float[iB];
                    for (int i9 = 0; i9 < iB; i9++) {
                        fArr4[i9] = vdVar4.a(i9);
                    }
                    fArr = fArr4;
                }
                fArr3[i6] = fArr;
            }
            this.v = new q82(this.b, (float[]) this.i, fArr3);
        }
    }

    public void o(EGLSurface eGLSurface) {
        ((EGLDisplay) this.i).getClass();
        ((EGLContext) this.j).getClass();
        if (EGL14.eglMakeCurrent((EGLDisplay) this.i, eGLSurface, eGLSurface, (EGLContext) this.j)) {
            return;
        }
        og.n("eglMakeCurrent failed");
    }

    public void p(Surface surface) {
        ur0.d((AtomicBoolean) this.c, true);
        ur0.c((Thread) this.f);
        HashMap map = (HashMap) this.e;
        if (map.containsKey(surface)) {
            return;
        }
        map.put(surface, ur0.j);
    }

    public void q() {
        HashMap map = (HashMap) this.e;
        Iterator it = ((Map) this.t).values().iterator();
        while (it.hasNext()) {
            GLES20.glDeleteProgram(((sr0) it.next()).a);
        }
        this.t = Collections.EMPTY_MAP;
        this.u = null;
        if (!Objects.equals((EGLDisplay) this.i, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = (EGLDisplay) this.i;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            for (vi viVar : map.values()) {
                if (!Objects.equals(viVar.a, EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface((EGLDisplay) this.i, viVar.a)) {
                    try {
                        ur0.a("eglDestroySurface");
                    } catch (IllegalStateException e) {
                        xq4.b("GLUtils", e.toString(), e);
                    }
                }
            }
            map.clear();
            if (!Objects.equals((EGLSurface) this.n, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface((EGLDisplay) this.i, (EGLSurface) this.n);
                this.n = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals((EGLContext) this.j, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext((EGLDisplay) this.i, (EGLContext) this.j);
                this.j = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate((EGLDisplay) this.i);
            this.i = EGL14.EGL_NO_DISPLAY;
        }
        this.k = null;
        this.a = -1;
        this.v = rr0.a;
        this.s = null;
        this.f = null;
    }

    public void r(Surface surface, boolean z) {
        if (((Surface) this.s) == surface) {
            this.s = null;
            o((EGLSurface) this.n);
        }
        HashMap map = (HashMap) this.e;
        vi viVar = z ? (vi) map.remove(surface) : (vi) map.put(surface, ur0.j);
        if (viVar == null || viVar == ur0.j) {
            return;
        }
        try {
            EGL14.eglDestroySurface((EGLDisplay) this.i, viVar.a);
        } catch (RuntimeException e) {
            xq4.e("OpenGlRenderer", "Failed to destroy EGL surface: " + e.getMessage(), e);
        }
    }

    public void s(long j, float[] fArr, Surface surface) {
        ur0.d((AtomicBoolean) this.c, true);
        ur0.c((Thread) this.f);
        HashMap map = (HashMap) this.e;
        hh1.e("The surface is not registered.", map.containsKey(surface));
        vi viVarC = (vi) map.get(surface);
        Objects.requireNonNull(viVarC);
        if (viVarC == ur0.j) {
            viVarC = c(surface);
            if (viVarC == null) {
                return;
            } else {
                map.put(surface, viVarC);
            }
        }
        int i = viVarC.c;
        int i2 = viVarC.b;
        EGLSurface eGLSurface = viVarC.a;
        if (surface != ((Surface) this.s)) {
            o(eGLSurface);
            this.s = surface;
            GLES20.glViewport(0, 0, i2, i);
            GLES20.glScissor(0, 0, i2, i);
        }
        sr0 sr0Var = (sr0) this.u;
        sr0Var.getClass();
        if (sr0Var instanceof tr0) {
            GLES20.glUniformMatrix4fv(((tr0) sr0Var).f, 1, false, fArr, 0);
            ur0.b("glUniformMatrix4fv");
        }
        GLES20.glDrawArrays(5, 0, 4);
        ur0.b("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID((EGLDisplay) this.i, eGLSurface, j);
        if (EGL14.eglSwapBuffers((EGLDisplay) this.i, eGLSurface)) {
            return;
        }
        xq4.d("OpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        r(surface, false);
    }

    public void t(int i) {
        sr0 sr0Var = (sr0) ((Map) this.t).get((rr0) this.v);
        if (sr0Var == null) {
            dk0.x((rr0) this.v, "Unable to configure program for input format: ");
            return;
        }
        if (((sr0) this.u) != sr0Var) {
            this.u = sr0Var;
            sr0Var.b();
            Objects.toString((rr0) this.v);
            Objects.toString((sr0) this.u);
        }
        GLES20.glActiveTexture(33984);
        ur0.b("glActiveTexture");
        GLES20.glBindTexture(36197, i);
        ur0.b("glBindTexture");
    }

    public qq1() {
        this.c = new AtomicBoolean(false);
        this.e = new HashMap();
        this.i = EGL14.EGL_NO_DISPLAY;
        this.j = EGL14.EGL_NO_CONTEXT;
        this.b = ur0.a;
        this.n = EGL14.EGL_NO_SURFACE;
        this.t = Collections.EMPTY_MAP;
        this.u = null;
        this.v = rr0.a;
        this.a = -1;
    }

    public qq1(ll1 ll1Var, ml1 ml1Var, int i, tg0 tg0Var) {
        this.c = ll1Var;
        this.e = ml1Var;
        this.a = i;
        this.f = tg0Var;
        this.b = t63.a;
        float[] fArr = t63.b;
        this.i = fArr;
        this.t = fArr;
        this.u = fArr;
        this.v = t63.c;
    }
}
