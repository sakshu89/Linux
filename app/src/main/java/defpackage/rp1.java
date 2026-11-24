package defpackage;

import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rp1 implements Cloneable {
    public static final List l0 = z53.l(y12.HTTP_2, y12.HTTP_1_1);
    public static final List m0 = z53.l(a40.e, a40.f);
    public final X509TrustManager H;
    public final List X;
    public final List Y;
    public final pp1 Z;
    public final p6 a;
    public final uf1 b;
    public final List c;
    public final ww c0;
    public final jh4 d0;
    public final List e;
    public final int e0;
    public final kf2 f;
    public final int f0;
    public final int g0;
    public final int h0;
    public final boolean i;
    public final int i0;
    public final ak1 j;
    public final long j0;
    public final boolean k;
    public final py0 k0;
    public final boolean n;
    public final su0 s;
    public final el1 t;
    public final ProxySelector u;
    public final ak1 v;
    public final SocketFactory w;
    public final SSLSocketFactory x;

    public rp1(qp1 qp1Var) throws NoSuchAlgorithmException, KeyStoreException {
        this.a = qp1Var.a;
        this.b = qp1Var.b;
        this.c = z53.x(qp1Var.c);
        this.e = z53.x(qp1Var.d);
        this.f = qp1Var.e;
        this.i = qp1Var.f;
        this.j = qp1Var.g;
        this.k = qp1Var.h;
        this.n = qp1Var.i;
        this.s = qp1Var.j;
        this.t = qp1Var.k;
        ProxySelector proxySelector = qp1Var.l;
        proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
        this.u = proxySelector == null ? so1.a : proxySelector;
        this.v = qp1Var.m;
        this.w = qp1Var.n;
        List list = qp1Var.q;
        this.X = list;
        this.Y = qp1Var.r;
        this.Z = qp1Var.s;
        this.e0 = qp1Var.v;
        this.f0 = qp1Var.w;
        this.g0 = qp1Var.x;
        this.h0 = qp1Var.y;
        this.i0 = qp1Var.z;
        this.j0 = qp1Var.A;
        py0 py0Var = qp1Var.B;
        this.k0 = py0Var == null ? new py0(12) : py0Var;
        if (list != null && list.isEmpty()) {
            this.x = null;
            this.d0 = null;
            this.H = null;
            this.c0 = ww.c;
            break;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.x = null;
                this.d0 = null;
                this.H = null;
                this.c0 = ww.c;
                break;
            }
            if (((a40) it.next()).a) {
                SSLSocketFactory sSLSocketFactory = qp1Var.o;
                if (sSLSocketFactory == null) {
                    ex1 ex1Var = ex1.a;
                    X509TrustManager x509TrustManagerM = ex1.a.m();
                    this.H = x509TrustManagerM;
                    this.x = ex1.a.l(x509TrustManagerM);
                    jh4 jh4VarB = ex1.a.b(x509TrustManagerM);
                    this.d0 = jh4VarB;
                    ww wwVar = qp1Var.t;
                    wwVar.getClass();
                    this.c0 = g31.a(wwVar.b, jh4VarB) ? wwVar : new ww(wwVar.a, jh4VarB);
                    break;
                }
                this.x = sSLSocketFactory;
                jh4 jh4Var = qp1Var.u;
                jh4Var.getClass();
                this.d0 = jh4Var;
                X509TrustManager x509TrustManager = qp1Var.p;
                x509TrustManager.getClass();
                this.H = x509TrustManager;
                ww wwVar2 = qp1Var.t;
                wwVar2.getClass();
                this.c0 = g31.a(wwVar2.b, jh4Var) ? wwVar2 : new ww(wwVar2.a, jh4Var);
                break;
            }
        }
        X509TrustManager x509TrustManager2 = this.H;
        jh4 jh4Var2 = this.d0;
        SSLSocketFactory sSLSocketFactory2 = this.x;
        List list2 = this.e;
        List list3 = this.c;
        list3.getClass();
        if (list3.contains(null)) {
            dk0.u(list3, "Null interceptor: ");
            throw null;
        }
        list2.getClass();
        if (list2.contains(null)) {
            dk0.u(list2, "Null network interceptor: ");
            throw null;
        }
        List list4 = this.X;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((a40) it2.next()).a) {
                    if (sSLSocketFactory2 == null) {
                        og.n("sslSocketFactory == null");
                        throw null;
                    }
                    if (jh4Var2 == null) {
                        og.n("certificateChainCleaner == null");
                        throw null;
                    }
                    if (x509TrustManager2 != null) {
                        return;
                    }
                    og.n("x509TrustManager == null");
                    throw null;
                }
            }
        }
        if (sSLSocketFactory2 != null) {
            og.n("Check failed.");
            throw null;
        }
        if (jh4Var2 != null) {
            og.n("Check failed.");
            throw null;
        }
        if (x509TrustManager2 != null) {
            og.n("Check failed.");
            throw null;
        }
        if (g31.a(this.c0, ww.c)) {
            return;
        }
        og.n("Check failed.");
        throw null;
    }

    public final Object clone() {
        return super.clone();
    }
}
