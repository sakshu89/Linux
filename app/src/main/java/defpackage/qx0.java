package defpackage;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qx0 extends gw2 {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qx0(String str, Object obj, int i) {
        super(str, true);
        this.e = i;
        this.f = obj;
    }

    @Override // defpackage.gw2
    public final long a() {
        int i = 0;
        switch (this.e) {
            case 0:
                tx0 tx0Var = (tx0) this.f;
                tx0Var.getClass();
                try {
                    tx0Var.g0.r(2, 0, false);
                    break;
                } catch (IOException e) {
                    tx0Var.c(2, 2, e);
                }
                return -1L;
            case 1:
                r32 r32Var = (r32) this.f;
                long jNanoTime = System.nanoTime();
                long j = Long.MIN_VALUE;
                q32 q32Var = null;
                int i2 = 0;
                for (q32 q32Var2 : (ConcurrentLinkedQueue) r32Var.e) {
                    q32Var2.getClass();
                    synchronized (q32Var2) {
                        if (r32Var.b(q32Var2, jNanoTime) > 0) {
                            i2++;
                        } else {
                            i++;
                            long j2 = jNanoTime - q32Var2.q;
                            if (j2 > j) {
                                q32Var = q32Var2;
                                j = j2;
                            }
                        }
                    }
                }
                long j3 = r32Var.a;
                if (j < j3 && i <= 5) {
                    if (i > 0) {
                        return j3 - j;
                    }
                    if (i2 > 0) {
                        return j3;
                    }
                    return -1L;
                }
                q32Var.getClass();
                synchronized (q32Var) {
                    if (!q32Var.p.isEmpty()) {
                        return 0L;
                    }
                    if (q32Var.q + j != jNanoTime) {
                        return 0L;
                    }
                    q32Var.j = true;
                    ((ConcurrentLinkedQueue) r32Var.e).remove(q32Var);
                    Socket socket = q32Var.d;
                    socket.getClass();
                    z53.e(socket);
                    if (!((ConcurrentLinkedQueue) r32Var.e).isEmpty()) {
                        return 0L;
                    }
                    ((lw2) r32Var.b).a();
                    return 0L;
                }
            default:
                ((fq0) this.f).a();
                return -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx0(r32 r32Var, String str) {
        super(str, true);
        this.e = 1;
        this.f = r32Var;
    }
}
