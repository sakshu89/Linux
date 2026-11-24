package defpackage;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.TotalCaptureResult;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import android.util.Size;
import android.view.Surface;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o8 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ o8(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        int i = 3;
        int i2 = 1;
        switch (this.a) {
            case 0:
                tc4.b((q8) this.b, (LongSparseArray) this.c);
                return;
            case 1:
                ((az0) this.c).c((s9) this.b);
                return;
            case 2:
                kq kqVar = (kq) this.b;
                es esVar = (es) this.c;
                hq hqVar = kqVar.z;
                ((HashSet) hqVar.b).remove(esVar);
                ((ArrayMap) hqVar.c).remove(esVar);
                return;
            case 3:
                kq kqVar2 = (kq) this.b;
                tp tpVar = (tp) this.c;
                final long jU = kqVar2.u();
                final tp tpVar2 = new tp();
                tpVar2.c = new o62();
                wp wpVar = new wp(tpVar2);
                tpVar2.b = wpVar;
                tpVar2.a = cq.class;
                try {
                    kqVar2.j(new jq() { // from class: dq
                        @Override // defpackage.jq
                        public final boolean a(TotalCaptureResult totalCaptureResult) {
                            if (!kq.q(totalCaptureResult, jU)) {
                                return false;
                            }
                            tpVar2.a(null);
                            return true;
                        }
                    });
                    tpVar2.a = "waitForSessionUpdateId:" + jU;
                    break;
                } catch (Exception e) {
                    wpVar.b(e);
                }
                oz3.f(true, wpVar, tpVar, xg4.a());
                return;
            case 4:
                iq iqVar = (iq) this.b;
                TotalCaptureResult totalCaptureResult = (TotalCaptureResult) this.c;
                HashSet hashSet = new HashSet();
                HashSet<jq> hashSet2 = (HashSet) iqVar.b;
                for (jq jqVar : hashSet2) {
                    if (jqVar.a(totalCaptureResult)) {
                        hashSet.add(jqVar);
                    }
                }
                if (hashSet.isEmpty()) {
                    return;
                }
                hashSet2.removeAll(hashSet);
                return;
            case 5:
                Surface surface = (Surface) this.b;
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.c;
                surface.release();
                surfaceTexture.release();
                return;
            case 6:
                yq yqVar = (yq) this.b;
                tp tpVar3 = (tp) this.c;
                lj1 lj1Var = yqVar.f0;
                if (lj1Var == null) {
                    tpVar3.a(Boolean.FALSE);
                    return;
                } else {
                    tpVar3.a(Boolean.valueOf(yqVar.a.d(yq.w(lj1Var))));
                    return;
                }
            case 7:
                yq yqVar2 = (yq) this.b;
                String str = (String) this.c;
                yqVar2.t("Use case " + str + " INACTIVE");
                LinkedHashMap linkedHashMap = yqVar2.a.a;
                if (linkedHashMap.containsKey(str)) {
                    p53 p53Var = (p53) linkedHashMap.get(str);
                    p53Var.f = false;
                    if (!p53Var.e) {
                        linkedHashMap.remove(str);
                    }
                }
                yqVar2.K();
                return;
            case 8:
                ((ih2) this.b).a((kh2) this.c);
                return;
            case 9:
                ((HashSet) ((kq) this.b).b.b).remove((or) this.c);
                return;
            case 10:
                n10 n10Var = (n10) this.b;
                n10Var.a.a(new g10((bq1) this.c, n10Var));
                return;
            case 11:
                fb0 fb0Var = (fb0) this.b;
                xt2 xt2Var = (xt2) this.c;
                Surface surfaceE = xt2Var.e(fb0Var.c, new tu(i2, fb0Var, xt2Var));
                fb0Var.a.p(surfaceE);
                fb0Var.h.put(xt2Var, surfaceE);
                return;
            case 12:
                ((fb0) this.b).k.add((di) this.c);
                return;
            case 13:
                final fb0 fb0Var2 = (fb0) this.b;
                final fu2 fu2Var = (fu2) this.c;
                fb0Var2.i++;
                qq1 qq1Var = fb0Var2.a;
                ur0.d((AtomicBoolean) qq1Var.c, true);
                ur0.c((Thread) qq1Var.f);
                final SurfaceTexture surfaceTexture2 = new SurfaceTexture(qq1Var.a);
                Size size = fu2Var.b;
                surfaceTexture2.setDefaultBufferSize(size.getWidth(), size.getHeight());
                final Surface surface2 = new Surface(surfaceTexture2);
                xv0 xv0Var = fb0Var2.c;
                fu2Var.b(xv0Var, new qq(i, fb0Var2, fu2Var));
                fu2Var.a(surface2, xv0Var, new s40() { // from class: eb0
                    @Override // defpackage.s40
                    public final void accept(Object obj) {
                        fb0 fb0Var3 = fb0Var2;
                        fu2 fu2Var2 = fu2Var;
                        SurfaceTexture surfaceTexture3 = surfaceTexture2;
                        Surface surface3 = surface2;
                        synchronized (fu2Var2.a) {
                            fu2Var2.m = null;
                            fu2Var2.n = null;
                        }
                        surfaceTexture3.setOnFrameAvailableListener(null);
                        surfaceTexture3.release();
                        surface3.release();
                        fb0Var3.i--;
                        fb0Var3.d();
                    }
                });
                surfaceTexture2.setOnFrameAvailableListener(fb0Var2, fb0Var2.d);
                return;
            case 14:
                ob0 ob0Var = (ob0) this.b;
                String str2 = (String) this.c;
                try {
                    ob0Var.e.get();
                    ob0.n.decrementAndGet();
                    ob0.m.get();
                    ob0Var.e();
                    return;
                } catch (Exception e2) {
                    xq4.a("DeferrableSurface", "Unexpected surface termination for " + ob0Var + "\nStack Trace:\n" + str2);
                    synchronized (ob0Var.a) {
                        try {
                            throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", ob0Var, Boolean.valueOf(ob0Var.c), Integer.valueOf(ob0Var.b)), e2);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            case 15:
                final cg0 cg0Var = (cg0) this.b;
                fu2 fu2Var2 = (fu2) this.c;
                cg0Var.e++;
                ag0 ag0Var = cg0Var.a;
                boolean z = fu2Var2.e;
                Size size2 = fu2Var2.b;
                ur0.d((AtomicBoolean) ag0Var.c, true);
                ur0.c((Thread) ag0Var.f);
                final SurfaceTexture surfaceTexture3 = new SurfaceTexture(z ? ag0Var.w : ag0Var.x);
                surfaceTexture3.setDefaultBufferSize(size2.getWidth(), size2.getHeight());
                final Surface surface3 = new Surface(surfaceTexture3);
                fu2Var2.a(surface3, cg0Var.c, new s40() { // from class: bg0
                    @Override // defpackage.s40
                    public final void accept(Object obj) {
                        SurfaceTexture surfaceTexture4 = surfaceTexture3;
                        surfaceTexture4.setOnFrameAvailableListener(null);
                        surfaceTexture4.release();
                        surface3.release();
                        cg0 cg0Var2 = cg0Var;
                        cg0Var2.e--;
                        cg0Var2.d();
                    }
                });
                if (z) {
                    cg0Var.i = surfaceTexture3;
                    return;
                } else {
                    cg0Var.j = surfaceTexture3;
                    surfaceTexture3.setOnFrameAvailableListener(cg0Var, cg0Var.d);
                    return;
                }
            case 16:
                cg0 cg0Var2 = (cg0) this.b;
                xt2 xt2Var2 = (xt2) this.c;
                Surface surfaceE2 = xt2Var2.e(cg0Var2.c, new tu(2, cg0Var2, xt2Var2));
                cg0Var2.a.p(surfaceE2);
                cg0Var2.h.put(xt2Var2, surfaceE2);
                return;
            case 17:
                ((zn0) this.b).d((tp) this.c);
                return;
            case 18:
                tp tpVar4 = (tp) this.b;
                wp wpVar2 = (wp) this.c;
                tpVar4.a(null);
                wpVar2.cancel(true);
                return;
            case 19:
                ((yv) this.b).H((tv0) this.c);
                return;
            case 20:
                ((pl1) ((q91) this.b).b).g((kd1) this.c);
                return;
            case 21:
                kd1 kd1Var = (kd1) this.b;
                ld1 ld1Var = (ld1) this.c;
                if (kd1Var.a.get()) {
                    ld1Var.getClass();
                    kd1Var.b.m(ld1Var.a);
                    return;
                }
                return;
            case 22:
                ((az0) this.c).c((fj1) this.b);
                return;
            case 23:
                ((gf2) this.b).j((mq1) this.c, q43.a);
                return;
            case 24:
                ((f02) this.b).a((fu2) this.c);
                return;
            case 25:
                ((r02) ((py0) this.b).b).u.a((fu2) this.c);
                return;
            case 26:
                g12 g12Var = (g12) this.b;
                zy0 zy0Var = (zy0) this.c;
                j62 j62Var = g12Var.g;
                vc4.b();
                if (j62Var.g) {
                    zy0Var.close();
                    return;
                }
                hh1.e("onImageCaptured() must be called before onFinalResult()", j62Var.c.b.isDone());
                j62Var.a();
                oj ojVar = j62Var.a;
                ojVar.b.execute(new c7(ojVar, zy0Var, i));
                return;
            case 27:
                g12 g12Var2 = (g12) this.b;
                py0 py0Var = (py0) this.c;
                j62 j62Var2 = g12Var2.g;
                vc4.b();
                if (j62Var2.g) {
                    return;
                }
                hh1.e("onImageCaptured() must be called before onFinalResult()", j62Var2.c.b.isDone());
                j62Var2.a();
                oj ojVar2 = j62Var2.a;
                ojVar2.b.execute(new v62(6, ojVar2, py0Var));
                return;
            case 28:
                g12 g12Var3 = (g12) this.b;
                Bitmap bitmap = (Bitmap) this.c;
                j62 j62Var3 = g12Var3.g;
                vc4.b();
                if (j62Var3.g) {
                    return;
                }
                oj ojVar3 = j62Var3.a;
                ojVar3.b.execute(new c7(ojVar3, bitmap, 4));
                return;
            default:
                g12 g12Var4 = (g12) this.b;
                ty0 ty0Var = (ty0) this.c;
                j62 j62Var4 = g12Var4.g;
                vc4.b();
                if (j62Var4.g) {
                    return;
                }
                hh1.e("onImageCaptured() must be called before onFinalResult()", j62Var4.c.b.isDone());
                j62Var4.a();
                vc4.b();
                oj ojVar4 = j62Var4.a;
                ojVar4.b.execute(new v62(5, ojVar4, ty0Var));
                return;
        }
    }
}
