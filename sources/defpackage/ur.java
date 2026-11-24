package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ur {
    public int a;
    public boolean b;
    public boolean c;
    public final Object d;
    public Object e;
    public final Object f;
    public final Object g;
    public Object h;

    public ur(lw lwVar) {
        HashSet hashSet = new HashSet();
        this.d = hashSet;
        this.e = zl1.m();
        this.a = -1;
        this.b = false;
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        this.c = false;
        this.g = om1.a();
        hashSet.addAll(lwVar.a);
        this.e = zl1.o(lwVar.b);
        this.a = lwVar.c;
        arrayList.addAll(lwVar.e);
        this.c = lwVar.f;
        iv2 iv2Var = lwVar.g;
        ArrayMap arrayMap = new ArrayMap();
        for (String str : iv2Var.a.keySet()) {
            arrayMap.put(str, iv2Var.a.get(str));
        }
        this.g = new om1(arrayMap);
        this.b = lwVar.d;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    public static boolean f(TotalCaptureResult totalCaptureResult, boolean z) {
        char c;
        if (totalCaptureResult != null) {
            int i = 8;
            l11 l11Var = new l11(i, iv2.b, totalCaptureResult);
            Set set = z50.a;
            boolean z2 = l11Var.u() == 2 || l11Var.u() == 1 || z50.a.contains(l11Var.o());
            Integer num = (Integer) ((CaptureResult) l11Var.c).get(CaptureResult.CONTROL_AE_MODE);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    c = 2;
                } else if (iIntValue == 1) {
                    c = 3;
                } else if (iIntValue == 2) {
                    c = 4;
                } else if (iIntValue == 3) {
                    c = 5;
                } else if (iIntValue == 4) {
                    c = 6;
                } else if (iIntValue == 5 && Build.VERSION.SDK_INT >= 28) {
                    c = 7;
                } else {
                    c = 1;
                }
            } else {
                c = 1;
            }
            boolean z3 = c == 2;
            boolean z4 = !z ? !(z3 || z50.c.contains(l11Var.j())) : !(z3 || z50.d.contains(l11Var.j()));
            Integer num2 = (Integer) ((CaptureResult) l11Var.c).get(CaptureResult.CONTROL_AWB_MODE);
            if (num2 != null) {
                switch (num2.intValue()) {
                    case 0:
                        i = 2;
                        break;
                    case 1:
                        i = 3;
                        break;
                    case 2:
                        i = 4;
                        break;
                    case 3:
                        i = 5;
                        break;
                    case 4:
                        i = 6;
                        break;
                    case 5:
                        i = 7;
                        break;
                    case 6:
                        break;
                    case 7:
                        i = 9;
                        break;
                    case 8:
                        i = 10;
                        break;
                    default:
                        i = 1;
                        break;
                }
            } else {
                i = 1;
            }
            boolean z5 = i == 2 || z50.b.contains(l11Var.k());
            Objects.toString(l11Var.j());
            Objects.toString(l11Var.o());
            Objects.toString(l11Var.k());
            xq4.c(3, "ConvergenceUtils");
            if (z2 && z4 && z5) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(int i, TotalCaptureResult totalCaptureResult) {
        xq4.c(3, "Camera2CapturePipeline");
        if (i == 0) {
            Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
            xq4.c(3, "Camera2CapturePipeline");
            return num != null && num.intValue() == 4;
        }
        if (i != 1) {
            if (i == 2) {
                return false;
            }
            if (i != 3) {
                throw new AssertionError(i);
            }
        }
        return true;
    }

    public void a(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            b((es) it.next());
        }
    }

    public void b(es esVar) {
        ArrayList arrayList = (ArrayList) this.f;
        if (arrayList.contains(esVar)) {
            return;
        }
        arrayList.add(esVar);
    }

    public void c(s30 s30Var) {
        for (bi biVar : s30Var.e()) {
            zl1 zl1Var = (zl1) this.e;
            zl1Var.getClass();
            try {
                zl1Var.f(biVar);
            } catch (IllegalArgumentException unused) {
            }
            ((zl1) this.e).u(biVar, s30Var.b(biVar), s30Var.f(biVar));
        }
    }

    public lw d() {
        ArrayList arrayList = new ArrayList((HashSet) this.d);
        gs1 gs1VarL = gs1.l((zl1) this.e);
        int i = this.a;
        boolean z = this.b;
        ArrayList arrayList2 = new ArrayList((ArrayList) this.f);
        boolean z2 = this.c;
        om1 om1Var = (om1) this.g;
        iv2 iv2Var = iv2.b;
        ArrayMap arrayMap = new ArrayMap();
        for (String str : om1Var.a.keySet()) {
            arrayMap.put(str, om1Var.a.get(str));
        }
        return new lw(arrayList, gs1VarL, i, z, arrayList2, z2, new iv2(arrayMap), (ls) this.h);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0079  */
    public mr e(int i, int i2, int i3) {
        boolean z;
        kq kqVar = (kq) this.d;
        cq0 cq0Var = (cq0) this.f;
        ph phVar = new ph(cq0Var, 2);
        int i4 = this.a;
        Object obj = this.g;
        mr mrVar = new mr(i4, (ch2) obj, (xv0) this.h, kqVar, this.c, phVar);
        ArrayList arrayList = mrVar.h;
        if (i == 0) {
            arrayList.add(new gr(kqVar));
        }
        if (i2 == 3) {
            arrayList.add(new rr(kqVar, (ch2) obj, (xv0) this.h, new wj1(cq0Var)));
        } else if (this.b) {
            boolean z2 = ((rh2) this.e).a;
            if (z2 || this.a == 3 || i3 == 1) {
                if (!z2) {
                    int i5 = ((AtomicInteger) kqVar.o.b).get();
                    xq4.c(3, "Camera2CameraControlImp");
                    z = i5 <= 0;
                }
                arrayList.add(new tr(kqVar, i2, (ch2) obj, (xv0) this.h, z));
            } else {
                arrayList.add(new fr(kqVar, i2, phVar));
            }
        }
        Objects.toString(arrayList);
        xq4.c(3, "Camera2CapturePipeline");
        return mrVar;
    }

    public ur() {
        this.d = new HashSet();
        this.e = zl1.m();
        this.a = -1;
        this.b = false;
        this.f = new ArrayList();
        this.c = false;
        this.g = om1.a();
    }

    public ur(kq kqVar, ys ysVar, cq0 cq0Var, ch2 ch2Var, xv0 xv0Var) {
        int i = 1;
        this.a = 1;
        this.d = kqVar;
        Integer num = (Integer) ysVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        this.c = num != null && num.intValue() == 2;
        this.g = ch2Var;
        this.h = xv0Var;
        this.f = cq0Var;
        this.e = new rh2(cq0Var, 4);
        this.b = ln4.a(new zq(i, ysVar));
    }
}
