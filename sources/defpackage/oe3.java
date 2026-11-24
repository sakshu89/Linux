package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oe3 extends ce3 {
    public final iw2 b;

    public oe3(xc1 xc1Var, iw2 iw2Var) {
        super(4);
        this.b = iw2Var;
    }

    @Override // defpackage.ce3
    public final boolean a(wd3 wd3Var) {
        return false;
    }

    @Override // defpackage.ce3
    public final el0[] b(wd3 wd3Var) {
        return null;
    }

    @Override // defpackage.ce3
    public final void c(Status status) {
        this.b.a(new qe(status));
    }

    @Override // defpackage.ce3
    public final void d(Exception exc) {
        this.b.a(exc);
    }

    @Override // defpackage.ce3
    public final void e(wd3 wd3Var) throws DeadObjectException {
        try {
            h(wd3Var);
        } catch (DeadObjectException e) {
            c(ce3.g(e));
            throw e;
        } catch (RemoteException e2) {
            c(ce3.g(e2));
        } catch (RuntimeException e3) {
            this.b.a(e3);
        }
    }

    public final void h(wd3 wd3Var) {
        this.b.a.g(Boolean.FALSE);
    }

    @Override // defpackage.ce3
    public final /* bridge */ /* synthetic */ void f(cu2 cu2Var, boolean z) {
    }
}
