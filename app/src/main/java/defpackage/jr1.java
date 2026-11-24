package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jr1 extends zr1 {
    public static final jr1 c = new jr1(0, 3, 1);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        q91 q91Var;
        ol2 ol2Var = (ol2) izVar.e(1);
        j6 j6Var = (j6) izVar.e(0);
        bm0 bm0Var = (bm0) izVar.e(2);
        rl2 rl2VarF = ol2Var.f();
        if (as1Var != null) {
            try {
                q91Var = new q91(17, as1Var, rl2Var);
            } catch (Throwable th) {
                rl2VarF.e(false);
                throw th;
            }
        } else {
            q91Var = null;
        }
        if (!bm0Var.b.c()) {
            y20.a("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        bm0Var.a.b(xfVar, rl2VarF, i52Var, q91Var);
        rl2VarF.e(true);
        rl2Var.d();
        j6Var.getClass();
        rl2Var.A(ol2Var, ol2Var.a(j6Var));
        rl2Var.k();
    }
}
