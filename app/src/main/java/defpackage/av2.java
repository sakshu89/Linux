package defpackage;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class av2 implements up, ch {
    public final /* synthetic */ bv2 a;
    public final /* synthetic */ oh2 b;
    public final /* synthetic */ List c;
    public final /* synthetic */ Object e;

    public /* synthetic */ av2(bv2 bv2Var, CameraDevice cameraDevice, oh2 oh2Var, List list) {
        this.a = bv2Var;
        this.e = cameraDevice;
        this.b = oh2Var;
        this.c = list;
    }

    @Override // defpackage.ch
    /* JADX INFO: renamed from: apply */
    public wc1 mo28apply(Object obj) {
        bv2 bv2Var = this.a;
        CameraDevice cameraDevice = (CameraDevice) this.e;
        oh2 oh2Var = this.b;
        List list = this.c;
        int i = 0;
        if (bv2Var.v.a) {
            ArrayList arrayListG = bv2Var.b.g();
            int size = arrayListG.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayListG.get(i2);
                i2++;
                ((bv2) obj2).j();
            }
        }
        bv2.l();
        synchronized (bv2Var.a) {
            try {
                if (bv2Var.m) {
                    return new mz0(1, new CancellationException("Opener is disabled"));
                }
                lj1 lj1Var = bv2Var.b;
                synchronized (lj1Var.c) {
                    ((LinkedHashSet) lj1Var.f).add(bv2Var);
                }
                Handler handler = bv2Var.c;
                q82 q82Var = new q82();
                if (Build.VERSION.SDK_INT >= 28) {
                    cameraDevice.getClass();
                    q82Var.a = new kt(cameraDevice, null);
                } else {
                    q82Var.a = new l11(cameraDevice, new lt(handler));
                }
                wp wpVarA = hg4.a(new av2(bv2Var, list, q82Var, oh2Var));
                bv2Var.h = wpVarA;
                wpVarA.a(new or0(i, wpVarA, new wj1(12, bv2Var)), xg4.a());
                return oz3.e(bv2Var.h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        String str;
        bv2 bv2Var = this.a;
        List list = this.c;
        q82 q82Var = (q82) this.e;
        oh2 oh2Var = this.b;
        synchronized (bv2Var.a) {
            synchronized (bv2Var.a) {
                synchronized (bv2Var.a) {
                    try {
                        List list2 = bv2Var.k;
                        if (list2 != null) {
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                ((ob0) it.next()).b();
                            }
                            bv2Var.k = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!list.isEmpty()) {
                    int i = 0;
                    do {
                        try {
                            ((ob0) list.get(i)).d();
                            i++;
                        } catch (nb0 e) {
                            for (int i2 = i - 1; i2 >= 0; i2--) {
                                ((ob0) list.get(i2)).b();
                            }
                            throw e;
                        }
                    } while (i < list.size());
                }
                bv2Var.k = list;
            }
            hh1.e("The openCaptureSessionCompleter can only set once!", bv2Var.i == null);
            bv2Var.i = tpVar;
            ((l11) q82Var.a).t(oh2Var);
            str = "openCaptureSession[session=" + bv2Var + "]";
        }
        return str;
    }

    public /* synthetic */ av2(bv2 bv2Var, List list, q82 q82Var, oh2 oh2Var) {
        this.a = bv2Var;
        this.c = list;
        this.e = q82Var;
        this.b = oh2Var;
    }
}
