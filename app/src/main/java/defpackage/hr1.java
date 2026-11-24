package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hr1 extends zr1 {
    public static final hr1 d;
    public static final hr1 e;
    public static final hr1 f;
    public static final hr1 g;
    public final /* synthetic */ int c;

    static {
        int i = 1;
        d = new hr1(i, 2, 0);
        int i2 = 1;
        e = new hr1(i2, i2, 1);
        f = new hr1(i, 2, 2);
        int i3 = 1;
        g = new hr1(i3, i3, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hr1(int i, int i2, int i3) {
        super(i, i2);
        this.c = i3;
    }

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        switch (this.c) {
            case 0:
                Object objA = ((fq0) izVar.e(0)).a();
                j6 j6Var = (j6) izVar.e(1);
                int iD = izVar.d(0);
                j6Var.getClass();
                rl2Var.U(rl2Var.c(j6Var), objA);
                xfVar.d(iD, objA);
                xfVar.b(objA);
                break;
            case 1:
                j6 j6Var2 = (j6) izVar.e(0);
                int iD2 = izVar.d(0);
                xfVar.j();
                j6Var2.getClass();
                xfVar.a(iD2, rl2Var.D(rl2Var.c(j6Var2)));
                break;
            case 2:
                Object objE = izVar.e(0);
                j6 j6Var3 = (j6) izVar.e(1);
                int iD3 = izVar.d(0);
                if (objE instanceof k52) {
                    k52 k52Var = (k52) objE;
                    ((pm1) i52Var.d).b(k52Var);
                    ((hm1) i52Var.g).a(k52Var);
                }
                Object objK = rl2Var.K(rl2Var.c(j6Var3), iD3, objE);
                if (objK instanceof k52) {
                    i52Var.e((k52) objK);
                } else if (objK instanceof a42) {
                    ((a42) objK).c();
                }
                break;
            default:
                Object objE2 = izVar.e(0);
                int iD4 = izVar.d(0);
                if (objE2 instanceof k52) {
                    k52 k52Var2 = (k52) objE2;
                    ((pm1) i52Var.d).b(k52Var2);
                    ((hm1) i52Var.g).a(k52Var2);
                }
                Object objK2 = rl2Var.K(rl2Var.t, iD4, objE2);
                if (objK2 instanceof k52) {
                    i52Var.e((k52) objK2);
                } else if (objK2 instanceof a42) {
                    ((a42) objK2).c();
                }
                break;
        }
    }

    @Override // defpackage.zr1
    public j6 b(iz izVar) {
        switch (this.c) {
            case 0:
                return (j6) izVar.e(1);
            case 1:
                return (j6) izVar.e(0);
            default:
                return super.b(izVar);
        }
    }
}
