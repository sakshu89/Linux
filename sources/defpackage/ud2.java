package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ud2 {
    public static final sa2 a = new sa2(22);
    public static final rd2 b = new rd2();
    public static final fd0 c = new fd0(1);
    public static final sd2 d = new sd2();

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(he2 he2Var, long j, y50 y50Var) {
        td2 td2Var;
        q42 q42Var;
        he2 he2Var2;
        if (y50Var instanceof td2) {
            td2Var = (td2) y50Var;
            int i = td2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                td2Var.j = i - Integer.MIN_VALUE;
            } else {
                td2Var = new td2(y50Var);
            }
        } else {
            td2Var = new td2(y50Var);
        }
        Object obj = td2Var.i;
        int i2 = td2Var.j;
        if (i2 == 0) {
            bz3.g(obj);
            q42Var = new q42();
            s0 s0Var = new s0(he2Var, j, q42Var, (x50) null, 2);
            td2Var.e = he2Var;
            td2Var.f = q42Var;
            td2Var.j = 1;
            Object objF = he2Var.f(rm1.a, s0Var, td2Var);
            t70 t70Var = t70.a;
            if (objF == t70Var) {
                return t70Var;
            }
            he2Var2 = he2Var;
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            q42 q42Var2 = td2Var.f;
            he2 he2Var3 = td2Var.e;
            bz3.g(obj);
            q42Var = q42Var2;
            he2Var2 = he2Var3;
        }
        return new jp1(he2Var2.h(q42Var.a));
    }

    public static ek1 b(ey2 ey2Var, js1 js1Var, boolean z, boolean z2) {
        return new qd2(ey2Var, js1Var, z, z2);
    }
}
