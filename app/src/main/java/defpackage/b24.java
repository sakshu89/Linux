package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b24 extends ud3 {
    public a b;
    public final int c;

    public b24(a aVar, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 1);
        this.b = aVar;
        this.c = i;
    }

    @Override // defpackage.ud3
    public final boolean e(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            int i2 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) i04.a(parcel, Bundle.CREATOR);
            i04.b(parcel);
            jg1.e(this.b, "onPostInitComplete can be called only once per call to getRemoteService");
            a aVar = this.b;
            int i3 = this.c;
            aVar.getClass();
            u54 u54Var = new u54(aVar, i2, strongBinder, bundle);
            wy3 wy3Var = aVar.e;
            wy3Var.sendMessage(wy3Var.obtainMessage(1, i3, -1, u54Var));
            this.b = null;
        } else if (i == 2) {
            parcel.readInt();
            i04.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i4 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            xf4 xf4Var = (xf4) i04.a(parcel, xf4.CREATOR);
            i04.b(parcel);
            a aVar2 = this.b;
            jg1.e(aVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            jg1.d(xf4Var);
            aVar2.u = xf4Var;
            if (aVar2 instanceof ye3) {
                c40 c40Var = xf4Var.e;
                q82 q82VarD = q82.D();
                r82 r82Var = c40Var == null ? null : c40Var.a;
                synchronized (q82VarD) {
                    try {
                        if (r82Var == null) {
                            r82Var = q82.c;
                        } else {
                            r82 r82Var2 = (r82) q82VarD.a;
                            if (r82Var2 == null || r82Var2.a < r82Var.a) {
                            }
                        }
                        q82VarD.a = r82Var;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            Bundle bundle2 = xf4Var.a;
            jg1.e(this.b, "onPostInitComplete can be called only once per call to getRemoteService");
            a aVar3 = this.b;
            int i5 = this.c;
            aVar3.getClass();
            u54 u54Var2 = new u54(aVar3, i4, strongBinder2, bundle2);
            wy3 wy3Var2 = aVar3.e;
            wy3Var2.sendMessage(wy3Var2.obtainMessage(1, i5, -1, u54Var2));
            this.b = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
