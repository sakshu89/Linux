package defpackage;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n40 implements sb0 {
    @Override // defpackage.sb0
    public final boolean c(SSLSocket sSLSocket) {
        return m40.d && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // defpackage.sb0
    public final xm2 g(SSLSocket sSLSocket) {
        return new o40();
    }
}
