package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ce3 {
    public final int a;

    public ce3(int i) {
        this.a = i;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(wd3 wd3Var);

    public abstract el0[] b(wd3 wd3Var);

    public abstract void c(Status status);

    public abstract void d(Exception exc);

    public abstract void e(wd3 wd3Var);

    public abstract void f(cu2 cu2Var, boolean z);
}
