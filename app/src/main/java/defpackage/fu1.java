package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fu1 {
    public static final long a;
    public static final /* synthetic */ int b = 0;

    static {
        c03[] c03VarArr = b03.b;
        a = b03.c;
    }

    public static final eu1 a(eu1 eu1Var, int i, int i2, long j, wy2 wy2Var, nx1 nx1Var, bc1 bc1Var, int i3, int i4, lz2 lz2Var) {
        long j2;
        int i5 = i;
        int i6 = i2;
        long j3 = j;
        wy2 wy2Var2 = wy2Var;
        nx1 nx1Var2 = nx1Var;
        bc1 bc1Var2 = bc1Var;
        int i7 = i3;
        int i8 = i4;
        lz2 lz2Var2 = lz2Var;
        if (i5 == 0 || i5 == eu1Var.a) {
            c03[] c03VarArr = b03.b;
            if ((j3 & 1095216660480L) == 0) {
                j2 = 0;
            } else {
                j2 = 0;
                if (b03.a(j3, eu1Var.c)) {
                }
            }
            if ((wy2Var2 == null || wy2Var2.equals(eu1Var.d)) && ((i6 == 0 || i6 == eu1Var.b) && ((nx1Var2 == null || nx1Var2.equals(eu1Var.e)) && ((bc1Var2 == null || bc1Var2.equals(eu1Var.f)) && ((i7 == 0 || i7 == eu1Var.g) && ((i8 == 0 || i8 == eu1Var.h) && (lz2Var2 == null || lz2Var2.equals(eu1Var.i)))))))) {
                return eu1Var;
            }
        } else {
            j2 = 0;
        }
        c03[] c03VarArr2 = b03.b;
        if ((j3 & 1095216660480L) == j2) {
            j3 = eu1Var.c;
        }
        if (wy2Var2 == null) {
            wy2Var2 = eu1Var.d;
        }
        if (i5 == 0) {
            i5 = eu1Var.a;
        }
        if (i6 == 0) {
            i6 = eu1Var.b;
        }
        nx1 nx1Var3 = eu1Var.e;
        if (nx1Var3 != null && nx1Var2 == null) {
            nx1Var2 = nx1Var3;
        }
        if (bc1Var2 == null) {
            bc1Var2 = eu1Var.f;
        }
        if (i7 == 0) {
            i7 = eu1Var.g;
        }
        if (i8 == 0) {
            i8 = eu1Var.h;
        }
        if (lz2Var2 == null) {
            lz2Var2 = eu1Var.i;
        }
        return new eu1(i5, i6, j3, wy2Var2, nx1Var2, bc1Var2, i7, i8, lz2Var2);
    }
}
