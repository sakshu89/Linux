package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ay2 {
    public final be a;
    public final long b;
    public final gz2 c;
    public final mp1 d;
    public final nz2 e;
    public long f;
    public final be g;
    public final ty2 h;
    public final hz2 i;

    public ay2(ty2 ty2Var, mp1 mp1Var, hz2 hz2Var, nz2 nz2Var) {
        be beVar = ty2Var.a;
        long j = ty2Var.b;
        gz2 gz2Var = hz2Var != null ? hz2Var.a : null;
        this.a = beVar;
        this.b = j;
        this.c = gz2Var;
        this.d = mp1Var;
        this.e = nz2Var;
        this.f = j;
        this.g = beVar;
        this.h = ty2Var;
        this.i = hz2Var;
    }

    public final List a(hq0 hq0Var) {
        if (!oz2.c(this.f)) {
            return nz.i(new r00("", 0), new vh2(oz2.f(this.f), oz2.f(this.f)));
        }
        fh0 fh0Var = (fh0) hq0Var.j(this);
        if (fh0Var != null) {
            return nz.h(fh0Var);
        }
        return null;
    }

    public final Integer b() {
        gz2 gz2Var = this.c;
        if (gz2Var == null) {
            return null;
        }
        fl1 fl1Var = gz2Var.b;
        int iE = oz2.e(this.f);
        mp1 mp1Var = this.d;
        return Integer.valueOf(mp1Var.k(fl1Var.c(fl1Var.d(mp1Var.l(iE)), true)));
    }

    public final Integer c() {
        gz2 gz2Var = this.c;
        if (gz2Var == null) {
            return null;
        }
        int iF = oz2.f(this.f);
        mp1 mp1Var = this.d;
        return Integer.valueOf(mp1Var.k(gz2Var.f(gz2Var.b.d(mp1Var.l(iF)))));
    }

    public final Integer d() {
        int length;
        gz2 gz2Var = this.c;
        if (gz2Var == null) {
            return null;
        }
        int iR = r();
        while (true) {
            be beVar = this.a;
            if (iR < beVar.b.length()) {
                int length2 = this.g.b.length() - 1;
                if (iR <= length2) {
                    length2 = iR;
                }
                long jI = gz2Var.i(length2);
                int i = oz2.c;
                int i2 = (int) (jI & 4294967295L);
                if (i2 > iR) {
                    length = this.d.k(i2);
                    break;
                }
                iR++;
            } else {
                length = beVar.b.length();
                break;
            }
        }
        return Integer.valueOf(length);
    }

    public final Integer e() {
        int iK;
        gz2 gz2Var = this.c;
        if (gz2Var == null) {
            return null;
        }
        for (int iR = r(); iR > 0; iR--) {
            int length = this.g.b.length() - 1;
            if (iR <= length) {
                length = iR;
            }
            long jI = gz2Var.i(length);
            int i = oz2.c;
            int i2 = (int) (jI >> 32);
            if (i2 < iR) {
                iK = this.d.k(i2);
                return Integer.valueOf(iK);
            }
        }
        iK = 0;
        return Integer.valueOf(iK);
    }

    public final boolean f() {
        gz2 gz2Var = this.c;
        return (gz2Var != null ? gz2Var.g(r()) : null) != p62.b;
    }

    public final int g(gz2 gz2Var, int i) {
        int iR = r();
        nz2 nz2Var = this.e;
        if (nz2Var.a == null) {
            nz2Var.a = Float.valueOf(gz2Var.c(iR).a);
        }
        fl1 fl1Var = gz2Var.b;
        int iD = fl1Var.d(iR) + i;
        if (iD < 0) {
            return 0;
        }
        if (iD >= fl1Var.f) {
            return this.g.b.length();
        }
        float fB = fl1Var.b(iD) - 1.0f;
        Float f = nz2Var.a;
        f.getClass();
        float fFloatValue = f.floatValue();
        if ((f() && fFloatValue >= gz2Var.e(iD)) || (!f() && fFloatValue <= gz2Var.d(iD))) {
            return fl1Var.c(iD, true);
        }
        return this.d.k(fl1Var.g((((long) Float.floatToRawIntBits(fB)) & 4294967295L) | (Float.floatToRawIntBits(f.floatValue()) << 32)));
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public final int h(hz2 hz2Var, int i) {
        l42 l42VarN;
        y61 y61Var = hz2Var.b;
        gz2 gz2Var = hz2Var.a;
        if (y61Var == null) {
            l42VarN = l42.e;
        } else {
            y61 y61Var2 = hz2Var.c;
            l42VarN = y61Var2 != null ? y61Var2.N(y61Var, true) : null;
            if (l42VarN == null) {
                l42VarN = l42.e;
            }
        }
        long j = this.h.b;
        int i2 = oz2.c;
        mp1 mp1Var = this.d;
        l42 l42VarC = gz2Var.c(mp1Var.l((int) (j & 4294967295L)));
        float f = l42VarC.a;
        return mp1Var.k(gz2Var.b.g((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (l42VarN.c() & 4294967295L)) * i) + l42VarC.b)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
    }

    public final void i() {
        nz2 nz2Var = this.e;
        nz2Var.a = null;
        be beVar = this.g;
        if (beVar.b.length() > 0) {
            if (f()) {
                k();
                return;
            }
            nz2Var.a = null;
            if (beVar.b.length() > 0) {
                String str = beVar.b;
                long j = this.f;
                int i = oz2.c;
                int iA = ra4.a((int) (j & 4294967295L), str);
                if (iA != -1) {
                    q(iA, iA);
                }
            }
        }
    }

    public final void j() {
        this.e.a = null;
        be beVar = this.g;
        String str = beVar.b;
        String str2 = beVar.b;
        if (str.length() > 0) {
            int iA = pa4.a(str2, oz2.e(this.f));
            if (iA == oz2.e(this.f) && iA != str2.length()) {
                iA = pa4.a(str2, iA + 1);
            }
            q(iA, iA);
        }
    }

    public final void k() {
        this.e.a = null;
        be beVar = this.g;
        if (beVar.b.length() > 0) {
            String str = beVar.b;
            long j = this.f;
            int i = oz2.c;
            int iB = ra4.b((int) (j & 4294967295L), str);
            if (iB != -1) {
                q(iB, iB);
            }
        }
    }

    public final void l() {
        this.e.a = null;
        be beVar = this.g;
        String str = beVar.b;
        String str2 = beVar.b;
        if (str.length() > 0) {
            int iB = pa4.b(str2, oz2.f(this.f));
            if (iB == oz2.f(this.f) && iB != 0) {
                iB = pa4.b(str2, iB - 1);
            }
            q(iB, iB);
        }
    }

    public final void m() {
        nz2 nz2Var = this.e;
        nz2Var.a = null;
        be beVar = this.g;
        if (beVar.b.length() > 0) {
            if (!f()) {
                k();
                return;
            }
            nz2Var.a = null;
            if (beVar.b.length() > 0) {
                String str = beVar.b;
                long j = this.f;
                int i = oz2.c;
                int iA = ra4.a((int) (j & 4294967295L), str);
                if (iA != -1) {
                    q(iA, iA);
                }
            }
        }
    }

    public final void n() {
        Integer numB;
        this.e.a = null;
        if (this.g.b.length() <= 0 || (numB = b()) == null) {
            return;
        }
        int iIntValue = numB.intValue();
        q(iIntValue, iIntValue);
    }

    public final void o() {
        Integer numC;
        this.e.a = null;
        if (this.g.b.length() <= 0 || (numC = c()) == null) {
            return;
        }
        int iIntValue = numC.intValue();
        q(iIntValue, iIntValue);
    }

    public final void p() {
        if (this.g.b.length() > 0) {
            int i = oz2.c;
            this.f = hc4.a((int) (this.b >> 32), (int) (this.f & 4294967295L));
        }
    }

    public final void q(int i, int i2) {
        this.f = hc4.a(i, i2);
    }

    public final int r() {
        long j = this.f;
        int i = oz2.c;
        return this.d.l((int) (j & 4294967295L));
    }
}
