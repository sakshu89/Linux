package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class na4 {
    public static final qs4 a = new qs4(18);
    public static final Object b = new Object();

    public static final void a(ek1 ek1Var, vq0 vq0Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-1298353104);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(vq0Var) ? 32 : 16;
        }
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            Object objL = x20Var.L();
            if (objL == r20.a) {
                objL = new ws2(y74.f);
                x20Var.g0(objL);
            }
            b((ws2) objL, ek1Var, vq0Var, x20Var, (i2 << 3) & 1008);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ss2(ek1Var, vq0Var, i);
        }
    }

    public static final void b(ws2 ws2Var, ek1 ek1Var, vq0 vq0Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-511989831);
        if ((i & 6) == 0) {
            i2 = (x20Var.h(ws2Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.f(ek1Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.h(vq0Var) ? 256 : 128;
        }
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            int iHashCode = Long.hashCode(x20Var.T);
            v20 v20VarA = aj4.a(x20Var);
            ek1 ek1VarC = gj4.c(x20Var, ek1Var);
            gw1 gw1VarL = x20Var.l();
            k30 k30Var = k30.k;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, ws2Var.c, ws2Var);
            ie4.c(x20Var, ws2Var.d, v20VarA);
            ie4.c(x20Var, ws2Var.e, vq0Var);
            o20.p.getClass();
            ie4.c(x20Var, n20.e, gw1VarL);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC);
            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
            x20Var.p(true);
            if (x20Var.A()) {
                x20Var.W(-1266202711);
            } else {
                x20Var.W(-1259244916);
                boolean zH = x20Var.h(ws2Var);
                Object objL = x20Var.L();
                if (zH || objL == r20.a) {
                    objL = new ta(16, ws2Var);
                    x20Var.g0(objL);
                }
                bz3.d((fq0) objL, x20Var);
            }
            x20Var.p(false);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ts2(ws2Var, ek1Var, vq0Var, i);
        }
    }

    public static t9 c(String str) throws ProtocolException {
        int i;
        String strSubstring;
        boolean zK = js2.k(str, "HTTP/1.", false);
        y12 y12Var = y12.HTTP_1_0;
        if (zK) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                y12Var = y12.HTTP_1_1;
            }
        } else {
            if (!js2.k(str, "ICY ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i3 = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i + 4);
            }
            return new t9(y12Var, i3, strSubstring, 7);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }
}
