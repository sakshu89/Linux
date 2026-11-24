package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m10 {
    public final LinkedHashMap a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final ArrayList d = new ArrayList();
    public final transient LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final Bundle g = new Bundle();
    public final /* synthetic */ n10 h;

    public m10(n10 n10Var) {
        this.h = n10Var;
    }

    public final boolean a(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        f4 f4Var = (f4) this.e.get(str);
        if ((f4Var != null ? f4Var.a : null) != null) {
            ArrayList arrayList = this.d;
            if (arrayList.contains(str)) {
                f4Var.a.a(f4Var.b.o(intent, i2));
                arrayList.remove(str);
                return true;
            }
        }
        this.f.remove(str);
        this.g.putParcelable(str, new b4(intent, i2));
        return true;
    }

    public final void b(int i, su0 su0Var, Object obj) {
        c4 c4Var;
        int i2;
        String[] strArr = (String[]) obj;
        strArr.getClass();
        int length = strArr.length;
        Bundle bundleExtra = null;
        n10 n10Var = this.h;
        if (length != 0) {
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    int iB = bh1.b(strArr.length);
                    if (iB < 16) {
                        iB = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iB);
                    for (String str : strArr) {
                        linkedHashMap.put(str, Boolean.TRUE);
                    }
                    c4Var = new c4(linkedHashMap);
                    break;
                }
                if (al4.a(n10Var, strArr[i3]) != 0) {
                    c4Var = null;
                    break;
                }
                i3++;
            }
        } else {
            c4Var = new c4(ji0.a);
        }
        if (c4Var != null) {
            new Handler(Looper.getMainLooper()).post(new gq(i, 4, this, c4Var));
            return;
        }
        strArr.getClass();
        Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        intentPutExtra.getClass();
        if (intentPutExtra.getExtras() != null) {
            Bundle extras = intentPutExtra.getExtras();
            extras.getClass();
            if (extras.getClassLoader() == null) {
                intentPutExtra.setExtrasClassLoader(n10Var.getClassLoader());
            }
        }
        if (intentPutExtra.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentPutExtra.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentPutExtra.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        }
        Bundle bundle = bundleExtra;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentPutExtra.getAction())) {
            String[] stringArrayExtra = intentPutExtra.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < stringArrayExtra.length; i4++) {
                if (TextUtils.isEmpty(stringArrayExtra[i4])) {
                    og.i(cq.n(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                    return;
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[i4], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i4));
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < stringArrayExtra.length; i6++) {
                    if (!hashSet.contains(Integer.valueOf(i6))) {
                        strArr2[i5] = stringArrayExtra[i6];
                        i5++;
                    }
                }
            }
            n10Var.requestPermissions(stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentPutExtra.getAction())) {
            n10Var.startActivityForResult(intentPutExtra, i, bundle);
            return;
        }
        p21 p21Var = (p21) intentPutExtra.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            p21Var.getClass();
            i2 = i;
            try {
                n10Var.startIntentSenderForResult(p21Var.a, i2, p21Var.b, p21Var.c, p21Var.e, 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new gq(i2, 5, this, e));
            }
        } catch (IntentSender.SendIntentException e2) {
            e = e2;
            i2 = i;
        }
    }
}
