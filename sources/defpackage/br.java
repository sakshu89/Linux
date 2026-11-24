package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Pair;
import android.util.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class br implements ut {
    public final String a;
    public final ys b;
    public final q82 c;
    public kq e;
    public final ar f;
    public final cq0 h;
    public final Object d = new Object();
    public ArrayList g = null;

    public br(zt ztVar, String str) {
        str.getClass();
        this.a = str;
        ys ysVarB = ztVar.b(str);
        this.b = ysVarB;
        q82 q82Var = new q82();
        q82Var.a = this;
        this.c = q82Var;
        this.h = tg4.a(ysVarB);
        new HashMap();
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            xq4.d("Camera2EncoderProfilesProvider", "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
        }
        this.f = new ar(new vh(5, null));
    }

    @Override // defpackage.ut
    public final int a() {
        return f(0);
    }

    @Override // defpackage.ut
    public final int b() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.LENS_FACING);
        hh1.a("Unable to get the lens facing of the camera.", num != null);
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return 0;
        }
        if (iIntValue == 1) {
            return 1;
        }
        if (iIntValue == 2) {
            return 2;
        }
        og.i(cq.h("The given lens facing integer: ", iIntValue, " can not be recognized."));
        return 0;
    }

    @Override // defpackage.ut
    public final String c() {
        return this.a;
    }

    @Override // defpackage.ut
    public final String d() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        num.getClass();
        return num.intValue() == 2 ? "androidx.camera.camera2.legacy" : "androidx.camera.camera2";
    }

    @Override // defpackage.ut
    public final List e(int i) {
        p6 p6VarB = this.b.b();
        HashMap map = (HashMap) p6VarB.e;
        Size[] sizeArr = null;
        if (!map.containsKey(Integer.valueOf(i))) {
            Size[] highResolutionOutputSizes = ((StreamConfigurationMap) ((wj1) p6VarB.a).b).getHighResolutionOutputSizes(i);
            if (highResolutionOutputSizes != null && highResolutionOutputSizes.length > 0) {
                highResolutionOutputSizes = ((q91) p6VarB.b).v(highResolutionOutputSizes, i);
            }
            map.put(Integer.valueOf(i), highResolutionOutputSizes);
            if (highResolutionOutputSizes != null) {
                sizeArr = (Size[]) highResolutionOutputSizes.clone();
            }
        } else if (((Size[]) map.get(Integer.valueOf(i))) != null) {
            sizeArr = (Size[]) ((Size[]) map.get(Integer.valueOf(i))).clone();
        }
        return sizeArr != null ? Arrays.asList(sizeArr) : Collections.EMPTY_LIST;
    }

    @Override // defpackage.ut
    public final int f(int i) {
        Integer num = (Integer) this.b.a(CameraCharacteristics.SENSOR_ORIENTATION);
        num.getClass();
        return pg4.a(pg4.b(i), num.intValue(), 1 == b());
    }

    @Override // defpackage.ut
    public final void g(Executor executor, hq hqVar) {
        synchronized (this.d) {
            try {
                kq kqVar = this.e;
                if (kqVar != null) {
                    kqVar.c.execute(new dc(kqVar, executor, hqVar, 1));
                    return;
                }
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(new Pair(hqVar, executor));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ut
    public final cq0 i() {
        return this.h;
    }

    @Override // defpackage.ut
    public final List j(int i) {
        Size[] sizeArrL = this.b.b().l(i);
        return sizeArrL != null ? Arrays.asList(sizeArrL) : Collections.EMPTY_LIST;
    }

    @Override // defpackage.ut
    public final void k(es esVar) {
        synchronized (this.d) {
            try {
                kq kqVar = this.e;
                if (kqVar != null) {
                    kqVar.c.execute(new o8(2, kqVar, esVar));
                    return;
                }
                ArrayList arrayList = this.g;
                if (arrayList == null) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((Pair) it.next()).first == esVar) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(kq kqVar) {
        synchronized (this.d) {
            try {
                this.e = kqVar;
                ArrayList arrayList = this.g;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        Pair pair = (Pair) obj;
                        kq kqVar2 = this.e;
                        kqVar2.c.execute(new dc(kqVar2, (Executor) pair.second, (es) pair.first, 1));
                    }
                    this.g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ((Integer) this.b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).getClass();
        xq4.c(4, "Camera2CameraInfo");
    }
}
