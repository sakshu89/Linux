package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zu3 implements ev3 {
    public final jt3 a;
    public final el1 b;
    public final boolean c;

    public zu3(el1 el1Var, jt3 jt3Var) {
        nr4 nr4Var = vt3.a;
        this.b = el1Var;
        this.c = jt3Var instanceof du3;
        this.a = jt3Var;
    }

    @Override // defpackage.ev3
    public final boolean a(gu3 gu3Var, gu3 gu3Var2) {
        if (!gu3Var.zbc.equals(gu3Var2.zbc)) {
            return false;
        }
        if (this.c) {
            return ((du3) gu3Var).zbb.equals(((du3) gu3Var2).zbb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a A[EDGE_INSN: B:54:0x009a->B:30:0x009a BREAK  A[LOOP:1: B:16:0x005a->B:57:0x005a], SYNTHETIC] */
    @Override // defpackage.ev3
    public final void b(Object obj, byte[] bArr, int i, int i2, nt3 nt3Var) throws pu3 {
        int i3;
        gu3 gu3Var = (gu3) obj;
        kv3 kv3VarB = gu3Var.zbc;
        if (kv3VarB == kv3.f) {
            kv3VarB = kv3.b();
            gu3Var.zbc = kv3VarB;
        }
        kv3 kv3Var = kv3VarB;
        du3 du3Var = (du3) obj;
        wt3 wt3Var = du3Var.zbb;
        if (wt3Var.b) {
            du3Var.zbb = wt3Var.clone();
        }
        while (i < i2) {
            int i4 = tg4.i(bArr, i, nt3Var);
            int i5 = nt3Var.a;
            ut3 ut3Var = nt3Var.d;
            jt3 jt3Var = this.a;
            if (i5 == 11) {
                byte[] bArr2 = bArr;
                int i6 = i2;
                nt3 nt3Var2 = nt3Var;
                rt3 rt3Var = null;
                int i7 = 0;
                while (true) {
                    if (i4 >= i6) {
                        i3 = i4;
                        break;
                    }
                    i3 = tg4.i(bArr2, i4, nt3Var2);
                    int i8 = nt3Var2.a;
                    int i9 = i8 >>> 3;
                    int i10 = i8 & 7;
                    if (i9 == 2) {
                        if (i10 != 0) {
                            if (i8 != 12) {
                                break;
                                break;
                            }
                            i4 = tg4.o(i8, bArr2, i3, i6, nt3Var2);
                        } else {
                            i4 = tg4.i(bArr2, i3, nt3Var2);
                            i7 = nt3Var2.a;
                            ut3Var.getClass();
                        }
                    } else if (i9 != 3 || i10 != 2) {
                        if (i8 != 12) {
                            break;
                        } else {
                            i4 = tg4.o(i8, bArr2, i3, i6, nt3Var2);
                        }
                    } else {
                        i4 = tg4.b(bArr2, i3, nt3Var2);
                        rt3Var = (rt3) nt3Var2.c;
                    }
                }
                if (rt3Var != null) {
                    kv3Var.c((i7 << 3) | 2, rt3Var);
                }
                i = i3;
                bArr = bArr2;
                i2 = i6;
                nt3Var = nt3Var2;
            } else if ((i5 & 7) == 2) {
                ut3Var.getClass();
                i = tg4.h(i5, bArr, i4, i2, kv3Var, nt3Var);
            } else {
                i = tg4.o(i5, bArr, i4, i2, nt3Var);
            }
        }
        if (i == i2) {
            return;
        }
        kf2.j("Failed to parse the message.");
    }

    @Override // defpackage.ev3
    public final int c(gu3 gu3Var) {
        int iHashCode = gu3Var.zbc.hashCode();
        if (!this.c) {
            return iHashCode;
        }
        return ((du3) gu3Var).zbb.a.hashCode() + (iHashCode * 53);
    }

    @Override // defpackage.ev3
    public final boolean d(Object obj) {
        return ((du3) obj).zbb.f();
    }

    @Override // defpackage.ev3
    public final void e(Object obj, Object obj2) {
        fv3.p(obj, obj2);
        if (this.c) {
            nr4 nr4Var = vt3.a;
            fv3.o(obj, obj2);
        }
    }

    @Override // defpackage.ev3
    public final int f(jt3 jt3Var) {
        kv3 kv3Var = ((gu3) jt3Var).zbc;
        int iA = kv3Var.d;
        if (iA == -1) {
            iA = 0;
            for (int i = 0; i < kv3Var.a; i++) {
                int i2 = kv3Var.b[i] >>> 3;
                rt3 rt3Var = (rt3) kv3Var.c[i];
                int iB = st3.b(8);
                int iB2 = st3.b(i2) + st3.b(16);
                int iB3 = st3.b(24);
                int iD = rt3Var.d();
                iA += iB + iB + iB2 + ky0.A(iD, iD, iB3);
            }
            kv3Var.d = iA;
        }
        if (this.c) {
            hv3 hv3Var = ((du3) jt3Var).zbb.a;
            if (hv3Var.b > 0) {
                wt3.i(hv3Var.c(0));
                throw null;
            }
            Iterator it = hv3Var.a().iterator();
            if (it.hasNext()) {
                wt3.i((Map.Entry) it.next());
                throw null;
            }
        }
        return iA;
    }

    @Override // defpackage.ev3
    public final void g(Object obj) {
        this.b.getClass();
        kv3 kv3Var = ((gu3) obj).zbc;
        if (kv3Var.e) {
            kv3Var.e = false;
        }
        nr4 nr4Var = vt3.a;
        ((du3) obj).zbb.d();
    }

    @Override // defpackage.ev3
    public final void h(Object obj, py0 py0Var) throws jz {
        Iterator itC = ((du3) obj).zbb.c();
        if (itC.hasNext()) {
            throw null;
        }
        kv3 kv3Var = ((gu3) obj).zbc;
        for (int i = 0; i < kv3Var.a; i++) {
            int i2 = kv3Var.b[i] >>> 3;
            Object obj2 = kv3Var.c[i];
            boolean z = obj2 instanceof rt3;
            st3 st3Var = (st3) py0Var.b;
            if (z) {
                st3Var.p(11);
                st3Var.o(2, i2);
                st3Var.p(26);
                st3Var.f((rt3) obj2);
                st3Var.p(12);
            } else {
                st3Var.p(11);
                st3Var.o(2, i2);
                st3Var.p(26);
                gu3 gu3Var = (gu3) ((jt3) obj2);
                st3Var.p(gu3Var.j());
                gu3Var.h(st3Var);
                st3Var.p(12);
            }
        }
    }

    @Override // defpackage.ev3
    public final Object i() {
        jt3 jt3Var = this.a;
        return jt3Var instanceof gu3 ? (gu3) ((gu3) jt3Var).i(4, null) : ((au3) ((gu3) jt3Var).i(5, null)).c();
    }
}
