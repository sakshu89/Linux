package defpackage;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b40 {
    public final List a;
    public int b;
    public boolean c;
    public boolean d;

    public b40(List list) {
        list.getClass();
        this.a = list;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Serializable, java.lang.String[]] */
    public final a40 a(SSLSocket sSLSocket) throws UnknownServiceException {
        a40 a40Var;
        int i;
        boolean z;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        int i2 = this.b;
        List list = this.a;
        int size = list.size();
        while (true) {
            if (i2 >= size) {
                a40Var = null;
                break;
            }
            a40Var = (a40) list.get(i2);
            if (a40Var.b(sSLSocket)) {
                this.b = i2 + 1;
                break;
            }
            i2++;
        }
        if (a40Var == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.d);
            sb.append(", modes=");
            sb.append(list);
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            enabledProtocols2.getClass();
            String string = Arrays.toString(enabledProtocols2);
            string.getClass();
            sb.append(", supported protocols=");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        int i3 = this.b;
        int size2 = list.size();
        while (true) {
            i = 0;
            if (i3 >= size2) {
                z = false;
                break;
            }
            if (((a40) list.get(i3)).b(sSLSocket)) {
                z = true;
                break;
            }
            i3++;
        }
        this.c = z;
        boolean z2 = this.d;
        ?? r0 = a40Var.d;
        String[] strArr = a40Var.c;
        if (strArr != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            enabledCipherSuites2.getClass();
            enabledCipherSuites = z53.p(enabledCipherSuites2, strArr, xx.c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (r0 != 0) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            enabledProtocols3.getClass();
            enabledProtocols = z53.p(enabledProtocols3, r0, bn1.b);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        supportedCipherSuites.getClass();
        lo0 lo0Var = xx.c;
        byte[] bArr = z53.a;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (lo0Var.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i++;
        }
        if (z2 && i != -1) {
            enabledCipherSuites.getClass();
            String str = supportedCipherSuites[i];
            str.getClass();
            enabledCipherSuites = (String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        z30 z30Var = new z30();
        z30Var.a = a40Var.a;
        z30Var.c = strArr;
        z30Var.d = r0;
        z30Var.b = a40Var.b;
        enabledCipherSuites.getClass();
        z30Var.c((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        enabledProtocols.getClass();
        z30Var.f((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        a40 a40VarA = z30Var.a();
        if (a40VarA.c() != null) {
            sSLSocket.setEnabledProtocols(a40VarA.d);
        }
        if (a40VarA.a() != null) {
            sSLSocket.setEnabledCipherSuites(a40VarA.c);
        }
        return a40Var;
    }
}
