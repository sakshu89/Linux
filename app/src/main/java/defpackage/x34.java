package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x34 implements ServiceConnection {
    public final int a;
    public final /* synthetic */ a b;

    public x34(a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        a aVar = this.b;
        if (iBinder == null) {
            synchronized (aVar.f) {
                i = aVar.m;
            }
            if (i == 3) {
                aVar.t = true;
                i2 = 5;
            } else {
                i2 = 4;
            }
            wy3 wy3Var = aVar.e;
            wy3Var.sendMessage(wy3Var.obtainMessage(i2, aVar.v.get(), 16));
            return;
        }
        synchronized (aVar.g) {
            try {
                a aVar2 = this.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar2.h = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof hx3)) ? new hx3(iBinder) : (hx3) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        a aVar3 = this.b;
        int i3 = this.a;
        x74 x74Var = new x74(aVar3, 0);
        wy3 wy3Var2 = aVar3.e;
        wy3Var2.sendMessage(wy3Var2.obtainMessage(7, i3, -1, x74Var));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a aVar;
        synchronized (this.b.g) {
            aVar = this.b;
            aVar.h = null;
        }
        int i = this.a;
        wy3 wy3Var = aVar.e;
        wy3Var.sendMessage(wy3Var.obtainMessage(6, i, 1));
    }
}
