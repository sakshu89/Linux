package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class on4 extends ov3 {
    public final tj1 b;

    public on4(tj1 tj1Var) {
        super(2);
        this.b = tj1Var;
    }

    @Override // defpackage.ov3
    public final Object c(Object obj) {
        qz2 qz2Var = (qz2) obj;
        ns4 ns4VarB = ps4.b(qz2Var.b());
        Context contextB = this.b.b();
        nu0.b.getClass();
        int i = ru0.c;
        int i2 = 0;
        try {
            i2 = contextB.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
        }
        return new rz2(ns4VarB, (i2 >= 204700000 || qz2Var.a()) ? new a24(contextB, qz2Var, ns4VarB) : new a50(contextB), qz2Var);
    }
}
