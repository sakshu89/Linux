package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sc3 {
    public static final sc3 b;
    public wf a;

    static {
        sc3 sc3Var = new sc3();
        sc3Var.a = null;
        b = sc3Var;
    }

    public static wf a(Context context) {
        wf wfVar;
        sc3 sc3Var = b;
        synchronized (sc3Var) {
            try {
                if (sc3Var.a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    sc3Var.a = new wf(context, false);
                }
                wfVar = sc3Var.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wfVar;
    }
}
