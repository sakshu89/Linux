package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u54 extends bx3 {
    public final IBinder g;
    public final /* synthetic */ a h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u54(a aVar, int i, IBinder iBinder, Bundle bundle) {
        super(aVar, i, bundle);
        this.h = aVar;
        this.g = iBinder;
    }

    @Override // defpackage.bx3
    public final void a(x30 x30Var) {
        wj1 wj1Var = this.h.o;
        if (wj1Var != null) {
            ((pu0) wj1Var.b).b(x30Var);
        }
        System.currentTimeMillis();
    }

    @Override // defpackage.bx3
    public final boolean b() {
        IBinder iBinder = this.g;
        try {
            jg1.d(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            a aVar = this.h;
            if (!aVar.q().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + aVar.q() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceL = aVar.l(iBinder);
            if (iInterfaceL == null || !(a.t(aVar, 2, 4, iInterfaceL) || a.t(aVar, 3, 4, iInterfaceL))) {
                return false;
            }
            aVar.s = null;
            py0 py0Var = aVar.n;
            if (py0Var == null) {
                return true;
            }
            ((ou0) py0Var.b).c();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
