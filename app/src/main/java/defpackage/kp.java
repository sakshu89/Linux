package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kp implements v21 {
    public final boolean a;

    public kp(boolean z) {
        this.a = z;
    }

    @Override // defpackage.v21
    public final z62 a(s32 s32Var) throws IllegalAccessException, IOException, InvocationTargetException {
        y62 y62VarD;
        IOException iOException;
        z62 z62VarA;
        ux uxVar = s32Var.d;
        uxVar.getClass();
        m32 m32Var = (m32) uxVar.b;
        rj0 rj0Var = (rj0) uxVar.d;
        q32 q32Var = (q32) uxVar.e;
        lj1 lj1Var = s32Var.e;
        t9 t9Var = (t9) lj1Var.e;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                rj0Var.b(lj1Var);
                boolean z = true;
                try {
                    if (!qo4.a((String) lj1Var.c) || t9Var == null) {
                        m32Var.h(uxVar, true, false, null);
                        y62VarD = null;
                    } else {
                        if ("100-continue".equalsIgnoreCase(((ew0) lj1Var.d).a("Expect"))) {
                            try {
                                rj0Var.e();
                                y62VarD = uxVar.d(true);
                            } catch (IOException e) {
                                uxVar.e(e);
                                throw e;
                            }
                        } else {
                            y62VarD = null;
                        }
                        if (y62VarD == null) {
                            t9Var.getClass();
                            long j = t9Var.b;
                            h32 h32Var = new h32(new pj0(uxVar, rj0Var.a(lj1Var, j), j));
                            byte[] bArr = (byte[]) t9Var.e;
                            int i = t9Var.b;
                            if (h32Var.c) {
                                throw new IllegalStateException("closed");
                            }
                            h32Var.b.C(bArr, i);
                            h32Var.c();
                            h32Var.close();
                        } else {
                            m32Var.h(uxVar, true, false, null);
                            if (q32Var.g == null) {
                                z = false;
                            }
                            if (!z) {
                                rj0Var.h().k();
                            }
                        }
                    }
                    try {
                        rj0Var.d();
                        iOException = null;
                        if (y62VarD == null) {
                            try {
                                y62VarD = uxVar.d(false);
                                y62VarD.getClass();
                            } catch (IOException e2) {
                                if (iOException == null) {
                                    throw e2;
                                }
                                gn4.a(iOException, e2);
                                throw iOException;
                            }
                        }
                        y62VarD.a = lj1Var;
                        y62VarD.e = q32Var.e;
                        y62VarD.k = jCurrentTimeMillis;
                        y62VarD.l = System.currentTimeMillis();
                        z62 z62VarA2 = y62VarD.a();
                        int i2 = z62VarA2.e;
                        if (i2 == 100 || (102 <= i2 && i2 < 200)) {
                            y62 y62VarD2 = uxVar.d(false);
                            y62VarD2.getClass();
                            y62VarD2.a = lj1Var;
                            y62VarD2.e = q32Var.e;
                            y62VarD2.k = jCurrentTimeMillis;
                            y62VarD2.l = System.currentTimeMillis();
                            z62VarA2 = y62VarD2.a();
                            i2 = z62VarA2.e;
                        }
                        if (this.a && i2 == 101) {
                            y62 y62VarE = z62VarA2.e();
                            y62VarE.g = z53.c;
                            z62VarA = y62VarE.a();
                        } else {
                            y62 y62VarE2 = z62VarA2.e();
                            try {
                                String strC = z62.c(z62VarA2, "Content-Type");
                                long jF = rj0Var.f(z62VarA2);
                                y62VarE2.g = new t32(strC, jF, new i32(new qj0(uxVar, rj0Var.c(z62VarA2), jF)));
                                z62VarA = y62VarE2.a();
                            } catch (IOException e3) {
                                uxVar.e(e3);
                                throw e3;
                            }
                        }
                        lj1 lj1Var2 = z62VarA.a;
                        lj1Var2.getClass();
                        if ("close".equalsIgnoreCase(((ew0) lj1Var2.d).a("Connection")) || "close".equalsIgnoreCase(z62.c(z62VarA, "Connection"))) {
                            rj0Var.h().k();
                        }
                        if (i2 == 204 || i2 == 205) {
                            b72 b72Var = z62VarA.j;
                            if ((b72Var != null ? b72Var.c() : -1L) > 0) {
                                StringBuilder sb = new StringBuilder("HTTP ");
                                sb.append(i2);
                                sb.append(" had non-zero Content-Length: ");
                                b72 b72Var2 = z62VarA.j;
                                sb.append(b72Var2 != null ? Long.valueOf(b72Var2.c()) : null);
                                throw new ProtocolException(sb.toString());
                            }
                        }
                        return z62VarA;
                    } catch (IOException e4) {
                        uxVar.e(e4);
                        throw e4;
                    }
                } catch (IOException e5) {
                    e = e5;
                    if (!(e instanceof y30) || !uxVar.a) {
                        throw e;
                    }
                    iOException = e;
                }
            } catch (IOException e6) {
                uxVar.e(e6);
                throw e6;
            }
        } catch (IOException e7) {
            e = e7;
            y62VarD = null;
            if (!(e instanceof y30)) {
                throw e;
            }
            throw e;
        }
    }
}
