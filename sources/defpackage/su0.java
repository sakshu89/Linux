package defpackage;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.media.CamcorderProfile;
import android.util.Log;
import android.view.GestureDetector;
import android.view.ViewConfiguration;
import com.project.sonic.ui.camera.CaptureActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class su0 implements i70, om2, wu3, dg, fg, yp, ks4, p10 {
    public static su0 b;
    public static final su0 c = new su0(1);
    public static final su0 e = new su0(2);
    public static final su0 f = new su0(3);
    public static final /* synthetic */ su0 i = new su0(4);
    public static final su0 j = new su0(5);
    public static final su0 k = new su0(6);
    public static final su0 n = new su0(7);
    public final /* synthetic */ int a;

    public su0(CaptureActivity captureActivity, dk0 dk0Var) {
        this.a = 21;
        ViewConfiguration.get(captureActivity).getScaledTouchSlop();
        new GestureDetector(captureActivity, new nd3(this));
    }

    public static ArrayList k(List list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((y12) obj) != y12.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(nz.d(arrayList));
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            arrayList2.add(((y12) obj2).a);
        }
        return arrayList2;
    }

    public static byte[] l(List list) {
        list.getClass();
        ln lnVar = new ln();
        ArrayList arrayListK = k(list);
        int size = arrayListK.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayListK.get(i2);
            i2++;
            String str = (String) obj;
            lnVar.E(str.length());
            lnVar.N(str);
        }
        return lnVar.r(lnVar.b);
    }

    public static boolean m() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static final uu3 p(Object obj, Object obj2) {
        uu3 uu3Var = (uu3) obj;
        uu3 uu3Var2 = (uu3) obj2;
        if (!uu3Var2.isEmpty()) {
            if (!uu3Var.a) {
                if (uu3Var.isEmpty()) {
                    uu3Var = new uu3();
                } else {
                    uu3 uu3Var3 = new uu3(uu3Var);
                    uu3Var3.a = true;
                    uu3Var = uu3Var3;
                }
            }
            uu3Var.a();
            if (!uu3Var2.isEmpty()) {
                uu3Var.putAll(uu3Var2);
            }
        }
        return uu3Var;
    }

    public static final yd4 q(PackageInfo packageInfo, yd4... yd4VarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zf4 zf4Var = new zf4(packageInfo.signatures[0].toByteArray());
            for (int i2 = 0; i2 < yd4VarArr.length; i2++) {
                if (yd4VarArr[i2].equals(zf4Var)) {
                    return yd4VarArr[i2];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0036  */
    /* JADX WARN: Code duplicated, block: B:24:0x003d  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b A[RETURN] */
    public static final boolean r(PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        boolean z;
        yd4 yd4VarQ;
        if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
                packageInfo2 = packageInfo;
            } else {
                packageInfo2 = packageInfo;
            }
            if (packageInfo != null && packageInfo2.signatures != null) {
                if (z) {
                    yd4VarQ = q(packageInfo2, yj4.a);
                } else {
                    yd4VarQ = q(packageInfo2, yj4.a[0]);
                }
                if (yd4VarQ != null) {
                    return true;
                }
            }
            return false;
        }
        packageInfo2 = null;
        z = true;
        if (packageInfo != null) {
            if (z) {
                yd4VarQ = q(packageInfo2, yj4.a);
            } else {
                yd4VarQ = q(packageInfo2, yj4.a[0]);
            }
            if (yd4VarQ != null) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.dg, defpackage.fg
    public float a() {
        return 0.0f;
    }

    @Override // defpackage.om2
    public boolean b(Object obj, Object obj2) {
        return g31.a(obj, obj2);
    }

    @Override // defpackage.yp
    public CamcorderProfile c(int i2, int i3) {
        return CamcorderProfile.get(i2, i3);
    }

    @Override // defpackage.wu3
    public dv3 d(Class cls) {
        if (!gu3.class.isAssignableFrom(cls)) {
            og.i("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            return (dv3) gu3.l(cls.asSubclass(gu3.class)).i(3, null);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
        }
    }

    @Override // defpackage.yp
    public boolean e(int i2, int i3) {
        return CamcorderProfile.hasProfile(i2, i3);
    }

    @Override // defpackage.ks4
    public Object f(Object obj) {
        ys4 ys4Var = (ys4) obj;
        qw2 qw2Var = new qw2(ys4Var.a, ys4Var.b, ys4Var.c, ys4Var.e, null);
        List arrayList = ys4Var.j;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        jh4.b(arrayList, new nr4(22));
        return qw2Var;
    }

    @Override // defpackage.p10
    public Object g(e72 e72Var) {
        switch (this.a) {
            case 24:
                synchronized (ir4.class) {
                    oq4 oq4Var = new oq4();
                    synchronized (ir4.class) {
                        try {
                            if (ir4.a == null) {
                                ir4.a = new xk4(1);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return new y74(0);
                }
                return new y74(0);
            default:
                return new on4((tj1) e72Var.b(tj1.class));
        }
    }

    @Override // defpackage.dg
    public void h(jc0 jc0Var, int i2, int[] iArr, z61 z61Var, int[] iArr2) {
        if (z61Var == z61.a) {
            jg1.i(i2, iArr, iArr2, false);
        } else {
            jg1.i(i2, iArr, iArr2, true);
        }
    }

    @Override // defpackage.fg
    public void i(int i2, qh1 qh1Var, int[] iArr, int[] iArr2) {
        jg1.i(i2, iArr, iArr2, false);
    }

    @Override // defpackage.wu3
    public boolean j(Class cls) {
        return gu3.class.isAssignableFrom(cls);
    }

    public boolean n(CharSequence charSequence) {
        return false;
    }

    public Object o(Intent intent, int i2) {
        if (i2 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null && stringArrayExtra != null) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i3 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i3 == 0));
                }
                List listO = qg.o(stringArrayExtra);
                Iterator it = ((ArrayList) listO).iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList2 = new ArrayList(Math.min(nz.d(listO), nz.d(arrayList)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList2.add(new wt1(it.next(), it2.next()));
                }
                return bh1.g(arrayList2);
            }
        }
        return ji0.a;
    }

    public String toString() {
        switch (this.a) {
            case 6:
                return "StructuralEqualityPolicy";
            case 9:
                return "Arrangement#SpaceBetween";
            case 11:
                return "CompositionErrorContext";
            default:
                return super.toString();
        }
    }

    public su0(lq lqVar) {
        this.a = 13;
        new CopyOnWriteArrayList();
    }

    public /* synthetic */ su0(int i2) {
        this.a = i2;
    }
}
