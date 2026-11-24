package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bc4 {
    public static final be d(ty2 ty2Var) {
        be beVar = ty2Var.a;
        long j = ty2Var.b;
        beVar.getClass();
        return beVar.subSequence(oz2.f(j), oz2.e(j));
    }

    public static final be e(ty2 ty2Var, int i) {
        be beVar = ty2Var.a;
        be beVar2 = ty2Var.a;
        long j = ty2Var.b;
        int iE = oz2.e(j);
        int iE2 = oz2.e(j);
        int length = iE2 + i;
        if (((i ^ length) & (iE2 ^ length)) < 0) {
            length = beVar2.b.length();
        }
        return beVar.subSequence(iE, Math.min(length, beVar2.b.length()));
    }

    public static final be f(ty2 ty2Var, int i) {
        be beVar = ty2Var.a;
        long j = ty2Var.b;
        int iF = oz2.f(j);
        int i2 = iF - i;
        if (((iF ^ i2) & (i ^ iF)) < 0) {
            i2 = 0;
        }
        return beVar.subSequence(Math.max(0, i2), oz2.f(j));
    }

    public abstract boolean a(w1 w1Var, s1 s1Var, s1 s1Var2);

    public abstract boolean b(w1 w1Var, Object obj, Object obj2);

    public abstract boolean c(w1 w1Var, v1 v1Var, v1 v1Var2);

    public abstract void g(v1 v1Var, v1 v1Var2);

    public abstract void h(v1 v1Var, Thread thread);
}
