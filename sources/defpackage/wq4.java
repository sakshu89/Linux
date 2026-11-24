package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wq4 {
    public static f5 a(a92 a92Var) {
        f5 f5Var;
        y82 y82Var = a92Var instanceof y82 ? (y82) a92Var : null;
        if (y82Var != null && (f5Var = y82Var.a) != null) {
            String str = f5Var.a;
            if (f5Var.c >= 0.9f && wh2.c(q21.a, q21.b).contains(f5Var.d) && (ge1.b.contains(new w3(str)) || wh2.c(new w3("util.calculate"), new w3("contact.find")).contains(new w3(str)))) {
                return f5Var;
            }
        }
        return null;
    }
}
