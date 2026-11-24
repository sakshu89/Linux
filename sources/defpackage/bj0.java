package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bj0 extends dk1 implements f71 {
    public f23 H;
    public f23 X;
    public cj0 Y;
    public mk0 Z;
    public fq0 c0;
    public ui0 d0;
    public long e0 = -9223372034707292160L;
    public c6 f0;
    public final h6 g0;
    public j23 x;

    public bj0(j23 j23Var, f23 f23Var, f23 f23Var2, cj0 cj0Var, mk0 mk0Var, fq0 fq0Var, ui0 ui0Var) {
        this.x = j23Var;
        this.H = f23Var;
        this.X = f23Var2;
        this.Y = cj0Var;
        this.Z = mk0Var;
        this.c0 = fq0Var;
        this.d0 = ui0Var;
        r40.b(0, 0, 15);
        this.g0 = new h6(11, this);
        new kt1(16, this);
    }

    @Override // defpackage.dk1
    public final void A0() {
        this.e0 = -9223372034707292160L;
    }

    @Override // defpackage.f71
    public final int B(mf1 mf1Var, jh1 jh1Var, int i) {
        return jh1Var.e0(i);
    }

    public final c6 I0() {
        c6 c6Var;
        c6 c6Var2;
        if (this.x.f().a(si0.a, si0.b)) {
            zw zwVar = this.Y.a.b;
            if (zwVar != null && (c6Var2 = zwVar.a) != null) {
                return c6Var2;
            }
            zw zwVar2 = this.Z.a.b;
            if (zwVar2 != null) {
                return zwVar2.a;
            }
            return null;
        }
        zw zwVar3 = this.Z.a.b;
        if (zwVar3 != null && (c6Var = zwVar3.a) != null) {
            return c6Var;
        }
        zw zwVar4 = this.Y.a.b;
        if (zwVar4 != null) {
            return zwVar4.a;
        }
        return null;
    }

    @Override // defpackage.f71
    public final int S(mf1 mf1Var, jh1 jh1Var, int i) {
        return jh1Var.V(i);
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        e23 e23VarA;
        long jA;
        if (this.x.c() == this.x.d.getValue()) {
            this.f0 = null;
        } else if (this.f0 == null) {
            c6 c6VarI0 = I0();
            if (c6VarI0 == null) {
                c6VarI0 = xy.b;
            }
            this.f0 = c6VarI0;
        }
        boolean zS = qh1Var.s();
        ji0 ji0Var = ji0.a;
        if (zS) {
            zw1 zw1VarE = jh1Var.e(j);
            long j2 = (((long) zw1VarE.a) << 32) | (((long) zw1VarE.b) & 4294967295L);
            this.e0 = j2;
            return qh1Var.j0((int) (j2 >> 32), (int) (j2 & 4294967295L), ji0Var, new d7(zw1VarE, 3));
        }
        if (!((Boolean) this.c0.a()).booleanValue()) {
            zw1 zw1VarE2 = jh1Var.e(j);
            return qh1Var.j0(zw1VarE2.a, zw1VarE2.b, ji0Var, new d7(zw1VarE2, 4));
        }
        ui0 ui0Var = this.d0;
        f23 f23Var = ui0Var.a;
        j23 j23Var = ui0Var.b;
        cj0 cj0Var = ui0Var.c;
        mk0 mk0Var = ui0Var.d;
        e23 e23VarA2 = f23Var != null ? f23Var.a(new vi0(cj0Var, mk0Var, 0), new vi0(cj0Var, mk0Var, 1)) : null;
        j23Var.c();
        ke0 ke0Var = new ke0(e23VarA2, null, null, 1);
        zw1 zw1VarE3 = jh1Var.e(j);
        long j3 = (((long) zw1VarE3.a) << 32) | (((long) zw1VarE3.b) & 4294967295L);
        long j4 = !l21.a(this.e0, -9223372034707292160L) ? this.e0 : j3;
        f23 f23Var2 = this.H;
        if (f23Var2 != null) {
            e23VarA = f23Var2.a(this.g0, new aj0(this, j4, 0));
        } else {
            e23VarA = null;
        }
        if (e23VarA != null) {
            j3 = ((l21) e23VarA.getValue()).a;
        }
        long jD = r40.d(j, j3);
        f23 f23Var3 = this.X;
        long j5 = f23Var3 != null ? ((e21) f23Var3.a(j7.d0, new aj0(this, j4, 1)).getValue()).a : 0L;
        c6 c6Var = this.f0;
        if (c6Var != null) {
            jA = c6Var.a(j4, jD, z61.a);
        } else {
            jA = 0;
        }
        return qh1Var.j0((int) (jD >> 32), (int) (jD & 4294967295L), ji0Var, new zi0(zw1VarE3, e21.c(jA, 0L), j5, ke0Var));
    }

    @Override // defpackage.f71
    public final int e(mf1 mf1Var, jh1 jh1Var, int i) {
        return jh1Var.c0(i);
    }

    @Override // defpackage.f71
    public final int n(mf1 mf1Var, jh1 jh1Var, int i) {
        return jh1Var.f(i);
    }
}
