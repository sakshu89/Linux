package defpackage;

import com.ibm.icu.lang.UCharacter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mm implements v21 {
    public final /* synthetic */ int a = 1;
    public final Object b;

    public mm(su0 su0Var) {
        su0Var.getClass();
        this.b = su0Var;
    }

    public static int d(z62 z62Var, int i) {
        String strC = z62.c(z62Var, "Retry-After");
        if (strC == null) {
            return i;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        patternCompile.getClass();
        if (!patternCompile.matcher(strC).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strC);
        numValueOf.getClass();
        return numValueOf.intValue();
    }

    @Override // defpackage.v21
    public final z62 a(s32 s32Var) {
        b72 b72Var;
        z62 z62VarB;
        SSLSocketFactory sSLSocketFactory;
        pp1 pp1Var;
        ww wwVar;
        switch (this.a) {
            case 0:
                su0 su0Var = (su0) this.b;
                lj1 lj1Var = s32Var.e;
                cj cjVarK = lj1Var.k();
                ey0 ey0Var = (ey0) lj1Var.b;
                ew0 ew0Var = (ew0) lj1Var.d;
                t9 t9Var = (t9) lj1Var.e;
                if (t9Var != null) {
                    ji1 ji1Var = (ji1) t9Var.c;
                    if (ji1Var != null) {
                        cjVarK.v("Content-Type", ji1Var.a);
                    }
                    long j = t9Var.b;
                    if (j != -1) {
                        cjVarK.v("Content-Length", String.valueOf(j));
                        ((uf1) cjVarK.e).x("Transfer-Encoding");
                    } else {
                        cjVarK.v("Transfer-Encoding", "chunked");
                        ((uf1) cjVarK.e).x("Content-Length");
                    }
                }
                boolean z = false;
                if (ew0Var.a("Host") == null) {
                    cjVarK.v("Host", z53.w(ey0Var, false));
                }
                if (ew0Var.a("Connection") == null) {
                    cjVarK.v("Connection", "Keep-Alive");
                }
                if (ew0Var.a("Accept-Encoding") == null && ew0Var.a("Range") == null) {
                    cjVarK.v("Accept-Encoding", "gzip");
                    z = true;
                }
                su0Var.getClass();
                ey0Var.getClass();
                if (ew0Var.a("User-Agent") == null) {
                    cjVarK.v("User-Agent", "okhttp/4.12.0");
                }
                z62 z62VarB2 = s32Var.b(cjVarK.j());
                ew0 ew0Var2 = z62VarB2.i;
                cy0.b(su0Var, ey0Var, ew0Var2);
                y62 y62VarE = z62VarB2.e();
                y62VarE.a = lj1Var;
                if (z && "gzip".equalsIgnoreCase(z62.c(z62VarB2, "Content-Encoding")) && cy0.a(z62VarB2) && (b72Var = z62VarB2.j) != null) {
                    ov0 ov0Var = new ov0(b72Var.j());
                    uf1 uf1VarD = ew0Var2.d();
                    uf1VarD.x("Content-Encoding");
                    uf1VarD.x("Content-Length");
                    y62VarE.f = uf1VarD.k().d();
                    y62VarE.g = new t32(z62.c(z62VarB2, "Content-Type"), -1L, new i32(ov0Var));
                }
                return y62VarE.a();
            default:
                lj1 lj1Var2 = s32Var.e;
                m32 m32Var = s32Var.a;
                List listF = ii0.a;
                z62 z62Var = null;
                int i = 0;
                lj1 lj1VarB = lj1Var2;
                while (true) {
                    boolean z2 = true;
                    while (true) {
                        if (m32Var.t != null) {
                            og.n("Check failed.");
                            return null;
                        }
                        synchronized (m32Var) {
                            try {
                                if (m32Var.v) {
                                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                                }
                                if (m32Var.u) {
                                    throw new IllegalStateException("Check failed.");
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z2) {
                            r32 r32Var = m32Var.e;
                            ey0 ey0Var2 = (ey0) lj1VarB.b;
                            rp1 rp1Var = m32Var.a;
                            if (ey0Var2.i) {
                                SSLSocketFactory sSLSocketFactory2 = rp1Var.x;
                                if (sSLSocketFactory2 == null) {
                                    og.n("CLEARTEXT-only client");
                                    return null;
                                }
                                pp1 pp1Var2 = rp1Var.Z;
                                wwVar = rp1Var.c0;
                                sSLSocketFactory = sSLSocketFactory2;
                                pp1Var = pp1Var2;
                            } else {
                                sSLSocketFactory = null;
                                pp1Var = null;
                                wwVar = null;
                            }
                            m32Var.k = new sj0(r32Var, new w4(ey0Var2.d, ey0Var2.e, rp1Var.t, rp1Var.w, sSLSocketFactory, pp1Var, wwVar, rp1Var.v, rp1Var.Y, rp1Var.X, rp1Var.u), m32Var);
                        }
                        try {
                            if (m32Var.x) {
                                throw new IOException("Canceled");
                            }
                            try {
                                try {
                                    z62VarB = s32Var.b(lj1VarB);
                                } catch (IOException e) {
                                    if (!c(e, m32Var, lj1VarB, !(e instanceof y30))) {
                                        Iterator it = listF.iterator();
                                        while (it.hasNext()) {
                                            gn4.a(e, (Exception) it.next());
                                        }
                                        throw e;
                                    }
                                    listF = mz.F(listF, e);
                                    m32Var.f(true);
                                    z2 = false;
                                }
                            } catch (w82 e2) {
                                boolean zC = c(e2.b, m32Var, lj1VarB, false);
                                IOException iOException = e2.a;
                                if (!zC) {
                                    iOException.getClass();
                                    Iterator it2 = listF.iterator();
                                    while (it2.hasNext()) {
                                        gn4.a(iOException, (Exception) it2.next());
                                    }
                                    throw iOException;
                                }
                                listF = mz.F(listF, iOException);
                                m32Var.f(true);
                                z2 = false;
                            }
                        } catch (Throwable th2) {
                            m32Var.f(true);
                            throw th2;
                        }
                        break;
                        z2 = false;
                    }
                    if (z62Var != null) {
                        y62 y62VarE2 = z62VarB.e();
                        y62 y62VarE3 = z62Var.e();
                        y62VarE3.g = null;
                        z62 z62VarA = y62VarE3.a();
                        if (z62VarA.j != null) {
                            throw new IllegalArgumentException("priorResponse.body != null");
                        }
                        y62VarE2.j = z62VarA;
                        z62VarB = y62VarE2.a();
                    }
                    z62Var = z62VarB;
                    lj1VarB = b(z62Var, m32Var.t);
                    if (lj1VarB == null) {
                        m32Var.f(false);
                        return z62Var;
                    }
                    b72 b72Var2 = z62Var.j;
                    if (b72Var2 != null) {
                        z53.d(b72Var2);
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    }
                    m32Var.f(true);
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x013b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0160  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:88:0x0112  */
    /* JADX WARN: Code duplicated, block: B:92:0x011e  */
    /* JADX WARN: Code duplicated, block: B:98:0x012f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x0131  */
    public lj1 b(z62 z62Var, ux uxVar) throws ProtocolException {
        rp1 rp1Var;
        String strC;
        lj1 lj1Var;
        dy0 dy0Var;
        ey0 ey0VarB;
        cj cjVarK;
        boolean z;
        z62 z62Var2;
        q32 q32Var;
        v82 v82Var = (uxVar == null || (q32Var = (q32) uxVar.e) == null) ? null : q32Var.b;
        int i = z62Var.e;
        String str = (String) z62Var.a.c;
        if (i == 307 || i == 308) {
            rp1Var = (rp1) this.b;
            if (rp1Var.k) {
                strC = z62.c(z62Var, "Location");
                lj1Var = z62Var.a;
                if (strC != null) {
                    ey0 ey0Var = (ey0) lj1Var.b;
                    ey0Var.getClass();
                    try {
                        dy0Var = new dy0();
                        dy0Var.d(ey0Var, strC);
                    } catch (IllegalArgumentException unused) {
                        dy0Var = null;
                    }
                    if (dy0Var != null) {
                        ey0VarB = dy0Var.b();
                    } else {
                        ey0VarB = null;
                    }
                    if (ey0VarB != null && (g31.a(ey0VarB.a, ((ey0) lj1Var.b).a) || rp1Var.n)) {
                        cjVarK = lj1Var.k();
                        if (qo4.a(str)) {
                            int i2 = z62Var.e;
                            z = !str.equals("PROPFIND") || i2 == 308 || i2 == 307;
                            if (!str.equals("PROPFIND") || i2 == 308 || i2 == 307) {
                                cjVarK.x(str, z ? (t9) lj1Var.e : null);
                            } else {
                                cjVarK.x("GET", null);
                            }
                            if (!z) {
                                ((uf1) cjVarK.e).x("Transfer-Encoding");
                                ((uf1) cjVarK.e).x("Content-Length");
                                ((uf1) cjVarK.e).x("Content-Type");
                            }
                        }
                        if (!z53.a((ey0) lj1Var.b, ey0VarB)) {
                            ((uf1) cjVarK.e).x("Authorization");
                        }
                        cjVarK.b = ey0VarB;
                        return cjVarK.j();
                    }
                }
            }
        } else {
            if (i == 401) {
                ((rp1) this.b).j.getClass();
                return null;
            }
            if (i != 421) {
                if (i == 503) {
                    z62 z62Var3 = z62Var.s;
                    if ((z62Var3 == null || z62Var3.e != 503) && d(z62Var, Integer.MAX_VALUE) == 0) {
                        return z62Var.a;
                    }
                } else {
                    if (i == 407) {
                        v82Var.getClass();
                        if (v82Var.b.type() != Proxy.Type.HTTP) {
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                        ((rp1) this.b).v.getClass();
                        return null;
                    }
                    if (i != 408) {
                        switch (i) {
                            case 300:
                            case UCharacter.UnicodeBlock.CHORASMIAN_ID /* 301 */:
                            case UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_G_ID /* 302 */:
                            case UCharacter.UnicodeBlock.DIVES_AKURU_ID /* 303 */:
                                rp1Var = (rp1) this.b;
                                if (rp1Var.k) {
                                    strC = z62.c(z62Var, "Location");
                                    lj1Var = z62Var.a;
                                    if (strC != null) {
                                        ey0 ey0Var2 = (ey0) lj1Var.b;
                                        ey0Var2.getClass();
                                        dy0Var = new dy0();
                                        dy0Var.d(ey0Var2, strC);
                                        if (dy0Var != null) {
                                            ey0VarB = dy0Var.b();
                                        } else {
                                            ey0VarB = null;
                                        }
                                        if (ey0VarB != null) {
                                            cjVarK = lj1Var.k();
                                            if (qo4.a(str)) {
                                                int i3 = z62Var.e;
                                                if (str.equals("PROPFIND")) {
                                                }
                                                if (str.equals("PROPFIND")) {
                                                    cjVarK.x(str, z ? (t9) lj1Var.e : null);
                                                } else {
                                                    cjVarK.x(str, z ? (t9) lj1Var.e : null);
                                                }
                                                if (!z) {
                                                    ((uf1) cjVarK.e).x("Transfer-Encoding");
                                                    ((uf1) cjVarK.e).x("Content-Length");
                                                    ((uf1) cjVarK.e).x("Content-Type");
                                                }
                                            }
                                            if (!z53.a((ey0) lj1Var.b, ey0VarB)) {
                                                ((uf1) cjVarK.e).x("Authorization");
                                            }
                                            cjVarK.b = ey0VarB;
                                            return cjVarK.j();
                                        }
                                    }
                                }
                            default:
                                return null;
                        }
                    } else if (((rp1) this.b).i && (((z62Var2 = z62Var.s) == null || z62Var2.e != 408) && d(z62Var, 0) <= 0)) {
                        return z62Var.a;
                    }
                }
            } else if (uxVar != null && !g31.a(((sj0) uxVar.c).b.h.d, ((q32) uxVar.e).b.a.h.d)) {
                q32 q32Var2 = (q32) uxVar.e;
                synchronized (q32Var2) {
                    q32Var2.k = true;
                }
                return z62Var.a;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0049  */
    /* JADX WARN: Code duplicated, block: B:36:0x004e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0051  */
    /* JADX WARN: Code duplicated, block: B:49:0x0066 A[ADDED_TO_REGION, DONT_GENERATE, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:51:0x0068 A[Catch: all -> 0x007e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:47:0x0062, B:51:0x0068, B:55:0x007a), top: B:76:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0083  */
    /* JADX WARN: Code duplicated, block: B:63:0x0085  */
    /* JADX WARN: Code duplicated, block: B:64:0x0087  */
    /* JADX WARN: Code duplicated, block: B:66:0x008b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0092  */
    /* JADX WARN: Code duplicated, block: B:75:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean c(IOException iOException, m32 m32Var, lj1 lj1Var, boolean z) {
        sj0 sj0Var;
        int i;
        boolean zB;
        v82 v82Var;
        m01 m01Var;
        we weVar;
        q32 q32Var;
        if (!((rp1) this.b).i || ((z && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException))) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                return false;
            }
            sj0Var = m32Var.k;
            sj0Var.getClass();
            i = sj0Var.f;
            if (i != 0) {
                if (sj0Var.i != null) {
                    zB = true;
                } else {
                    v82Var = null;
                    if (i <= 1) {
                        synchronized (q32Var) {
                            if (q32Var.l != 0) {
                                v82Var = q32Var.b;
                            }
                        }
                    }
                    if (v82Var != null) {
                        sj0Var.i = v82Var;
                    } else {
                        m01Var = sj0Var.d;
                        zB = m01Var != null ? weVar.b() : weVar.b();
                    }
                    zB = true;
                }
            } else if (sj0Var.i != null) {
                zB = true;
            } else {
                v82Var = null;
                if (i <= 1) {
                    synchronized (q32Var) {
                        if (q32Var.l != 0) {
                            v82Var = q32Var.b;
                        }
                    }
                }
                if (v82Var != null) {
                    sj0Var.i = v82Var;
                } else {
                    m01Var = sj0Var.d;
                    if (m01Var != null) {
                    }
                }
                zB = true;
            }
            if (!zB) {
                return true;
            }
        } else if ((iOException instanceof SocketTimeoutException) && !z) {
            sj0Var = m32Var.k;
            sj0Var.getClass();
            i = sj0Var.f;
            if (i != 0 && sj0Var.g == 0 && sj0Var.h == 0) {
                zB = false;
            } else if (sj0Var.i != null) {
                zB = true;
            } else {
                v82Var = null;
                if (i <= 1 && sj0Var.g <= 1 && sj0Var.h <= 0 && (q32Var = sj0Var.c.n) != null) {
                    synchronized (q32Var) {
                        if (q32Var.l != 0 && z53.a(q32Var.b.a.h, sj0Var.b.h)) {
                            v82Var = q32Var.b;
                        }
                    }
                }
                if (v82Var != null) {
                    sj0Var.i = v82Var;
                } else {
                    m01Var = sj0Var.d;
                    if ((m01Var != null || !m01Var.a()) && (weVar = sj0Var.e) != null) {
                    }
                }
                zB = true;
            }
            if (!zB) {
                return true;
            }
        }
        return false;
    }

    public mm(rp1 rp1Var) {
        this.b = rp1Var;
    }
}
