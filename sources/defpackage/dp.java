package defpackage;

import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dp {
    public final Context a;
    public final zv1 b;
    public final n21 c;
    public final bd1 d;

    public dp(Context context, zv1 zv1Var, n21 n21Var, bd1 bd1Var) {
        zv1Var.getClass();
        n21Var.getClass();
        bd1Var.getClass();
        this.a = context;
        this.b = zv1Var;
        this.c = n21Var;
        this.d = bd1Var;
    }

    public final boolean a() {
        TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService(TelephonyManager.class);
        return (telephonyManager == null || telephonyManager.getPhoneType() == 0) ? false : true;
    }
}
