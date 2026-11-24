package defpackage;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w4 {
    public final el1 a;
    public final SocketFactory b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final ww e;
    public final ak1 f;
    public final ProxySelector g;
    public final ey0 h;
    public final List i;
    public final List j;

    public w4(String str, int i, el1 el1Var, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ww wwVar, ak1 ak1Var, List list, List list2, ProxySelector proxySelector) {
        str.getClass();
        el1Var.getClass();
        socketFactory.getClass();
        ak1Var.getClass();
        list.getClass();
        list2.getClass();
        proxySelector.getClass();
        this.a = el1Var;
        this.b = socketFactory;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.e = wwVar;
        this.f = ak1Var;
        this.g = proxySelector;
        dy0 dy0Var = new dy0();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            dy0Var.a = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                og.i("unexpected scheme: ".concat(str2));
                throw null;
            }
            dy0Var.a = "https";
        }
        String strB = no4.b(fl4.e(0, 0, 7, str));
        if (strB == null) {
            og.i("unexpected host: ".concat(str));
            throw null;
        }
        dy0Var.d = strB;
        if (1 > i || i >= 65536) {
            og.g(ky0.h(i, "unexpected port: "));
            throw null;
        }
        dy0Var.e = i;
        this.h = dy0Var.b();
        this.i = z53.x(list);
        this.j = z53.x(list2);
    }

    public final boolean a(w4 w4Var) {
        w4Var.getClass();
        return g31.a(this.a, w4Var.a) && g31.a(this.f, w4Var.f) && g31.a(this.i, w4Var.i) && g31.a(this.j, w4Var.j) && g31.a(this.g, w4Var.g) && g31.a(this.c, w4Var.c) && g31.a(this.d, w4Var.d) && g31.a(this.e, w4Var.e) && this.h.e == w4Var.h.e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof w4)) {
            return false;
        }
        w4 w4Var = (w4) obj;
        return g31.a(this.h, w4Var.h) && a(w4Var);
    }

    public final int hashCode() {
        return Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((this.g.hashCode() + ((this.j.hashCode() + ((this.i.hashCode() + ((this.f.hashCode() + ((this.a.hashCode() + ky0.d(527, 31, this.h.h)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        ey0 ey0Var = this.h;
        sb.append(ey0Var.d);
        sb.append(':');
        sb.append(ey0Var.e);
        sb.append(", ");
        sb.append("proxySelector=" + this.g);
        sb.append('}');
        return sb.toString();
    }
}
