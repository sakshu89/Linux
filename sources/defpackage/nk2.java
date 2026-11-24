package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nk2 extends a {
    public final Bundle A;
    public final Integer B;
    public final boolean y;
    public final lj1 z;

    public nk2(Context context, Looper looper, lj1 lj1Var, Bundle bundle, ou0 ou0Var, pu0 pu0Var) {
        super(context, looper, 44, lj1Var, ou0Var, pu0Var);
        this.y = true;
        this.z = lj1Var;
        this.A = bundle;
        this.B = (Integer) lj1Var.g;
    }

    @Override // defpackage.je
    public final int c() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.a, defpackage.je
    public final boolean j() {
        return this.y;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof le3 ? (le3) iInterfaceQueryLocalInterface : new le3(iBinder, "com.google.android.gms.signin.internal.ISignInService", 0);
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle o() {
        lj1 lj1Var = this.z;
        boolean zEquals = this.c.getPackageName().equals((String) lj1Var.d);
        Bundle bundle = this.A;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) lj1Var.d);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String q() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String r() {
        return "com.google.android.gms.signin.service.START";
    }
}
