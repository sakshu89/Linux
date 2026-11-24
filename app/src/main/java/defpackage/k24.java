package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class k24 {
    public static f5 a(b63 b63Var) {
        f5 f5VarD;
        x42 x42Var = yz0.a;
        String str = b63Var.a;
        String strA = yz0.a(str, false);
        fh1 fh1VarD = yz0.n.d(strA);
        if (fh1VarD == null && (fh1VarD = yz0.o.d(strA)) == null) {
            f5VarD = null;
        } else {
            ch1 ch1VarB = fh1VarD.c.b(1);
            ch1VarB.getClass();
            f5VarD = dp4.d(b63Var, "screen.type", bh1.c(new wt1("text", cs2.V((String) ((dh1) fh1VarD.a()).get(1)).toString()), new wt1("target", yz0.b.a(cs2.H(strA, ch1VarB.b).toString()) ? "search bar in whatsapp" : "search bar")), 0.0f, 12);
        }
        if (f5VarD != null) {
            return f5VarD;
        }
        fh1 fh1VarD2 = je2.a.d(cs2.V(str).toString());
        if (fh1VarD2 != null) {
            String strY = cs2.Y(cs2.V((String) ((dh1) fh1VarD2.a()).get(2)).toString(), '.', '!', '?');
            if (ie2.f(strY)) {
                return dp4.d(b63Var, "screen.type", bh1.c(new wt1("text", ((dh1) fh1VarD2.a()).get(1)), new wt1("target", strY)), 0.0f, 12);
            }
        }
        return null;
    }
}
