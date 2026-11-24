package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iz {
    public final /* synthetic */ int a;
    public int b;
    public int c;
    public int d;
    public Object e;

    public iz(hz hzVar) {
        this.a = 0;
        this.d = 0;
        Charset charset = x21.a;
        this.e = hzVar;
        hzVar.b = this;
    }

    public void A(int i) throws n31 {
        if ((this.b & 7) != i) {
            throw o31.b();
        }
    }

    public boolean B() {
        int i;
        hz hzVar = (hz) this.e;
        if (hzVar.d() || (i = this.b) == this.c) {
            return false;
        }
        return hzVar.C(i);
    }

    public if2 a(int i) {
        return new if2(u24.a((gz2) this.e, i), i, 1L);
    }

    public int b() {
        return this.d - this.c;
    }

    public int c() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = ((hz) this.e).z();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public int d(int i) {
        return ((bs1) this.e).c[this.c + i];
    }

    public Object e(int i) {
        return ((bs1) this.e).e[this.d + i];
    }

    public void f(Object obj, db2 db2Var, wk0 wk0Var) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            db2Var.h(obj, this, wk0Var);
            if (this.b != this.c) {
                throw new o31("Failed to parse the message.");
            }
            this.c = i;
        } catch (Throwable th) {
            this.c = i;
            throw th;
        }
    }

    public void g(Object obj, db2 db2Var, wk0 wk0Var) throws o31 {
        hz hzVar = (hz) this.e;
        int iA = hzVar.A();
        if (hzVar.a >= 100) {
            throw new o31("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iJ = hzVar.j(iA);
        hzVar.a++;
        db2Var.h(obj, this, wk0Var);
        hzVar.b(0);
        hzVar.a--;
        hzVar.i(iJ);
    }

    public void h(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 0) {
            do {
                ((x12) w21Var).add(Boolean.valueOf(hzVar.k()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iC = hzVar.c() + hzVar.A();
        do {
            ((x12) w21Var).add(Boolean.valueOf(hzVar.k()));
        } while (hzVar.c() < iC);
        z(iC);
    }

    public no i() throws n31 {
        A(2);
        return ((hz) this.e).l();
    }

    public void j(w21 w21Var) throws n31 {
        int iZ;
        hz hzVar = (hz) this.e;
        if ((this.b & 7) != 2) {
            throw o31.b();
        }
        do {
            ((x12) w21Var).add(i());
            if (hzVar.d()) {
                return;
            } else {
                iZ = hzVar.z();
            }
        } while (iZ == this.b);
        this.d = iZ;
    }

    public void k(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 1) {
            do {
                ((x12) w21Var).add(Double.valueOf(hzVar.m()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iA = hzVar.A();
        if ((iA & 7) != 0) {
            throw new o31("Failed to parse the message.");
        }
        int iC = hzVar.c() + iA;
        do {
            ((x12) w21Var).add(Double.valueOf(hzVar.m()));
        } while (hzVar.c() < iC);
    }

    public void l(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 0) {
            do {
                ((x12) w21Var).add(Integer.valueOf(hzVar.n()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iC = hzVar.c() + hzVar.A();
        do {
            ((x12) w21Var).add(Integer.valueOf(hzVar.n()));
        } while (hzVar.c() < iC);
        z(iC);
    }

    public Object m(jc3 jc3Var, Class cls, wk0 wk0Var) throws o31 {
        hz hzVar = (hz) this.e;
        switch (jc3Var.ordinal()) {
            case 0:
                A(1);
                return Double.valueOf(hzVar.m());
            case 1:
                A(5);
                return Float.valueOf(hzVar.q());
            case 2:
                A(0);
                return Long.valueOf(hzVar.s());
            case 3:
                A(0);
                return Long.valueOf(hzVar.B());
            case 4:
                A(0);
                return Integer.valueOf(hzVar.r());
            case 5:
                A(1);
                return Long.valueOf(hzVar.p());
            case 6:
                A(5);
                return Integer.valueOf(hzVar.o());
            case 7:
                A(0);
                return Boolean.valueOf(hzVar.k());
            case 8:
                A(2);
                return hzVar.y();
            case 9:
            default:
                og.i("unsupported field type.");
                return null;
            case 10:
                A(2);
                db2 db2VarA = w12.c.a(cls);
                yt0 yt0VarI = db2VarA.i();
                g(yt0VarI, db2VarA, wk0Var);
                db2VarA.c(yt0VarI);
                return yt0VarI;
            case 11:
                return i();
            case 12:
                A(0);
                return Integer.valueOf(hzVar.A());
            case 13:
                A(0);
                return Integer.valueOf(hzVar.n());
            case 14:
                A(5);
                return Integer.valueOf(hzVar.t());
            case 15:
                A(1);
                return Long.valueOf(hzVar.u());
            case 16:
                A(0);
                return Integer.valueOf(hzVar.v());
            case 17:
                A(0);
                return Long.valueOf(hzVar.w());
        }
    }

    public void n(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 2) {
            int iA = hzVar.A();
            if ((iA & 3) != 0) {
                throw new o31("Failed to parse the message.");
            }
            int iC = hzVar.c() + iA;
            do {
                ((x12) w21Var).add(Integer.valueOf(hzVar.o()));
            } while (hzVar.c() < iC);
            return;
        }
        if (i != 5) {
            throw o31.b();
        }
        do {
            ((x12) w21Var).add(Integer.valueOf(hzVar.o()));
            if (hzVar.d()) {
                return;
            } else {
                iZ = hzVar.z();
            }
        } while (iZ == this.b);
        this.d = iZ;
    }

    public void o(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 1) {
            do {
                ((x12) w21Var).add(Long.valueOf(hzVar.p()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iA = hzVar.A();
        if ((iA & 7) != 0) {
            throw new o31("Failed to parse the message.");
        }
        int iC = hzVar.c() + iA;
        do {
            ((x12) w21Var).add(Long.valueOf(hzVar.p()));
        } while (hzVar.c() < iC);
    }

    public void p(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 2) {
            int iA = hzVar.A();
            if ((iA & 3) != 0) {
                throw new o31("Failed to parse the message.");
            }
            int iC = hzVar.c() + iA;
            do {
                ((x12) w21Var).add(Float.valueOf(hzVar.q()));
            } while (hzVar.c() < iC);
            return;
        }
        if (i != 5) {
            throw o31.b();
        }
        do {
            ((x12) w21Var).add(Float.valueOf(hzVar.q()));
            if (hzVar.d()) {
                return;
            } else {
                iZ = hzVar.z();
            }
        } while (iZ == this.b);
        this.d = iZ;
    }

    public void q(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 0) {
            do {
                ((x12) w21Var).add(Integer.valueOf(hzVar.r()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iC = hzVar.c() + hzVar.A();
        do {
            ((x12) w21Var).add(Integer.valueOf(hzVar.r()));
        } while (hzVar.c() < iC);
        z(iC);
    }

    public void r(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 0) {
            do {
                ((x12) w21Var).add(Long.valueOf(hzVar.s()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iC = hzVar.c() + hzVar.A();
        do {
            ((x12) w21Var).add(Long.valueOf(hzVar.s()));
        } while (hzVar.c() < iC);
        z(iC);
    }

    public void s(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 2) {
            int iA = hzVar.A();
            if ((iA & 3) != 0) {
                throw new o31("Failed to parse the message.");
            }
            int iC = hzVar.c() + iA;
            do {
                ((x12) w21Var).add(Integer.valueOf(hzVar.t()));
            } while (hzVar.c() < iC);
            return;
        }
        if (i != 5) {
            throw o31.b();
        }
        do {
            ((x12) w21Var).add(Integer.valueOf(hzVar.t()));
            if (hzVar.d()) {
                return;
            } else {
                iZ = hzVar.z();
            }
        } while (iZ == this.b);
        this.d = iZ;
    }

    public void t(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 1) {
            do {
                ((x12) w21Var).add(Long.valueOf(hzVar.u()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iA = hzVar.A();
        if ((iA & 7) != 0) {
            throw new o31("Failed to parse the message.");
        }
        int iC = hzVar.c() + iA;
        do {
            ((x12) w21Var).add(Long.valueOf(hzVar.u()));
        } while (hzVar.c() < iC);
    }

    public String toString() {
        switch (this.a) {
            case 1:
                return "";
            case 2:
            default:
                return super.toString();
            case 3:
                StringBuilder sb = new StringBuilder("SelectionInfo(id=1, range=(");
                int i = this.b;
                sb.append(i);
                sb.append('-');
                gz2 gz2Var = (gz2) this.e;
                sb.append(u24.a(gz2Var, i));
                sb.append(',');
                int i2 = this.c;
                sb.append(i2);
                sb.append('-');
                sb.append(u24.a(gz2Var, i2));
                sb.append("), prevOffset=");
                return ky0.m(sb, this.d, ')');
        }
    }

    public void u(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 0) {
            do {
                ((x12) w21Var).add(Integer.valueOf(hzVar.v()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iC = hzVar.c() + hzVar.A();
        do {
            ((x12) w21Var).add(Integer.valueOf(hzVar.v()));
        } while (hzVar.c() < iC);
        z(iC);
    }

    public void v(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 0) {
            do {
                ((x12) w21Var).add(Long.valueOf(hzVar.w()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iC = hzVar.c() + hzVar.A();
        do {
            ((x12) w21Var).add(Long.valueOf(hzVar.w()));
        } while (hzVar.c() < iC);
        z(iC);
    }

    public void w(w21 w21Var, boolean z) throws n31 {
        String strX;
        int iZ;
        hz hzVar = (hz) this.e;
        if ((this.b & 7) != 2) {
            throw o31.b();
        }
        do {
            if (z) {
                A(2);
                strX = hzVar.y();
            } else {
                A(2);
                strX = hzVar.x();
            }
            ((x12) w21Var).add(strX);
            if (hzVar.d()) {
                return;
            } else {
                iZ = hzVar.z();
            }
        } while (iZ == this.b);
        this.d = iZ;
    }

    public void x(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 0) {
            do {
                ((x12) w21Var).add(Integer.valueOf(hzVar.A()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iC = hzVar.c() + hzVar.A();
        do {
            ((x12) w21Var).add(Integer.valueOf(hzVar.A()));
        } while (hzVar.c() < iC);
        z(iC);
    }

    public void y(w21 w21Var) throws o31 {
        int iZ;
        hz hzVar = (hz) this.e;
        int i = this.b & 7;
        if (i == 0) {
            do {
                ((x12) w21Var).add(Long.valueOf(hzVar.B()));
                if (hzVar.d()) {
                    return;
                } else {
                    iZ = hzVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        if (i != 2) {
            throw o31.b();
        }
        int iC = hzVar.c() + hzVar.A();
        do {
            ((x12) w21Var).add(Long.valueOf(hzVar.B()));
        } while (hzVar.c() < iC);
        z(iC);
    }

    public void z(int i) throws o31 {
        if (((hz) this.e).c() != i) {
            throw o31.e();
        }
    }

    public /* synthetic */ iz() {
        this.a = 1;
    }

    public iz(bs1 bs1Var) {
        this.a = 2;
        this.e = bs1Var;
    }

    public iz(int i, int i2, int i3, gz2 gz2Var) {
        this.a = 3;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = gz2Var;
    }
}
