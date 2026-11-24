package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cm implements xm2 {
    public static final bm a = new bm();

    @Override // defpackage.xm2
    public final String a(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // defpackage.xm2
    public final boolean b() {
        boolean z = am.d;
        return am.d;
    }

    @Override // defpackage.xm2
    public final boolean c(SSLSocket sSLSocket) {
        return false;
    }

    @Override // defpackage.xm2
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        if (c(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            ex1 ex1Var = ex1.a;
            parameters.setApplicationProtocols((String[]) su0.k(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
