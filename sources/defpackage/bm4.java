package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bm4 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void a(y50 y50Var) {
        wb0 wb0Var;
        if (y50Var instanceof wb0) {
            wb0Var = (wb0) y50Var;
            int i = wb0Var.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                wb0Var.f = i - Integer.MIN_VALUE;
            } else {
                wb0Var = new wb0(y50Var);
            }
        } else {
            wb0Var = new wb0(y50Var);
        }
        Object obj = wb0Var.e;
        int i2 = wb0Var.f;
        if (i2 == 0) {
            bz3.g(obj);
            wb0Var.f = 1;
            yv yvVar = new yv(1, fp4.b(wb0Var));
            yvVar.x();
            if (yvVar.v() == t70.a) {
                return;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return;
            }
            bz3.g(obj);
        }
        og.k();
    }

    public static final Object b(long j, x50 x50Var) {
        if (j > 0) {
            yv yvVar = new yv(1, fp4.b(x50Var));
            yvVar.x();
            if (j < Long.MAX_VALUE) {
                c(yvVar.f).o(j, yvVar);
            }
            Object objV = yvVar.v();
            if (objV == t70.a) {
                return objV;
            }
        }
        return q43.a;
    }

    public static final vb0 c(j70 j70Var) {
        h70 h70VarV = j70Var.v(qs4.c);
        vb0 vb0Var = h70VarV instanceof vb0 ? (vb0) h70VarV : null;
        return vb0Var == null ? ia0.a : vb0Var;
    }
}
