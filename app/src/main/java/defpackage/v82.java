package defpackage;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v82 {
    public final w4 a;
    public final Proxy b;
    public final InetSocketAddress c;

    public v82(w4 w4Var, Proxy proxy, InetSocketAddress inetSocketAddress) {
        inetSocketAddress.getClass();
        this.a = w4Var;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v82)) {
            return false;
        }
        v82 v82Var = (v82) obj;
        return v82Var.a.equals(this.a) && v82Var.b.equals(this.b) && g31.a(v82Var.c, this.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.c + '}';
    }
}
