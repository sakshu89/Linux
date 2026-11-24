package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xd4 {
    public final Executor b;
    public final Object d;
    public final /* synthetic */ int a = 0;
    public final Object c = new Object();

    public xd4(Executor executor, cq1 cq1Var) {
        this.b = executor;
        this.d = cq1Var;
    }

    public final void a(et4 et4Var) {
        boolean z = false;
        switch (this.a) {
            case 0:
                synchronized (this.c) {
                    break;
                }
                this.b.execute(new or0(13, this, et4Var, z));
                return;
            case 1:
                if (et4Var.c() || et4Var.d) {
                    return;
                }
                synchronized (this.c) {
                    break;
                }
                this.b.execute(new or0(14, this, et4Var, z));
                return;
            default:
                if (et4Var.c()) {
                    synchronized (this.c) {
                        break;
                    }
                    this.b.execute(new or0(16, this, et4Var, z));
                    return;
                }
                return;
        }
    }

    public xd4(Executor executor, eq1 eq1Var) {
        this.b = executor;
        this.d = eq1Var;
    }

    public xd4(Executor executor, kq1 kq1Var) {
        this.b = executor;
        this.d = kq1Var;
    }
}
