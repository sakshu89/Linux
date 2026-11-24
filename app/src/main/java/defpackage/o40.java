package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o40 implements xm2 {
    public static final n40 a = new n40();

    @Override // defpackage.xm2
    public final String a(SSLSocket sSLSocket) {
        if (c(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.xm2
    public final boolean b() {
        boolean z = m40.d;
        return m40.d;
    }

    @Override // defpackage.xm2
    public final boolean c(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // defpackage.xm2
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        if (c(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            ex1 ex1Var = ex1.a;
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) su0.k(list).toArray(new String[0]));
        }
    }
}
