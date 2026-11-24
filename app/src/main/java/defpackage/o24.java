package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class o24 {
    public static final yy a = new yy(null, null, null);
    public static yy b;

    public static final jf2 a(s9 s9Var, dm dmVar) {
        e80 e80VarG = s9Var.g();
        iz izVar = (iz) s9Var.e;
        boolean z = e80VarG == e80.a;
        return new jf2(c(izVar, z, true, dmVar), c(izVar, z, false, dmVar), z);
    }

    public static final if2 b(final s9 s9Var, final iz izVar, if2 if2Var) {
        e80 e80Var;
        int i = izVar.c;
        int i2 = izVar.b;
        boolean z = s9Var.b;
        final int i3 = z ? i2 : i;
        gz2 gz2Var = (gz2) izVar.e;
        int i4 = izVar.d;
        final f81 f81VarA = yp4.a(new fq0() { // from class: mf2
            @Override // defpackage.fq0
            public final Object a() {
                return Integer.valueOf(((gz2) izVar.e).b.d(i3));
            }
        });
        final int i5 = z ? i : i2;
        f81 f81VarA2 = yp4.a(new fq0() { // from class: nf2
            @Override // defpackage.fq0
            public final Object a() {
                iz izVar2 = izVar;
                gz2 gz2Var2 = (gz2) izVar2.e;
                int iIntValue = ((Number) f81VarA.getValue()).intValue();
                s9 s9Var2 = s9Var;
                boolean z2 = s9Var2.b;
                boolean z3 = s9Var2.g() == e80.a;
                int i6 = i3;
                long jI = gz2Var2.i(i6);
                fl1 fl1Var = gz2Var2.b;
                int i7 = oz2.c;
                int iF = (int) (jI >> 32);
                int iD = fl1Var.d(iF);
                int i8 = fl1Var.f;
                if (iD != iIntValue) {
                    iF = iIntValue >= i8 ? gz2Var2.f(i8 - 1) : gz2Var2.f(iIntValue);
                }
                int iC = (int) (jI & 4294967295L);
                if (fl1Var.d(iC) != iIntValue) {
                    iC = iIntValue >= i8 ? fl1Var.c(i8 - 1, false) : fl1Var.c(iIntValue, false);
                }
                int i9 = i5;
                if (iF == i9) {
                    return izVar2.a(iC);
                }
                if (iC == i9) {
                    return izVar2.a(iF);
                }
                if (!(z2 ^ z3) ? i6 >= iF : i6 > iC) {
                    iF = iC;
                }
                return izVar2.a(iF);
            }
        });
        if (1 != if2Var.c) {
            return (if2) ((x43) f81VarA2).getValue();
        }
        if (i3 == i4) {
            return if2Var;
        }
        if (((Number) ((x43) f81VarA).getValue()).intValue() != gz2Var.b.d(i4)) {
            return (if2) ((x43) f81VarA2).getValue();
        }
        int i6 = if2Var.b;
        long jI = gz2Var.i(i6);
        if (i4 != -1) {
            if (i3 != i4) {
                e80 e80Var2 = e80.a;
                if (i2 < i) {
                    e80Var = e80.b;
                } else {
                    e80Var = i2 > i ? e80Var2 : e80.c;
                }
                if (!((e80Var == e80Var2) ^ z)) {
                }
            }
            return izVar.a(i3);
        }
        int i7 = oz2.c;
        return (i6 == ((int) (jI >> 32)) || i6 == ((int) (4294967295L & jI))) ? (if2) ((x43) f81VarA2).getValue() : izVar.a(i3);
    }

    public static final if2 c(iz izVar, boolean z, boolean z2, dm dmVar) {
        long j;
        long jK = dmVar.k(izVar, z2 ? izVar.b : izVar.c);
        if (z ^ z2) {
            int i = oz2.c;
            j = jK >> 32;
        } else {
            int i2 = oz2.c;
            j = 4294967295L & jK;
        }
        return izVar.a((int) j);
    }

    public static final if2 d(if2 if2Var, iz izVar, int i) {
        return new if2(((gz2) izVar.e).a(i), i, if2Var.c);
    }
}
