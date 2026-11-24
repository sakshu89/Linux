package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class aq4 {
    public static final int a(int i, t91 t91Var, Object obj) {
        int iC;
        return (obj == null || t91Var.c() == 0 || (i < t91Var.c() && obj.equals(t91Var.d(i))) || (iC = t91Var.d.c(obj)) == -1) ? i : iC;
    }
}
