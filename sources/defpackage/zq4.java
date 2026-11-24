package defpackage;

import android.content.Context;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zq4 {
    public static final gy3 b = gy3.a(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    public final String a;

    public zq4(Context context, jk2 jk2Var) {
        new HashMap();
        new HashMap();
        context.getPackageName();
        t00.a(context);
        synchronized (nr4.class) {
            int i = 0;
            if (nr4.b == null) {
                nr4.b = new nr4(i);
            }
        }
        this.a = "common";
        uf1 uf1VarQ = uf1.q();
        vv0 vv0Var = new vv0(2, this);
        uf1VarQ.getClass();
        uf1.y(vv0Var);
        uf1 uf1VarQ2 = uf1.q();
        Objects.requireNonNull(jk2Var);
        kk4 kk4Var = new kk4(jk2Var, 1);
        uf1VarQ2.getClass();
        uf1.y(kk4Var);
        gy3 gy3Var = b;
        if (gy3Var.containsKey("common")) {
            sg0.d(context, (String) gy3Var.get("common"), false);
        }
    }
}
