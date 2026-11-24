package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class u24 {
    public static final p62 a(gz2 gz2Var, int i) {
        fz2 fz2Var = gz2Var.a;
        fl1 fl1Var = gz2Var.b;
        if (fz2Var.a.b.length() != 0) {
            int iD = fl1Var.d(i);
            if ((i != 0 && iD == fl1Var.d(i - 1)) || (i != fz2Var.a.b.length() && iD == fl1Var.d(i + 1))) {
                return gz2Var.a(i);
            }
        }
        return gz2Var.g(i);
    }

    public static ek1 b(ek1 ek1Var, float f) {
        return ek1Var.c(new kp1(f));
    }
}
