package defpackage;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sq1 extends ex1 {
    public static final boolean d;
    public final Provider c = new OpenJSSE();

    static {
        boolean z = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, rq1.class.getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        d = z;
    }

    @Override // defpackage.ex1
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
    }

    @Override // defpackage.ex1
    public final String f(SSLSocket sSLSocket) {
        return null;
    }

    @Override // defpackage.ex1
    public final SSLContext k() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.c);
        sSLContext.getClass();
        return sSLContext;
    }

    @Override // defpackage.ex1
    public final X509TrustManager m() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.c);
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        trustManagers.getClass();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                trustManager.getClass();
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        string.getClass();
        kf2.e("Unexpected default trust managers: ".concat(string));
        return null;
    }
}
