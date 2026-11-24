package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ne3 extends ce3 {
    public final kk b;
    public final iw2 c;
    public final nr4 d;

    public ne3(int i, kk kkVar, iw2 iw2Var, nr4 nr4Var) {
        super(i);
        this.c = iw2Var;
        this.b = kkVar;
        this.d = nr4Var;
        if (i == 2 && kkVar.c) {
            og.i("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
            throw null;
        }
    }

    @Override // defpackage.ce3
    public final boolean a(wd3 wd3Var) {
        return this.b.c;
    }

    @Override // defpackage.ce3
    public final el0[] b(wd3 wd3Var) {
        return (el0[]) this.b.d;
    }

    @Override // defpackage.ce3
    public final void c(Status status) {
        this.d.getClass();
        this.c.a(status.c != null ? new n62(status) : new qe(status));
    }

    @Override // defpackage.ce3
    public final void d(Exception exc) {
        this.c.a(exc);
    }

    @Override // defpackage.ce3
    public final void e(wd3 wd3Var) throws DeadObjectException {
        iw2 iw2Var = this.c;
        try {
            kk kkVar = this.b;
            ((o52) ((py0) kkVar.e).b).accept(wd3Var.b, iw2Var);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            c(ce3.g(e2));
        } catch (RuntimeException e3) {
            iw2Var.a(e3);
        }
    }

    @Override // defpackage.ce3
    public final void f(cu2 cu2Var, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Map map = (Map) cu2Var.c;
        iw2 iw2Var = this.c;
        map.put(iw2Var, boolValueOf);
        et4 et4Var = iw2Var.a;
        cu2 cu2Var2 = new cu2(10, cu2Var, iw2Var, false);
        et4Var.getClass();
        et4Var.b.o(new xd4(jw2.a, cu2Var2));
        et4Var.i();
    }
}
