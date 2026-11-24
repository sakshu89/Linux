package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sc1 {
    public static w21 a(long j, Object obj) {
        w21 w21Var = (w21) c53.c.h(j, obj);
        if (((x12) w21Var).a) {
            return w21Var;
        }
        x12 x12Var = (x12) w21Var;
        int i = x12Var.c;
        x12 x12VarD = x12Var.d(i == 0 ? 10 : i * 2);
        c53.o(obj, j, x12VarD);
        return x12VarD;
    }
}
