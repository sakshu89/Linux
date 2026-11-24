package defpackage;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wt3 {
    public static final wt3 c = new wt3(0);
    public final hv3 a = new hv3();
    public boolean b;

    public wt3(int i) {
        d();
        d();
    }

    public static int a(sv3 sv3Var, int i, Object obj) {
        int iD;
        int iB;
        int iB2 = st3.b(i << 3);
        if (sv3Var == sv3.f) {
            Charset charset = nu3.a;
            iB2 += iB2;
        }
        tv3 tv3Var = tv3.a;
        int iC = 4;
        switch (sv3Var.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                iC = 8;
                return iB2 + iC;
            case 1:
                ((Float) obj).getClass();
                return iB2 + iC;
            case 2:
                iC = st3.c(((Long) obj).longValue());
                return iB2 + iC;
            case 3:
                iC = st3.c(((Long) obj).longValue());
                return iB2 + iC;
            case 4:
                iC = st3.c(((Integer) obj).intValue());
                return iB2 + iC;
            case 5:
                ((Long) obj).getClass();
                iC = 8;
                return iB2 + iC;
            case 6:
                ((Integer) obj).getClass();
                return iB2 + iC;
            case 7:
                ((Boolean) obj).getClass();
                iC = 1;
                return iB2 + iC;
            case 8:
                if (obj instanceof rt3) {
                    iD = ((rt3) obj).d();
                    iB = st3.b(iD);
                    iC = iB + iD;
                } else {
                    iC = st3.a((String) obj);
                }
                return iB2 + iC;
            case 9:
                iC = ((gu3) ((jt3) obj)).j();
                return iB2 + iC;
            case 10:
                iD = ((gu3) ((jt3) obj)).j();
                iB = st3.b(iD);
                iC = iB + iD;
                return iB2 + iC;
            case 11:
                if (obj instanceof rt3) {
                    iD = ((rt3) obj).d();
                    iB = st3.b(iD);
                } else {
                    iD = ((byte[]) obj).length;
                    iB = st3.b(iD);
                }
                iC = iB + iD;
                return iB2 + iC;
            case 12:
                iC = st3.b(((Integer) obj).intValue());
                return iB2 + iC;
            case 13:
                iC = st3.c(((Integer) obj).intValue());
                return iB2 + iC;
            case 14:
                ((Integer) obj).getClass();
                return iB2 + iC;
            case 15:
                ((Long) obj).getClass();
                iC = 8;
                return iB2 + iC;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iC = st3.b((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iB2 + iC;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iC = st3.c((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iB2 + iC;
            default:
                og.p("There is no way to get here, but the compiler thinks otherwise.");
                return 0;
        }
    }

    public static void e(st3 st3Var, sv3 sv3Var, int i, Object obj) throws jz {
        if (sv3Var == sv3.f) {
            Charset charset = nu3.a;
            st3Var.n(i, 3);
            ((gu3) ((jt3) obj)).h(st3Var);
            st3Var.n(i, 4);
            return;
        }
        st3Var.n(i, sv3Var.b);
        tv3 tv3Var = tv3.a;
        switch (sv3Var.ordinal()) {
            case 0:
                st3Var.j(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                st3Var.h(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                st3Var.r(((Long) obj).longValue());
                break;
            case 3:
                st3Var.r(((Long) obj).longValue());
                break;
            case 4:
                st3Var.l(((Integer) obj).intValue());
                break;
            case 5:
                st3Var.j(((Long) obj).longValue());
                break;
            case 6:
                st3Var.h(((Integer) obj).intValue());
                break;
            case 7:
                st3Var.d(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof rt3)) {
                    st3Var.m((String) obj);
                } else {
                    st3Var.f((rt3) obj);
                }
                break;
            case 9:
                ((gu3) ((jt3) obj)).h(st3Var);
                break;
            case 10:
                gu3 gu3Var = (gu3) ((jt3) obj);
                st3Var.p(gu3Var.j());
                gu3Var.h(st3Var);
                break;
            case 11:
                if (!(obj instanceof rt3)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    st3Var.p(length);
                    st3Var.e(bArr, length);
                } else {
                    st3Var.f((rt3) obj);
                }
                break;
            case 12:
                st3Var.p(((Integer) obj).intValue());
                break;
            case 13:
                st3Var.l(((Integer) obj).intValue());
                break;
            case 14:
                st3Var.h(((Integer) obj).intValue());
                break;
            case 15:
                st3Var.j(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                st3Var.p((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                st3Var.r((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public static boolean h(Map.Entry entry) {
        throw null;
    }

    public static final int i(Map.Entry entry) {
        entry.getValue();
        throw null;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final wt3 clone() {
        wt3 wt3Var = new wt3();
        hv3 hv3Var = this.a;
        if (hv3Var.b > 0) {
            ((eu3) hv3Var.c(0).a).getClass();
            throw null;
        }
        Iterator it = hv3Var.a().iterator();
        if (!it.hasNext()) {
            return wt3Var;
        }
        Map.Entry entry = (Map.Entry) it.next();
        eu3 eu3Var = (eu3) entry.getKey();
        entry.getValue();
        eu3Var.getClass();
        throw null;
    }

    public final Iterator c() {
        hv3 hv3Var = this.a;
        return hv3Var.isEmpty() ? Collections.emptyIterator() : ((ig) hv3Var.entrySet()).iterator();
    }

    public final void d() {
        if (this.b) {
            return;
        }
        hv3 hv3Var = this.a;
        int i = hv3Var.b;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = hv3Var.c(i2).b;
            if (obj instanceof gu3) {
                gu3 gu3Var = (gu3) obj;
                gu3Var.getClass();
                bv3.c.a(gu3Var.getClass()).g(gu3Var);
                gu3Var.c();
            }
        }
        if (!hv3Var.e) {
            for (int i3 = 0; i3 < hv3Var.b; i3++) {
                ((eu3) hv3Var.c(i3).a).getClass();
            }
            Iterator it = hv3Var.a().iterator();
            while (it.hasNext()) {
                ((eu3) ((Map.Entry) it.next()).getKey()).getClass();
            }
        }
        if (!hv3Var.e) {
            hv3Var.c = hv3Var.c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(hv3Var.c);
            hv3Var.i = hv3Var.i.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(hv3Var.i);
            hv3Var.e = true;
        }
        this.b = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof wt3) {
            return this.a.equals(((wt3) obj).a);
        }
        return false;
    }

    public final boolean f() {
        hv3 hv3Var = this.a;
        int i = hv3Var.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (!h(hv3Var.c(i2))) {
                return false;
            }
        }
        Iterator it = hv3Var.a().iterator();
        while (it.hasNext()) {
            if (!h((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void g(Map.Entry entry) {
        eu3 eu3Var = (eu3) entry.getKey();
        entry.getValue();
        eu3Var.getClass();
        throw null;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public wt3() {
    }
}
