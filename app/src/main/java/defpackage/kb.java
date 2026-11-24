package defpackage;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import com.project.sonic.MainActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kb implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ kb(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:184:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0112 A[Catch: all -> 0x0107, LOOP:4: B:51:0x00d2->B:65:0x0112, LOOP_END, TryCatch #2 {all -> 0x0107, blocks: (B:59:0x0101, B:62:0x0109, B:67:0x011b, B:65:0x0112), top: B:168:0x0101 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r17v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // defpackage.fq0
    public final Object a() {
        Object obj;
        boolean z;
        String str;
        boolean z2 = true;
        boolean z3 = false;
        switch (this.a) {
            case 0:
                vm4.a((lb) this.b);
                return q43.a;
            case 1:
                return ((dx2) this.b).s0();
            case 2:
                return (l42) this.b;
            case 3:
                a50 a50Var = (a50) this.b;
                x42 x42Var = c50.a;
                return c50.a((String) a50Var.c);
            case 4:
                return ((ua1) this.b).d();
            case 5:
                return new fy2((js1) this.b, 0.0f);
            case 6:
                ((ox2) this.b).close();
                return q43.a;
            case 7:
                return Float.valueOf(ya4.e(((s70) this.b).o()));
            case 8:
                Object systemService = ((View) ((l11) this.b).b).getContext().getSystemService("input_method");
                systemService.getClass();
                return (InputMethodManager) systemService;
            case 9:
                x11 x11Var = (x11) this.b;
                Set set = ue.f;
                return qs4.r(x11Var.b);
            case 10:
                return Integer.valueOf(((ea1) this.b).i().n);
            case 11:
                return new BaseInputConnection(((wa1) this.b).a, false);
            case 12:
                MainActivity mainActivity = (MainActivity) this.b;
                Set set2 = MainActivity.m0;
                List list = ((qj2) mainActivity.s().f.getValue()).a;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (!((i92) obj2).d) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj3 = arrayList.get(i);
                    i++;
                    arrayList2.add(((i92) obj3).a);
                }
                if (arrayList2.isEmpty()) {
                    mainActivity.s().e();
                } else {
                    mainActivity.l0.x(arrayList2.toArray(new String[0]));
                }
                return q43.a;
            case 13:
                return (vk1) mx.a(((bx) this.b).p());
            case 14:
                x92 x92Var = (x92) this.b;
                qa2 qa2Var = x92Var.a;
                Object obj4 = x92Var.e;
                if (obj4 != null) {
                    return qa2Var.s(x92Var, obj4);
                }
                og.i("Value should be initialized");
                return null;
            case 15:
                q91 q91Var = ((ea2) this.b).c;
                if (q91Var == null) {
                    return null;
                }
                Bundle bundleA = bg4.a((wt1[]) Arrays.copyOf(new wt1[0], 0));
                q91Var.E(bundleA);
                if (bundleA.isEmpty()) {
                    return null;
                }
                return bundleA;
            case 16:
                return c44.d((h83) this.b);
            case 17:
                na2 na2Var = (na2) this.b;
                na2Var.f().a(new k42(0, na2Var));
                return q43.a;
            case 18:
                od2 od2Var = (od2) this.b;
                g9 g9Var = (g9) ij4.a(od2Var, gt1.a);
                od2Var.i0 = g9Var;
                od2Var.j0 = g9Var != null ? new f9(g9Var.a, g9Var.b, g9Var.c, g9Var.d) : null;
                return q43.a;
            case 19:
                return this.b;
            case 20:
                uj2 uj2Var = (uj2) this.b;
                ku1 ku1Var = uj2Var.c;
                if (((xk2) ku1Var.getValue()).a == 9205357640488583168L || xk2.c(((xk2) ku1Var.getValue()).a)) {
                    return null;
                }
                return uj2Var.a.b(((xk2) ku1Var.getValue()).a);
            case 21:
                wm2 wm2Var = (wm2) this.b;
                while (true) {
                    Object obj5 = wm2Var.g;
                    synchronized (obj5) {
                        try {
                            if (wm2Var.c) {
                                obj = obj5;
                            } else {
                                wm2Var.c = z2;
                                try {
                                    pm1 pm1Var = wm2Var.f;
                                    Object[] objArr = pm1Var.a;
                                    int i2 = pm1Var.c;
                                    for (?? r6 = z3; r6 < i2; r6++) {
                                        try {
                                            vm2 vm2Var = (vm2) objArr[r6];
                                            hm1 hm1Var = vm2Var.g;
                                            hq0 hq0Var = vm2Var.a;
                                            Object[] objArr2 = hm1Var.b;
                                            long[] jArr = hm1Var.a;
                                            int length = jArr.length - 2;
                                            if (length >= 0) {
                                                ?? r12 = z3;
                                                while (true) {
                                                    long j = jArr[r12];
                                                    obj = obj5;
                                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i3 = 8 - ((~(r12 - length)) >>> 31);
                                                        for (?? r15 = z3; r15 < i3; r15++) {
                                                            if ((j & 255) < 128) {
                                                                try {
                                                                    hq0Var.j(objArr2[(r12 << 3) + r15]);
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    z = false;
                                                                    wm2Var.c = z;
                                                                    throw th;
                                                                }
                                                            }
                                                            j >>= 8;
                                                        }
                                                        if (i3 == 8) {
                                                            if (r12 != length) {
                                                                z3 = false;
                                                                obj5 = obj;
                                                                r12++;
                                                            }
                                                        }
                                                    } else if (r12 != length) {
                                                        z3 = false;
                                                        obj5 = obj;
                                                        r12++;
                                                    }
                                                }
                                            } else {
                                                obj = obj5;
                                            }
                                            hm1Var.b();
                                            z3 = false;
                                            obj5 = obj;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            obj = obj5;
                                        }
                                    }
                                    obj = obj5;
                                    try {
                                        wm2Var.c = z3;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj = obj5;
                                    z = z3;
                                }
                            }
                            if (!wm2Var.b()) {
                                return q43.a;
                            }
                            z2 = true;
                            z3 = false;
                        } catch (Throwable th5) {
                            th = th5;
                            obj = obj5;
                        }
                    }
                }
                break;
            case 22:
                PendingIntent actionIntent = ((RemoteAction) this.b).getActionIntent();
                if (Build.VERSION.SDK_INT >= 34) {
                    try {
                        actionIntent.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                    } catch (PendingIntent.CanceledException e) {
                        Log.e("TextClassification", "error sending pendingIntent: " + actionIntent + " error: " + e);
                    }
                    break;
                } else {
                    actionIntent.send();
                }
                return q43.a;
            case 23:
                rx2 rx2Var = (rx2) this.b;
                return rx2Var.w ? kb4.a(rx2Var) : cx2.b;
            case 24:
                xz2 xz2Var = (xz2) this.b;
                xz2Var.h0 = null;
                a34.a(xz2Var);
                up4.a(xz2Var);
                vm4.a(xz2Var);
                return Boolean.TRUE;
            default:
                j13 j13Var = (j13) this.b;
                CameraManager cameraManager = j13Var.b;
                if (cameraManager == null) {
                    return null;
                }
                try {
                    String[] cameraIdList = cameraManager.getCameraIdList();
                    cameraIdList.getClass();
                    int length2 = cameraIdList.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length2) {
                            str = cameraIdList[i4];
                            str.getClass();
                            if (!j13Var.a(str, true)) {
                                i4++;
                            }
                        } else {
                            str = null;
                        }
                    }
                    if (str != null) {
                        return str;
                    }
                    for (String str2 : cameraIdList) {
                        str2.getClass();
                        if (j13Var.a(str2, false)) {
                            return str2;
                        }
                    }
                    return null;
                } catch (CameraAccessException | IllegalStateException unused) {
                    return null;
                }
        }
    }
}
