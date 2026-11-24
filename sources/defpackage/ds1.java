package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ds1 {
    public static final el0[] a = new el0[0];
    public static final el0 b;
    public static final gy3 c;

    static {
        el0 el0Var = new el0(1L, "vision.barcode");
        el0 el0Var2 = new el0(1L, "vision.custom.ica");
        el0 el0Var3 = new el0(1L, "vision.face");
        el0 el0Var4 = new el0(1L, "vision.ica");
        el0 el0Var5 = new el0(1L, "vision.ocr");
        b = el0Var5;
        el0 el0Var6 = new el0(1L, "mlkit.langid");
        el0 el0Var7 = new el0(1L, "mlkit.nlclassifier");
        el0 el0Var8 = new el0(1L, "tflite_dynamite");
        el0 el0Var9 = new el0(1L, "mlkit.barcode.ui");
        el0 el0Var10 = new el0(1L, "mlkit.smartreply");
        t9 t9Var = new t9(9);
        t9Var.i("barcode", el0Var);
        t9Var.i("custom_ica", el0Var2);
        t9Var.i("face", el0Var3);
        t9Var.i("ica", el0Var4);
        t9Var.i("ocr", el0Var5);
        t9Var.i("langid", el0Var6);
        t9Var.i("nlclassifier", el0Var7);
        t9Var.i("tflite_dynamite", el0Var8);
        t9Var.i("barcode_ui", el0Var9);
        t9Var.i("smart_reply", el0Var10);
        ox3 ox3Var = (ox3) t9Var.e;
        if (ox3Var != null) {
            throw ox3Var.a();
        }
        gy3 gy3VarA = gy3.a(t9Var.b, (Object[]) t9Var.c, t9Var);
        ox3 ox3Var2 = (ox3) t9Var.e;
        if (ox3Var2 != null) {
            throw ox3Var2.a();
        }
        c = gy3VarA;
        t9 t9Var2 = new t9(9);
        t9Var2.i("com.google.android.gms.vision.barcode", el0Var);
        t9Var2.i("com.google.android.gms.vision.custom.ica", el0Var2);
        t9Var2.i("com.google.android.gms.vision.face", el0Var3);
        t9Var2.i("com.google.android.gms.vision.ica", el0Var4);
        t9Var2.i("com.google.android.gms.vision.ocr", el0Var5);
        t9Var2.i("com.google.android.gms.mlkit.langid", el0Var6);
        t9Var2.i("com.google.android.gms.mlkit.nlclassifier", el0Var7);
        t9Var2.i("com.google.android.gms.tflite_dynamite", el0Var8);
        t9Var2.i("com.google.android.gms.mlkit_smartreply", el0Var10);
        ox3 ox3Var3 = (ox3) t9Var2.e;
        if (ox3Var3 != null) {
            throw ox3Var3.a();
        }
        gy3.a(t9Var2.b, (Object[]) t9Var2.c, t9Var2);
        ox3 ox3Var4 = (ox3) t9Var2.e;
        if (ox3Var4 != null) {
            throw ox3Var4.a();
        }
    }

    public static void a(Context context) {
        int i;
        ex3 ex3Var = lx3.f;
        Object[] objArr = {"ocr"};
        dh4.b(1, objArr);
        vx3 vx3Var = new vx3(1, objArr);
        nu0.b.getClass();
        int i2 = ru0.c;
        try {
            i = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            i = 0;
        }
        if (i < 221500000) {
            Intent intent = new Intent();
            intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
            intent.setAction("com.google.android.gms.vision.DEPENDENCY");
            intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", vx3Var));
            intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
            context.sendBroadcast(intent);
            return;
        }
        int i3 = vx3Var.j;
        el0[] el0VarArr = new el0[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            el0 el0Var = (el0) c.get(vx3Var.get(i4));
            jg1.d(el0Var);
            el0VarArr[i4] = el0Var;
        }
        b(context, el0VarArr);
    }

    public static void b(Context context, final el0[] el0VarArr) {
        et4 et4VarC;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new cs1() { // from class: pm4
            @Override // defpackage.cs1
            public final el0[] c() {
                el0[] el0VarArr2 = ds1.a;
                return el0VarArr;
            }
        });
        if (arrayList.isEmpty()) {
            og.i("APIs must not be empty.");
            return;
        }
        re3 re3Var = new re3(context, re3.j, ie.a, lu0.b);
        TreeSet treeSet = new TreeSet(lo0.j);
        int size = arrayList.size();
        boolean z = false;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Collections.addAll(treeSet, ((cs1) obj).c());
        }
        re reVar = new re(new ArrayList(treeSet), true, null, null);
        if (reVar.a.isEmpty()) {
            lk1 lk1Var = new lk1(0, false);
            et4VarC = new et4();
            et4VarC.e(lk1Var);
        } else {
            py0 py0Var = new py0(17, z);
            el0[] el0VarArr2 = {ob4.a};
            py0Var.b = new wj1(re3Var, reVar);
            et4VarC = re3Var.c(0, new kk(py0Var, el0VarArr2, true, 27304));
        }
        qs4 qs4Var = new qs4(24);
        et4VarC.getClass();
        et4VarC.b.o(new xd4(jw2.a, qs4Var));
        et4VarC.i();
    }
}
