package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ux0 implements rj0 {
    public static final List g = z53.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List h = z53.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public final q32 a;
    public final s32 b;
    public final tx0 c;
    public volatile ay0 d;
    public final y12 e;
    public volatile boolean f;

    public ux0(rp1 rp1Var, q32 q32Var, s32 s32Var, tx0 tx0Var) {
        tx0Var.getClass();
        this.a = q32Var;
        this.b = s32Var;
        this.c = tx0Var;
        List list = rp1Var.Y;
        y12 y12Var = y12.H2_PRIOR_KNOWLEDGE;
        this.e = list.contains(y12Var) ? y12Var : y12.HTTP_2;
    }

    @Override // defpackage.rj0
    public final wk2 a(lj1 lj1Var, long j) {
        ay0 ay0Var = this.d;
        ay0Var.getClass();
        return ay0Var.f();
    }

    @Override // defpackage.rj0
    public final void b(lj1 lj1Var) throws IOException {
        int i;
        ay0 ay0Var;
        boolean z;
        if (this.d != null) {
            return;
        }
        boolean z2 = ((t9) lj1Var.e) != null;
        ew0 ew0Var = (ew0) lj1Var.d;
        ArrayList arrayList = new ArrayList(ew0Var.size() + 4);
        arrayList.add(new dw0(dw0.f, (String) lj1Var.c));
        oo ooVar = dw0.g;
        ey0 ey0Var = (ey0) lj1Var.b;
        ey0Var.getClass();
        String strB = ey0Var.b();
        String strD = ey0Var.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new dw0(ooVar, strB));
        String strA = ew0Var.a("Host");
        if (strA != null) {
            arrayList.add(new dw0(dw0.i, strA));
        }
        arrayList.add(new dw0(dw0.h, ey0Var.a));
        int size = ew0Var.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strB2 = ew0Var.b(i2);
            Locale locale = Locale.US;
            String strO = cq.o(locale, strB2, locale);
            if (!g.contains(strO) || (strO.equals("te") && g31.a(ew0Var.f(i2), "trailers"))) {
                arrayList.add(new dw0(strO, ew0Var.f(i2)));
            }
        }
        tx0 tx0Var = this.c;
        tx0Var.getClass();
        boolean z3 = !z2;
        synchronized (tx0Var.g0) {
            synchronized (tx0Var) {
                try {
                    if (tx0Var.f > 1073741823) {
                        tx0Var.o(8);
                    }
                    if (tx0Var.i) {
                        throw new y30();
                    }
                    i = tx0Var.f;
                    tx0Var.f = i + 2;
                    ay0Var = new ay0(i, tx0Var, z3, false, null);
                    z = !z2 || tx0Var.d0 >= tx0Var.e0 || ay0Var.e >= ay0Var.f;
                    if (ay0Var.h()) {
                        tx0Var.b.put(Integer.valueOf(i), ay0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            tx0Var.g0.q(z3, i, arrayList);
        }
        if (z) {
            tx0Var.g0.flush();
        }
        this.d = ay0Var;
        boolean z4 = this.f;
        ay0 ay0Var2 = this.d;
        if (z4) {
            ay0Var2.getClass();
            ay0Var2.e(9);
            dk0.h("Canceled");
            return;
        }
        ay0Var2.getClass();
        zx0 zx0Var = ay0Var2.k;
        long j = this.b.g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zx0Var.g(j, timeUnit);
        ay0 ay0Var3 = this.d;
        ay0Var3.getClass();
        ay0Var3.l.g(this.b.h, timeUnit);
    }

    @Override // defpackage.rj0
    public final fp2 c(z62 z62Var) {
        ay0 ay0Var = this.d;
        ay0Var.getClass();
        return ay0Var.i;
    }

    @Override // defpackage.rj0
    public final void cancel() {
        this.f = true;
        ay0 ay0Var = this.d;
        if (ay0Var != null) {
            ay0Var.e(9);
        }
    }

    @Override // defpackage.rj0
    public final void d() {
        ay0 ay0Var = this.d;
        ay0Var.getClass();
        ay0Var.f().close();
    }

    @Override // defpackage.rj0
    public final void e() {
        this.c.flush();
    }

    @Override // defpackage.rj0
    public final long f(z62 z62Var) {
        if (cy0.a(z62Var)) {
            return z53.k(z62Var);
        }
        return 0L;
    }

    @Override // defpackage.rj0
    public final y62 g(boolean z) throws IOException {
        ew0 ew0Var;
        ay0 ay0Var = this.d;
        if (ay0Var == null) {
            dk0.h("stream wasn't created");
            return null;
        }
        synchronized (ay0Var) {
            ay0Var.k.i();
            while (ay0Var.g.isEmpty() && ay0Var.m == 0) {
                try {
                    try {
                        ay0Var.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    ay0Var.k.l();
                    throw th;
                }
            }
            ay0Var.k.l();
            if (ay0Var.g.isEmpty()) {
                IOException iOException = ay0Var.n;
                if (iOException != null) {
                    throw iOException;
                }
                int i = ay0Var.m;
                if (i != 0) {
                    throw new wr2(i);
                }
                throw null;
            }
            Object objRemoveFirst = ay0Var.g.removeFirst();
            objRemoveFirst.getClass();
            ew0Var = (ew0) objRemoveFirst;
        }
        y12 y12Var = this.e;
        y12Var.getClass();
        ArrayList arrayList = new ArrayList(20);
        int size = ew0Var.size();
        t9 t9VarC = null;
        for (int i2 = 0; i2 < size; i2++) {
            String strB = ew0Var.b(i2);
            String strF = ew0Var.f(i2);
            if (g31.a(strB, ":status")) {
                t9VarC = na4.c("HTTP/1.1 " + strF);
            } else if (!h.contains(strB)) {
                strB.getClass();
                strF.getClass();
                arrayList.add(strB);
                arrayList.add(cs2.V(strF).toString());
            }
        }
        if (t9VarC == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        y62 y62Var = new y62();
        y62Var.b = y12Var;
        y62Var.c = t9VarC.b;
        y62Var.d = (String) t9VarC.e;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        uf1 uf1Var = new uf1(22);
        ArrayList arrayList2 = (ArrayList) uf1Var.b;
        arrayList2.getClass();
        strArr.getClass();
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        arrayList2.addAll(listAsList);
        y62Var.f = uf1Var;
        if (z && y62Var.c == 100) {
            return null;
        }
        return y62Var;
    }

    @Override // defpackage.rj0
    public final q32 h() {
        return this.a;
    }
}
