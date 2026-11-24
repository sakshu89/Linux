package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wf4 {
    public static Object a(String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 34) {
            return f3.c(str, bundle);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (b4.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static boolean b(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }
}
