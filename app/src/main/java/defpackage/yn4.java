package defpackage;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yn4 {
    public static final ro0 a(Context context) {
        ak1 ak1Var = new ak1(8);
        context.getApplicationContext();
        return new ro0(ak1Var, new l9(Build.VERSION.SDK_INT >= 31 ? op0.a.a(context) : 0));
    }
}
