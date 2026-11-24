package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tv0 extends l70 implements vb0 {
    public final Handler c;
    public final String e;
    public final boolean f;
    public final tv0 i;

    public tv0(Handler handler, String str, boolean z) {
        this.c = handler;
        this.e = str;
        this.f = z;
        this.i = z ? this : new tv0(handler, str, true);
    }

    @Override // defpackage.vb0
    public final rd0 A(long j, final Runnable runnable, j70 j70Var) {
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.c.postDelayed(runnable, j)) {
            return new rd0() { // from class: sv0
                @Override // defpackage.rd0
                public final void a() {
                    this.a.c.removeCallbacks(runnable);
                }
            };
        }
        P(j70Var, runnable);
        return jo1.a;
    }

    @Override // defpackage.l70
    public final void L(j70 j70Var, Runnable runnable) {
        if (this.c.post(runnable)) {
            return;
        }
        P(j70Var, runnable);
    }

    @Override // defpackage.l70
    public final boolean N(j70 j70Var) {
        return (this.f && g31.a(Looper.myLooper(), this.c.getLooper())) ? false : true;
    }

    public final void P(j70 j70Var, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        f41 f41Var = (f41) j70Var.v(nr4.k);
        if (f41Var != null) {
            f41Var.e(cancellationException);
        }
        xa0 xa0Var = ld0.a;
        qa0.c.L(j70Var, runnable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof tv0)) {
            return false;
        }
        tv0 tv0Var = (tv0) obj;
        return tv0Var.c == this.c && tv0Var.f == this.f;
    }

    public final int hashCode() {
        return (this.f ? 1231 : 1237) ^ System.identityHashCode(this.c);
    }

    @Override // defpackage.vb0
    public final void o(long j, yv yvVar) {
        o8 o8Var = new o8(19, yvVar, this);
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.c.postDelayed(o8Var, j)) {
            yvVar.z(new o0(8, this, o8Var));
        } else {
            P(yvVar.f, o8Var);
        }
    }

    @Override // defpackage.l70
    public final String toString() {
        tv0 tv0Var;
        String str;
        xa0 xa0Var = ld0.a;
        tv0 tv0Var2 = ig1.a;
        if (this == tv0Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                tv0Var = tv0Var2.i;
            } catch (UnsupportedOperationException unused) {
                tv0Var = null;
            }
            str = this == tv0Var ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.e;
        if (string == null) {
            string = this.c.toString();
        }
        return this.f ? ky0.j(string, ".immediate") : string;
    }

    public tv0(Handler handler) {
        this(handler, null, false);
    }
}
