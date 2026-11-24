package defpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sj0 {
    public final r32 a;
    public final w4 b;
    public final m32 c;
    public m01 d;
    public we e;
    public int f;
    public int g;
    public int h;
    public v82 i;

    public sj0(r32 r32Var, w4 w4Var, m32 m32Var) {
        r32Var.getClass();
        this.a = r32Var;
        this.b = w4Var;
        this.c = m32Var;
    }

    /* JADX WARN: Code duplicated, block: B:129:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:132:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:134:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:135:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:137:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:146:0x0320  */
    /* JADX WARN: Code duplicated, block: B:147:0x0334  */
    /* JADX WARN: Code duplicated, block: B:189:0x0335 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x030c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x039e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x027d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x0398 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x0394 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x006f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:63:0x0112  */
    /* JADX WARN: Code duplicated, block: B:66:0x0123  */
    /* JADX WARN: Code duplicated, block: B:68:0x0135  */
    /* JADX WARN: Code duplicated, block: B:82:0x018b  */
    public final q32 a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        v82 v82Var;
        m01 m01Var;
        we weVar;
        ArrayList arrayList;
        m01 m01Var2;
        w4 w4Var;
        Proxy proxy;
        String hostAddress;
        int port;
        List listH;
        boolean zContains;
        w4 w4Var2;
        URI uriH;
        List<Proxy> listSelect;
        List listL;
        q32 q32Var;
        py0 py0Var;
        Socket socketJ;
        while (!this.c.x) {
            q32 q32Var2 = this.c.n;
            if (q32Var2 != null) {
                synchronized (q32Var2) {
                    try {
                        if (!q32Var2.j) {
                            ey0 ey0Var = q32Var2.b.a.h;
                            ey0Var.getClass();
                            ey0 ey0Var2 = this.b.h;
                            socketJ = !(ey0Var.e == ey0Var2.e && g31.a(ey0Var.d, ey0Var2.d)) ? this.c.j() : null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.c.n == null) {
                    if (socketJ != null) {
                        z53.e(socketJ);
                    }
                    this.f = 0;
                    this.g = 0;
                    this.h = 0;
                    if (this.a.a(this.b, this.c, null, false)) {
                        q32Var2 = this.c.n;
                        q32Var2.getClass();
                    } else {
                        v82Var = this.i;
                        try {
                            if (v82Var != null) {
                                this.i = null;
                            } else {
                                m01Var = this.d;
                                if (m01Var == null && m01Var.a()) {
                                    m01 m01Var3 = this.d;
                                    m01Var3.getClass();
                                    if (!m01Var3.a()) {
                                        dk0.d();
                                        return null;
                                    }
                                    ArrayList arrayList2 = m01Var3.b;
                                    int i5 = m01Var3.a;
                                    m01Var3.a = i5 + 1;
                                    v82Var = (v82) arrayList2.get(i5);
                                } else {
                                    weVar = this.e;
                                    if (weVar == null) {
                                        w4Var2 = this.b;
                                        py0 py0Var2 = this.c.a.k0;
                                        py0Var2.getClass();
                                        weVar = new we();
                                        weVar.b = w4Var2;
                                        weVar.c = py0Var2;
                                        ii0 ii0Var = ii0.a;
                                        weVar.d = ii0Var;
                                        weVar.e = ii0Var;
                                        weVar.f = new ArrayList();
                                        ey0 ey0Var3 = w4Var2.h;
                                        ey0Var3.getClass();
                                        uriH = ey0Var3.h();
                                        if (uriH.getHost() == null) {
                                            listL = z53.l(Proxy.NO_PROXY);
                                        } else {
                                            listSelect = w4Var2.g.select(uriH);
                                            if (listSelect != null || listSelect.isEmpty()) {
                                                listL = z53.l(Proxy.NO_PROXY);
                                            } else {
                                                listL = z53.x(listSelect);
                                            }
                                        }
                                        weVar.d = listL;
                                        weVar.a = 0;
                                        this.e = weVar;
                                    }
                                    if (weVar.b()) {
                                        dk0.d();
                                        return null;
                                    }
                                    arrayList = new ArrayList();
                                    while (weVar.a < ((List) weVar.d).size()) {
                                        w4Var = (w4) weVar.b;
                                        if (weVar.a < ((List) weVar.d).size()) {
                                            throw new SocketException("No route to " + w4Var.h.d + "; exhausted proxy configurations: " + ((List) weVar.d));
                                        }
                                        List list = (List) weVar.d;
                                        int i6 = weVar.a;
                                        weVar.a = i6 + 1;
                                        proxy = (Proxy) list.get(i6);
                                        ArrayList arrayList3 = new ArrayList();
                                        weVar.e = arrayList3;
                                        if (proxy.type() != Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            ey0 ey0Var4 = w4Var.h;
                                            hostAddress = ey0Var4.d;
                                            port = ey0Var4.e;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                dk0.w(socketAddressAddress.getClass(), "Proxy.address() is not an InetSocketAddress: ");
                                                return null;
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            InetAddress address = inetSocketAddress.getAddress();
                                            if (address == null) {
                                                hostAddress = inetSocketAddress.getHostName();
                                                hostAddress.getClass();
                                            } else {
                                                hostAddress = address.getHostAddress();
                                                hostAddress.getClass();
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 <= port || port >= 65536) {
                                            throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList3.add(InetSocketAddress.createUnresolved(hostAddress, port));
                                        } else {
                                            byte[] bArr = z53.a;
                                            hostAddress.getClass();
                                            if (z53.f.e(hostAddress)) {
                                                listH = nz.h(InetAddress.getByName(hostAddress));
                                            } else {
                                                w4Var.a.getClass();
                                                try {
                                                    InetAddress[] allByName = InetAddress.getAllByName(hostAddress);
                                                    allByName.getClass();
                                                    List listS = qg.s(allByName);
                                                    if (listS.isEmpty()) {
                                                        throw new UnknownHostException(w4Var.a + " returned no addresses for " + hostAddress);
                                                    }
                                                    listH = listS;
                                                } catch (NullPointerException e) {
                                                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostAddress));
                                                    unknownHostException.initCause(e);
                                                    throw unknownHostException;
                                                }
                                            }
                                            Iterator it = listH.iterator();
                                            while (it.hasNext()) {
                                                arrayList3.add(new InetSocketAddress((InetAddress) it.next(), port));
                                            }
                                        }
                                        Iterator it2 = ((List) weVar.e).iterator();
                                        while (it2.hasNext()) {
                                            v82 v82Var2 = new v82((w4) weVar.b, proxy, (InetSocketAddress) it2.next());
                                            py0 py0Var3 = (py0) weVar.c;
                                            synchronized (py0Var3) {
                                                zContains = ((LinkedHashSet) py0Var3.b).contains(v82Var2);
                                            }
                                            if (zContains) {
                                                ((ArrayList) weVar.f).add(v82Var2);
                                            } else {
                                                arrayList.add(v82Var2);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        rz.q((ArrayList) weVar.f, arrayList);
                                        ((ArrayList) weVar.f).clear();
                                    }
                                    m01Var2 = new m01();
                                    m01Var2.b = arrayList;
                                    this.d = m01Var2;
                                    if (!this.c.x) {
                                        dk0.h("Canceled");
                                        return null;
                                    }
                                    if (this.a.a(this.b, this.c, arrayList, false)) {
                                        q32Var2 = this.c.n;
                                        q32Var2.getClass();
                                    } else {
                                        if (m01Var2.a()) {
                                            dk0.d();
                                            return null;
                                        }
                                        int i7 = m01Var2.a;
                                        m01Var2.a = i7 + 1;
                                        v82Var = (v82) arrayList.get(i7);
                                        q32Var = new q32(this.a, v82Var);
                                        this.c.X = q32Var;
                                        q32Var.c(i, i2, i3, i4, z, this.c);
                                        this.c.X = null;
                                        py0Var = this.c.a.k0;
                                        synchronized (py0Var) {
                                            ((LinkedHashSet) py0Var.b).remove(v82Var);
                                        }
                                        if (this.a.a(this.b, this.c, arrayList, true)) {
                                            q32 q32Var3 = this.c.n;
                                            q32Var3.getClass();
                                            this.i = v82Var;
                                            Socket socket = q32Var.d;
                                            socket.getClass();
                                            z53.e(socket);
                                            q32Var2 = q32Var3;
                                        } else {
                                            synchronized (q32Var) {
                                                r32 r32Var = this.a;
                                                r32Var.getClass();
                                                byte[] bArr2 = z53.a;
                                                ((ConcurrentLinkedQueue) r32Var.e).add(q32Var);
                                                ((lw2) r32Var.b).c((qx0) r32Var.c, 0L);
                                                this.c.b(q32Var);
                                            }
                                            q32Var2 = q32Var;
                                        }
                                    }
                                }
                            }
                            q32Var.c(i, i2, i3, i4, z, this.c);
                            this.c.X = null;
                            py0Var = this.c.a.k0;
                            synchronized (py0Var) {
                                ((LinkedHashSet) py0Var.b).remove(v82Var);
                                if (this.a.a(this.b, this.c, arrayList, true)) {
                                    q32 q32Var4 = this.c.n;
                                    q32Var4.getClass();
                                    this.i = v82Var;
                                    Socket socket2 = q32Var.d;
                                    socket2.getClass();
                                    z53.e(socket2);
                                    q32Var2 = q32Var4;
                                } else {
                                    synchronized (q32Var) {
                                        r32 r32Var2 = this.a;
                                        r32Var2.getClass();
                                        byte[] bArr3 = z53.a;
                                        ((ConcurrentLinkedQueue) r32Var2.e).add(q32Var);
                                        ((lw2) r32Var2.b).c((qx0) r32Var2.c, 0L);
                                        this.c.b(q32Var);
                                        q32Var2 = q32Var;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            this.c.X = null;
                            throw th2;
                        }
                        arrayList = null;
                        q32Var = new q32(this.a, v82Var);
                        this.c.X = q32Var;
                    }
                } else if (socketJ != null) {
                    og.n("Check failed.");
                    return null;
                }
            } else {
                this.f = 0;
                this.g = 0;
                this.h = 0;
                if (this.a.a(this.b, this.c, null, false)) {
                    q32Var2 = this.c.n;
                    q32Var2.getClass();
                } else {
                    v82Var = this.i;
                    if (v82Var != null) {
                        this.i = null;
                    } else {
                        m01Var = this.d;
                        if (m01Var == null) {
                        }
                        weVar = this.e;
                        if (weVar == null) {
                            w4Var2 = this.b;
                            py0 py0Var4 = this.c.a.k0;
                            py0Var4.getClass();
                            weVar = new we();
                            weVar.b = w4Var2;
                            weVar.c = py0Var4;
                            ii0 ii0Var2 = ii0.a;
                            weVar.d = ii0Var2;
                            weVar.e = ii0Var2;
                            weVar.f = new ArrayList();
                            ey0 ey0Var5 = w4Var2.h;
                            ey0Var5.getClass();
                            uriH = ey0Var5.h();
                            if (uriH.getHost() == null) {
                                listL = z53.l(Proxy.NO_PROXY);
                            } else {
                                listSelect = w4Var2.g.select(uriH);
                                if (listSelect != null) {
                                    listL = z53.l(Proxy.NO_PROXY);
                                } else {
                                    listL = z53.l(Proxy.NO_PROXY);
                                }
                            }
                            weVar.d = listL;
                            weVar.a = 0;
                            this.e = weVar;
                        }
                        if (weVar.b()) {
                            dk0.d();
                            return null;
                        }
                        arrayList = new ArrayList();
                        while (weVar.a < ((List) weVar.d).size()) {
                            w4Var = (w4) weVar.b;
                            if (weVar.a < ((List) weVar.d).size()) {
                                throw new SocketException("No route to " + w4Var.h.d + "; exhausted proxy configurations: " + ((List) weVar.d));
                            }
                            List list2 = (List) weVar.d;
                            int i8 = weVar.a;
                            weVar.a = i8 + 1;
                            proxy = (Proxy) list2.get(i8);
                            ArrayList arrayList4 = new ArrayList();
                            weVar.e = arrayList4;
                            if (proxy.type() != Proxy.Type.DIRECT) {
                                ey0 ey0Var6 = w4Var.h;
                                hostAddress = ey0Var6.d;
                                port = ey0Var6.e;
                            } else {
                                ey0 ey0Var7 = w4Var.h;
                                hostAddress = ey0Var7.d;
                                port = ey0Var7.e;
                            }
                            if (1 <= port) {
                            }
                            throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
                        }
                        if (arrayList.isEmpty()) {
                            rz.q((ArrayList) weVar.f, arrayList);
                            ((ArrayList) weVar.f).clear();
                        }
                        m01Var2 = new m01();
                        m01Var2.b = arrayList;
                        this.d = m01Var2;
                        if (!this.c.x) {
                            dk0.h("Canceled");
                            return null;
                        }
                        if (this.a.a(this.b, this.c, arrayList, false)) {
                            q32Var2 = this.c.n;
                            q32Var2.getClass();
                        } else {
                            if (m01Var2.a()) {
                                dk0.d();
                                return null;
                            }
                            int i9 = m01Var2.a;
                            m01Var2.a = i9 + 1;
                            v82Var = (v82) arrayList.get(i9);
                            q32Var = new q32(this.a, v82Var);
                            this.c.X = q32Var;
                            q32Var.c(i, i2, i3, i4, z, this.c);
                            this.c.X = null;
                            py0Var = this.c.a.k0;
                            synchronized (py0Var) {
                                ((LinkedHashSet) py0Var.b).remove(v82Var);
                                if (this.a.a(this.b, this.c, arrayList, true)) {
                                    q32 q32Var5 = this.c.n;
                                    q32Var5.getClass();
                                    this.i = v82Var;
                                    Socket socket3 = q32Var.d;
                                    socket3.getClass();
                                    z53.e(socket3);
                                    q32Var2 = q32Var5;
                                } else {
                                    synchronized (q32Var) {
                                        r32 r32Var3 = this.a;
                                        r32Var3.getClass();
                                        byte[] bArr4 = z53.a;
                                        ((ConcurrentLinkedQueue) r32Var3.e).add(q32Var);
                                        ((lw2) r32Var3.b).c((qx0) r32Var3.c, 0L);
                                        this.c.b(q32Var);
                                        q32Var2 = q32Var;
                                    }
                                }
                            }
                        }
                    }
                    arrayList = null;
                    q32Var = new q32(this.a, v82Var);
                    this.c.X = q32Var;
                    q32Var.c(i, i2, i3, i4, z, this.c);
                    this.c.X = null;
                    py0Var = this.c.a.k0;
                    synchronized (py0Var) {
                        ((LinkedHashSet) py0Var.b).remove(v82Var);
                        if (this.a.a(this.b, this.c, arrayList, true)) {
                            q32 q32Var6 = this.c.n;
                            q32Var6.getClass();
                            this.i = v82Var;
                            Socket socket4 = q32Var.d;
                            socket4.getClass();
                            z53.e(socket4);
                            q32Var2 = q32Var6;
                        } else {
                            synchronized (q32Var) {
                                r32 r32Var4 = this.a;
                                r32Var4.getClass();
                                byte[] bArr5 = z53.a;
                                ((ConcurrentLinkedQueue) r32Var4.e).add(q32Var);
                                ((lw2) r32Var4.b).c((qx0) r32Var4.c, 0L);
                                this.c.b(q32Var);
                                q32Var2 = q32Var;
                            }
                        }
                    }
                }
            }
            if (q32Var2.i(z2)) {
                return q32Var2;
            }
            q32Var2.k();
            if (this.i == null) {
                m01 m01Var4 = this.d;
                if (m01Var4 != null ? m01Var4.a() : true) {
                    continue;
                } else {
                    we weVar2 = this.e;
                    if (!(weVar2 != null ? weVar2.b() : true)) {
                        dk0.h("exhausted all routes");
                        return null;
                    }
                }
            }
        }
        dk0.h("Canceled");
        return null;
    }

    public final void b(IOException iOException) {
        iOException.getClass();
        this.i = null;
        if ((iOException instanceof wr2) && ((wr2) iOException).a == 8) {
            this.f++;
        } else if (iOException instanceof y30) {
            this.g++;
        } else {
            this.h++;
        }
    }
}
