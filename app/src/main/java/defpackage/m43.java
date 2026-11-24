package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m43 {
    public cu2 a;
    public cu2 b;
    public int c;
    public Long d;
    public boolean e;

    /* JADX WARN: Code duplicated, block: B:30:0x0068  */
    public final void a(ty2 ty2Var) {
        cu2 cu2Var;
        be beVar = ty2Var.a;
        this.e = false;
        cu2 cu2Var2 = this.a;
        if (ty2Var.equals(cu2Var2 != null ? (ty2) cu2Var2.c : null)) {
            return;
        }
        String str = beVar.b;
        cu2 cu2Var3 = this.a;
        boolean zA = g31.a(str, cu2Var3 != null ? ((ty2) cu2Var3.c).a.b : null);
        cu2 cu2Var4 = this.a;
        if (zA) {
            if (cu2Var4 != null) {
                cu2Var4.c = ty2Var;
                return;
            }
            return;
        }
        this.a = new cu2(5, cu2Var4, ty2Var);
        this.b = null;
        int length = beVar.b.length() + this.c;
        this.c = length;
        if (length > 100000) {
            cu2 cu2Var5 = this.a;
            if ((cu2Var5 != null ? (cu2) cu2Var5.b : null) == null) {
                return;
            }
            while (true) {
                if (cu2Var5 == null) {
                    cu2Var = null;
                } else {
                    cu2 cu2Var6 = (cu2) cu2Var5.b;
                    if (cu2Var6 != null) {
                        cu2Var = (cu2) cu2Var6.b;
                    } else {
                        cu2Var = null;
                    }
                }
                if (cu2Var == null) {
                    break;
                } else {
                    cu2Var5 = (cu2) cu2Var5.b;
                }
            }
            if (cu2Var5 != null) {
                cu2Var5.b = null;
            }
        }
    }
}
