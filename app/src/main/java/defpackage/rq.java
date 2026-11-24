package defpackage;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.util.ArrayMap;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rq extends CameraDevice.StateCallback {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final Object c;

    public rq(Executor executor, CameraDevice.StateCallback stateCallback) {
        this.c = executor;
        this.b = stateCallback;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                ((yq) obj).t("openCameraConfigAndClose camera closed");
                ((tp) this.b).a(null);
                break;
            default:
                ((Executor) obj).execute(new jt(this, cameraDevice, 0));
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                ((yq) obj).t("openCameraConfigAndClose camera disconnected");
                ((tp) this.b).a(null);
                break;
            default:
                ((Executor) obj).execute(new jt(this, cameraDevice, 1));
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        int i2 = this.a;
        Object obj = this.c;
        switch (i2) {
            case 0:
                ((yq) obj).t("openCameraConfigAndClose camera error " + i);
                ((tp) this.b).a(null);
                break;
            default:
                ((Executor) obj).execute(new gq(this, cameraDevice, i, 3));
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                yq yqVar = (yq) obj;
                ch2 ch2Var = yqVar.c;
                yqVar.t("openCameraConfigAndClose camera opened");
                tw twVar = new tw(yqVar.n0, new cq0(Collections.EMPTY_LIST), false);
                SurfaceTexture surfaceTexture = new SurfaceTexture(0);
                surfaceTexture.setDefaultBufferSize(640, 480);
                Surface surface = new Surface(surfaceTexture);
                nz0 nz0Var = new nz0(surface);
                oz3.e(nz0Var.e).a(new o8(5, surface, surfaceTexture), xg4.a());
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashSet hashSet = new HashSet();
                zl1 zl1VarM = zl1.m();
                ArrayList arrayList = new ArrayList();
                om1 om1VarA = om1.a();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                cj cjVarA = dj.a(nz0Var);
                cjVarA.a = ig0.d;
                linkedHashSet.add(cjVarA.h());
                yqVar.t("Start configAndClose.");
                ArrayList arrayList5 = new ArrayList(linkedHashSet);
                ArrayList arrayList6 = new ArrayList(arrayList2);
                ArrayList arrayList7 = new ArrayList(arrayList3);
                ArrayList arrayList8 = new ArrayList(arrayList4);
                ArrayList arrayList9 = new ArrayList(hashSet);
                gs1 gs1VarL = gs1.l(zl1VarM);
                ArrayList arrayList10 = new ArrayList(arrayList);
                iv2 iv2Var = iv2.b;
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = om1VarA.a;
                for (String str : arrayMap2.keySet()) {
                    arrayMap.put(str, arrayMap2.get(str));
                    arrayList6 = arrayList6;
                }
                kh2 kh2Var = new kh2(arrayList5, arrayList6, arrayList7, arrayList8, new lw(arrayList9, gs1VarL, 1, false, arrayList10, false, new iv2(arrayMap), null), null, null, null);
                lj1 lj1Var = yqVar.h0;
                xw xwVarG = oz3.g(jr0.b(hg4.a(new nr0(twVar.k(kh2Var, cameraDevice, new bv2((cq0) lj1Var.f, (cq0) lj1Var.g, (xv0) lj1Var.c, (lj1) lj1Var.e, (ch2) lj1Var.b, (Handler) lj1Var.d)), 0))), new qq(0, twVar, nz0Var), ch2Var);
                Objects.requireNonNull(cameraDevice);
                xwVarG.a(new s7(5, cameraDevice), ch2Var);
                break;
            default:
                ((Executor) obj).execute(new jt(this, cameraDevice, 2));
                break;
        }
    }

    public rq(yq yqVar, tp tpVar) {
        this.c = yqVar;
        this.b = tpVar;
    }
}
