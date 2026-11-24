package defpackage;

import android.content.Context;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class el4 {
    public static Context a(Context context) {
        int iF;
        Context applicationContext = context.getApplicationContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 34 && (iF = v2.f(context)) != v2.f(applicationContext)) {
            applicationContext = v2.a(applicationContext, iF);
        }
        if (i >= 30) {
            String strC = e3.c(context);
            if (!Objects.equals(strC, e3.c(applicationContext))) {
                return e3.a(applicationContext, strC);
            }
        }
        return applicationContext;
    }
}
