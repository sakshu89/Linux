package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zt {
    public final l11 a;
    public final ArrayMap b = new ArrayMap(4);

    public zt(l11 l11Var) {
        this.a = l11Var;
    }

    public static zt a(Context context, Handler handler) {
        l11 auVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            auVar = new cu(context, null);
        } else if (i >= 29) {
            auVar = new bu(context, null);
        } else {
            auVar = i >= 28 ? new au(context, null) : new l11(context, new du(handler));
        }
        return new zt(auVar);
    }

    public final ys b(String str) {
        ys ysVar;
        synchronized (this.b) {
            ysVar = (ys) this.b.get(str);
            if (ysVar == null) {
                try {
                    ys ysVar2 = new ys(this.a.v(str), str);
                    this.b.put(str, ysVar2);
                    ysVar = ysVar2;
                } catch (AssertionError e) {
                    throw new ds(e.getMessage(), e);
                }
            }
        }
        return ysVar;
    }
}
