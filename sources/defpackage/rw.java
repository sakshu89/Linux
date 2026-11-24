package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Size;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rw implements ch, up, eu2 {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ rw(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public void a() {
        py0 py0Var = (py0) this.a;
        k02 k02Var = (k02) this.b;
        wt wtVar = (wt) this.c;
        AtomicReference atomicReference = ((r02) py0Var.b).j;
        do {
            if (atomicReference.compareAndSet(k02Var, null)) {
                k02Var.a(q02.a);
                break;
            }
        } while (atomicReference.get() == k02Var);
        jr0 jr0Var = (jr0) k02Var.i;
        if (jr0Var != null) {
            jr0Var.cancel(false);
            k02Var.i = null;
        }
        wtVar.k().o(k02Var);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x014e A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:4:0x0019, B:10:0x002a, B:11:0x003e, B:16:0x0047, B:17:0x004e, B:19:0x0054, B:20:0x006a, B:21:0x00c8, B:23:0x00ce, B:24:0x00e5, B:26:0x00f7, B:28:0x00fb, B:29:0x0107, B:31:0x0126, B:33:0x0138, B:35:0x0140, B:39:0x014e, B:41:0x0160), top: B:79:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0160 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:4:0x0019, B:10:0x002a, B:11:0x003e, B:16:0x0047, B:17:0x004e, B:19:0x0054, B:20:0x006a, B:21:0x00c8, B:23:0x00ce, B:24:0x00e5, B:26:0x00f7, B:28:0x00fb, B:29:0x0107, B:31:0x0126, B:33:0x0138, B:35:0x0140, B:39:0x014e, B:41:0x0160), top: B:79:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0178  */
    @Override // defpackage.ch
    /* JADX INFO: renamed from: apply */
    public wc1 mo28apply(Object obj) throws Throwable {
        Object obj2;
        InputConfiguration inputConfiguration;
        boolean z;
        ws1 ws1VarE;
        String str;
        tw twVar = (tw) this.a;
        kh2 kh2Var = (kh2) this.b;
        CameraDevice cameraDevice = (CameraDevice) this.c;
        List list = (List) obj;
        Object obj3 = twVar.a;
        synchronized (obj3) {
            try {
                try {
                    int iX = cq.x(twVar.i);
                    if (iX != 0 && iX != 1) {
                        if (iX == 2) {
                            twVar.g.clear();
                            for (int i = 0; i < list.size(); i++) {
                                twVar.g.put((ob0) twVar.h.get(i), (Surface) list.get(i));
                            }
                            twVar.i = 4;
                            xq4.c(3, "CaptureSession");
                            sw swVar = new sw(Arrays.asList(twVar.c, new sw(kh2Var.d, 1)), 2);
                            lw lwVar = kh2Var.g;
                            zr zrVar = new zr(lwVar.b);
                            HashSet hashSet = new HashSet();
                            zl1.m();
                            ArrayList arrayList = new ArrayList();
                            om1.a();
                            hashSet.addAll(lwVar.a);
                            zl1 zl1VarO = zl1.o(lwVar.b);
                            int i2 = lwVar.c;
                            arrayList.addAll(lwVar.e);
                            boolean z2 = lwVar.f;
                            iv2 iv2Var = lwVar.g;
                            ArrayMap arrayMap = new ArrayMap();
                            for (Iterator it = iv2Var.a.keySet().iterator(); it.hasNext(); it = it) {
                                String str2 = (String) it.next();
                                arrayMap.put(str2, iv2Var.a.get(str2));
                            }
                            om1 om1Var = new om1(arrayMap);
                            boolean z3 = lwVar.d;
                            HashMap map = new HashMap();
                            if (twVar.r && Build.VERSION.SDK_INT >= 35) {
                                map = tw.c(tw.f(kh2Var.a), twVar.g);
                            }
                            ArrayList arrayList2 = new ArrayList();
                            String str3 = (String) ((s30) zrVar.a).d(zr.t, null);
                            ArrayList arrayList3 = kh2Var.a;
                            int size = arrayList3.size();
                            int i3 = 0;
                            while (i3 < size) {
                                Object obj4 = arrayList3.get(i3);
                                int i4 = i3 + 1;
                                int i5 = size;
                                dj djVar = (dj) obj4;
                                if (twVar.r) {
                                    z = z2;
                                    ws1VarE = Build.VERSION.SDK_INT >= 35 ? (ws1) map.get(djVar) : null;
                                    if (ws1VarE == null) {
                                        ws1VarE = twVar.e(djVar, twVar.g, str3);
                                        str = str3;
                                        if (twVar.l.containsKey(djVar.a)) {
                                            ws1VarE.a.f(((Long) twVar.l.get(djVar.a)).longValue());
                                        }
                                        arrayList2.add(ws1VarE);
                                        obj3 = obj3;
                                        i3 = i4;
                                        size = i5;
                                        z2 = z;
                                        str3 = str;
                                    } else {
                                        str = str3;
                                    }
                                    arrayList2.add(ws1VarE);
                                    obj3 = obj3;
                                    i3 = i4;
                                    size = i5;
                                    z2 = z;
                                    str3 = str;
                                } else {
                                    z = z2;
                                }
                                if (ws1VarE == null) {
                                    ws1VarE = twVar.e(djVar, twVar.g, str3);
                                    str = str3;
                                    if (twVar.l.containsKey(djVar.a)) {
                                        ws1VarE.a.f(((Long) twVar.l.get(djVar.a)).longValue());
                                    }
                                    arrayList2.add(ws1VarE);
                                    obj3 = obj3;
                                    i3 = i4;
                                    size = i5;
                                    z2 = z;
                                    str3 = str;
                                } else {
                                    str = str3;
                                }
                                arrayList2.add(ws1VarE);
                                obj3 = obj3;
                                i3 = i4;
                                size = i5;
                                z2 = z;
                                str3 = str;
                            }
                            obj2 = obj3;
                            boolean z4 = z2;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = new ArrayList();
                            int size2 = arrayList2.size();
                            int i6 = 0;
                            while (i6 < size2) {
                                Object obj5 = arrayList2.get(i6);
                                i6++;
                                ws1 ws1Var = (ws1) obj5;
                                if (!arrayList4.contains(((OutputConfiguration) ws1Var.a.a()).getSurface())) {
                                    arrayList4.add(((OutputConfiguration) ws1Var.a.a()).getSurface());
                                    arrayList5.add(ws1Var);
                                }
                            }
                            bv2 bv2Var = twVar.d;
                            bv2Var.f = swVar;
                            oh2 oh2Var = new oh2(arrayList5, bv2Var.d, new vs(1, bv2Var));
                            if (kh2Var.g.c == 5 && (inputConfiguration = kh2Var.h) != null) {
                                oh2Var.a.h(j11.a(inputConfiguration));
                            }
                            try {
                                ArrayList arrayList6 = new ArrayList(hashSet);
                                gs1 gs1VarL = gs1.l(zl1VarO);
                                ArrayList arrayList7 = new ArrayList(arrayList);
                                iv2 iv2Var2 = iv2.b;
                                ArrayMap arrayMap2 = new ArrayMap();
                                for (String str4 : om1Var.a.keySet()) {
                                    arrayMap2.put(str4, om1Var.a.get(str4));
                                }
                                CaptureRequest captureRequestD = jg4.d(new lw(arrayList6, gs1VarL, i2, z3, arrayList7, z4, new iv2(arrayMap2), null), cameraDevice, twVar.q);
                                if (captureRequestD != null) {
                                    oh2Var.a.g(captureRequestD);
                                }
                                wc1 wc1VarN = twVar.d.n(cameraDevice, oh2Var, twVar.h);
                                return wc1VarN;
                            } catch (CameraAccessException e) {
                                return new mz0(1, e);
                            }
                        }
                        if (iX != 4) {
                            return new mz0(1, new CancellationException("openCaptureSession() not execute in state: ".concat(cq.z(twVar.i))));
                        }
                        throw th;
                    }
                    return new mz0(1, new IllegalStateException("openCaptureSession() should not be possible in state: ".concat(cq.z(twVar.i))));
                } catch (Throwable th) {
                    th = th;
                    obj2 = obj3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // defpackage.eu2
    public void b(lj ljVar) {
        s02 s02Var;
        py0 py0Var = (py0) this.a;
        wt wtVar = (wt) this.b;
        fu2 fu2Var = (fu2) this.c;
        r02 r02Var = (r02) py0Var.b;
        Objects.toString(ljVar);
        xq4.c(3, "PreviewView");
        boolean z = wtVar.i().b() == 0;
        l02 l02Var = r02Var.e;
        Size size = fu2Var.b;
        l02Var.getClass();
        Objects.toString(ljVar);
        Objects.toString(size);
        xq4.c(3, "PreviewTransform");
        l02Var.b = ljVar.a;
        l02Var.c = ljVar.b;
        int i = ljVar.c;
        l02Var.e = i;
        l02Var.a = size;
        l02Var.f = z;
        l02Var.g = ljVar.d;
        l02Var.d = ljVar.e;
        if (i == -1 || ((s02Var = r02Var.b) != null && (s02Var instanceof iu2))) {
            r02Var.f = true;
        } else {
            r02Var.f = false;
        }
        r02Var.a();
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        wp wpVar = (wp) this.a;
        ch2 ch2Var = (ch2) this.b;
        ArrayList arrayList = (ArrayList) this.c;
        s7 s7Var = new s7(18, wpVar);
        o62 o62Var = tpVar.c;
        if (o62Var != null) {
            o62Var.a(s7Var, ch2Var);
        }
        wpVar.a(new or0(0, wpVar, new pb0(tpVar, 0)), ch2Var);
        return "surfaceList[" + arrayList + "]";
    }
}
