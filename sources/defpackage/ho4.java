package defpackage;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ho4 {
    public static yv0 a(SSLSession sSLSession) throws IOException {
        List listL;
        List listL2 = ii0.a;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            og.n("cipherSuite == null");
            return null;
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            dk0.h("cipherSuite == ".concat(cipherSuite));
            return null;
        }
        xx xxVarN = xx.b.n(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            og.n("tlsVersion == null");
            return null;
        }
        if ("NONE".equals(protocol)) {
            dk0.h("tlsVersion == NONE");
            return null;
        }
        c13 c13VarB = zc4.b(protocol);
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            listL = peerCertificates != null ? z53.l(Arrays.copyOf(peerCertificates, peerCertificates.length)) : listL2;
        } catch (SSLPeerUnverifiedException unused) {
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listL2 = z53.l(Arrays.copyOf(localCertificates, localCertificates.length));
        }
        return new yv0(c13VarB, xxVarN, listL2, new ta(5, listL));
    }
}
