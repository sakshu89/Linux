package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jy3 implements dr0 {
    public static final gb a = new gb(1);

    public static final void a(List list, int i, int i2) {
        int iD = d(i, list);
        if (iD < 0) {
            iD = -(iD + 1);
        }
        while (iD < list.size() && ((r31) list.get(iD)).b < i2) {
        }
    }

    public static i22 b(Context context, Bundle bundle) {
        boolean z = bundle.getBoolean("androidx.camera.core.quirks.DEFAULT_QUIRK_ENABLED", true);
        String[] strArrE = e(context, bundle, "androidx.camera.core.quirks.FORCE_ENABLED");
        String[] strArrE2 = e(context, bundle, "androidx.camera.core.quirks.FORCE_DISABLED");
        xq4.c(3, "QuirkSettingsLoader");
        xq4.c(3, "QuirkSettingsLoader");
        Arrays.toString(strArrE);
        xq4.c(3, "QuirkSettingsLoader");
        Arrays.toString(strArrE2);
        xq4.c(3, "QuirkSettingsLoader");
        return new i22(z, new HashSet(g(strArrE)), new HashSet(g(strArrE2)));
    }

    public static final void c(nl2 nl2Var, ArrayList arrayList, int i) {
        boolean zL = nl2Var.l(i);
        int[] iArr = nl2Var.b;
        if (zL) {
            arrayList.add(nl2Var.n(i));
            return;
        }
        int i2 = iArr[(i * 5) + 3] + i;
        for (int i3 = i + 1; i3 < i2; i3 += iArr[(i3 * 5) + 3]) {
            c(nl2Var, arrayList, i3);
        }
    }

    public static final int d(int i, List list) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int iB = g31.b(((r31) list.get(i3)).b, i);
            if (iB < 0) {
                i2 = i3 + 1;
            } else {
                if (iB <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static String[] e(Context context, Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            return new String[0];
        }
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            xq4.d("QuirkSettingsLoader", "Resource ID not found for key: ".concat(str));
            return new String[0];
        }
        try {
            return context.getResources().getStringArray(i);
        } catch (Resources.NotFoundException e) {
            xq4.e("QuirkSettingsLoader", "Quirk class names resource not found: " + i, e);
            return new String[0];
        }
    }

    public static final void f(rl2 rl2Var, int i, Object obj) {
        int iH = rl2Var.h(i);
        Object[] objArr = rl2Var.c;
        Object obj2 = objArr[iH];
        objArr[iH] = r20.a;
        if (obj == obj2) {
            return;
        }
        y20.a("Slot table is out of sync (expected " + obj + ", got " + obj2 + ')');
    }

    public static HashSet g(String[] strArr) {
        Class<?> cls;
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            try {
                cls = Class.forName(str);
                if (!h22.class.isAssignableFrom(cls)) {
                    xq4.d("QuirkSettingsLoader", str + " does not implement the Quirk interface.");
                    cls = null;
                }
            } catch (ClassNotFoundException e) {
                xq4.e("QuirkSettingsLoader", "Class not found: " + str, e);
            }
            if (cls != null) {
                hashSet.add(cls);
            }
        }
        return hashSet;
    }
}
