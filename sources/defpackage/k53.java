package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k53 implements Runnable {
    public final pi a;
    public final pj b;
    public final int c;
    public final Runnable e;

    public k53(pi piVar, pj pjVar, int i, Runnable runnable) {
        this.a = piVar;
        this.b = pjVar;
        this.c = i;
        this.e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pi piVar = this.a;
        l92 l92Var = (l92) piVar.f;
        pj pjVar = this.b;
        int i = this.c;
        Runnable runnable = this.e;
        try {
            l92 l92Var2 = (l92) piVar.c;
            l92Var2.getClass();
            l92Var.o(new wj1(15, l92Var2));
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ((Context) piVar.a).getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                l92Var.o(new t9(piVar, pjVar, i));
            } else {
                piVar.a(pjVar, i);
            }
        } catch (vu2 unused) {
            ((kf) piVar.d).B(pjVar, i + 1, false);
        } finally {
            runnable.run();
        }
    }
}
