package defpackage;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Range;
import android.util.Size;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kq implements gt {
    public final iq b;
    public final ch2 c;
    public final Object d = new Object();
    public final ys e;
    public final uf1 f;
    public final gh2 g;
    public final zn0 h;
    public final k02 i;
    public final a22 j;
    public final jb k;
    public final od3 l;
    public final bq m;
    public final ur n;
    public final wj1 o;
    public int p;
    public qy0 q;
    public volatile boolean r;
    public volatile int s;
    public final uf1 t;
    public final ph u;
    public final AtomicLong v;
    public volatile wc1 w;
    public int x;
    public long y;
    public final hq z;

    public kq(ys ysVar, xv0 xv0Var, ch2 ch2Var, uf1 uf1Var, cq0 cq0Var) {
        gh2 gh2Var = new gh2();
        this.g = gh2Var;
        this.p = 0;
        this.r = false;
        this.s = 2;
        this.v = new AtomicLong(0L);
        this.w = mz0.c;
        this.x = 1;
        this.y = 0L;
        hq hqVar = new hq();
        hqVar.b = new HashSet();
        hqVar.c = new ArrayMap();
        this.z = hqVar;
        this.e = ysVar;
        this.f = uf1Var;
        this.c = ch2Var;
        this.o = new wj1(ch2Var);
        iq iqVar = new iq(ch2Var);
        this.b = iqVar;
        gh2Var.b.a = this.x;
        gh2Var.b.b(new kw(iqVar));
        gh2Var.b.b(hqVar);
        jb jbVar = new jb();
        jbVar.a = false;
        c4 c4Var = new c4();
        c4Var.a = new Object();
        jbVar.b = c4Var;
        this.k = jbVar;
        this.h = new zn0(this, ch2Var);
        this.i = new k02(this, ysVar);
        this.j = new a22(this, ysVar);
        this.l = new od3(ysVar);
        this.t = new uf1(cq0Var, 3);
        this.u = new ph(cq0Var, 0);
        this.m = new bq(this, ch2Var);
        this.n = new ur(this, ysVar, cq0Var, ch2Var, xv0Var);
    }

    public static int n(ys ysVar, int i) {
        int[] iArr = (int[]) ysVar.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (p(i, iArr)) {
            return i;
        }
        return p(1, iArr) ? 1 : 0;
    }

    public static boolean p(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean q(TotalCaptureResult totalCaptureResult, long j) {
        Long l;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        return (tag instanceof iv2) && (l = (Long) ((iv2) tag).a.get("CameraControlSessionUpdateId")) != null && l.longValue() >= j;
    }

    @Override // defpackage.gt
    public final wc1 a(final int i, final int i2) {
        if (o()) {
            final int i3 = this.s;
            return oz3.g(jr0.b(oz3.e(this.w)), new ch() { // from class: fq
                @Override // defpackage.ch
                /* JADX INFO: renamed from: apply */
                public final wc1 mo28apply(Object obj) {
                    ur urVar = this.a.n;
                    int i4 = i;
                    int i5 = i3;
                    return oz3.d(new hr(urVar.e(i4, i5, i2), (ch2) urVar.g, i5));
                }
            }, this.c);
        }
        xq4.d("Camera2CameraControlImp", "Camera is not active.");
        return new mz0(1, new dt("Camera is not active."));
    }

    @Override // defpackage.gt
    public final s30 b() {
        zr zrVar;
        bq bqVar = this.m;
        synchronized (bqVar.e) {
            yr yrVar = bqVar.f;
            yrVar.getClass();
            zrVar = new zr(gs1.l(yrVar.b));
        }
        return zrVar;
    }

    @Override // defpackage.gt
    public final void c(s30 s30Var) {
        bq bqVar = this.m;
        q82 q82VarD = yr.e(s30Var).d();
        synchronized (bqVar.e) {
            yr yrVar = bqVar.f;
            yrVar.getClass();
            r30 r30Var = r30.c;
            for (bi biVar : q82VarD.e()) {
                yrVar.b.u(biVar, r30Var, q82VarD.f(biVar));
            }
        }
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        int i = 1;
        try {
            bqVar.d.execute(new zp(bqVar, tpVar, i));
            tpVar.a = "addCaptureRequestOptions";
        } catch (Exception e) {
            wpVar.b(e);
        }
        oz3.e(wpVar).a(new c7(i), xg4.a());
    }

    @Override // defpackage.gt
    public final void d() {
        int i;
        bq bqVar = this.m;
        synchronized (bqVar.e) {
            i = 0;
            bqVar.f = new yr(0);
        }
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            bqVar.d.execute(new zp(bqVar, tpVar, i));
            tpVar.a = "clearCaptureRequestOptions";
        } catch (Exception e) {
            wpVar.b(e);
        }
        oz3.e(wpVar).a(new c7(1), xg4.a());
    }

    @Override // defpackage.gt
    public final Rect e() {
        Rect rect = (Rect) this.e.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if ("robolectric".equals(Build.FINGERPRINT) && rect == null) {
            return new Rect(0, 0, 4000, 3000);
        }
        rect.getClass();
        return rect;
    }

    @Override // defpackage.gt
    public final void f(int i) {
        if (!o()) {
            xq4.d("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.s = i;
        xq4.c(3, "Camera2CameraControlImp");
        od3 od3Var = this.l;
        boolean z = true;
        if (this.s != 1 && this.s != 0) {
            z = false;
        }
        od3Var.d = z;
        this.w = t();
    }

    @Override // defpackage.gt
    public final void g(qy0 qy0Var) {
        this.q = qy0Var;
    }

    @Override // defpackage.gt
    public final wc1 h(final ArrayList arrayList, final int i, final int i2) {
        if (o()) {
            final int i3 = this.s;
            return oz3.g(jr0.b(oz3.e(this.w)), new ch() { // from class: eq
                @Override // defpackage.ch
                /* JADX INFO: renamed from: apply */
                public final wc1 mo28apply(Object obj) {
                    ur urVar = this.a.n;
                    int i4 = i;
                    final int i5 = i3;
                    final mr mrVarE = urVar.e(i4, i5, i2);
                    jr0 jr0VarB = jr0.b(mrVarE.a(i5));
                    final ArrayList arrayList2 = arrayList;
                    ch chVar = new ch() { // from class: jr
                        /* JADX WARN: Code duplicated, block: B:23:0x0083  */
                        @Override // defpackage.ch
                        /* JADX INFO: renamed from: apply */
                        public final wc1 mo28apply(Object obj2) {
                            ls lsVar;
                            int i6;
                            zy0 zy0Var;
                            mr mrVar = mrVarE;
                            kq kqVar = mrVar.d;
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = arrayList2;
                            int size = arrayList5.size();
                            int i7 = 0;
                            while (i7 < size) {
                                int i8 = i7 + 1;
                                lw lwVar = (lw) arrayList5.get(i7);
                                ur urVar2 = new ur(lwVar);
                                int i9 = lwVar.c;
                                if (i9 == 5) {
                                    od3 od3Var = kqVar.l;
                                    if (od3Var.d || od3Var.c) {
                                        lsVar = null;
                                    } else {
                                        try {
                                            zy0Var = (zy0) od3Var.b.b();
                                        } catch (NoSuchElementException unused) {
                                            xq4.a("ZslControlImpl", "dequeueImageFromBuffer no such element");
                                            zy0Var = null;
                                        }
                                        if (zy0Var != null) {
                                            od3 od3Var2 = kqVar.l;
                                            od3Var2.getClass();
                                            Image imageT = zy0Var.t();
                                            ImageWriter imageWriter = od3Var2.j;
                                            if (imageWriter == null || imageT == null) {
                                                lsVar = null;
                                            } else {
                                                try {
                                                    imageWriter.queueInputImage(imageT);
                                                    vy0 vy0VarM = zy0Var.m();
                                                    if (vy0VarM instanceof ms) {
                                                        lsVar = ((ms) vy0VarM).a;
                                                    } else {
                                                        lsVar = null;
                                                    }
                                                } catch (IllegalStateException e) {
                                                    xq4.a("ZslControlImpl", "enqueueImageToImageWriter throws IllegalStateException = " + e.getMessage());
                                                }
                                            }
                                        } else {
                                            lsVar = null;
                                        }
                                    }
                                } else {
                                    lsVar = null;
                                }
                                if (lsVar != null) {
                                    urVar2.h = lsVar;
                                } else {
                                    if (mrVar.a != 3 || mrVar.f) {
                                        i6 = (i9 == -1 || i9 == 5) ? 2 : -1;
                                    } else {
                                        i6 = 4;
                                    }
                                    if (i6 != -1) {
                                        urVar2.a = i6;
                                    }
                                }
                                ph phVar = mrVar.e;
                                if (phVar.b && i5 == 0 && phVar.a) {
                                    zl1 zl1VarM = zl1.m();
                                    zl1VarM.v(zr.M(CaptureRequest.CONTROL_AE_MODE), 3);
                                    urVar2.c(new zr(gs1.l(zl1VarM)));
                                }
                                tp tpVar = new tp();
                                tpVar.c = new o62();
                                wp wpVar = new wp(tpVar);
                                tpVar.b = wpVar;
                                tpVar.a = cq.class;
                                try {
                                    try {
                                        urVar2.b(new lr(tpVar, 0));
                                        tpVar.a = "submitStillCapture";
                                    } catch (Exception e2) {
                                        e = e2;
                                        wpVar.b(e);
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                }
                                arrayList3.add(wpVar);
                                arrayList4.add(urVar2.d());
                                i7 = i8;
                            }
                            kqVar.s(arrayList4);
                            return new uc1(new ArrayList(arrayList3), true, xg4.a());
                        }
                    };
                    Executor executor = mrVarE.b;
                    xw xwVarG = oz3.g(jr0VarB, chVar, executor);
                    xwVarG.a(new s7(7, mrVarE), executor);
                    return oz3.e(xwVarG);
                }
            }, this.c);
        }
        xq4.d("Camera2CameraControlImp", "Camera is not active.");
        return new mz0(1, new dt("Camera is not active."));
    }

    @Override // defpackage.gt
    public final void i(gh2 gh2Var) throws Exception {
        boolean zIsEmpty;
        HashMap map;
        StreamConfigurationMap streamConfigurationMap;
        int[] validOutputFormatsForInput;
        od3 od3Var = this.l;
        b13 b13Var = od3Var.b;
        while (true) {
            synchronized (b13Var.b) {
                zIsEmpty = ((ArrayDeque) b13Var.a).isEmpty();
            }
            if (zIsEmpty) {
                break;
            } else {
                ((zy0) b13Var.b()).close();
            }
        }
        nz0 nz0Var = od3Var.i;
        StreamConfigurationMap streamConfigurationMap2 = null;
        if (nz0Var != null) {
            m92 m92Var = od3Var.g;
            if (m92Var != null) {
                oz3.e(nz0Var.e).a(new nw(m92Var, 2), xg4.c());
                od3Var.g = null;
            }
            nz0Var.a();
            od3Var.i = null;
        }
        ImageWriter imageWriter = od3Var.j;
        if (imageWriter != null) {
            imageWriter.close();
            od3Var.j = null;
        }
        if (od3Var.c) {
            gh2Var.b.a = 1;
            return;
        }
        if (od3Var.f) {
            gh2Var.b.a = 1;
            return;
        }
        try {
            streamConfigurationMap2 = (StreamConfigurationMap) od3Var.a.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (AssertionError e) {
            xq4.a("ZslControlImpl", "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
        }
        if (streamConfigurationMap2 == null || streamConfigurationMap2.getInputFormats() == null) {
            map = new HashMap();
        } else {
            map = new HashMap();
            for (int i : streamConfigurationMap2.getInputFormats()) {
                Size[] inputSizes = streamConfigurationMap2.getInputSizes(i);
                if (inputSizes != null) {
                    Arrays.sort(inputSizes, new v00(true));
                    map.put(Integer.valueOf(i), inputSizes[0]);
                }
            }
        }
        if (od3Var.e && !map.isEmpty() && map.containsKey(34) && (streamConfigurationMap = (StreamConfigurationMap) od3Var.a.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)) != null && (validOutputFormatsForInput = streamConfigurationMap.getValidOutputFormatsForInput(34)) != null) {
            for (int i2 : validOutputFormatsForInput) {
                if (i2 == 256) {
                    Size size = (Size) map.get(34);
                    fj1 fj1Var = new fj1(size.getWidth(), size.getHeight(), 34, 9);
                    od3Var.h = fj1Var.b;
                    od3Var.g = new m92(fj1Var);
                    fj1Var.l(new zq(11, od3Var), xg4.b());
                    nz0 nz0Var2 = new nz0(od3Var.g.getSurface(), new Size(od3Var.g.b(), od3Var.g.a()), 34);
                    od3Var.i = nz0Var2;
                    m92 m92Var2 = od3Var.g;
                    wc1 wc1VarE = oz3.e(nz0Var2.e);
                    Objects.requireNonNull(m92Var2);
                    wc1VarE.a(new nw(m92Var2, 2), xg4.c());
                    gh2Var.b(od3Var.i, ig0.d, -1);
                    ow owVar = od3Var.h;
                    gh2Var.b.b(owVar);
                    ArrayList arrayList = gh2Var.e;
                    if (!arrayList.contains(owVar)) {
                        arrayList.add(owVar);
                    }
                    vs vsVar = new vs(2, od3Var);
                    ArrayList arrayList2 = gh2Var.d;
                    if (!arrayList2.contains(vsVar)) {
                        arrayList2.add(vsVar);
                    }
                    gh2Var.g = new InputConfiguration(od3Var.g.b(), od3Var.g.a(), od3Var.g.h());
                    return;
                }
            }
        }
        gh2Var.b.a = 1;
    }

    public final void j(jq jqVar) {
        ((HashSet) this.b.b).add(jqVar);
    }

    public final void k() {
        synchronized (this.d) {
            try {
                int i = this.p;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                this.p = i - 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(boolean z) {
        this.r = z;
        if (!z) {
            ur urVar = new ur();
            urVar.a = this.x;
            urVar.c = true;
            zl1 zl1VarM = zl1.m();
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
            zl1VarM.v(zr.M(key), Integer.valueOf(n(this.e, 1)));
            zl1VarM.v(zr.M(CaptureRequest.FLASH_MODE), 0);
            urVar.c(new zr(gs1.l(zl1VarM)));
            s(Collections.singletonList(urVar.d()));
        }
        u();
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:65:0x011b A[Catch: all -> 0x015e, LOOP:0: B:63:0x0115->B:65:0x011b, LOOP_END, TryCatch #1 {, blocks: (B:62:0x0107, B:63:0x0115, B:65:0x011b, B:66:0x012b), top: B:77:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0036  */
    public final kh2 m() {
        int[] iArr;
        jb jbVar;
        bq bqVar;
        zl1 zl1Var;
        r30 r30Var;
        gh2 gh2Var = this.g;
        gh2Var.b.a = this.x;
        yr yrVar = new yr(0);
        int i = 1;
        yrVar.f(CaptureRequest.CONTROL_MODE, 1);
        zn0 zn0Var = this.h;
        zn0Var.getClass();
        int i2 = 4;
        int i3 = 3;
        int i4 = zn0Var.d != 3 ? 4 : 3;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
        int[] iArr2 = (int[]) zn0Var.a.e.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr2 == null) {
            i2 = 0;
        } else if (p(i4, iArr2)) {
            i2 = i4;
        } else if (!p(4, iArr2)) {
            if (p(1, iArr2)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        }
        yrVar.f(key, Integer.valueOf(i2));
        MeteringRectangle[] meteringRectangleArr = zn0Var.e;
        if (meteringRectangleArr.length != 0) {
            yrVar.f(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        MeteringRectangle[] meteringRectangleArr2 = zn0Var.f;
        if (meteringRectangleArr2.length != 0) {
            yrVar.f(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        }
        MeteringRectangle[] meteringRectangleArr3 = zn0Var.g;
        if (meteringRectangleArr3.length != 0) {
            yrVar.f(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3);
        }
        Range range = (Range) this.t.b;
        if (range != null) {
            yrVar.f(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
        }
        ((md3) this.i.f).e(yrVar);
        int i5 = this.h.h ? 5 : 1;
        if (!this.r) {
            int i6 = this.s;
            if (i6 == 0) {
                ph phVar = this.u;
                if (phVar.a || phVar.b) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
            } else if (i6 != 1) {
                if (i6 == 2) {
                    i3 = 1;
                }
            }
            yrVar.f(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(n(this.e, i3)));
            CaptureRequest.Key key2 = CaptureRequest.CONTROL_AWB_MODE;
            iArr = (int[]) this.e.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
            if (iArr != null || (!p(1, iArr) && !p(1, iArr))) {
                i = 0;
            }
            yrVar.f(key2, Integer.valueOf(i));
            jbVar = this.k;
            jbVar.getClass();
            CaptureRequest.Key key3 = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
            synchronized (((c4) jbVar.b).a) {
            }
            yrVar.f(key3, 0);
            bqVar = this.m;
            synchronized (bqVar.e) {
                zl1Var = bqVar.f.b;
                r30Var = r30.a;
                for (bi biVar : zl1Var.e()) {
                    yrVar.b.u(biVar, r30Var, zl1Var.f(biVar));
                }
            }
            zr zrVar = new zr(gs1.l(yrVar.b));
            ur urVar = gh2Var.b;
            urVar.getClass();
            urVar.e = zl1.o(zrVar);
            ((om1) this.g.b.g).a.put("CameraControlSessionUpdateId", Long.valueOf(this.y));
            return this.g.c();
        }
        yrVar.f(CaptureRequest.FLASH_MODE, 2);
        i3 = i5;
        yrVar.f(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(n(this.e, i3)));
        CaptureRequest.Key key4 = CaptureRequest.CONTROL_AWB_MODE;
        iArr = (int[]) this.e.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr != null) {
            i = 0;
        } else {
            i = 0;
        }
        yrVar.f(key4, Integer.valueOf(i));
        jbVar = this.k;
        jbVar.getClass();
        CaptureRequest.Key key5 = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
        synchronized (((c4) jbVar.b).a) {
            yrVar.f(key5, 0);
            bqVar = this.m;
            synchronized (bqVar.e) {
                zl1Var = bqVar.f.b;
                r30Var = r30.a;
                while (r5.hasNext()) {
                    yrVar.b.u(biVar, r30Var, zl1Var.f(biVar));
                }
                zr zrVar2 = new zr(gs1.l(yrVar.b));
                ur urVar2 = gh2Var.b;
                urVar2.getClass();
                urVar2.e = zl1.o(zrVar2);
                ((om1) this.g.b.g).a.put("CameraControlSessionUpdateId", Long.valueOf(this.y));
                return this.g.c();
            }
        }
    }

    public final boolean o() {
        int i;
        synchronized (this.d) {
            i = this.p;
        }
        return i > 0;
    }

    public final void r(boolean z) {
        ni niVar;
        xq4.c(3, "Camera2CameraControlImp");
        zn0 zn0Var = this.h;
        int i = 0;
        if (z != zn0Var.c) {
            zn0Var.c = z;
            if (!zn0Var.c) {
                kq kqVar = zn0Var.a;
                ((HashSet) kqVar.b.b).remove(null);
                ((HashSet) kqVar.b.b).remove(null);
                if (zn0Var.e.length > 0) {
                    zn0Var.a(true, false);
                }
                MeteringRectangle[] meteringRectangleArr = zn0.j;
                zn0Var.e = meteringRectangleArr;
                zn0Var.f = meteringRectangleArr;
                zn0Var.g = meteringRectangleArr;
                kqVar.u();
            }
        }
        k02 k02Var = this.i;
        if (k02Var.b != z) {
            k02Var.b = z;
            if (!z) {
                synchronized (((fm1) k02Var.e)) {
                    ((fm1) k02Var.e).g();
                    fm1 fm1Var = (fm1) k02Var.e;
                    niVar = new ni(fm1Var.d(), fm1Var.b(), fm1Var.c(), fm1Var.a());
                }
                Looper looperMyLooper = Looper.myLooper();
                Looper mainLooper = Looper.getMainLooper();
                pl1 pl1Var = (pl1) k02Var.a;
                if (looperMyLooper == mainLooper) {
                    pl1Var.h(niVar);
                } else {
                    pl1Var.i(niVar);
                }
                ((md3) k02Var.f).g();
                ((kq) k02Var.c).u();
            }
        }
        a22 a22Var = this.j;
        if (a22Var.b != z) {
            a22Var.b = z;
            if (!z) {
                if (a22Var.c) {
                    a22Var.c = false;
                    ((kq) a22Var.d).l(false);
                    pl1 pl1Var2 = (pl1) a22Var.e;
                    if (vc4.c()) {
                        pl1Var2.h(0);
                    } else {
                        pl1Var2.i(0);
                    }
                }
                tp tpVar = (tp) a22Var.f;
                if (tpVar != null) {
                    tpVar.b(new dt("Camera is not active."));
                    a22Var.f = null;
                }
            }
        }
        jb jbVar = this.k;
        if (z != jbVar.a) {
            jbVar.a = z;
            if (!z) {
                synchronized (((c4) jbVar.b).a) {
                }
            }
        }
        bq bqVar = this.m;
        bqVar.d.execute(new aq(bqVar, z, i));
        if (z) {
            return;
        }
        this.q = null;
        ((AtomicInteger) this.o.b).set(0);
        xq4.c(3, "VideoUsageControl");
    }

    public final void s(List list) {
        Iterator it;
        int iC;
        int iB;
        ls lsVar;
        yq yqVar = (yq) this.f.b;
        list.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            lw lwVar = (lw) it2.next();
            HashSet hashSet = new HashSet();
            zl1.m();
            ArrayList arrayList2 = new ArrayList();
            om1.a();
            hashSet.addAll(lwVar.a);
            zl1 zl1VarO = zl1.o(lwVar.b);
            int i = lwVar.c;
            arrayList2.addAll(lwVar.e);
            boolean z = lwVar.f;
            iv2 iv2Var = lwVar.g;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : iv2Var.a.keySet()) {
                arrayMap.put(str, iv2Var.a.get(str));
            }
            om1 om1Var = new om1(arrayMap);
            boolean z2 = lwVar.d;
            ls lsVar2 = (lwVar.c != 5 || (lsVar = lwVar.h) == null) ? null : lsVar;
            if (Collections.unmodifiableList(lwVar.a).isEmpty() && lwVar.f) {
                if (hashSet.isEmpty()) {
                    sg1 sg1Var = yqVar.a;
                    sg1Var.getClass();
                    ArrayList arrayList3 = new ArrayList();
                    for (Map.Entry entry : sg1Var.a.entrySet()) {
                        p53 p53Var = (p53) entry.getValue();
                        Iterator it3 = it2;
                        if (p53Var.f && p53Var.e) {
                            arrayList3.add(((p53) entry.getValue()).a);
                        }
                        it2 = it3;
                    }
                    it = it2;
                    Iterator it4 = Collections.unmodifiableCollection(arrayList3).iterator();
                    while (it4.hasNext()) {
                        lw lwVar2 = ((kh2) it4.next()).g;
                        List listUnmodifiableList = Collections.unmodifiableList(lwVar2.a);
                        if (!listUnmodifiableList.isEmpty()) {
                            if (lwVar2.b() != 0 && (iB = lwVar2.b()) != 0) {
                                zl1VarO.v(r53.a0, Integer.valueOf(iB));
                            }
                            if (lwVar2.c() != 0 && (iC = lwVar2.c()) != 0) {
                                zl1VarO.v(r53.b0, Integer.valueOf(iC));
                            }
                            Iterator it5 = listUnmodifiableList.iterator();
                            while (it5.hasNext()) {
                                hashSet.add((ob0) it5.next());
                            }
                        }
                    }
                    if (hashSet.isEmpty()) {
                        xq4.d("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
                    }
                } else {
                    xq4.d("Camera2CameraImpl", "The capture config builder already has surface inside.");
                    it = it2;
                }
                it2 = it;
            } else {
                it = it2;
            }
            ArrayList arrayList4 = new ArrayList(hashSet);
            gs1 gs1VarL = gs1.l(zl1VarO);
            ArrayList arrayList5 = new ArrayList(arrayList2);
            iv2 iv2Var2 = iv2.b;
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayMap arrayMap3 = om1Var.a;
            for (String str2 : arrayMap3.keySet()) {
                arrayMap2.put(str2, arrayMap3.get(str2));
            }
            arrayList.add(new lw(arrayList4, gs1VarL, i, z2, arrayList5, z, new iv2(arrayMap2), lsVar2));
            it2 = it;
        }
        yqVar.t("Issue capture request");
        yqVar.u.i(arrayList);
    }

    public final wc1 t() {
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            this.c.execute(new o8(3, this, tpVar));
            tpVar.a = "updateSessionConfigAsync";
        } catch (Exception e) {
            wpVar.b(e);
        }
        return oz3.e(wpVar);
    }

    public final long u() {
        this.y = this.v.getAndIncrement();
        ((yq) this.f.b).K();
        return this.y;
    }
}
