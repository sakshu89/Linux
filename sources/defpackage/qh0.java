package defpackage;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qh0 extends cn4 {
    public final /* synthetic */ cn4 a;
    public final /* synthetic */ ThreadPoolExecutor b;

    public qh0(cn4 cn4Var, ThreadPoolExecutor threadPoolExecutor) {
        this.a = cn4Var;
        this.b = threadPoolExecutor;
    }

    @Override // defpackage.cn4
    public final void a(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.b;
        try {
            this.a.a(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // defpackage.cn4
    public final void b(p6 p6Var) {
        ThreadPoolExecutor threadPoolExecutor = this.b;
        try {
            this.a.b(p6Var);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
