package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tb0 implements xm2 {
    public final sb0 a;
    public xm2 b;

    public tb0(sb0 sb0Var) {
        this.a = sb0Var;
    }

    @Override // defpackage.xm2
    public final String a(SSLSocket sSLSocket) {
        xm2 xm2VarE = e(sSLSocket);
        if (xm2VarE != null) {
            return xm2VarE.a(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.xm2
    public final boolean b() {
        return true;
    }

    @Override // defpackage.xm2
    public final boolean c(SSLSocket sSLSocket) {
        return this.a.c(sSLSocket);
    }

    @Override // defpackage.xm2
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        xm2 xm2VarE = e(sSLSocket);
        if (xm2VarE != null) {
            xm2VarE.d(sSLSocket, str, list);
        }
    }

    public final synchronized xm2 e(SSLSocket sSLSocket) {
        try {
            if (this.b == null && this.a.c(sSLSocket)) {
                this.b = this.a.g(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }
}
