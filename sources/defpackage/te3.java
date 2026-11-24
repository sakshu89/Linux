package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.a;
import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class te3 extends a {
    public final pw2 y;

    public te3(Context context, Looper looper, lj1 lj1Var, pw2 pw2Var, wd3 wd3Var, wd3 wd3Var2) {
        super(context, looper, UCharacter.UnicodeBlock.NEWA_ID, lj1Var, wd3Var, wd3Var2);
        this.y = pw2Var;
    }

    @Override // defpackage.je
    public final int c() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof pe3 ? (pe3) iInterfaceQueryLocalInterface : new pe3(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 0);
    }

    @Override // com.google.android.gms.common.internal.a
    public final el0[] n() {
        return mb4.b;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle o() {
        pw2 pw2Var = this.y;
        pw2Var.getClass();
        Bundle bundle = new Bundle();
        String str = pw2Var.b;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String q() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String r() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean s() {
        return true;
    }
}
