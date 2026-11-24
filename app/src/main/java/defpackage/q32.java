package defpackage;

import com.ibm.icu.text.DateTimePatternGenerator;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q32 extends kx0 {
    public final v82 b;
    public Socket c;
    public Socket d;
    public yv0 e;
    public y12 f;
    public tx0 g;
    public i32 h;
    public h32 i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final ArrayList p;
    public long q;

    public q32(r32 r32Var, v82 v82Var) {
        r32Var.getClass();
        v82Var.getClass();
        this.b = v82Var;
        this.o = 1;
        this.p = new ArrayList();
        this.q = Long.MAX_VALUE;
    }

    public static void d(rp1 rp1Var, v82 v82Var, IOException iOException) {
        v82Var.getClass();
        iOException.getClass();
        if (v82Var.b.type() != Proxy.Type.DIRECT) {
            w4 w4Var = v82Var.a;
            w4Var.g.connectFailed(w4Var.h.h(), v82Var.b.address(), iOException);
        }
        py0 py0Var = rp1Var.k0;
        synchronized (py0Var) {
            ((LinkedHashSet) py0Var.b).add(v82Var);
        }
    }

    @Override // defpackage.kx0
    public final synchronized void a(tx0 tx0Var, yh2 yh2Var) {
        yh2Var.getClass();
        this.o = (yh2Var.a & 16) != 0 ? yh2Var.b[4] : Integer.MAX_VALUE;
    }

    @Override // defpackage.kx0
    public final void b(ay0 ay0Var) {
        ay0Var.c(8, null);
    }

    public final void c(int i, int i2, int i3, int i4, boolean z, m32 m32Var) throws Throwable {
        if (this.f != null) {
            og.n("already connected");
            return;
        }
        List list = this.b.a.j;
        b40 b40Var = new b40(list);
        w4 w4Var = this.b.a;
        if (w4Var.c == null) {
            if (!list.contains(a40.f)) {
                throw new w82(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.b.a.h.d;
            ex1 ex1Var = ex1.a;
            if (!ex1.a.h(str)) {
                throw new w82(new UnknownServiceException(cq.v("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (w4Var.i.contains(y12.H2_PRIOR_KNOWLEDGE)) {
            throw new w82(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        w82 w82Var = null;
        while (true) {
            try {
                v82 v82Var = this.b;
                if (v82Var.a.c != null && v82Var.b.type() == Proxy.Type.HTTP) {
                    f(i, i2, i3, m32Var);
                    if (this.c != null) {
                        break;
                    } else {
                        break;
                    }
                }
                e(i, i2, m32Var);
                g(b40Var, i4, m32Var);
                this.b.c.getClass();
                break;
            } catch (IOException e) {
                Socket socket = this.d;
                if (socket != null) {
                    z53.e(socket);
                }
                Socket socket2 = this.c;
                if (socket2 != null) {
                    z53.e(socket2);
                }
                this.d = null;
                this.c = null;
                this.h = null;
                this.i = null;
                this.e = null;
                this.f = null;
                this.g = null;
                this.o = 1;
                this.b.c.getClass();
                if (w82Var == null) {
                    w82Var = new w82(e);
                } else {
                    gn4.a(w82Var.a, e);
                    w82Var.b = e;
                }
                if (!z) {
                    throw w82Var;
                }
                b40Var.d = true;
                if (!b40Var.c) {
                    throw w82Var;
                }
                if (e instanceof ProtocolException) {
                    throw w82Var;
                }
                if (e instanceof InterruptedIOException) {
                    throw w82Var;
                }
                if ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) {
                    throw w82Var;
                }
                if (e instanceof SSLPeerUnverifiedException) {
                    throw w82Var;
                }
                if (!(e instanceof SSLException)) {
                    throw w82Var;
                }
            }
        }
        v82 v82Var2 = this.b;
        if (v82Var2.a.c != null && v82Var2.b.type() == Proxy.Type.HTTP && this.c == null) {
            throw new w82(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.q = System.nanoTime();
    }

    public final void e(int i, int i2, m32 m32Var) throws IOException {
        Socket socketCreateSocket;
        v82 v82Var = this.b;
        Proxy proxy = v82Var.b;
        w4 w4Var = v82Var.a;
        Proxy.Type type = proxy.type();
        int i3 = type == null ? -1 : n32.a[type.ordinal()];
        int i4 = 1;
        if (i3 == 1 || i3 == 2) {
            socketCreateSocket = w4Var.b.createSocket();
            socketCreateSocket.getClass();
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.c = socketCreateSocket;
        this.b.c.getClass();
        socketCreateSocket.setSoTimeout(i2);
        try {
            ex1 ex1Var = ex1.a;
            ex1.a.e(socketCreateSocket, this.b.c, i);
            try {
                Logger logger = sp1.a;
                ym2 ym2Var = new ym2(socketCreateSocket);
                InputStream inputStream = socketCreateSocket.getInputStream();
                inputStream.getClass();
                this.h = new i32(new fh(0, ym2Var, new fh(i4, inputStream, ym2Var)));
                ym2 ym2Var2 = new ym2(socketCreateSocket);
                OutputStream outputStream = socketCreateSocket.getOutputStream();
                outputStream.getClass();
                this.i = new h32(new eh(ym2Var2, new eh(outputStream, ym2Var2)));
            } catch (NullPointerException e) {
                if (g31.a(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.b.c);
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void f(int i, int i2, int i3, m32 m32Var) throws IOException {
        cj cjVar = new cj(10);
        v82 v82Var = this.b;
        ey0 ey0Var = v82Var.a.h;
        ey0Var.getClass();
        cjVar.b = ey0Var;
        cjVar.x("CONNECT", null);
        w4 w4Var = v82Var.a;
        cjVar.v("Host", z53.w(w4Var.h, true));
        cjVar.v("Proxy-Connection", "Keep-Alive");
        cjVar.v("User-Agent", "okhttp/4.12.0");
        lj1 lj1VarJ = cjVar.j();
        ArrayList arrayList = new ArrayList(20);
        ko4.a("Proxy-Authenticate");
        ko4.b("OkHttp-Preemptive", "Proxy-Authenticate");
        int i4 = 0;
        while (i4 < arrayList.size()) {
            if ("Proxy-Authenticate".equalsIgnoreCase((String) arrayList.get(i4))) {
                arrayList.remove(i4);
                arrayList.remove(i4);
                i4 -= 2;
            }
            i4 += 2;
        }
        arrayList.add("Proxy-Authenticate");
        arrayList.add(cs2.V("OkHttp-Preemptive").toString());
        w4Var.f.getClass();
        ey0 ey0Var2 = (ey0) lj1VarJ.b;
        e(i, i2, m32Var);
        String str = "CONNECT " + z53.w(ey0Var2, true) + " HTTP/1.1";
        i32 i32Var = this.h;
        i32Var.getClass();
        h32 h32Var = this.i;
        h32Var.getClass();
        hx0 hx0Var = new hx0(null, this, i32Var, h32Var);
        u03 u03VarD = i32Var.a.d();
        long j = i2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        u03VarD.g(j, timeUnit);
        h32Var.a.d().g(i3, timeUnit);
        hx0Var.j((ew0) lj1VarJ.d, str);
        hx0Var.d();
        y62 y62VarG = hx0Var.g(false);
        y62VarG.getClass();
        y62VarG.a = lj1VarJ;
        z62 z62VarA = y62VarG.a();
        int i5 = z62VarA.e;
        long jK = z53.k(z62VarA);
        if (jK != -1) {
            fx0 fx0VarI = hx0Var.i(jK);
            z53.u(fx0VarI, Integer.MAX_VALUE);
            fx0VarI.close();
        }
        if (i5 == 200) {
            if (i32Var.b.e() && h32Var.b.e()) {
                return;
            }
            dk0.h("TLS tunnel buffered too many bytes!");
            return;
        }
        if (i5 != 407) {
            dk0.h(ky0.h(i5, "Unexpected response code for CONNECT: "));
        } else {
            w4Var.f.getClass();
            dk0.h("Failed to authenticate with proxy");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(b40 b40Var, int i, m32 m32Var) throws Throwable {
        y12 y12VarA = y12.HTTP_1_1;
        w4 w4Var = this.b.a;
        SSLSocketFactory sSLSocketFactory = w4Var.c;
        if (sSLSocketFactory == null) {
            List list = w4Var.i;
            y12 y12Var = y12.H2_PRIOR_KNOWLEDGE;
            boolean zContains = list.contains(y12Var);
            Socket socket = this.c;
            if (!zContains) {
                this.d = socket;
                this.f = y12VarA;
                return;
            } else {
                this.d = socket;
                this.f = y12Var;
                l(i);
                return;
            }
        }
        SSLSocket sSLSocket = null;
        String strF = null;
        try {
            sSLSocketFactory.getClass();
            Socket socket2 = this.c;
            ey0 ey0Var = w4Var.h;
            int i2 = 1;
            Socket socketCreateSocket = sSLSocketFactory.createSocket(socket2, ey0Var.d, ey0Var.e, true);
            socketCreateSocket.getClass();
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                a40 a40VarA = b40Var.a(sSLSocket2);
                if (a40VarA.b) {
                    ex1 ex1Var = ex1.a;
                    ex1.a.d(sSLSocket2, w4Var.h.d, w4Var.i);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                session.getClass();
                yv0 yv0VarA = ho4.a(session);
                HostnameVerifier hostnameVerifier = w4Var.d;
                hostnameVerifier.getClass();
                boolean zVerify = hostnameVerifier.verify(w4Var.h.d, session);
                int i3 = 0;
                if (!zVerify) {
                    List listA = yv0VarA.a();
                    if (listA.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + w4Var.h.d + " not verified (no certificates)");
                    }
                    Object obj = listA.get(0);
                    obj.getClass();
                    X509Certificate x509Certificate = (X509Certificate) obj;
                    StringBuilder sb = new StringBuilder("\n              |Hostname ");
                    sb.append(w4Var.h.d);
                    sb.append(" not verified:\n              |    certificate: ");
                    ww wwVar = ww.c;
                    StringBuilder sb2 = new StringBuilder("sha256/");
                    oo ooVar = oo.e;
                    byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                    encoded.getClass();
                    sb2.append(nr4.o(encoded).b("SHA-256").a());
                    sb.append(sb2.toString());
                    sb.append("\n              |    DN: ");
                    sb.append(x509Certificate.getSubjectDN().getName());
                    sb.append("\n              |    subjectAltNames: ");
                    sb.append(mz.G(pp1.a(x509Certificate, 7), pp1.a(x509Certificate, 2)));
                    sb.append("\n              ");
                    throw new SSLPeerUnverifiedException(ds2.c(sb.toString()));
                }
                ww wwVar2 = w4Var.e;
                wwVar2.getClass();
                this.e = new yv0(yv0VarA.a, yv0VarA.b, yv0VarA.c, new o32(wwVar2, yv0VarA, w4Var, i3));
                w4Var.h.d.getClass();
                Iterator it = wwVar2.a.iterator();
                if (it.hasNext()) {
                    ky0.x(it.next());
                    throw null;
                }
                if (a40VarA.b) {
                    ex1 ex1Var2 = ex1.a;
                    strF = ex1.a.f(sSLSocket2);
                }
                this.d = sSLSocket2;
                Logger logger = sp1.a;
                ym2 ym2Var = new ym2(sSLSocket2);
                InputStream inputStream = sSLSocket2.getInputStream();
                inputStream.getClass();
                this.h = new i32(new fh(i3, ym2Var, new fh(i2, inputStream, ym2Var)));
                ym2 ym2Var2 = new ym2(sSLSocket2);
                OutputStream outputStream = sSLSocket2.getOutputStream();
                outputStream.getClass();
                this.i = new h32(new eh(ym2Var2, new eh(outputStream, ym2Var2)));
                if (strF != null) {
                    y12VarA = fy3.a(strF);
                }
                this.f = y12VarA;
                ex1 ex1Var3 = ex1.a;
                ex1.a.a(sSLSocket2);
                if (this.f == y12.HTTP_2) {
                    l(i);
                }
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    ex1 ex1Var4 = ex1.a;
                    ex1.a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    z53.e(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean h(w4 w4Var, List list) {
        yv0 yv0Var;
        ey0 ey0Var = w4Var.h;
        byte[] bArr = z53.a;
        if (this.p.size() < this.o && !this.j) {
            v82 v82Var = this.b;
            w4 w4Var2 = v82Var.a;
            w4 w4Var3 = v82Var.a;
            if (w4Var2.a(w4Var)) {
                String str = ey0Var.d;
                String str2 = ey0Var.d;
                if (!g31.a(str, w4Var3.h.d)) {
                    if (this.g != null && list != null && !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            v82 v82Var2 = (v82) it.next();
                            Proxy.Type type = v82Var2.b.type();
                            Proxy.Type type2 = Proxy.Type.DIRECT;
                            if (type == type2 && v82Var.b.type() == type2 && g31.a(v82Var.c, v82Var2.c)) {
                                if (w4Var.d != pp1.a) {
                                    break;
                                }
                                byte[] bArr2 = z53.a;
                                ey0 ey0Var2 = w4Var3.h;
                                if (ey0Var.e != ey0Var2.e) {
                                    break;
                                }
                                if (!g31.a(str2, ey0Var2.d)) {
                                    if (!this.k && (yv0Var = this.e) != null) {
                                        List listA = yv0Var.a();
                                        if (!listA.isEmpty()) {
                                            Object obj = listA.get(0);
                                            obj.getClass();
                                            if (!pp1.c(str2, (X509Certificate) obj)) {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                        break;
                                    }
                                }
                                try {
                                    ww wwVar = w4Var.e;
                                    wwVar.getClass();
                                    yv0 yv0Var2 = this.e;
                                    yv0Var2.getClass();
                                    List listA2 = yv0Var2.a();
                                    str2.getClass();
                                    listA2.getClass();
                                    Iterator it2 = wwVar.a.iterator();
                                    if (!it2.hasNext()) {
                                        return true;
                                    }
                                    ky0.x(it2.next());
                                    throw null;
                                } catch (SSLPeerUnverifiedException unused) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean i(boolean z) {
        long j;
        byte[] bArr = z53.a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.c;
        socket.getClass();
        Socket socket2 = this.d;
        socket2.getClass();
        i32 i32Var = this.h;
        i32Var.getClass();
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        tx0 tx0Var = this.g;
        if (tx0Var != null) {
            synchronized (tx0Var) {
                if (tx0Var.i) {
                    return false;
                }
                return tx0Var.x >= tx0Var.w || jNanoTime < tx0Var.H;
            }
        }
        synchronized (this) {
            j = jNanoTime - this.q;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !i32Var.c();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final rj0 j(rp1 rp1Var, s32 s32Var) throws SocketException {
        int i = s32Var.g;
        Socket socket = this.d;
        socket.getClass();
        i32 i32Var = this.h;
        i32Var.getClass();
        h32 h32Var = this.i;
        h32Var.getClass();
        tx0 tx0Var = this.g;
        if (tx0Var != null) {
            return new ux0(rp1Var, this, s32Var, tx0Var);
        }
        socket.setSoTimeout(i);
        u03 u03VarD = i32Var.a.d();
        long j = i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        u03VarD.g(j, timeUnit);
        h32Var.a.d().g(s32Var.h, timeUnit);
        return new hx0(rp1Var, this, i32Var, h32Var);
    }

    public final synchronized void k() {
        this.j = true;
    }

    public final void l(int i) throws SocketException {
        int i2;
        Socket socket = this.d;
        socket.getClass();
        i32 i32Var = this.h;
        i32Var.getClass();
        h32 h32Var = this.i;
        h32Var.getClass();
        socket.setSoTimeout(0);
        mw2 mw2Var = mw2.h;
        hx0 hx0Var = new hx0(mw2Var);
        String str = this.b.a.h.d;
        str.getClass();
        hx0Var.c = socket;
        hx0Var.d = z53.g + ' ' + str;
        hx0Var.e = i32Var;
        hx0Var.f = h32Var;
        hx0Var.g = this;
        hx0Var.a = i;
        tx0 tx0Var = new tx0(hx0Var);
        this.g = tx0Var;
        yh2 yh2Var = tx0.j0;
        this.o = (yh2Var.a & 16) != 0 ? yh2Var.b[4] : Integer.MAX_VALUE;
        by0 by0Var = tx0Var.g0;
        synchronized (by0Var) {
            try {
                if (by0Var.e) {
                    throw new IOException("closed");
                }
                Logger logger = by0.i;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(z53.i(">> CONNECTION " + ix0.a.d(), new Object[0]));
                }
                by0Var.a.h(ix0.a);
                by0Var.a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
        by0 by0Var2 = tx0Var.g0;
        yh2 yh2Var2 = tx0Var.X;
        synchronized (by0Var2) {
            try {
                yh2Var2.getClass();
                if (by0Var2.e) {
                    throw new IOException("closed");
                }
                by0Var2.j(0, Integer.bitCount(yh2Var2.a) * 6, 4, 0);
                int i3 = 0;
                while (i3 < 10) {
                    boolean z = true;
                    if (((1 << i3) & yh2Var2.a) == 0) {
                        z = false;
                    }
                    if (z) {
                        if (i3 != 4) {
                            i2 = i3 != 7 ? i3 : 4;
                        } else {
                            i2 = 3;
                        }
                        by0Var2.a.writeShort(i2);
                        by0Var2.a.writeInt(yh2Var2.b[i3]);
                    }
                    i3++;
                }
                by0Var2.a.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int iA = tx0Var.X.a();
        if (iA != 65535) {
            tx0Var.g0.w(0, iA - DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH);
        }
        mw2Var.e().c(new qx0(tx0Var.c, tx0Var.h0, 2), 0L);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        v82 v82Var = this.b;
        sb.append(v82Var.a.h.d);
        sb.append(':');
        sb.append(v82Var.a.h.e);
        sb.append(", proxy=");
        sb.append(v82Var.b);
        sb.append(" hostAddress=");
        sb.append(v82Var.c);
        sb.append(" cipherSuite=");
        yv0 yv0Var = this.e;
        sb.append(yv0Var != null ? yv0Var.b : "none");
        sb.append(" protocol=");
        sb.append(this.f);
        sb.append('}');
        return sb.toString();
    }
}
