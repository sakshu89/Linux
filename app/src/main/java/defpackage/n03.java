package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n03 {
    public final int a;
    public final ck b;
    public final o0 c;
    public n03 d;
    public long e;
    public long f;
    public long g = Long.MIN_VALUE;
    public final /* synthetic */ o03 h;

    public n03(o03 o03Var, int i, ck ckVar, o0 o0Var) {
        this.h = o03Var;
        this.a = i;
        this.b = ckVar;
        this.c = o0Var;
    }

    public final void a(long j, long j2, long j3, long j4, float[] fArr) {
        b52 b52Var;
        b52 b52Var2;
        long j5 = this.h.f;
        ck ckVar = this.b;
        co1 co1VarE = cm4.e(ckVar, 2);
        n71 n71VarG = cm4.g(ckVar);
        boolean zI = n71VarG.I();
        zn1 zn1Var = n71VarG.o0;
        if (zI) {
            if (zn1Var.d != co1VarE) {
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (j >> 32)) << 32);
                long j6 = co1VarE.c;
                co1 co1Var = zn1Var.d;
                co1Var.getClass();
                long jB = ap4.b(co1Var.H(co1VarE, jFloatToRawIntBits));
                b52Var = new b52(jB, (4294967295L & ((long) (((int) (jB & 4294967295L)) + ((int) (j6 & 4294967295L))))) | (((long) (((int) (jB >> 32)) + ((int) (j6 >> 32)))) << 32), j3, j4, j5, fArr, ckVar);
            } else {
                b52Var = new b52(j, j2, j3, j4, j5, fArr, ckVar);
            }
            b52Var2 = b52Var;
        } else {
            b52Var2 = null;
        }
        if (b52Var2 == null) {
            return;
        }
        this.c.j(b52Var2);
    }

    public final void b() {
        o03 o03Var = this.h;
        ml1 ml1Var = o03Var.a;
        int i = this.a;
        n03 n03Var = (n03) ml1Var.g(i);
        if (n03Var != null) {
            if (n03Var == this) {
                n03 n03Var2 = this.d;
                this.d = null;
                if (n03Var2 == null) {
                    n71 n71VarG = cm4.g(this.b.a);
                    if (n71VarG.k) {
                        ((r7) q71.a(n71VarG)).getRectManager().a.f(n71VarG.b, false);
                        return;
                    }
                    return;
                }
                int iD = ml1Var.d(i);
                Object[] objArr = ml1Var.c;
                Object obj = objArr[iD];
                ml1Var.b[iD] = i;
                objArr[iD] = n03Var2;
                return;
            }
            int iD2 = ml1Var.d(i);
            Object[] objArr2 = ml1Var.c;
            Object obj2 = objArr2[iD2];
            ml1Var.b[iD2] = i;
            objArr2[iD2] = n03Var;
            while (true) {
                n03 n03Var3 = n03Var.d;
                if (n03Var3 == null) {
                    break;
                }
                if (n03Var3 == this) {
                    n03Var.d = this.d;
                    this.d = null;
                    return;
                }
                n03Var = n03Var3;
            }
        }
        n03 n03Var4 = o03Var.b;
        if (n03Var4 == this) {
            o03Var.b = n03Var4.d;
            this.d = null;
            return;
        }
        n03 n03Var5 = n03Var4 != null ? n03Var4.d : null;
        while (true) {
            n03 n03Var6 = n03Var4;
            n03Var4 = n03Var5;
            if (n03Var4 == null) {
                return;
            }
            if (n03Var4 == this) {
                if (n03Var6 != null) {
                    n03Var6.d = n03Var4.d;
                }
                this.d = null;
                return;
            }
            n03Var5 = n03Var4.d;
        }
    }
}
