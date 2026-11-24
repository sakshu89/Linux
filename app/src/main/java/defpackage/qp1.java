package defpackage;

import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qp1 {
    public long A;
    public py0 B;
    public p6 a = new p6(3);
    public uf1 b = new uf1(13);
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public kf2 e = new kf2(9);
    public boolean f = true;
    public ak1 g;
    public boolean h;
    public boolean i;
    public su0 j;
    public el1 k;
    public ProxySelector l;
    public ak1 m;
    public SocketFactory n;
    public SSLSocketFactory o;
    public X509TrustManager p;
    public List q;
    public List r;
    public pp1 s;
    public ww t;
    public jh4 u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public qp1() {
        ak1 ak1Var = ak1.b;
        this.g = ak1Var;
        this.h = true;
        this.i = true;
        this.j = su0.e;
        this.k = el1.c;
        this.m = ak1Var;
        SocketFactory socketFactory = SocketFactory.getDefault();
        socketFactory.getClass();
        this.n = socketFactory;
        this.q = rp1.m0;
        this.r = rp1.l0;
        this.s = pp1.a;
        this.t = ww.c;
        this.w = 10000;
        this.x = 10000;
        this.y = 10000;
        this.A = 1024L;
    }
}
