package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class j40 {
    public static final ml1 a;

    static {
        y72 y72Var = d00.e;
        int i = y72Var.c;
        g40 g40Var = new g40(y72Var, y72Var, 1);
        int i2 = y72Var.c;
        tp1 tp1Var = d00.x;
        int i3 = (tp1Var.c << 6) | i2;
        i40 i40Var = new i40(y72Var, tp1Var, 0);
        int i4 = (i2 << 6) | tp1Var.c;
        i40 i40Var2 = new i40(tp1Var, y72Var, 0);
        ml1 ml1Var = d21.a;
        ml1 ml1Var2 = new ml1();
        ml1Var2.h(i | (i << 6), g40Var);
        ml1Var2.h(i3, i40Var);
        ml1Var2.h(i4, i40Var2);
        a = ml1Var2;
    }
}
