package defpackage;

import java.io.IOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rx0 extends gw2 {
    public final /* synthetic */ int e;
    public final /* synthetic */ long f;
    public final /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rx0(String str, Object obj, long j, int i) {
        super(str, true);
        this.e = i;
        this.g = obj;
        this.f = j;
    }

    @Override // defpackage.gw2
    public final long a() {
        tx0 tx0Var;
        boolean z;
        x93 x93Var;
        switch (this.e) {
            case 0:
                synchronized (((tx0) this.g)) {
                    tx0Var = (tx0) this.g;
                    long j = tx0Var.v;
                    long j2 = tx0Var.u;
                    if (j < j2) {
                        z = true;
                    } else {
                        tx0Var.u = j2 + 1;
                        z = false;
                    }
                }
                if (z) {
                    tx0Var.c(2, 2, null);
                    return -1L;
                }
                try {
                    tx0Var.g0.r(1, 0, false);
                    break;
                } catch (IOException e) {
                    tx0Var.c(2, 2, e);
                }
                return this.f;
            default:
                x32 x32Var = (x32) this.g;
                synchronized (x32Var) {
                    try {
                        if (!x32Var.t && (x93Var = x32Var.j) != null) {
                            int i = x32Var.v ? x32Var.u : -1;
                            x32Var.u++;
                            x32Var.v = true;
                            if (i != -1) {
                                x32Var.c(new SocketTimeoutException("sent ping but didn't receive pong within " + x32Var.c + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
                            } else {
                                try {
                                    oo ooVar = oo.e;
                                    ooVar.getClass();
                                    x93Var.c(9, ooVar);
                                } catch (IOException e2) {
                                    x32Var.c(e2, null);
                                }
                            }
                            break;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return this.f;
        }
    }
}
